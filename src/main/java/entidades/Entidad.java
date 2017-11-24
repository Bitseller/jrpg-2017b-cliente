package entidades;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;

import javax.swing.JOptionPane;

import org.omg.CORBA.CODESET_INCOMPATIBLE;

import com.google.gson.Gson;

import chat.VentanaContactos;
import cliente.Cliente;
import estados.Estado;
import estados.EstadoBatallaNPC;
import frames.MenuEscape;
import frames.MenuInventario;
import interfaz.MenuInfoPersonaje;
import juego.Juego;
import juego.Pantalla;
import mensajeria.PaqueteBatalla;
import mensajeria.PaqueteComerciar;
import mensajeria.PaqueteDeNPC;
import mensajeria.PaqueteMovimiento;
import mensajeria.PaquetePersonaje;
import mundo.Grafo;
import mundo.Mundo;
import mundo.Nodo;
import recursos.Recursos;

/**
 * Clase Entidad.
 */
public class Entidad {

    private static final int FONT_SIZE = 15;
	private static final double ONE_AND_A_HALF = 1.5;
	private static final int SIXTH_TILE = 6;
	private static final int BIG_TEN = 10;
	private static final int BIG_TWENTY = 20;
	private static final int BIG_FOUR = 4;
	private static final int RANGO_MAX = -50;
	private static final int RANGO_MIN = 50;
	private static final int BIG_TREINTAYDOS = 32;
	private static final int COMERCIO_DOWN = 0;
	private static final int COMERCIO_UP = 29;
	private static final int COMERCIO_DER = 71;
	private static final int COMERCIO_IZQ = 44;
	private static final int V_CONT_UP = 559;
	private static final int V_CONT_DOWN = 524;
	private static final int V_CONT_DER = 105;
	private static final int V_CONT_IZQ = 3;
	private static final int ESCAPE_UP = 597;
	private static final int ESCAPE_DOWN = 562;
	private static final int ESCAPE_DER = 105;
	private static final int ESCAPE_IZQ = 3;
	private static final int INV_UP = 597;
	private static final int INV_DOWN = 545;
	private static final int INV_DER = 797;
	private static final int INV_IZQ = 738;
	private static final int SEVENTH_TILE = 7;
	private static final int FIFTH_TILE = 5;
	private static final int FOURTH_TILE = 4;
	private static final int THIRD_TILE = 3;

	//General
	private Juego juego;
	private Cliente client;
	
    // Tamaño de la entidad
    private int ancho;
    private int alto;

    // Posiciones
    private float x;
    private float y;
    private float dx;
    private float dy;
    private LinkedList<Double> movX;
    private LinkedList<Double> movY;
    private float xFinal;
    private float yFinal;
    private int xOffset;
    private int yOffset;
    private int drawX;
    private int drawY;
    private int[] posMouseRecorrido;
    private int[] posMouse;

    // Movimiento Actual
    private final LinkedList<Integer> movimientos;
    private static final int MOVIMIENTOS = 6;
    private static final int HORIZONTAL_IZQ = 0;
    private static final int HORIZONTAL_DER = 4;
    private static final int VERTICAL_SUP = 2;
    private static final int DIAGONAL_SUP_IZQ = 1;
    private static final int DIAGONAL_SUP_DER = 3;
    private static final int VERTICAL_INF = 6;
    private static final int DIAGONAL_INF_IZQ = 7;
    private static final int DIAGONAL_INF_DER = 5;
    private int movimientoHacia = MOVIMIENTOS;
    private boolean enMovimiento;
    
    // Referencias del mapa
    private static final int REFERENCIA_X = 64;
    private static final int REFERENCIA_Y = 32;

    // Animaciones
    private LinkedList<Animacion> patronAnimaciones;
    private Animacion moverIzq;
    private Animacion moverDer;
    private Animacion moverArriba;
    private Animacion moverArribaIzq;
    private Animacion moverAbajoDer;
    private Animacion moverAbajo;
    private Animacion moverAbajoIzq;
    private Animacion moverArribaDer;
    private int velAnimacion;
    private final Gson gson = new Gson();
    private int intervaloEnvio = 0;

    // pila de movimiento
    private PilaDeTiles pilaMovimiento;
    private int[] tileActual;
    private int[] tileFinal;
    private int[] tileMoverme;

    private Mundo mundo;
    private String nombre;
    private int[] tilePersonajes;
    private int idEnemigo;

    // Ubicacion para abrir comerciar.
    private float xComercio;
    private float yComercio;
    private float[] comercio;
    private static final int TOLERANCIA_DISTANCIA_NPC = 30;
    


