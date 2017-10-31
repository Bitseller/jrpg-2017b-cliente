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
/*import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.RowSpec;
import com.jgoodies.forms.layout.FormSpecs;*/
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import cliente.Cliente;
import mensajeria.Comando;

/**
 * The Class MenuRegistro.
 */
public class MenuRegistro extends JFrame {

    private static final int TEXT_SIZE = 15;
    private static final int LABEL_ALTO = 23;
    private static final int BOTON_ANCHO = 153;
    private static final int LABEL_ANCHO = 68;
    private static final int FILA_SEPARADOR = 20;
    private static final int FRAME_ANCHO = 450;
    private static final int FRAME_ALTO = 300;

    private JTextField txtUsuario;
    private JPasswordField pwPassword;

    /**
     * Instantiates a new menu registro.
     *
     * @param cliente
     *            the cliente
     */
    public MenuRegistro(final Cliente cliente) {
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
                dispose();
            }
        });

        setTitle("WOME - Registrarse");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);
        setSize(FRAME_ANCHO, FRAME_ALTO);
        getContentPane().setLayout(null);
        setLocationRelativeTo(null);

        JLayeredPane layeredPane = new JLayeredPane();
        layeredPane.setSize(FRAME_ANCHO, FRAME_ALTO);
        getContentPane().add(layeredPane);

        JLabel lblUsuario = new JLabel("Usuario");
        lblUsuario.setForeground(Color.WHITE);
        lblUsuario.setFont(new Font("Tahoma", Font.PLAIN, TEXT_SIZE));

        JLabel lblPassword = new JLabel("Password");
        lblPassword.setForeground(Color.WHITE);
        lblPassword.setFont(new Font("Tahoma", Font.PLAIN, TEXT_SIZE));

        JLabel lblRegistrarse = new JLabel("Registrarse");
        lblRegistrarse.setHorizontalAlignment(SwingConstants.CENTER);
        layeredPane.setLayer(lblRegistrarse, 1);
        lblRegistrarse.setForeground(Color.WHITE);
        lblRegistrarse.setFont(new Font("Tahoma", Font.PLAIN, TEXT_SIZE));

        JButton btnRegistrarse = new JButton("");
        btnRegistrarse.setFocusable(false);
        btnRegistrarse.setIcon(new ImageIcon(MenuRegistro.class.getResource("/frames/BotonMenu.png")));

        pwPassword = new JPasswordField();
        pwPassword.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(final ActionEvent e) {
                logIn(cliente);
                dispose();
            }
        });

        txtUsuario = new JTextField();
        txtUsuario.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(final ActionEvent e) {
                logIn(cliente);
                dispose();
            }
        });
        //txtUsuario.setColumns(10);

        JLabel labelBackground = new JLabel("");
        labelBackground.setIcon(new ImageIcon(MenuRegistro.class.getResource("/frames/menuBackground.jpg")));
        GroupLayout layout = new GroupLayout(layeredPane);
        layout.setHorizontalGroup(
            layout.createParallelGroup(Alignment.CENTER)
                .addGroup(layout.createSequentialGroup()
                    .addComponent(lblUsuario, GroupLayout.PREFERRED_SIZE, LABEL_ANCHO, GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtUsuario, GroupLayout.PREFERRED_SIZE, BOTON_ANCHO, GroupLayout.PREFERRED_SIZE))
                .addGroup(layout.createSequentialGroup()
                    .addComponent(lblPassword, GroupLayout.PREFERRED_SIZE, LABEL_ANCHO, GroupLayout.PREFERRED_SIZE)
                    .addComponent(pwPassword, GroupLayout.PREFERRED_SIZE, BOTON_ANCHO, GroupLayout.PREFERRED_SIZE))
                .addGroup(layout.createParallelGroup(Alignment.CENTER)
                    .addComponent(btnRegistrarse, GroupLayout.PREFERRED_SIZE, BOTON_ANCHO, GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblRegistrarse, GroupLayout.PREFERRED_SIZE, BOTON_ANCHO, GroupLayout.PREFERRED_SIZE))
                .addComponent(labelBackground, GroupLayout.PREFERRED_SIZE, FRAME_ANCHO, GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(Alignment.CENTER)
                .addComponent(labelBackground, GroupLayout.PREFERRED_SIZE, FRAME_ALTO, GroupLayout.PREFERRED_SIZE)
                .addGroup(layout.createSequentialGroup()
                    .addGroup(layout.createParallelGroup(Alignment.CENTER)
                        .addComponent(lblUsuario, GroupLayout.PREFERRED_SIZE, LABEL_ALTO, GroupLayout.PREFERRED_SIZE)
                        .addComponent(txtUsuario, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
                            GroupLayout.PREFERRED_SIZE))
                    .addGap(FILA_SEPARADOR)
                    .addGroup(layout.createParallelGroup(Alignment.CENTER)
                        .addComponent(lblPassword, GroupLayout.PREFERRED_SIZE, LABEL_ALTO, GroupLayout.PREFERRED_SIZE)
                        .addComponent(pwPassword, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
                            GroupLayout.PREFERRED_SIZE))
                    .addGap(FILA_SEPARADOR)
                    .addGroup(layout.createParallelGroup(Alignment.CENTER)
                        .addComponent(btnRegistrarse, GroupLayout.PREFERRED_SIZE, LABEL_ALTO,
                            GroupLayout.PREFERRED_SIZE)
                        .addComponent(lblRegistrarse, GroupLayout.PREFERRED_SIZE, LABEL_ALTO,
                            GroupLayout.PREFERRED_SIZE)))
        );
        layeredPane.setLayout(layout);
        btnRegistrarse.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(final ActionEvent e) {
                logIn(cliente);
                dispose();
            }
        });
    }

    /**
     * Gets the txt usuario.
     *
     * @return the txt usuario
     */
    public JTextField gettxtUsuario() {
        return txtUsuario;
    }

    /**
     * Sets the txt usuario.
     *
     * @param txtUsuario
     *            the new txt usuario
     */
    public void settxtUsuario(final JTextField txtUsuario) {
        this.txtUsuario = txtUsuario;
    }

    /**
     * Gets the password field.
     *
     * @return the password field
     */
    public JPasswordField getPasswordField() {
        return pwPassword;
    }

    /**
     * Sets the password field.
     *
     * @param pwPassword
     *            the new password field
     */
    public void setPasswordField(final JPasswordField pwPassword) {
        this.pwPassword = pwPassword;
    }

    /**
     * Log in.
     *
     * @param cliente
     *            the cliente
     */
    private void logIn(final Cliente cliente) {
        synchronized (cliente) {
            cliente.getPaqueteUsuario().setUsername(txtUsuario.getText());
            cliente.getPaqueteUsuario().setPassword(String.valueOf(pwPassword.getPassword()));
            cliente.setAccion(Comando.REGISTRO);
            cliente.notify();
        }
    }
}
