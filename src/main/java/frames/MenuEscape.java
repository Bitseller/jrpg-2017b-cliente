package frames;

import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import com.google.gson.Gson;

import cliente.Cliente;
import estados.Estado;
import juego.Pantalla;
import mensajeria.Comando;
import mensajeria.Paquete;

/**
 * The Class MenuEscape.
 */
public class MenuEscape extends JFrame implements MenuGenerico {

    private static final int FRAME_ALTO = 270;
    private static final int FRAME_ANCHO = 180;
    private static final int BOTON_ALTO = 25;
    private static final int BOTON_ANCHO = 125;
    private static final int FILA_SEPARADOR = 30;
    private JPanel contentPane;
    private final Gson gson = new Gson();

    /**
     * Create the frame.
     *
     * @param cliente
     *            the cliente
     */
    public MenuEscape(final Cliente cliente) {
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.setUndecorated(true);
        this.setResizable(false);
        this.setSize(FRAME_ANCHO, FRAME_ALTO);
        this.setLocationRelativeTo(null);

        contentPane = new JPanel();
        setContentPane(contentPane);

        JButton verStats = new JButton("Estadísticas");
        verStats.setIcon(new ImageIcon("recursos//stats.png"));
        verStats.setToolTipText("Presiona S para ver estadísticas");
        verStats.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(final ActionEvent e) {
                dispose();
                Pantalla.setMenuEscp(null);
                if (Pantalla.getMenuStats() == null) {
                    Pantalla.setMenuStats(new MenuStats(cliente));
                    Pantalla.getMenuStats().setVisible(true);
                }
            }
        });

        JButton asignarSkills = new JButton("Asignar Skills");
        asignarSkills.setIcon(new ImageIcon("recursos//asignar skills.png"));
        asignarSkills.setToolTipText("Presiona A para asignar skills");
        asignarSkills.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(final ActionEvent e) {
                dispose();
                Pantalla.setMenuEscp(null);
                if (Pantalla.getMenuAsignar() == null) {
                    Pantalla.setMenuAsignar(new MenuAsignarSkills(cliente));
                    Pantalla.getMenuAsignar().setVisible(true);
                }
            }
        });

        JButton inventario = new JButton("Inventario");
        inventario.setIcon(new ImageIcon("recursos//inventario.png"));
        inventario.setToolTipText("Presiona I para abrir inventario");
        inventario.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(final ActionEvent e) {
                dispose();
                Pantalla.setMenuEscp(null);
                if (Estado.getEstado().esEstadoDeJuego()) {
                    if (Pantalla.getMenuInventario() == null) {
                        Pantalla.setMenuInventario(new MenuInventario(cliente));
                        Pantalla.getMenuInventario().setVisible(true);
                    }
                }
            }
        });

        JButton desconectarse = new JButton("Desconectarse");
        desconectarse.setIcon(new ImageIcon("recursos//desconectarse.png"));
        desconectarse.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(final ActionEvent e) {
                try {
                    Paquete p = new Paquete();
                    p.setComando(Comando.DESCONECTAR);
                    p.setIp(cliente.getMiIp());
                    cliente.getSalida().writeObject(gson.toJson(p));
                    cliente.getEntrada().close();
                    cliente.getSalida().close();
                    cliente.getSocket().close();
                    System.exit(0);
                } catch (IOException e1) {
                    JOptionPane.showMessageDialog(null, "Error al desconectar");

                }
            }
        });

        JButton volver = new JButton("Volver");
        volver.setIcon(new ImageIcon("recursos//volver.png"));
        volver.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(final ActionEvent arg0) {
                Pantalla.setMenuEscp(null);
                dispose();
            }
        });

        BufferedImage imagenFondo = null;
        try {
            imagenFondo = ImageIO.read(new File("recursos//fondo2.png"));
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, "No se pudo cargar el fondo");

        }
        JLabel background = new JLabel(new ImageIcon(imagenFondo.getScaledInstance(FRAME_ANCHO, FRAME_ALTO,
            Image.SCALE_DEFAULT)));
        GroupLayout layout = new GroupLayout(contentPane);
        layout.setHorizontalGroup(
            layout.createParallelGroup(Alignment.CENTER)
                .addComponent(verStats, GroupLayout.PREFERRED_SIZE, BOTON_ANCHO, GroupLayout.PREFERRED_SIZE)
                .addComponent(asignarSkills, GroupLayout.PREFERRED_SIZE, BOTON_ANCHO, GroupLayout.PREFERRED_SIZE)
                .addComponent(inventario, GroupLayout.PREFERRED_SIZE, BOTON_ANCHO, GroupLayout.PREFERRED_SIZE)
                .addComponent(desconectarse, GroupLayout.PREFERRED_SIZE, BOTON_ANCHO, GroupLayout.PREFERRED_SIZE)
                .addComponent(volver, GroupLayout.PREFERRED_SIZE, BOTON_ANCHO, GroupLayout.PREFERRED_SIZE)
                .addComponent(background, GroupLayout.PREFERRED_SIZE, FRAME_ANCHO, GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(Alignment.CENTER)
                .addGroup(layout.createSequentialGroup()
                    .addComponent(verStats, GroupLayout.PREFERRED_SIZE, BOTON_ALTO, GroupLayout.PREFERRED_SIZE)
                    .addGap(FILA_SEPARADOR)
                    .addComponent(asignarSkills, GroupLayout.PREFERRED_SIZE, BOTON_ALTO, GroupLayout.PREFERRED_SIZE)
                    .addGap(FILA_SEPARADOR)
                    .addComponent(inventario, GroupLayout.PREFERRED_SIZE, BOTON_ALTO, GroupLayout.PREFERRED_SIZE)
                    .addGap(FILA_SEPARADOR)
                    .addComponent(desconectarse, GroupLayout.PREFERRED_SIZE, BOTON_ALTO, GroupLayout.PREFERRED_SIZE)
                    .addGap(FILA_SEPARADOR)
                    .addComponent(volver, GroupLayout.PREFERRED_SIZE, BOTON_ALTO, GroupLayout.PREFERRED_SIZE))
                .addComponent(background, GroupLayout.PREFERRED_SIZE, FRAME_ALTO, GroupLayout.PREFERRED_SIZE)
        );
        contentPane.setLayout(layout);
    }

    @Override
    public JFrame getMenu() {
        return this;
    }
}