    /**
     * Constructor de la clase Entidad.
     *
     * @param juego
     *            juego con el que se instancia Entidad
     * @param client
     * 			  cliente con el que se instancia Entidad
     * @param mundo
     *            mundo con el que se instancia Entidad
     * @param ancho
     *            ancho
     * @param alto
     *            alto
     * @param nombre
     *            nombre del personaje
     * @param spawnX
     *            tile X donde spawnea
     * @param spawnY
     *            tile Y donde spawnea
     * @param animaciones
     *            animaciones del personaje
     * @param velAnimacion
     *            velocidad de animacion del personaje
     */
    //public Entidad(final Juego juego, final Mundo mundo, final int ancho, final int alto, final String nombre,
    public Entidad(final Cliente client2, final Mundo mundo, final int ancho, final int alto, final String nombre,
        final float spawnX, final float spawnY, final LinkedList<BufferedImage[]> animaciones,
        final int velAnimacion) {
    	this.client = client2;
        this.juego = client.getJuego();
        this.ancho = ancho;
        this.alto = alto;
        this.nombre = nombre;
        this.mundo = mundo;
        this.velAnimacion = velAnimacion;
        xOffset = ancho / 2;
        yOffset = alto / 2;
        x = (int) (spawnX / REFERENCIA_X) * REFERENCIA_X;
        y = (int) (spawnY / REFERENCIA_Y) * REFERENCIA_Y;

        double paso = 1;
        

        movX = new LinkedList<Double>();
        movY = new LinkedList<Double>();

        // Cargo una lista con los movimientos de dx.
        movX.add(paso * -1);
        movX.add(paso);
        movX.add(paso * 0);
        movX.add(paso * -1);
        movX.add(paso);
        movX.add(paso * 0);
        movX.add(paso * -1);
        movX.add(paso);

        // Cargo una lista con los movimientos de dy.
        movY.add(paso * 0);
        movY.add(paso * 0);
        movY.add(paso * -1);
        movY.add((paso / 2) * -1);
        movY.add((paso / 2) * -1);
        movY.add(paso);
        movY.add(paso / 2);
        movY.add(paso / 2);

        movimientos = new LinkedList<Integer>();
        patronAnimaciones = new LinkedList<Animacion>();

        moverIzq = new Animacion(velAnimacion, animaciones.get(0));
        moverArribaIzq = new Animacion(velAnimacion, animaciones.get(1));
        moverArriba = new Animacion(velAnimacion, animaciones.get(2));
        moverArribaDer = new Animacion(velAnimacion, animaciones.get(THIRD_TILE));
        moverDer = new Animacion(velAnimacion, animaciones.get(FOURTH_TILE));
        moverAbajoDer = new Animacion(velAnimacion, animaciones.get(FIFTH_TILE));
        moverAbajo = new Animacion(velAnimacion, animaciones.get(SIXTH_TILE));
        moverAbajoIzq = new Animacion(velAnimacion, animaciones.get(SEVENTH_TILE));

        // Cargo una lista con las animaciones.
        getPatronAnimaciones().add(moverIzq);
        getPatronAnimaciones().add(moverDer);
        getPatronAnimaciones().add(moverArriba);
        getPatronAnimaciones().add(moverArribaIzq);
        getPatronAnimaciones().add(moverArribaDer);
        getPatronAnimaciones().add(moverAbajo);
        getPatronAnimaciones().add(moverAbajoIzq);
        getPatronAnimaciones().add(moverAbajoDer);

        // Cargo una lista con los movimientos patrones.
        movimientos.add(HORIZONTAL_IZQ);
        movimientos.add(HORIZONTAL_DER);
        movimientos.add(VERTICAL_SUP);
        movimientos.add(DIAGONAL_SUP_IZQ);
        movimientos.add(DIAGONAL_SUP_DER);
        movimientos.add(VERTICAL_INF);
        movimientos.add(DIAGONAL_INF_IZQ);
        movimientos.add(DIAGONAL_INF_DER);

        // Informo mi posicion actual
        juego.getUbicacionPersonaje().setPosX(x);
        juego.getUbicacionPersonaje().setPosY(y);
        juego.getUbicacionPersonaje().setDireccion(getDireccion());
        juego.getUbicacionPersonaje().setFrame(getFrame());
    }

    /**
     * Actualiza el personaje.
     */
    public void actualizar() {

        if (enMovimiento) {
            for (Animacion patron : getPatronAnimaciones()) {
                patron.actualizar();
            }
        } else {
            for (Animacion patron : getPatronAnimaciones()) {
                patron.reset();
            }
        }

        getEntrada();
        mover();

        juego.getCamara().centrar(this);
    }

