package interfaz;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;

import dominio.Personaje;
import juego.Pantalla;
import mensajeria.PaquetePersonaje;
import recursos.Recursos;

/**
 * The Class MenuInfoPersonaje.
 */
public class MenuInfoPersonaje {

    private static final BufferedImage MENU = Recursos.menuEnemigo;
    public static final int MENU_BATALLAR = 0;
    public static final int MENU_INFORMACION = 1;
    public static final int MENU_SUBIR_NIVEL = 2;
    public static final int MENU_GANAR_BATALLA = 3;
    public static final int MENU_PERDER_BATALLA = 4;
    public static final int MENU_GANAR_ITEM = 5;
    public static final int MENU_COMERCIAR = 6;
    private static final String[] LEYENDA_BOTON = {
        "Batallar", "Volver", "Aceptar", "Aceptar", "Aceptar", "Aceptar", "Comerciar" };

    //CONSTANTES GRAFICO PERSONAJE
  	/**
  	 * Indice dentro de la lista para obtener la imagen del personaje a graficar
  	 */
  	private static final int INDICE_LINKEDLIST_IMG_PERS = 6;
  	/**
  	 * Constante que desplaza en 70 la posicion Y del personaje
  	 */
  	private static final int DESPLAZAM_Y_PERSONAJE = 70;
  	/**
  	 * Alto del grafico del personaje
  	 */
  	private static final int ALTO_PERSONAJE = 128;
  	/**
  	 * Ancho del grafico del personaje
  	 */
  	private static final int ANCHO_PERSONAJE = 128;
  	/**
  	 * Tamanio de la fuente usada para el nombre del personaje
  	 */
  	private static final int TAM_FONT_NOM_PER = 20;
  	/**
  	 * Constante que desplaza en 15 la posicion Y del nombre del personaje
  	 */
  	private static final int DESPL_Y_NOM_PER = 15;
  	//CONSTANTES BOTON MENU
  	/**
  	 * Tamanio de fuente del boton menu
  	 */
  	private static final int TAM_FONT_BOTON_MENU = 20;
  	/**
  	 * Desplazamiento en X del boton menu
  	 */
  	private static final int DESPL_X_BOTON_MENU = 50;
  	/**
  	 * Desplazamiento en Y del boton menu
  	 */
  	private static final int DESPL_Y_BOTON_MENU = 380;
  	/**
  	 * Ancho del rectangulo de texto del boton menu
  	 */
  	private static final int ANCHO_BOTON_MENU = 200;
  	/**
  	 * Alto del rectangulo de texto del boton menu
  	 */
  	private static final int ALTO_BOTON_MENU = 25;
  	//CONSTANTES DIALOGO DERROTA
  	/**
  	 * Desplazamiento en Y de la linea 1 del dialogo de derrota
  	 */
  	private static final int DESPL_Y_L1_DERROTA = 200;
  	/**
  	 * Desplazamiento en Y de la linea 2 del dialogo de derrota
  	 */
  	private static final int DESPL_Y_L2_DERROTA = 250;
  	/**
  	 * Desplazamiento en Y de la linea 3 del dialogo de derrota
  	 */
  	private static final int DESPL_Y_L3_DERROTA = 270;
  	/**
  	 * Desplazamiento en Y de la linea 4 del dialogo de derrota
  	 */
  	private static final int DESPL_Y_L4_DERROTA = 290;
  	/**
  	 * Desplazamiento en Y de la linea 5 del dialogo de derrota
  	 */
  	private static final int DESPL_Y_L5_DERROTA = 310;
  	/**
  	 * Tamanio de fuente del dialogo de derrota
  	 */
  	private static final int TAM_FONT_DERROTA = 14;
  	//CONSTANTES DIALOGO VICTORIA
  	/**
  	 * Desplazamiento en Y de la linea 1 del dialogo de victoria
  	 */
  	private static final int DESPL_Y_L1_VICTORIA = 200;
  	/**
  	 * Desplazamiento en Y de la linea 2 del dialogo de victoria
  	 */
  	private static final int DESPL_Y_L2_VICTORIA = 230;
  	/**
  	 * Desplazamiento en Y de la linea 3 del dialogo de victoria
  	 */
  	private static final int DESPL_Y_L3_VICTORIA = 270;
  	/**
  	 * Desplazamiento en Y de la linea 4 del dialogo de victoria
  	 */
  	private static final int DESPL_Y_L4_VICTORIA = 290;
  	/**
  	 * Desplazamiento en Y de la linea 5 del dialogo de victoria
  	 */
  	private static final int DESPL_Y_L5_VICTORIA = 310;
  	/**
  	 * Desplazamiento en Y de la linea 6 del dialogo de victoria
  	 */
  	private static final int DESPL_Y_L6_VICTORIA = 330;
  	/**
  	 * Tamanio de fuente del dialogo de victoria
  	 */
  	private static final int TAM_FONT_VICTORIA = 14;
  	//CONSTANTES SUBIR NIVEL
  	/**
  	 * Desplazamiento en Y de la linea 1 del dialogo de subir nivel
  	 */
  	private static final int DESPL_Y_L1_SUB_NVL = 200;
  	/**
  	 * Desplazamiento en Y de la linea 2 del dialogo de subir nivel
  	 */
  	private static final int DESPL_Y_L2_SUB_NVL = 240;
  	/**
  	 * Desplazamiento en Y de la linea 3 del dialogo de subir nivel
  	 */
  	private static final int DESPL_Y_L3_SUB_NVL = 270;
  	/**
  	 * Desplazamiento en Y de la linea 4 del dialogo de subir nivel
  	 */
  	private static final int DESPL_Y_L4_SUB_NVL = 325;
  	/**
  	 * Tamanio de fuente del dialogo de subir nivel
  	 */
  	private static final int TAM_FONT1_SUB_NVL = 18;
  	/**
  	 * Tamanio de fuente del nuevo nivel adquirido
  	 */
  	private static final int TAM_FONT2_SUB_NVL = 62;
  	//CONSTANTES CUADRO INFO
  	/**
  	 * Desplazamiento en Y del rectangulo de informacion del personaje
  	 */
  	private static final int DESPL_Y_RECTANG_INFO = 200;
  	/**
  	 * Desplazamiento en X de la la etiqueta casta
  	 */
  	private static final int DESPL_X_CASTA = 30;
  	/**
  	 * Desplazamiento en Y de la etiqueta casta
  	 */
  	private static final int DESPL_Y_CASTA = 260;
  	/**
  	 * Desplazamiento en X de la etiqueta nivel
  	 */
  	private static final int DESPL_X_NIVEL = 30;
  	/**
  	 * Desplazamiento en Y de la etiqueta nivel
  	 */
  	private static final int DESPL_Y_NIVEL = 290;
  	/**
  	 * Desplazamiento en X de la etiqueta experiencia
  	 */
  	private static final int DESPL_X_EXP = 30;
  	/**
  	 * Desplazamiento en Y de la etiqueta experiencia
  	 */
  	private static final int DESPL_Y_EXP = 320;
  	/**
  	 * Tamanio de fuente de los valores de atributos casta, nivel, experiencia
  	 */
  	private static final int TAM_FONT_ATRIB_VAL = 20;
  	/**
  	 * Desplazamiento en X del valor de la casta
  	 */
  	private static final int DESPL_X_CASTA_VAL = 100;
  	/**
  	 * Desplazamiento en Y del valor de la casta
  	 */
  	private static final int DESPL_Y_CASTA_VAL = 260;
  	/**
  	 * Desplazamiento en X del valor del nivel
  	 */
  	private static final int DESPL_X_NIVEL_VAL = 100;
  	/**
  	 * Desplazamiento en Y del valor del nivel
  	 */
  	private static final int DESPL_Y_NIVEL_VAL = 290;
  	/**
  	 * Desplazamiento en X del valor de experiencia
  	 */
  	private static final int DESPL_X_EXP_VAL = 150;
  	/**
  	 * Desplazamiento en Y del valor de experiencia
  	 */
  	private static final int DESPL_Y_EXP_VAL = 320;
  	//CONSTANTES CUADRO ITEM
  	/**
  	 * Desplazamiento en Y de la linea 1 de mostrar item
  	 */
  	private static final int DESPL_Y_L1_ITEM = 200;
  	/**
  	 * Desplazamiento en Y de la linea 2 de mostrar item
  	 */
  	private static final int DESPL_Y_L2_ITEM = 240;
  	/**
  	 * Desplazamiento en Y de la linea 3 de mostrar item
  	 */
  	private static final int DESPL_Y_L3_ITEM = 270;
  	/**
  	 * Desplazamiento en Y de la linea 4 de mostrar item
  	 */
  	private static final int DESPL_Y_L4_ITEM = 325;
  	/**
  	 * Tamanio de fuente 1 de mostrar item
  	 */
  	private static final int TAM_FONT1_ITEM = 18;
  	/**
  	 * Tamanio de fuente 2 de mostrar item
  	 */
  	private static final int TAM_FONT2_ITEM = 62;
  	//CONSTANTES CLIC EN BOTON
  	/**
  	 * Desplazamiento 1 en X a evaluar al hacer clic en boton
  	 */
  	private static final int DESPL_X1_CLIC_BOTON = 50;
  	/**
  	 * Desplazamiento 2 en X a evaluar al hacer clic en boton
  	 */
  	private static final int DESPL_X2_CLIC_BOTON = 250;
  	/**
  	 * Desplazamiento 1 en Y a evaluar al hacer clic en boton
  	 */
  	private static final int DESPL_Y1_CLIC_BOTON = 380;
  	/**
  	 * Desplazamiento 2 en Y a evaluar al hacer clic en boton
  	 */
  	private static final int DESPL_Y2_CLIC_BOTON = 405;
  	//CONSTANTES CLIC EN CERRAR
  	/**
  	 * Desplazamiento 1 en X a evaluar al hacer clic en cerrar
  	 */
  	private static final int DESPL_X1_CLIC_CERRAR = 24;
  	/**
  	 * Desplazamiento 2 en X a evaluar al hacer clic en cerrar
  	 */
  	private static final int DESPL_X2_CLIC_CERRAR = 4;
  	/**
  	 * Desplazamiento 1 en Y a evaluar al hacer clic en cerrar
  	 */
  	private static final int DESPL_Y1_CLIC_CERRAR = 12;
  	/**
  	 * Desplazamiento 2 en Y a evaluar al hacer clic en cerrar
  	 */
  	private static final int DESPL_Y2_CLIC_CERRAR = 36;

