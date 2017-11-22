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
import java.util.HashMap;
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
public class Pantalla {

	private JFrame pantalla;
    private Canvas canvas;

    private Cliente cliente;
    private HashMap<Integer,Runnable> keyMap;
  
    // Menus
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
    public Pantalla (final String nombre, final int ancho, final int alto, final Cliente client) {
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
                    p.setIp(client.getMiIp());
                    client.getSalida().writeObject(gson.toJson(p));
                    client.getEntrada().close();
                    client.getSalida().close();
                    client.getSocket().close();
                    System.exit(0);
                } catch (IOException e) {
                    JOptionPane.showMessageDialog(null, "Fallo al intentar cerrar la aplicación.");
                    System.exit(1);
                }
            }
        });
        
        //para instanciar los menues necesito el cliente.
        this.cliente = client;
        
        //Creo un mapa con los KeyEvent y la interface Runnable que me permite dirigirme a los diferentes menues.
        keyMap = new HashMap<Integer,Runnable>();
        keyMap.put(KeyEvent.VK_I, ()->mostrarMenuInventario());
        keyMap.put(KeyEvent.VK_A, ()->mostrarMenuAsignarSkills());
        keyMap.put(KeyEvent.VK_S, ()->mostrarMenuStats());
        keyMap.put(KeyEvent.VK_ESCAPE, ()->mostrarMenuEscp());
        keyMap.put(KeyEvent.VK_C, ()->mostrarVentanaContactos());
        
        pantalla.addKeyListener(new KeyAdapter() {
            @Override
            public void keyReleased(final KeyEvent e) {
            	if (Estado.getEstado().esEstadoDeJuego() && keyMap.containsKey(e.getKeyCode())) {
            		keyMap.get(e.getKeyCode()).run();
            	}
            }
        });

        pantalla.setLocationRelativeTo(null);
        pantalla.setVisible(false);

        canvas = new Canvas();
        canvas.setPreferredSize(new Dimension(ancho, alto));
        canvas.setMaximumSize(new Dimension(ancho, alto));
        canvas.setMinimumSize(new Dimension(ancho, alto));
        canvas.setFocusable(false);

        pantalla.getContentPane().add(canvas);
        pantalla.pack();
    }

	/**
     * Instancia y muestra menuInventario
     */
    private void mostrarMenuInventario() {
    	if (menuInventario == null) {
    		menuInventario = new MenuInventario(this.cliente);
    		menuInventario.setVisible(true);
    	}else
			menuInventario.requestFocus();
    }
    
    /**
     * Instancia y muestra menuAsignar
     */
    private void mostrarMenuAsignarSkills() {
    	if (menuAsignar == null) {
    		menuAsignar = new MenuAsignarSkills(this.cliente);
    		menuAsignar.setVisible(true);
    	}else
			menuAsignar.requestFocus();
    }
    
    /**
     * Instancia y muestra menuStats
     */
    private void mostrarMenuStats() {
    	if (menuStats == null) {
    		menuStats = new MenuStats(this.cliente);
    			menuStats.setVisible(true);
    	}else
    		menuStats.requestFocus();
    }
    
    /**
     * Instancia y muestra menuEscp
     */
    private void mostrarMenuEscp() {
    	if (menuEscp == null) {
    		menuEscp = new MenuEscape(this.cliente);
    		menuEscp.setVisible(true);
    	}else
			menuEscp.requestFocus();
    }
    
    /**
     * Instancia y muestra ventContac
     */
	private void mostrarVentanaContactos() {
		if (ventContac == null) {
			ventContac = new VentanaContactos(this.cliente);
			ventContac.setVisible(true);
		}else
			ventContac.requestFocus();
	}

	/**
	 * @return the menuInventario
	 */
	public static MenuInventario getMenuInventario() {
		return menuInventario;
	}

	/**
	 * @param menuInventario the menuInventario to set
	 */
	public static void setMenuInventario(final MenuInventario menuInventario) {
		Pantalla.menuInventario = menuInventario;
	}

	/**
	 * @return the menuAsignar
	 */
	public static MenuAsignarSkills getMenuAsignar() {
		return menuAsignar;
	}

	/**
	 * @param menuAsignar the menuAsignar to set
	 */
	public static void setMenuAsignar(final MenuAsignarSkills menuAsignar) {
		Pantalla.menuAsignar = menuAsignar;
	}

	/**
	 * @return the menuStats
	 */
	public static MenuStats getMenuStats() {
		return menuStats;
	}

	/**
	 * @param menuStats the menuStats to set
	 */
	public static void setMenuStats(final MenuStats menuStats) {
		Pantalla.menuStats = menuStats;
	}

	/**
	 * @return the menuEscp
	 */
	public static MenuEscape getMenuEscp() {
		return menuEscp;
	}

	/**
	 * @param menuEscp the menuEscp to set
	 */
	public static void setMenuEscp(final MenuEscape menuEscp) {
		Pantalla.menuEscp = menuEscp;
	}

	/**
	 * @return the ventContac
	 */
	public static VentanaContactos getVentContac() {
		return ventContac;
	}

	/**
	 * @param ventContac the ventContac to set
	 */
	public static void setVentContac(final VentanaContactos ventContac) {
		Pantalla.ventContac = ventContac;
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
}
