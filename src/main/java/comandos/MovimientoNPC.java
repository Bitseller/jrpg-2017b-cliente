package comandos;

import mensajeria.PaqueteDeMovimientos;

/**
 * The Class MovimientoNPC.
 */
public class MovimientoNPC extends ComandosEscucha {

    @Override
    public void ejecutar() {

        PaqueteDeMovimientos pdm = gson.fromJson(cadenaLeida, PaqueteDeMovimientos.class);
        juego.setUbicacionNPCs(pdm.getPersonajes());

    }
}
