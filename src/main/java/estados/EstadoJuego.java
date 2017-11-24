package estados;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import javax.swing.JOptionPane;

import com.google.gson.Gson;

import cliente.Cliente;
import entidades.Entidad;
import interfaz.EstadoDePersonaje;
import interfaz.MenuInfoPersonaje;
import juego.Juego;
import juego.Pantalla;
import mensajeria.Comando;
import mensajeria.PaqueteDeNPC;
import mensajeria.PaqueteMovimiento;
import mensajeria.PaquetePersonaje;
import mundo.Mundo;
import recursos.Recursos;

/**
 * The Class EstadoJuego.
 */
public class EstadoJuego extends Estado {

    private static final int POS_Y_MENU_INFO = 50;
	private static final int POS_X_MENU_INFO = 300;
	private static final int ALTO_NPC = 64;
	private static final int ANCHO_NPC = 64;
	private static final int ALTO_RECT_NPC = 10;
	private static final int DESPL_Y_RECT_NPC = 20;
	private static final int DESPL_X_RECT_NPC = 32;
	private static final int TAM_FONT_NPC = 15;
	private static final int ALTO_PERSONAJE = 64;
	private static final int ANCHO_PERSONAJE = 64;
	private static final int ALTO_RECT_PER = 10;
	private static final int DESPL_Y_RECT_PER = 20;
	private static final int DESPL_X_RECT_PER = 32;
	private static final int TAM_FONT_PER = 15;
	private static final int ALTO_CHAT = 35;
	private static final int ANCHO_CHAT = 102;
	private static final int POS_Y_CHAT = 524;
	private static final int POS_X_CHAT = 3;
	private static final int ALTO_MENU = 35;
	private static final int ANCHO_MENU = 102;
	private static final int POS_Y_MENU = 562;
	private static final int POS_X_MENU = 3;
	private static final int ALTO_MOCHILA = 52;
	private static final int ANCHO_MOCHILA = 59;
	private static final int POS_Y_MOCHILA = 545;
	private static final int POS_X_MOCHILA = 738;
	private static final int POS_Y_PER = 5;
	private static final int POS_X_PER = 5;
	private static final int POS_LISTA = 5;
	private static final int VEL_ANIMACION = 150;
	private static final int ALTO_ENTIDAD_PER = 64;
	private static final int ANCHO_ENTIDAD_PER = 64;
	private Entidad entidadPersonaje;
    private PaquetePersonaje paquetePersonaje;
    private Mundo mundo;
    private Map<Integer, PaqueteMovimiento> ubicacionPersonajes;
    private Map<Integer, PaquetePersonaje> personajesConectados;
    private Map<Integer, PaqueteMovimiento> ubicacionNPCS;
    private Map<Integer, PaqueteDeNPC> npcs;
    private boolean haySolicitud;
    private int tipoSolicitud;

    private final Gson gson = new Gson();

    private BufferedImage miniaturaPersonaje;

    private MenuInfoPersonaje menuEnemigo;

    /**
     * @param menuEnemigo
     * 					el menu enemigo
     */
    public void setMenuEnemigo(final MenuInfoPersonaje menuEnemigo) {
		this.menuEnemigo = menuEnemigo;
	}

