package mundo;

import java.awt.Graphics;
import java.awt.image.BufferedImage;

/**
 * The Class Tile.
 */
public class Tile {

    private static final int BASE_AUBENOR = 3;
	private static final int BASE_ARIS = 3;
	private static final int TAM_VEC_TILE = 256;
	private static Tile[] tiles = new Tile[TAM_VEC_TILE];
    private static Tile[] aubenor;
    private static Tile[] aris;
    // es el piso de aubenor por defecto si queres llamarlo asi, es gris
    private static int arisBase = BASE_ARIS;
    private static int aubenorBase = BASE_AUBENOR;

    public static final int ANCHO = 64;
    public static final int ALTO = 32;

    private BufferedImage textura;
    private final int id;

    private boolean esSolido;

    private int ancho;
    private int alto;

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
	public static void setTiles(final Tile[] tiles) {
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
	public static void setAubenor(final Tile[] aubenor) {
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
	public static void setAris(final Tile[] aris) {
		Tile.aris = aris;
	}


	/**
	 * @return the arisBase
	 */
	public static int getArisBase() {
		return arisBase;
	}


	/**
	 * @param arisBase the arisBase to set
	 */
	public static void setArisBase(final int arisBase) {
		Tile.arisBase = arisBase;
	}


	/**
	 * @return the aubenorBase
	 */
	public static int getAubenorBase() {
		return aubenorBase;
	}


	/**
	 * @param aubenorBase the aubenorBase to set
	 */
	public static void setAubenorBase(final int aubenorBase) {
		Tile.aubenorBase = aubenorBase;
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
	public void setTextura(final BufferedImage textura) {
		this.textura = textura;
	}


	/**
	 * @param ancho the ancho to set
	 */
	public void setAncho(final int ancho) {
		this.ancho = ancho;
	}


	/**
	 * @param alto the alto to set
	 */
	public void setAlto(final int alto) {
		this.alto = alto;
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
     * Sets the solido.
     *
     * @param solidez
     *            si e solido o no
     */
    public void setSolido(final boolean solidez) {
        esSolido = solidez;
    }

    /**
     * Es solido.
     *
     * @return true, if successful
     */
    public boolean esSolido() {
        return esSolido;
    }

    /**
     * Gets the id.
     *
     * @return the id
     */
    public int getId() {
        return id;
    }

    /**
     * Gets the ancho.
     *
     * @return the ancho
     */
    public int getAncho() {
        return ancho;
    }

    /**
     * Gets the alto.
     *
     * @return the alto
     */
    public int getAlto() {
        return alto;
    }

}
