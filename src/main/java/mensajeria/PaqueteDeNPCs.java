package mensajeria;

import java.io.Serializable;
import java.util.Map;

/**
 * The Class PaqueteDeNPCs.
 */
public class PaqueteDeNPCs extends Paquete implements Serializable, Cloneable {

    private Map<Integer, PaqueteDeNPC> NPCs;

    /**
     * Instantiates a new paquete de NPcs.
     */
    public PaqueteDeNPCs() {

    }

    /**
     * Instantiates a new paquete de NPcs.
     *
     * @param NPCs
     *            el paquete de NPcs
     */
    public PaqueteDeNPCs(final Map<Integer, PaqueteDeNPC> NPCs) {
        this.NPCs = NPCs;
    }

    /**
     * Gets the NPcs.
     *
     * @return the NPcs
     */
    public Map<Integer, PaqueteDeNPC> getNPCs() {
        return NPCs;
    }

    @Override
    public Object clone() {
        Object obj = null;
        obj = super.clone();
        return obj;
    }
}
