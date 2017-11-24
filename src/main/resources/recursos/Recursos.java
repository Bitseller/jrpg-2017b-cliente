package recursos;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

import javax.imageio.ImageIO;

import frames.MenuCarga;
import frames.MenuMapas;
import mundo.Tile;

/**
 * The Class Recursos.
 */
public final class Recursos {

    private static final int GRAN_SESENTAYCUATRO = 64;
	private static final int BIG_TEN = 10;
	private static final int BIG_EIGHT = 8;
	private static final int MAGIC_TILENUMBER = 81;
	private static final int GREEN_TREE_W = 50;
	private static final int GREEN_TREE_H = 42;
	private static final int BIG_SEVEN = 7;
	private static final int BIG_SIX = 6;
	private static final int BIG_FIVE = 5;
	private static final int BIG_THREE = 3;
	private static final int FRAMES = 4;
    //private static final int ELEMENTOS = 65;
	private static final int ELEMENTOS = 190;
    private static final int ANCHOBARRA = 345;

    private static final int ANCHO = 256; // Ancho del frame a obtener
    private static final int ALTO = 256; // Alto del frame a obtener

    // Inicio Personajes
    // Hash de imagenes para los personajes (humano, ogro, elfo)
    private static Map<String, LinkedList<BufferedImage[]>> personaje = new HashMap<>();

    private static SpriteSheet spriteHumano;
    private static LinkedList<BufferedImage[]> humano = new LinkedList<>();
    private static BufferedImage[] humanoIzq;
    private static BufferedImage[] humanoArribaIzq;
    private static BufferedImage[] humanoArriba;
    private static BufferedImage[] humanoArribaDer;
    private static BufferedImage[] humanoDer;
    private static BufferedImage[] humanoAbajoDer;
    private static BufferedImage[] humanoAbajo;
    private static BufferedImage[] humanoAbajoIzq;
	
    //CheatsSprite Humano
    //God Mode
    private static SpriteSheet spriteHumanoG;
    private static LinkedList<BufferedImage[]> humanoG = new LinkedList<>();
    private static BufferedImage[] humanoIzqG;
    private static BufferedImage[] humanoArribaIzqG;
    private static BufferedImage[] humanoArribaG;
    private static BufferedImage[] humanoArribaDerG;
    private static BufferedImage[] humanoDerG;
    private static BufferedImage[] humanoAbajoDerG;
    private static BufferedImage[] humanoAbajoG;
    private static BufferedImage[] humanoAbajoIzqG;
    //Fantasma
    private static SpriteSheet spriteHumanoF;
    private static LinkedList<BufferedImage[]> humanoF = new LinkedList<>();
    private static BufferedImage[] humanoIzqF;
    private static BufferedImage[] humanoArribaIzqF;
    private static BufferedImage[] humanoArribaF;
    private static BufferedImage[] humanoArribaDerF;
    private static BufferedImage[] humanoDerF;
    private static BufferedImage[] humanoAbajoDerF;
    private static BufferedImage[] humanoAbajoF;
    private static BufferedImage[] humanoAbajoIzqF;
  //Invisible
    private static SpriteSheet spriteHumanoI;
    private static LinkedList<BufferedImage[]> humanoI = new LinkedList<>();
    private static BufferedImage[] humanoIzqI;
    private static BufferedImage[] humanoArribaIzqI;
    private static BufferedImage[] humanoArribaI;
    private static BufferedImage[] humanoArribaDerI;
    private static BufferedImage[] humanoDerI;
    private static BufferedImage[] humanoAbajoDerI;
    private static BufferedImage[] humanoAbajoI;
    private static BufferedImage[] humanoAbajoIzqI;
    //Powerup
    private static SpriteSheet spriteHumanoB;
    private static LinkedList<BufferedImage[]> humanoB = new LinkedList<>();
    private static BufferedImage[] humanoIzqB;
    private static BufferedImage[] humanoArribaIzqB;
    private static BufferedImage[] humanoArribaB;
    private static BufferedImage[] humanoArribaDerB;
    private static BufferedImage[] humanoDerB;
    private static BufferedImage[] humanoAbajoDerB;
    private static BufferedImage[] humanoAbajoB;
    private static BufferedImage[] humanoAbajoIzqB;
    //PowerDown
    private static SpriteSheet spriteHumanoT;
    private static LinkedList<BufferedImage[]> humanoT = new LinkedList<>();
    private static BufferedImage[] humanoIzqT;
    private static BufferedImage[] humanoArribaIzqT;
    private static BufferedImage[] humanoArribaT;
    private static BufferedImage[] humanoArribaDerT;
    private static BufferedImage[] humanoDerT;
    private static BufferedImage[] humanoAbajoDerT;
    private static BufferedImage[] humanoAbajoT;
    private static BufferedImage[] humanoAbajoIzqT;
    
    private static SpriteSheet spriteOgro;
    private static LinkedList<BufferedImage[]> orco = new LinkedList<>();

	private static BufferedImage[] orcoIzq;
    private static BufferedImage[] orcoArribaIzq;
    private static BufferedImage[] orcoArriba;
    private static BufferedImage[] orcoArribaDer;
    private static BufferedImage[] orcoDer;
    private static BufferedImage[] orcoAbajoDer;
    private static BufferedImage[] orcoAbajo;
    private static BufferedImage[] orcoAbajoIzq;
    
    //CheatsSprite orco
    //God Mode
    private static SpriteSheet spriteOrcoG;
    private static LinkedList<BufferedImage[]> orcoG = new LinkedList<>();
    private static BufferedImage[] orcoIzqG;
    private static BufferedImage[] orcoArribaIzqG;
    private static BufferedImage[] orcoArribaG;
    private static BufferedImage[] orcoArribaDerG;
    private static BufferedImage[] orcoDerG;
    private static BufferedImage[] orcoAbajoDerG;
    private static BufferedImage[] orcoAbajoG;
    private static BufferedImage[] orcoAbajoIzqG;
    //Fantasma
    private static SpriteSheet spriteOrcoF;
    private static LinkedList<BufferedImage[]> orcoF = new LinkedList<>();
    private static BufferedImage[] orcoIzqF;
    private static BufferedImage[] orcoArribaIzqF;
    private static BufferedImage[] orcoArribaF;
    private static BufferedImage[] orcoArribaDerF;
    private static BufferedImage[] orcoDerF;
    private static BufferedImage[] orcoAbajoDerF;
    private static BufferedImage[] orcoAbajoF;
    private static BufferedImage[] orcoAbajoIzqF;
  //Invisible
    private static SpriteSheet spriteOrcoI;
    private static LinkedList<BufferedImage[]> orcoI = new LinkedList<>();
    private static BufferedImage[] orcoIzqI;
    private static BufferedImage[] orcoArribaIzqI;
    private static BufferedImage[] orcoArribaI;
    private static BufferedImage[] orcoArribaDerI;
    private static BufferedImage[] orcoDerI;
    private static BufferedImage[] orcoAbajoDerI;
    private static BufferedImage[] orcoAbajoI;
    private static BufferedImage[] orcoAbajoIzqI;
    //Powerup
    private static SpriteSheet spriteOrcoB;
    private static LinkedList<BufferedImage[]> orcoB = new LinkedList<>();
    private static BufferedImage[] orcoIzqB;
    private static BufferedImage[] orcoArribaIzqB;
    private static BufferedImage[] orcoArribaB;
    private static BufferedImage[] orcoArribaDerB;
    private static BufferedImage[] orcoDerB;
    private static BufferedImage[] orcoAbajoDerB;
    private static BufferedImage[] orcoAbajoB;
    private static BufferedImage[] orcoAbajoIzqB;
    //PowerDown
    private static SpriteSheet spriteOrcoT;
    private static LinkedList<BufferedImage[]> orcoT = new LinkedList<>();
    private static BufferedImage[] orcoIzqT;
    private static BufferedImage[] orcoArribaIzqT;
    private static BufferedImage[] orcoArribaT;
    private static BufferedImage[] orcoArribaDerT;
    private static BufferedImage[] orcoDerT;
    private static BufferedImage[] orcoAbajoDerT;
    private static BufferedImage[] orcoAbajoT;
    private static BufferedImage[] orcoAbajoIzqT;
    
    private static SpriteSheet spriteElfo;
    private static LinkedList<BufferedImage[]> elfo = new LinkedList<>();
    private static BufferedImage[] elfoIzq;
    private static BufferedImage[] elfoArribaIzq;
    private static BufferedImage[] elfoArriba;
    private static BufferedImage[] elfoArribaDer;
    private static BufferedImage[] elfoDer;
    private static BufferedImage[] elfoAbajoDer;
    private static BufferedImage[] elfoAbajo;
    private static BufferedImage[] elfoAbajoIzq;
  
    //CheatsSprite elfo
    //God Mode
    private static SpriteSheet spriteElfoG;
    private static LinkedList<BufferedImage[]> elfoG = new LinkedList<>();
    private static BufferedImage[] elfoIzqG;
    private static BufferedImage[] elfoArribaIzqG;
    private static BufferedImage[] elfoArribaG;
    private static BufferedImage[] elfoArribaDerG;
    private static BufferedImage[] elfoDerG;
    private static BufferedImage[] elfoAbajoDerG;
    private static BufferedImage[] elfoAbajoG;
    private static BufferedImage[] elfoAbajoIzqG;
    //Fantasma
    private static SpriteSheet spriteElfoF;
    private static LinkedList<BufferedImage[]> elfoF = new LinkedList<>();
    private static BufferedImage[] elfoIzqF;
    private static BufferedImage[] elfoArribaIzqF;
    private static BufferedImage[] elfoArribaF;
    private static BufferedImage[] elfoArribaDerF;
    private static BufferedImage[] elfoDerF;
    private static BufferedImage[] elfoAbajoDerF;
    private static BufferedImage[] elfoAbajoF;
    private static BufferedImage[] elfoAbajoIzqF;
  //Invisible
    private static SpriteSheet spriteElfoI;
    private static LinkedList<BufferedImage[]> elfoI = new LinkedList<>();
    private static BufferedImage[] elfoIzqI;
    private static BufferedImage[] elfoArribaIzqI;
    private static BufferedImage[] elfoArribaI;
    private static BufferedImage[] elfoArribaDerI;
    private static BufferedImage[] elfoDerI;
    private static BufferedImage[] elfoAbajoDerI;
    private static BufferedImage[] elfoAbajoI;
    private static BufferedImage[] elfoAbajoIzqI;
    //Powerup
    private static SpriteSheet spriteElfoB;
    private static LinkedList<BufferedImage[]> elfoB = new LinkedList<>();
    private static BufferedImage[] elfoIzqB;
    private static BufferedImage[] elfoArribaIzqB;
    private static BufferedImage[] elfoArribaB;
    private static BufferedImage[] elfoArribaDerB;
    private static BufferedImage[] elfoDerB;
    private static BufferedImage[] elfoAbajoDerB;
    private static BufferedImage[] elfoAbajoB;
    private static BufferedImage[] elfoAbajoIzqB;
    //PowerDown
    private static SpriteSheet spriteElfoT;
    private static LinkedList<BufferedImage[]> elfoT = new LinkedList<>();
    private static BufferedImage[] elfoIzqT;
    private static BufferedImage[] elfoArribaIzqT;
    private static BufferedImage[] elfoArribaT;
    private static BufferedImage[] elfoArribaDerT;
    private static BufferedImage[] elfoDerT;
    private static BufferedImage[] elfoAbajoDerT;
    private static BufferedImage[] elfoAbajoT;
    private static BufferedImage[] elfoAbajoIzqT;
    
    ///NPC
    private static BufferedImage monstruo;

    // Fin Personajes

    // Entorno
    private static SpriteSheet trees;
    private static BufferedImage cesped;
    private static BufferedImage roca;
    private static BufferedImage background;
    private static BufferedImage marco;
    private static BufferedImage botonMenu;
    private static BufferedImage menuEnemigo;
    private static BufferedImage greenTree;
    private static BufferedImage nievePiso1;
    private static BufferedImage iceBlock;
    // Fin Entorno

    // Batalla
    private static BufferedImage barraSpells;
    private static BufferedImage estadoPersonaje;
    private static BufferedImage barraSalud;
    private static BufferedImage barraEnergia;
    private static BufferedImage barraExperiencia;
    private static BufferedImage menuBatalla;
    private static BufferedImage menuBatallaDeshabilitado;
    private static BufferedImage noItem;
    private static BufferedImage mochila;
    private static BufferedImage menu;
    private static BufferedImage chat;
    private static Map<String, BufferedImage> habilidades = new HashMap<>();
    // Fin Batalla
	/**
     * Instantiates a new recursos.
     */
    private Recursos() {
    }

    // Se cargan todos los recursos del juego una sola vez al inicio

