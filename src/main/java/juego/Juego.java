package juego;

import java.awt.Font;
import java.awt.Graphics;
import java.awt.image.BufferStrategy;
import java.util.HashMap;
import java.util.Map;

import javax.swing.JOptionPane;

import chat.MiChat;
import cliente.Cliente;
import cliente.EscuchaMensajes;
import dominio.Personaje;
import estados.Estado;
import estados.EstadoBatalla;
import estados.EstadoJuego;
import mensajeria.PaqueteDeNPC;
import mensajeria.PaqueteMovimiento;
import mensajeria.PaquetePersonaje;

/**
 * The Class Juego.
 */
public class Juego implements Runnable {

    private static final int CANT_FPS = 60;
	private static final int TAM_FONT_OBJ = 15;
	private static final int CONST_3 = 3;
	private static final int CONST_DIRECCION = 6;
	private static final int MICRO_SEGUNDO = 1000000000;
    private Pantalla pantalla;
    private final String nombre;
    private final int ancho;
    private final int alto;

    private Thread hilo;
    private boolean corriendo;

    // Estrategia para graficar mediante buffers (Primero se "grafica" en el/los buffer/s y finalmente en el canvas)
    private BufferStrategy bs;
    private Graphics g;

    // Estados
    private Estado estadoJuego;
    private Estado estadoBatalla;
    private Estado estadoBatallaNPC;

    // HandlerMouse
    private HandlerMouse handlerMouse;

    // Camara
    private Camara camara;

    // Conexion
    private Cliente cliente;
    private EscuchaMensajes escuchaMensajes;
    private PaquetePersonaje paquetePersonaje;
    private PaqueteMovimiento ubicacionPersonaje;
    private Map<Integer, PaquetePersonaje> personajesConectados;
    private Map<Integer, PaqueteMovimiento> ubicacionPersonajes;
    private Map<Integer, PaqueteDeNPC> npcs;
    private Map<Integer, PaqueteMovimiento> ubicacionNPCS;
    private Map<String, MiChat> chatsActivos = new HashMap<>();
    
    //cheats
    private boolean cheatAtravezarParedes = false;

    private CargarRecursos cargarRecursos;

    /**
     * Instantiates a new juego.
     *
     * @param nombre
     *            the nombre
     * @param ancho
     *            the ancho
     * @param alto
     *            the alto
     * @param cliente
     *            the cliente
     * @param pp
     *            the pp
     */
    public Juego(final String nombre, final int ancho, final int alto, final Cliente cliente,
        final PaquetePersonaje pp) {
        this.nombre = nombre;
        this.alto = alto;
        this.ancho = ancho;
        this.cliente = cliente;
        this.paquetePersonaje = pp;

        // Inicializo la ubicacion del personaje
        ubicacionPersonaje = new PaqueteMovimiento();
        ubicacionPersonaje.setIdPersonaje(paquetePersonaje.getId());
        ubicacionPersonaje.setFrame(0);
        ubicacionPersonaje.setDireccion(CONST_DIRECCION);

        // Creo el escucha de mensajes
        escuchaMensajes = new EscuchaMensajes(this);
        escuchaMensajes.start();

        handlerMouse = new HandlerMouse();

        iniciar();

        cargarRecursos = new CargarRecursos(cliente);
        cargarRecursos.start();
    }

    /**
     * Iniciar Juego.
     */
    public void iniciar() { // Carga lo necesario para iniciar el juego
        pantalla = new Pantalla(nombre, ancho, alto, cliente);

        pantalla.getCanvas().addMouseListener(handlerMouse);

        camara = new Camara(this, 0, 0);

        Personaje.cargarTablaNivel();
    }

    /**
     * Actualizar el juego.
     */
    private void actualizar() { // Actualiza los objetos y sus posiciones

        if (Estado.getEstado() != null) {
            Estado.getEstado().actualizar();
        }
    }

