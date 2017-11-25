package estados;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;

import javax.swing.JOptionPane;

import com.google.gson.Gson;

import dominio.Asesino;
import dominio.Casta;
import dominio.Elfo;
import dominio.Guerrero;
import dominio.Hechicero;
import dominio.Humano;
import dominio.Orco;
import dominio.Personaje;
import interfaz.EstadoDePersonaje;
import interfaz.MenuBatalla;
import interfaz.MenuInfoPersonaje;
import juego.Juego;
import mensajeria.Comando;
import mensajeria.PaqueteAtacar;
import mensajeria.PaqueteBatalla;
import mensajeria.PaqueteFinalizarBatalla;
import mensajeria.PaquetePersonaje;
import mundo.Mundo;
import recursos.Recursos;

/**
 * The Class EstadoBatalla.
 */
public class EstadoBatalla extends Estado {

    private static final int CONSTANTE_ENERGIZANTE = 10;
	private static final int Y_ESTADO_ENEMIGO = 5;
	private static final int X_ESTADO_ENEMIGO = 550;
	private static final int Y_ESTADO_PJ = 5;
	private static final int X_ESTADO_PJ = 25;
	private static final int H_ENEMIGO = 256;
	private static final int W_ENEMIGO = 256;
	private static final int Y_ENEMIGO = 75;
	private static final int X_ENEMIGO = 550;
	private static final int H_PERSONAJE = 256;
	private static final int W_PERSONAJE = 256;
	private static final int Y_PERSONAJE = 175;
	private static final int X_PERSONAJE = 0;
	private static final int ENEMIGOBUFFERFRENTE = 7;
	private static final int PERSONAJEBUFFERESPALDA = 3;
	private static final int PUNTOS_A_ASIGNAR = 3;
	private static final int CONSTANTEEXP = 40;
	private static final int PRIMERHABILIDAD = 1;
    private static final int SEGUNDAHABILIDAD = 2;
    private static final int TERCERAHABILIDAD = 3;
    private static final int CUARTAHABILIDAD = 4;
    private static final int QUINTAHABILIDAD = 5;
    private static final int SEXTAHABILIDAD = 6;
	private static final int Y_OFFSET = 150;
	private static final int X_OFFSET = -350;
	private static final int ENEMIGOBUFFERED = 5;
	private static final int PERSONAJEBUFFERED = 5;
	private Mundo mundo;
    private Personaje personaje;
    private Personaje enemigo;
    private int[] posMouse;
    private PaquetePersonaje paquetePersonaje;
    private PaquetePersonaje paqueteEnemigo;
    private PaqueteAtacar paqueteAtacar;
    private PaqueteFinalizarBatalla paqueteFinalizarBatalla;
    private boolean miTurno;

    private boolean haySpellSeleccionada;
    private boolean seRealizoAccion;

    private Gson gson = new Gson();

    private BufferedImage miniaturaPersonaje;
    private BufferedImage miniaturaEnemigo;

    private MenuBatalla menuBatalla;
	private String razaEnemigo;
	private String razaPersonaje;

