package comandos;

import juego.Juego;
import mensajeria.Comando;

/**
 * The Class ComandosEscucha.
 */
public abstract class ComandosEscucha extends Comando {
    protected Juego juego;

    /**
     * Sets the juego.
     * @param juego
     *            el juego
     */
    public void setJuego(final Juego juego) {
        this.juego = juego;
    }

}
