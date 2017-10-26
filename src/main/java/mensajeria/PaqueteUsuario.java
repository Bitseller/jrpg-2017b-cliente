package mensajeria;

import java.io.Serializable;

/**
 * The Class PaqueteUsuario.
 */
public class PaqueteUsuario extends Paquete implements Serializable, Cloneable {

    private int idPj;
    private String username;
    private String password;
    private boolean inicioSesion;

    /**
     * Instantiates a new paquete usuario.
     */
    public PaqueteUsuario() {

    }

    /**
     * Instantiates a new paquete usuario.
     *
     * @param pj
     *            ID
     * @param user
     *            usuario
     * @param pw
     *            contraseña
     */
    public PaqueteUsuario(final int pj, final String user, final String pw) {
        idPj = pj;
        username = user;
        password = pw;
        inicioSesion = false;
    }

    /**
     * Gets the id personaje.
     *
     * @return ID
     */
    public int getIdPj() {
        return idPj;
    }

    /**
     * Sets the id personaje.
     *
     * @param idPj
     *            ID
     */
    public void setIdPj(final int idPj) {
        this.idPj = idPj;
    }

    /**
     * Gets the username.
     *
     * @return the username
     */
    public String getUsername() {
        return username;
    }

    /**
     * Sets the username.
     *
     * @param username
     *            the new username
     */
    public void setUsername(final String username) {
        this.username = username;
    }

    /**
     * Gets the password.
     *
     * @return the password
     */
    public String getPassword() {
        return password;
    }

    /**
     * Sets the password.
     *
     * @param password
     *            the new password
     */
    public void setPassword(final String password) {
        this.password = password;
    }

    /**
     * Checks if is inicio sesion.
     *
     * @return true, if is inicio sesion
     */
    public boolean isInicioSesion() {
        return inicioSesion;
    }

    /**
     * Sets the inicio sesion.
     *
     * @param inicioSesion
     *            boolean
     */
    public void setInicioSesion(final boolean inicioSesion) {
        this.inicioSesion = inicioSesion;
    }

    @Override
    public Object clone() {
        Object obj = null;
        obj = super.clone();
        return obj;
    }
}