    /**
     * Devuelve la entrada.
     */
    public void getEntrada() {
        posMouseRecorrido = juego.getHandlerMouse().getPosMouseRecorrido();
        posMouse = juego.getHandlerMouse().getPosMouse();
        if (juego.getHandlerMouse().getNuevoClick() && posMouse[0] >= INV_IZQ
        		&& posMouse[0] <= INV_DER && posMouse[1] >= INV_DOWN
            && posMouse[1] <= INV_UP) {
            if (Pantalla.getMenuInventario() == null) {
                Pantalla.setMenuInventario(new MenuInventario(juego.getCliente()));
                Pantalla.getMenuInventario().setVisible(true);
            }
            juego.getHandlerMouse().setNuevoClick(false);
        }
        if (juego.getHandlerMouse().getNuevoClick() && posMouse[0] >= ESCAPE_IZQ
        		&& posMouse[0] <= ESCAPE_DER && posMouse[1] >= ESCAPE_DOWN
            && posMouse[1] <= ESCAPE_UP) {
            if (Pantalla.getMenuEscp() == null) {
                Pantalla.setMenuEscp(new MenuEscape(juego.getCliente()));
                Pantalla.getMenuEscp().setVisible(true);
            }
            juego.getHandlerMouse().setNuevoClick(false);
        }
        if (juego.getHandlerMouse().getNuevoClick() && posMouse[0] >= V_CONT_IZQ
        		&& posMouse[0] <= V_CONT_DER && posMouse[1] >= V_CONT_DOWN
            && posMouse[1] <= V_CONT_UP) {
            if (Pantalla.getVentContac() == null) {
                Pantalla.setVentContac(new VentanaContactos(client));
                Pantalla.getVentContac().setVisible(true);
            }
            juego.getHandlerMouse().setNuevoClick(false);
        }
        // Tomo el click izquierdo
        if (juego.getHandlerMouse().getNuevoClick()) {
            if (juego.getEstadoJuego().getHaySolicitud()) {

                if (juego.getEstadoJuego().getMenuEnemigo().clickEnMenu(posMouse[0], posMouse[1])) {
                    if (juego.getEstadoJuego().getMenuEnemigo().clickEnBoton(posMouse[0], posMouse[1])) {
                        // Pregunto si menuBatallar o menuComerciar, sino no me
                        // interesa hacer esto
                        if (juego.getEstadoJuego().getTipoSolicitud() == MenuInfoPersonaje.MENU_BATALLAR
                            || juego.getEstadoJuego().getTipoSolicitud() == MenuInfoPersonaje.MENU_COMERCIAR) {
                            // Guardo las poss con el que quiero comerciar
                            xComercio = juego.getUbicacionPersonajes().get(idEnemigo).getPosX();
                            yComercio = juego.getUbicacionPersonajes().get(idEnemigo).getPosY();
                            comercio = Mundo.isoA2D(xComercio, yComercio);
                        }
                        // pregunto si el menu emergente es de tipo batalla
                        if (juego.getEstadoJuego().getTipoSolicitud() == MenuInfoPersonaje.MENU_BATALLAR) {
                            // Me fijo si con el que quiero batallar se
                            // encuentre en la zona de comercio.
                            if (!((int) comercio[0] >= COMERCIO_IZQ && (int) comercio[0] <= COMERCIO_DER
                            		&& (int) comercio[1] >= COMERCIO_DOWN && (int) comercio[1] <= COMERCIO_UP)) {
                                juego.getEstadoJuego().setHaySolicitud(false, null, MenuInfoPersonaje.MENU_BATALLAR);
                                PaqueteBatalla pBatalla = new PaqueteBatalla();

                                pBatalla.setId(juego.getPersonaje().getId());
                                pBatalla.setIdEnemigo(idEnemigo);

                                juego.getEstadoJuego().setHaySolicitud(false, null, MenuInfoPersonaje.MENU_BATALLAR);

                                try {
                                    juego.getCliente().getSalida().writeObject(gson.toJson(pBatalla));
                                } catch (IOException e) {
                                    JOptionPane.showMessageDialog(null, "Fallo la conexión " + "con el servidor");
                                }
                            } else {
                                JOptionPane.showMessageDialog(null,
                                    "El otro usuario se encuentra " + "dentro de la zona de comercio");
                            }
                        } else {
                            // Pregunto si el menu emergente es de tipo
                            // Comercio.
                            if (juego.getEstadoJuego().getTipoSolicitud() == MenuInfoPersonaje.MENU_COMERCIAR) {
                                if ((int) comercio[0] >= COMERCIO_IZQ && (int) comercio[0] <= COMERCIO_DER
                                		&& (int) comercio[1] >= COMERCIO_DOWN
                                			&& (int) comercio[1] <= COMERCIO_UP) {
                                    if (juego.getCliente().getM1() == null) {
                                        juego.getCliente().setPaqueteComercio(new PaqueteComerciar());
                                        juego.getCliente().getPaqueteComercio().setId(juego.getPersonaje().getId());
                                        juego.getCliente().getPaqueteComercio().setIdEnemigo(idEnemigo);

                                        try {
                                            juego.getCliente().getSalida()
                                                .writeObject(gson.toJson(juego.getCliente().getPaqueteComercio()));
                                        } catch (IOException e) {
                                            JOptionPane.showMessageDialog(null,
                                                "Fallo la conexión " + "con el servidor");
                                        }
                                    } else {
                                        JOptionPane.showMessageDialog(null, "Ya te encuentras comerciando!");
                                    }
                                } else {
                                    JOptionPane.showMessageDialog(null,
                                        "El otro usuario no se encuentra " + "dentro de la zona de comercio");
                                }
                            }
                        }
                        juego.getEstadoJuego().setHaySolicitud(false, null, MenuInfoPersonaje.MENU_BATALLAR);

                    } else if (juego.getEstadoJuego().getMenuEnemigo().clickEnCerrar(posMouse[0], posMouse[1])) {
                        juego.getEstadoJuego().setHaySolicitud(false, null, MenuInfoPersonaje.MENU_BATALLAR);
                    }
                } else {
                    juego.getEstadoJuego().setHaySolicitud(false, null, MenuInfoPersonaje.MENU_BATALLAR);
                }
            } else {
            // Se fija si clickeo alguno de los personajes
                Iterator<Integer> it = juego.getUbicacionPersonajes().keySet().iterator();
                int key;
                int[] tileMov = Mundo.mouseATile(posMouse[0] + juego.getCamara().getxOffset() - xOffset, posMouse[1] + juego.getCamara().getyOffset() - yOffset);
                PaqueteMovimiento actual;

                while (it.hasNext()) {
                    key = it.next();
                    actual = juego.getUbicacionPersonajes().get(key);
                    tilePersonajes = Mundo.mouseATile(actual.getPosX(), actual.getPosY());
                    if ( 	   actual != null 
                    		&& actual.getIdPersonaje() != juego.getPersonaje().getId()
                    		&& juego.getPersonajesConectados().get(actual.getIdPersonaje()) != null
                    		&& juego.getPersonajesConectados().get(actual.getIdPersonaje()).getEstado() == Estado.getEstadoJuego()) {
                    	//Si quiero clickear un personaje invisible, y yo no lo soy (no puedo verlo), no lo puedo atacar
                    	if(juego.getPersonajesConectados().get(key).isInvisible() && !juego.getPersonaje().isInvisible())
                    		continue;
                    	//if (   tileMoverme[0] == tilePersonajes[0] && (tileMoverme[1] == tilePersonajes[1] || tileMoverme[1] == (tilePersonajes[1] - 1) ) ) {
                    	 if (tileMov[0] == tilePersonajes[0] && tileMov[1] == tilePersonajes[1]) {	
                    		
                            idEnemigo = actual.getIdPersonaje();
                            float [] xy = Mundo.isoA2D(x, y);
                            // Controlo la posicion para no moverme hasta el
                            // lugar.
                            if (xy[0] >= COMERCIO_IZQ && xy[0] <= COMERCIO_DER
                            		&& xy[1] >= COMERCIO_DOWN && xy[1] <= COMERCIO_UP) {
                                // Si me encuentro dentro de la zona de
                                // comercio, abro el menu de Comercio.
                                juego.getEstadoJuego().setHaySolicitud(true,
                                    juego.getPersonajesConectados().get(idEnemigo),
                                    MenuInfoPersonaje.MENU_COMERCIAR);
                            } else {
                                // Si estoy dentro de la zona de batalla, abro
                                // el menu de Batalla.
                                juego.getEstadoJuego().setHaySolicitud(true,
                                    juego.getPersonajesConectados().get(idEnemigo), MenuInfoPersonaje.MENU_BATALLAR);
                            }
                            juego.getHandlerMouse().setNuevoClick(false);
                        }
                    }
                }
            }

        }

        if (juego.getHandlerMouse().getNuevoRecorrido() && !juego.getEstadoJuego().getHaySolicitud()) {

            tileMoverme = Mundo.mouseATile(posMouseRecorrido[0] + juego.getCamara().getxOffset() - xOffset,
                posMouseRecorrido[1] + juego.getCamara().getyOffset() - yOffset);

            juego.getHandlerMouse().setNuevoRecorrido(false);

            pilaMovimiento = null;

            juego.getEstadoJuego().setHaySolicitud(false, null, MenuInfoPersonaje.MENU_BATALLAR);
        }

        if (!enMovimiento && tileMoverme != null) {

            enMovimiento = false;

            tileActual = Mundo.mouseATile(x, y);

            if (tileMoverme[0] < 0 || tileMoverme[1] < 0 || tileMoverme[0] >= mundo.obtenerAncho()
                || tileMoverme[1] >= mundo.obtenerAlto()) {
                enMovimiento = false;
                juego.getHandlerMouse().setNuevoRecorrido(false);
                pilaMovimiento = null;
                tileMoverme = null;
                return;
            }

            if (   tileMoverme[0] == tileActual[0] && tileMoverme[1] == tileActual[1]
            		|| !juego.isCheatAtravezarParedes() && mundo.getTile(tileMoverme[0], tileMoverme[1]).esSolido()   ) {
                
            	tileMoverme = null;
                enMovimiento = false;
                juego.getHandlerMouse().setNuevoRecorrido(false);
                pilaMovimiento = null;
                return;
            }

            if (pilaMovimiento == null) {
            	
            	if( juego.isCheatAtravezarParedes() ){
                    pilaMovimiento = caminoMasCortoCheat(tileActual[0], tileActual[1], tileMoverme[0], tileMoverme[1]);
            	}
            	else{
                    pilaMovimiento = caminoMasCorto(tileActual[0], tileActual[1], tileMoverme[0], tileMoverme[1]);
            	}

            }
            
            // Me muevo al primero de la pila
            NodoDePila nodoActualTile = pilaMovimiento.pop();

            if (nodoActualTile == null) {
                enMovimiento = false;
                juego.getHandlerMouse().setNuevoRecorrido(false);
                pilaMovimiento = null;
                tileMoverme = null;
                return;
            }

            tileFinal = new int[2];
            tileFinal[0] = nodoActualTile.obtenerX();
            tileFinal[1] = nodoActualTile.obtenerY();

            xFinal = Mundo.dosDaIso(tileFinal[0], tileFinal[1])[0];
            yFinal = Mundo.dosDaIso(tileFinal[0], tileFinal[1])[1];

            if (tileFinal[0] == tileActual[0] - 1 && tileFinal[1] == tileActual[1] - 1) {
                movimientoHacia = VERTICAL_SUP;
            }
            if (tileFinal[0] == tileActual[0] + 1 && tileFinal[1] == tileActual[1] + 1) {
                movimientoHacia = VERTICAL_INF;
            }
            if (tileFinal[0] == tileActual[0] - 1 && tileFinal[1] == tileActual[1] + 1) {
                movimientoHacia = HORIZONTAL_IZQ;
            }
            if (tileFinal[0] == tileActual[0] + 1 && tileFinal[1] == tileActual[1] - 1) {
                movimientoHacia = HORIZONTAL_DER;
            }
            if (tileFinal[0] == tileActual[0] - 1 && tileFinal[1] == tileActual[1]) {
                movimientoHacia = DIAGONAL_SUP_IZQ;
            }
            if (tileFinal[0] == tileActual[0] + 1 && tileFinal[1] == tileActual[1]) {
                movimientoHacia = DIAGONAL_INF_DER;
            }
            if (tileFinal[0] == tileActual[0] && tileFinal[1] == tileActual[1] - 1) {
                movimientoHacia = DIAGONAL_SUP_DER;
            }
            if (tileFinal[0] == tileActual[0] && tileFinal[1] == tileActual[1] + 1) {
                movimientoHacia = DIAGONAL_INF_IZQ;
            }
            enMovimiento = true;
        }
    }

