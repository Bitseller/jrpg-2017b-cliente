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
        this.setSize(180, 270);
        this.setLocationRelativeTo(null);

        contentPane = new JPanel();
        setContentPane(contentPane);

        JButton verStats = new JButton("Estadísticas");
        verStats.setIcon(new ImageIcon("recursos//stats.png"));
        verStats.setToolTipText("Presiona S para ver estadísticas");
        verStats.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                Pantalla.menuEscp = null;
                if (Pantalla.menuStats == null) {
                    Pantalla.menuStats = new MenuStats(cliente);
                    Pantalla.menuStats.setVisible(true);
                }
            }
        });

        JButton asignarSkills = new JButton("Asignar Skills");
        asignarSkills.setIcon(new ImageIcon("recursos//asignar skills.png"));
        asignarSkills.setToolTipText("Presiona A para asignar skills");
        asignarSkills.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                Pantalla.menuEscp = null;
                if (Pantalla.menuAsignar == null) {
                    Pantalla.menuAsignar = new MenuAsignarSkills(cliente);
                    Pantalla.menuAsignar.setVisible(true);
                }
            }
        });

        JButton inventario = new JButton("Inventario");
        inventario.setIcon(new ImageIcon("recursos//inventario.png"));
        inventario.setToolTipText("Presiona I para abrir inventario");
        inventario.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                Pantalla.menuEscp = null;
                if (Estado.getEstado().esEstadoDeJuego()) {
                    if (Pantalla.menuInventario == null) {
                        Pantalla.menuInventario = new MenuInventario(cliente);
                        Pantalla.menuInventario.setVisible(true);
                    }
                }
            }
        });

        JButton desconectarse = new JButton("Desconectarse");
        desconectarse.setIcon(new ImageIcon("recursos//desconectarse.png"));
        desconectarse.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
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
            public void actionPerformed(ActionEvent arg0) {
                Pantalla.menuEscp = null;
                dispose();
            }
        });

        BufferedImage imagenFondo = null;
        try {
            imagenFondo = ImageIO.read(new File("recursos//fondo2.png"));
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, "No se pudo cargar el fondo");

        }
        JLabel background = new JLabel(new ImageIcon(imagenFondo.getScaledInstance(200, 350, Image.SCALE_DEFAULT)));
        GroupLayout gl_contentPane = new GroupLayout(contentPane);
        gl_contentPane.setHorizontalGroup(
            gl_contentPane.createParallelGroup(Alignment.LEADING)
                .addGroup(gl_contentPane.createSequentialGroup()
                    .addGap(29)
                    .addComponent(verStats, GroupLayout.PREFERRED_SIZE, 125, GroupLayout.PREFERRED_SIZE))
                .addGroup(gl_contentPane.createSequentialGroup()
                    .addGap(29)
                    .addComponent(asignarSkills, GroupLayout.PREFERRED_SIZE, 125, GroupLayout.PREFERRED_SIZE))
                .addGroup(gl_contentPane.createSequentialGroup()
                    .addGap(29)
                    .addComponent(inventario, GroupLayout.PREFERRED_SIZE, 125, GroupLayout.PREFERRED_SIZE))
                .addGroup(gl_contentPane.createSequentialGroup()
                    .addGap(29)
                    .addComponent(desconectarse, GroupLayout.PREFERRED_SIZE, 125, GroupLayout.PREFERRED_SIZE))
                .addGroup(gl_contentPane.createSequentialGroup()
                    .addGap(29)
                    .addComponent(volver, GroupLayout.PREFERRED_SIZE, 125, GroupLayout.PREFERRED_SIZE))
                .addComponent(background, GroupLayout.PREFERRED_SIZE, 186, GroupLayout.PREFERRED_SIZE)
        );
        gl_contentPane.setVerticalGroup(
            gl_contentPane.createParallelGroup(Alignment.LEADING)
                .addGroup(gl_contentPane.createSequentialGroup()
                    .addGap(13)
                    .addComponent(verStats, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE)
                    .addGap(28)
                    .addComponent(asignarSkills, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE)
                    .addGap(30)
                    .addComponent(inventario, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE)
                    .addGap(29)
                    .addComponent(desconectarse, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE)
                    .addGap(27)
                    .addComponent(volver, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE))
                .addComponent(background, GroupLayout.PREFERRED_SIZE, 273, GroupLayout.PREFERRED_SIZE)
        );
        contentPane.setLayout(gl_contentPane);
    }

    @Override
    public JFrame getMenu() {
        return this;
    }
}
