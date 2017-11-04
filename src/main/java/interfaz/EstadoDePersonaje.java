package interfaz;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.image.BufferedImage;

import dominio.Personaje;
import mensajeria.PaquetePersonaje;
import recursos.Recursos;

/**
 * The Class EstadoDePersonaje.
 */
public final class EstadoDePersonaje {

	private static final int ANCHOBARRA = 122;
    private static final int ALTOSALUD = 14;
    private static final int ALTOENERGIA = 14;
    private static final int ALTOEXPERIENCIA = 6;
    private static final int ALTOMINIATURA = 64;
    private static final int ANCHOMINIATURA = 64;
    /**
     * Desplazamiento en X de la miniatura del personaje
     */
	private static final int DESPL_X_MIN_PERS = 10;
	/**
	 * Desplazamiento en Y de la miniatura del personaje
	 */
	private static final int DESPL_Y_MIN_PERS = 9;
	/**
	 * Tamanio de la fuente de la la salud y la energia
	 */
	private static final int TAM_FONT_SALUD = 10;
	/**
	 * Desplazamiento en X de la barra de salud
	 */
	private static final int DESPL_X_BAR_SALUD = 80;
	/**
	 * Desplazamiento en Y de la barra de salud
	 */
	private static final int DESPL_Y_BAR_SALUD = 26;
	/**
	 * Desplazamiento en X del valor de salud
	 */
	private static final int DESPL_X_SALUD_VAL = 132;
	/**
	 * Desplazamiento en Y del valor de salud
	 */
	private static final int DESPL_Y_SALUD_VAL = 37;
	/**
	 * Desplazamiento en X de la barra de energia
	 */
	private static final int DESPL_X_BAR_ENERG = 80;
	/**
	 * Desplazamiento en Y de la barra de energia
	 */
	private static final int DESPL_Y_BAR_ENERG = 42;
	/**
	 * Desplazamiento en X del valor de energia
	 */
	private static final int DESPL_X_ENERG_VAL = 132;
	/**
	 * Desplazamiento en Y del valor de energia
	 */
	private static final int DESPL_Y_ENERG_VAL = 52;
	/**
	 * Tamanio de fuente de la experiencia
	 */
	private static final int TAM_FONT_EXP = 8;
	/**
	 * Desplazamiento en X de la barra de experiencia
	 */
	private static final int DESPL_X_BAR_EXP = 77;
	/**
	 * Desplazamiento en Y de la barra de experiencia
	 */
	private static final int DESPL_Y_BAR_EXP = 65;
	/**
	 * Desplazamiento en X del valor de experiencia
	 */
	private static final int DESPL_X_EXP_VAL = 132;
	/**
	 * Desplazamiento en Y del valor de experiencia
	 */
	private static final int DESPL_Y_EXP_VAL = 70;
	/**
	 * Tamanio de la fuente del nivel
	 */
	private static final int TAM_FONT_NIVEL = 10;
	/**
	 * Desplazamiento en X del nivel
	 */
	private static final int DESPL_X_NIVEL = 59;
	/**
	 * Desplazamiento en Y del nivel
	 */
	private static final int DESPL_Y_NIVEL = 70;

    /**
     * Instantiates a new estado de personaje.
     */
    private EstadoDePersonaje() {

    }

