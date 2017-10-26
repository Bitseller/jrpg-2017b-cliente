package recursos;

import java.awt.image.BufferedImage;

/**
 * The Class SpriteSheet.
 */
public class SpriteSheet {

    private BufferedImage sprite;

    /**
     * Instantiates a new sprite sheet.
     *
     * @param sprite
     *            the sprite
     */
    public SpriteSheet(final BufferedImage sprite) {
        this.sprite = sprite;
    }

    /**
     * Gets the tile.
     *
     * @param x
     *            pos x
     * @param y
     *            pos y
     * @param ancho
     *            el ancho
     * @param alto
     *            el alto
     * @return the tile
     */
    public BufferedImage getTile(final int x, final int y, final int ancho, final int alto) {
        return sprite.getSubimage(x, y, ancho, alto);
    }
}
