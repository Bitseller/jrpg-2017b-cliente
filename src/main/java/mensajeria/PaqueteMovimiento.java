package mensajeria;

import java.io.Serializable;

/**
 * The Class PaqueteMovimiento.
 */
public class PaqueteMovimiento extends Paquete implements Serializable, Cloneable {

    private int id;
    private float posX;
    private float posY;
    private int direccion;
    private int frame;

    /**
     * Instantiates a new paquete movimiento.
     */
    public PaqueteMovimiento() {
        setComando(Comando.MOVIMIENTO);
    }

    /**
     * Instantiates a new paquete movimiento.
     *
     * @param idPersonaje
     *            the id personaje
     */
    public PaqueteMovimiento(final int idPersonaje) {
        id = idPersonaje;
        setComando(Comando.MOVIMIENTO);
    }

    /**
     * Instantiates a new paquete movimiento.
     *
     * @param idPersonaje
     *            the id personaje
     * @param posX
     *            the pos X
     * @param posY
     *            the pos Y
     */
    public PaqueteMovimiento(final int idPersonaje, final float posX, final float posY) {
        this.id = idPersonaje;
        this.posX = posX;
        this.posY = posY;
        setComando(Comando.MOVIMIENTO);
    }

    /**
     * Gets the id personaje.
     *
     * @return the id personaje
     */
    public int getIdPersonaje() {
        return id;
    }

    /**
     * Sets the id personaje.
     *
     * @param idPersonaje
     *            the new id personaje
     */
    public void setIdPersonaje(final int idPersonaje) {
        this.id = idPersonaje;
    }

    /**
     * Gets the pos X.
     *
     * @return the pos X
     */
    public float getPosX() {
        return posX;
    }

    /**
     * Sets the pos X.
     *
     * @param posX
     *            the new pos X
     */
    public void setPosX(final float posX) {
        this.posX = posX;
    }

    /**
     * Gets the pos Y.
     *
     * @return the pos Y
     */
    public float getPosY() {
        return posY;
    }

    /**
     * Sets the pos Y.
     *
     * @param posY
     *            the new pos Y
     */
    public void setPosY(final float posY) {
        this.posY = posY;
    }

    /**
     * Gets the direccion.
     *
     * @return the direccion
     */
    public int getDireccion() {
        return direccion;
    }

    /**
     * Sets the direccion.
     *
     * @param direccion
     *            the new direccion
     */
    public void setDireccion(final int direccion) {
        this.direccion = direccion;
    }

    /**
     * Gets the frame.
     *
     * @return the frame
     */
    public int getFrame() {
        return frame;
    }

    /**
     * Sets the frame.
     *
     * @param frame
     *            the new frame
     */
    public void setFrame(final int frame) {
        this.frame = frame;
    }

    @Override
    public Object clone() {
        Object obj = null;
        obj = super.clone();
        return obj;
    }
}