    /**
     * Dibujar estado de personaje.
     *
     * @param g
     *            the g
     * @param x
     *            the x
     * @param y
     *            the y
     * @param personaje
     *            the personaje
     * @param miniaturaPersonaje
     *            the miniatura personaje
     */
    public static void dibujarEstadoDePersonaje(final Graphics g, final int x, final int y, final Personaje personaje,
        final BufferedImage miniaturaPersonaje) {

        int drawBarra = 0;

        g.drawImage(Recursos.getEstadoPersonaje(), x, y, null);

        g.drawImage(miniaturaPersonaje, x + DESPL_X_MIN_PERS, y + DESPL_Y_MIN_PERS, ANCHOMINIATURA, ALTOMINIATURA,
        		null);

        if (personaje.getSalud() == personaje.getSaludTope()) {
            drawBarra = ANCHOBARRA;
        } else {
            drawBarra = (personaje.getSalud() * ANCHOBARRA) / personaje.getSaludTope();
        }

        g.setColor(Color.WHITE);
        g.setFont(new Font("Tahoma", Font.PLAIN, TAM_FONT_SALUD));
        g.drawImage(Recursos.getBarraSalud(), x + DESPL_X_BAR_SALUD, y + DESPL_Y_BAR_SALUD, drawBarra, ALTOSALUD, null);
        g.drawString(String.valueOf(personaje.getSalud()) + " / " + String.valueOf(personaje.getSaludTope()),
        		x + DESPL_X_SALUD_VAL, y + DESPL_Y_SALUD_VAL);

        if (personaje.getEnergia() == personaje.getEnergiaTope()) {
            drawBarra = ANCHOBARRA;
        } else {
            drawBarra = (personaje.getEnergia() * ANCHOBARRA) / personaje.getEnergiaTope();
        }

        g.drawImage(Recursos.getBarraEnergia(), x + DESPL_X_BAR_ENERG, y + DESPL_Y_BAR_ENERG, drawBarra, ALTOENERGIA,
         null);
        g.drawString(String.valueOf(personaje.getEnergia()) + " / " + String.valueOf(personaje.getEnergiaTope()), x
            + DESPL_X_ENERG_VAL, y + DESPL_Y_ENERG_VAL);

        if (personaje.getExperiencia() == Personaje.getTablaDeNiveles()[personaje.getNivel() + 1]) {
            drawBarra = ANCHOBARRA;
        } else {
            drawBarra = (personaje.getExperiencia() * ANCHOBARRA) / Personaje.getTablaDeNiveles()[personaje.getNivel()
                + 1];
        }

        g.setFont(new Font("Tahoma", Font.PLAIN, TAM_FONT_EXP));
        g.drawImage(Recursos.getBarraExperiencia(), x + DESPL_X_BAR_EXP, y + DESPL_Y_BAR_EXP, drawBarra,
            ALTOEXPERIENCIA, null);
        g.drawString(String.valueOf(personaje.getExperiencia()) + " / " + String.valueOf(Personaje
            .getTablaDeNiveles()[personaje.getNivel() + 1]), x + DESPL_X_EXP_VAL, y + DESPL_Y_EXP_VAL);
        g.setFont(new Font("Tahoma", Font.PLAIN, TAM_FONT_NIVEL));
        g.setColor(Color.GREEN);
        g.drawString(String.valueOf(personaje.getNivel()), x + DESPL_X_NIVEL, y + DESPL_Y_NIVEL);

    }

    /**
     * Dibujar estado de personaje.
     *
     * @param g
     *            the g
     * @param x
     *            the x
     * @param y
     *            the y
     * @param personaje
     *            the personaje
     * @param miniaturaPersonaje
     *            the miniatura personaje
     */
    public static void dibujarEstadoDePersonaje(final Graphics g, final int x, final int y,
        final PaquetePersonaje personaje,
        final BufferedImage miniaturaPersonaje) {

        int drawBarra = 0;

        g.drawImage(Recursos.getEstadoPersonaje(), x, y, null);

        g.drawImage(miniaturaPersonaje, x + DESPL_X_MIN_PERS, y + DESPL_Y_MIN_PERS, ANCHOMINIATURA, ALTOMINIATURA,
        		null);

        g.setColor(Color.WHITE);
        g.setFont(new Font("Tahoma", Font.PLAIN, TAM_FONT_SALUD));
        g.drawImage(Recursos.getBarraSalud(), x + DESPL_X_BAR_SALUD, y + DESPL_Y_BAR_SALUD, ANCHOBARRA, ALTOSALUD, null);
        g.drawString(String.valueOf(personaje.getSaludTope()) + " / " + String.valueOf(personaje.getSaludTope()),
        		x + DESPL_X_SALUD_VAL, y + DESPL_Y_SALUD_VAL);

        g.drawImage(Recursos.getBarraEnergia(), x + DESPL_X_BAR_ENERG, y + DESPL_Y_BAR_ENERG, ANCHOBARRA, ALTOENERGIA,
            null);
        g.drawString(String.valueOf(personaje.getEnergiaTope()) + " / " + String.valueOf(personaje.getEnergiaTope()), x
        	+ DESPL_X_ENERG_VAL, y + DESPL_Y_ENERG_VAL);

        if (personaje.getExperiencia() == Personaje.getTablaDeNiveles()[personaje.getNivel() + 1]) {
            drawBarra = ANCHOBARRA;
        } else {
            drawBarra = (personaje.getExperiencia() * ANCHOBARRA) / Personaje.getTablaDeNiveles()[personaje.getNivel()
                + 1];
        }

        g.setFont(new Font("Tahoma", Font.PLAIN, TAM_FONT_EXP));
        g.drawImage(Recursos.getBarraExperiencia(), x + DESPL_X_BAR_EXP, y + DESPL_Y_BAR_EXP, drawBarra,
            ALTOEXPERIENCIA, null);
        g.drawString(String.valueOf(personaje.getExperiencia()) + " / " + String.valueOf(Personaje
            .getTablaDeNiveles()[personaje.getNivel() + 1]), x + DESPL_X_EXP_VAL, y + DESPL_Y_EXP_VAL);
        g.setFont(new Font("Tahoma", Font.PLAIN, TAM_FONT_NIVEL));
        g.setColor(Color.GREEN);
        g.drawString(String.valueOf(personaje.getNivel()), x + DESPL_X_NIVEL, y + DESPL_Y_NIVEL);
    }
}
