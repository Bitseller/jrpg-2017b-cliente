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

        PaqueteBatalla paqueteBatalla = gson.fromJson(cadenaLeida, PaqueteBatalla.class);
        juego.getPersonaje().setEstado(Estado.estadoBatalla);
        Estado.setEstado(null);
        juego.setEstadoBatalla(new EstadoBatalla(juego, paqueteBatalla));
        Estado.setEstado(juego.getEstadoBatalla());

    }

}
