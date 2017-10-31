package mensajeria;

import java.io.Serializable;
import java.util.Map;

/**
 * The Class PaqueteDePersonajes.
 */
public class PaqueteDePersonajes extends Paquete implements Serializable, Cloneable {

    private Map<Integer, PaquetePersonaje> personajes;

    /**
     * Instantiates a new paquete de personajes.
     */
    public PaqueteDePersonajes() {

    }

    /**
     * Instantiates a new paquete de personajes.
     *
     * @param personajes
     *            the personajes
     */
    public PaqueteDePersonajes(final Map<Integer, PaquetePersonaje> personajes) {
        this.personajes = personajes;
    }

    /**
     * Gets the personajes.
     *
     * @return the personajes
     */
    public Map<Integer, PaquetePersonaje> getPersonajes() {
        return personajes;
    }

    @Override
    public Object clone() {
        Object obj = null;
        obj = super.clone();
        return obj;
    }

}
