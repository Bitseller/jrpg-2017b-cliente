package juego;

import java.io.FileNotFoundException;
import java.io.IOException;

import javax.swing.JOptionPane;

import cliente.Cliente;
import mensajeria.Comando;
import recursos.Recursos;

/**
 * The Class CargarRecursos.
 */
public class CargarRecursos extends Thread {

    private Cliente cliente;

    /**
     * Instantiates a new cargar recursos.
     *
     * @param cliente the cliente
     */
    public CargarRecursos(final Cliente cliente) {
        this.cliente = cliente;
    }

    @Override
    public void run() {
        synchronized (cliente) {
            try {
                Recursos.cargar(cliente.getMenuCarga());
            } catch (FileNotFoundException e) {
                JOptionPane.showMessageDialog(null, "Falló al cargar los recursos");

            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "Falló al cargar los recursos");
            } catch (IOException e) {
                JOptionPane.showMessageDialog(null, "Falló al cargar los recursos");
            }

            cliente.setAccion(Comando.SALIR);
            cliente.notify();
        }
    }

}
