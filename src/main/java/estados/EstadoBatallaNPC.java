package estados;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;

import javax.swing.JOptionPane;

import com.google.gson.Gson;

import dominio.Casta;
import dominio.NonPlayableCharacter;
import dominio.Personaje;
import interfaz.EstadoDeNPC;
import interfaz.EstadoDePersonaje;
import interfaz.MenuBatalla;
import interfaz.MenuInfoPersonaje;
import juego.Juego;
import mensajeria.Comando;
import mensajeria.PaqueteBatalla;
import mensajeria.PaqueteDeNPC;
import mensajeria.PaqueteFinalizarBatalla;
import mensajeria.PaquetePersonaje;
import mundo.Mundo;
import recursos.Recursos;

/**
 * The Class EstadoBatallaNPC.
 */
public class EstadoBatallaNPC extends Estado {

    private static final int Y_OFFSET = 150;
	private static final int X_OFFSET = -350;
	private static final int PERDEDOR = -1;
	private static final int PERSONAJEBUFFERED = 5;
	private static final int PRIMERHABILIDAD = 1;
    private static final int SEGUNDAHABILIDAD = 2;
    private static final int TERCERAHABILIDAD = 3;
    private static final int CUARTAHABILIDAD = 4;
    private static final int QUINTAHABILIDAD = 5;
    private static final int SEXTAHABILIDAD = 6;
	private static final int CONSTANTEEXP = 40;
	private static final int PUNTOS_A_ASIGNAR = 3;
	private static final int H_ENEMIGO = 256;
	private static final int W_ENEMIGO = 256;
	private static final int Y_ENEMIGO = 75;
	private static final int X_ENEMIGO = 550;
	private static final int H_PERSONAJE = 256;
	private static final int W_PERSONAJE = 256;
	private static final int Y_PERSONAJE = 175;
	private static final int X_PERSONAJE = 0;
	private static final int PERSONAJEBUFFERESPALDA = 3;
    private static final int CONSTANTE_ENERGIZANTE = 10;
	private static final int Y_ESTADO_ENEMIGO = 5;
	private static final int X_ESTADO_ENEMIGO = 550;
	private static final int Y_ESTADO_PJ = 5;
	private static final int X_ESTADO_PJ = 25;
	private Mundo mundo;
    private Personaje personaje;
    private NonPlayableCharacter enemigo;

    private int[] posMouse;
    private PaquetePersonaje paquetePersonaje;
    private PaqueteDeNPC paqueteEnemigo;
    private PaqueteFinalizarBatalla paqueteFinalizarBatalla;
    private boolean miTurno;

    private boolean haySpellSeleccionada;
    private boolean seRealizoAccion;

    private Gson gson = new Gson();

    private BufferedImage miniaturaPersonaje;
    private BufferedImage miniaturaNPC;

    private MenuBatalla menuBatalla;
	/**
     * Instantiates a new estado batalla NPC.
     *
     * @param juego
     *            the juego
     * @param paqueteBatalla
     *            the paquete batalla
     */
    public EstadoBatallaNPC(final Juego juego, final PaqueteBatalla paqueteBatalla) {
        super(juego);
        mundo = new Mundo(juego, "recursos/mundoBatalla.txt", "recursos/mundoBatallaCapaDos.txt");
        miTurno = true;

        paquetePersonaje = juego.getPersonajesConectados().get(paqueteBatalla.getId());
        paqueteEnemigo = juego.getNPCs().get(paqueteBatalla.getIdEnemigo());

        crearPersonajes();

        menuBatalla = new MenuBatalla(miTurno, personaje);

        miniaturaNPC = Recursos.monstruo;
        miniaturaPersonaje = Recursos.personaje.get(personaje.getNombreRaza()).get(PERSONAJEBUFFERED)[0];

        paqueteFinalizarBatalla = new PaqueteFinalizarBatalla();
        paqueteFinalizarBatalla.setId(personaje.getIdPersonaje());
        paqueteFinalizarBatalla.setIdEnemigo(paqueteEnemigo.getId());
        paqueteFinalizarBatalla.setGanadorBatalla(PERDEDOR);

        juego.getEstadoJuego().setHaySolicitud(true, juego.getPersonaje(), MenuInfoPersonaje.MENU_GANAR_BATALLA);

        juego.getHandlerMouse().setNuevoClick(false);

    }

