package interfaz;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Rectangle;

import dominio.Personaje;
import juego.Pantalla;
import recursos.Recursos;

/**
 * The Class MenuBatalla.
 */
public class MenuBatalla {

    /**
     * Tamanio de fuente para los nombre de habilidades
     */
	private static final int TAM_FONT_NOMB_HAB = 14;
	/**
     * Alto rectangulo de turno rival
     */
	private static final int ALTO_RECT_TURNO_RIVAL = 20;
    /**
     * Desplazamiento en Y del rectangulo de turno rival
     */
	private static final int DESPL_Y_RECT_TURNO_RIV = 5;
	/**
	 * Alto del rectangulo de mi turno
	 */
	private static final int ALTO_RECT_MI_TURNO = 20;
	/**
	 * Desplazamiento en Y del rectangulo de mi turno
	 */
	private static final int DESPL_Y_RECT_MI_TURNO = 5;
	/**
	 * Desplazamiento en Y del nombre de la habilidad 6
	 */
	private static final int DESPL_Y_HAB_6 = 168;
	/**
	 * Desplazamiento en X del nombre de la habilidad 6
	 */
	private static final int DESPL_X_HAB_6 = 442;
	/**
	 * Desplazamiento en Y del nombre de la habilidad 5
	 */
	private static final int DESPL_Y_HAB_5 = 94;
	/**
	 * Desplazamiento en X del nombre de la habilidad 5
	 */
	private static final int DESPL_X_HAB_5 = 442;
	/**
	 * Desplazamiento en Y del nombre de la habilidad 4
	 */
	private static final int DESPL_Y_HAB_4 = 168;
	/**
	 * Desplazamiento en X del nombre de la habilidad 4
	 */
	private static final int DESPL_X_HAB_4 = 268;
	/**
	 * Desplazamiento en Y del nombre de la habilidad 3
	 */
	private static final int DESPL_Y_HAB_3 = 94;
	/**
	 * Desplazamiento en X del nombre de la habilidad 3
	 */
	private static final int DESPL_X_HAB_3 = 268;
	/**
	 * Desplazamiento en Y del nombre de la habilidad 2
	 */
	private static final int DESPL_Y_HAB_2 = 168;
	/**
	 * Desplazamiento en X del nombre de la habilidad 2
	 */
	private static final int DESPL_X_HAB_2 = 95;
	/**
	 * Desplazamiento en Y del nombre de la habilidad 1
	 */
	private static final int DESPL_Y_HAB_1 = 94;
	/**
	 * Desplazamiento en X del nombre de la habilidad 1
	 */
	private static final int DESPL_X_HAB_1 = 95;
	/**
	 * Desplazamiento en Y del boton habilidad 6
	 */
	private static final int DESPL_Y_BOTON_6 = 146;
	/**
	 * Desplazamiento en X del boton habilidad 6
	 */
	private static final int DESPL_X_BOTON_6 = 394;
	/**
	 * Desplazamiento en Y del boton habilidad 5
	 */
	private static final int DESPL_Y_BOTON_5 = 72;
	/**
	 * Desplazamiento en X del boton habilidad 5
	 */
	private static final int DESPL_X_BOTON_5 = 394;
	/**
	 * Desplazamiento en Y del boton habilidad 4
	 */
	private static final int DESPL_Y_BOTON_4 = 146;
	/**
	 * Desplazamiento en X del boton habilidad 4
	 */
	private static final int DESPL_X_BOTON_4 = 221;
	/**
	 * Desplazamiento en Y del boton habilidad 3
	 */
	private static final int DESPL_Y_BOTON_3 = 72;
	/**
	 * Desplazamiento en X del boton habilidad 3
	 */
	private static final int DESPL_X_BOTON_3 = 221;
	/**
	 * Desplazamiento en Y del boton habilidad 2
	 */
	private static final int DESPL_Y_BOTON_2 = 146;
	/**
	 * Desplazamiento en X del boton habilidad 2
	 */
	private static final int DESPL_X_BOTON_2 = 48;
	/**
	 * Desplazamiento en Y del boton habilidad 1
	 */
	private static final int DESPL_Y_BOTON_1 = 72;
	/**
	 * Desplazamiento en X del boton habilidad 1
	 */
	private static final int FILA_5 = 5;
	private static final int FILA_4 = 4;
	private static final int FILA_3 = 3;
	private static final int DESPL_X_BOTON_1 = 48;
	private static final int X = 100;
    private static final int Y = 380;
    private static final int ANCHO_BOTON = 40;
    private static final int[][] BOTONES = {
        {
            X + DESPL_X_BOTON_1, Y + DESPL_Y_BOTON_1 },
        {
            X + DESPL_X_BOTON_2, Y + DESPL_Y_BOTON_2 },
        {
            X + DESPL_X_BOTON_3, Y + DESPL_Y_BOTON_3 },
        {
            X + DESPL_X_BOTON_4, Y + DESPL_Y_BOTON_4 },
        {
            X + DESPL_X_BOTON_5, Y + DESPL_Y_BOTON_5 },
        {
            X + DESPL_X_BOTON_6, Y + DESPL_Y_BOTON_6 }
    };
    private boolean habilitado;
    private Personaje personaje;

