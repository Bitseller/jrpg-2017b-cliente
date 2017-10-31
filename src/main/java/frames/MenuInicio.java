package frames;

import java.awt.Color;
import java.awt.Font;
import java.awt.Point;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

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

/**
 * The Class MenuInicio.
 */
public class MenuInicio extends JFrame {

    private static final int FRAME_ALTO = 272;
    private static final int FRAME_ANCHO = 444;
    private static final int BOTON_ALTO = 23;
    private static final int BOTON_ANCHO = 191;
    private static final int POS_LOGO = 50;
    private static final int POS_JUGAR = 150;
    private static final int POS_SALIR = 200;
    private static final int FUENTE_SIZE = 15;
    private JPanel contentPane;

    /**
     * Instantiates a new menu inicio.
     */
    public MenuInicio() {
        addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(final KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_ENTER) {
                    Cliente cliente;
                    try {
                        cliente = new Cliente();
                        cliente.start();

                    } catch (Exception e1) {
                        e1.printStackTrace();
                    }
                    dispose();
                }
            }
        });
        setIconImage(Toolkit.getDefaultToolkit().getImage("src/main/java/frames/IconoWome.png"));
        setCursor(Toolkit.getDefaultToolkit().createCustomCursor(
                new ImageIcon(MenuJugar.class.getResource("/cursor.png")).getImage(), new Point(0, 0),
                "custom cursor"));

        this.setDefaultCloseOperation(EXIT_ON_CLOSE);

        // Propiedades de la ventana
        setTitle("WOME - World Of the Middle Earth");
        //setLocation(100, 100);
        setSize(FRAME_ANCHO, FRAME_ALTO);
        //setBounds(100, 100, 450, 300);
        setLocationRelativeTo(null);
        setResizable(false);
        contentPane = new JPanel();
        //contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        JLayeredPane layeredPane = new JLayeredPane();
        //layeredPane.setLocation(0, 0);
        layeredPane.setSize(FRAME_ANCHO, FRAME_ALTO);
        contentPane.add(layeredPane);

        JLabel lblLogo = new JLabel("");
        lblLogo.setHorizontalAlignment(SwingConstants.CENTER);
        lblLogo.setIcon(new ImageIcon(MenuCarga.class.getResource("/frames/WOME.png")));
        layeredPane.setLayer(lblLogo, JLayeredPane.PALETTE_LAYER);
        lblLogo.setForeground(Color.WHITE);
        lblLogo.setEnabled(true);
        lblLogo.setBackground(Color.WHITE);

        // Boton Jugar
        JLabel lblRegistrarse = new JLabel("Jugar");
        lblRegistrarse.setHorizontalAlignment(SwingConstants.CENTER);
        layeredPane.setLayer(lblRegistrarse, JLayeredPane.PALETTE_LAYER);
        lblRegistrarse.setForeground(Color.WHITE);
        lblRegistrarse.setEnabled(true);
        lblRegistrarse.setFont(new Font("Tahoma", Font.PLAIN, FUENTE_SIZE));
        lblRegistrarse.setBackground(Color.WHITE);

        // Boton Salir
        JLabel lblIniciarSesion = new JLabel("Salir");
        lblIniciarSesion.setHorizontalAlignment(SwingConstants.CENTER);
        layeredPane.setLayer(lblIniciarSesion, JLayeredPane.PALETTE_LAYER);
        lblIniciarSesion.setForeground(Color.WHITE);
        lblIniciarSesion.setFont(new Font("Tahoma", Font.PLAIN, FUENTE_SIZE));

        JButton btnRegistrar = new JButton("Jugar");
        btnRegistrar.setFocusable(false);
        btnRegistrar.setIcon(new ImageIcon(MenuJugar.class.getResource("/frames/BotonMenu.png")));
        btnRegistrar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(final ActionEvent e) {
                Cliente cliente;
                try {
                    cliente = new Cliente();
                    cliente.start();
                } catch (Exception e1) {
                    // TODO Auto-generated catch block
                    e1.printStackTrace();
                }
                dispose();
            }
        });

        JButton btnIniciarSesion = new JButton("Salir");
        btnIniciarSesion.setFocusable(false);
        btnIniciarSesion.setIcon(new ImageIcon(MenuJugar.class.getResource("/frames/BotonMenu.png")));
        btnIniciarSesion.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(final ActionEvent e) {
                dispose();
            }
        });

        JLabel lblBackground = new JLabel("");
        lblBackground.setIcon(new ImageIcon(MenuJugar.class.getResource("/frames/menuBackground.jpg")));
        layeredPane.setLayer(lblBackground, JLayeredPane.DEFAULT_LAYER);
        lblBackground.setForeground(Color.WHITE);

        GroupLayout glLayeredPane = new GroupLayout(layeredPane);
        glLayeredPane.setAutoCreateGaps(true);

        glLayeredPane.setHorizontalGroup(glLayeredPane.createParallelGroup(Alignment.CENTER)
                .addGroup(glLayeredPane.createSequentialGroup().addComponent(lblLogo, GroupLayout.PREFERRED_SIZE,
                        GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                .addGroup(glLayeredPane.createSequentialGroup().addComponent(lblRegistrarse,
                        GroupLayout.PREFERRED_SIZE, BOTON_ANCHO, GroupLayout.PREFERRED_SIZE))
                .addGroup(glLayeredPane.createSequentialGroup().addComponent(btnIniciarSesion,
                        GroupLayout.PREFERRED_SIZE, BOTON_ANCHO, GroupLayout.PREFERRED_SIZE))
                .addGroup(glLayeredPane.createSequentialGroup().addComponent(btnRegistrar, GroupLayout.PREFERRED_SIZE,
                        191, GroupLayout.PREFERRED_SIZE))
                .addComponent(lblBackground, GroupLayout.PREFERRED_SIZE, FRAME_ANCHO, GroupLayout.PREFERRED_SIZE)
                .addGroup(glLayeredPane.createSequentialGroup().addComponent(lblIniciarSesion,
                        GroupLayout.PREFERRED_SIZE, BOTON_ANCHO, GroupLayout.PREFERRED_SIZE)));

        glLayeredPane.setVerticalGroup(glLayeredPane.createParallelGroup(Alignment.LEADING)
                .addGroup(glLayeredPane.createSequentialGroup().addGap(POS_LOGO).addComponent(lblLogo,
                        GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                .addGroup(glLayeredPane.createSequentialGroup().addGap(POS_JUGAR).addComponent(lblRegistrarse,
                        GroupLayout.PREFERRED_SIZE, BOTON_ALTO, GroupLayout.PREFERRED_SIZE))
                .addGroup(glLayeredPane.createSequentialGroup().addGap(POS_SALIR).addComponent(btnIniciarSesion,
                        GroupLayout.PREFERRED_SIZE, BOTON_ALTO, GroupLayout.PREFERRED_SIZE))
                .addGroup(glLayeredPane.createSequentialGroup().addGap(POS_JUGAR).addComponent(btnRegistrar,
                        GroupLayout.PREFERRED_SIZE, BOTON_ALTO, GroupLayout.PREFERRED_SIZE))
                .addComponent(lblBackground, GroupLayout.PREFERRED_SIZE, FRAME_ALTO, GroupLayout.PREFERRED_SIZE)
                .addGroup(glLayeredPane.createSequentialGroup().addGap(POS_SALIR).addComponent(lblIniciarSesion,
                        GroupLayout.PREFERRED_SIZE, BOTON_ALTO, GroupLayout.PREFERRED_SIZE)));
        layeredPane.setLayout(glLayeredPane);
    }

    /**
     * The main method.
     *
     * @param args
     *            the arguments
     */
    public static void main(final String[] args) {
        new MenuInicio().setVisible(true);
    }

}
