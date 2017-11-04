package comandos;

import mensajeria.PaquetePersonaje;

/**
 * The Class ActualizarInventario.
 */
public class ActualizarInventario extends ComandosEscucha {

    @Override
    public void ejecutar() {
        PaquetePersonaje paquetePersonaje = getGson().fromJson(getCadenaLeida(), PaquetePersonaje.class);
        juego.getPersonajesConectados().remove(paquetePersonaje.getId());
        juego.getPersonajesConectados().put(paquetePersonaje.getId(), paquetePersonaje);
        if (juego.getPersonaje().getId() == paquetePersonaje.getId()) {
            juego.actualizarPersonaje();
            juego.getEstadoJuego().actualizarPersonaje();
            juego.getCliente().actualizarItems(paquetePersonaje);
            juego.getCliente().actualizarPersonaje(juego.getPersonajesConectados().get(paquetePersonaje.getId()));
        }

    }

}
