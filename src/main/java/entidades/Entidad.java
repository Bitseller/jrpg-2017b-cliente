package entidades;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;

import javax.swing.JOptionPane;

import com.google.gson.Gson;

import chat.VentanaContactos;
import estados.Estado;
import estados.EstadoBatallaNPC;
import frames.MenuEscape;
import frames.MenuInventario;
import interfaz.MenuInfoPersonaje;
import juego.Juego;
import juego.Pantalla;
import mensajeria.PaqueteBatalla;
import mensajeria.PaqueteComerciar;
import mensajeria.PaqueteDeNPC;
import mensajeria.PaqueteMovimiento;
import mundo.Grafo;
import mundo.Mundo;
import mundo.Nodo;
import recursos.Recursos;

/**
 * Clase Entidad.
 */
public class Entidad {

    Juego juego;

    // Tamaño de la entidad
    private int ancho;
    private int alto;

    // Posiciones
    private float x;
    private float y;
    private float dx;
    private float dy;
    private LinkedList<Double> movX;
    private LinkedList<Double> movY;
    private float xInicial;
    private float yInicial;
    private float xFinal;
    private float yFinal;
    private int xOffset;
    private int yOffset;
    private int drawX;
    private int drawY;
    private int[] posMouseRecorrido;
    private int[] posMouse;

    // Movimiento Actual
    private final LinkedList<Integer> movimientos;
    private static final int HORIZONTAL_IZQ = 0;
    private static final int HORIZONTAL_DER = 4;
    private static final int VERTICAL_SUP = 2;
    private static final int DIAGONAL_SUP_IZQ = 1;
    private static final int DIAGONAL_SUP_DER = 3;
    private static final int VERTICAL_INF = 6;
    private static final int DIAGONAL_INF_IZQ = 7;
    private static final int DIAGONAL_INF_DER = 5;
    private int movimientoHacia = 6;
    private boolean enMovimiento;

    // Animaciones
    private final LinkedList<Animacion> patronAnimaciones;
    private final Animacion moverIzq;
    private final Animacion moverDer;
    private final Animacion moverArriba;
    private final Animacion moverArribaIzq;
    private final Animacion moverAbajoDer;
    private final Animacion moverAbajo;
    private final Animacion moverAbajoIzq;
    private final Animacion moverArribaDer;

    private final Gson gson = new Gson();
    private int intervaloEnvio = 0;

    // pila de movimiento
    private PilaDeTiles pilaMovimiento;
    private int[] tileActual;
    private int[] tileFinal;
    private int[] tileMoverme;

    private Mundo mundo;
    private String nombre;
    private int[] tilePersonajes;
    private int idEnemigo;

    // Ubicacion para abrir comerciar.
    private float xComercio;
    private float yComercio;
    private float[] comercio;

