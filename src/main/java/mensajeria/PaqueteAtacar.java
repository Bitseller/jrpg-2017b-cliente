package mensajeria;

import java.io.Serializable;
import java.util.HashMap;

/**
 * The Class PaqueteAtacar.
 */
public class PaqueteAtacar extends Paquete implements Serializable, Cloneable {

    private int id;
    private int idEnemigo;
    private int nuevaSaludPersonaje;
    private int nuevaEnergiaPersonaje;
    private int nuevaSaludEnemigo;
    private int nuevaEnergiaEnemigo;
    private HashMap<String, Number> mapPersonaje = new HashMap<String, Number>();
    private HashMap<String, Number> mapEnemigo = new HashMap<String, Number>();

    /**
     * Instantiates a new paquete atacar.
     *
     * @param id
     *            the id
     * @param idEnemigo
     *            the id enemigo
     * @param nuevaSalud
     *            the nueva salud
     * @param nuevaEnergia
     *            the nueva energia
     * @param nuevaSaludEnemigo
     *            the nueva salud enemigo
     * @param nuevaEnergiaEnemigo
     *            the nueva energia enemigo
     * @param nuevaDefensa
     *            the nueva defensa
     * @param nuevaDefensaEnemigo
     *            the nueva defensa enemigo
     * @param probEvitarDano
     *            the prob evitar dano
     * @param probEvitarDanoEnemgio
     *            the prob evitar dano enemgio
     */
    public PaqueteAtacar(final int id, final int idEnemigo, final int nuevaSalud, final int nuevaEnergia,
        final int nuevaSaludEnemigo, final int nuevaEnergiaEnemigo, final int nuevaDefensa,
        final int nuevaDefensaEnemigo,
        final double probEvitarDano, final double probEvitarDanoEnemgio) {
        setComando(Comando.ATACAR);
        this.id = id;
        this.idEnemigo = idEnemigo;
        this.nuevaSaludPersonaje = nuevaSalud;
        this.nuevaEnergiaPersonaje = nuevaEnergia;
        this.nuevaSaludEnemigo = nuevaSaludEnemigo;
        this.nuevaEnergiaEnemigo = nuevaEnergiaEnemigo;
        mapPersonaje.put("salud", nuevaSalud);
        mapPersonaje.put("energia", nuevaEnergia);
        mapPersonaje.put("defensa", nuevaDefensa);
        mapPersonaje.put("probEvitarDanio", probEvitarDano);
        mapEnemigo.put("salud", nuevaSaludEnemigo);
        mapEnemigo.put("energia", nuevaEnergiaEnemigo);
        mapEnemigo.put("defensa", nuevaDefensaEnemigo);
        mapEnemigo.put("probEvitarDanio", probEvitarDanoEnemgio);
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
     * Gets the nueva salud personaje.
     *
     * @return the nueva salud personaje
     */
    public int getNuevaSaludPersonaje() {
        return nuevaSaludPersonaje;
    }

    /**
     * Sets the nueva salud personaje.
     *
     * @param nuevaSaludPersonaje
     *            the new nueva salud personaje
     */
    public void setNuevaSaludPersonaje(final int nuevaSaludPersonaje) {
        this.nuevaSaludPersonaje = nuevaSaludPersonaje;
    }

    /**
     * Gets the nueva energia personaje.
     *
     * @return the nueva energia personaje
     */
    public int getNuevaEnergiaPersonaje() {
        return nuevaEnergiaPersonaje;
    }

    /**
     * Sets the nueva energia personaje.
     *
     * @param nuevaEnergiaPersonaje
     *            the new nueva energia personaje
     */
    public void setNuevaEnergiaPersonaje(final int nuevaEnergiaPersonaje) {
        this.nuevaEnergiaPersonaje = nuevaEnergiaPersonaje;
    }

    /**
     * Gets the nueva salud enemigo.
     *
     * @return the nueva salud enemigo
     */
    public int getNuevaSaludEnemigo() {
        return nuevaSaludEnemigo;
    }

    /**
     * Sets the nueva salud enemigo.
     *
     * @param nuevaSaludEnemigo
     *            the new nueva salud enemigo
     */
    public void setNuevaSaludEnemigo(final int nuevaSaludEnemigo) {
        this.nuevaSaludEnemigo = nuevaSaludEnemigo;
    }

    /**
     * Gets the nueva energia enemigo.
     *
     * @return the nueva energia enemigo
     */
    public int getNuevaEnergiaEnemigo() {
        return nuevaEnergiaEnemigo;
    }

    /**
     * Sets the nueva energia enemigo.
     *
     * @param nuevaEnergiaEnemigo
     *            the new nueva energia enemigo
     */
    public void setNuevaEnergiaEnemigo(final int nuevaEnergiaEnemigo) {
        this.nuevaEnergiaEnemigo = nuevaEnergiaEnemigo;
    }

    /**
     * Gets the map personaje.
     *
     * @return the map personaje
     */
    public HashMap<String, Number> getMapPersonaje() {
        return mapPersonaje;
    }

    /**
     * Gets the map enemigo.
     *
     * @return the map enemigo
     */
    public HashMap<String, Number> getMapEnemigo() {
        return mapEnemigo;
    }
}
