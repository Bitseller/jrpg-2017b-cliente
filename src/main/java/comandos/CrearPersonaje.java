package comandos;

import javax.swing.JOptionPane;

import mensajeria.PaquetePersonaje;

/**
 * The Class CrearPersonaje.
 */
public class CrearPersonaje extends ComandosCliente {

    @Override
    public void ejecutar() {
        JOptionPane.showMessageDialog(null, "Registro exitoso.");
        cliente.setPaquetePersonaje(getGson().fromJson(getCadenaLeida(), PaquetePersonaje.class));
        cliente.getPaqueteUsuario().setInicioSesion(true);

    }

}
