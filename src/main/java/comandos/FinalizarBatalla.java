package comandos;

import estados.Estado;
import mensajeria.PaqueteFinalizarBatalla;

/**
 * The Class FinalizarBatalla.
 */
public class FinalizarBatalla extends ComandosEscucha {

    @Override
    public void ejecutar() {
        PaqueteFinalizarBatalla paqueteFinalizarBatalla = gson.fromJson(cadenaLeida, PaqueteFinalizarBatalla.class);
        juego.getPersonaje().setEstado(Estado.getEstadoJuego());
        Estado.setEstado(juego.getEstadoJuego());

    }

}