    /**
     * Cargar.
     *
     * @param menuCarga
     *            the menu carga
     * @throws IOException
     *             Signals that an I/O exception has occurred.
     */
    public static void cargar(final MenuCarga menuCarga) throws IOException {

        int elementosCargados = 0;

        //Items

        setNoItem(ImageIO.read(new File("recursos//noItem.png")));
        setMochila(ImageIO.read(new File("recursos//mochila.png")));
        setMenu(ImageIO.read(new File("recursos//menu.png")));
        setChat(ImageIO.read(new File("recursos//chat.png")));

        // NPC
        setMonstruo(ImageIO.read(new File("recursos//npc.png")));

        // Inicio humano
        spriteHumano = new SpriteSheet(CargadorImagen.cargarImagen("/Humano.png"));

        actualizarBarraDeCarga(++elementosCargados, menuCarga);

        humanoIzq = new BufferedImage[FRAMES];
        humanoArribaIzq = new BufferedImage[FRAMES];
        humanoArriba = new BufferedImage[FRAMES];
        humanoArribaDer = new BufferedImage[FRAMES];
        humanoDer = new BufferedImage[FRAMES];
        humanoAbajoDer = new BufferedImage[FRAMES];
        humanoAbajo = new BufferedImage[FRAMES];
        humanoAbajoIzq = new BufferedImage[FRAMES];

        for (int i = 0; i < FRAMES; i++) {
            humanoIzq[i] = spriteHumano.getTile(ANCHO * i, 0, ANCHO, ALTO);
        }

        actualizarBarraDeCarga(++elementosCargados, menuCarga);

        for (int i = 0; i < FRAMES; i++) {
            humanoArribaIzq[i] = spriteHumano.getTile(ANCHO * i, ALTO, ANCHO, ALTO);
        }

        actualizarBarraDeCarga(++elementosCargados, menuCarga);

        for (int i = 0; i < FRAMES; i++) {
            humanoArriba[i] = spriteHumano.getTile(ANCHO * i, ALTO * 2, ANCHO, ALTO);
        }

        actualizarBarraDeCarga(++elementosCargados, menuCarga);

        for (int i = 0; i < FRAMES; i++) {
            humanoArribaDer[i] = spriteHumano.getTile(ANCHO * i, ALTO * BIG_THREE, ANCHO, ALTO);
        }

        actualizarBarraDeCarga(++elementosCargados, menuCarga);

        for (int i = 0; i < FRAMES; i++) {
            humanoDer[i] = spriteHumano.getTile(ANCHO * i, ALTO * FRAMES, ANCHO, ALTO);
        }

        actualizarBarraDeCarga(++elementosCargados, menuCarga);

        for (int i = 0; i < FRAMES; i++) {
            humanoAbajoDer[i] = spriteHumano.getTile(ANCHO * i, ALTO * BIG_FIVE, ANCHO, ALTO);
        }

        actualizarBarraDeCarga(++elementosCargados, menuCarga);

        for (int i = 0; i < FRAMES; i++) {
            humanoAbajo[i] = spriteHumano.getTile(ANCHO * i, ALTO * BIG_SIX, ANCHO, ALTO);
        }

        actualizarBarraDeCarga(++elementosCargados, menuCarga);

        for (int i = 0; i < FRAMES; i++) {
            humanoAbajoIzq[i] = spriteHumano.getTile(ANCHO * i, ALTO * BIG_SEVEN, ANCHO, ALTO);
        }

        actualizarBarraDeCarga(++elementosCargados, menuCarga);

        humano.add(humanoIzq);
        humano.add(humanoArribaIzq);
        humano.add(humanoArriba);
        humano.add(humanoArribaDer);
        humano.add(humanoDer);
        humano.add(humanoAbajoDer);
        humano.add(humanoAbajo);
        humano.add(humanoAbajoIzq);
        // Fin humano
        
     // Inicio humano God Mode
        setSpriteHumanoG(new SpriteSheet(ImageIO.read(new File("recursos//HumanoGodMode.png"))));
        
        actualizarBarraDeCarga(++elementosCargados, menuCarga);
        
        humanoIzqG = new BufferedImage[FRAMES];
        humanoArribaIzqG = new BufferedImage[FRAMES];
        humanoArribaG = new BufferedImage[FRAMES];
        humanoArribaDerG = new BufferedImage[FRAMES];
        humanoDerG = new BufferedImage[FRAMES];
        humanoAbajoDerG = new BufferedImage[FRAMES];
        humanoAbajoG = new BufferedImage[FRAMES];
        humanoAbajoIzqG = new BufferedImage[FRAMES];

        for (int i = 0; i < FRAMES; i++) {
            humanoIzqG[i] = getSpriteHumanoG().getTile(ANCHO * i, 0, ANCHO, ALTO);
        }

        actualizarBarraDeCarga(++elementosCargados, menuCarga);

        for (int i = 0; i < FRAMES; i++) {
            humanoArribaIzqG[i] = getSpriteHumanoG().getTile(ANCHO * i, ALTO, ANCHO, ALTO);
        }

        actualizarBarraDeCarga(++elementosCargados, menuCarga);

        for (int i = 0; i < FRAMES; i++) {
            humanoArribaG[i] = getSpriteHumanoG().getTile(ANCHO * i, ALTO * 2, ANCHO, ALTO);
        }

        actualizarBarraDeCarga(++elementosCargados, menuCarga);

        for (int i = 0; i < FRAMES; i++) {
            humanoArribaDerG[i] = getSpriteHumanoG().getTile(ANCHO * i, ALTO * BIG_THREE, ANCHO, ALTO);
        }

        actualizarBarraDeCarga(++elementosCargados, menuCarga);

        for (int i = 0; i < FRAMES; i++) {
            humanoDerG[i] = getSpriteHumanoG().getTile(ANCHO * i, ALTO * FRAMES, ANCHO, ALTO);
        }

        actualizarBarraDeCarga(++elementosCargados, menuCarga);

        for (int i = 0; i < FRAMES; i++) {
            humanoAbajoDerG[i] = getSpriteHumanoG().getTile(ANCHO * i, ALTO * BIG_FIVE, ANCHO, ALTO);
        }

        actualizarBarraDeCarga(++elementosCargados, menuCarga);

        for (int i = 0; i < FRAMES; i++) {
            humanoAbajoG[i] = getSpriteHumanoG().getTile(ANCHO * i, ALTO * BIG_SIX, ANCHO, ALTO);
        }

        actualizarBarraDeCarga(++elementosCargados, menuCarga);

        for (int i = 0; i < FRAMES; i++) {
            humanoAbajoIzqG[i] = getSpriteHumanoG().getTile(ANCHO * i, ALTO * BIG_SEVEN, ANCHO, ALTO);
        }

        actualizarBarraDeCarga(++elementosCargados, menuCarga);

        humanoG.add(humanoIzqG);
        humanoG.add(humanoArribaIzqG);
        humanoG.add(humanoArribaG);
        humanoG.add(humanoArribaDerG);
        humanoG.add(humanoDerG);
        humanoG.add(humanoAbajoDerG);
        humanoG.add(humanoAbajoG);
        humanoG.add(humanoAbajoIzqG);
        // Fin humano God Mode
        
        // Inicio humano Fantasma
        setSpriteHumanoF(new SpriteSheet(ImageIO.read(new File("recursos//HumanoFantasma.png"))));
        
        actualizarBarraDeCarga(++elementosCargados, menuCarga);
        
        humanoIzqF = new BufferedImage[FRAMES];
        humanoArribaIzqF = new BufferedImage[FRAMES];
        humanoArribaF = new BufferedImage[FRAMES];
        humanoArribaDerF = new BufferedImage[FRAMES];
        humanoDerF = new BufferedImage[FRAMES];
        humanoAbajoDerF = new BufferedImage[FRAMES];
        humanoAbajoF = new BufferedImage[FRAMES];
        humanoAbajoIzqF = new BufferedImage[FRAMES];

        for (int i = 0; i < FRAMES; i++) {
            humanoIzqF[i] = getSpriteHumanoF().getTile(ANCHO * i, 0, ANCHO, ALTO);
        }

        actualizarBarraDeCarga(++elementosCargados, menuCarga);

        for (int i = 0; i < FRAMES; i++) {
            humanoArribaIzqF[i] = getSpriteHumanoF().getTile(ANCHO * i, ALTO, ANCHO, ALTO);
        }

        actualizarBarraDeCarga(++elementosCargados, menuCarga);

        for (int i = 0; i < FRAMES; i++) {
            humanoArribaF[i] = getSpriteHumanoF().getTile(ANCHO * i, ALTO * 2, ANCHO, ALTO);
        }

        actualizarBarraDeCarga(++elementosCargados, menuCarga);

        for (int i = 0; i < FRAMES; i++) {
            humanoArribaDerF[i] = getSpriteHumanoF().getTile(ANCHO * i, ALTO * BIG_THREE, ANCHO, ALTO);
        }

        actualizarBarraDeCarga(++elementosCargados, menuCarga);

        for (int i = 0; i < FRAMES; i++) {
            humanoDerF[i] = getSpriteHumanoF().getTile(ANCHO * i, ALTO * FRAMES, ANCHO, ALTO);
        }

        actualizarBarraDeCarga(++elementosCargados, menuCarga);

        for (int i = 0; i < FRAMES; i++) {
            humanoAbajoDerF[i] = getSpriteHumanoF().getTile(ANCHO * i, ALTO * BIG_FIVE, ANCHO, ALTO);
        }

        actualizarBarraDeCarga(++elementosCargados, menuCarga);

        for (int i = 0; i < FRAMES; i++) {
            humanoAbajoF[i] = getSpriteHumanoF().getTile(ANCHO * i, ALTO * BIG_SIX, ANCHO, ALTO);
        }

        actualizarBarraDeCarga(++elementosCargados, menuCarga);

        for (int i = 0; i < FRAMES; i++) {
            humanoAbajoIzqF[i] = getSpriteHumanoF().getTile(ANCHO * i, ALTO * BIG_SEVEN, ANCHO, ALTO);
        }

        actualizarBarraDeCarga(++elementosCargados, menuCarga);

        humanoF.add(humanoIzqF);
        humanoF.add(humanoArribaIzqF);
        humanoF.add(humanoArribaF);
        humanoF.add(humanoArribaDerF);
        humanoF.add(humanoDerF);
        humanoF.add(humanoAbajoDerF);
        humanoF.add(humanoAbajoF);
        humanoF.add(humanoAbajoIzqF);
        // Fin humano fantasma
        
        // Inicio humano Invisible
        setSpriteHumanoI(new SpriteSheet(ImageIO.read(new File("recursos//HumanoInvisible.png"))));
        
        actualizarBarraDeCarga(++elementosCargados, menuCarga);
        
        humanoIzqI = new BufferedImage[FRAMES];
        humanoArribaIzqI = new BufferedImage[FRAMES];
        humanoArribaI = new BufferedImage[FRAMES];
        humanoArribaDerI = new BufferedImage[FRAMES];
        humanoDerI = new BufferedImage[FRAMES];
        humanoAbajoDerI = new BufferedImage[FRAMES];
        humanoAbajoI = new BufferedImage[FRAMES];
        humanoAbajoIzqI = new BufferedImage[FRAMES];

        for (int i = 0; i < FRAMES; i++) {
            humanoIzqI[i] = getSpriteHumanoI().getTile(ANCHO * i, 0, ANCHO, ALTO);
        }

        actualizarBarraDeCarga(++elementosCargados, menuCarga);

        for (int i = 0; i < FRAMES; i++) {
            humanoArribaIzqI[i] = getSpriteHumanoI().getTile(ANCHO * i, ALTO, ANCHO, ALTO);
        }

        actualizarBarraDeCarga(++elementosCargados, menuCarga);

        for (int i = 0; i < FRAMES; i++) {
            humanoArribaI[i] = getSpriteHumanoI().getTile(ANCHO * i, ALTO * 2, ANCHO, ALTO);
        }

        actualizarBarraDeCarga(++elementosCargados, menuCarga);

        for (int i = 0; i < FRAMES; i++) {
            humanoArribaDerI[i] = getSpriteHumanoI().getTile(ANCHO * i, ALTO * BIG_THREE, ANCHO, ALTO);
        }

        actualizarBarraDeCarga(++elementosCargados, menuCarga);

        for (int i = 0; i < FRAMES; i++) {
            humanoDerI[i] = getSpriteHumanoI().getTile(ANCHO * i, ALTO * FRAMES, ANCHO, ALTO);
        }

        actualizarBarraDeCarga(++elementosCargados, menuCarga);

        for (int i = 0; i < FRAMES; i++) {
            humanoAbajoDerI[i] = getSpriteHumanoI().getTile(ANCHO * i, ALTO * BIG_FIVE, ANCHO, ALTO);
        }

        actualizarBarraDeCarga(++elementosCargados, menuCarga);

        for (int i = 0; i < FRAMES; i++) {
            humanoAbajoI[i] = getSpriteHumanoI().getTile(ANCHO * i, ALTO * BIG_SIX, ANCHO, ALTO);
        }

        actualizarBarraDeCarga(++elementosCargados, menuCarga);

        for (int i = 0; i < FRAMES; i++) {
            humanoAbajoIzqI[i] = getSpriteHumanoI().getTile(ANCHO * i, ALTO * BIG_SEVEN, ANCHO, ALTO);
        }

        actualizarBarraDeCarga(++elementosCargados, menuCarga);

        humanoI.add(humanoIzqI);
        humanoI.add(humanoArribaIzqI);
        humanoI.add(humanoArribaI);
        humanoI.add(humanoArribaDerI);
        humanoI.add(humanoDerI);
        humanoI.add(humanoAbajoDerI);
        humanoI.add(humanoAbajoI);
        humanoI.add(humanoAbajoIzqI);
        // Fin humano Invisible
        
        // Inicio humano PowerUp
        setSpriteHumanoB(new SpriteSheet(ImageIO.read(new File("recursos//HumanoBig.png"))));
        
        actualizarBarraDeCarga(++elementosCargados, menuCarga);
        
        humanoIzqB = new BufferedImage[FRAMES];
        humanoArribaIzqB = new BufferedImage[FRAMES];
        humanoArribaB = new BufferedImage[FRAMES];
        humanoArribaDerB = new BufferedImage[FRAMES];
        humanoDerB = new BufferedImage[FRAMES];
        humanoAbajoDerB = new BufferedImage[FRAMES];
        humanoAbajoB = new BufferedImage[FRAMES];
        humanoAbajoIzqB = new BufferedImage[FRAMES];

        for (int i = 0; i < FRAMES; i++) {
            humanoIzqB[i] = getSpriteHumanoB().getTile(ANCHO * i, 0, ANCHO, ALTO);
        }

        actualizarBarraDeCarga(++elementosCargados, menuCarga);

        for (int i = 0; i < FRAMES; i++) {
            humanoArribaIzqB[i] = getSpriteHumanoB().getTile(ANCHO * i, ALTO, ANCHO, ALTO);
        }

        actualizarBarraDeCarga(++elementosCargados, menuCarga);

        for (int i = 0; i < FRAMES; i++) {
            humanoArribaB[i] = getSpriteHumanoB().getTile(ANCHO * i, ALTO * 2, ANCHO, ALTO);
        }

        actualizarBarraDeCarga(++elementosCargados, menuCarga);

        for (int i = 0; i < FRAMES; i++) {
            humanoArribaDerB[i] = getSpriteHumanoB().getTile(ANCHO * i, ALTO * BIG_THREE, ANCHO, ALTO);
        }

        actualizarBarraDeCarga(++elementosCargados, menuCarga);

        for (int i = 0; i < FRAMES; i++) {
            humanoDerB[i] = getSpriteHumanoB().getTile(ANCHO * i, ALTO * FRAMES, ANCHO, ALTO);
        }

        actualizarBarraDeCarga(++elementosCargados, menuCarga);

        for (int i = 0; i < FRAMES; i++) {
            humanoAbajoDerB[i] = getSpriteHumanoB().getTile(ANCHO * i, ALTO * BIG_FIVE, ANCHO, ALTO);
        }

        actualizarBarraDeCarga(++elementosCargados, menuCarga);

        for (int i = 0; i < FRAMES; i++) {
            humanoAbajoB[i] = getSpriteHumanoB().getTile(ANCHO * i, ALTO * BIG_SIX, ANCHO, ALTO);
        }

        actualizarBarraDeCarga(++elementosCargados, menuCarga);

        for (int i = 0; i < FRAMES; i++) {
            humanoAbajoIzqB[i] = getSpriteHumanoB().getTile(ANCHO * i, ALTO * BIG_SEVEN, ANCHO, ALTO);
        }

        actualizarBarraDeCarga(++elementosCargados, menuCarga);

        humanoB.add(humanoIzqB);
        humanoB.add(humanoArribaIzqB);
        humanoB.add(humanoArribaB);
        humanoB.add(humanoArribaDerB);
        humanoB.add(humanoDerB);
        humanoB.add(humanoAbajoDerB);
        humanoB.add(humanoAbajoB);
        humanoB.add(humanoAbajoIzqB);
        // Fin humano PowerUp
        
        // Inicio humano PowerDown
        setSpriteHumanoT(new SpriteSheet(ImageIO.read(new File("recursos//HumanoTiny.png"))));
        
        actualizarBarraDeCarga(++elementosCargados, menuCarga);
        
        humanoIzqT = new BufferedImage[FRAMES];
        humanoArribaIzqT = new BufferedImage[FRAMES];
        humanoArribaT = new BufferedImage[FRAMES];
        humanoArribaDerT = new BufferedImage[FRAMES];
        humanoDerT = new BufferedImage[FRAMES];
        humanoAbajoDerT = new BufferedImage[FRAMES];
        humanoAbajoT = new BufferedImage[FRAMES];
        humanoAbajoIzqT = new BufferedImage[FRAMES];

        for (int i = 0; i < FRAMES; i++) {
            humanoIzqT[i] = getSpriteHumanoT().getTile(ANCHO * i, 0, ANCHO, ALTO);
        }

        actualizarBarraDeCarga(++elementosCargados, menuCarga);

        for (int i = 0; i < FRAMES; i++) {
            humanoArribaIzqT[i] = getSpriteHumanoT().getTile(ANCHO * i, ALTO, ANCHO, ALTO);
        }

        actualizarBarraDeCarga(++elementosCargados, menuCarga);

        for (int i = 0; i < FRAMES; i++) {
            humanoArribaT[i] = getSpriteHumanoT().getTile(ANCHO * i, ALTO * 2, ANCHO, ALTO);
        }

        actualizarBarraDeCarga(++elementosCargados, menuCarga);

        for (int i = 0; i < FRAMES; i++) {
            humanoArribaDerT[i] = getSpriteHumanoT().getTile(ANCHO * i, ALTO * BIG_THREE, ANCHO, ALTO);
        }

        actualizarBarraDeCarga(++elementosCargados, menuCarga);

        for (int i = 0; i < FRAMES; i++) {
            humanoDerT[i] = getSpriteHumanoT().getTile(ANCHO * i, ALTO * FRAMES, ANCHO, ALTO);
        }

        actualizarBarraDeCarga(++elementosCargados, menuCarga);

        for (int i = 0; i < FRAMES; i++) {
            humanoAbajoDerT[i] = getSpriteHumanoT().getTile(ANCHO * i, ALTO * BIG_FIVE, ANCHO, ALTO);
        }

        actualizarBarraDeCarga(++elementosCargados, menuCarga);

        for (int i = 0; i < FRAMES; i++) {
            humanoAbajoT[i] = getSpriteHumanoT().getTile(ANCHO * i, ALTO * BIG_SIX, ANCHO, ALTO);
        }

        actualizarBarraDeCarga(++elementosCargados, menuCarga);

        for (int i = 0; i < FRAMES; i++) {
            humanoAbajoIzqT[i] = getSpriteHumanoT().getTile(ANCHO * i, ALTO * BIG_SEVEN, ANCHO, ALTO);
        }

        actualizarBarraDeCarga(++elementosCargados, menuCarga);

        humanoT.add(humanoIzqT);
        humanoT.add(humanoArribaIzqT);
        humanoT.add(humanoArribaT);
        humanoT.add(humanoArribaDerT);
        humanoT.add(humanoDerT);
        humanoT.add(humanoAbajoDerT);
        humanoT.add(humanoAbajoT);
        humanoT.add(humanoAbajoIzqT);
        // Fin humano PowerDown
        
        
        // Inicio Ogro
        spriteOgro = new SpriteSheet(CargadorImagen.cargarImagen("/Ogro.png"));

        actualizarBarraDeCarga(++elementosCargados, menuCarga);

        orcoIzq = new BufferedImage[FRAMES];
        orcoArribaIzq = new BufferedImage[FRAMES];
        orcoArriba = new BufferedImage[FRAMES];
        orcoArribaDer = new BufferedImage[FRAMES];
        orcoDer = new BufferedImage[FRAMES];
        orcoAbajoDer = new BufferedImage[FRAMES];
        orcoAbajo = new BufferedImage[FRAMES];
        orcoAbajoIzq = new BufferedImage[FRAMES];

        for (int i = 0; i < FRAMES; i++) {
            orcoIzq[i] = spriteOgro.getTile(ANCHO * i, 0, ANCHO, ALTO);
        }

        actualizarBarraDeCarga(++elementosCargados, menuCarga);

        for (int i = 0; i < FRAMES; i++) {
            orcoArribaIzq[i] = spriteOgro.getTile(ANCHO * i, ALTO, ANCHO, ALTO);
        }

        actualizarBarraDeCarga(++elementosCargados, menuCarga);

        for (int i = 0; i < FRAMES; i++) {
            orcoArriba[i] = spriteOgro.getTile(ANCHO * i, ALTO * 2, ANCHO, ALTO);
        }

        actualizarBarraDeCarga(++elementosCargados, menuCarga);

        for (int i = 0; i < FRAMES; i++) {
            orcoArribaDer[i] = spriteOgro.getTile(ANCHO * i, ALTO * BIG_THREE, ANCHO, ALTO);
        }

        actualizarBarraDeCarga(++elementosCargados, menuCarga);

        for (int i = 0; i < FRAMES; i++) {
            orcoDer[i] = spriteOgro.getTile(ANCHO * i, ALTO * FRAMES, ANCHO, ALTO);
        }

        actualizarBarraDeCarga(++elementosCargados, menuCarga);

        for (int i = 0; i < FRAMES; i++) {
            orcoAbajoDer[i] = spriteOgro.getTile(ANCHO * i, ALTO * BIG_FIVE, ANCHO, ALTO);
        }

        actualizarBarraDeCarga(++elementosCargados, menuCarga);

        for (int i = 0; i < FRAMES; i++) {
            orcoAbajo[i] = spriteOgro.getTile(ANCHO * i, ALTO * BIG_SIX, ANCHO, ALTO);
        }

        actualizarBarraDeCarga(++elementosCargados, menuCarga);

        for (int i = 0; i < FRAMES; i++) {
            orcoAbajoIzq[i] = spriteOgro.getTile(ANCHO * i, ALTO * BIG_SEVEN, ANCHO, ALTO);
        }

        actualizarBarraDeCarga(++elementosCargados, menuCarga);

        orco.add(orcoIzq);
        orco.add(orcoArribaIzq);
        orco.add(orcoArriba);
        orco.add(orcoArribaDer);
        orco.add(orcoDer);
        orco.add(orcoAbajoDer);
        orco.add(orcoAbajo);
        orco.add(orcoAbajoIzq);

        // Fin Ogro
        
     // Inicio orco God Mode
        setSpriteOrcoG(new SpriteSheet(ImageIO.read(new File("recursos//OgroGodMode.png"))));
        
        actualizarBarraDeCarga(++elementosCargados, menuCarga);
        
        orcoIzqG = new BufferedImage[FRAMES];
        orcoArribaIzqG = new BufferedImage[FRAMES];
        orcoArribaG = new BufferedImage[FRAMES];
        orcoArribaDerG = new BufferedImage[FRAMES];
        orcoDerG = new BufferedImage[FRAMES];
        orcoAbajoDerG = new BufferedImage[FRAMES];
        orcoAbajoG = new BufferedImage[FRAMES];
        orcoAbajoIzqG = new BufferedImage[FRAMES];

        for (int i = 0; i < FRAMES; i++) {
            orcoIzqG[i] = getSpriteOrcoG().getTile(ANCHO * i, 0, ANCHO, ALTO);
        }

        actualizarBarraDeCarga(++elementosCargados, menuCarga);

        for (int i = 0; i < FRAMES; i++) {
            orcoArribaIzqG[i] = getSpriteOrcoG().getTile(ANCHO * i, ALTO, ANCHO, ALTO);
        }

        actualizarBarraDeCarga(++elementosCargados, menuCarga);

        for (int i = 0; i < FRAMES; i++) {
            orcoArribaG[i] = getSpriteOrcoG().getTile(ANCHO * i, ALTO * 2, ANCHO, ALTO);
        }

        actualizarBarraDeCarga(++elementosCargados, menuCarga);

        for (int i = 0; i < FRAMES; i++) {
            orcoArribaDerG[i] = getSpriteOrcoG().getTile(ANCHO * i, ALTO * BIG_THREE, ANCHO, ALTO);
        }

        actualizarBarraDeCarga(++elementosCargados, menuCarga);

        for (int i = 0; i < FRAMES; i++) {
            orcoDerG[i] = getSpriteOrcoG().getTile(ANCHO * i, ALTO * FRAMES, ANCHO, ALTO);
        }

        actualizarBarraDeCarga(++elementosCargados, menuCarga);

        for (int i = 0; i < FRAMES; i++) {
            orcoAbajoDerG[i] = getSpriteOrcoG().getTile(ANCHO * i, ALTO * BIG_FIVE, ANCHO, ALTO);
        }

        actualizarBarraDeCarga(++elementosCargados, menuCarga);

        for (int i = 0; i < FRAMES; i++) {
            orcoAbajoG[i] = getSpriteOrcoG().getTile(ANCHO * i, ALTO * BIG_SIX, ANCHO, ALTO);
        }

        actualizarBarraDeCarga(++elementosCargados, menuCarga);

        for (int i = 0; i < FRAMES; i++) {
            orcoAbajoIzqG[i] = getSpriteOrcoG().getTile(ANCHO * i, ALTO * BIG_SEVEN, ANCHO, ALTO);
        }

        actualizarBarraDeCarga(++elementosCargados, menuCarga);

        orcoG.add(orcoIzqG);
        orcoG.add(orcoArribaIzqG);
        orcoG.add(orcoArribaG);
        orcoG.add(orcoArribaDerG);
        orcoG.add(orcoDerG);
        orcoG.add(orcoAbajoDerG);
        orcoG.add(orcoAbajoG);
        orcoG.add(orcoAbajoIzqG);
        // Fin orco God Mode
        
        // Inicio orco Fantasma
        setSpriteOrcoF(new SpriteSheet(ImageIO.read(new File("recursos//OgroFantasma.png"))));
        
        actualizarBarraDeCarga(++elementosCargados, menuCarga);
        
        orcoIzqF = new BufferedImage[FRAMES];
        orcoArribaIzqF = new BufferedImage[FRAMES];
        orcoArribaF = new BufferedImage[FRAMES];
        orcoArribaDerF = new BufferedImage[FRAMES];
        orcoDerF = new BufferedImage[FRAMES];
        orcoAbajoDerF = new BufferedImage[FRAMES];
        orcoAbajoF = new BufferedImage[FRAMES];
        orcoAbajoIzqF = new BufferedImage[FRAMES];

        for (int i = 0; i < FRAMES; i++) {
            orcoIzqF[i] = getSpriteOrcoF().getTile(ANCHO * i, 0, ANCHO, ALTO);
        }

        actualizarBarraDeCarga(++elementosCargados, menuCarga);

        for (int i = 0; i < FRAMES; i++) {
            orcoArribaIzqF[i] = getSpriteOrcoF().getTile(ANCHO * i, ALTO, ANCHO, ALTO);
        }

        actualizarBarraDeCarga(++elementosCargados, menuCarga);

        for (int i = 0; i < FRAMES; i++) {
            orcoArribaF[i] = getSpriteOrcoF().getTile(ANCHO * i, ALTO * 2, ANCHO, ALTO);
        }

        actualizarBarraDeCarga(++elementosCargados, menuCarga);

        for (int i = 0; i < FRAMES; i++) {
            orcoArribaDerF[i] = getSpriteOrcoF().getTile(ANCHO * i, ALTO * BIG_THREE, ANCHO, ALTO);
        }

        actualizarBarraDeCarga(++elementosCargados, menuCarga);

        for (int i = 0; i < FRAMES; i++) {
            orcoDerF[i] = getSpriteOrcoF().getTile(ANCHO * i, ALTO * FRAMES, ANCHO, ALTO);
        }

        actualizarBarraDeCarga(++elementosCargados, menuCarga);

        for (int i = 0; i < FRAMES; i++) {
            orcoAbajoDerF[i] = getSpriteOrcoF().getTile(ANCHO * i, ALTO * BIG_FIVE, ANCHO, ALTO);
        }

        actualizarBarraDeCarga(++elementosCargados, menuCarga);

        for (int i = 0; i < FRAMES; i++) {
            orcoAbajoF[i] = getSpriteOrcoF().getTile(ANCHO * i, ALTO * BIG_SIX, ANCHO, ALTO);
        }

        actualizarBarraDeCarga(++elementosCargados, menuCarga);

        for (int i = 0; i < FRAMES; i++) {
            orcoAbajoIzqF[i] = getSpriteOrcoF().getTile(ANCHO * i, ALTO * BIG_SEVEN, ANCHO, ALTO);
        }

        actualizarBarraDeCarga(++elementosCargados, menuCarga);

        orcoF.add(orcoIzqF);
        orcoF.add(orcoArribaIzqF);
        orcoF.add(orcoArribaF);
        orcoF.add(orcoArribaDerF);
        orcoF.add(orcoDerF);
        orcoF.add(orcoAbajoDerF);
        orcoF.add(orcoAbajoF);
        orcoF.add(orcoAbajoIzqF);
        // Fin orco fantasma
        
        // Inicio orco Invisible
        setSpriteOrcoI(new SpriteSheet(ImageIO.read(new File("recursos//OgroInvisible.png"))));
        
        actualizarBarraDeCarga(++elementosCargados, menuCarga);
        
        orcoIzqI = new BufferedImage[FRAMES];
        orcoArribaIzqI = new BufferedImage[FRAMES];
        orcoArribaI = new BufferedImage[FRAMES];
        orcoArribaDerI = new BufferedImage[FRAMES];
        orcoDerI = new BufferedImage[FRAMES];
        orcoAbajoDerI = new BufferedImage[FRAMES];
        orcoAbajoI = new BufferedImage[FRAMES];
        orcoAbajoIzqI = new BufferedImage[FRAMES];

        for (int i = 0; i < FRAMES; i++) {
            orcoIzqI[i] = getSpriteOrcoI().getTile(ANCHO * i, 0, ANCHO, ALTO);
        }

        actualizarBarraDeCarga(++elementosCargados, menuCarga);

        for (int i = 0; i < FRAMES; i++) {
            orcoArribaIzqI[i] = getSpriteOrcoI().getTile(ANCHO * i, ALTO, ANCHO, ALTO);
        }

        actualizarBarraDeCarga(++elementosCargados, menuCarga);

        for (int i = 0; i < FRAMES; i++) {
            orcoArribaI[i] = getSpriteOrcoI().getTile(ANCHO * i, ALTO * 2, ANCHO, ALTO);
        }

        actualizarBarraDeCarga(++elementosCargados, menuCarga);

        for (int i = 0; i < FRAMES; i++) {
            orcoArribaDerI[i] = getSpriteOrcoI().getTile(ANCHO * i, ALTO * BIG_THREE, ANCHO, ALTO);
        }

        actualizarBarraDeCarga(++elementosCargados, menuCarga);

        for (int i = 0; i < FRAMES; i++) {
            orcoDerI[i] = getSpriteOrcoI().getTile(ANCHO * i, ALTO * FRAMES, ANCHO, ALTO);
        }

        actualizarBarraDeCarga(++elementosCargados, menuCarga);

        for (int i = 0; i < FRAMES; i++) {
            orcoAbajoDerI[i] = getSpriteOrcoI().getTile(ANCHO * i, ALTO * BIG_FIVE, ANCHO, ALTO);
        }

        actualizarBarraDeCarga(++elementosCargados, menuCarga);

        for (int i = 0; i < FRAMES; i++) {
            orcoAbajoI[i] = getSpriteOrcoI().getTile(ANCHO * i, ALTO * BIG_SIX, ANCHO, ALTO);
        }

        actualizarBarraDeCarga(++elementosCargados, menuCarga);

        for (int i = 0; i < FRAMES; i++) {
            orcoAbajoIzqI[i] = getSpriteOrcoI().getTile(ANCHO * i, ALTO * BIG_SEVEN, ANCHO, ALTO);
        }

        actualizarBarraDeCarga(++elementosCargados, menuCarga);

        orcoI.add(orcoIzqI);
        orcoI.add(orcoArribaIzqI);
        orcoI.add(orcoArribaI);
        orcoI.add(orcoArribaDerI);
        orcoI.add(orcoDerI);
        orcoI.add(orcoAbajoDerI);
        orcoI.add(orcoAbajoI);
        orcoI.add(orcoAbajoIzqI);
        // Fin orco Invisible
        
        // Inicio orco PowerUp
        setSpriteOrcoB(new SpriteSheet(ImageIO.read(new File("recursos//OgroBig.png"))));
        
        actualizarBarraDeCarga(++elementosCargados, menuCarga);
        
        orcoIzqB = new BufferedImage[FRAMES];
        orcoArribaIzqB = new BufferedImage[FRAMES];
        orcoArribaB = new BufferedImage[FRAMES];
        orcoArribaDerB = new BufferedImage[FRAMES];
        orcoDerB = new BufferedImage[FRAMES];
        orcoAbajoDerB = new BufferedImage[FRAMES];
        orcoAbajoB = new BufferedImage[FRAMES];
        orcoAbajoIzqB = new BufferedImage[FRAMES];

        for (int i = 0; i < FRAMES; i++) {
            orcoIzqB[i] = getSpriteOrcoB().getTile(ANCHO * i, 0, ANCHO, ALTO);
        }

        actualizarBarraDeCarga(++elementosCargados, menuCarga);

        for (int i = 0; i < FRAMES; i++) {
            orcoArribaIzqB[i] = getSpriteOrcoB().getTile(ANCHO * i, ALTO, ANCHO, ALTO);
        }

        actualizarBarraDeCarga(++elementosCargados, menuCarga);

        for (int i = 0; i < FRAMES; i++) {
            orcoArribaB[i] = getSpriteOrcoB().getTile(ANCHO * i, ALTO * 2, ANCHO, ALTO);
        }

        actualizarBarraDeCarga(++elementosCargados, menuCarga);

        for (int i = 0; i < FRAMES; i++) {
            orcoArribaDerB[i] = getSpriteOrcoB().getTile(ANCHO * i, ALTO * BIG_THREE, ANCHO, ALTO);
        }

        actualizarBarraDeCarga(++elementosCargados, menuCarga);

        for (int i = 0; i < FRAMES; i++) {
            orcoDerB[i] = getSpriteOrcoB().getTile(ANCHO * i, ALTO * FRAMES, ANCHO, ALTO);
        }

        actualizarBarraDeCarga(++elementosCargados, menuCarga);

        for (int i = 0; i < FRAMES; i++) {
            orcoAbajoDerB[i] = getSpriteOrcoB().getTile(ANCHO * i, ALTO * BIG_FIVE, ANCHO, ALTO);
        }

        actualizarBarraDeCarga(++elementosCargados, menuCarga);

        for (int i = 0; i < FRAMES; i++) {
            orcoAbajoB[i] = getSpriteOrcoB().getTile(ANCHO * i, ALTO * BIG_SIX, ANCHO, ALTO);
        }

        actualizarBarraDeCarga(++elementosCargados, menuCarga);

        for (int i = 0; i < FRAMES; i++) {
            orcoAbajoIzqB[i] = getSpriteOrcoB().getTile(ANCHO * i, ALTO * BIG_SEVEN, ANCHO, ALTO);
        }

        actualizarBarraDeCarga(++elementosCargados, menuCarga);

        orcoB.add(orcoIzqB);
        orcoB.add(orcoArribaIzqB);
        orcoB.add(orcoArribaB);
        orcoB.add(orcoArribaDerB);
        orcoB.add(orcoDerB);
        orcoB.add(orcoAbajoDerB);
        orcoB.add(orcoAbajoB);
        orcoB.add(orcoAbajoIzqB);
        // Fin orco PowerUp
        
        // Inicio orco PowerDown
        setSpriteOrcoT(new SpriteSheet(ImageIO.read(new File("recursos//OgroTiny.png"))));
        
        actualizarBarraDeCarga(++elementosCargados, menuCarga);
        
        orcoIzqT = new BufferedImage[FRAMES];
        orcoArribaIzqT = new BufferedImage[FRAMES];
        orcoArribaT = new BufferedImage[FRAMES];
        orcoArribaDerT = new BufferedImage[FRAMES];
        orcoDerT = new BufferedImage[FRAMES];
        orcoAbajoDerT = new BufferedImage[FRAMES];
        orcoAbajoT = new BufferedImage[FRAMES];
        orcoAbajoIzqT = new BufferedImage[FRAMES];

        for (int i = 0; i < FRAMES; i++) {
            orcoIzqT[i] = getSpriteOrcoT().getTile(ANCHO * i, 0, ANCHO, ALTO);
        }

        actualizarBarraDeCarga(++elementosCargados, menuCarga);

        for (int i = 0; i < FRAMES; i++) {
            orcoArribaIzqT[i] = getSpriteOrcoT().getTile(ANCHO * i, ALTO, ANCHO, ALTO);
        }

        actualizarBarraDeCarga(++elementosCargados, menuCarga);

        for (int i = 0; i < FRAMES; i++) {
            orcoArribaT[i] = getSpriteOrcoT().getTile(ANCHO * i, ALTO * 2, ANCHO, ALTO);
        }

        actualizarBarraDeCarga(++elementosCargados, menuCarga);

        for (int i = 0; i < FRAMES; i++) {
            orcoArribaDerT[i] = getSpriteOrcoT().getTile(ANCHO * i, ALTO * BIG_THREE, ANCHO, ALTO);
        }

        actualizarBarraDeCarga(++elementosCargados, menuCarga);

        for (int i = 0; i < FRAMES; i++) {
            orcoDerT[i] = getSpriteOrcoT().getTile(ANCHO * i, ALTO * FRAMES, ANCHO, ALTO);
        }

        actualizarBarraDeCarga(++elementosCargados, menuCarga);

        for (int i = 0; i < FRAMES; i++) {
            orcoAbajoDerT[i] = getSpriteOrcoT().getTile(ANCHO * i, ALTO * BIG_FIVE, ANCHO, ALTO);
        }

        actualizarBarraDeCarga(++elementosCargados, menuCarga);

        for (int i = 0; i < FRAMES; i++) {
            orcoAbajoT[i] = getSpriteOrcoT().getTile(ANCHO * i, ALTO * BIG_SIX, ANCHO, ALTO);
        }

        actualizarBarraDeCarga(++elementosCargados, menuCarga);

        for (int i = 0; i < FRAMES; i++) {
            orcoAbajoIzqT[i] = getSpriteOrcoT().getTile(ANCHO * i, ALTO * BIG_SEVEN, ANCHO, ALTO);
        }

        actualizarBarraDeCarga(++elementosCargados, menuCarga);

        orcoT.add(orcoIzqT);
        orcoT.add(orcoArribaIzqT);
        orcoT.add(orcoArribaT);
        orcoT.add(orcoArribaDerT);
        orcoT.add(orcoDerT);
        orcoT.add(orcoAbajoDerT);
        orcoT.add(orcoAbajoT);
        orcoT.add(orcoAbajoIzqT);
        // Fin orco PowerDown
        
        // Inicio Elfo
        spriteElfo = new SpriteSheet(CargadorImagen.cargarImagen("/elfo2.png"));

        actualizarBarraDeCarga(++elementosCargados, menuCarga);

        elfoIzq = new BufferedImage[FRAMES];
        elfoArribaIzq = new BufferedImage[FRAMES];
        elfoArriba = new BufferedImage[FRAMES];
        elfoArribaDer = new BufferedImage[FRAMES];
        elfoDer = new BufferedImage[FRAMES];
        elfoAbajoDer = new BufferedImage[FRAMES];
        elfoAbajo = new BufferedImage[FRAMES];
        elfoAbajoIzq = new BufferedImage[FRAMES];

        for (int i = 0; i < FRAMES; i++) {
            elfoIzq[i] = spriteElfo.getTile(ANCHO * i, 0, ANCHO, ALTO);
        }

        actualizarBarraDeCarga(++elementosCargados, menuCarga);

        for (int i = 0; i < FRAMES; i++) {
            elfoArribaIzq[i] = spriteElfo.getTile(ANCHO * i, ALTO, ANCHO, ALTO);
        }

        actualizarBarraDeCarga(++elementosCargados, menuCarga);

        for (int i = 0; i < FRAMES; i++) {
            elfoArriba[i] = spriteElfo.getTile(ANCHO * i, ALTO * 2, ANCHO, ALTO);
        }

        actualizarBarraDeCarga(++elementosCargados, menuCarga);

        for (int i = 0; i < FRAMES; i++) {
            elfoArribaDer[i] = spriteElfo.getTile(ANCHO * i, ALTO * BIG_THREE, ANCHO, ALTO);
        }

        actualizarBarraDeCarga(++elementosCargados, menuCarga);

        for (int i = 0; i < FRAMES; i++) {
            elfoDer[i] = spriteElfo.getTile(ANCHO * i, ALTO * FRAMES, ANCHO, ALTO);
        }

        actualizarBarraDeCarga(++elementosCargados, menuCarga);

        for (int i = 0; i < FRAMES; i++) {
            elfoAbajoDer[i] = spriteElfo.getTile(ANCHO * i, ALTO * BIG_FIVE, ANCHO, ALTO);
        }

        actualizarBarraDeCarga(++elementosCargados, menuCarga);

        for (int i = 0; i < FRAMES; i++) {
            elfoAbajo[i] = spriteElfo.getTile(ANCHO * i, ALTO * BIG_SIX, ANCHO, ALTO);
        }

        actualizarBarraDeCarga(++elementosCargados, menuCarga);

        for (int i = 0; i < FRAMES; i++) {
            elfoAbajoIzq[i] = spriteElfo.getTile(ANCHO * i, ALTO * BIG_SEVEN, ANCHO, ALTO);
        }

        actualizarBarraDeCarga(++elementosCargados, menuCarga);

        elfo.add(elfoIzq);
        elfo.add(elfoArribaIzq);
        elfo.add(elfoArriba);
        elfo.add(elfoArribaDer);
        elfo.add(elfoDer);
        elfo.add(elfoAbajoDer);
        elfo.add(elfoAbajo);
        elfo.add(elfoAbajoIzq);

        // Fin Elfo
        
        
     // Inicio elfo God Mode
        setSpriteElfoG(new SpriteSheet(ImageIO.read(new File("recursos//elfo2GodMode.png"))));
        
        actualizarBarraDeCarga(++elementosCargados, menuCarga);
        
        elfoIzqG = new BufferedImage[FRAMES];
        elfoArribaIzqG = new BufferedImage[FRAMES];
        elfoArribaG = new BufferedImage[FRAMES];
        elfoArribaDerG = new BufferedImage[FRAMES];
        elfoDerG = new BufferedImage[FRAMES];
        elfoAbajoDerG = new BufferedImage[FRAMES];
        elfoAbajoG = new BufferedImage[FRAMES];
        elfoAbajoIzqG = new BufferedImage[FRAMES];

        for (int i = 0; i < FRAMES; i++) {
            elfoIzqG[i] = getSpriteElfoG().getTile(ANCHO * i, 0, ANCHO, ALTO);
        }

        actualizarBarraDeCarga(++elementosCargados, menuCarga);

        for (int i = 0; i < FRAMES; i++) {
            elfoArribaIzqG[i] = getSpriteElfoG().getTile(ANCHO * i, ALTO, ANCHO, ALTO);
        }

        actualizarBarraDeCarga(++elementosCargados, menuCarga);

        for (int i = 0; i < FRAMES; i++) {
            elfoArribaG[i] = getSpriteElfoG().getTile(ANCHO * i, ALTO * 2, ANCHO, ALTO);
        }

        actualizarBarraDeCarga(++elementosCargados, menuCarga);

        for (int i = 0; i < FRAMES; i++) {
            elfoArribaDerG[i] = getSpriteElfoG().getTile(ANCHO * i, ALTO * BIG_THREE, ANCHO, ALTO);
        }

        actualizarBarraDeCarga(++elementosCargados, menuCarga);

        for (int i = 0; i < FRAMES; i++) {
            elfoDerG[i] = getSpriteElfoG().getTile(ANCHO * i, ALTO * FRAMES, ANCHO, ALTO);
        }

        actualizarBarraDeCarga(++elementosCargados, menuCarga);

        for (int i = 0; i < FRAMES; i++) {
            elfoAbajoDerG[i] = getSpriteElfoG().getTile(ANCHO * i, ALTO * BIG_FIVE, ANCHO, ALTO);
        }

        actualizarBarraDeCarga(++elementosCargados, menuCarga);

        for (int i = 0; i < FRAMES; i++) {
            elfoAbajoG[i] = getSpriteElfoG().getTile(ANCHO * i, ALTO * BIG_SIX, ANCHO, ALTO);
        }

        actualizarBarraDeCarga(++elementosCargados, menuCarga);

        for (int i = 0; i < FRAMES; i++) {
            elfoAbajoIzqG[i] = getSpriteElfoG().getTile(ANCHO * i, ALTO * BIG_SEVEN, ANCHO, ALTO);
        }

        actualizarBarraDeCarga(++elementosCargados, menuCarga);

        elfoG.add(elfoIzqG);
        elfoG.add(elfoArribaIzqG);
        elfoG.add(elfoArribaG);
        elfoG.add(elfoArribaDerG);
        elfoG.add(elfoDerG);
        elfoG.add(elfoAbajoDerG);
        elfoG.add(elfoAbajoG);
        elfoG.add(elfoAbajoIzqG);
        // Fin elfo God Mode
        
        // Inicio elfo Fantasma
        setSpriteElfoF(new SpriteSheet(ImageIO.read(new File("recursos//elfo2Fantasma.png"))));
        
        actualizarBarraDeCarga(++elementosCargados, menuCarga);
        
        elfoIzqF = new BufferedImage[FRAMES];
        elfoArribaIzqF = new BufferedImage[FRAMES];
        elfoArribaF = new BufferedImage[FRAMES];
        elfoArribaDerF = new BufferedImage[FRAMES];
        elfoDerF = new BufferedImage[FRAMES];
        elfoAbajoDerF = new BufferedImage[FRAMES];
        elfoAbajoF = new BufferedImage[FRAMES];
        elfoAbajoIzqF = new BufferedImage[FRAMES];

        for (int i = 0; i < FRAMES; i++) {
            elfoIzqF[i] = getSpriteElfoF().getTile(ANCHO * i, 0, ANCHO, ALTO);
        }

        actualizarBarraDeCarga(++elementosCargados, menuCarga);

        for (int i = 0; i < FRAMES; i++) {
            elfoArribaIzqF[i] = getSpriteElfoF().getTile(ANCHO * i, ALTO, ANCHO, ALTO);
        }

        actualizarBarraDeCarga(++elementosCargados, menuCarga);

        for (int i = 0; i < FRAMES; i++) {
            elfoArribaF[i] = getSpriteElfoF().getTile(ANCHO * i, ALTO * 2, ANCHO, ALTO);
        }

        actualizarBarraDeCarga(++elementosCargados, menuCarga);

        for (int i = 0; i < FRAMES; i++) {
            elfoArribaDerF[i] = getSpriteElfoF().getTile(ANCHO * i, ALTO * BIG_THREE, ANCHO, ALTO);
        }

        actualizarBarraDeCarga(++elementosCargados, menuCarga);

        for (int i = 0; i < FRAMES; i++) {
            elfoDerF[i] = getSpriteElfoF().getTile(ANCHO * i, ALTO * FRAMES, ANCHO, ALTO);
        }

        actualizarBarraDeCarga(++elementosCargados, menuCarga);

        for (int i = 0; i < FRAMES; i++) {
            elfoAbajoDerF[i] = getSpriteElfoF().getTile(ANCHO * i, ALTO * BIG_FIVE, ANCHO, ALTO);
        }

        actualizarBarraDeCarga(++elementosCargados, menuCarga);

        for (int i = 0; i < FRAMES; i++) {
            elfoAbajoF[i] = getSpriteElfoF().getTile(ANCHO * i, ALTO * BIG_SIX, ANCHO, ALTO);
        }

        actualizarBarraDeCarga(++elementosCargados, menuCarga);

        for (int i = 0; i < FRAMES; i++) {
            elfoAbajoIzqF[i] = getSpriteElfoF().getTile(ANCHO * i, ALTO * BIG_SEVEN, ANCHO, ALTO);
        }

        actualizarBarraDeCarga(++elementosCargados, menuCarga);

        elfoF.add(elfoIzqF);
        elfoF.add(elfoArribaIzqF);
        elfoF.add(elfoArribaF);
        elfoF.add(elfoArribaDerF);
        elfoF.add(elfoDerF);
        elfoF.add(elfoAbajoDerF);
        elfoF.add(elfoAbajoF);
        elfoF.add(elfoAbajoIzqF);
        // Fin elfo fantasma
        
        // Inicio elfo Invisible
        setSpriteElfoI(new SpriteSheet(ImageIO.read(new File("recursos//elfo2Invisible.png"))));
        
        actualizarBarraDeCarga(++elementosCargados, menuCarga);
        
        elfoIzqI = new BufferedImage[FRAMES];
        elfoArribaIzqI = new BufferedImage[FRAMES];
        elfoArribaI = new BufferedImage[FRAMES];
        elfoArribaDerI = new BufferedImage[FRAMES];
        elfoDerI = new BufferedImage[FRAMES];
        elfoAbajoDerI = new BufferedImage[FRAMES];
        elfoAbajoI = new BufferedImage[FRAMES];
        elfoAbajoIzqI = new BufferedImage[FRAMES];

        for (int i = 0; i < FRAMES; i++) {
            elfoIzqI[i] = getSpriteElfoI().getTile(ANCHO * i, 0, ANCHO, ALTO);
        }

        actualizarBarraDeCarga(++elementosCargados, menuCarga);

        for (int i = 0; i < FRAMES; i++) {
            elfoArribaIzqI[i] = getSpriteElfoI().getTile(ANCHO * i, ALTO, ANCHO, ALTO);
        }

        actualizarBarraDeCarga(++elementosCargados, menuCarga);

        for (int i = 0; i < FRAMES; i++) {
            elfoArribaI[i] = getSpriteElfoI().getTile(ANCHO * i, ALTO * 2, ANCHO, ALTO);
        }

        actualizarBarraDeCarga(++elementosCargados, menuCarga);

        for (int i = 0; i < FRAMES; i++) {
            elfoArribaDerI[i] = getSpriteElfoI().getTile(ANCHO * i, ALTO * BIG_THREE, ANCHO, ALTO);
        }

        actualizarBarraDeCarga(++elementosCargados, menuCarga);

        for (int i = 0; i < FRAMES; i++) {
            elfoDerI[i] = getSpriteElfoI().getTile(ANCHO * i, ALTO * FRAMES, ANCHO, ALTO);
        }

        actualizarBarraDeCarga(++elementosCargados, menuCarga);

        for (int i = 0; i < FRAMES; i++) {
            elfoAbajoDerI[i] = getSpriteElfoI().getTile(ANCHO * i, ALTO * BIG_FIVE, ANCHO, ALTO);
        }

        actualizarBarraDeCarga(++elementosCargados, menuCarga);

        for (int i = 0; i < FRAMES; i++) {
            elfoAbajoI[i] = getSpriteElfoI().getTile(ANCHO * i, ALTO * BIG_SIX, ANCHO, ALTO);
        }

        actualizarBarraDeCarga(++elementosCargados, menuCarga);

        for (int i = 0; i < FRAMES; i++) {
            elfoAbajoIzqI[i] = getSpriteElfoI().getTile(ANCHO * i, ALTO * BIG_SEVEN, ANCHO, ALTO);
        }

        actualizarBarraDeCarga(++elementosCargados, menuCarga);

        elfoI.add(elfoIzqI);
        elfoI.add(elfoArribaIzqI);
        elfoI.add(elfoArribaI);
        elfoI.add(elfoArribaDerI);
        elfoI.add(elfoDerI);
        elfoI.add(elfoAbajoDerI);
        elfoI.add(elfoAbajoI);
        elfoI.add(elfoAbajoIzqI);
        // Fin elfo Invisible
        
        // Inicio elfo PowerUp
        setSpriteElfoB(new SpriteSheet(ImageIO.read(new File("recursos//elfo2Big.png"))));
        
        actualizarBarraDeCarga(++elementosCargados, menuCarga);
        
        elfoIzqB = new BufferedImage[FRAMES];
        elfoArribaIzqB = new BufferedImage[FRAMES];
        elfoArribaB = new BufferedImage[FRAMES];
        elfoArribaDerB = new BufferedImage[FRAMES];
        elfoDerB = new BufferedImage[FRAMES];
        elfoAbajoDerB = new BufferedImage[FRAMES];
        elfoAbajoB = new BufferedImage[FRAMES];
        elfoAbajoIzqB = new BufferedImage[FRAMES];

        for (int i = 0; i < FRAMES; i++) {
            elfoIzqB[i] = getSpriteElfoB().getTile(ANCHO * i, 0, ANCHO, ALTO);
        }

        actualizarBarraDeCarga(++elementosCargados, menuCarga);

        for (int i = 0; i < FRAMES; i++) {
            elfoArribaIzqB[i] = getSpriteElfoB().getTile(ANCHO * i, ALTO, ANCHO, ALTO);
        }

        actualizarBarraDeCarga(++elementosCargados, menuCarga);

        for (int i = 0; i < FRAMES; i++) {
            elfoArribaB[i] = getSpriteElfoB().getTile(ANCHO * i, ALTO * 2, ANCHO, ALTO);
        }

        actualizarBarraDeCarga(++elementosCargados, menuCarga);

        for (int i = 0; i < FRAMES; i++) {
            elfoArribaDerB[i] = getSpriteElfoB().getTile(ANCHO * i, ALTO * BIG_THREE, ANCHO, ALTO);
        }

        actualizarBarraDeCarga(++elementosCargados, menuCarga);

        for (int i = 0; i < FRAMES; i++) {
            elfoDerB[i] = getSpriteElfoB().getTile(ANCHO * i, ALTO * FRAMES, ANCHO, ALTO);
        }

        actualizarBarraDeCarga(++elementosCargados, menuCarga);

        for (int i = 0; i < FRAMES; i++) {
            elfoAbajoDerB[i] = getSpriteElfoB().getTile(ANCHO * i, ALTO * BIG_FIVE, ANCHO, ALTO);
        }

        actualizarBarraDeCarga(++elementosCargados, menuCarga);

        for (int i = 0; i < FRAMES; i++) {
            elfoAbajoB[i] = getSpriteElfoB().getTile(ANCHO * i, ALTO * BIG_SIX, ANCHO, ALTO);
        }

        actualizarBarraDeCarga(++elementosCargados, menuCarga);

        for (int i = 0; i < FRAMES; i++) {
            elfoAbajoIzqB[i] = getSpriteElfoB().getTile(ANCHO * i, ALTO * BIG_SEVEN, ANCHO, ALTO);
        }

        actualizarBarraDeCarga(++elementosCargados, menuCarga);

        elfoB.add(elfoIzqB);
        elfoB.add(elfoArribaIzqB);
        elfoB.add(elfoArribaB);
        elfoB.add(elfoArribaDerB);
        elfoB.add(elfoDerB);
        elfoB.add(elfoAbajoDerB);
        elfoB.add(elfoAbajoB);
        elfoB.add(elfoAbajoIzqB);
        // Fin elfo PowerUp
        
        // Inicio elfo PowerDown
        setSpriteElfoT(new SpriteSheet(ImageIO.read(new File("recursos//elfo2Tiny.png"))));
        
        actualizarBarraDeCarga(++elementosCargados, menuCarga);
        
        elfoIzqT = new BufferedImage[FRAMES];
        elfoArribaIzqT = new BufferedImage[FRAMES];
        elfoArribaT = new BufferedImage[FRAMES];
        elfoArribaDerT = new BufferedImage[FRAMES];
        elfoDerT = new BufferedImage[FRAMES];
        elfoAbajoDerT = new BufferedImage[FRAMES];
        elfoAbajoT = new BufferedImage[FRAMES];
        elfoAbajoIzqT = new BufferedImage[FRAMES];

        for (int i = 0; i < FRAMES; i++) {
            elfoIzqT[i] = getSpriteElfoT().getTile(ANCHO * i, 0, ANCHO, ALTO);
        }

        actualizarBarraDeCarga(++elementosCargados, menuCarga);

        for (int i = 0; i < FRAMES; i++) {
            elfoArribaIzqT[i] = getSpriteElfoT().getTile(ANCHO * i, ALTO, ANCHO, ALTO);
        }

        actualizarBarraDeCarga(++elementosCargados, menuCarga);

        for (int i = 0; i < FRAMES; i++) {
            elfoArribaT[i] = getSpriteElfoT().getTile(ANCHO * i, ALTO * 2, ANCHO, ALTO);
        }

        actualizarBarraDeCarga(++elementosCargados, menuCarga);

        for (int i = 0; i < FRAMES; i++) {
            elfoArribaDerT[i] = getSpriteElfoT().getTile(ANCHO * i, ALTO * BIG_THREE, ANCHO, ALTO);
        }

        actualizarBarraDeCarga(++elementosCargados, menuCarga);

        for (int i = 0; i < FRAMES; i++) {
            elfoDerT[i] = getSpriteElfoT().getTile(ANCHO * i, ALTO * FRAMES, ANCHO, ALTO);
        }

        actualizarBarraDeCarga(++elementosCargados, menuCarga);

        for (int i = 0; i < FRAMES; i++) {
            elfoAbajoDerT[i] = getSpriteElfoT().getTile(ANCHO * i, ALTO * BIG_FIVE, ANCHO, ALTO);
        }

        actualizarBarraDeCarga(++elementosCargados, menuCarga);

        for (int i = 0; i < FRAMES; i++) {
            elfoAbajoT[i] = getSpriteElfoT().getTile(ANCHO * i, ALTO * BIG_SIX, ANCHO, ALTO);
        }

        actualizarBarraDeCarga(++elementosCargados, menuCarga);

        for (int i = 0; i < FRAMES; i++) {
            elfoAbajoIzqT[i] = getSpriteElfoT().getTile(ANCHO * i, ALTO * BIG_SEVEN, ANCHO, ALTO);
        }

        actualizarBarraDeCarga(++elementosCargados, menuCarga);

        elfoT.add(elfoIzqT);
        elfoT.add(elfoArribaIzqT);
        elfoT.add(elfoArribaT);
        elfoT.add(elfoArribaDerT);
        elfoT.add(elfoDerT);
        elfoT.add(elfoAbajoDerT);
        elfoT.add(elfoAbajoT);
        elfoT.add(elfoAbajoIzqT);
        // Fin elfo PowerDown
        
        // Agrego los pj al hash
        personaje.put("Humano", humano);
        personaje.put("Orco", orco);
        personaje.put("Elfo", elfo);
        
        //cheats
        personaje.put("HumanoGodMode", humanoG);
        personaje.put("HumanoFantasma", humanoF);
        personaje.put("HumanoInvisible", humanoI);
        personaje.put("HumanoBig", humanoB);
        personaje.put("HumanoTiny", humanoT);
        personaje.put("OrcoGodMode", orcoG);
        personaje.put("OrcoFantasma", orcoF);
        personaje.put("OrcoInvisible", orcoI);
        personaje.put("OrcoBig", orcoB);
        personaje.put("OrcoTiny", orcoT);
        personaje.put("ElfoGodMode", elfoG);
        personaje.put("ElfoFantasma", elfoF);
        personaje.put("ElfoInvisible", elfoI);
        personaje.put("ElfoBig", elfoB);
        personaje.put("ElfoTiny", elfoT);
        
        // Inicio Entorno
        setCesped(CargadorImagen.cargarImagen("/Cesped.png"));
        actualizarBarraDeCarga(++elementosCargados, menuCarga);
        setRoca(CargadorImagen.cargarImagen("/rock.png"));
        actualizarBarraDeCarga(++elementosCargados, menuCarga);
        setBackground(CargadorImagen.cargarImagen("/background.jpg"));
        actualizarBarraDeCarga(++elementosCargados, menuCarga);
        setMarco(CargadorImagen.cargarImagen("/marco.png"));
        actualizarBarraDeCarga(++elementosCargados, menuCarga);
        setBotonMenu(CargadorImagen.cargarImagen("/botonMenu.png"));
        actualizarBarraDeCarga(++elementosCargados, menuCarga);
        setMenuEnemigo(CargadorImagen.cargarImagen("/MenuEnemigo.png"));
        actualizarBarraDeCarga(++elementosCargados, menuCarga);
        trees = new SpriteSheet(CargadorImagen.cargarImagen("/trees.png"));
        actualizarBarraDeCarga(++elementosCargados, menuCarga);
        setGreenTree(trees.getTile(0, 0, GREEN_TREE_H, GREEN_TREE_W));
        actualizarBarraDeCarga(++elementosCargados, menuCarga);
        setNievePiso1(CargadorImagen.cargarImagen("/nieve piso.png"));
        actualizarBarraDeCarga(++elementosCargados, menuCarga);
        setIceBlock(CargadorImagen.cargarImagen("/nieve cubo.png"));

        // Mapa
        if (MenuMapas.numberMap == 1) {
            SpriteSheet mapaAubenor = new SpriteSheet(CargadorImagen.cargarImagen("/Aubenor.png"));
            Tile.setAubenor(new Tile[MAGIC_TILENUMBER]);
            boolean[][] solidezAubenor = {
                {
                    true, true, false, true, false, true, true, true, true, true },
                {
                    true, true, true, true, true, true, true, true, true, true },
                {
                    true, true, true, true, true, true, true, true, true, true },
                {
                    true, false, false, false, false, false, false, false, true, true },
                {
                    false, false, false, false, false, false, false, false, true, true },
                {
                    false, true, true, true, true, true, true, true, true, true },
                {
                    true, true, true, true, true, true, true, true, true, true },
                {
                    true, true, true, true, true, true, true, true, true, true } };
            for (int y = 0; y < BIG_EIGHT; y++) {
                for (int x = 0; x < BIG_TEN; x++) {
                    Tile.getAubenor()[y * BIG_TEN + x + 1] = new Tile(mapaAubenor.getTile(x * GRAN_SESENTAYCUATRO
                    		, y * GRAN_SESENTAYCUATRO, GRAN_SESENTAYCUATRO
                    		, GRAN_SESENTAYCUATRO), y * BIG_TEN + x + 1,
                        solidezAubenor[y][x], GRAN_SESENTAYCUATRO, GRAN_SESENTAYCUATRO);
                }
            }
        } else {
            SpriteSheet mapaAris = new SpriteSheet(CargadorImagen.cargarImagen("/Aris.png"));
            Tile.setAris(new Tile[MAGIC_TILENUMBER]);
            boolean[][] solidezAris = {
                {
                    true, false, false, false, false, false, false, true, true, true },
                {
                    false, false, false, false, false, false, false, false, true, true },
                {
                    false, false, false, false, true, true, true, true, true, true },
                {
                    true, true, true, true, true, true, true, true, true, true },
                {
                    true, true, true, true, true, true, true, true, true, true },
                {
                    false, true, true, true, true, true, true, true, true, true },
                {
                    true, true, true, true, true, true, true, true, true, true },
                {
                    true, true, true, true, true, true, true, true, true, true } };
            for (int y = 0; y < BIG_EIGHT; y++) {
                for (int x = 0; x < BIG_TEN; x++) {
                    Tile.getAris()[y * BIG_TEN + x + 1] = new Tile(mapaAris.getTile(x * GRAN_SESENTAYCUATRO
                    		, y * GRAN_SESENTAYCUATRO, GRAN_SESENTAYCUATRO
                    		, GRAN_SESENTAYCUATRO), y * BIG_TEN + x + 1,
                        solidezAris[y][x], GRAN_SESENTAYCUATRO, GRAN_SESENTAYCUATRO);
                }
            }
        }

        // Fin Entorno

        // Inicio Batalla
        setBarraSpells(CargadorImagen.cargarImagen("/BarraSpells.png"));
        actualizarBarraDeCarga(++elementosCargados, menuCarga);
        setEstadoPersonaje(CargadorImagen.cargarImagen("/EstadoPersonaje.png"));
        actualizarBarraDeCarga(++elementosCargados, menuCarga);
        setBarraSalud(CargadorImagen.cargarImagen("/BarraDeSalud.png"));
        actualizarBarraDeCarga(++elementosCargados, menuCarga);
        setBarraEnergia(CargadorImagen.cargarImagen("/BarraDeEnergia.png"));
        actualizarBarraDeCarga(++elementosCargados, menuCarga);
        setBarraExperiencia(CargadorImagen.cargarImagen("/BarraDeExperiencia.png"));
        actualizarBarraDeCarga(++elementosCargados, menuCarga);

        habilidades.put("Golpe Level", CargadorImagen.cargarImagen("/Golpe Level.png"));
        actualizarBarraDeCarga(++elementosCargados, menuCarga);

        habilidades.put("Ataque Bosque", CargadorImagen.cargarImagen("/Ataque Bosque.png"));
        actualizarBarraDeCarga(++elementosCargados, menuCarga);

        habilidades.put("Golpe Defensa", CargadorImagen.cargarImagen("/Golpe Defensa.png"));
        actualizarBarraDeCarga(++elementosCargados, menuCarga);

        habilidades.put("Mordisco de Vida", CargadorImagen.cargarImagen("/Mordisco de Vida.png"));
        actualizarBarraDeCarga(++elementosCargados, menuCarga);

        habilidades.put("Incentivar", CargadorImagen.cargarImagen("/Incentivar.png"));
        actualizarBarraDeCarga(++elementosCargados, menuCarga);

        habilidades.put("Golpe Fatal", CargadorImagen.cargarImagen("/Golpe Fatal.png"));
        actualizarBarraDeCarga(++elementosCargados, menuCarga);

        habilidades.put("Ataque Doble", CargadorImagen.cargarImagen("/Ataque Doble.png"));
        actualizarBarraDeCarga(++elementosCargados, menuCarga);

        habilidades.put("Aumentar Defensa", CargadorImagen.cargarImagen("/Aumentar Defensa.png"));
        actualizarBarraDeCarga(++elementosCargados, menuCarga);

        habilidades.put("Ignorar Defensa", CargadorImagen.cargarImagen("/Ignorar Defensa.png"));
        actualizarBarraDeCarga(++elementosCargados, menuCarga);

        habilidades.put("Bola de Fuego", CargadorImagen.cargarImagen("/Bola de Fuego.png"));
        actualizarBarraDeCarga(++elementosCargados, menuCarga);

        habilidades.put("Curar Aliado", CargadorImagen.cargarImagen("/Curar Aliado.png"));
        actualizarBarraDeCarga(++elementosCargados, menuCarga);

        habilidades.put("Robar Energia y Salud", CargadorImagen.cargarImagen("/Robar Energia y Salud.png"));
        actualizarBarraDeCarga(++elementosCargados, menuCarga);

        habilidades.put("Golpe Critico", CargadorImagen.cargarImagen("/Golpe Critico.png"));
        actualizarBarraDeCarga(++elementosCargados, menuCarga);

        habilidades.put("Aumentar Evasion", CargadorImagen.cargarImagen("/Aumentar Evasion.png"));
        actualizarBarraDeCarga(++elementosCargados, menuCarga);

        habilidades.put("Robar", CargadorImagen.cargarImagen("/Robar.png"));
        actualizarBarraDeCarga(++elementosCargados, menuCarga);

        habilidades.put("Ser Energizado", CargadorImagen.cargarImagen("/Ser Energizado.png"));
        actualizarBarraDeCarga(++elementosCargados, menuCarga);

        setMenuBatalla(CargadorImagen.cargarImagen("/MenuBatalla.png"));
        actualizarBarraDeCarga(++elementosCargados, menuCarga);

        setMenuBatallaDeshabilitado(CargadorImagen.cargarImagen("/MenuBatallaDeshabilitado.png"));
        actualizarBarraDeCarga(++elementosCargados, menuCarga);
        // Fin Batalla
    }

