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

	private static final int ANCHO_PERSONAJE = 128;
	private static final BufferedImage MENU = Recursos.getMenuEnemigo();
	public static final int MENU_BATALLAR = 0;
	public static final int MENU_INFORMACION = 1;
	public static final int MENU_SUBIR_NIVEL = 2;
	public static final int MENU_GANAR_BATALLA = 3;
	public static final int MENU_PEDER_BATALLA = 4;
	public static final int MENU_GANAR_ITEM = 5;
	public static final int MENU_COMERCIAR = 6;
	private static final String[] LEYENDA_BOTON =
		{"Batallar", "Volver", "Aceptar", "Aceptar", "Aceptar", "Aceptar",
	        "Comerciar"};
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
		g.drawImage(Recursos.getPersonaje().get(personaje.getRaza()).get(6)[0],
		        x + MENU.getWidth() / 2 - ANCHO_PERSONAJE / 2, y + 70, 128, 128, null);
		// muestro el nombre
		g.setColor(Color.WHITE);
		g.setFont(new Font("Book Antiqua", 1, 20));
		Pantalla.centerString(g, new Rectangle(x, y + 15,
				MENU.getWidth(), 0), personaje.getNombre());
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
		case MENU_PEDER_BATALLA:
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
		g.setFont(new Font("Book Antiqua", 1, 20));
		g.drawImage(Recursos.getBotonMenu(), x + 50, y + 380, 200, 25, null);
		g.setColor(Color.WHITE);
		Pantalla.centerString(g, new Rectangle(x + 50, y + 380, 200, 25),
				LEYENDA_BOTON[tipoMenu]);
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
		Pantalla.centerString(g, new Rectangle(x, y + 200,
				MENU.getWidth(), 0), "¡Has sido derrotado!");
		g.setFont(new Font("Book Antiqua", 0, 14));
		Pantalla.centerString(g, new Rectangle(x, y + 250,
				MENU.getWidth(), 0), "¡No te rindas! Sigue luchando");
		Pantalla.centerString(g, new Rectangle(x, y + 270,
				MENU.getWidth(), 0), "contra los demás personajes");
		Pantalla.centerString(g, new Rectangle(x, y + 290,
				MENU.getWidth(), 0), "para aumentar tu nivel y");
		Pantalla.centerString(g, new Rectangle(x, y + 310,
				MENU.getWidth(), 0), "mejorar tus atributos.");
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
		Pantalla.centerString(g, new Rectangle(x, y + 200,
				MENU.getWidth(), 0), "¡Has derrotado");
		Pantalla.centerString(g, new Rectangle(x, y + 230,
				MENU.getWidth(), 0), "a tu enemigo!");
		g.setFont(new Font("Book Antiqua", 0, 14));
		Pantalla.centerString(g, new Rectangle(x, y + 270,
				MENU.getWidth(), 0), "¡Felicitaciones! Has derrotado");
		Pantalla.centerString(g, new Rectangle(x, y + 290,
				MENU.getWidth(), 0), "a tu oponente, sigue así");
		Pantalla.centerString(g, new Rectangle(x, y + 310,
				MENU.getWidth(), 0), "para lograr subir de nivel");
		Pantalla.centerString(g, new Rectangle(x, y + 330,
				MENU.getWidth(), 0), "y mejorar tus atributos.");
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
		Pantalla.centerString(g, new Rectangle(x, y + 200,
				MENU.getWidth(), 0), "¡Has subido de nivel!");
		g.setFont(new Font("Book Antiqua", 0, 18));
		Pantalla.centerString(g, new Rectangle(x, y + 240,
				MENU.getWidth(), 0), "¡Felicitaciones!");
		Pantalla.centerString(g, new Rectangle(x, y + 270,
				MENU.getWidth(), 0), "Nuevo Nivel");
		g.setFont(new Font("Book Antiqua", 1, 62));
		Pantalla.centerString(g, new Rectangle(x, y + 325,
				MENU.getWidth(), 0), String.valueOf(personaje.getNivel()));
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
		Pantalla.centerString(g, new Rectangle(x, y + 200,
				MENU.getWidth(), 0), personaje.getRaza());
		g.drawString("Casta: ", x + 30, y + 260);
		g.drawString("Nivel: ", x + 30, y + 290);
		g.drawString("Experiencia: ", x + 30, y + 320);
		// muestro los atributos
		g.setFont(new Font("Book Antiqua", 0, 20));
		g.drawString(personaje.getCasta(), x + 100, y + 260);
		g.drawString(personaje.getNivel() + " ", x + 100, y + 290);
		g.drawString(personaje.getExperiencia() + " / "
		+ Personaje.getTablaDeNiveles()[personaje.getNivel() + 1],
		        x + 150, y + 320);
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
		Pantalla.centerString(g, new Rectangle(x, y + 200,
				MENU.getWidth(), 0), "¡Aca iria algo!");
		g.setFont(new Font("Book Antiqua", 0, 18));
		Pantalla.centerString(g, new Rectangle(x, y + 240,
				MENU.getWidth(), 0), "¡Aca otra cosa!");
		Pantalla.centerString(g, new Rectangle(x, y + 270,
				MENU.getWidth(), 0), "Nuevo Nivel");
		g.setFont(new Font("Book Antiqua", 1, 62));
		Pantalla.centerString(g, new Rectangle(x, y + 325,
				MENU.getWidth(), 0), String.valueOf(personaje.getNivel()));
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
		Pantalla.centerString(g, new Rectangle(x, y + 200,
				MENU.getWidth(), 0), personaje.getRaza());
		g.drawString("Casta: ", x + 30, y + 260);
		g.drawString("Nivel: ", x + 30, y + 290);
		g.drawString("Experiencia: ", x + 30, y + 320);
		// muestro los atributos
		g.setFont(new Font("Book Antiqua", 0, 20));
		g.drawString(personaje.getCasta(), x + 100, y + 260);
		g.drawString(personaje.getNivel() + " ", x + 100, y + 290);
		g.drawString(personaje.getExperiencia() + " / "
		+ Personaje.getTablaDeNiveles()[personaje.getNivel() + 1],
		x + 150, y + 320);
	}

	/**
	 * Click en boton.
	 *
	 * @param mouseX
	 *            the mouse X
	 * @param mouseY
	 *            the mouse Y
	 * @return true, if successful
	 */
	public boolean clickEnBoton(final int mouseX, final int mouseY) {
		return (mouseX >= x + 50 && mouseX <= x + 250
				&& mouseY >= y + 380 && mouseY <= y + 405);
	}

	/**
	 * Click en cerrar.
	 *
	 * @param mouseX
	 *            the mouse X
	 * @param mouseY
	 *            the mouse Y
	 * @return true, if successful
	 */
	public boolean clickEnCerrar(final int mouseX, final int mouseY) {
		return (mouseX >= x + MENU.getWidth() - 24
				&& mouseX <= x + MENU.getWidth() + 4 && mouseY >= y + 12
		        && mouseY <= y + 36);
	}

	/**
	 * Click en menu.
	 *
	 * @param mouseX
	 *            the mouse X
	 * @param mouseY
	 *            the mouse Y
	 * @return true, if successful
	 */
	public boolean clickEnMenu(final int mouseX, final int mouseY) {
		return (mouseX >= x && mouseX <= x + MENU.getWidth()
		&& mouseY >= y && mouseY <= y + MENU.getHeight());
	}
}
