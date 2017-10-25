package comandos;

import juego.Juego;
import mensajeria.Comando;

public abstract class ComandosEscucha extends Comando {
	protected Juego juego;
	public void setJuego(final Juego juego) {
		this.juego = juego;
	}

}
