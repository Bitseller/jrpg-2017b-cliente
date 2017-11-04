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
import javax.swing.WindowConstants;

import cliente.Cliente;
import mensajeria.Comando;

/**
 * The Class MenuMapas.
 */
public class MenuMapas extends JFrame {
    private static final int MAPA_EODRIM = 3;
    private static final int FILA_SEPARADOR = 20;
    private static final int TEXT_SIZE = 15;
    private static final int LABEL_ANCHO = 70;
    private static final int LABEL_ALTO = 23;
    private static final int BOTON_ANCHO = 143;
    private static final int FRAME_ALTO = 300;
    private static final int FRAME_ANCHO = 450;
    public static int numberMap = 0;
    private JPanel contentPane;

    private JLabel lblBackground;
    private JButton btnAubenor;
    private JLabel lblAubenor;
    private JButton btnAris;
    private JLabel lblAris;
    private JButton btnEodrim;
    private JLabel lblEodrim;

    /**
     * Instantiates a new menu mapas.
     *
     * @param cliente
     *            the cliente
     */
    public MenuMapas(final Cliente cliente) {
        iniciarVentana(cliente);

        //Formato de la ventana.
        JLayeredPane layeredPane = new JLayeredPane();
        layeredPane.setSize(FRAME_ANCHO, FRAME_ALTO);
        contentPane.add(layeredPane);

        iniciarLabels(cliente);

        layeredPane.setLayer(lblAubenor, JLayeredPane.PALETTE_LAYER);
        layeredPane.setLayer(lblEodrim, JLayeredPane.PALETTE_LAYER);
        layeredPane.setLayer(lblAris, JLayeredPane.PALETTE_LAYER);
        GroupLayout layout = new GroupLayout(layeredPane);
        layout.setHorizontalGroup(
            layout.createParallelGroup(Alignment.CENTER)
                .addGroup(layout.createParallelGroup(Alignment.CENTER)
                    .addComponent(btnAris, GroupLayout.PREFERRED_SIZE, BOTON_ANCHO, GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblAris, GroupLayout.PREFERRED_SIZE, LABEL_ANCHO, GroupLayout.PREFERRED_SIZE))
                .addGroup(layout.createParallelGroup(Alignment.CENTER)
                    .addComponent(btnAubenor, GroupLayout.PREFERRED_SIZE, BOTON_ANCHO, GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblAubenor, GroupLayout.PREFERRED_SIZE, LABEL_ANCHO, GroupLayout.PREFERRED_SIZE))
                .addGroup(layout.createParallelGroup(Alignment.CENTER)
                    .addComponent(btnEodrim, GroupLayout.PREFERRED_SIZE, BOTON_ANCHO, GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblEodrim, GroupLayout.PREFERRED_SIZE, LABEL_ANCHO, GroupLayout.PREFERRED_SIZE))
                .addComponent(lblBackground, GroupLayout.PREFERRED_SIZE, FRAME_ANCHO, GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(Alignment.CENTER)
                .addComponent(lblBackground, GroupLayout.PREFERRED_SIZE, FRAME_ALTO, GroupLayout.PREFERRED_SIZE)
                .addGroup(layout.createSequentialGroup()
                    .addGroup(layout.createParallelGroup(Alignment.CENTER)
                        .addComponent(btnAris, GroupLayout.PREFERRED_SIZE, LABEL_ALTO, GroupLayout.PREFERRED_SIZE)
                        .addComponent(lblAris, GroupLayout.PREFERRED_SIZE, LABEL_ALTO, GroupLayout.PREFERRED_SIZE))
                    .addGap(FILA_SEPARADOR)
                    .addGroup(layout.createParallelGroup(Alignment.CENTER)
                        .addComponent(btnAubenor, GroupLayout.PREFERRED_SIZE, LABEL_ALTO, GroupLayout.PREFERRED_SIZE)
                        .addComponent(lblAubenor, GroupLayout.PREFERRED_SIZE, LABEL_ALTO, GroupLayout.PREFERRED_SIZE))
                    .addGap(FILA_SEPARADOR)
                    .addGroup(layout.createParallelGroup(Alignment.CENTER)
                        .addComponent(btnEodrim, GroupLayout.PREFERRED_SIZE, LABEL_ALTO, GroupLayout.PREFERRED_SIZE)
                        .addComponent(lblEodrim, GroupLayout.PREFERRED_SIZE, LABEL_ALTO, GroupLayout.PREFERRED_SIZE)))

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
        lblBackground = new JLabel("");
        lblBackground.setIcon(new ImageIcon(MenuMapas.class.getResource("/frames/menuBackground.jpg")));

        // Mapa Aubenor
        //Boton.
        btnAubenor = new JButton("");
        btnAubenor.setFocusable(false);
        btnAubenor.setIcon(new ImageIcon(MenuMapas.class.getResource("/frames/BotonMenu.png")));

        //Formato del boton (etiqueta).
        lblAubenor = new JLabel("Aubenor");
        lblAubenor.setHorizontalAlignment(SwingConstants.CENTER);

        lblAubenor.setForeground(Color.WHITE);
        lblAubenor.setFont(new Font("Tahoma", Font.PLAIN, TEXT_SIZE));

        //Configuracion del boton.
        btnAubenor.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(final ActionEvent e) {
                synchronized (cliente) {
                    cliente.getPaquetePersonaje().setMapa("Aubenor");
                    numberMap = 1;
                    cliente.notify();
                }
                dispose();
            }
        });

        // Mapa Aris
        //Boton.
        btnAris = new JButton("");
        btnAris.setFocusable(false);
        btnAris.setIcon(new ImageIcon(MenuMapas.class.getResource("/frames/BotonMenu.png")));

        //Formato del boton (etiqueta).
        lblAris = new JLabel("Aris");
        lblAris.setHorizontalAlignment(SwingConstants.CENTER);
        lblAris.setForeground(Color.WHITE);
        lblAris.setFont(new Font("Tahoma", Font.PLAIN, TEXT_SIZE));

        //Configuracion del boton.
        btnAris.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(final ActionEvent e) {
                synchronized (cliente) {
                    cliente.getPaquetePersonaje().setMapa("Aris");
                    numberMap = 2;
                    cliente.notify();
                }
                dispose();
            }
        });

        // Mapa Eodrim
        //Boton
        btnEodrim = new JButton("");
        btnEodrim.setFocusable(false);
        btnEodrim.setEnabled(false);
        btnEodrim.setIcon(new ImageIcon(MenuMapas.class.getResource("/frames/BotonMenu.png")));

        //Formato del boton (etiqueta).
        lblEodrim = new JLabel("Eodrim");
        lblEodrim.setHorizontalAlignment(SwingConstants.CENTER);

        lblEodrim.setForeground(Color.WHITE);
        lblEodrim.setFont(new Font("Tahoma", Font.PLAIN, TEXT_SIZE));

        //Configuracion del Boton
        btnEodrim.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(final ActionEvent e) {
                synchronized (cliente) {
                    cliente.getPaquetePersonaje().setMapa("Eodrim");
                    numberMap = MAPA_EODRIM;
                    cliente.notify();
                }
                dispose();
            }
        });

        //Seteo de botones.
        btnAris.setEnabled(true);
        btnAubenor.setEnabled(true);
        btnEodrim.setEnabled(false);
    }

    /**
     * Iniciar ventana.
     *
     * @param cliente
     *            the cliente
     */
    private void iniciarVentana(final Cliente cliente) {
        //Acceso rapido al primer mapa.
        addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(final KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_ENTER) {
                    synchronized (cliente) {
                        cliente.getPaquetePersonaje().setMapa("Aubenor");
                        numberMap = 1;
                        cliente.notify();
                    }
                    dispose();
                }
            }
        });
        setIconImage(Toolkit.getDefaultToolkit().getImage("src/main/java/frames/IconoWome.png"));
        setCursor(Toolkit.getDefaultToolkit().createCustomCursor(
            new ImageIcon(MenuJugar.class.getResource("/cursor.png")).getImage(),
            new Point(0, 0), "custom cursor"));

        setTitle("Elegir Mapa");
        setSize(FRAME_ANCHO, FRAME_ALTO);

        // En caso de cerrar
        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(final WindowEvent e) {
                cliente.getPaquetePersonaje().setMapa("Salir");
                synchronized (cliente) {
                    cliente.setAccion(Comando.SALIR);
                    cliente.notify();
                }
                dispose();
            }
        });

        // Ventana del menu.
        setTitle("WOME - Elegir Mapa");
        setDefaultCloseOperation(WindowConstants.DO_NOTHING_ON_CLOSE);
        contentPane = new JPanel();
        setContentPane(contentPane);
        setLocationRelativeTo(null);
        setResizable(false);
    }
}