    /**
     * Graficar los objetos del juego.
     */
    private void graficar() { // Grafica los objetos y sus posiciones
        bs = pantalla.getCanvas().getBufferStrategy();
        if (bs == null) { // Seteo una estrategia para el canvas en caso de que no tenga una
            pantalla.getCanvas().createBufferStrategy(CONST_3);
            return;
        }

        g = bs.getDrawGraphics(); // Permite graficar el buffer mediante g

        g.clearRect(0, 0, ancho, alto); // Limpiamos la pantalla

        // Graficado de imagenes
        g.setFont(new Font("Book Antiqua", 1, TAM_FONT_OBJ));

        if (Estado.getEstado() != null) {
            Estado.getEstado().graficar(g);
        }

        // Fin de graficado de imagenes

        bs.show(); // Hace visible el próximo buffer disponible
        g.dispose();
    }

    @Override
    public void run() { // Hilo principal del juego

        int fps = CANT_FPS; // Cantidad de actualizaciones por segundo que se desean
        double tiempoPorActualizacion = MICRO_SEGUNDO / fps; // Cantidad de nanosegundos en FPS deseados
        double delta = 0;
        long ahora;
        long ultimoTiempo = System.nanoTime();
        long timer = 0; // Timer para mostrar fps cada un segundo
        int actualizaciones = 0; // Cantidad de actualizaciones que se realizan realmente

        while (corriendo) {
            ahora = System.nanoTime();
            // Calculo  para determinar cuando realizar la actualizacion y el graficado
            delta += (ahora - ultimoTiempo) / tiempoPorActualizacion;
            // Sumo el tiempo transcurrido hasta que se acumule 1 segundo y mostrar los FPS
            timer += ahora - ultimoTiempo;
            ultimoTiempo = ahora; // Para las proximas corridas del bucle

            if (delta >= 1) {
                actualizar();
                graficar();
                actualizaciones++;
                delta--;
            }

            // Si paso 1 segundo muestro los FPS
            if (timer >= MICRO_SEGUNDO) {
                pantalla.getFrame().setTitle(nombre + " | " + "FPS: " + actualizaciones);
                actualizaciones = 0;
                timer = 0;
            }
        }

        stop();
    }

    /**
     * Inicia el juego
     */
    public synchronized void start() { // Inicia el juego
        if (corriendo) {
            return;
        }

        estadoJuego = new EstadoJuego(this);
        Estado.setEstado(estadoJuego);
        pantalla.mostrar();
        corriendo = true;
        hilo = new Thread(this);
        hilo.start();
    }

    /**
     * Detiene el juego
     */
    public synchronized void stop() { // Detiene el juego
        if (!corriendo) {
            return;
        }
        try {
            corriendo = false;
            hilo.join();
        } catch (InterruptedException e) {
            JOptionPane.showMessageDialog(null, "Fallo al intentar detener el juego.");
        }
    }

    /**
     * Gets the ancho.
     *
     * @return the ancho
     */
    public int getAncho() {
        return ancho;
    }

    /**
     * Gets the alto.
     *
     * @return the alto
     */
    public int getAlto() {
        return alto;
    }

    /**
     * Gets the handler mouse.
     *
     * @return the handler mouse
     */
    public HandlerMouse getHandlerMouse() {
        return handlerMouse;
    }

    /**
     * Gets the camara.
     *
     * @return the camara
     */
    public Camara getCamara() {
        return camara;
    }

    /**
     * Gets the estado juego.
     *
     * @return the estado juego
     */
    public EstadoJuego getEstadoJuego() {
        return (EstadoJuego) estadoJuego;
    }

    /**
     * Gets the estado batalla.
     *
     * @return the estado batalla
     */
    public EstadoBatalla getEstadoBatalla() {
        return (EstadoBatalla) estadoBatalla;
    }

    /**
     * Sets the estado batalla.
     *
     * @param estadoBatalla
     *            the new estado batalla
     */
    public void setEstadoBatalla(final EstadoBatalla estadoBatalla) {
        this.estadoBatalla = estadoBatalla;
    }

