package mensajeria;

import java.util.ArrayList;

import dominio.Item;

/**
 * The Class PaqueteDeNPC.
 */
public class PaqueteDeNPC {
    private static final int NIVEL_INICIAL = 1;
    private static final int FUERZA_INICIAL = 50;
    private static final int ENERGIA_MAXIMA = 20;
    private static final int SALUD_MAXIMA = 100;
    private int id;
    private int idMapa;
    private String nombre;
    private int saludTope;
    private int energiaTope;
    private int fuerza;
    private int nivel;
    private ArrayList<Item> items = new ArrayList<Item>();

    /**
     * Instantiates a new paquete de NPC.
     *
     * @param id
     *            the id
     */
    public PaqueteDeNPC(final int id) {
        super();
        this.id = id;
        idMapa = 1;
        nombre = "enemigo";
        saludTope = SALUD_MAXIMA;
        energiaTope = ENERGIA_MAXIMA;
        fuerza = FUERZA_INICIAL;
        nivel = NIVEL_INICIAL;
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
     * Gets the id mapa.
     *
     * @return the id mapa
     */
    public int getIdMapa() {
        return idMapa;
    }

    /**
     * Sets the id mapa.
     *
     * @param idMapa
     *            the new id mapa
     */
    public void setIdMapa(final int idMapa) {
        this.idMapa = idMapa;
    }

    /**
     * Gets the nombre.
     *
     * @return the nombre
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * Sets the nombre.
     *
     * @param nombre
     *            the new nombre
     */
    public void setNombre(final String nombre) {
        this.nombre = nombre;
    }

    /**
     * Gets the salud tope.
     *
     * @return the salud tope
     */
    public int getSaludTope() {
        return saludTope;
    }

    /**
     * Sets the salud tope.
     *
     * @param saludTope
     *            the new salud tope
     */
    public void setSaludTope(final int saludTope) {
        this.saludTope = saludTope;
    }

    /**
     * Gets the energia tope.
     *
     * @return the energia tope
     */
    public int getEnergiaTope() {
        return energiaTope;
    }

    /**
     * Sets the energia tope.
     *
     * @param energiaTope
     *            the new energia tope
     */
    public void setEnergiaTope(final int energiaTope) {
        this.energiaTope = energiaTope;
    }

    /**
     * Gets the fuerza.
     *
     * @return the fuerza
     */
    public int getFuerza() {
        return fuerza;
    }

    /**
     * Sets the fuerza.
     *
     * @param fuerza
     *            the new fuerza
     */
    public void setFuerza(final int fuerza) {
        this.fuerza = fuerza;
    }

    /**
     * Gets the nivel.
     *
     * @return the nivel
     */
    public int getNivel() {
        return nivel;
    }

    /**
     * Sets the nivel.
     *
     * @param nivel
     *            the new nivel
     */
    public void setNivel(final int nivel) {
        this.nivel = nivel;
    }

    /**
     * Gets the items.
     *
     * @return the items
     */
    public ArrayList<Item> getItems() {
        return items;
    }

    /**
     * Sets the items.
     *
     * @param items
     *            the new items
     */
    public void setItems(ArrayList<Item> items) {
        this.items = items;
    }
}
