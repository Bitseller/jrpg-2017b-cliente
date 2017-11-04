package mundo;

/**
 * The Class Nodo.
 */
public class Nodo {

    private static final int CANT_CASILLAS_ALRED = 8;
	private int x;
    private int y;
    private int indice;
    private int cantidadDeAdyacentes;
    private Nodo[] nodosAdyacentes;

    /**
     * Instantiates a new nodo.
     *
     * @param indice
     *            the indice
     * @param x
     *            pos x
     * @param y
     *            pos y
     */
    public Nodo(final int indice, final int x, final int y) {
        this.x = x;
        this.y = y;
        this.indice = indice;
        cantidadDeAdyacentes = 0;
        nodosAdyacentes = new Nodo[CANT_CASILLAS_ALRED];
    }

    /**
     * Obtener X.
     *
     * @return pos x
     */
    public int obtenerX() {
        return x;
    }

    /**
     * Obtener Y.
     *
     * @return pos y
     */
    public int obtenerY() {
        return y;
    }

    /**
     * Obtener indice.
     *
     * @return indice
     */
    public int obtenerIndice() {
        return indice;
    }

    /**
     * Obtener nodos adyacentes.
     *
     * @return nodos adyacentes
     */
    public Nodo[] obtenerNodosAdyacentes() {
        return nodosAdyacentes;
    }

    /**
     * Agregar adyacente.
     *
     * @param nodo
     *            un nodo
     */
    public void agregarAdyacente(final Nodo nodo) {
        nodosAdyacentes[cantidadDeAdyacentes++] = nodo;
    }

    /**
     * Obtener cantidad de adyacentes.
     *
     * @return cantidad de adyacentes.
     */
    public int obtenerCantidadDeAdyacentes() {
        return cantidadDeAdyacentes;
    }
}
