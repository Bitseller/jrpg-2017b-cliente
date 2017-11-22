package comandos;

import mensajeria.PaqueteAtacar;

/**
 * The Class Atacar.
 */
public class Atacar extends ComandosEscucha {

    @Override
    public void ejecutar() {
        PaqueteAtacar paqueteAtacar = getGson().fromJson(getCadenaLeida(), PaqueteAtacar.class);
        juego.getEstadoBatalla().getEnemigo().actualizarAtributos(paqueteAtacar.getMapPersonaje());
        juego.getEstadoBatalla().getPersonaje().actualizarAtributos(paqueteAtacar.getMapEnemigo());
        juego.getEstadoBatalla().setMiTurno(true);
    }
}
