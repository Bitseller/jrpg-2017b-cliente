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
public final  class Recursos {

	private static final int FRAMES = 4;
	private static final int ELEMENTOS = 65;
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

	/// NPC
	private static BufferedImage monstruo;

	// Fin Personajes

	// Entorno
	// private static SpriteSheet trees;
	// private static BufferedImage cesped;
	// private static BufferedImage roca;
	private static BufferedImage background;
	private static BufferedImage marco;
	private static BufferedImage botonMenu;
	private static BufferedImage menuEnemigo;
	// private static BufferedImage greenTree;
	// private static BufferedImage nievePiso1;
	// private static BufferedImage iceBlock;
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

		// Items

		noItem = ImageIO.read(new File("recursos//noItem.png"));
		mochila = ImageIO.read(new File("recursos//mochila.png"));
		menu = ImageIO.read(new File("recursos//menu.png"));
		chat = ImageIO.read(new File("recursos//chat.png"));

		// NPC
		monstruo = ImageIO.read(new File("recursos//npc.png"));

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
			humanoArribaDer[i] = spriteHumano.getTile(ANCHO * i, ALTO * 3, ANCHO, ALTO);
		}

		actualizarBarraDeCarga(++elementosCargados, menuCarga);

		for (int i = 0; i < FRAMES; i++) {
			humanoDer[i] = spriteHumano.getTile(ANCHO * i, ALTO * FRAMES, ANCHO, ALTO);
		}

		actualizarBarraDeCarga(++elementosCargados, menuCarga);

		for (int i = 0; i < FRAMES; i++) {
			humanoAbajoDer[i] = spriteHumano.getTile(ANCHO * i, ALTO * 5, ANCHO, ALTO);
		}

		actualizarBarraDeCarga(++elementosCargados, menuCarga);

		for (int i = 0; i < FRAMES; i++) {
			humanoAbajo[i] = spriteHumano.getTile(ANCHO * i, ALTO * 6, ANCHO, ALTO);
		}

		actualizarBarraDeCarga(++elementosCargados, menuCarga);

		for (int i = 0; i < FRAMES; i++) {
			humanoAbajoIzq[i] = spriteHumano.getTile(ANCHO * i, ALTO * 7, ANCHO, ALTO);
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
			orcoArribaDer[i] = spriteOgro.getTile(ANCHO * i, ALTO * 3, ANCHO, ALTO);
		}

		actualizarBarraDeCarga(++elementosCargados, menuCarga);

		for (int i = 0; i < FRAMES; i++) {
			orcoDer[i] = spriteOgro.getTile(ANCHO * i, ALTO * FRAMES, ANCHO, ALTO);
		}

		actualizarBarraDeCarga(++elementosCargados, menuCarga);

		for (int i = 0; i < FRAMES; i++) {
			orcoAbajoDer[i] = spriteOgro.getTile(ANCHO * i, ALTO * 5, ANCHO, ALTO);
		}

		actualizarBarraDeCarga(++elementosCargados, menuCarga);

		for (int i = 0; i < FRAMES; i++) {
			orcoAbajo[i] = spriteOgro.getTile(ANCHO * i, ALTO * 6, ANCHO, ALTO);
		}

		actualizarBarraDeCarga(++elementosCargados, menuCarga);

		for (int i = 0; i < FRAMES; i++) {
			orcoAbajoIzq[i] = spriteOgro.getTile(ANCHO * i, ALTO * 7, ANCHO, ALTO);
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
			elfoArribaDer[i] = spriteElfo.getTile(ANCHO * i, ALTO * 3, ANCHO, ALTO);
		}

		actualizarBarraDeCarga(++elementosCargados, menuCarga);

		for (int i = 0; i < FRAMES; i++) {
			elfoDer[i] = spriteElfo.getTile(ANCHO * i, ALTO * FRAMES, ANCHO, ALTO);
		}

		actualizarBarraDeCarga(++elementosCargados, menuCarga);

		for (int i = 0; i < FRAMES; i++) {
			elfoAbajoDer[i] = spriteElfo.getTile(ANCHO * i, ALTO * 5, ANCHO, ALTO);
		}

		actualizarBarraDeCarga(++elementosCargados, menuCarga);

		for (int i = 0; i < FRAMES; i++) {
			elfoAbajo[i] = spriteElfo.getTile(ANCHO * i, ALTO * 6, ANCHO, ALTO);
		}

		actualizarBarraDeCarga(++elementosCargados, menuCarga);

		for (int i = 0; i < FRAMES; i++) {
			elfoAbajoIzq[i] = spriteElfo.getTile(ANCHO * i, ALTO * 7, ANCHO, ALTO);
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

		// Agrego los pj al hash
		personaje.put("Humano", humano);
		personaje.put("Orco", orco);
		personaje.put("Elfo", elfo);

		// Inicio Entorno
		// cesped = CargadorImagen.cargarImagen("/Cesped.png");
		actualizarBarraDeCarga(++elementosCargados, menuCarga);
		// roca = CargadorImagen.cargarImagen("/rock.png");
		actualizarBarraDeCarga(++elementosCargados, menuCarga);
		// background = CargadorImagen.cargarImagen("/background.jpg");
		actualizarBarraDeCarga(++elementosCargados, menuCarga);
		// marco = CargadorImagen.cargarImagen("/marco.png");
		actualizarBarraDeCarga(++elementosCargados, menuCarga);
		// botonMenu = CargadorImagen.cargarImagen("/botonMenu.png");
		actualizarBarraDeCarga(++elementosCargados, menuCarga);
		// menuEnemigo = CargadorImagen.cargarImagen("/MenuEnemigo.png");
		actualizarBarraDeCarga(++elementosCargados, menuCarga);
		// trees = new SpriteSheet(CargadorImagen.cargarImagen("/trees.png"));
		actualizarBarraDeCarga(++elementosCargados, menuCarga);
		// greenTree = trees.getTile(0, 0, 42, 50);
		actualizarBarraDeCarga(++elementosCargados, menuCarga);
		// nievePiso1 = CargadorImagen.cargarImagen("/nieve piso.png");
		actualizarBarraDeCarga(++elementosCargados, menuCarga);
		// iceBlock = CargadorImagen.cargarImagen("/nieve cubo.png");

		// Mapa
		if (MenuMapas.getNumberMap() == 1) {
			SpriteSheet mapaAubenor = new SpriteSheet(CargadorImagen.cargarImagen("/Aubenor.png"));
			Tile.setAubenor(new Tile[81]);
			boolean[][] solidezAubenor = {{true, true, false, true, false, true, true, true, true, true},
			        {true, true, true, true, true, true, true, true, true, true},
			        {true, true, true, true, true, true, true, true, true, true},
			        {true, false, false, false, false, false, false, false, true, true},
			        {false, false, false, false, false, false, false, false, true, true},
			        {false, true, true, true, true, true, true, true, true, true},
			        {true, true, true, true, true, true, true, true, true, true},
			        {true, true, true, true, true, true, true, true, true, true}};
			for (int y = 0; y < 8; y++) {
				for (int x = 0; x < 10; x++) {
					Tile.getAubenor()[y * 10 + x + 1] =
						new Tile(mapaAubenor.getTile(x * 64, y * 64, 64, 64),
					        y * 10 + x + 1, solidezAubenor[y][x], 64, 64);
				}
			}
		} else {
			SpriteSheet mapaAris = new SpriteSheet(CargadorImagen.cargarImagen("/Aris.png"));
			Tile.setAris(new Tile[81]);
			boolean[][] solidezAris = {{true, false, false, false, false, false, false, true, true, true},
			        {false, false, false, false, false, false, false, false, true, true},
			        {false, false, false, false, true, true, true, true, true, true},
			        {true, true, true, true, true, true, true, true, true, true},
			        {true, true, true, true, true, true, true, true, true, true},
			        {false, true, true, true, true, true, true, true, true, true},
			        {true, true, true, true, true, true, true, true, true, true},
			        {true, true, true, true, true, true, true, true, true, true}};
			for (int y = 0; y < 8; y++) {
				for (int x = 0; x < 10; x++) {
					Tile.getAris()[y * 10 + x + 1] =
						new Tile(mapaAris.getTile(x * 64, y * 64, 64, 64), y * 10 + x + 1,
					        solidezAris[y][x], 64, 64);
				}
			}
		}

		// Fin Entorno

		// Inicio Batalla
		barraSpells = CargadorImagen.cargarImagen("/BarraSpells.png");
		actualizarBarraDeCarga(++elementosCargados, menuCarga);
		estadoPersonaje = CargadorImagen.cargarImagen("/EstadoPersonaje.png");
		actualizarBarraDeCarga(++elementosCargados, menuCarga);
		barraSalud = CargadorImagen.cargarImagen("/BarraDeSalud.png");
		actualizarBarraDeCarga(++elementosCargados, menuCarga);
		barraEnergia = CargadorImagen.cargarImagen("/BarraDeEnergia.png");
		actualizarBarraDeCarga(++elementosCargados, menuCarga);
		barraExperiencia = CargadorImagen.cargarImagen("/BarraDeExperiencia.png");
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

		menuBatalla = CargadorImagen.cargarImagen("/MenuBatalla.png");
		actualizarBarraDeCarga(++elementosCargados, menuCarga);

		menuBatallaDeshabilitado = CargadorImagen.cargarImagen("/MenuBatallaDeshabilitado.png");
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
	 * @return the barraSpells
	 */
	public static BufferedImage getBarraSpells() {
		return barraSpells;
	}

	/**
	 * @param barraSpells
	 *            the barraSpells to set
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
	 * @param estadoPersonaje
	 *            the estadoPersonaje to set
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
	 * @param barraSalud
	 *            the barraSalud to set
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
	 * @param barraEnergia
	 *            the barraEnergia to set
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
	 * @param barraExperiencia
	 *            the barraExperiencia to set
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
	 * @param menuBatalla
	 *            the menuBatalla to set
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
	 * @param menuBatallaDeshabilitado
	 *            the menuBatallaDeshabilitado to set
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
	 * @param noItem
	 *            the noItem to set
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
	 * @param mochila
	 *            the mochila to set
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
	 * @param menu
	 *            the menu to set
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
	 * @param chat
	 *            the chat to set
	 */
	public static void setChat(final BufferedImage chat) {
		Recursos.chat = chat;
	}

	/**
	 * @return the habilidades
	 */
	public static Map<String, BufferedImage> getHabilidades() {
		return habilidades;
	}

	/**
	 * @param habilidades
	 *            the habilidades to set
	 */
	public static void setHabilidades(final Map<String, BufferedImage> habilidades) {
		Recursos.habilidades = habilidades;
	}

	/**
	 * @return the monstruo
	 */
	public static BufferedImage getMonstruo() {
		return monstruo;
	}

	/**
	 * @param monstruo
	 *            the monstruo to set
	 */
	public static void setMonstruo(final BufferedImage monstruo) {
		Recursos.monstruo = monstruo;
	}

	/**
	 * @return the personaje
	 */
	public static Map<String, LinkedList<BufferedImage[]>> getPersonaje() {
		return personaje;
	}

	/**
	 * @param personaje
	 *            the personaje to set
	 */
	public static void setPersonaje(final Map<String, LinkedList<BufferedImage[]>> personaje) {
		Recursos.personaje = personaje;
	}

	/**
	 * @return the humano
	 */
	public static LinkedList<BufferedImage[]> getHumano() {
		return humano;
	}

	/**
	 * @param humano
	 *            the humano to set
	 */
	public static void setHumano(final LinkedList<BufferedImage[]> humano) {
		Recursos.humano = humano;
	}

	/**
	 * @return the orco
	 */
	public static LinkedList<BufferedImage[]> getOrco() {
		return orco;
	}

	/**
	 * @param orco
	 *            the orco to set
	 */
	public static void setOrco(final LinkedList<BufferedImage[]> orco) {
		Recursos.orco = orco;
	}

	/**
	 * @return the elfo
	 */
	public static LinkedList<BufferedImage[]> getElfo() {
		return elfo;
	}

	/**
	 * @param elfo
	 *            the elfo to set
	 */
	public static void setElfo(final LinkedList<BufferedImage[]> elfo) {
		Recursos.elfo = elfo;
	}

	/**
	 * @return the background
	 */
	public static BufferedImage getBackground() {
		return background;
	}

	/**
	 * @param background
	 *            the background to set
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
	 * @param marco
	 *            the marco to set
	 */
	public static void setMarco(final BufferedImage marco) {
		Recursos.marco = marco;
	}

	/**
	 * @return the menuEnemigo
	 */
	public static BufferedImage getMenuEnemigo() {
		return menuEnemigo;
	}

	/**
	 * @param menuEnemigo
	 *            the menuEnemigo to set
	 */
	public static void setMenuEnemigo(final BufferedImage menuEnemigo) {
		Recursos.menuEnemigo = menuEnemigo;
	}

	/**
	 * @return the botonMenu
	 */
	public static BufferedImage getBotonMenu() {
		return botonMenu;
	}

	/**
	 * @param botonMenu
	 *            the botonMenu to set
	 */
	public static void setBotonMenu(final BufferedImage botonMenu) {
		Recursos.botonMenu = botonMenu;
	}

}