    /**
     * Actualizar barra de carga.
     *
     * @param elementosCargados
     *            the elementos cargados
     * @param menuCarga
     *            the menu carga
     */
    private static void actualizarBarraDeCarga(final int elementosCargados, final MenuCarga menuCarga) {
        menuCarga.setBarraCargando(elementosCargados * ANCHOBARRA / ELEMENTOS);
    }

	/**
	 * @return the monstruo
	 */
	public static BufferedImage getMonstruo() {
		return monstruo;
	}

	/**
	 * @param monstruo the monstruo to set
	 */
	public static void setMonstruo(final BufferedImage monstruo) {
		Recursos.monstruo = monstruo;
	}

	/**
	 * @return the cesped
	 */
	public static BufferedImage getCesped() {
		return cesped;
	}

	/**
	 * @param cesped the cesped to set
	 */
	public static void setCesped(final BufferedImage cesped) {
		Recursos.cesped = cesped;
	}

	/**
	 * @return the roca
	 */
	public static BufferedImage getRoca() {
		return roca;
	}

	/**
	 * @param roca the roca to set
	 */
	public static void setRoca(final BufferedImage roca) {
		Recursos.roca = roca;
	}

	/**
	 * @return the background
	 */
	public static BufferedImage getBackground() {
		return background;
	}

