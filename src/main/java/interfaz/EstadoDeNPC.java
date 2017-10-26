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
public class EstadoDeNPC {

    private static final int ANCHOBARRA = 122;
    private static final int ALTOSALUD = 14;
    private static final int ALTOENERGIA = 14;
    private static final int ALTOEXPERIENCIA = 6;
    private static final int ALTOMINIATURA = 64;
    private static final int ANCHOMINIATURA = 64;

    /**
     * Esta clase no se instancia
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

        g.drawImage(Recursos.estadoPersonaje, x, y, null);

        g.drawImage(miniaturaPersonaje, x + 10, y + 9, ANCHOMINIATURA, ALTOMINIATURA, null);

        if (personaje.getSalud() == personaje.getSaludTope()) {
            drawBarra = ANCHOBARRA;
        } else {
            drawBarra = (personaje.getSalud() * ANCHOBARRA) / personaje.getSaludTope();
        }

        g.setColor(Color.WHITE);
        g.setFont(new Font("Tahoma", Font.PLAIN, 10));
        g.drawImage(Recursos.barraSalud, x + 80, y + 26, drawBarra, ALTOSALUD, null);
        g.drawString(String.valueOf(personaje.getSalud()) + " / " + String.valueOf(personaje.getSaludTope()), x + 132,
                y + 37);

        if (personaje.getEnergia() == personaje.getEnergiaTope()) {
            drawBarra = ANCHOBARRA;
        } else {
            drawBarra = (personaje.getEnergia() * ANCHOBARRA) / personaje.getEnergiaTope();
        }

        g.drawImage(Recursos.barraEnergia, x + 80, y + 42, drawBarra, ALTOENERGIA, null);
        g.drawString(String.valueOf(personaje.getEnergia()) + " / " + String.valueOf(personaje.getEnergiaTope()),
                x + 132, y + 52);

        if (personaje.getExperiencia() == Personaje.getTablaDeNiveles()[personaje.getNivel() + 1]) {
            drawBarra = ANCHOBARRA;
        } else {
            drawBarra = (personaje.getExperiencia() * ANCHOBARRA)
                    / Personaje.getTablaDeNiveles()[personaje.getNivel() + 1];
        }

        g.setFont(new Font("Tahoma", Font.PLAIN, 8));
        g.drawImage(Recursos.barraExperiencia, x + 77, y + 65, drawBarra, ALTOEXPERIENCIA, null);
        g.drawString(String.valueOf(personaje.getExperiencia()) + " / "
                + String.valueOf(Personaje.getTablaDeNiveles()[personaje.getNivel() + 1]), x + 132, y + 70);
        g.setFont(new Font("Tahoma", Font.PLAIN, 10));
        g.setColor(Color.GREEN);
        g.drawString(String.valueOf(personaje.getNivel()), x + 59, y + 70);

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

        g.drawImage(Recursos.estadoPersonaje, x, y, null);

        g.drawImage(miniaturaNPC, x + 10, y + 9, ANCHOMINIATURA, ALTOMINIATURA, null);

        if (npc.getSalud() == npc.getSaludTope()) {
            drawBarra = ANCHOBARRA;
        } else {
            drawBarra = (npc.getSalud() * ANCHOBARRA) / npc.getSaludTope();
        }

        g.setColor(Color.WHITE);
        g.setFont(new Font("Tahoma", Font.PLAIN, 10));
        g.drawImage(Recursos.barraSalud, x + 80, y + 26, drawBarra, ALTOSALUD, null);
        g.drawString(String.valueOf(npc.getSalud()) + " / " + String.valueOf(npc.getSaludTope()), x + 132, y + 37);

        g.setFont(new Font("Tahoma", Font.PLAIN, 8));
        g.drawImage(Recursos.barraExperiencia, x + 77, y + 65, drawBarra, ALTOEXPERIENCIA, null);
        //g.drawString(String.valueOf(personaje.getExperiencia()) + " / " + String.valueOf(Personaje.getTablaDeNiveles()[personaje.getNivel() + 1]), x + 132, y + 70);
        g.setFont(new Font("Tahoma", Font.PLAIN, 10));
        g.setColor(Color.GREEN);
        g.drawString(String.valueOf(npc.getNivel()), x + 59, y + 70);
    }
}
