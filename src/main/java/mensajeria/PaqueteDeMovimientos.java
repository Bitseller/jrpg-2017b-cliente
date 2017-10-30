package mensajeria;

import java.io.Serializable;
import java.util.Map;

/**
 * The Class PaqueteDeMovimientos.
 */
public class PaqueteDeMovimientos extends Paquete implements Serializable, Cloneable {

    private Map<Integer, PaqueteMovimiento> personajes;

    /**
     * Instantiates a new paquete de movimientos.
     */
    public PaqueteDeMovimientos() {

    }

    /**
     * Instantiates a new paquete de movimientos.
     *
     * @param personajes
     *            the personajes
     */
    public PaqueteDeMovimientos(final Map<Integer, PaqueteMovimiento> personajes) {
        this.personajes = personajes;
    }

    /**
     * Gets the personajes.
     *
     * @return the personajes
     */
    public Map<Integer, PaqueteMovimiento> getPersonajes() {
        return personajes;
    }

    @Override
    public Object clone() {
        Object obj = null;
        obj = super.clone();
        return obj;
    }

}