    /**
     * Gets the estado batalla NPC.
     *
     * @return the estado batalla NPC
     */
    public Estado getEstadoBatallaNPC() {
        return estadoBatallaNPC;
    }

    /**
     * Sets the estado batalla NPC.
     *
     * @param estadoBatallaNPC
     *            the new estado batalla NPC
     */
    public void setEstadoBatallaNPC(final Estado estadoBatallaNPC) {
        this.estadoBatallaNPC = estadoBatallaNPC;
    }

    /**
     * Gets the cliente.
     *
     * @return the cliente
     */
    public Cliente getCliente() {
        return cliente;
    }

    /**
     * Gets the escucha mensajes.
     *
     * @return the escucha mensajes
     */
    public EscuchaMensajes getEscuchaMensajes() {
        return escuchaMensajes;
    }

    /**
     * Gets the personaje.
     *
     * @return the personaje
     */
    public PaquetePersonaje getPersonaje() {
        return paquetePersonaje;
    }

    /**
     * Gets the ubicacion personaje.
     *
     * @return the ubicacion personaje
     */
    public PaqueteMovimiento getUbicacionPersonaje() {
        return ubicacionPersonaje;
    }

    /**
     * Sets the personaje.
     *
     * @param paquetePersonaje
     *            the new personaje
     */
    public void setPersonaje(final PaquetePersonaje paquetePersonaje) {
        this.paquetePersonaje = paquetePersonaje;
    }

    /**
     * Actualizar personaje.
     */
    public void actualizarPersonaje() {
        paquetePersonaje = (PaquetePersonaje) (personajesConectados.get(paquetePersonaje.getId()).clone());
    }

    /**
     * Gets the personajes conectados.
     *
     * @return the personajes conectados
     */
    public Map<Integer, PaquetePersonaje> getPersonajesConectados() {
        return personajesConectados;
    }

    /**
     * Sets the personajes conectados.
     *
     * @param map
     *            the map
     */
    public void setPersonajesConectados(final Map<Integer, PaquetePersonaje> map) {
        this.personajesConectados = map;
    }

    /**
     * Gets the ubicacion personajes.
     *
     * @return the ubicacion personajes
     */
    public Map<Integer, PaqueteMovimiento> getUbicacionPersonajes() {
        return ubicacionPersonajes;
    }

    /**
     * Sets the ubicacion personajes.
     *
     * @param ubicacionPersonajes
     *            the ubicacion personajes
     */
    public void setUbicacionPersonajes(final Map<Integer, PaqueteMovimiento> ubicacionPersonajes) {
        this.ubicacionPersonajes = ubicacionPersonajes;
    }

    /**
     * Gets the chats activos.
     *
     * @return the chats activos
     */
    public Map<String, MiChat> getChatsActivos() {
        return chatsActivos;
    }

    /**
     * Gets the NPcs.
     *
     * @return the NPcs
     */
    public Map<Integer, PaqueteDeNPC> getNPCs() {
        return npcs;
    }

    /**
     * Sets the NPcs.
     *
     * @param map
     *            the map
     */
    public void setNPCs(final Map<Integer, PaqueteDeNPC> map) {
        npcs = map;
    }

    /**
     * Gets the ubicacion NPcs.
     *
     * @return the ubicacion NPcs
     */
    public Map<Integer, PaqueteMovimiento> getUbicacionNPCs() {
        return ubicacionNPCS;
    }

    /**
     * Sets the ubicacion NPcs.
     *
     * @param ubicacionNPCs
     *            the ubicacion NPcs
     */
    public void setUbicacionNPCs(final Map<Integer, PaqueteMovimiento> ubicacionNPCs) {
        this.ubicacionNPCS = ubicacionNPCs;
    }

	public boolean isCheatAtravezarParedes() {
		return cheatAtravezarParedes;
	}

	public void setCheatAtravezarParedes(boolean cheatAtravezarParedes) {
		this.cheatAtravezarParedes = cheatAtravezarParedes;
	}
    
    
}