	/**
	 * @param background the background to set
	 */
	public static void setBackground(final BufferedImage background) {
		Recursos.background = background;
	}

	/**
	 * @return the marco
	 */
	public static BufferedImage getMarco() {
		return marco;
	}

	/**
	 * @param marco the marco to set
	 */
	public static void setMarco(final BufferedImage marco) {
		Recursos.marco = marco;
	}

	/**
	 * @return the botonMenu
	 */
	public static BufferedImage getBotonMenu() {
		return botonMenu;
	}

	/**
	 * @param botonMenu the botonMenu to set
	 */
	public static void setBotonMenu(final BufferedImage botonMenu) {
		Recursos.botonMenu = botonMenu;
	}

	/**
	 * @return the menuEnemigo
	 */
	public static BufferedImage getMenuEnemigo() {
		return menuEnemigo;
	}

	/**
	 * @param menuEnemigo the menuEnemigo to set
	 */
	public static void setMenuEnemigo(final BufferedImage menuEnemigo) {
		Recursos.menuEnemigo = menuEnemigo;
	}

	/**
	 * @return the greenTree
	 */
	public static BufferedImage getGreenTree() {
		return greenTree;
	}

	/**
	 * @param greenTree the greenTree to set
	 */
	public static void setGreenTree(final BufferedImage greenTree) {
		Recursos.greenTree = greenTree;
	}

