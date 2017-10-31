package mundo;

import java.awt.Graphics;
import java.awt.image.BufferedImage;

/**
 * The Class Tile.
 */
public class Tile {

    private static Tile[] tiles = new Tile[256];
    private static Tile[] aubenor;
    private static Tile[] aris;
    // es el piso de aubenor por defecto si queres llamarlo asi, es gris
    private static final int arisBase = 3;
    private static final int aubenorBase = 3;
    public static final int ANCHO = 64;
    public static final int ALTO = 32;
    private BufferedImage textura;
    private final int id;
    private final boolean esSolido;
    private final int ancho;
    private final int alto;
    /**
     * Instantiates a new tile.
     *
     * @param textura
     *            the textura
     * @param id
     *            the id
     * @param esSolido
     *            the es solido
     */
    public Tile(final BufferedImage textura, final int id, final boolean esSolido) {
        this.textura = textura;
        this.id = id;
        tiles[id] = this;
        this.esSolido = esSolido;
        this.alto = 0;
        this.ancho = 0;
    }
    /**
     * Instantiates a new tile.
     *
     * @param textura
     *            the textura
     * @param id
     *            the id
     * @param esSolido
     *            the es solido
     * @param ancho
     *            the ancho
     * @param alto
     *            the alto
     */
    public Tile(final BufferedImage textura, final int id, final boolean esSolido, final int ancho, final int alto) {
        this.textura = textura;
        this.id = id;
        tiles[id] = this;
        this.ancho = ancho;
        this.alto = alto;
        this.esSolido = esSolido;
    }
    /**
     * Actualizar el tile
     */
    public void actualizar() {

    }
    /**
     * Grafica el tile
     *
     * @param g
     *            grafico
     * @param x
     *            pos x
     * @param y
     *            pos y
     */
    public void graficar(final Graphics g, final int x, final int y) {
        g.drawImage(textura, x, y, ANCHO, ALTO, null);
    }
    /**
     * Graficar.
     *
     * @param g
     *            grafico
     * @param x
     *            pos x
     * @param y
     *            pos y
     * @param width
     *            ancho
     * @param height
     *            alto
     */
    public void graficar(final Graphics g, final int x, final int y, final int width, final int height) {
        g.drawImage(textura, x, y, width, height, null);
    }
	/**
	 * @return the tiles
	 */
	public static Tile[] getTiles() {
		return tiles;
	}
	/**
	 * @param tiles the tiles to set
	 */
	public static void setTiles(Tile[] tiles) {
		Tile.tiles = tiles;
	}
	/**
	 * @return the aubenor
	 */
	public static Tile[] getAubenor() {
		return aubenor;
	}
	/**
	 * @param aubenor the aubenor to set
	 */
	public static void setAubenor(Tile[] aubenor) {
		Tile.aubenor = aubenor;
	}
	/**
	 * @return the aris
	 */
	public static Tile[] getAris() {
		return aris;
	}
	/**
	 * @param aris the aris to set
	 */
	public static void setAris(Tile[] aris) {
		Tile.aris = aris;
	}
	/**
	 * @return the textura
	 */
	public BufferedImage getTextura() {
		return textura;
	}
	/**
	 * @param textura the textura to set
	 */
	public void setTextura(BufferedImage textura) {
		this.textura = textura;
	}
	/**
	 * @return the ancho
	 */
	public int getAncho() {
		return ancho;
	}
	/**
	 * @return the alto
	 */
	public int getAlto() {
		return alto;
	}
	/**
	 * @return the esSolido
	 */
	public boolean isEsSolido() {
		return esSolido;
	}
	/**
	 * @return the arisbase
	 */
	public static int getArisbase() {
		return arisBase;
	}
	/**
	 * @return the aubenorbase
	 */
	public static int getAubenorbase() {
		return aubenorBase;
	}
	/**
	 * @return the id
	 */
	public int getId() {
		return id;
	}
}
