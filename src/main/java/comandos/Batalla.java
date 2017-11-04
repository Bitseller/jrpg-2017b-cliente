package comandos;

import estados.Estado;
import estados.EstadoBatalla;
import mensajeria.PaqueteBatalla;

/**
 * The Class Batalla.
 */
public class Batalla extends ComandosEscucha {

    @Override
    public void ejecutar() {

        PaqueteBatalla paqueteBatalla = getGson().fromJson(getCadenaLeida(), PaqueteBatalla.class);
        juego.getPersonaje().setEstado(Estado.getEstadoBatalla());
        Estado.setEstado(null);
        juego.setEstadoBatalla(new EstadoBatalla(juego, paqueteBatalla));
        Estado.setEstado(juego.getEstadoBatalla());

    }

}
