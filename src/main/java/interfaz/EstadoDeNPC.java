package interfaz;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.image.BufferedImage;

import dominio.NonPlayableCharacter;
import dominio.Personaje;
import recursos.Recursos;

/**
 * The Class EstadoDeNPC.
 */
public final class EstadoDeNPC {

    /**
     * Desplazamiento en Y del nivel
     */
	private static final int DESPL_Y_NIVEL = 70;
    /**
     * Desplazamiento en X del nivel
     */
	private static final int DESPL_X_NIVEL = 59;
	/**
	 * Tamanio de fuente del nivel
	 */
	private static final int TAM_FONT_NIVEL = 10;
	/**
	 * Desplazamiento en Y del valor de experiencia
	 */
	private static final int DESPL_Y_EXP_VAL = 70;
	/**
	 * Desplazamiento en X del valor de experiencia
	 */
	private static final int DESPL_X_EXP_VAL = 132;
	/**
	 * Desplazamiento en Y de la barra de experiencia
	 */
	private static final int DESPL_Y_BAR_EXP = 65;
	/**
	 * Desplazamiento en X de la barra de experiencia
	 */
	private static final int DESPL_X_BAR_EXP = 77;
	/**
	 * Tamanio de fuente de la experiencia
	 */
	private static final int TAM_FONT_EXP = 8;
	/**
	 * Desplazamiento en Y del valor de energia
	 */
	private static final int DESPL_Y_ENERG_VAL = 52;
	/**
	 * Desplazamiento en X del valor de energia
	 */
	private static final int DESPL_X_ENERG_VAL = 132;
	/**
	 * Desplazamiento en Y de la barra de energia
	 */
	private static final int DESPL_Y_BAR_ENERG = 42;
	/**
	 * Desplazamiento en X de la barra de energia
	 */
	private static final int DESPL_X_BAR_ENERG = 80;
	/**
	 * Desplazamiento en Y del valor de salud
	 */
	private static final int DESPL_Y_SALUD_VAL = 37;
	/**
	 * Desplazamiento en X del valor de salud
	 */
	private static final int DESPL_X_SALUD_VAL = 132;
	/**
	 * Desplazamiento en Y de la barra de salud
	 */
	private static final int DESPL_Y_BAR_SALUD = 26;
	/**
	 * Desplazamiento en X de la barra de salud
	 */
	private static final int DESPL_X_BAR_SALUD = 80;
	/**
	 * Tamanio de fuente de la salud
	 */
	private static final int TAM_FONT_SALUD = 10;
	/**
	 * Desplazamiento en Y de la miniatura del npc
	 */
	private static final int DESPL_Y_MIN_NPC = 9;
	/**
	 * Desplazamiento en X de la miniatura del npc
	 */
	private static final int DESPL_X_MIN_NPC = 10;
	private static final int ANCHOBARRA = 122;
    private static final int ALTOSALUD = 14;
    private static final int ALTOENERGIA = 14;
    private static final int ALTOEXPERIENCIA = 6;
    private static final int ALTOMINIATURA = 64;
    private static final int ANCHOMINIATURA = 64;

    /**
     * Esta clase no se instancia.
     */
    private EstadoDeNPC() {

    }