	/**
	 * @return the nievePiso1
	 */
	public static BufferedImage getNievePiso1() {
		return nievePiso1;
	}

	/**
	 * @param nievePiso1 the nievePiso1 to set
	 */
	public static void setNievePiso1(final BufferedImage nievePiso1) {
		Recursos.nievePiso1 = nievePiso1;
	}

	/**
	 * @return the iceBlock
	 */
	public static BufferedImage getIceBlock() {
		return iceBlock;
	}

	/**
	 * @param iceBlock the iceBlock to set
	 */
	public static void setIceBlock(final BufferedImage iceBlock) {
		Recursos.iceBlock = iceBlock;
	}

	/**
	 * @return the barraSpells
	 */
	public static BufferedImage getBarraSpells() {
		return barraSpells;
	}

	/**
	 * @param barraSpells the barraSpells to set
	 */
	public static void setBarraSpells(final BufferedImage barraSpells) {
		Recursos.barraSpells = barraSpells;
	}

	/**
	 * @return the estadoPersonaje
	 */
	public static BufferedImage getEstadoPersonaje() {
		return estadoPersonaje;
	}

	/**
	 * @param estadoPersonaje the estadoPersonaje to set
	 */
	public static void setEstadoPersonaje(final BufferedImage estadoPersonaje) {
		Recursos.estadoPersonaje = estadoPersonaje;
	}

