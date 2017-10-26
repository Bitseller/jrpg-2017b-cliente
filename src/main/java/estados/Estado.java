package estados;

import java.awt.Graphics;

import juego.Juego;

/**
 * The Class Estado.
 */
public abstract class Estado {

    private static Estado estadoActual = null;

    // Tipo de estados
    public static int estadoOffline = 0;
    public static int estadoJuego = 1;
    public static int estadoBatalla = 2;
    public static int estadoBatallaNPC = 3;

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
}