    /**
     * Constructor de la clase Entidad.
     *
     * @param juego
     *            juego con el que se instancia Entidad
     * @param mundo
     *            mundo con el que se instancia Entidad
     * @param ancho
     *            ancho
     * @param alto
     *            alto
     * @param nombre
     *            nombre del personaje
     * @param spawnX
     *            tile X donde spawnea
     * @param spawnY
     *            tile Y donde spawnea
     * @param animaciones
     *            animaciones del personaje
     * @param velAnimacion
     *            velocidad de animacion del personaje
     */
    public Entidad(final Juego juego, final Mundo mundo, final int ancho, final int alto, final String nombre,
        final float spawnX, final float spawnY, final LinkedList<BufferedImage[]> animaciones,
        final int velAnimacion) {
        this.juego = juego;
        this.ancho = ancho;
        this.alto = alto;
        this.nombre = nombre;
        this.mundo = mundo;
        xOffset = ancho / 2;
        yOffset = alto / 2;
        x = (int) (spawnX / 64) * 64;
        y = (int) (spawnY / 32) * 32;

        double paso = 1;

        movX = new LinkedList<Double>();
        movY = new LinkedList<Double>();

        // Cargo una lista con los movimientos de dx.
        movX.add(paso * -1);
        movX.add(paso);
        movX.add(paso * 0);
        movX.add(paso * -1);
        movX.add(paso);
        movX.add(paso * 0);
        movX.add(paso * -1);
        movX.add(paso);

        // Cargo una lista con los movimientos de dy.
        movY.add(paso * 0);
        movY.add(paso * 0);
        movY.add(paso * -1);
        movY.add((paso / 2) * -1);
        movY.add((paso / 2) * -1);
        movY.add(paso);
        movY.add(paso / 2);
        movY.add(paso / 2);

        movimientos = new LinkedList<Integer>();
        patronAnimaciones = new LinkedList<Animacion>();

        moverIzq = new Animacion(velAnimacion, animaciones.get(0));
        moverArribaIzq = new Animacion(velAnimacion, animaciones.get(1));
        moverArriba = new Animacion(velAnimacion, animaciones.get(2));
        moverArribaDer = new Animacion(velAnimacion, animaciones.get(3));
        moverDer = new Animacion(velAnimacion, animaciones.get(4));
        moverAbajoDer = new Animacion(velAnimacion, animaciones.get(5));
        moverAbajo = new Animacion(velAnimacion, animaciones.get(6));
        moverAbajoIzq = new Animacion(velAnimacion, animaciones.get(7));

        // Cargo una lista con las animaciones.
        patronAnimaciones.add(moverIzq);
        patronAnimaciones.add(moverDer);
        patronAnimaciones.add(moverArriba);
        patronAnimaciones.add(moverArribaIzq);
        patronAnimaciones.add(moverArribaDer);
        patronAnimaciones.add(moverAbajo);
        patronAnimaciones.add(moverAbajoIzq);
        patronAnimaciones.add(moverAbajoDer);

        // Cargo una lista con los movimientos patrones.
        movimientos.add(HORIZONTAL_IZQ);
        movimientos.add(HORIZONTAL_DER);
        movimientos.add(VERTICAL_SUP);
        movimientos.add(DIAGONAL_SUP_IZQ);
        movimientos.add(DIAGONAL_SUP_DER);
        movimientos.add(VERTICAL_INF);
        movimientos.add(DIAGONAL_INF_IZQ);
        movimientos.add(DIAGONAL_INF_DER);

        // Informo mi posicion actual
        juego.getUbicacionPersonaje().setPosX(x);
        juego.getUbicacionPersonaje().setPosY(y);
        juego.getUbicacionPersonaje().setDireccion(getDireccion());
        juego.getUbicacionPersonaje().setFrame(getFrame());
    }

    /**
     * Actualiza el personaje.
     */
    public void actualizar() {

        if (enMovimiento) {
            for (Animacion patron : patronAnimaciones) {
                patron.actualizar();
            }
        } else {
            for (Animacion patron : patronAnimaciones) {
                patron.reset();
            }
        }

        getEntrada();
        mover();

        juego.getCamara().centrar(this);
    }