    @Override
    public void actualizar() {

        juego.getCamara().setxOffset(X_OFFSET);
        juego.getCamara().setyOffset(Y_OFFSET);

        seRealizoAccion = false;
        haySpellSeleccionada = false;

        if (miTurno) {

            if (juego.getHandlerMouse().getNuevoClick()) {
                posMouse = juego.getHandlerMouse().getPosMouse();

                if (menuBatalla.clickEnMenu(posMouse[0], posMouse[1])) {

                    if (menuBatalla.getBotonClickeado(posMouse[0], posMouse[1]) == PRIMERHABILIDAD) {
                        if (personaje.puedeAtacar()) {
                            seRealizoAccion = true;
                            personaje.habilidadRaza1(enemigo);
                        }
                        haySpellSeleccionada = true;
                    }

                    if (menuBatalla.getBotonClickeado(posMouse[0], posMouse[1]) == SEGUNDAHABILIDAD) {
                        if (personaje.puedeAtacar()) {
                            seRealizoAccion = true;
                            personaje.habilidadRaza2(enemigo);
                        }
                        haySpellSeleccionada = true;
                    }

                    if (menuBatalla.getBotonClickeado(posMouse[0], posMouse[1]) == TERCERAHABILIDAD) {
                        if (personaje.puedeAtacar()) {
                            seRealizoAccion = true;
                            personaje.habilidadCasta1(enemigo);
                        }
                        haySpellSeleccionada = true;
                    }

                    if (menuBatalla.getBotonClickeado(posMouse[0], posMouse[1]) == CUARTAHABILIDAD) {
                        if (personaje.puedeAtacar()) {
                            seRealizoAccion = true;
                            personaje.habilidadCasta2(enemigo);
                        }
                        haySpellSeleccionada = true;
                    }

                    if (menuBatalla.getBotonClickeado(posMouse[0], posMouse[1]) == QUINTAHABILIDAD) {
                        if (personaje.puedeAtacar()) {
                            seRealizoAccion = true;
                            personaje.habilidadCasta3(enemigo);
                        }
                        haySpellSeleccionada = true;
                    }

                    if (menuBatalla.getBotonClickeado(posMouse[0], posMouse[1]) == SEXTAHABILIDAD) {
                        seRealizoAccion = true;
                        personaje.serEnergizado(CONSTANTE_ENERGIZANTE);
                        haySpellSeleccionada = true;
                    }
                }

                if (haySpellSeleccionada && seRealizoAccion) {
                    if (!enemigo.estaVivo()) {
                        juego.getEstadoJuego().setHaySolicitud(true, juego.getPersonaje(),
                            MenuInfoPersonaje.MENU_GANAR_BATALLA);
                        if (personaje.ganarExperiencia(enemigo.getNivel() * CONSTANTEEXP)) {
                            juego.getPersonaje().setNivel(personaje.getNivel());
                            juego.getPersonaje().setPuntosSkill(personaje.getPuntosSkill() + PUNTOS_A_ASIGNAR);
                            juego.getEstadoJuego().setHaySolicitud(true, juego.getPersonaje(),
                                MenuInfoPersonaje.MENU_SUBIR_NIVEL);
                        }

                        finalizarBatalla();

                        juego.getPersonaje().setEstado(Estado.estadoJuego);
                        Estado.setEstado(juego.getEstadoJuego());
                    } else {
                        enemigo.atacar(personaje);

                        if (!personaje.estaVivo()) {
                            juego.getEstadoJuego().setHaySolicitud(true, juego.getPersonaje(),
                                MenuInfoPersonaje.MENU_PERDER_BATALLA);

                            juego.getPersonaje().setEstado(Estado.estadoJuego);

                            paqueteFinalizarBatalla.setGanadorBatalla(PERDEDOR);

                            finalizarBatalla();
                        }

                        setMiTurno(true);

                    }
                } else if (haySpellSeleccionada && !seRealizoAccion) {
                    JOptionPane.showMessageDialog(null,
                        "No posees la energía suficiente para realizar esta habilidad.");
                }

                juego.getHandlerMouse().setNuevoClick(false);
            }
        }

    }

