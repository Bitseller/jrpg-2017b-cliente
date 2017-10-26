package mensajeria;

import java.io.Serializable;

/**
 * The Class PaqueteBatalla.
 */
public class PaqueteBatalla extends Paquete implements Serializable, Cloneable {

    private int id;
    private int idEnemigo;
    private boolean miTurno;

    /**
     * Instantiates a new paquete batalla.
     */
    public PaqueteBatalla() {
        setComando(Comando.BATALLA);
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
     * Sets the id.
     *
     * @param id
     *            the new id
     */
    public void setId(final int id) {
        this.id = id;
    }

    /**
     * Gets the id enemigo.
     *
     * @return the id enemigo
     */
    public int getIdEnemigo() {
        return idEnemigo;
    }

    /**
     * Sets the id enemigo.
     *
     * @param idEnemigo
     *            the new id enemigo
     */
    public void setIdEnemigo(final int idEnemigo) {
        this.idEnemigo = idEnemigo;
    }

    /**
     * Checks if is mi turno.
     *
     * @return true, if is mi turno
     */
    public boolean isMiTurno() {
        return miTurno;
    }

    /**
     * Sets the mi turno.
     *
     * @param miTurno
     *            the new mi turno
     */
    public void setMiTurno(final boolean miTurno) {
        this.miTurno = miTurno;
    }
}
