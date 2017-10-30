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

import cliente.Cliente;
import mensajeria.Comando;

/**
 * The Class MenuRegistro.
 */
public class MenuRegistro extends JFrame {

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
            public void windowClosing(WindowEvent e) {
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
        setSize(450, 300);
        getContentPane().setLayout(null);
        setLocationRelativeTo(null);

        JLayeredPane layeredPane = new JLayeredPane();
        layeredPane.setSize(450, 300);
        getContentPane().add(layeredPane);

        JLabel lblUsuario = new JLabel("Usuario");
        lblUsuario.setForeground(Color.WHITE);
        lblUsuario.setFont(new Font("Tahoma", Font.PLAIN, 15));

        JLabel lblPassword = new JLabel("Password");
        lblPassword.setForeground(Color.WHITE);
        lblPassword.setFont(new Font("Tahoma", Font.PLAIN, 15));

        JLabel lblRegistrarse = new JLabel("Registrarse");
        layeredPane.setLayer(lblRegistrarse, 1);
        lblRegistrarse.setForeground(Color.WHITE);
        lblRegistrarse.setFont(new Font("Tahoma", Font.PLAIN, 15));

        JButton btnRegistrarse = new JButton("");
        btnRegistrarse.setFocusable(false);
        btnRegistrarse.setIcon(new ImageIcon(MenuRegistro.class.getResource("/frames/BotonMenu.png")));

        pwPassword = new JPasswordField();
        pwPassword.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                logIn(cliente);
                dispose();
            }
        });

        txtUsuario = new JTextField();
        txtUsuario.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                logIn(cliente);
                dispose();
            }
        });
        txtUsuario.setColumns(10);

        JLabel labelBackground = new JLabel("");
        labelBackground.setIcon(new ImageIcon(MenuRegistro.class.getResource("/frames/menuBackground.jpg")));
        GroupLayout gl_layeredPane = new GroupLayout(layeredPane);
        gl_layeredPane.setHorizontalGroup(
            gl_layeredPane.createParallelGroup(Alignment.LEADING)
                .addGroup(gl_layeredPane.createSequentialGroup()
                    .addGap(113)
                    .addComponent(lblUsuario, GroupLayout.PREFERRED_SIZE, 57, GroupLayout.PREFERRED_SIZE)
                    .addGap(29)
                    .addComponent(txtUsuario, GroupLayout.PREFERRED_SIZE, 118, GroupLayout.PREFERRED_SIZE))
                .addGroup(gl_layeredPane.createSequentialGroup()
                    .addGap(113)
                    .addComponent(lblPassword, GroupLayout.PREFERRED_SIZE, 65, GroupLayout.PREFERRED_SIZE)
                    .addGap(21)
                    .addComponent(pwPassword, GroupLayout.PREFERRED_SIZE, 118, GroupLayout.PREFERRED_SIZE))
                .addGroup(gl_layeredPane.createSequentialGroup()
                    .addGap(143)
                    .addGroup(gl_layeredPane.createParallelGroup(Alignment.LEADING)
                        .addComponent(btnRegistrarse, GroupLayout.PREFERRED_SIZE, 153, GroupLayout.PREFERRED_SIZE)
                        .addGroup(gl_layeredPane.createSequentialGroup()
                            .addGap(43)
                            .addComponent(lblRegistrarse, GroupLayout.PREFERRED_SIZE, 82, GroupLayout.PREFERRED_SIZE))))
                .addComponent(labelBackground, GroupLayout.PREFERRED_SIZE, 444, GroupLayout.PREFERRED_SIZE)
        );
        gl_layeredPane.setVerticalGroup(
            gl_layeredPane.createParallelGroup(Alignment.LEADING)
                .addGroup(gl_layeredPane.createSequentialGroup()
                    .addGap(69)
                    .addGroup(gl_layeredPane.createParallelGroup(Alignment.LEADING)
                        .addGroup(gl_layeredPane.createSequentialGroup()
                            .addGap(1)
                            .addComponent(lblUsuario))
                        .addComponent(txtUsuario, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
                            GroupLayout.PREFERRED_SIZE))
                    .addGap(31)
                    .addGroup(gl_layeredPane.createParallelGroup(Alignment.LEADING)
                        .addGroup(gl_layeredPane.createSequentialGroup()
                            .addGap(1)
                            .addComponent(lblPassword, GroupLayout.PREFERRED_SIZE, 17, GroupLayout.PREFERRED_SIZE))
                        .addComponent(pwPassword, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
                            GroupLayout.PREFERRED_SIZE))
                    .addGap(42)
                    .addGroup(gl_layeredPane.createParallelGroup(Alignment.LEADING)
                        .addComponent(btnRegistrarse, GroupLayout.PREFERRED_SIZE, 23, GroupLayout.PREFERRED_SIZE)
                        .addComponent(lblRegistrarse, GroupLayout.PREFERRED_SIZE, 23, GroupLayout.PREFERRED_SIZE)))
                .addComponent(labelBackground, GroupLayout.PREFERRED_SIZE, 271, GroupLayout.PREFERRED_SIZE)
        );
        layeredPane.setLayout(gl_layeredPane);
        btnRegistrarse.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
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
    public void settxtUsuario(JTextField txtUsuario) {
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
    public void setPasswordField(JPasswordField pwPassword) {
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