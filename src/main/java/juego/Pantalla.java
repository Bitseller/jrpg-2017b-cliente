package juego;

import java.awt.Canvas;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.Toolkit;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.font.FontRenderContext;
import java.awt.geom.Rectangle2D;
import java.io.IOException;
import java.util.LinkedList;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.WindowConstants;

import com.google.gson.Gson;

import chat.VentanaContactos;
import cliente.Cliente;
import estados.Estado;
import frames.MenuAsignarSkills;
import frames.MenuEscape;
import frames.MenuInventario;
import frames.MenuJugar;
import frames.MenuStats;
import mensajeria.Comando;
import mensajeria.Paquete;

/**
 * The Class Pantalla.
 */
/**
 * @author ARIEL
 *
 */
public class Pantalla {

    private JFrame pantalla;
    private Canvas canvas;

    private final LinkedList<Integer> keys;

    // Menus
    private static LinkedList<JFrame> menues;
    private static MenuInventario menuInventario;
    private static MenuAsignarSkills menuAsignar;
    private static MenuStats menuStats;
    private static MenuEscape menuEscp;
    private static VentanaContactos ventContac;

    private final Gson gson = new Gson();

    /**
     * Instantiates a new pantalla.
     *
     * @param nombre
     *            the nombre
     * @param ancho
     *            the ancho
     * @param alto
     *            the alto
     * @param cliente
     *            the cliente
     */
    public Pantalla(final String nombre, final int ancho, final int alto, final Cliente cliente) {

        pantalla = new JFrame(nombre);
        pantalla.setIconImage(Toolkit.getDefaultToolkit().getImage("src/main/java/frames/IconoWome.png"));
        pantalla.setCursor(Toolkit.getDefaultToolkit().createCustomCursor(
            new ImageIcon(MenuJugar.class.getResource("/cursor.png")).getImage(), new Point(0, 0),
            "custom cursor"));

        pantalla.setSize(ancho, alto);
        pantalla.setResizable(false);
        pantalla.setDefaultCloseOperation(WindowConstants.DO_NOTHING_ON_CLOSE);
        pantalla.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(final WindowEvent evt) {
                try {
                    Paquete p = new Paquete();
                    p.setComando(Comando.DESCONECTAR);
                    p.setIp(cliente.getMiIp());
                    cliente.getSalida().writeObject(gson.toJson(p));
                    cliente.getEntrada().close();
                    cliente.getSalida().close();
                    cliente.getSocket().close();
                    System.exit(0);
                } catch (IOException e) {
                    JOptionPane.showMessageDialog(null, "Fallo al intentar cerrar la aplicación.");
                    System.exit(1);
                }
            }
        });

        keys = new LinkedList<Integer>();
        // Cargo los KeyEvents en una lista
        keys.add(KeyEvent.VK_I);
        keys.add(KeyEvent.VK_A);
        keys.add(KeyEvent.VK_S);
        keys.add(KeyEvent.VK_ESCAPE);
        keys.add(KeyEvent.VK_C);

        menues = new LinkedList<JFrame>();
        // Cargo los menues en una lista
        menues.add(menuInventario);
        menues.add(menuAsignar);
        menues.add(menuStats);
        menues.add(menuEscp);
        menues.add(ventContac);

        pantalla.addKeyListener(new KeyAdapter() {
            @Override
            public void keyReleased(final KeyEvent e) {

                int i = 0;

                while (i < keys.size() && e.getKeyCode() != keys.get(i)) {
                    i++;
                }

                if (i < keys.size()) {

                    //Como se que ambas listas estan sincronizadas,
                    //el mismo indice me indica que menu es el que debo verificar.
                    if (Estado.getEstado().esEstadoDeJuego() && menues.get(i) == null) {
                        switch (i) {
                            case 1:
                                menuInventario = new MenuInventario(cliente);
                                break;
                            case 2:
                                menuAsignar = new MenuAsignarSkills(cliente);
                                break;
                            case 3:
                                menuStats = new MenuStats(cliente);
                                break;
                            case 4:
                                menuEscp = new MenuEscape(cliente);
                                break;
                            default:
                                break;
                        }
                    }
                } else {
                    ventContac = new VentanaContactos(cliente.getJuego());
                }

                menues.get(i).setVisible(true);

            }
        });

        pantalla.setLocationRelativeTo(null);
        pantalla.setVisible(false);

        canvas = new Canvas();
        canvas.setPreferredSize(new Dimension(ancho, alto));
        canvas.setMaximumSize(new Dimension(ancho, alto));
        canvas.setMinimumSize(new Dimension(ancho, alto));
        canvas.setFocusable(false);

        pantalla.add(canvas);
        pantalla.pack();
    }

    /**
     * Gets the canvas.
     *
     * @return the canvas
     */
    public Canvas getCanvas() {
        return canvas;
    }

    /**
     * Gets the frame.
     *
     * @return the frame
     */
    public JFrame getFrame() {
        return pantalla;
    }

    /**
     * Mostrar la pantalla
     */
    public void mostrar() {
        pantalla.setVisible(true);
    }

    /**
     * Center string en pantalla
     *
     * @param g
     *            grafico
     * @param r
     *            rectangulo
     * @param s
     *            string
     */
    public static void centerString(final Graphics g, final Rectangle r, final String s) {
        FontRenderContext frc = new FontRenderContext(null, true, true);

        Rectangle2D r2D = g.getFont().getStringBounds(s, frc);
        int rWidth = (int) Math.round(r2D.getWidth());
        int rHeight = (int) Math.round(r2D.getHeight());
        int rX = (int) Math.round(r2D.getX());
        int rY = (int) Math.round(r2D.getY());

        int a = (r.width / 2) - (rWidth / 2) - rX;
        int b = (r.height / 2) - (rHeight / 2) - rY;

        g.drawString(s, r.x + a, r.y + b);
    }

    /**
     *
     * @return menues
     */
	public static LinkedList<JFrame> getMenues() {
		return menues;
	}

	/**
	 *
	 * @param menues
	 */
	public static void setMenues(final LinkedList<JFrame> menues) {
		Pantalla.menues = menues;
	}

	/**
	 *
	 * @return menuInventario
	 */
	public static MenuInventario getMenuInventario() {
		return menuInventario;
	}

	/**
	 *
	 * @param menuInventario
	 */
	public static void setMenuInventario(final MenuInventario menuInventario) {
		Pantalla.menuInventario = menuInventario;
	}

	/**
	 *
	 * @return menuAsignar
	 */
	public static MenuAsignarSkills getMenuAsignar() {
		return menuAsignar;
	}

	/**
	 *
	 * @param menuAsignar
	 */
	public static void setMenuAsignar(final MenuAsignarSkills menuAsignar) {
		Pantalla.menuAsignar = menuAsignar;
	}

	/**
	 *
	 * @return menuStats
	 */
	public static MenuStats getMenuStats() {
		return menuStats;
	}

	/**
	 *
	 * @param menuStats
	 */
	public static void setMenuStats(final MenuStats menuStats) {
		Pantalla.menuStats = menuStats;
	}

	/**
	 *
	 * @return menuEscp
	 */
	public static MenuEscape getMenuEscp() {
		return menuEscp;
	}

	/**
	 *
	 * @param menuEscp
	 */
	public static void setMenuEscp(final MenuEscape menuEscp) {
		Pantalla.menuEscp = menuEscp;
	}

	/**
	 *
	 * @return ventContac
	 */
	public static VentanaContactos getVentContac() {
		return ventContac;
	}
	
	/**
	 *
	 * @param ventContac
	 */
	public static void setVentContac(final VentanaContactos ventContac) {
		Pantalla.ventContac = ventContac;
	}
}
