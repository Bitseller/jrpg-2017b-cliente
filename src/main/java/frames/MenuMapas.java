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
import javax.swing.WindowConstants;

import cliente.Cliente;
import mensajeria.Comando;

/**
 * The Class MenuMapas.
 */
public class MenuMapas extends JFrame {
    private static int numberMap = 0;
    private JPanel contentPane;

    /**
     * Instantiates a new menu mapas.
     *
     * @param cliente
     *            the cliente
     */
    public MenuMapas(final Cliente cliente) {
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
        setBounds(100, 100, 450, 300);

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
        setSize(450, 300);
        contentPane = new JPanel();
        setContentPane(contentPane);
        contentPane.setLayout(null);
        setLocationRelativeTo(null);
        setResizable(false);

        //Formato de la ventana.
        JLayeredPane layeredPane = new JLayeredPane();
        layeredPane.setSize(450, 300);
        contentPane.add(layeredPane);

        JLabel lblBackground = new JLabel("");
        lblBackground.setIcon(new ImageIcon(MenuMapas.class.getResource("/frames/menuBackground.jpg")));

        // Mapa Aubenor
        //Boton.
        JButton btnAubenor = new JButton("");
        btnAubenor.setFocusable(false);
        btnAubenor.setIcon(new ImageIcon(MenuMapas.class.getResource("/frames/BotonMenu.png")));

        //Formato del boton (etiqueta).
        JLabel lblAubenor = new JLabel("Aubenor");
        layeredPane.setLayer(lblAubenor, 1);
        lblAubenor.setForeground(Color.WHITE);
        lblAubenor.setFont(new Font("Tahoma", Font.PLAIN, 15));

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
        JButton btnAris = new JButton("");
        btnAris.setFocusable(false);
        btnAris.setIcon(new ImageIcon(MenuMapas.class.getResource("/frames/BotonMenu.png")));

        //Formato del boton (etiqueta).
        JLabel lblAris = new JLabel("Aris");
        lblAris.setForeground(Color.WHITE);
        lblAris.setFont(new Font("Tahoma", Font.PLAIN, 15));

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
        JButton btnEodrim = new JButton("");
        btnEodrim.setFocusable(false);
        btnEodrim.setEnabled(false);
        btnEodrim.setIcon(new ImageIcon(MenuMapas.class.getResource("/frames/BotonMenu.png")));

        //Formato del boton (etiqueta).
        JLabel lblEodrim = new JLabel("Eodrim");
        layeredPane.setLayer(lblEodrim, 1);
        lblEodrim.setForeground(Color.WHITE);
        lblEodrim.setFont(new Font("Tahoma", Font.PLAIN, 15));

        //Configuracion del Boton
        btnEodrim.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(final ActionEvent e) {
                synchronized (cliente) {
                    cliente.getPaquetePersonaje().setMapa("Eodrim");
                    numberMap = 3;
                    cliente.notify();
                }
                dispose();
            }
        });

        //Seteo de botones.
        btnAris.setEnabled(true);
        btnAubenor.setEnabled(true);
        btnEodrim.setEnabled(false);
        GroupLayout glLayeredPane = new GroupLayout(layeredPane);
        glLayeredPane.setHorizontalGroup(
            glLayeredPane.createParallelGroup(Alignment.LEADING)
                .addGroup(glLayeredPane.createSequentialGroup()
                    .addGap(148)
                    .addComponent(btnAubenor, GroupLayout.PREFERRED_SIZE, 143, GroupLayout.PREFERRED_SIZE))
                .addGroup(glLayeredPane.createSequentialGroup()
                    .addGap(148)
                    .addComponent(btnEodrim, GroupLayout.PREFERRED_SIZE, 143, GroupLayout.PREFERRED_SIZE))
                .addGroup(glLayeredPane.createSequentialGroup()
                    .addGap(204)
                    .addComponent(lblAris, GroupLayout.PREFERRED_SIZE, 32, GroupLayout.PREFERRED_SIZE))
                .addGroup(glLayeredPane.createSequentialGroup()
                    .addGap(191)
                    .addComponent(lblAubenor, GroupLayout.PREFERRED_SIZE, 66, GroupLayout.PREFERRED_SIZE))
                .addGroup(glLayeredPane.createSequentialGroup()
                    .addGap(198)
                    .addComponent(lblEodrim, GroupLayout.PREFERRED_SIZE, 53, GroupLayout.PREFERRED_SIZE))
                .addGroup(glLayeredPane.createSequentialGroup()
                    .addGap(148)
                    .addComponent(btnAris, GroupLayout.PREFERRED_SIZE, 143, GroupLayout.PREFERRED_SIZE))
                .addComponent(lblBackground, GroupLayout.PREFERRED_SIZE, 444, GroupLayout.PREFERRED_SIZE)
        );
        glLayeredPane.setVerticalGroup(
            glLayeredPane.createParallelGroup(Alignment.LEADING)
                .addGroup(glLayeredPane.createSequentialGroup()
                    .addGap(72)
                    .addComponent(btnAubenor, GroupLayout.PREFERRED_SIZE, 23, GroupLayout.PREFERRED_SIZE)
                    .addGap(97)
                    .addComponent(btnEodrim, GroupLayout.PREFERRED_SIZE, 23, GroupLayout.PREFERRED_SIZE))
                .addGroup(glLayeredPane.createSequentialGroup()
                    .addGap(129)
                    .addComponent(lblAris, GroupLayout.PREFERRED_SIZE, 23, GroupLayout.PREFERRED_SIZE))
                .addGroup(glLayeredPane.createSequentialGroup()
                    .addGap(72)
                    .addComponent(lblAubenor, GroupLayout.PREFERRED_SIZE, 23, GroupLayout.PREFERRED_SIZE))
                .addGroup(glLayeredPane.createSequentialGroup()
                    .addGap(192)
                    .addComponent(lblEodrim, GroupLayout.PREFERRED_SIZE, 23, GroupLayout.PREFERRED_SIZE))
                .addGroup(glLayeredPane.createSequentialGroup()
                    .addGap(130)
                    .addComponent(btnAris, GroupLayout.PREFERRED_SIZE, 23, GroupLayout.PREFERRED_SIZE))
                .addComponent(lblBackground, GroupLayout.PREFERRED_SIZE, 271, GroupLayout.PREFERRED_SIZE)
        );
        layeredPane.setLayout(glLayeredPane);

    }

	/**
	 * @return the numberMap
	 */
	public static int getNumberMap() {
		return numberMap;
	}

	/**
	 * @param numberMap the numberMap to set
	 */
	public static void setNumberMap(int numberMap) {
		MenuMapas.numberMap = numberMap;
	}
  
}
