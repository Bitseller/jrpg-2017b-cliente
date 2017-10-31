package frames;

import java.awt.Color;
import java.awt.Font;
import java.awt.Point;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JPanel;

import cliente.Cliente;
import mensajeria.Comando;

/**
 * The Class MenuJugar.
 */
public class MenuJugar extends JFrame {

    private JPanel contentPane;

    /**
     * Instantiates a new menu jugar.
     *
     * @param cliente
     *            the cliente
     */
    public MenuJugar(final Cliente cliente) {
        addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(final KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_ENTER) {
                    MenuInicioSesion menuInicioSesion = new MenuInicioSesion(cliente);
                    menuInicioSesion.setVisible(true);
                    dispose();
                }
            }
        });
        setIconImage(Toolkit.getDefaultToolkit().getImage("src/main/java/frames/IconoWome.png"));
        setCursor(Toolkit.getDefaultToolkit().createCustomCursor(
            new ImageIcon(MenuJugar.class.getResource("/cursor.png")).getImage(),
            new Point(0, 0), "custom cursor"));

        this.setDefaultCloseOperation(EXIT_ON_CLOSE);

        // En caso de cerrar la ventana
        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(final WindowEvent e) {
                synchronized (cliente) {
                    cliente.setAccion(Comando.SALIR);
                    cliente.notify();
                }
                dispose();
            }
        });

        // Propiedades de la ventana
        setTitle("WOME - World Of the Middle Earth");
        setSize(450, 300);
        setLocationRelativeTo(null);
        setResizable(false);
        contentPane = new JPanel();
        setContentPane(contentPane);
        contentPane.setLayout(null);

        JLayeredPane layeredPane = new JLayeredPane();
        layeredPane.setSize(450, 300);
        contentPane.add(layeredPane);

        // Boton Registrarse
        JLabel lblRegistrarse = new JLabel("Registrarse");
        layeredPane.setLayer(lblRegistrarse, 1);
        lblRegistrarse.setForeground(Color.WHITE);
        lblRegistrarse.setEnabled(true);
        lblRegistrarse.setFont(new Font("Tahoma", Font.PLAIN, 15));
        lblRegistrarse.setBackground(Color.WHITE);

        // Boton Iniciar sesion
        JLabel lblIniciarSesion = new JLabel("Iniciar Sesion");
        layeredPane.setLayer(lblIniciarSesion, 1);
        lblIniciarSesion.setForeground(Color.WHITE);
        lblIniciarSesion.setFont(new Font("Tahoma", Font.PLAIN, 15));

        JButton btnRegistrar = new JButton("Registrarse");
        btnRegistrar.setFocusable(false);
        btnRegistrar.setIcon(new ImageIcon(MenuJugar.class.getResource("/frames/BotonMenu.png")));
        btnRegistrar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(final ActionEvent e) {
                MenuRegistro menuRegistro = new MenuRegistro(cliente);
                menuRegistro.setVisible(true);
                dispose();
            }
        });

        JButton btnIniciarSesion = new JButton("Iniciar Sesion");
        btnIniciarSesion.setFocusable(false);
        btnIniciarSesion.setIcon(new ImageIcon(MenuJugar.class.getResource("/frames/BotonMenu.png")));
        btnIniciarSesion.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(final ActionEvent e) {
                MenuInicioSesion menuInicioSesion = new MenuInicioSesion(cliente);
                menuInicioSesion.setVisible(true);
                dispose();
            }
        });

        JLabel lblBackground = new JLabel("");
        lblBackground.setIcon(new ImageIcon(MenuJugar.class.getResource("/frames/menuBackground.jpg")));
        GroupLayout glLayeredPane = new GroupLayout(layeredPane);
        glLayeredPane.setHorizontalGroup(
            glLayeredPane.createParallelGroup(Alignment.LEADING)
                .addGroup(glLayeredPane.createSequentialGroup()
                    .addGap(121)
                    .addGroup(glLayeredPane.createParallelGroup(Alignment.LEADING)
                        .addComponent(btnIniciarSesion, GroupLayout.PREFERRED_SIZE, 191, GroupLayout.PREFERRED_SIZE)
                        .addGroup(glLayeredPane.createSequentialGroup()
                            .addGap(54)
                            .addComponent(lblIniciarSesion, GroupLayout.PREFERRED_SIZE, 91,
                                GroupLayout.PREFERRED_SIZE))))
                .addGroup(glLayeredPane.createSequentialGroup()
                    .addGap(121)
                    .addGroup(glLayeredPane.createParallelGroup(Alignment.LEADING)
                        .addComponent(btnRegistrar, GroupLayout.PREFERRED_SIZE, 191, GroupLayout.PREFERRED_SIZE)
                        .addGroup(glLayeredPane.createSequentialGroup()
                            .addGap(60)
                            .addComponent(lblRegistrarse, GroupLayout.PREFERRED_SIZE, 82, GroupLayout.PREFERRED_SIZE))))
                .addComponent(lblBackground, GroupLayout.PREFERRED_SIZE, 444, GroupLayout.PREFERRED_SIZE)
        );
        glLayeredPane.setVerticalGroup(
            glLayeredPane.createParallelGroup(Alignment.LEADING)
                .addGroup(glLayeredPane.createSequentialGroup()
                    .addGap(91)
                    .addGroup(glLayeredPane.createParallelGroup(Alignment.LEADING)
                        .addGroup(glLayeredPane.createSequentialGroup()
                            .addGap(1)
                            .addComponent(btnIniciarSesion, GroupLayout.PREFERRED_SIZE, 23, GroupLayout.PREFERRED_SIZE))
                        .addComponent(lblIniciarSesion, GroupLayout.PREFERRED_SIZE, 23, GroupLayout.PREFERRED_SIZE))
                    .addGap(47)
                    .addGroup(glLayeredPane.createParallelGroup(Alignment.LEADING)
                        .addComponent(btnRegistrar, GroupLayout.PREFERRED_SIZE, 23, GroupLayout.PREFERRED_SIZE)
                        .addComponent(lblRegistrarse, GroupLayout.PREFERRED_SIZE, 23, GroupLayout.PREFERRED_SIZE)))
                .addComponent(lblBackground, GroupLayout.PREFERRED_SIZE, 271, GroupLayout.PREFERRED_SIZE)
        );
        layeredPane.setLayout(glLayeredPane);
    }
}