	/**
     * Instantiates a new estado juego.
     *
     * @param juego
     *            the juego
     */
    //public EstadoJuego(final Juego juego) {
    public EstadoJuego(final Cliente client) {
        super(client.getJuego());
        mundo = new Mundo(client.getJuego(), "recursos/" + getMundo() + ".txt", "recursos/" + getMundo() + ".txt");
        paquetePersonaje = client.getJuego().getPersonaje();
        setEntidadPersonaje(new Entidad(client, mundo, ANCHO_ENTIDAD_PER, ALTO_ENTIDAD_PER,
        		client.getJuego().getPersonaje().getNombre(), 0, 0,
        		Recursos.getPersonaje().get(client.getJuego().getPersonaje().getRaza()), VEL_ANIMACION));
        miniaturaPersonaje = Recursos.getPersonaje().get(paquetePersonaje.getRaza()).get(POS_LISTA)[0];

        try {
            // Le envio al servidor que me conecte al mapa y mi posicion
        	client.getJuego().getPersonaje().setComando(Comando.CONEXION);
        	client.getJuego().getPersonaje().setEstado(Estado.getEstadoJuego());
        	client.getJuego().getCliente().getSalida().writeObject(gson.toJson(client.getJuego().getPersonaje(), PaquetePersonaje.class));
        	client.getJuego().getCliente().getSalida().writeObject(gson.toJson(client.getJuego().getUbicacionPersonaje(),
                PaqueteMovimiento.class));
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, "Fallo la conexión con el servidor al ingresar al mundo");
        }
    }

    @Override
    public void actualizar() {
        mundo.actualizar();
        getEntidadPersonaje().actualizar();
    }

    @Override
    public void graficar(final Graphics g, PaquetePersonaje pj) {
        g.drawImage(Recursos.getBackground(), 0, 0, getJuego().getAncho(), getJuego().getAlto(), null);
        mundo.graficar(g);
        //entidadPersonaje.graficar(g);
        graficarPersonajes(g);
        graficarNPCs(g);
        mundo.graficarObstaculos(g);
        getEntidadPersonaje().graficarNombre(g, pj);
        g.drawImage(Recursos.getMarco(), 0, 0, getJuego().getAncho(), getJuego().getAlto(), null);
        EstadoDePersonaje.dibujarEstadoDePersonaje(g, POS_X_PER, POS_Y_PER, paquetePersonaje, miniaturaPersonaje);
        g.drawImage(Recursos.getMochila(), POS_X_MOCHILA, POS_Y_MOCHILA, ANCHO_MOCHILA, ALTO_MOCHILA, null);
        g.drawImage(Recursos.getMenu(), POS_X_MENU, POS_Y_MENU, ANCHO_MENU, ALTO_MENU, null);
        g.drawImage(Recursos.getChat(), POS_X_CHAT, POS_Y_CHAT, ANCHO_CHAT, ALTO_CHAT, null);
        if (haySolicitud) {
            menuEnemigo.graficar(g, tipoSolicitud);
        }
    }

    /**
     * Graficar personajes.
     *
     * @param g
     *            the g
     */
    public void graficarPersonajes(final Graphics g) {

        if (getJuego().getPersonajesConectados() != null) {
            personajesConectados = new HashMap<Integer, PaquetePersonaje>(getJuego().getPersonajesConectados());
            ubicacionPersonajes = new HashMap<Integer, PaqueteMovimiento>(getJuego().getUbicacionPersonajes());
            Iterator<Integer> it = personajesConectados.keySet().iterator();
            int key;
            PaqueteMovimiento actual;
            g.setColor(Color.WHITE);
            g.setFont(new Font("Book Antiqua", Font.PLAIN, TAM_FONT_PER));
            
            while (it.hasNext()) {
                key = it.next();
                actual = ubicacionPersonajes.get(key);
                
                if (personajesConectados.get(key).getEstadoCheats(PaquetePersonaje.CODE_WAWIUTB)) {
            		g.setColor(Color.BLUE);
            		g.setFont(new Font("Book Antiqua", Font.ITALIC, TAM_FONT_PER));
            	} else {
            		g.setColor(Color.WHITE);
            		g.setFont(new Font("Book Antiqua", Font.BOLD, TAM_FONT_PER));
            	}
                
                if (actual != null && actual.getIdPersonaje() != getJuego().getPersonaje().getId()
                		&& personajesConectados.get(actual.getIdPersonaje()).getEstado()
                		== Estado.getEstadoJuego()) {
                	//Si un personaje es invisible no lo grafico, a menos que mi personaje tambien lo sea
                    if( personajesConectados.get(key).isInvisible() && !getJuego().getPersonaje().isInvisible()){
                    	continue;
                    }
                    Pantalla.centerString(g, new Rectangle((int) (actual.getPosX() - getJuego().getCamara().getxOffset()
                        + DESPL_X_RECT_PER), (int) (actual.getPosY() - getJuego().getCamara().getyOffset()
                        - DESPL_Y_RECT_PER), 0, ALTO_RECT_PER),
                    	personajesConectados.get(actual.getIdPersonaje()).getNombre());
                    g.drawImage(Recursos.getPersonaje().get(personajesConectados.get(actual.getIdPersonaje())
                    		.getRaza()).get(actual.getDireccion())[actual.getFrame()], (int) (actual.getPosX()
                    		  - getJuego().getCamara().getxOffset()), (int) (actual.getPosY()
                    				- getJuego().getCamara().getyOffset()), ANCHO_PERSONAJE,
                              ALTO_PERSONAJE, null);
                }
            }
        }
    }

    /**
     * Graficar NP cs.
     *
     * @param g
     *            the g
     */
    public void graficarNPCs(final Graphics g) {

        if (getJuego().getNPCs() != null) {
            npcs = new HashMap<Integer, PaqueteDeNPC>(getJuego().getNPCs());
            ubicacionNPCS = new HashMap<Integer, PaqueteMovimiento>(getJuego().getUbicacionNPCs());
            Iterator<Integer> it = npcs.keySet().iterator();
            int key;
            PaqueteMovimiento actual;
            g.setColor(Color.WHITE);
            g.setFont(new Font("Book Antiqua", Font.PLAIN, TAM_FONT_NPC));
            while (it.hasNext()) {
                key = it.next();
                actual = ubicacionNPCS.get(key);
                if (actual != null) {
                    Pantalla.centerString(g, new Rectangle((int) (actual.getPosX() - getJuego().getCamara().getxOffset()
                        + DESPL_X_RECT_NPC), (int) (actual.getPosY() - getJuego().getCamara().getyOffset()
                        		- DESPL_Y_RECT_NPC), 0, ALTO_RECT_NPC),
                    		npcs.get(actual.getIdPersonaje()).getNombre());
                    g.drawImage(Recursos.getMonstruo(), (int) (actual.getPosX() - getJuego().getCamara().getxOffset()),
                        (int) (actual.getPosY() - getJuego().getCamara().getyOffset()), ANCHO_NPC, ALTO_NPC, null);
                }
            }
        }
    }

    /**
     * Gets the personaje.
     *
     * @return the personaje
     */
    public Entidad getPersonaje() {
        return getEntidadPersonaje();
    }

    /**
     * Gets the mundo.
     *
     * @return the mundo
     */
    private String getMundo() {
        return getJuego().getPersonaje().getMapa();
    }

    /**
     * Sets the hay solicitud.
     *
     * @param b
     *            the b
     * @param enemigo
     *            the enemigo
     * @param tipoSolicitudExt
     *            the tipo solicitud
     */
    public void setHaySolicitud(final boolean b, final PaquetePersonaje enemigo, final int tipoSolicitudExt) {
        haySolicitud = b;
        // menu que mostrara al enemigo
        menuEnemigo = new MenuInfoPersonaje(POS_X_MENU_INFO, POS_Y_MENU_INFO, enemigo);
        this.tipoSolicitud = tipoSolicitudExt;
    }

    /**
     * Gets the hay solicitud.
     *
     * @return the hay solicitud
     */
    public boolean getHaySolicitud() {
        return haySolicitud;
    }

    /**
     * Actualizar personaje.
     */
    public void actualizarPersonaje() {
        paquetePersonaje = getJuego().getPersonaje();
    }

    /**
     * Gets the menu enemigo.
     *
     * @return the menu enemigo
     */
    public MenuInfoPersonaje getMenuEnemigo() {
        return this.menuEnemigo;
    }

    /**
     * Gets the tipo solicitud.
     *
     * @return the tipo solicitud
     */
    public int getTipoSolicitud() {
        return tipoSolicitud;
    }

    @Override
    public boolean esEstadoDeJuego() {
        return true;
    }

	/**
	 * @return the entidadPersonaje
	 */
	public Entidad getEntidadPersonaje() {
		return entidadPersonaje;
	}

	/**
	 * @param entidadPersonaje the entidadPersonaje to set
	 */
	public void setEntidadPersonaje(Entidad entidadPersonaje) {
		this.entidadPersonaje = entidadPersonaje;
	}
}
