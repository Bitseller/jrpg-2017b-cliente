package comandos;

import javax.swing.JOptionPane;

import mensajeria.Paquete;
import mensajeria.PaquetePersonaje;

/**
 * The Class InicioSesion.
 */
public class InicioSesion extends ComandosCliente {

    @Override
    public void ejecutar() {
        Paquete paquete = gson.fromJson(cadenaLeida, Paquete.class);
        if (paquete.getMensaje().equals(Paquete.getMsjExito())) {

            // El usuario ya inicio sesión
            cliente.getPaqueteUsuario().setInicioSesion(true);

            // Recibo el paquete personaje con los datos
            cliente.setPaquetePersonaje(gson.fromJson(cadenaLeida, PaquetePersonaje.class));

        } else {
            if (paquete.getMensaje().equals(Paquete.getMsjFracaso())) {
                JOptionPane.showMessageDialog(null, "Error al iniciar sesión." + " Revise el usuario y la contraseña");
            }

            // El usuario no pudo iniciar sesión
            cliente.getPaqueteUsuario().setInicioSesion(false);
        }

    }

}
