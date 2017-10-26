package mensajeria;

import java.io.Serializable;

/**
 * The Class PaqueteFinalizarBatalla.
 */
public class PaqueteFinalizarBatalla extends Paquete implements Serializable, Cloneable {

    private int id;
    private int idEnemigo;
    private int ganadorBatalla;

    /**
     * Instantiates a new paquete finalizar batalla.
     */
    public PaqueteFinalizarBatalla() {
        setComando(Comando.FINALIZARBATALLA);
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
     * Gets the ganador batalla.
     *
     * @return the ganador batalla
     */
    public int getGanadorBatalla() {
        return ganadorBatalla;
    }

    /**
     * Sets the ganador batalla.
     *
     * @param ganadorBatalla
     *            the new ganador batalla
     */
    public void setGanadorBatalla(final int ganadorBatalla) {
        this.ganadorBatalla = ganadorBatalla;
    }
}
