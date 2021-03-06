package frames;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

import com.google.gson.Gson;

import cliente.Cliente;
import inventario.Inventario;
import juego.Pantalla;
import mensajeria.Comando;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

/**
 * The Class MenuInventario.
 */
public class MenuInventario extends JFrame {
    private static final int FRAME_SIZE = 600;
    private JButton cancelar = new JButton("Exit");

    /**
     * Instantiates a new menu inventario.
     *
     * @param cliente
     *            the cliente
     */
    public MenuInventario(final Cliente cliente) {
        cancelar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(final ActionEvent e) {
                try {
                    Gson gson = new Gson();
                    cliente.getPaquetePersonaje().setComando(Comando.ACTUALIZARINVENTARIO);
                    cliente.getSalida().writeObject(gson.toJson(cliente.getPaquetePersonaje()));
                } catch (IOException e1) {
                    JOptionPane.showMessageDialog(null, "Error al actualizar inventario");
                }
                Pantalla.setMenuInventario(null);
                dispose();
            }
        });
        this.setTitle("Inventario");
        this.setUndecorated(true);
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        try {
            getContentPane().setLayout(new BorderLayout());
            Inventario inventario = new Inventario(cliente.getPaquetePersonaje());
            inventario.addKeyListener(new KeyAdapter() {
            	@Override
            	public void keyPressed(KeyEvent e) {
            		if (e.getKeyCode() == KeyEvent.VK_ESCAPE) {
            			Pantalla.setMenuInventario(null);
                        dispose();
            		}
            	}
            });
            getContentPane().add(inventario);
            //cliente.getPaquetePersonaje().removerBonus();
            getContentPane().add(cancelar, BorderLayout.AFTER_LAST_LINE);
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, "Falló al iniciar el inventario");
        }
        this.setSize(FRAME_SIZE, FRAME_SIZE);
        this.pack();
        this.setLocationRelativeTo(null);
        //this.setLocation(900, 140);
        this.setResizable(false);
        this.setVisible(true);
    }
}