    /**
     * Dibujar estado de NPC.
     *
     * @param g
     *            grafico
     * @param x
     *            pos x
     * @param y
     *            pos y
     * @param personaje
     *            personaje
     * @param miniaturaPersonaje
     *            miniatura personaje
     */
    public static void dibujarEstadoDeNPC(final Graphics g, final int x, final int y, final Personaje personaje,
        final BufferedImage miniaturaPersonaje) {

        int drawBarra = 0;

        g.drawImage(Recursos.getEstadoPersonaje(), x, y, null);

        g.drawImage(miniaturaPersonaje, x + DESPL_X_MIN_NPC, y + DESPL_Y_MIN_NPC, ANCHOMINIATURA, ALTOMINIATURA,
        		null);

        if (personaje.getSalud() == personaje.getSaludTope()) {
            drawBarra = ANCHOBARRA;
        } else {
            drawBarra = (personaje.getSalud() * ANCHOBARRA) / personaje.getSaludTope();
        }

        g.setColor(Color.WHITE);
        g.setFont(new Font("Tahoma", Font.PLAIN, TAM_FONT_SALUD));
        g.drawImage(Recursos.getBarraSalud(), x + DESPL_X_BAR_SALUD, y + DESPL_Y_BAR_SALUD, drawBarra, ALTOSALUD,
        		null);
        g.drawString(String.valueOf(personaje.getSalud()) + " / " + String.valueOf(personaje.getSaludTope()),
        		x + DESPL_X_SALUD_VAL, y + DESPL_Y_SALUD_VAL);

        if (personaje.getEnergia() == personaje.getEnergiaTope()) {
            drawBarra = ANCHOBARRA;
        } else {
            drawBarra = (personaje.getEnergia() * ANCHOBARRA) / personaje.getEnergiaTope();
        }

        g.drawImage(Recursos.getBarraEnergia(), x + DESPL_X_BAR_ENERG, y + DESPL_Y_BAR_ENERG, drawBarra, ALTOENERGIA,
        		null);
        g.drawString(String.valueOf(personaje.getEnergia()) + " / " + String.valueOf(personaje.getEnergiaTope()),
            x + DESPL_X_ENERG_VAL, y + DESPL_Y_ENERG_VAL);

        if (personaje.getExperiencia() == Personaje.getTablaDeNiveles()[personaje.getNivel() + 1]) {
            drawBarra = ANCHOBARRA;
        } else {
            drawBarra = (personaje.getExperiencia() * ANCHOBARRA)
                / Personaje.getTablaDeNiveles()[personaje.getNivel() + 1];
        }

        g.setFont(new Font("Tahoma", Font.PLAIN, TAM_FONT_EXP));
        g.drawImage(Recursos.getBarraExperiencia(), x + DESPL_X_BAR_EXP, y + DESPL_Y_BAR_EXP, drawBarra,
        		ALTOEXPERIENCIA, null);
        g.drawString(String.valueOf(personaje.getExperiencia()) + " / "
            + String.valueOf(Personaje.getTablaDeNiveles()[personaje.getNivel() + 1]), x + DESPL_X_EXP_VAL,
            y + DESPL_Y_EXP_VAL);
        g.setFont(new Font("Tahoma", Font.PLAIN, TAM_FONT_NIVEL));
        g.setColor(Color.GREEN);
        g.drawString(String.valueOf(personaje.getNivel()), x + DESPL_X_NIVEL, y + DESPL_Y_NIVEL);

    }

    /**
     * Dibujar estado de NPC.
     *
     * @param g
     *            grafico
     * @param x
     *            pos x
     * @param y
     *            pos y
     * @param npc
     *            npc
     * @param miniaturaNPC
     *            miniatura NPC
     */
    public static void dibujarEstadoDeNPC(final Graphics g, final int x, final int y, final NonPlayableCharacter npc,
        final BufferedImage miniaturaNPC) {

        int drawBarra = 0;

        g.drawImage(Recursos.getEstadoPersonaje(), x, y, null);

        g.drawImage(miniaturaNPC, x + DESPL_X_MIN_NPC, y + DESPL_Y_MIN_NPC, ANCHOMINIATURA, ALTOMINIATURA, null);

        if (npc.getSalud() == npc.getSaludTope()) {
            drawBarra = ANCHOBARRA;
        } else {
            drawBarra = (npc.getSalud() * ANCHOBARRA) / npc.getSaludTope();
        }

        g.setColor(Color.WHITE);
        g.setFont(new Font("Tahoma", Font.PLAIN, TAM_FONT_SALUD));
        g.drawImage(Recursos.getBarraSalud(), x + DESPL_X_BAR_SALUD, y + DESPL_Y_BAR_SALUD, drawBarra, ALTOSALUD,
        		null);
        g.drawString(String.valueOf(npc.getSalud()) + " / " + String.valueOf(npc.getSaludTope()),
        		x + DESPL_X_SALUD_VAL, y + DESPL_Y_SALUD_VAL);

        g.setFont(new Font("Tahoma", Font.PLAIN, TAM_FONT_EXP));
        g.drawImage(Recursos.getBarraExperiencia(), x + DESPL_X_BAR_EXP, y + DESPL_Y_BAR_EXP, drawBarra,
        		ALTOEXPERIENCIA, null);
        /*g.drawString(String.valueOf(personaje.getExperiencia()) + " / "
        + String.valueOf(Personaje.getTablaDeNiveles()[personaje.getNivel() + 1]), x + 132, y + 70); */
        g.setFont(new Font("Tahoma", Font.PLAIN, TAM_FONT_NIVEL));
        g.setColor(Color.GREEN);
        g.drawString(String.valueOf(npc.getNivel()), x + DESPL_X_NIVEL, y + DESPL_Y_NIVEL);
    }
}