    /**
     * Devuelve la entrada.
     *
     * @return the entrada
     */
    public void getEntrada() {
        posMouseRecorrido = juego.getHandlerMouse().getPosMouseRecorrido();
        posMouse = juego.getHandlerMouse().getPosMouse();
        if (juego.getHandlerMouse().getNuevoClick() && posMouse[0] >= 738 && posMouse[0] <= 797 && posMouse[1] >= 545
            && posMouse[1] <= 597) {
            if (Pantalla.menuInventario == null) {
                Pantalla.menuInventario = new MenuInventario(juego.getCliente());
                Pantalla.menuInventario.setVisible(true);
            }
            juego.getHandlerMouse().setNuevoClick(false);
        }
        if (juego.getHandlerMouse().getNuevoClick() && posMouse[0] >= 3 && posMouse[0] <= 105 && posMouse[1] >= 562
            && posMouse[1] <= 597) {
            if (Pantalla.menuEscp == null) {
                Pantalla.menuEscp = new MenuEscape(juego.getCliente());
                Pantalla.menuEscp.setVisible(true);
            }
            juego.getHandlerMouse().setNuevoClick(false);
        }
        if (juego.getHandlerMouse().getNuevoClick() && posMouse[0] >= 3 && posMouse[0] <= 105 && posMouse[1] >= 524
            && posMouse[1] <= 559) {
            if (Pantalla.ventContac == null) {
                Pantalla.ventContac = new VentanaContactos(juego);
                Pantalla.ventContac.setVisible(true);
            }
            juego.getHandlerMouse().setNuevoClick(false);
        }
        // Tomo el click izquierdo
        if (juego.getHandlerMouse().getNuevoClick()) {
            if (juego.getEstadoJuego().getHaySolicitud()) {

                if (juego.getEstadoJuego().getMenuEnemigo().clickEnMenu(posMouse[0], posMouse[1])) {
                    if (juego.getEstadoJuego().getMenuEnemigo().clickEnBoton(posMouse[0], posMouse[1])) {
                        // Pregunto si menuBatallar o menuComerciar, sino no me
                        // interesa hacer esto
                        if (juego.getEstadoJuego().getTipoSolicitud() == MenuInfoPersonaje.MENU_BATALLAR
                            || juego.getEstadoJuego().getTipoSolicitud() == MenuInfoPersonaje.MENU_COMERCIAR) {
                            // Guardo las poss con el que quiero comerciar
                            xComercio = juego.getUbicacionPersonajes().get(idEnemigo).getPosX();
                            yComercio = juego.getUbicacionPersonajes().get(idEnemigo).getPosY();
                            comercio = Mundo.isoA2D(xComercio, yComercio);
                        }
                        // pregunto si el menu emergente es de tipo batalla
                        if (juego.getEstadoJuego().getTipoSolicitud() == MenuInfoPersonaje.MENU_BATALLAR) {
                            // Me fijo si con el que quiero batallar se
                            // encuentre en la zona de comercio.
                            if (!((int) comercio[0] >= 44 && (int) comercio[0] <= 71 && (int) comercio[1] >= 0
                                && (int) comercio[1] <= 29)) {
                                juego.getEstadoJuego().setHaySolicitud(false, null, MenuInfoPersonaje.MENU_BATALLAR);
                                PaqueteBatalla pBatalla = new PaqueteBatalla();

                                pBatalla.setId(juego.getPersonaje().getId());
                                pBatalla.setIdEnemigo(idEnemigo);

                                juego.getEstadoJuego().setHaySolicitud(false, null, MenuInfoPersonaje.MENU_BATALLAR);

                                try {
                                    juego.getCliente().getSalida().writeObject(gson.toJson(pBatalla));
                                } catch (IOException e) {
                                    JOptionPane.showMessageDialog(null, "Fallo la conexión " + "con el servidor");
                                }
                            } else {
                                JOptionPane.showMessageDialog(null,
                                    "El otro usuario se encuentra " + "dentro de la zona de comercio");
                            }
                        } else {
                            // Pregunto si el menu emergente es de tipo
                            // Comercio.
                            if (juego.getEstadoJuego().getTipoSolicitud() == MenuInfoPersonaje.MENU_COMERCIAR) {
                                if ((int) comercio[0] >= 44 && (int) comercio[0] <= 71 && (int) comercio[1] >= 0
                                    && (int) comercio[1] <= 29) {
                                    if (juego.getCliente().getM1() == null) {
                                        juego.getCliente().setPaqueteComercio(new PaqueteComerciar());
                                        juego.getCliente().getPaqueteComercio().setId(juego.getPersonaje().getId());
                                        juego.getCliente().getPaqueteComercio().setIdEnemigo(idEnemigo);

                                        try {
                                            juego.getCliente().getSalida()
                                                .writeObject(gson.toJson(juego.getCliente().getPaqueteComercio()));
                                        } catch (IOException e) {
                                            JOptionPane.showMessageDialog(null,
                                                "Fallo la conexión " + "con el servidor");
                                        }
                                    } else {
                                        JOptionPane.showMessageDialog(null, "Ya te encuentras comerciando!");
                                    }
                                } else {
                                    JOptionPane.showMessageDialog(null,
                                        "El otro usuario no se encuentra " + "dentro de la zona de comercio");
                                }
                            }
                        }
                        juego.getEstadoJuego().setHaySolicitud(false, null, MenuInfoPersonaje.MENU_BATALLAR);

                    } else if (juego.getEstadoJuego().getMenuEnemigo().clickEnCerrar(posMouse[0], posMouse[1])) {
                        juego.getEstadoJuego().setHaySolicitud(false, null, MenuInfoPersonaje.MENU_BATALLAR);
                    }
                } else {
                    juego.getEstadoJuego().setHaySolicitud(false, null, MenuInfoPersonaje.MENU_BATALLAR);
                }
            } else
            // Se fija si clickeo alguno de los personajes
            {
                Iterator<Integer> it = juego.getUbicacionPersonajes().keySet().iterator();
                int key;
                int[] tileMoverme = Mundo.mouseATile(posMouse[0] + juego.getCamara().getxOffset() - xOffset,
                    posMouse[1] + juego.getCamara().getyOffset() - yOffset);
                PaqueteMovimiento actual;

                while (it.hasNext()) {
                    key = it.next();
                    actual = juego.getUbicacionPersonajes().get(key);
                    tilePersonajes = Mundo.mouseATile(actual.getPosX(), actual.getPosY());
                    if (actual != null && actual.getIdPersonaje() != juego.getPersonaje().getId()
                        && juego.getPersonajesConectados().get(actual.getIdPersonaje()) != null
                        && juego.getPersonajesConectados().get(actual.getIdPersonaje())
                            .getEstado() == Estado.estadoJuego) {

                        if (tileMoverme[0] == tilePersonajes[0] && tileMoverme[1] == tilePersonajes[1]) {
                            idEnemigo = actual.getIdPersonaje();
                            float XY[] = Mundo.isoA2D(x, y);
                            // Controlo la posicion para no moverme hasta el
                            // lugar.
                            if (XY[0] >= 44 && XY[0] <= 71 && XY[1] >= 0 && XY[1] <= 29) {
                                // Si me encuentro dentro de la zona de
                                // comercio, abro el menu de Comercio.
                                juego.getEstadoJuego().setHaySolicitud(true,
                                    juego.getPersonajesConectados().get(idEnemigo),
                                    MenuInfoPersonaje.MENU_COMERCIAR);
                            } else {
                                // Si estoy dentro de la zona de batalla, abro
                                // el menu de Batalla.
                                juego.getEstadoJuego().setHaySolicitud(true,
                                    juego.getPersonajesConectados().get(idEnemigo), MenuInfoPersonaje.MENU_BATALLAR);
                            }
                            juego.getHandlerMouse().setNuevoClick(false);
                        }
                    }
                }
            }

        }

        if (juego.getHandlerMouse().getNuevoRecorrido() && !juego.getEstadoJuego().getHaySolicitud()) {

            tileMoverme = Mundo.mouseATile(posMouseRecorrido[0] + juego.getCamara().getxOffset() - xOffset,
                posMouseRecorrido[1] + juego.getCamara().getyOffset() - yOffset);

            juego.getHandlerMouse().setNuevoRecorrido(false);

            pilaMovimiento = null;

            juego.getEstadoJuego().setHaySolicitud(false, null, MenuInfoPersonaje.MENU_BATALLAR);
        }

        if (!enMovimiento && tileMoverme != null) {

            enMovimiento = false;

            tileActual = Mundo.mouseATile(x, y);

            if (tileMoverme[0] < 0 || tileMoverme[1] < 0 || tileMoverme[0] >= mundo.obtenerAncho()
                || tileMoverme[1] >= mundo.obtenerAlto()) {
                enMovimiento = false;
                juego.getHandlerMouse().setNuevoRecorrido(false);
                pilaMovimiento = null;
                tileMoverme = null;
                return;
            }

            if (tileMoverme[0] == tileActual[0] && tileMoverme[1] == tileActual[1]
                || mundo.getTile(tileMoverme[0], tileMoverme[1]).esSolido()) {
                tileMoverme = null;
                enMovimiento = false;
                juego.getHandlerMouse().setNuevoRecorrido(false);
                pilaMovimiento = null;
                return;
            }

            if (pilaMovimiento == null) {
                pilaMovimiento = caminoMasCorto(tileActual[0], tileActual[1], tileMoverme[0], tileMoverme[1]);
            }
            // Me muevo al primero de la pila
            NodoDePila nodoActualTile = pilaMovimiento.pop();

            if (nodoActualTile == null) {
                enMovimiento = false;
                juego.getHandlerMouse().setNuevoRecorrido(false);
                pilaMovimiento = null;
                tileMoverme = null;
                return;
            }

            tileFinal = new int[2];
            tileFinal[0] = nodoActualTile.obtenerX();
            tileFinal[1] = nodoActualTile.obtenerY();

            xFinal = Mundo.dosDaIso(tileFinal[0], tileFinal[1])[0];
            yFinal = Mundo.dosDaIso(tileFinal[0], tileFinal[1])[1];

            if (tileFinal[0] == tileActual[0] - 1 && tileFinal[1] == tileActual[1] - 1) {
                movimientoHacia = VERTICAL_SUP;
            }
            if (tileFinal[0] == tileActual[0] + 1 && tileFinal[1] == tileActual[1] + 1) {
                movimientoHacia = VERTICAL_INF;
            }
            if (tileFinal[0] == tileActual[0] - 1 && tileFinal[1] == tileActual[1] + 1) {
                movimientoHacia = HORIZONTAL_IZQ;
            }
            if (tileFinal[0] == tileActual[0] + 1 && tileFinal[1] == tileActual[1] - 1) {
                movimientoHacia = HORIZONTAL_DER;
            }
            if (tileFinal[0] == tileActual[0] - 1 && tileFinal[1] == tileActual[1]) {
                movimientoHacia = DIAGONAL_SUP_IZQ;
            }
            if (tileFinal[0] == tileActual[0] + 1 && tileFinal[1] == tileActual[1]) {
                movimientoHacia = DIAGONAL_INF_DER;
            }
            if (tileFinal[0] == tileActual[0] && tileFinal[1] == tileActual[1] - 1) {
                movimientoHacia = DIAGONAL_SUP_DER;
            }
            if (tileFinal[0] == tileActual[0] && tileFinal[1] == tileActual[1] + 1) {
                movimientoHacia = DIAGONAL_INF_IZQ;
            }
            enMovimiento = true;
        }
    }