	/**
	 * @return the barraSalud
	 */
	public static BufferedImage getBarraSalud() {
		return barraSalud;
	}

	/**
	 * @param barraSalud the barraSalud to set
	 */
	public static void setBarraSalud(final BufferedImage barraSalud) {
		Recursos.barraSalud = barraSalud;
	}

	/**
	 * @return the barraEnergia
	 */
	public static BufferedImage getBarraEnergia() {
		return barraEnergia;
	}

	/**
	 * @param barraEnergia the barraEnergia to set
	 */
	public static void setBarraEnergia(final BufferedImage barraEnergia) {
		Recursos.barraEnergia = barraEnergia;
	}

	/**
	 * @return the barraExperiencia
	 */
	public static BufferedImage getBarraExperiencia() {
		return barraExperiencia;
	}

	/**
	 * @param barraExperiencia the barraExperiencia to set
	 */
	public static void setBarraExperiencia(final BufferedImage barraExperiencia) {
		Recursos.barraExperiencia = barraExperiencia;
	}

	/**
	 * @return the menuBatalla
	 */
	public static BufferedImage getMenuBatalla() {
		return menuBatalla;
	}

	/**
	 * @param menuBatalla the menuBatalla to set
	 */
	public static void setMenuBatalla(final BufferedImage menuBatalla) {
		Recursos.menuBatalla = menuBatalla;
	}