    /**
     * Mueve el personaje.
     */
    public void mover() {

        dx = 0;
        dy = 0;
        int i = 0;

        if (enMovimiento && !(x == xFinal && y == yFinal - BIG_TREINTAYDOS)) {
            // Si se cumple la condicion busco el movimiento que corresponda.
            while (movimientoHacia != movimientos.get(i)) {
                i++;
            }

            // Realizo la asignacion que corresponda.
            dx += movX.get(i);
            dy += movY.get(i);

            x += dx;
            y += dy;

            if(!juego.getPersonaje().isInvisible())
            	verSiNoEstaCercaDeUnNPC();
            // Le envio la posicion
            if (intervaloEnvio == 2) {
                enviarPosicion();
                intervaloEnvio = 0;
            }
            intervaloEnvio++;
            if (x == xFinal && y == yFinal - BIG_TREINTAYDOS) {
                enMovimiento = false;
            }
        }
    }

    /**
     * Ver si no esta cerca de un NPC.
     */
    private void verSiNoEstaCercaDeUnNPC() {
    	if (juego.getNPCs() != null) {
            boolean esPelea = false;

            Map<Integer, PaqueteDeNPC> npcs;
            npcs = new HashMap<Integer, PaqueteDeNPC>(juego.getNPCs());
            Map<Integer, PaqueteMovimiento> ubicacionNPCs;
            ubicacionNPCs = new HashMap<Integer, PaqueteMovimiento>(juego.getUbicacionNPCs());

            Iterator<Integer> it = ubicacionNPCs.keySet().iterator();
            int key;
            PaqueteMovimiento actual;

            while (it.hasNext()) {
                key = it.next();
                actual = ubicacionNPCs.get(key);
                if (actual != null) {
                    if (actual.getPosX() - x < TOLERANCIA_DISTANCIA_NPC && actual.getPosX() - x > (-1)
                        * TOLERANCIA_DISTANCIA_NPC && actual.getPosY() - y < TOLERANCIA_DISTANCIA_NPC
                        && actual.getPosY() - y > (-1) * TOLERANCIA_DISTANCIA_NPC) {
                        // iniciar pelea
                        PaqueteBatalla pBatalla = new PaqueteBatalla();

                        pBatalla.setId(juego.getPersonaje().getId());
                        pBatalla.setIdEnemigo(key);

                        juego.getPersonaje().setEstado(Estado.getEstadoBatallaNPC());
                        Estado.setEstado(null);
                        juego.setEstadoBatallaNPC(new EstadoBatallaNPC(juego, pBatalla));
                        Estado.setEstado(juego.getEstadoBatallaNPC());

                        esPelea = true;
                        break;
                    }
                }
            }
        }
    }