    /**
     * Mueve el personaje.
     */
    public void mover() {

        dx = 0;
        dy = 0;
        int i = 0;

        if (enMovimiento && !(x == xFinal && y == yFinal - 32)) {
            // Si se cumple la condicion busco el movimiento que corresponda.
            while (movimientoHacia != movimientos.get(i)) {
                i++;
            }

            // Realizo la asignacion que corresponda.
            dx += movX.get(i);
            dy += movY.get(i);

            x += dx;
            y += dy;

            // Le envio la posicion
            if (intervaloEnvio == 2) {
                verSiNoEstaCercaDeUnNPC();
                enviarPosicion();
                intervaloEnvio = 0;
            }
            intervaloEnvio++;

            if (x == xFinal && y == yFinal - 32) {
                enMovimiento = false;
            }
        }
    }

    /**
     * Ver si no esta cerca de un NPC.
     */
    private void verSiNoEstaCercaDeUnNPC() {
        if (juego.getNPCs() != null) {
            boolean esPelea = false;

            Map<Integer, PaqueteDeNPC> NPCs;
            NPCs = new HashMap<Integer, PaqueteDeNPC>(juego.getNPCs());
            Map<Integer, PaqueteMovimiento> ubicacionNPCs;
            ubicacionNPCs = new HashMap<Integer, PaqueteMovimiento>(juego.getUbicacionNPCs());

            Iterator<Integer> it = ubicacionNPCs.keySet().iterator();
            int key;
            PaqueteMovimiento actual;

            while (it.hasNext()) {
                key = it.next();
                actual = ubicacionNPCs.get(key);
                if (actual != null) {
                    if (actual.getPosX() - x < 50 && x > -50 && actual.getPosY() - y < 50 && y > -50) {
                        // iniciar pelea

                        PaqueteBatalla pBatalla = new PaqueteBatalla();

                        pBatalla.setId(juego.getPersonaje().getId());
                        pBatalla.setIdEnemigo(key);

                        juego.getPersonaje().setEstado(Estado.estadoBatallaNPC);
                        Estado.setEstado(null);
                        juego.setEstadoBatallaNPC(new EstadoBatallaNPC(juego, pBatalla));
                        Estado.setEstado(juego.getEstadoBatallaNPC());

                        esPelea = true;
                        break;
                    }
                }
            }
        }
    }