	/**
	 * @return the menuBatallaDeshabilitado
	 */
	public static BufferedImage getMenuBatallaDeshabilitado() {
		return menuBatallaDeshabilitado;
	}

	/**
	 * @param menuBatallaDeshabilitado the menuBatallaDeshabilitado to set
	 */
	public static void setMenuBatallaDeshabilitado(final BufferedImage menuBatallaDeshabilitado) {
		Recursos.menuBatallaDeshabilitado = menuBatallaDeshabilitado;
	}

	/**
	 * @return the noItem
	 */
	public static BufferedImage getNoItem() {
		return noItem;
	}

	/**
	 * @param noItem the noItem to set
	 */
	public static void setNoItem(final BufferedImage noItem) {
		Recursos.noItem = noItem;
	}

	/**
	 * @return the mochila
	 */
	public static BufferedImage getMochila() {
		return mochila;
	}

	/**
	 * @param mochila the mochila to set
	 */
	public static void setMochila(final BufferedImage mochila) {
		Recursos.mochila = mochila;
	}

	/**
	 * @return the menu
	 */
	public static BufferedImage getMenu() {
		return menu;
	}

	/**
	 * @param menu the menu to set
	 */
	public static void setMenu(final BufferedImage menu) {
		Recursos.menu = menu;
	}

	/**
	 * @return the chat
	 */
	public static BufferedImage getChat() {
		return chat;
	}

	/**
	 * @param chat the chat to set
	 */
	public static void setChat(final BufferedImage chat) {
		Recursos.chat = chat;
	}

	/**
	 * @return the personaje
	 */
	public static Map<String, LinkedList<BufferedImage[]>> getPersonaje() {
		return personaje;
	}

	/**
	 * @param personaje the personaje to set
	 */
	public static void setPersonaje(final Map<String, LinkedList<BufferedImage[]>> personaje) {
		Recursos.personaje = personaje;
	}

	/**
	 * @return the spriteHumano
	 */
	public static SpriteSheet getSpriteHumano() {
		return spriteHumano;
	}

	/**
	 * @param spriteHumano the spriteHumano to set
	 */
	public static void setSpriteHumano(final SpriteSheet spriteHumano) {
		Recursos.spriteHumano = spriteHumano;
	}

	/**
	 * @return the humano
	 */
	public static LinkedList<BufferedImage[]> getHumano() {
		return humano;
	}

	/**
	 * @param humano the humano to set
	 */
	public static void setHumano(final LinkedList<BufferedImage[]> humano) {
		Recursos.humano = humano;
	}

	/**
	 * @return the humanoIzq
	 */
	public static BufferedImage[] getHumanoIzq() {
		return humanoIzq;
	}

	/**
	 * @param humanoIzq the humanoIzq to set
	 */
	public static void setHumanoIzq(final BufferedImage[] humanoIzq) {
		Recursos.humanoIzq = humanoIzq;
	}

	/**
	 * @return the humanoArribaIzq
	 */
	public static BufferedImage[] getHumanoArribaIzq() {
		return humanoArribaIzq;
	}

	/**
	 * @param humanoArribaIzq the humanoArribaIzq to set
	 */
	public static void setHumanoArribaIzq(final BufferedImage[] humanoArribaIzq) {
		Recursos.humanoArribaIzq = humanoArribaIzq;
	}

	/**
	 * @return the humanoArriba
	 */
	public static BufferedImage[] getHumanoArriba() {
		return humanoArriba;
	}

	/**
	 * @param humanoArriba the humanoArriba to set
	 */
	public static void setHumanoArriba(final BufferedImage[] humanoArriba) {
		Recursos.humanoArriba = humanoArriba;
	}

	/**
	 * @return the humanoArribaDer
	 */
	public static BufferedImage[] getHumanoArribaDer() {
		return humanoArribaDer;
	}

	/**
	 * @param humanoArribaDer the humanoArribaDer to set
	 */
	public static void setHumanoArribaDer(final BufferedImage[] humanoArribaDer) {
		Recursos.humanoArribaDer = humanoArribaDer;
	}

	/**
	 * @return the humanoDer
	 */
	public static BufferedImage[] getHumanoDer() {
		return humanoDer;
	}

	/**
	 * @param humanoDer the humanoDer to set
	 */
	public static void setHumanoDer(final BufferedImage[] humanoDer) {
		Recursos.humanoDer = humanoDer;
	}

	/**
	 * @return the humanoAbajoDer
	 */
	public static BufferedImage[] getHumanoAbajoDer() {
		return humanoAbajoDer;
	}

	/**
	 * @param humanoAbajoDer the humanoAbajoDer to set
	 */
	public static void setHumanoAbajoDer(final BufferedImage[] humanoAbajoDer) {
		Recursos.humanoAbajoDer = humanoAbajoDer;
	}

	/**
	 * @return the humanoAbajo
	 */
	public static BufferedImage[] getHumanoAbajo() {
		return humanoAbajo;
	}

	/**
	 * @param humanoAbajo the humanoAbajo to set
	 */
	public static void setHumanoAbajo(final BufferedImage[] humanoAbajo) {
		Recursos.humanoAbajo = humanoAbajo;
	}

	/**
	 * @return the humanoAbajoIzq
	 */
	public static BufferedImage[] getHumanoAbajoIzq() {
		return humanoAbajoIzq;
	}

	/**
	 * @param humanoAbajoIzq the humanoAbajoIzq to set
	 */
	public static void setHumanoAbajoIzq(final BufferedImage[] humanoAbajoIzq) {
		Recursos.humanoAbajoIzq = humanoAbajoIzq;
	}

	/**
	 * @return the spriteOgro
	 */
	public static SpriteSheet getSpriteOgro() {
		return spriteOgro;
	}

	/**
	 * @param spriteOgro the spriteOgro to set
	 */
	public static void setSpriteOgro(final SpriteSheet spriteOgro) {
		Recursos.spriteOgro = spriteOgro;
	}

	/**
	 * @return the orco
	 */
	public static LinkedList<BufferedImage[]> getOrco() {
		return orco;
	}

	/**
	 * @param orco the orco to set
	 */
	public static void setOrco(final LinkedList<BufferedImage[]> orco) {
		Recursos.orco = orco;
	}

	/**
	 * @return the orcoIzq
	 */
	public static BufferedImage[] getOrcoIzq() {
		return orcoIzq;
	}

	/**
	 * @param orcoIzq the orcoIzq to set
	 */
	public static void setOrcoIzq(final BufferedImage[] orcoIzq) {
		Recursos.orcoIzq = orcoIzq;
	}

	/**
	 * @return the orcoArribaIzq
	 */
	public static BufferedImage[] getOrcoArribaIzq() {
		return orcoArribaIzq;
	}