    /**
     * Instantiates a new menu batalla.
     *
     * @param habilitado
     *            the habilitado
     * @param personaje
     *            the personaje
     */
    public MenuBatalla(final boolean habilitado, final Personaje personaje) {
        this.habilitado = habilitado;
        this.personaje = personaje;
    }

    /**
     * Graficar.
     *
     * @param g
     *            the g
     */
    public void graficar(final Graphics g) {

        if (habilitado) {
            g.drawImage(Recursos.getMenuBatalla(), X, Y, null);
        } else {
            g.drawImage(Recursos.getMenuBatallaDeshabilitado(), X, Y, null);
        }

        // Dibujo los botones
        g.drawImage(Recursos.getHabilidades().get(personaje.getHabilidadesRaza()[0]), BOTONES[0][0], BOTONES[0][1],
            ANCHO_BOTON, ANCHO_BOTON, null);
        g.drawImage(Recursos.getHabilidades().get(personaje.getHabilidadesRaza()[1]), BOTONES[1][0], BOTONES[1][1],
            ANCHO_BOTON, ANCHO_BOTON, null);
        g.drawImage(Recursos.getHabilidades().get(personaje.getHabilidadesCasta()[0]), BOTONES[2][0], BOTONES[2][1],
            ANCHO_BOTON, ANCHO_BOTON, null);
        g.drawImage(Recursos.getHabilidades().get(personaje.getHabilidadesCasta()[1]), BOTONES[FILA_3][0],
        		BOTONES[FILA_3][1], ANCHO_BOTON, ANCHO_BOTON, null);
        g.drawImage(Recursos.getHabilidades().get(personaje.getHabilidadesCasta()[2]), BOTONES[FILA_4][0],
        		BOTONES[FILA_4][1], ANCHO_BOTON, ANCHO_BOTON, null);
        g.drawImage(Recursos.getHabilidades().get("Ser Energizado"), BOTONES[FILA_5][0], BOTONES[FILA_5][1],
        		ANCHO_BOTON, ANCHO_BOTON, null);

        // Dibujo las leyendas
        g.setFont(new Font("Book Antiqua", 1, TAM_FONT_NOMB_HAB));
        g.drawString(personaje.getHabilidadesRaza()[0], X + DESPL_X_HAB_1, Y + DESPL_Y_HAB_1);
        g.drawString(personaje.getHabilidadesRaza()[1], X + DESPL_X_HAB_2, Y + DESPL_Y_HAB_2);
        g.drawString(personaje.getHabilidadesCasta()[0], X + DESPL_X_HAB_3, Y + DESPL_Y_HAB_3);
        g.drawString(personaje.getHabilidadesCasta()[1], X + DESPL_X_HAB_4, Y + DESPL_Y_HAB_4);
        g.drawString(personaje.getHabilidadesCasta()[2], X + DESPL_X_HAB_5, Y + DESPL_Y_HAB_5);
        g.drawString("Ser energizado", X + DESPL_X_HAB_6, Y + DESPL_Y_HAB_6);

        // Dibujo el turno de quien es
        g.setColor(Color.WHITE);
        if (habilitado) {
            Pantalla.centerString(g, new Rectangle(X, Y + DESPL_Y_RECT_MI_TURNO, Recursos.getMenuBatalla().getWidth(),
            		ALTO_RECT_MI_TURNO), "Mi Turno");
        } else {
            Pantalla.centerString(g, new Rectangle(X, Y + DESPL_Y_RECT_TURNO_RIV, Recursos.getMenuBatalla().getWidth(),
            		ALTO_RECT_TURNO_RIVAL), "Turno Rival");
        }
    }

    /**
     * Gets the boton clickeado.
     *
     * @param mouseX
     *            the mouse X
     * @param mouseY
     *            the mouse Y
     * @return the boton clickeado
     */
    public int getBotonClickeado(final int mouseX, final int mouseY) {
        if (!habilitado) {
            return 0;
        }
        for (int i = 0; i < BOTONES.length; i++) {
            if (mouseX >= BOTONES[i][0] && mouseX <= BOTONES[i][0] + ANCHO_BOTON
                && mouseY >= BOTONES[i][1] && mouseY <= BOTONES[i][1] + ANCHO_BOTON) {
                return i + 1;
            }
        }
        return 0;
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
        if (mouseX >= X && mouseX <= X + Recursos.getMenuBatalla().getWidth() && mouseY >= Y && mouseY <= Y
            + Recursos.getMenuBatalla().getHeight()) {
            return habilitado;
        }
        return false;
    }

    /**
     * Sets the habilitado.
     *
     * @param b
     *            the new habilitado
     */
    public void setHabilitado(final boolean b) {
        habilitado = b;
    }
}
