package frames;

import java.awt.Point;
import java.awt.Toolkit;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import cliente.Cliente;
import mensajeria.Comando;

/**
 * The Class MenuCarga.
 */
public class MenuCarga extends JFrame {

    private static final int BORDE = 5;
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
        setBounds(100, 100, 450, 300);
        setLocationRelativeTo(null);
        setResizable(false);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(BORDE, BORDE, BORDE, BORDE));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        barraCargando = new JLabel("");
        barraCargando.setIcon(new ImageIcon(MenuCarga.class.getResource("/frames/Barra.png")));
        barraCargando.setBounds(52, 160, 0, ALTO_BARRA);
        contentPane.add(barraCargando);

        JLabel lblBarraCarga = new JLabel("");
        lblBarraCarga.setIcon(new ImageIcon(MenuCarga.class.getResource("/frames/BarraCarga.png")));
        lblBarraCarga.setBounds(47, 154, 355, 40);
        contentPane.add(lblBarraCarga);

        JLabel lblLogo = new JLabel("");
        lblLogo.setIcon(new ImageIcon(MenuCarga.class.getResource("/frames/WOME.png")));
        lblLogo.setBounds(109, 39, 216, 90);
        contentPane.add(lblLogo);

        JLabel lblBackground = new JLabel("");
        lblBackground.setBounds(0, 0, 444, 271);
        contentPane.add(lblBackground);
        lblBackground.setIcon(new ImageIcon(MenuCarga.class.getResource("/frames/menuBackground.jpg")));
    }

    /**
     * Sets la longitud cargada cargado
     *
     * @param ancho
     *            la longitud de la barra de carga
     */
    public void setBarraCargando(int ancho) {
        barraCargando.setSize(ancho, ALTO_BARRA);
    }
}
