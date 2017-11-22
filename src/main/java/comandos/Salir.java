package comandos;

import java.io.IOException;

import javax.swing.JOptionPane;

import mensajeria.Comando;
import mensajeria.Paquete;

/**
 * The Class Salir.
 */
public class Salir extends ComandosCliente {

    @Override
    public void ejecutar() {
        try {
            cliente.getPaqueteUsuario().setInicioSesion(false);
            cliente.getSalida().writeObject(getGson().toJson(new Paquete(Comando.DESCONECTAR), Paquete.class));
            cliente.getSocket().close();
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, "Error al salir");
        }
    }
}