    /**
     * Grafica el frame del personaje.
     *
     * @param g
     *            the g
     */
    public void graficar(final Graphics g) {
        drawX = (int) (x - juego.getCamara().getxOffset());
        drawY = (int) (y - juego.getCamara().getyOffset());
        g.drawImage(getFrameAnimacionActual(), drawX, drawY + 4, ancho, alto, null);
    }

    /**
     * Grafica el nombre.
     *
     * @param g
     *            the g
     */
    public void graficarNombre(final Graphics g) {
        g.setColor(Color.WHITE);
        g.setFont(new Font("Book Antiqua", Font.BOLD, 15));
        Pantalla.centerString(g, new java.awt.Rectangle(drawX + 32, drawY - 20, 0, 10), nombre);
    }

    /**
     * Obtiene el frameActual del personaje.
     *
     * @return the frame animacion actual
     */
    private BufferedImage getFrameAnimacionActual() {
        int i = 0;
        while (movimientoHacia != movimientos.get(i) && i < movimientos.size()) {
            i++;
        }
        // Ambas listas entan sincronizadas según sus valores, por lo que el
        // indice i es el mismo para ambas.
        if (i < movimientos.size()) {
            return patronAnimaciones.get(i).getFrameActual();
        }

        return Recursos.orco.get(6)[0];
    }

