package comandos;

import java.util.Map;

import javax.swing.DefaultListModel;

import chat.VentanaContactos;
import mensajeria.PaqueteDePersonajes;
import mensajeria.PaquetePersonaje;

/**
 * The Class Conexion.
 */
public class Conexion extends ComandosEscucha {

    @Override
    public void ejecutar() {
        PaqueteDePersonajes pdp = gson.fromJson(cadenaLeida, PaqueteDePersonajes.class);
        juego.setPersonajesConectados(pdp.getPersonajes());
        actualizarLista(pdp);
    }

    /**
     * Actualizar lista.
     *
     * @param pdp
     *            paquete de personajes
     */
    private void actualizarLista(final PaqueteDePersonajes pdp) {
        DefaultListModel<String> modelo = new DefaultListModel<String>();
        VentanaContactos.getList().removeAll();
        for (Map.Entry<Integer, PaquetePersonaje> personaje : pdp.getPersonajes().entrySet()) {
            modelo.addElement(personaje.getValue().getNombre());
        }
        modelo.removeElement(juego.getPersonaje().getNombre());
        VentanaContactos.getList().setModel(modelo);
    }
}