    /**
     * Instantiates a new estado batalla.
     *
     * @param juego
     *            the juego
     * @param paqueteBatalla
     *            the paquete batalla
     */
    public EstadoBatalla(final Juego juego, final PaqueteBatalla paqueteBatalla) {
        super(juego);
        mundo = new Mundo(juego, "recursos/mundoBatalla.txt", "recursos/mundoBatallaCapaDos.txt");
        miTurno = paqueteBatalla.isMiTurno();

        paquetePersonaje = juego.getPersonajesConectados().get(paqueteBatalla.getId());
        paqueteEnemigo = juego.getPersonajesConectados().get(paqueteBatalla.getIdEnemigo());

        crearPersonajes();

        menuBatalla = new MenuBatalla(miTurno, personaje);

        razaEnemigo = enemigo.getNombreRaza();
		if (paqueteEnemigo.getEstadoCheats(PaquetePersonaje.CODE_IDDQD).equals(true)) {
			razaEnemigo += "GodMode";
		} else if (paqueteEnemigo.getEstadoCheats(PaquetePersonaje.CODE_TINYDADDY).equals(true)) {
			razaEnemigo += "TinyDaddy";
		}
		miniaturaEnemigo = Recursos.getPersonaje().get(razaEnemigo).get(ENEMIGOBUFFERED)[0];

		razaPersonaje = personaje.getNombreRaza();
		if (paquetePersonaje.getEstadoCheats(PaquetePersonaje.CODE_IDDQD).equals(true)) {
			razaPersonaje += "GodMode";
		} else if (paquetePersonaje.getEstadoCheats(PaquetePersonaje.CODE_TINYDADDY).equals(true)) {
			razaPersonaje += "TinyDaddy";
		}
		miniaturaPersonaje = Recursos.getPersonaje().get(razaPersonaje).get(PERSONAJEBUFFERED)[0];

        paqueteFinalizarBatalla = new PaqueteFinalizarBatalla();
        paqueteFinalizarBatalla.setId(personaje.getIdPersonaje());
        paqueteFinalizarBatalla.setIdEnemigo(enemigo.getIdPersonaje());

        // por defecto batalla perdida
        juego.getEstadoJuego().setHaySolicitud(true, juego.getPersonaje(), MenuInfoPersonaje.MENU_PERDER_BATALLA);

        // limpio la accion del mouse
        juego.getHandlerMouse().setNuevoClick(false);

    }