    private int x;
    private int y;
    private PaquetePersonaje personaje;

    /**
     * Instantiates a new menu info personaje.
     *
     * @param x
     *            the x
     * @param y
     *            the y
     * @param personaje
     *            the personaje
     */
    public MenuInfoPersonaje(final int x, final int y, final PaquetePersonaje personaje) {
        this.x = x;
        this.y = y;
        this.personaje = personaje;
    }

    /**
     * Graficar.
     *
     * @param g
     *            the g
     * @param tipoMenu
     *            the tipo menu
     */
    public void graficar(final Graphics g, final int tipoMenu) {

        // dibujo el menu
        g.drawImage(MENU, x, y, null);

        // dibujo el personaje
        g.drawImage(Recursos.personaje.get(personaje.getRaza()).get(INDICE_LINKEDLIST_IMG_PERS)[0], x
          + MENU.getWidth() / 2  - ANCHO_PERSONAJE / 2, y + DESPLAZAM_Y_PERSONAJE, ANCHO_PERSONAJE,
        		ALTO_PERSONAJE, null);

        // muestro el nombre
        g.setColor(Color.WHITE);
		g.setFont(new Font("Book Antiqua", 1, TAM_FONT_NOM_PER));
		Pantalla.centerString(g, new Rectangle(x, y + DESPL_Y_NOM_PER, MENU.getWidth(), 0),
				personaje.getNombre());

        // Grafico la leyenda segun el tipo de menu
        switch (tipoMenu) {
            case MENU_BATALLAR:
                graficarMenuInformacion(g);
                break;
            case MENU_INFORMACION:
                graficarMenuInformacion(g);
                break;
            case MENU_SUBIR_NIVEL:
                graficarMenuSubirNivel(g);
                break;
            case MENU_GANAR_BATALLA:
                graficarMenuGanarBatalla(g);
                break;
            case MENU_PERDER_BATALLA:
                graficarMenuPerderBatalla(g);
                break;
            case MENU_GANAR_ITEM:
                graficarMenuItem(g);
                break;
            case MENU_COMERCIAR:
                graficarMenuComerciar(g);
                break;
            default:
				break;
        }
        // Muestro los botones
        g.setFont(new Font("Book Antiqua", 1, TAM_FONT_BOTON_MENU));
		g.drawImage(Recursos.botonMenu, x + DESPL_X_BOTON_MENU, y + DESPL_Y_BOTON_MENU, ANCHO_BOTON_MENU,
				ALTO_BOTON_MENU, null);
		g.setColor(Color.WHITE);
		Pantalla.centerString(g, new Rectangle(x + DESPL_X_BOTON_MENU, y + DESPL_Y_BOTON_MENU, ANCHO_BOTON_MENU,
				ALTO_BOTON_MENU), LEYENDA_BOTON[tipoMenu]);
    }

