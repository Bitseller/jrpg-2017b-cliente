package comandos;

import estados.Estado;
import mensajeria.PaqueteFinalizarBatalla;

/**
 * The Class FinalizarBatalla.
 */
public class FinalizarBatalla extends ComandosEscucha {

    @Override
    public void ejecutar() {
        PaqueteFinalizarBatalla paqueteFinalizarBatalla = getGson().fromJson(getCadenaLeida(),
        		PaqueteFinalizarBatalla.class);
        juego.getPersonaje().setEstado(Estado.getEstadoJuego());
        Estado.setEstado(juego.getEstadoJuego());
    }
}