    @Override
    public void actualizar() {

        getJuego().getCamara().setxOffset(X_OFFSET);
        getJuego().getCamara().setyOffset(Y_OFFSET);

        seRealizoAccion = false;
        haySpellSeleccionada = false;

        if (miTurno) {

            if (getJuego().getHandlerMouse().getNuevoClick()) {
                posMouse = getJuego().getHandlerMouse().getPosMouse();

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
                        getJuego().getEstadoJuego().setHaySolicitud(true, getJuego().getPersonaje(),
                            MenuInfoPersonaje.MENU_GANAR_BATALLA);
                        if (personaje.ganarExperiencia(enemigo.getNivel() * CONSTANTEEXP)) {
                            getJuego().getPersonaje().setNivel(personaje.getNivel());
                            getJuego().getEstadoJuego().setHaySolicitud(true, getJuego().getPersonaje(),
                                MenuInfoPersonaje.MENU_SUBIR_NIVEL);
                         // Actualiza los puntos del personaje.
                            getJuego().getPersonaje().setPuntosSkill(personaje.getPuntosSkill()
                            		+ PUNTOS_A_ASIGNAR);
                        }
                        paqueteFinalizarBatalla.setGanadorBatalla(getJuego().getPersonaje().getId());
                        finalizarBatalla();
                        Estado.setEstado(getJuego().getEstadoJuego());

                    } else {
                    	if(!paquetePersonaje.getEstadoCheats(PaquetePersonaje.CODE_IDDQD) && !paqueteEnemigo.getEstadoCheats(paqueteEnemigo.CODE_IDDQD)
                    			|| paquetePersonaje.getEstadoCheats(PaquetePersonaje.CODE_IDDQD) && paqueteEnemigo.getEstadoCheats(paqueteEnemigo.CODE_IDDQD)) {
	                        paqueteAtacar = new PaqueteAtacar(paquetePersonaje.getId(), paqueteEnemigo.getId(),
	                            personaje.getSalud(), personaje.getEnergia(), enemigo.getSalud(), enemigo.getEnergia(),
	                            personaje.getDefensa(), enemigo.getDefensa(),
	                            personaje.getCasta().getProbabilidadEvitarAtaque(),
	                            enemigo.getCasta().getProbabilidadEvitarAtaque());
	                        	enviarAtaque(paqueteAtacar);
	                        	System.out.println("AMBOS SACAN VIDA");
	                        	
                    	}
                    	if(paquetePersonaje.getEstadoCheats(PaquetePersonaje.CODE_IDDQD) && !paqueteEnemigo.getEstadoCheats(paqueteEnemigo.CODE_IDDQD)) {
	                        paqueteAtacar = new PaqueteAtacar(paquetePersonaje.getId(), paqueteEnemigo.getId(),
	                            personaje.getSalud(), personaje.getEnergia(), enemigo.getSalud(), enemigo.getEnergia(),
	                            personaje.getDefensa(), enemigo.getDefensa(),
	                            1,
	                            enemigo.getCasta().getProbabilidadEvitarAtaque());
	                        	enviarAtaque(paqueteAtacar);
	                        	System.out.println("SI SACO VIDA");
	                        	
                    	}
                    	if(!paquetePersonaje.getEstadoCheats(PaquetePersonaje.CODE_IDDQD) && paqueteEnemigo.getEstadoCheats(paqueteEnemigo.CODE_IDDQD)) {
	                        paqueteAtacar = new PaqueteAtacar(paquetePersonaje.getId(), paqueteEnemigo.getId(),
	                            personaje.getSalud(), personaje.getEnergia(), enemigo.getSalud(), enemigo.getEnergia(),
	                            personaje.getDefensa(), enemigo.getDefensa(),
	                            personaje.getCasta().getProbabilidadEvitarAtaque(),
	                            1);
	                        	enviarAtaque(paqueteAtacar);
	                        	System.out.println("NO SACO VIDA");
	                        	
                    	}
                        	
                        
                        miTurno = false;
                        menuBatalla.setHabilitado(false);
                    }
                } else if (haySpellSeleccionada && !seRealizoAccion) {
                    JOptionPane.showMessageDialog(null,
                        "No posees la energía suficiente para realizar esta habilidad.");
                }

                getJuego().getHandlerMouse().setNuevoClick(false);
            }
        }

    }

    @Override
	public void graficar(final Graphics g, PaquetePersonaje pj) {
		g.setColor(Color.BLACK);
		g.fillRect(0, 0, getJuego().getAncho(), getJuego().getAlto());
		mundo.graficar(g);

		g.drawImage(Recursos.getPersonaje().get(razaPersonaje).get(PERSONAJEBUFFERESPALDA)[0], X_PERSONAJE, Y_PERSONAJE,
				W_PERSONAJE, H_PERSONAJE, null);
		g.drawImage(Recursos.getPersonaje().get(razaEnemigo).get(ENEMIGOBUFFERFRENTE)[0], X_ENEMIGO, Y_ENEMIGO,
				W_ENEMIGO, H_ENEMIGO, null);

		mundo.graficarObstaculos(g);
		menuBatalla.graficar(g);

		g.setColor(Color.GREEN);

		EstadoDePersonaje.dibujarEstadoDePersonaje(g, X_ESTADO_PJ, Y_ESTADO_PJ, personaje, miniaturaPersonaje);
		EstadoDePersonaje.dibujarEstadoDePersonaje(g, X_ESTADO_ENEMIGO, Y_ESTADO_ENEMIGO, enemigo, miniaturaEnemigo);

    }

    /**
     * Crear personajes.
     */
    private void crearPersonajes() {
        String nombre = paquetePersonaje.getNombre();
        int salud = paquetePersonaje.getSaludTope();
        int energia = paquetePersonaje.getEnergiaTope();
        int fuerza = (int) (paquetePersonaje.getFuerza() * paquetePersonaje.getMultiplicadorCheat());
        int destreza = paquetePersonaje.getDestreza();
        int inteligencia = paquetePersonaje.getInteligencia();
        int experiencia = paquetePersonaje.getExperiencia();
        int nivel = paquetePersonaje.getNivel();
        int id = paquetePersonaje.getId();

        Casta casta = null;
        try {
            casta = (Casta) Class.forName("dominio" + "." + paquetePersonaje.getCasta()).newInstance();
            personaje = (Personaje) Class.forName("dominio" + "." + paquetePersonaje.getRaza())
                .getConstructor(String.class, Integer.TYPE, Integer.TYPE, Integer.TYPE, Integer.TYPE, Integer.TYPE,
                    Casta.class, Integer.TYPE, Integer.TYPE, Integer.TYPE)
                .newInstance(nombre, salud, energia, fuerza, destreza, inteligencia, casta, experiencia, nivel, id);
        } catch (InstantiationException | IllegalAccessException | ClassNotFoundException | IllegalArgumentException
            | InvocationTargetException | NoSuchMethodException | SecurityException e) {
            JOptionPane.showMessageDialog(null, "Error al crear la batalla");
        }

        nombre = paqueteEnemigo.getNombre();
        salud = paqueteEnemigo.getSaludTope();
        energia = paqueteEnemigo.getEnergiaTope();
        fuerza = paqueteEnemigo.getFuerza();
        destreza = paqueteEnemigo.getDestreza();
        inteligencia = paqueteEnemigo.getInteligencia();
        experiencia = paqueteEnemigo.getExperiencia();
        nivel = paqueteEnemigo.getNivel();
        id = paqueteEnemigo.getId();

        casta = null;
        if (paqueteEnemigo.getCasta().equals("Guerrero")) {
            casta = new Guerrero();
        } else if (paqueteEnemigo.getCasta().equals("Hechicero")) {
            casta = new Hechicero();
        } else if (paqueteEnemigo.getCasta().equals("Asesino")) {
            casta = new Asesino();
        }

        if (paqueteEnemigo.getRaza().equals("Humano")) {
            enemigo = new Humano(nombre, salud, energia, fuerza, destreza, inteligencia, casta, experiencia, nivel, id);
        } else if (paqueteEnemigo.getRaza().equals("Orco")) {
            enemigo = new Orco(nombre, salud, energia, fuerza, destreza, inteligencia, casta, experiencia, nivel, id);
        } else if (paqueteEnemigo.getRaza().equals("Elfo")) {
            enemigo = new Elfo(nombre, salud, energia, fuerza, destreza, inteligencia, casta, experiencia, nivel, id);
        }
    }

    /**
     * Enviar ataque.
     *
     * @param pAtacar
     *            the paquete atacar
     */
    public void enviarAtaque(final PaqueteAtacar pAtacar) {
        try {
            getJuego().getCliente().getSalida().writeObject(gson.toJson(pAtacar));
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, "Fallo la conexion con el servidor.");
        }
    }

    /**
     * Finalizar batalla.
     */
    private void finalizarBatalla() {
        try {
            getJuego().getCliente().getSalida().writeObject(gson.toJson(paqueteFinalizarBatalla));

            paquetePersonaje.setSaludTope(personaje.getSaludTope());
            paquetePersonaje.setEnergiaTope(personaje.getEnergiaTope());
            paquetePersonaje.setNivel(personaje.getNivel());
            paquetePersonaje.setExperiencia(personaje.getExperiencia());
            paquetePersonaje.setDestreza(personaje.getDestreza());
            paquetePersonaje.setFuerza(personaje.getFuerza());
            paquetePersonaje.setInteligencia(personaje.getInteligencia());
            //paquetePersonaje.removerBonus();

            paqueteEnemigo.setSaludTope(enemigo.getSaludTope());
            paqueteEnemigo.setEnergiaTope(enemigo.getEnergiaTope());
            paqueteEnemigo.setNivel(enemigo.getNivel());
            paqueteEnemigo.setExperiencia(enemigo.getExperiencia());
            paqueteEnemigo.setDestreza(enemigo.getDestreza());
            paqueteEnemigo.setFuerza(enemigo.getFuerza());
            paqueteEnemigo.setInteligencia(enemigo.getInteligencia());
            //paqueteEnemigo.removerBonus();
            
            paquetePersonaje.setComando(Comando.ACTUALIZARPERSONAJE);
            paqueteEnemigo.setComando(Comando.ACTUALIZARPERSONAJE);

            getJuego().getCliente().getSalida().writeObject(gson.toJson(paquetePersonaje));
            getJuego().getCliente().getSalida().writeObject(gson.toJson(paqueteEnemigo));

        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, "Fallo la conexión con el servidor");
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
    public PaquetePersonaje getPaqueteEnemigo() {
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
        getJuego().getHandlerMouse().setNuevoClick(false);
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
    public Personaje getEnemigo() {
        return enemigo;
    }

    @Override
    public boolean esEstadoDeJuego() {
        return false;
    }
}