    /**
     * Graficar menu perder batalla.
     *
     * @param g
     *            the g
     */
    private void graficarMenuPerderBatalla(final Graphics g) {

        // Informo que perdio la batalla
    	g.setColor(Color.BLACK);
		Pantalla.centerString(g, new Rectangle(x, y + DESPL_Y_L1_DERROTA, MENU.getWidth(), 0),
      "¡Has sido derrotado!");
		g.setFont(new Font("Book Antiqua", 0, TAM_FONT_DERROTA));
		Pantalla.centerString(g, new Rectangle(x, y + DESPL_Y_L2_DERROTA, MENU.getWidth(), 0),
				"¡No te rindas! Sigue luchando");
		Pantalla.centerString(g, new Rectangle(x, y + DESPL_Y_L3_DERROTA, MENU.getWidth(), 0),
				"contra los demás personajes");
		Pantalla.centerString(g, new Rectangle(x, y + DESPL_Y_L4_DERROTA, MENU.getWidth(), 0),
				"para aumentar tu nivel y");
		Pantalla.centerString(g, new Rectangle(x, y + DESPL_Y_L5_DERROTA, MENU.getWidth(), 0),
				"mejorar tus atributos.");
    }

    /**
     * Graficar menu ganar batalla.
     *
     * @param g
     *            the g
     */
    private void graficarMenuGanarBatalla(final Graphics g) {
        // Informo que gano la batalla
    	g.setColor(Color.BLACK);
		Pantalla.centerString(g, new Rectangle(x, y + DESPL_Y_L1_VICTORIA, MENU.getWidth(), 0),
      "¡Has derrotado");
		Pantalla.centerString(g, new Rectangle(x, y + DESPL_Y_L2_VICTORIA, MENU.getWidth(), 0),
      "a tu enemigo!");
		g.setFont(new Font("Book Antiqua", 0, TAM_FONT_VICTORIA));
		Pantalla.centerString(g, new Rectangle(x, y + DESPL_Y_L3_VICTORIA, MENU.getWidth(), 0),
				"¡Felicitaciones! Has derrotado");
		Pantalla.centerString(g, new Rectangle(x, y + DESPL_Y_L4_VICTORIA, MENU.getWidth(), 0),
				"a tu oponente, sigue así");
		Pantalla.centerString(g, new Rectangle(x, y + DESPL_Y_L5_VICTORIA, MENU.getWidth(), 0),
				"para lograr subir de nivel");
		Pantalla.centerString(g, new Rectangle(x, y + DESPL_Y_L6_VICTORIA, MENU.getWidth(), 0),
				"y mejorar tus atributos.");
    }

