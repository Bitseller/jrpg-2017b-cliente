package estados;

import java.awt.Graphics;

import juego.Juego;

/**
 * The Class Estado.
 */
public abstract class Estado {

    private static final int CONST_ESTADO_BATALLA_NPC = 3;

	private static Estado estadoActual = null;

    // Tipo de estados
    private static int estadoOffline = 0;
    private static int estadoJuego = 1;
    private static int estadoBatalla = 2;
    private static int estadoBatallaNPC = CONST_ESTADO_BATALLA_NPC;
    private Juego juego;

    /**
     * Instantiates a new estado.
     *
     * @param juego
     *            the juego
     */
    public Estado(final Juego juego) {
        this.juego = juego;
    }

    /**
     * Actualizar.
     */
    public abstract void actualizar();

    /**
     * Graficar.
     *
     * @param g
     *            the g
     */
    public abstract void graficar(final Graphics g);

    /**
     * Sets the estado.
     *
     * @param estado
     *            the new estado
     */
    public static void setEstado(final Estado estado) {
        estadoActual = estado;
    }

    /**
     * Gets the estado.
     *
     * @return the estado
     */
    public static Estado getEstado() {
        return estadoActual;
    }

    /**
     * Es estado de juego.
     *
     * @return true, if successful
     */
    public abstract boolean esEstadoDeJuego();

	/**
	 * @return the estadoOffline
	 */
	public static int getEstadoOffline() {
		return estadoOffline;
	}

	/**
	 * @param estadoOffline the estadoOffline to set
	 */
	public static void setEstadoOffline(int estadoOffline) {
		Estado.estadoOffline = estadoOffline;
	}

	/**
	 * @return the estadoJuego
	 */
	public static int getEstadoJuego() {
		return estadoJuego;
	}

	/**
	 * @param estadoJuego the estadoJuego to set
	 */
	public static void setEstadoJuego(int estadoJuego) {
		Estado.estadoJuego = estadoJuego;
	}

	/**
	 * @return the estadoBatalla
	 */
	public static int getEstadoBatalla() {
		return estadoBatalla;
	}

	/**
	 * @param estadoBatalla the estadoBatalla to set
	 */
	public static void setEstadoBatalla(int estadoBatalla) {
		Estado.estadoBatalla = estadoBatalla;
	}

	/**
	 * @return the estadoBatallaNPC
	 */
	public static int getEstadoBatallaNPC() {
		return estadoBatallaNPC;
	}

	/**
	 * @param estadoBatallaNPC the estadoBatallaNPC to set
	 */
	public static void setEstadoBatallaNPC(int estadoBatallaNPC) {
		Estado.estadoBatallaNPC = estadoBatallaNPC;
	}

	/**
	 * @return the juego
	 */
	public Juego getJuego() {
		return juego;
	}

	/**
	 * @param juego the juego to set
	 */
	public void setJuego(Juego juego) {
		this.juego = juego;
	}
    
    
}