    @Override
    public void graficar(final Graphics g) {
        g.setColor(Color.BLACK);
        g.fillRect(0, 0, juego.getAncho(), juego.getAlto());
        mundo.graficar(g);

        g.drawImage(Recursos.personaje.get(paquetePersonaje.getRaza())
        		.get(PERSONAJEBUFFERESPALDA)[0], X_PERSONAJE, Y_PERSONAJE
        		, W_PERSONAJE, H_PERSONAJE, null);
        g.drawImage(Recursos.monstruo, X_ENEMIGO, Y_ENEMIGO, H_ENEMIGO, W_ENEMIGO, null);

        mundo.graficarObstaculos(g);
        menuBatalla.graficar(g);

        g.setColor(Color.GREEN);

        EstadoDePersonaje.dibujarEstadoDePersonaje(g, X_ESTADO_PJ, Y_ESTADO_PJ, personaje, miniaturaPersonaje);
        EstadoDeNPC.dibujarEstadoDeNPC(g, X_ESTADO_ENEMIGO, Y_ESTADO_ENEMIGO, enemigo, miniaturaNPC);
    }

    /**
     * Crear personajes.
     */
    private void crearPersonajes() {
        String nombre = paquetePersonaje.getNombre();
        int salud = paquetePersonaje.getSaludTope();
        int energia = paquetePersonaje.getEnergiaTope();
        int fuerza = paquetePersonaje.getFuerza();
        int destreza = paquetePersonaje.getDestreza();
        int inteligencia = paquetePersonaje.getInteligencia();
        int experiencia = paquetePersonaje.getExperiencia();
        int nivel = paquetePersonaje.getNivel();
        int id = paquetePersonaje.getId();

        Casta casta = null;
        try {
            casta = (Casta) Class.forName("dominio" + "." + paquetePersonaje.getCasta()).newInstance();
            personaje = (Personaje) Class.forName("dominio" + "." + paquetePersonaje.getRaza()).getConstructor(
                String.class, Integer.TYPE,
                Integer.TYPE, Integer.TYPE, Integer.TYPE, Integer.TYPE, Casta.class, Integer.TYPE, Integer.TYPE,
                Integer.TYPE).newInstance(nombre, salud, energia, fuerza, destreza, inteligencia, casta,
                    experiencia, nivel, id);
        } catch (InstantiationException | IllegalAccessException | ClassNotFoundException | IllegalArgumentException
            | InvocationTargetException | NoSuchMethodException | SecurityException e) {
            JOptionPane.showMessageDialog(null, "Error al crear la batalla");
        }

        enemigo = new NonPlayableCharacter(paqueteEnemigo.getNombre(), paqueteEnemigo.getNivel(), paqueteEnemigo
            .getNivel());
    }

    /**
     * Finalizar batalla.
     */
    private void finalizarBatalla() {
        try {
            paqueteFinalizarBatalla.setComando(Comando.FINALIZARBATALLANPC);
            juego.getCliente().getSalida().writeObject(gson.toJson(paqueteFinalizarBatalla));

            paquetePersonaje.setSaludTope(personaje.getSaludTope());
            paquetePersonaje.setEnergiaTope(personaje.getEnergiaTope());
            paquetePersonaje.setNivel(personaje.getNivel());
            paquetePersonaje.setExperiencia(personaje.getExperiencia());
            paquetePersonaje.setDestreza(personaje.getDestreza());
            paquetePersonaje.setFuerza(personaje.getFuerza());
            paquetePersonaje.setInteligencia(personaje.getInteligencia());

            paquetePersonaje.setPuntosSkill(personaje.getPuntosSkill());
            paquetePersonaje.removerBonus();

            paquetePersonaje.setComando(Comando.ACTUALIZARPERSONAJE);
            juego.getCliente().getSalida().writeObject(gson.toJson(paquetePersonaje));

        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, "Fallo la conexión con el servidor :C");
        }
    }

    /**
     * Gets the paquete personaje.
     *
     * @return the paquete personaje
     */
    public PaquetePersonaje getPaquetePersonaje() {
        return paquetePersonaje;
    }

    /**
     * Gets the paquete enemigo.
     *
     * @return the paquete enemigo
     */
    public PaqueteDeNPC getPaqueteEnemigo() {
        return paqueteEnemigo;
    }

    /**
     * Sets the mi turno.
     *
     * @param b
     *            the new mi turno
     */
    public void setMiTurno(final boolean b) {
        miTurno = b;
        menuBatalla.setHabilitado(b);
        juego.getHandlerMouse().setNuevoClick(false);
    }

    /**
     * Gets the personaje.
     *
     * @return the personaje
     */
    public Personaje getPersonaje() {
        return personaje;
    }

    /**
     * Gets the enemigo.
     *
     * @return the enemigo
     */
    public NonPlayableCharacter getEnemigo() {
        return enemigo;
    }

    @Override
    public boolean esEstadoDeJuego() {
        return false;
    }
}