    /**
     * Graficar menu subir nivel.
     *
     * @param g
     *            the g
     */
    private void graficarMenuSubirNivel(final Graphics g) {
        // Informo que subio de nivel
    	g.setColor(Color.BLACK);
		Pantalla.centerString(g, new Rectangle(x, y + DESPL_Y_L1_SUB_NVL, MENU.getWidth(), 0),
				"¡Has subido de nivel!");
		g.setFont(new Font("Book Antiqua", 0, TAM_FONT1_SUB_NVL));
		Pantalla.centerString(g, new Rectangle(x, y + DESPL_Y_L2_SUB_NVL, MENU.getWidth(), 0),
      "¡Felicitaciones!");
		Pantalla.centerString(g, new Rectangle(x, y + DESPL_Y_L3_SUB_NVL, MENU.getWidth(), 0), "Nuevo Nivel");
		g.setFont(new Font("Book Antiqua", 1, TAM_FONT2_SUB_NVL));
		Pantalla.centerString(g, new Rectangle(x, y + DESPL_Y_L4_SUB_NVL, MENU.getWidth(), 0),
      String.valueOf(personaje.getNivel()));
    }

    /**
     * Graficar menu informacion.
     *
     * @param g
     *            the g
     */
    public void graficarMenuInformacion(final Graphics g) {

    	// muestro los nombres de los atributos
    	g.setColor(Color.BLACK);
    	Pantalla.centerString(g, new Rectangle(x, y + DESPL_Y_RECTANG_INFO, MENU.getWidth(), 0),
            personaje.getRaza());
    	g.drawString("Casta: ", x + DESPL_X_CASTA, y + DESPL_Y_CASTA);
    	g.drawString("Nivel: ", x + DESPL_X_NIVEL, y + DESPL_Y_NIVEL);
    	g.drawString("Experiencia: ", x + DESPL_X_EXP, y + DESPL_Y_EXP);

    	// muestro los atributos
    	g.setFont(new Font("Book Antiqua", 0, TAM_FONT_ATRIB_VAL));
    	g.drawString(personaje.getCasta(), x + DESPL_X_CASTA_VAL, y + DESPL_Y_CASTA_VAL);
    	g.drawString(personaje.getNivel() + " ", x + DESPL_X_NIVEL_VAL, y + DESPL_Y_NIVEL_VAL);
    	g.drawString(personaje.getExperiencia() + " / " + Personaje.getTablaDeNiveles()[personaje.getNivel() + 1],
    			x + DESPL_X_EXP_VAL, y + DESPL_Y_EXP_VAL);

    }