    /**
     * Grafica el frame del personaje.
     *
     * @param g
     *            the g
     */
    public void graficar(final Graphics g) {
        drawX = (int) (x - juego.getCamara().getxOffset());
        drawY = (int) (y - juego.getCamara().getyOffset());
        g.drawImage(getFrameAnimacionActual(), drawX, drawY + BIG_FOUR, ancho, alto, null);
    }

    /**
     * Grafica el nombre.
     *
     * @param g
     *            the g
     */
    public void graficarNombre(final Graphics g, PaquetePersonaje pj) {
    	if (pj.getEstadoCheats(PaquetePersonaje.CODE_WAWIUTB)) {
    		g.setColor(Color.BLUE);
    		g.setFont(new Font("Book Antiqua", Font.ITALIC, FONT_SIZE));
    	} else {
    		g.setColor(Color.WHITE);
    		g.setFont(new Font("Book Antiqua", Font.BOLD, FONT_SIZE));
    	}
    	
    	Pantalla.centerString(g, new java.awt.Rectangle(drawX
        		+ BIG_TREINTAYDOS, drawY - BIG_TWENTY, 0, BIG_TEN), nombre);
    }

    /**
     * Obtiene el frameActual del personaje.
     *
     * @return the frame animacion actual
     */
    private BufferedImage getFrameAnimacionActual() {
        int i = 0;
        while (movimientoHacia != movimientos.get(i) && i < movimientos.size()) {
            i++;
        }
        // Ambas listas entan sincronizadas según sus valores, por lo que el
        // indice i es el mismo para ambas.
        if (i < movimientos.size()) {
            return getPatronAnimaciones().get(i).getFrameActual();
        }

        return Recursos.getOrco().get(SIXTH_TILE)[0];
    }