    /**
     * Pide la direccion donde va.
     *
     * @return devuelve el movimiento hacia donde va
     */
    private int getDireccion() {
        return movimientoHacia;
    }

    /**
     * Obtiene el frame donde esta el personaje.
     *
     * @return the frame
     */
    private int getFrame() {
        int i = 0;
        while (movimientoHacia != movimientos.get(i) && i < movimientos.size()) {
            i++;
        }
        // Ambas listas entan sincronizadas según sus valores, por lo que el
        // indice i es el mismo para ambas.
        if (i < movimientos.size()) {
            return patronAnimaciones.get(i).getFrame();
        }

        return 0;
    }

    /**
     * Envia la posicion del personaje.
     */
    private void enviarPosicion() {
        juego.getUbicacionPersonaje().setPosX(x);
        juego.getUbicacionPersonaje().setPosY(y);
        juego.getUbicacionPersonaje().setDireccion(getDireccion());
        juego.getUbicacionPersonaje().setFrame(getFrame());
        try {
            juego.getCliente().getSalida()
                .writeObject(gson.toJson(juego.getUbicacionPersonaje(), PaqueteMovimiento.class));
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, "Fallo la conexión con el servidor");
        }
    }

    /**
     * Busca el camino más corto a recorrer para llegar a una posición.
     *
     * @param xInicial
     *            ubicacion en X inicial
     * @param yInicial
     *            ubicacion en Y inicial
     * @param xFinal
     *            ubicacion en X final
     * @param yFinal
     *            ubicacion en Y final
     * @return la pila de tiles a recorrer
     */
    private PilaDeTiles caminoMasCorto(final int xInicial, final int yInicial, final int xFinal, final int yFinal) {
        Grafo grafoLibres = mundo.obtenerGrafoDeTilesNoSolidos();
        // Transformo las coordenadas iniciales y finales en indices
        int nodoInicial = (yInicial - grafoLibres.obtenerNodos()[0].obtenerY())
            * (int) Math.sqrt(grafoLibres.obtenerCantidadDeNodosTotal()) + xInicial
            - grafoLibres.obtenerNodos()[0].obtenerX();

        int nodoFinal = (yFinal - grafoLibres.obtenerNodos()[0].obtenerY())
            * (int) Math.sqrt(grafoLibres.obtenerCantidadDeNodosTotal()) + xFinal
            - grafoLibres.obtenerNodos()[0].obtenerX();

        // Hago todo
        double[] vecCostos = new double[grafoLibres.obtenerCantidadDeNodosTotal()];
        int[] vecPredecesores = new int[grafoLibres.obtenerCantidadDeNodosTotal()];
        boolean[] conjSolucion = new boolean[grafoLibres.obtenerCantidadDeNodosTotal()];
        int cantSolucion = 0;
        // Lleno la matriz de costos de numeros grandes
        for (int i = 0; i < grafoLibres.obtenerCantidadDeNodosTotal(); i++) {
            vecCostos[i] = Double.MAX_VALUE;
        }
        // Adyacentes al nodo inicial
        conjSolucion[nodoInicial] = true;
        cantSolucion++;
        vecCostos[nodoInicial] = 0;
        Nodo[] adyacentes = grafoLibres.obtenerNodos()[nodoInicial].obtenerNodosAdyacentes();
        for (int i = 0; i < grafoLibres.obtenerNodos()[nodoInicial].obtenerCantidadDeAdyacentes(); i++) {
            if (estanEnDiagonal(grafoLibres.obtenerNodos()[nodoInicial],
                grafoLibres.obtenerNodos()[adyacentes[i].obtenerIndice()])) {
                vecCostos[adyacentes[i].obtenerIndice()] = 1.5;
            } else {
                vecCostos[adyacentes[i].obtenerIndice()] = 1;
            }
            vecPredecesores[adyacentes[i].obtenerIndice()] = nodoInicial;
        }
        // Aplico Dijkstra
        while (cantSolucion < grafoLibres.obtenerCantidadDeNodosTotal()) {
            // Elijo W perteneciente al conjunto restante tal que el costo de W
            // sea minimo
            double minimo = Double.MAX_VALUE;
            int indiceMinimo = 0;
            Nodo nodoW = null;
            for (int i = 0; i < grafoLibres.obtenerCantidadDeNodosTotal(); i++) {
                if (!conjSolucion[i] && vecCostos[i] < minimo) {
                    nodoW = grafoLibres.obtenerNodos()[i];
                    minimo = vecCostos[i];
                    indiceMinimo = i;
                }
            }
            // Pongo a W en el conj solucion
            conjSolucion[indiceMinimo] = true;
            cantSolucion++;
            // Por cada nodo I adyacente a W del conj restante
            // Le sumo 1 al costo de ir hasta W y luego ir hasta su adyacente
            adyacentes = grafoLibres.obtenerNodos()[indiceMinimo].obtenerNodosAdyacentes();
            for (int i = 0; i < grafoLibres.obtenerNodos()[indiceMinimo].obtenerCantidadDeAdyacentes(); i++) {
                double valorASumar = 1;
                if (estanEnDiagonal(grafoLibres.obtenerNodos()[indiceMinimo],
                    grafoLibres.obtenerNodos()[adyacentes[i].obtenerIndice()])) {
                    valorASumar = 1.5;
                }
                if (vecCostos[indiceMinimo] + valorASumar < vecCostos[adyacentes[i].obtenerIndice()]) {
                    vecCostos[adyacentes[i].obtenerIndice()] = vecCostos[indiceMinimo] + valorASumar;
                    vecPredecesores[adyacentes[i].obtenerIndice()] = indiceMinimo;
                }
            }
        }
        // Creo el vector de nodos hasta donde quiere llegar
        PilaDeTiles camino = new PilaDeTiles();
        while (nodoFinal != nodoInicial) {
            camino.push(new NodoDePila(grafoLibres.obtenerNodos()[nodoFinal].obtenerX(),
                grafoLibres.obtenerNodos()[nodoFinal].obtenerY()));
            nodoFinal = vecPredecesores[nodoFinal];
        }

        return camino;
    }

    /**
     * Pregunta si los personajes estan en diagonal.
     *
     * @param nodoUno
     *            personaje 1
     * @param nodoDos
     *            personaje 2
     * @return true or false
     */
    private boolean estanEnDiagonal(final Nodo nodoUno, final Nodo nodoDos) {

        return (nodoUno.obtenerX() == nodoDos.obtenerX() || nodoUno.obtenerY() == nodoDos.obtenerY());

    }

    /**
     * Pide el valor de X.
     *
     * @return devuelve la ubicacion en X
     */
    public float getX() {
        return x;
    }

    /**
     * Setea el valor de X.
     *
     * @param x
     *            valor nuevo de la ubicacion en X
     */
    public void setX(final float x) {
        this.x = x;
    }

    /**
     * Pide el valor de Y.
     *
     * @return devuelve la ubicacion en Y
     */
    public float getY() {
        return y;
    }

    /**
     * Setea el valor de Y.
     *
     * @param y
     *            valor nuevo de la ubicacion en Y
     */
    public void setY(final float y) {
        this.y = y;
    }

    /**
     * Pide el ancho.
     *
     * @return devuelve el ancho
     */
    public int getAncho() {
        return ancho;
    }

    /**
     * Setea el ancho.
     *
     * @param ancho
     *            nuevo ancho a setear
     */
    public void setAncho(final int ancho) {
        this.ancho = ancho;
    }

    /**
     * Pide el alto.
     *
     * @return devuelve el alto
     */
    public int getAlto() {
        return alto;
    }

    /**
     * Setea el alto.
     *
     * @param alto
     *            nuevo alto a setear
     */
    public void setAlto(final int alto) {
        this.alto = alto;
    }

    /**
     * Pide el offset de X.
     *
     * @return devuelve el offset de X
     */
    public int getxOffset() {
        return xOffset;
    }

    /**
     * Pide el offset de Y.
     *
     * @return devuelve el offset de Y
     */
    public int getYOffset() {
        return yOffset;
    }
}
