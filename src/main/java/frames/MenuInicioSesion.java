package frames;

import java.awt.Color;
import java.awt.Font;
import java.awt.Point;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
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
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.WindowConstants;

import cliente.Cliente;
import mensajeria.Comando;

/**
 * The Class MenuInicioSesion.
 */
public class MenuInicioSesion extends JFrame {

    private static final int TEXT_SIZE = 15;
    private static final int LABEL_ALTO = 23;
    private static final int BOTON_ANCHO = 153;
    private static final int LABEL_ANCHO = 68;
    private static final int FILA_SEPARADOR = 20;
    private static final int FRAME_ANCHO = 450;
    private static final int FRAME_ALTO = 300;

    private JPanel contentPane;
    private JTextField textField;
    private JPasswordField passwordField;
    private JLayeredPane layeredPane;
    private JLabel lblPassword;
    private JLabel lblUsuario;
    private JLabel lblIngresar;
    private JButton btnConectar;
    private JLabel labelBackground;

    /**
     * Instantiates a new menu inicio sesion.
     *
     * @param cliente
     *            the cliente
     */
    public MenuInicioSesion(final Cliente cliente) {
        iniciarVentana(cliente);
        iniciarLabels(cliente);

        layeredPane.setLayer(lblIngresar, JLayeredPane.PALETTE_LAYER);
        GroupLayout layout = new GroupLayout(layeredPane);
        layout.setHorizontalGroup(
            layout.createParallelGroup(Alignment.CENTER)
                .addGroup(layout.createSequentialGroup()
                    .addComponent(lblUsuario, GroupLayout.PREFERRED_SIZE, LABEL_ANCHO, GroupLayout.PREFERRED_SIZE)
                    .addComponent(textField, GroupLayout.PREFERRED_SIZE, BOTON_ANCHO, GroupLayout.PREFERRED_SIZE))
                .addGroup(layout.createSequentialGroup()
                    .addComponent(lblPassword, GroupLayout.PREFERRED_SIZE, LABEL_ANCHO, GroupLayout.PREFERRED_SIZE)
                    .addComponent(passwordField, GroupLayout.PREFERRED_SIZE, BOTON_ANCHO, GroupLayout.PREFERRED_SIZE))
                .addGroup(layout.createParallelGroup(Alignment.CENTER)
                    .addComponent(btnConectar, GroupLayout.PREFERRED_SIZE, BOTON_ANCHO, GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblIngresar, GroupLayout.PREFERRED_SIZE, LABEL_ANCHO, GroupLayout.PREFERRED_SIZE))
                .addComponent(labelBackground, GroupLayout.PREFERRED_SIZE, FRAME_ANCHO, GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(Alignment.CENTER)
                .addComponent(labelBackground, GroupLayout.PREFERRED_SIZE, FRAME_ALTO, GroupLayout.PREFERRED_SIZE)
                .addGroup(layout.createSequentialGroup()
                    .addGroup(layout.createParallelGroup(Alignment.CENTER)
                        .addComponent(lblUsuario, GroupLayout.PREFERRED_SIZE, LABEL_ALTO, GroupLayout.PREFERRED_SIZE)
                        .addComponent(textField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
                            GroupLayout.PREFERRED_SIZE))
                    .addGap(FILA_SEPARADOR)
                    .addGroup(layout.createParallelGroup(Alignment.CENTER)
                        .addComponent(lblPassword, GroupLayout.PREFERRED_SIZE, LABEL_ALTO, GroupLayout.PREFERRED_SIZE)
                        .addComponent(passwordField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
                            GroupLayout.PREFERRED_SIZE))
                    .addGap(FILA_SEPARADOR)
                    .addGroup(layout.createParallelGroup(Alignment.CENTER)
                        .addComponent(btnConectar, GroupLayout.PREFERRED_SIZE, LABEL_ALTO, GroupLayout.PREFERRED_SIZE)
                        .addComponent(lblIngresar, GroupLayout.PREFERRED_SIZE, LABEL_ALTO, GroupLayout.PREFERRED_SIZE)))
        );
        layeredPane.setLayout(layout);
    }

    /**
     * Iniciar labels.
     *
     * @param cliente
     *            the cliente
     */
    private void iniciarLabels(final Cliente cliente) {
        contentPane = new JPanel();
        setContentPane(contentPane);
        contentPane.setLayout(null);

        layeredPane = new JLayeredPane();
        layeredPane.setSize(FRAME_ANCHO, FRAME_ALTO);
        contentPane.add(layeredPane);

        lblPassword = new JLabel("Password");
        lblPassword.setFont(new Font("Tahoma", Font.PLAIN, TEXT_SIZE));
        lblPassword.setForeground(Color.WHITE);

        lblUsuario = new JLabel("Usuario");
        lblUsuario.setForeground(Color.WHITE);
        lblUsuario.setFont(new Font("Tahoma", Font.PLAIN, TEXT_SIZE));

        lblIngresar = new JLabel("Ingresar");

        lblIngresar.setForeground(Color.WHITE);
        lblIngresar.setFont(new Font("Tahoma", Font.PLAIN, TEXT_SIZE));

        textField = new JTextField();
        textField.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(final ActionEvent arg0) {
                logIn(cliente);
            }
        });
        //textField.setColumns(10);

        passwordField = new JPasswordField();
        passwordField.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(final ActionEvent e) {
                logIn(cliente);
            }
        });
        passwordField.setFont(new Font("Tahoma", Font.PLAIN, TEXT_SIZE));

        btnConectar = new JButton("");
        btnConectar.setFocusable(false);
        btnConectar.setIcon(new ImageIcon(MenuInicioSesion.class.getResource("/frames/BotonMenu.png")));
        btnConectar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(final ActionEvent e) {
                logIn(cliente);

            }
        });

        labelBackground = new JLabel("");
        labelBackground.setIcon(new ImageIcon(MenuInicioSesion.class.getResource("/frames/menuBackground.jpg")));
    }

    /**
     * Iniciar ventana.
     *
     * @param cliente
     *            the cliente
     */
    private void iniciarVentana(final Cliente cliente) {
        setIconImage(Toolkit.getDefaultToolkit().getImage("src/main/java/frames/IconoWome.png"));
        setCursor(Toolkit.getDefaultToolkit().createCustomCursor(
            new ImageIcon(MenuJugar.class.getResource("/cursor.png")).getImage(),
            new Point(0, 0), "custom cursor"));

        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(final WindowEvent e) {
                synchronized (cliente) {
                    cliente.setAccion(Comando.SALIR);
                    cliente.notify();
                }
                setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);

            }
        });

        setTitle("WOME - Iniciar Sesion");
        setSize(FRAME_ANCHO, FRAME_ALTO);
        setLocationRelativeTo(null);
        setResizable(false);
    }

    /**
     * Log in.
     *
     * @param cliente
     *            the cliente
     */
    private void logIn(final Cliente cliente) {
        synchronized (cliente) {
            cliente.setAccion(Comando.INICIOSESION);
            cliente.getPaqueteUsuario().setUsername(textField.getText());
            cliente.getPaqueteUsuario().setPassword(String.valueOf(passwordField.getPassword()));
            cliente.notify();
            dispose();
        }
    }
}