    /**
     * Pide la direccion donde va.
     *
     * @return devuelve el movimiento hacia donde va
     */
    private int getDireccion() {
        return movimientoHacia;
    }

    /**
     * Obtiene el frame donde esta el personaje.
     *
     * @return the frame
     */
    private int getFrame() {
        int i = 0;
        while (movimientoHacia != movimientos.get(i) && i < movimientos.size()) {
            i++;
        }
        // Ambas listas entan sincronizadas según sus valores, por lo que el
        // indice i es el mismo para ambas.
        if (i < movimientos.size()) {
            return getPatronAnimaciones().get(i).getFrame();
        }

        return 0;
    }

    /**
     * Envia la posicion del personaje.
     */
    private void enviarPosicion() {
        juego.getUbicacionPersonaje().setPosX(x);
        juego.getUbicacionPersonaje().setPosY(y);
        juego.getUbicacionPersonaje().setDireccion(getDireccion());
        juego.getUbicacionPersonaje().setFrame(getFrame());
        try {
            juego.getCliente().getSalida()
                .writeObject(gson.toJson(juego.getUbicacionPersonaje(), PaqueteMovimiento.class));
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, "Fallo la conexión con el servidor");
        }
    }
    
    /**
     * Busca el camino más corto a recorrer para llegar a una posición si el mapa esta vacio. (se usa para el cheat de atravezar paredes)
     *
     * @param xIni
     *            ubicacion en X inicial
     * @param yIni
     *            ubicacion en Y inicial
     * @param xFin
     *            ubicacion en X final
     * @param yFin
     *            ubicacion en Y final
     * @return la pila de tiles a recorrer
     */
    private PilaDeTiles caminoMasCortoCheat( int xIni, int yIni, final int xFin, final int yFin) {
        PilaDeTiles camino = new PilaDeTiles();
        int dirX, dirY, xAct = xFin, yAct = yFin;
        
        dirX = xAct < xIni ? 1 : -1 ; // definis si vas a tener q ir para la izquierda(-1) o derecha(1)
        dirY = yAct < yIni ? 1 : -1 ; // definis si vas a tener q ir para arriba(-1) o abajo(1)
       
        camino.push( new NodoDePila(xFin, yFin)); // pones el nodo final abajo de todo de la pila
    	while( xAct != xIni && yAct != yIni){ // avanzas lo mas que puedas en diagonal
    		xAct = xAct + dirX;
    		yAct = yAct + dirY;
    		
    		camino.push( new NodoDePila(xAct, yAct));
    	}
    	
    	while( xAct != xIni ){ // avanzas lo q te queda de x todo recto
    		xAct = xAct + dirX;
    		camino.push( new NodoDePila(xAct, yAct));
    	}
    	
    	while( yAct != yIni ) { // avanzas lo que te queda de y todo recto
    		yAct = yAct + dirY;
    		camino.push( new NodoDePila(xAct, yAct));
    	}
    	
    	camino.pop(); // sacas el de arriba de todo q seria en el q ya estas parado ahora
    	return camino;
    }
    
    /**
     * Busca el camino más corto a recorrer para llegar a una posición.
     *
     * @param xIni
     *            ubicacion en X inicial
     * @param yIni
     *            ubicacion en Y inicial
     * @param xFin
     *            ubicacion en X final
     * @param yFin
     *            ubicacion en Y final
     * @return la pila de tiles a recorrer
     */
    private PilaDeTiles caminoMasCorto(final int xIni, final int yIni, final int xFin, final int yFin) {
        Grafo grafoLibres = mundo.obtenerGrafoDeTilesNoSolidos();
        // Transformo las coordenadas iniciales y finales en indices
        int nodoInicial = (yIni - grafoLibres.obtenerNodos()[0].obtenerY())
            * (int) Math.sqrt(grafoLibres.obtenerCantidadDeNodosTotal()) + xIni
            - grafoLibres.obtenerNodos()[0].obtenerX();

        int nodoFinal = (yFin - grafoLibres.obtenerNodos()[0].obtenerY())
            * (int) Math.sqrt(grafoLibres.obtenerCantidadDeNodosTotal()) + xFin
            - grafoLibres.obtenerNodos()[0].obtenerX();

        // Hago todo
        double[] vecCostos = new double[grafoLibres.obtenerCantidadDeNodosTotal()];
        int[] vecPredecesores = new int[grafoLibres.obtenerCantidadDeNodosTotal()];
        boolean[] conjSolucion = new boolean[grafoLibres.obtenerCantidadDeNodosTotal()];
        int cantSolucion = 0;
        
        // Lleno la matriz de costos de numeros grandes
        for (int i = 0; i < grafoLibres.obtenerCantidadDeNodosTotal(); i++) {
            vecCostos[i] = Double.MAX_VALUE;
        }
        
        // Adyacentes al nodo inicial
        conjSolucion[nodoInicial] = true;
        cantSolucion++;
        vecCostos[nodoInicial] = 0;
        Nodo[] adyacentes = grafoLibres.obtenerNodos()[nodoInicial].obtenerNodosAdyacentes();
        for (int i = 0; i < grafoLibres.obtenerNodos()[nodoInicial].obtenerCantidadDeAdyacentes(); i++) {
            if (estanEnDiagonal(grafoLibres.obtenerNodos()[nodoInicial],
                grafoLibres.obtenerNodos()[adyacentes[i].obtenerIndice()])) {
                vecCostos[adyacentes[i].obtenerIndice()] = ONE_AND_A_HALF;
            } else {
                vecCostos[adyacentes[i].obtenerIndice()] = 1;
            }
            vecPredecesores[adyacentes[i].obtenerIndice()] = nodoInicial;
        }
        
        // Aplico Dijkstra
        while (cantSolucion < grafoLibres.obtenerCantidadDeNodosTotal()) {
            // Elijo W perteneciente al conjunto restante tal que el costo de W
            // sea minimo
            double minimo = Double.MAX_VALUE;
            int indiceMinimo = 0;
            Nodo nodoW = null;
            for (int i = 0; i < grafoLibres.obtenerCantidadDeNodosTotal(); i++) {
                if (!conjSolucion[i] && vecCostos[i] < minimo) {
                    nodoW = grafoLibres.obtenerNodos()[i];
                    minimo = vecCostos[i];
                    indiceMinimo = i;
                }
            }
            // Pongo a W en el conj solucion
            conjSolucion[indiceMinimo] = true;
            cantSolucion++;
            // Por cada nodo I adyacente a W del conj restante
            // Le sumo 1 al costo de ir hasta W y luego ir hasta su adyacente
            adyacentes = grafoLibres.obtenerNodos()[indiceMinimo].obtenerNodosAdyacentes();
            for (int i = 0; i < grafoLibres.obtenerNodos()[indiceMinimo].obtenerCantidadDeAdyacentes(); i++) {
                double valorASumar = 1;
                if (estanEnDiagonal(grafoLibres.obtenerNodos()[indiceMinimo],
                    grafoLibres.obtenerNodos()[adyacentes[i].obtenerIndice()])) {
                    valorASumar = ONE_AND_A_HALF;
                }
                if (vecCostos[indiceMinimo] + valorASumar < vecCostos[adyacentes[i].obtenerIndice()]) {
                    vecCostos[adyacentes[i].obtenerIndice()] = vecCostos[indiceMinimo] + valorASumar;
                    vecPredecesores[adyacentes[i].obtenerIndice()] = indiceMinimo;
                }
            }
        }
        // Creo el vector de nodos hasta donde quiere llegar
        PilaDeTiles camino = new PilaDeTiles();
        while (nodoFinal != nodoInicial) {
            camino.push(new NodoDePila(grafoLibres.obtenerNodos()[nodoFinal].obtenerX(), grafoLibres.obtenerNodos()[nodoFinal].obtenerY()));
            nodoFinal = vecPredecesores[nodoFinal];
        }

        return camino;
    }

    /**
     * Pregunta si los personajes estan en diagonal.
     *
     * @param nodoUno
     *            personaje 1
     * @param nodoDos
     *            personaje 2
     * @return true or false
     */
    private boolean estanEnDiagonal(final Nodo nodoUno, final Nodo nodoDos) {

        return (nodoUno.obtenerX() == nodoDos.obtenerX() || nodoUno.obtenerY() == nodoDos.obtenerY());

    }

    /**
     * Pide el valor de X.
     *
     * @return devuelve la ubicacion en X
     */
    public float getX() {
        return x;
    }

    /**
     * Setea el valor de X.
     *
     * @param x
     *            valor nuevo de la ubicacion en X
     */
    public void setX(final float x) {
        this.x = x;
    }

    /**
     * Pide el valor de Y.
     *
     * @return devuelve la ubicacion en Y
     */
    public float getY() {
        return y;
    }

    /**
     * Setea el valor de Y.
     *
     * @param y
     *            valor nuevo de la ubicacion en Y
     */
    public void setY(final float y) {
        this.y = y;
    }

    /**
     * Pide el ancho.
     *
     * @return devuelve el ancho
     */
    public int getAncho() {
        return ancho;
    }

    /**
     * Setea el ancho.
     *
     * @param ancho
     *            nuevo ancho a setear
     */
    public void setAncho(final int ancho) {
        this.ancho = ancho;
    }

    /**
     * Pide el alto.
     *
     * @return devuelve el alto
     */
    public int getAlto() {
        return alto;
    }

    /**
     * Setea el alto.
     *
     * @param alto
     *            nuevo alto a setear
     */
    public void setAlto(final int alto) {
        this.alto = alto;
    }

    /**
     * Pide el offset de X.
     *
     * @return devuelve el offset de X
     */
    public int getxOffset() {
        return xOffset;
    }

    /**
     * Pide el offset de Y.
     *
     * @return devuelve el offset de Y
     */
    public int getYOffset() {
        return yOffset;
    }

	/**
	 * @return the patronAnimaciones
	 */
	public LinkedList<Animacion> getPatronAnimaciones() {
		return patronAnimaciones;
	}
	
	public void setPatronAnimaciones(LinkedList<BufferedImage[]> animaciones) {
        patronAnimaciones = new LinkedList<Animacion>();

        moverIzq = new Animacion(velAnimacion, animaciones.get(0));
        moverArribaIzq = new Animacion(velAnimacion, animaciones.get(1));
        moverArriba = new Animacion(velAnimacion, animaciones.get(2));
        moverArribaDer = new Animacion(velAnimacion, animaciones.get(THIRD_TILE));
        moverDer = new Animacion(velAnimacion, animaciones.get(FOURTH_TILE));
        moverAbajoDer = new Animacion(velAnimacion, animaciones.get(FIFTH_TILE));
        moverAbajo = new Animacion(velAnimacion, animaciones.get(SIXTH_TILE));
        moverAbajoIzq = new Animacion(velAnimacion, animaciones.get(SEVENTH_TILE));

        // Cargo una lista con las animaciones.
        patronAnimaciones.add(moverIzq);
        patronAnimaciones.add(moverDer);
        patronAnimaciones.add(moverArriba);
        patronAnimaciones.add(moverArribaIzq);
        patronAnimaciones.add(moverArribaDer);
        patronAnimaciones.add(moverAbajo);
        patronAnimaciones.add(moverAbajoIzq);
        patronAnimaciones.add(moverAbajoDer);
	}
	
}