	/**
	 * @param orcoArribaIzq the orcoArribaIzq to set
	 */
	public static void setOrcoArribaIzq(final BufferedImage[] orcoArribaIzq) {
		Recursos.orcoArribaIzq = orcoArribaIzq;
	}

	/**
	 * @return the orcoArriba
	 */
	public static BufferedImage[] getOrcoArriba() {
		return orcoArriba;
	}

	/**
	 * @param orcoArriba the orcoArriba to set
	 */
	public static void setOrcoArriba(final BufferedImage[] orcoArriba) {
		Recursos.orcoArriba = orcoArriba;
	}

	/**
	 * @return the orcoArribaDer
	 */
	public static BufferedImage[] getOrcoArribaDer() {
		return orcoArribaDer;
	}

	/**
	 * @param orcoArribaDer the orcoArribaDer to set
	 */
	public static void setOrcoArribaDer(final BufferedImage[] orcoArribaDer) {
		Recursos.orcoArribaDer = orcoArribaDer;
	}

	/**
	 * @return the orcoDer
	 */
	public static BufferedImage[] getOrcoDer() {
		return orcoDer;
	}

	/**
	 * @param orcoDer the orcoDer to set
	 */
	public static void setOrcoDer(final BufferedImage[] orcoDer) {
		Recursos.orcoDer = orcoDer;
	}

	/**
	 * @return the orcoAbajoDer
	 */
	public static BufferedImage[] getOrcoAbajoDer() {
		return orcoAbajoDer;
	}

	/**
	 * @param orcoAbajoDer the orcoAbajoDer to set
	 */
	public static void setOrcoAbajoDer(final BufferedImage[] orcoAbajoDer) {
		Recursos.orcoAbajoDer = orcoAbajoDer;
	}

	/**
	 * @return the orcoAbajo
	 */
	public static BufferedImage[] getOrcoAbajo() {
		return orcoAbajo;
	}

	/**
	 * @param orcoAbajo the orcoAbajo to set
	 */
	public static void setOrcoAbajo(final BufferedImage[] orcoAbajo) {
		Recursos.orcoAbajo = orcoAbajo;
	}

	/**
	 * @return the orcoAbajoIzq
	 */
	public static BufferedImage[] getOrcoAbajoIzq() {
		return orcoAbajoIzq;
	}

	/**
	 * @param orcoAbajoIzq the orcoAbajoIzq to set
	 */
	public static void setOrcoAbajoIzq(final BufferedImage[] orcoAbajoIzq) {
		Recursos.orcoAbajoIzq = orcoAbajoIzq;
	}

	/**
	 * @return the spriteElfo
	 */
	public static SpriteSheet getSpriteElfo() {
		return spriteElfo;
	}

	/**
	 * @param spriteElfo the spriteElfo to set
	 */
	public static void setSpriteElfo(final SpriteSheet spriteElfo) {
		Recursos.spriteElfo = spriteElfo;
	}

	/**
	 * @return the elfo
	 */
	public static LinkedList<BufferedImage[]> getElfo() {
		return elfo;
	}

	/**
	 * @param elfo the elfo to set
	 */
	public static void setElfo(final LinkedList<BufferedImage[]> elfo) {
		Recursos.elfo = elfo;
	}

	/**
	 * @return the elfoIzq
	 */
	public static BufferedImage[] getElfoIzq() {
		return elfoIzq;
	}

	/**
	 * @param elfoIzq the elfoIzq to set
	 */
	public static void setElfoIzq(final BufferedImage[] elfoIzq) {
		Recursos.elfoIzq = elfoIzq;
	}

	/**
	 * @return the elfoArribaIzq
	 */
	public static BufferedImage[] getElfoArribaIzq() {
		return elfoArribaIzq;
	}

	/**
	 * @param elfoArribaIzq the elfoArribaIzq to set
	 */
	public static void setElfoArribaIzq(final BufferedImage[] elfoArribaIzq) {
		Recursos.elfoArribaIzq = elfoArribaIzq;
	}

	/**
	 * @return the elfoArriba
	 */
	public static BufferedImage[] getElfoArriba() {
		return elfoArriba;
	}

	/**
	 * @param elfoArriba the elfoArriba to set
	 */
	public static void setElfoArriba(final BufferedImage[] elfoArriba) {
		Recursos.elfoArriba = elfoArriba;
	}

	/**
	 * @return the elfoArribaDer
	 */
	public static BufferedImage[] getElfoArribaDer() {
		return elfoArribaDer;
	}

	/**
	 * @param elfoArribaDer the elfoArribaDer to set
	 */
	public static void setElfoArribaDer(final BufferedImage[] elfoArribaDer) {
		Recursos.elfoArribaDer = elfoArribaDer;
	}

	/**
	 * @return the elfoDer
	 */
	public static BufferedImage[] getElfoDer() {
		return elfoDer;
	}

	/**
	 * @param elfoDer the elfoDer to set
	 */
	public static void setElfoDer(final BufferedImage[] elfoDer) {
		Recursos.elfoDer = elfoDer;
	}

	/**
	 * @return the elfoAbajoDer
	 */
	public static BufferedImage[] getElfoAbajoDer() {
		return elfoAbajoDer;
	}

	/**
	 * @param elfoAbajoDer the elfoAbajoDer to set
	 */
	public static void setElfoAbajoDer(final BufferedImage[] elfoAbajoDer) {
		Recursos.elfoAbajoDer = elfoAbajoDer;
	}

	/**
	 * @return the elfoAbajo
	 */
	public static BufferedImage[] getElfoAbajo() {
		return elfoAbajo;
	}

	/**
	 * @param elfoAbajo the elfoAbajo to set
	 */
	public static void setElfoAbajo(final BufferedImage[] elfoAbajo) {
		Recursos.elfoAbajo = elfoAbajo;
	}

	/**
	 * @return the elfoAbajoIzq
	 */
	public static BufferedImage[] getElfoAbajoIzq() {
		return elfoAbajoIzq;
	}

	/**
	 * @param elfoAbajoIzq the elfoAbajoIzq to set
	 */
	public static void setElfoAbajoIzq(final BufferedImage[] elfoAbajoIzq) {
		Recursos.elfoAbajoIzq = elfoAbajoIzq;
	}

	/**
	 * @return the trees
	 */
	public static SpriteSheet getTrees() {
		return trees;
	}

	/**
	 * @param trees the trees to set
	 */
	public static void setTrees(final SpriteSheet trees) {
		Recursos.trees = trees;
	}

	/**
	 * @return the frames
	 */
	public static int getFrames() {
		return FRAMES;
	}

	/**
	 * @return the elementos
	 */
	public static int getElementos() {
		return ELEMENTOS;
	}

	/**
	 * @return the anchobarra
	 */
	public static int getAnchobarra() {
		return ANCHOBARRA;
	}

	/**
	 * @return the ancho
	 */
	public static int getAncho() {
		return ANCHO;
	}

	/**
	 * @return the alto
	 */
	public static int getAlto() {
		return ALTO;
	}

	/**
	 * @return the habilidades
	 */
	public static Map<String, BufferedImage> getHabilidades() {
		return habilidades;
	}

	/**
	 * @param habilidades the habilidades to set
	 */
	public static void setHabilidades(final Map<String, BufferedImage> habilidades) {
		Recursos.habilidades = habilidades;
	}

	/**
	 * @return the spriteHumanoG
	 */
	public static SpriteSheet getSpriteHumanoG() {
		return spriteHumanoG;
	}

	/**
	 * @param spriteHumanoG the spriteHumanoG to set
	 */
	public static void setSpriteHumanoG(SpriteSheet spriteHumanoG) {
		Recursos.spriteHumanoG = spriteHumanoG;
	}

	/**
	 * @return the spriteHumanoF
	 */
	public static SpriteSheet getSpriteHumanoF() {
		return spriteHumanoF;
	}

	/**
	 * @param spriteHumanoF the spriteHumanoF to set
	 */
	public static void setSpriteHumanoF(SpriteSheet spriteHumanoF) {
		Recursos.spriteHumanoF = spriteHumanoF;
	}

	/**
	 * @return the spriteHumanoI
	 */
	public static SpriteSheet getSpriteHumanoI() {
		return spriteHumanoI;
	}

	/**
	 * @param spriteHumanoI the spriteHumanoI to set
	 */
	public static void setSpriteHumanoI(SpriteSheet spriteHumanoI) {
		Recursos.spriteHumanoI = spriteHumanoI;
	}

	/**
	 * @return the spriteHumanoT
	 */
	public static SpriteSheet getSpriteHumanoT() {
		return spriteHumanoT;
	}

	/**
	 * @param spriteHumanoT the spriteHumanoT to set
	 */
	public static void setSpriteHumanoT(SpriteSheet spriteHumanoT) {
		Recursos.spriteHumanoT = spriteHumanoT;
	}

	/**
	 * @return the humanoB
	 */
	public static LinkedList<BufferedImage[]> getHumanoB() {
		return humanoB;
	}

	/**
	 * @param humanoB the humanoB to set
	 */
	public static void setHumanoB(LinkedList<BufferedImage[]> humanoB) {
		Recursos.humanoB = humanoB;
	}

	/**
	 * @return the spriteHumanoB
	 */
	public static SpriteSheet getSpriteHumanoB() {
		return spriteHumanoB;
	}

	/**
	 * @param spriteHumanoB the spriteHumanoB to set
	 */
	public static void setSpriteHumanoB(SpriteSheet spriteHumanoB) {
		Recursos.spriteHumanoB = spriteHumanoB;
	}

	/**
	 * @return the humanoT
	 */
	public static LinkedList<BufferedImage[]> getHumanoT() {
		return humanoT;
	}

	/**
	 * @param humanoT the humanoT to set
	 */
	public static void setHumanoT(LinkedList<BufferedImage[]> humanoT) {
		Recursos.humanoT = humanoT;
	}

	/**
	 * @return the spriteElfoT
	 */
	public static SpriteSheet getSpriteElfoT() {
		return spriteElfoT;
	}

	/**
	 * @param spriteElfoT the spriteElfoT to set
	 */
	public static void setSpriteElfoT(SpriteSheet spriteElfoT) {
		Recursos.spriteElfoT = spriteElfoT;
	}

	/**
	 * @return the spriteElfoB
	 */
	public static SpriteSheet getSpriteElfoB() {
		return spriteElfoB;
	}

	/**
	 * @param spriteElfoB the spriteElfoB to set
	 */
	public static void setSpriteElfoB(SpriteSheet spriteElfoB) {
		Recursos.spriteElfoB = spriteElfoB;
	}

	/**
	 * @return the spriteElfoI
	 */
	public static SpriteSheet getSpriteElfoI() {
		return spriteElfoI;
	}

	/**
	 * @param spriteElfoI the spriteElfoI to set
	 */
	public static void setSpriteElfoI(SpriteSheet spriteElfoI) {
		Recursos.spriteElfoI = spriteElfoI;
	}

	/**
	 * @return the spriteElfoF
	 */
	public static SpriteSheet getSpriteElfoF() {
		return spriteElfoF;
	}

	/**
	 * @param spriteElfoF the spriteElfoF to set
	 */
	public static void setSpriteElfoF(SpriteSheet spriteElfoF) {
		Recursos.spriteElfoF = spriteElfoF;
	}

	/**
	 * @return the spriteElfoG
	 */
	public static SpriteSheet getSpriteElfoG() {
		return spriteElfoG;
	}

	/**
	 * @param spriteElfoG the spriteElfoG to set
	 */
	public static void setSpriteElfoG(SpriteSheet spriteElfoG) {
		Recursos.spriteElfoG = spriteElfoG;
	}

	/**
	 * @return the spriteOrcoT
	 */
	public static SpriteSheet getSpriteOrcoT() {
		return spriteOrcoT;
	}

	/**
	 * @param spriteOrcoT the spriteOrcoT to set
	 */
	public static void setSpriteOrcoT(SpriteSheet spriteOrcoT) {
		Recursos.spriteOrcoT = spriteOrcoT;
	}

	/**
	 * @return the spriteOrcoB
	 */
	public static SpriteSheet getSpriteOrcoB() {
		return spriteOrcoB;
	}

	/**
	 * @param spriteOrcoB the spriteOrcoB to set
	 */
	public static void setSpriteOrcoB(SpriteSheet spriteOrcoB) {
		Recursos.spriteOrcoB = spriteOrcoB;
	}

	/**
	 * @return the spriteOrcoI
	 */
	public static SpriteSheet getSpriteOrcoI() {
		return spriteOrcoI;
	}

	/**
	 * @param spriteOrcoI the spriteOrcoI to set
	 */
	public static void setSpriteOrcoI(SpriteSheet spriteOrcoI) {
		Recursos.spriteOrcoI = spriteOrcoI;
	}

	/**
	 * @return the spriteOrcoF
	 */
	public static SpriteSheet getSpriteOrcoF() {
		return spriteOrcoF;
	}

	/**
	 * @param spriteOrcoF the spriteOrcoF to set
	 */
	public static void setSpriteOrcoF(SpriteSheet spriteOrcoF) {
		Recursos.spriteOrcoF = spriteOrcoF;
	}

	/**
	 * @return the spriteOrcoG
	 */
	public static SpriteSheet getSpriteOrcoG() {
		return spriteOrcoG;
	}

	/**
	 * @param spriteOrcoG the spriteOrcoG to set
	 */
	public static void setSpriteOrcoG(SpriteSheet spriteOrcoG) {
		Recursos.spriteOrcoG = spriteOrcoG;
	}


}
