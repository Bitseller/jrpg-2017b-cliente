package frames;

import java.awt.Point;
import java.awt.Toolkit;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import cliente.Cliente;
import mensajeria.Comando;

/**
 * The Class MenuCarga.
 */
public class MenuCarga extends JFrame {

    private static final int BARRA_ALTO = 40;
    private static final int FRAME_ALTO = 300;
    private static final int FRAME_ANCHO = 450;
    private static final int ALTO_BARRA = 27;
    private JPanel contentPane;
    private JLabel barraCargando;

    /**
     * Instantiates a new menu carga.
     *
     * @param cliente
     *            the cliente
     */
    public MenuCarga(final Cliente cliente) {
        setIconImage(Toolkit.getDefaultToolkit().getImage("src/main/java/frames/IconoWome.png"));
        setCursor(Toolkit.getDefaultToolkit().createCustomCursor(
            new ImageIcon(MenuJugar.class.getResource("/cursor.png")).getImage(), new Point(0, 0),
            "custom cursor"));

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

        barraCargando = new JLabel("");
        barraCargando.setIcon(new ImageIcon(MenuCarga.class.getResource("/frames/Barra.png")));

        JLabel lblBarraCarga = new JLabel("");
        lblBarraCarga.setIcon(new ImageIcon(MenuCarga.class.getResource("/frames/BarraCarga.png")));

        JLabel lblLogo = new JLabel("");
        lblLogo.setIcon(new ImageIcon(MenuCarga.class.getResource("/frames/WOME.png")));

        JLabel lblBackground = new JLabel("");
        lblBackground.setIcon(new ImageIcon(MenuCarga.class.getResource("/frames/menuBackground.jpg")));
        GroupLayout gl_contentPane = new GroupLayout(contentPane);
        gl_contentPane.setAutoCreateGaps(true);

        gl_contentPane.setHorizontalGroup(
            gl_contentPane.createParallelGroup(Alignment.CENTER)
                .addComponent(lblLogo)
                .addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
                    .addComponent(barraCargando, GroupLayout.PREFERRED_SIZE, 0, GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblBarraCarga)
                )
                .addComponent(lblBackground, GroupLayout.PREFERRED_SIZE, FRAME_ANCHO, GroupLayout.PREFERRED_SIZE)
        );

        gl_contentPane.setVerticalGroup(gl_contentPane.createSequentialGroup()
            .addGroup(gl_contentPane.createParallelGroup(Alignment.CENTER)
                .addGroup(gl_contentPane.createSequentialGroup()
                    .addComponent(lblLogo)
                    .addGroup(gl_contentPane.createParallelGroup(GroupLayout.Alignment.CENTER)
                        .addComponent(barraCargando)
                        .addComponent(lblBarraCarga, GroupLayout.PREFERRED_SIZE, BARRA_ALTO, GroupLayout.PREFERRED_SIZE)
                    )
                )
                .addComponent(lblBackground, GroupLayout.PREFERRED_SIZE, FRAME_ALTO, GroupLayout.PREFERRED_SIZE)
            )
        );
        contentPane.setLayout(gl_contentPane);
    }

    /**
     * Sets la longitud cargada cargado.
     *
     * @param ancho
     *            la longitud de la barra de carga
     */
    public void setBarraCargando(int ancho) {
        barraCargando.setSize(ancho, ALTO_BARRA);
    }
}
