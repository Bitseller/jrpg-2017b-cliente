package mensajeria;

import java.io.Serializable;

/**
 * The Class PaqueteMensaje.
 */
public class PaqueteMensaje extends Paquete implements Serializable, Cloneable {

    private String userEmisor;
    private String userReceptor;
    private String msj;

    /**
     * Instantiates a new paquete mensaje.
     */
    public PaqueteMensaje() {
    }

    @Override
    public String getMensaje() {
        return msj;
    }

    @Override
    public void setMensaje(final String mensaje) {
        this.msj = mensaje;
    }

    /**
     * Gets the user emisor.
     *
     * @return the user emisor
     */
    public String getUserEmisor() {
        return userEmisor;
    }

    /**
     * Sets the user emisor.
     *
     * @param idEmisor
     *            the new user emisor
     */
    public void setUserEmisor(final String idEmisor) {
        this.userEmisor = idEmisor;
    }

    /**
     * Gets the user receptor.
     *
     * @return the user receptor
     */
    public String getUserReceptor() {
        return userReceptor;
    }

    /**
     * Sets the user receptor.
     *
     * @param idReceptor
     *            the new user receptor
     */
    public void setUserReceptor(final String idReceptor) {
        this.userReceptor = idReceptor;
    }

    @Override
    public Object clone() {
        Object obj = null;
        obj = super.clone();
        return obj;
    }
}
