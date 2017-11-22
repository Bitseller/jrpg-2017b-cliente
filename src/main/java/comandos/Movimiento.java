package comandos;

import mensajeria.PaqueteDeMovimientos;

/**
 * The Class Movimiento.
 */
public class Movimiento extends ComandosEscucha {

    @Override
    public void ejecutar() {

        PaqueteDeMovimientos pdm = getGson().fromJson(getCadenaLeida(), PaqueteDeMovimientos.class);
        juego.setUbicacionPersonajes(pdm.getPersonajes());
    }
}
