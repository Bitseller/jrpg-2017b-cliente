package estados;

import java.awt.Graphics;

import juego.Juego;

/**
 * The Class Estado.
 */
public abstract class Estado {

    private static Estado estadoActual = null;

    // Tipo de estados
    private static final int estadoOffline = 0;
    private static final int estadoJuego = 1;
    private static final int estadoBatalla = 2;
    private static final int estadoBatallaNPC = 3;

    protected Juego juego;

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
	 * @return the estadoActual
	 */
	public static Estado getEstadoActual() {
		return estadoActual;
	}

	/**
	 * @param estadoActual the estadoActual to set
	 */
	public static void setEstadoActual(Estado estadoActual) {
		Estado.estadoActual = estadoActual;
	}

	/**
	 * @return the estadoOffline
	 */
	public static int getEstadoOffline() {
		return estadoOffline;
	}
	
	/**
	 * @return the estadoJuego
	 */
	public static int getEstadoJuego() {
		return estadoJuego;
	}

	/**
	 * @return the estadoBatalla
	 */
	public static int getEstadoBatalla() {
		return estadoBatalla;
	}

	/**
	 * @return the estadoBatallaNPC
	 */
	public static int getEstadoBatallaNPC() {
		return estadoBatallaNPC;
	}    
    
}
