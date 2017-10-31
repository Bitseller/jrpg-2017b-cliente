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
import javax.swing.SwingConstants;

import cliente.Cliente;
import mensajeria.Comando;

/**
 * The Class MenuJugar.
 */
public class MenuJugar extends JFrame {

    private static final int TEXT_SIZE = 15;
    private static final int LABEL_ALTO = 23;
    private static final int FRAME_ALTO = 300;
    private static final int FRAME_ANCHO = 450;
    private static final int BOTON_ANCHO = 191;
    private static final int FILA_SEPARADOR = 30;
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
        setSize(FRAME_ANCHO, FRAME_ALTO);
        setLocationRelativeTo(null);
        setResizable(false);
        contentPane = new JPanel();
        setContentPane(contentPane);
        contentPane.setLayout(null);

        JLayeredPane layeredPane = new JLayeredPane();
        layeredPane.setSize(FRAME_ANCHO, FRAME_ALTO);
        contentPane.add(layeredPane);

        // Boton Registrarse
        JLabel lblRegistrarse = new JLabel("Registrarse");
        lblRegistrarse.setHorizontalAlignment(SwingConstants.CENTER);
        layeredPane.setLayer(lblRegistrarse, 1);
        lblRegistrarse.setForeground(Color.WHITE);
        lblRegistrarse.setEnabled(true);
        lblRegistrarse.setFont(new Font("Tahoma", Font.PLAIN, TEXT_SIZE));
        lblRegistrarse.setBackground(Color.WHITE);

        // Boton Iniciar sesion
        JLabel lblIniciarSesion = new JLabel("Iniciar Sesion");
        lblIniciarSesion.setHorizontalAlignment(SwingConstants.CENTER);
        layeredPane.setLayer(lblIniciarSesion, 1);
        lblIniciarSesion.setForeground(Color.WHITE);
        lblIniciarSesion.setFont(new Font("Tahoma", Font.PLAIN, TEXT_SIZE));

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

        GroupLayout layout = new GroupLayout(layeredPane);
        layout.setHorizontalGroup(
            layout.createParallelGroup(Alignment.CENTER)
                .addComponent(btnIniciarSesion, GroupLayout.PREFERRED_SIZE, BOTON_ANCHO, GroupLayout.PREFERRED_SIZE)
                .addComponent(lblIniciarSesion, GroupLayout.PREFERRED_SIZE, BOTON_ANCHO, GroupLayout.PREFERRED_SIZE)
                .addComponent(btnRegistrar, GroupLayout.PREFERRED_SIZE, BOTON_ANCHO, GroupLayout.PREFERRED_SIZE)
                .addComponent(lblRegistrarse, GroupLayout.PREFERRED_SIZE, BOTON_ANCHO, GroupLayout.PREFERRED_SIZE)
                .addComponent(lblBackground, GroupLayout.PREFERRED_SIZE, FRAME_ANCHO, GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(Alignment.CENTER)
                .addGroup(layout.createSequentialGroup()
                    .addGroup(layout.createParallelGroup(Alignment.CENTER)
                        .addComponent(btnIniciarSesion, GroupLayout.PREFERRED_SIZE, LABEL_ALTO,
                            GroupLayout.PREFERRED_SIZE)
                        .addComponent(lblIniciarSesion, GroupLayout.PREFERRED_SIZE, LABEL_ALTO,
                            GroupLayout.PREFERRED_SIZE))
                    .addGap(FILA_SEPARADOR)
                    .addGroup(layout.createParallelGroup(Alignment.CENTER)
                        .addComponent(btnRegistrar, GroupLayout.PREFERRED_SIZE, LABEL_ALTO, GroupLayout.PREFERRED_SIZE)
                        .addComponent(lblRegistrarse, GroupLayout.PREFERRED_SIZE, LABEL_ALTO,
                            GroupLayout.PREFERRED_SIZE)))
                .addComponent(lblBackground, GroupLayout.PREFERRED_SIZE, FRAME_ALTO, GroupLayout.PREFERRED_SIZE)
        );
        layeredPane.setLayout(layout);
    }
}