    /**
     * Graficar menu item.
     *
     * @param g
     *            the g
     */
    private void graficarMenuItem(final Graphics g) {

        // Informo que subio de nivel
    	g.setColor(Color.BLACK);
		Pantalla.centerString(g, new Rectangle(x, y + DESPL_Y_L1_ITEM, MENU.getWidth(), 0), "¡Aca iria algo!");

		g.setFont(new Font("Book Antiqua", 0, TAM_FONT1_ITEM));
		Pantalla.centerString(g, new Rectangle(x, y + DESPL_Y_L2_ITEM, MENU.getWidth(), 0), "¡Aca otra cosa!");
		Pantalla.centerString(g, new Rectangle(x, y + DESPL_Y_L3_ITEM, MENU.getWidth(), 0), "Nuevo Nivel");
		g.setFont(new Font("Book Antiqua", 1, TAM_FONT2_ITEM));
		Pantalla.centerString(g, new Rectangle(x, y + DESPL_Y_L4_ITEM, MENU.getWidth(), 0),
      String.valueOf(personaje.getNivel()));

    }

    /**
     * Graficar menu comerciar.
     *
     * @param g
     *            the g
     */
    private void graficarMenuComerciar(final Graphics g) {

    	// muestro los nombres de los atributos
    	g.setColor(Color.BLACK);
    	Pantalla.centerString(g, new Rectangle(x, y + DESPL_Y_RECTANG_INFO, MENU.getWidth(), 0),
            personaje.getRaza());
    	g.drawString("Casta: ", x + DESPL_X_CASTA, y + DESPL_Y_CASTA);
    	g.drawString("Nivel: ", x + DESPL_X_NIVEL, y + DESPL_Y_NIVEL);
    	g.drawString("Experiencia: ", x + DESPL_X_EXP, y + DESPL_Y_EXP);

    	// muestro los atributos
    	g.setFont(new Font("Book Antiqua", 0, TAM_FONT_ATRIB_VAL));
    	g.drawString(personaje.getCasta(), x + DESPL_X_CASTA_VAL, y + DESPL_Y_CASTA_VAL);
    	g.drawString(personaje.getNivel() + " ", x + DESPL_X_NIVEL_VAL, y + DESPL_Y_NIVEL_VAL);
    	g.drawString(personaje.getExperiencia() + " / " + Personaje.getTablaDeNiveles()[personaje.getNivel() + 1],
    			x + DESPL_X_EXP_VAL, y + DESPL_Y_EXP_VAL);
    }

    /**
     * Click en boton.
     * @param mouseX
     *            the mouse X
     * @param mouseY
     *            the mouse Y
     * @return true, if successful
     */
    public boolean clickEnBoton(final int mouseX, final int mouseY) {
        return (mouseX >= x + DESPL_X1_CLIC_BOTON && mouseX <= x + DESPL_X2_CLIC_BOTON
        		&& mouseY >= y + DESPL_Y1_CLIC_BOTON && mouseY <= y + DESPL_Y2_CLIC_BOTON);
    }

    /**
     * Click en cerrar.
     * @param mouseX
     *            the mouse X
     * @param mouseY
     *            the mouse Y
     * @return true, if successful
     */
    public boolean clickEnCerrar(final int mouseX, final int mouseY) {
        return (mouseX >= x + MENU.getWidth() - DESPL_X1_CLIC_CERRAR && mouseX <= x + MENU.getWidth()
          + DESPL_X2_CLIC_CERRAR && mouseY >= y + DESPL_Y1_CLIC_CERRAR && mouseY <= y + DESPL_Y2_CLIC_CERRAR);
    }

    /**
     * Click en menu.
     * @param mouseX
     *            the mouse X
     * @param mouseY
     *            the mouse Y
     * @return true, if successful
     */
    public boolean clickEnMenu(final int mouseX, final int mouseY) {
        return (mouseX >= x && mouseX <= x + MENU.getWidth() && mouseY >= y && mouseY <= y + MENU.getHeight());
    }
}
