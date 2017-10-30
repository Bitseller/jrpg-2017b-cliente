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

    private JPanel contentPane;
    private JTextField textField;
    private JPasswordField passwordField;

    /**
     * Instantiates a new menu inicio sesion.
     *
     * @param cliente
     *            the cliente
     */
    public MenuInicioSesion(final Cliente cliente) {
        setIconImage(Toolkit.getDefaultToolkit().getImage("src/main/java/frames/IconoWome.png"));
        setCursor(Toolkit.getDefaultToolkit().createCustomCursor(
            new ImageIcon(MenuJugar.class.getResource("/cursor.png")).getImage(),
            new Point(0, 0), "custom cursor"));

        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                synchronized (cliente) {
                    cliente.setAccion(Comando.SALIR);
                    cliente.notify();
                }
                setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);

            }
        });

        setTitle("WOME - Iniciar Sesion");
        setSize(450, 300);
        setLocationRelativeTo(null);
        setResizable(false);
        contentPane = new JPanel();
        setContentPane(contentPane);
        contentPane.setLayout(null);

        JLayeredPane layeredPane = new JLayeredPane();
        layeredPane.setSize(450, 300);
        contentPane.add(layeredPane);

        JLabel lblNewLabel_1 = new JLabel("Password");
        lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
        lblNewLabel_1.setForeground(Color.WHITE);

        JLabel lblNewLabel = new JLabel("Usuario");
        lblNewLabel.setForeground(Color.WHITE);
        lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 15));

        JLabel lblIngresar = new JLabel("Ingresar");
        layeredPane.setLayer(lblIngresar, 1);
        lblIngresar.setForeground(Color.WHITE);
        lblIngresar.setFont(new Font("Tahoma", Font.PLAIN, 15));

        textField = new JTextField();
        textField.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent arg0) {
                logIn(cliente);
            }
        });
        textField.setColumns(10);

        passwordField = new JPasswordField();
        passwordField.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                logIn(cliente);
            }
        });
        passwordField.setFont(new Font("Tahoma", Font.PLAIN, 11));

        JButton btnConectar = new JButton("");
        btnConectar.setFocusable(false);
        btnConectar.setIcon(new ImageIcon(MenuInicioSesion.class.getResource("/frames/BotonMenu.png")));
        btnConectar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                logIn(cliente);

            }
        });

        JLabel labelBackground = new JLabel("");
        labelBackground.setIcon(new ImageIcon(MenuInicioSesion.class.getResource("/frames/menuBackground.jpg")));
        GroupLayout gl_layeredPane = new GroupLayout(layeredPane);
        gl_layeredPane.setHorizontalGroup(
            gl_layeredPane.createParallelGroup(Alignment.LEADING)
                .addGroup(gl_layeredPane.createSequentialGroup()
                    .addGap(111)
                    .addComponent(lblNewLabel, GroupLayout.PREFERRED_SIZE, 55, GroupLayout.PREFERRED_SIZE))
                .addGroup(gl_layeredPane.createSequentialGroup()
                    .addGap(111)
                    .addComponent(lblNewLabel_1, GroupLayout.PREFERRED_SIZE, 68, GroupLayout.PREFERRED_SIZE))
                .addGroup(gl_layeredPane.createSequentialGroup()
                    .addGap(141)
                    .addGroup(gl_layeredPane.createParallelGroup(Alignment.LEADING)
                        .addComponent(btnConectar, GroupLayout.PREFERRED_SIZE, 153, GroupLayout.PREFERRED_SIZE)
                        .addGroup(gl_layeredPane.createSequentialGroup()
                            .addGap(52)
                            .addComponent(lblIngresar, GroupLayout.PREFERRED_SIZE, 68, GroupLayout.PREFERRED_SIZE))))
                .addGroup(gl_layeredPane.createSequentialGroup()
                    .addGap(198)
                    .addComponent(textField, GroupLayout.PREFERRED_SIZE, 118, GroupLayout.PREFERRED_SIZE))
                .addGroup(gl_layeredPane.createSequentialGroup()
                    .addGap(198)
                    .addComponent(passwordField, GroupLayout.PREFERRED_SIZE, 118, GroupLayout.PREFERRED_SIZE))
                .addComponent(labelBackground, GroupLayout.PREFERRED_SIZE, 444, GroupLayout.PREFERRED_SIZE)
        );
        gl_layeredPane.setVerticalGroup(
            gl_layeredPane.createParallelGroup(Alignment.LEADING)
                .addGroup(gl_layeredPane.createSequentialGroup()
                    .addGap(66)
                    .addComponent(lblNewLabel, GroupLayout.PREFERRED_SIZE, 23, GroupLayout.PREFERRED_SIZE)
                    .addGap(29)
                    .addComponent(lblNewLabel_1, GroupLayout.PREFERRED_SIZE, 21, GroupLayout.PREFERRED_SIZE)
                    .addGap(43)
                    .addGroup(gl_layeredPane.createParallelGroup(Alignment.LEADING)
                        .addComponent(btnConectar, GroupLayout.PREFERRED_SIZE, 23, GroupLayout.PREFERRED_SIZE)
                        .addGroup(gl_layeredPane.createSequentialGroup()
                            .addGap(1)
                            .addComponent(lblIngresar, GroupLayout.PREFERRED_SIZE, 23, GroupLayout.PREFERRED_SIZE))))
                .addGroup(gl_layeredPane.createSequentialGroup()
                    .addGap(69)
                    .addComponent(textField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
                        GroupLayout.PREFERRED_SIZE))
                .addGroup(gl_layeredPane.createSequentialGroup()
                    .addGap(119)
                    .addComponent(passwordField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
                        GroupLayout.PREFERRED_SIZE))
                .addComponent(labelBackground, GroupLayout.PREFERRED_SIZE, 271, GroupLayout.PREFERRED_SIZE)
        );
        layeredPane.setLayout(gl_layeredPane);
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
