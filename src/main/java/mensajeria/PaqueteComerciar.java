package mensajeria;

import java.io.Serializable;
import java.util.ArrayList;

import dominio.Item;

/**
 * The Class PaqueteComerciar.
 */
public class PaqueteComerciar extends Paquete implements Serializable, Cloneable {

    private int id;
    private int idEnemigo;
    private int listo = 0;
    private ArrayList<Item> itemsADar = new ArrayList<Item>();
    private ArrayList<Item> itemsAObtener = new ArrayList<Item>();
    private boolean solicitudDeComercio;

    /**
     * Instantiates a new paquete comerciar.
     */
    public PaqueteComerciar() {
        setComando(Comando.COMERCIO);
        solicitudDeComercio = true;
    }

    /**
     * Checks if is solicitud de comercio.
     *
     * @return true, if is solicitud de comercio
     */
    public boolean isSolicitudDeComercio() {
        return solicitudDeComercio;
    }

    /**
     * Sets the solicitud de comercio.
     *
     * @param solicitudDeComercio
     *            the new solicitud de comercio
     */
    public void setSolicitudDeComercio(final boolean solicitudDeComercio) {
        this.solicitudDeComercio = solicitudDeComercio;
    }

    /**
     * Gets the items A dar.
     *
     * @return the items A dar
     */
    public ArrayList<Item> getItemsADar() {
        return itemsADar;
    }

    /**
     * Sets the items A dar.
     *
     * @param itemsADar
     *            the new items A dar
     */
    public void setItemsADar(final ArrayList<Item> itemsADar) {
        this.itemsADar = itemsADar;
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
     * Gets the listo.
     *
     * @return the listo
     */
    public int getListo() {
        return listo;
    }

    /**
     * Aumentar listo.
     */
    public void aumentarListo() {
        this.listo++;
    }

    /**
     * Disminuir listo.
     */
    public void disminuirListo() {
        this.listo--;
    }

    /**
     * Gets the items A obtener.
     *
     * @return the items A obtener
     */
    public ArrayList<Item> getItemsAObtener() {
        return itemsAObtener;
    }

    /**
     * Sets the items A obtener.
     *
     * @param itemsAObtener
     *            the new items A obtener
     */
    public void setItemsAObtener(final ArrayList<Item> itemsAObtener) {
        this.itemsAObtener = itemsAObtener;
    }
}
