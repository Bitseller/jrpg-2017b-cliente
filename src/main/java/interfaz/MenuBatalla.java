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

    private static final int X = 100;
    private static final int Y = 380;
    private static final int ANCHO_BOTON = 40;
    private static final int[][] BOTONES = { { X + 48, Y + 72 }, { X + 48, Y + 146 }, { X + 221, Y + 72 }, { X + 221, Y
        + 146 }, { X + 394, Y + 72 }, { X + 394, Y + 146 } };
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
    public MenuBatalla(boolean habilitado, Personaje personaje) {
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
            g.drawImage(Recursos.menuBatalla, X, Y, null);
        } else {
            g.drawImage(Recursos.menuBatallaDeshabilitado, X, Y, null);
        }

        // Dibujo los boones
        g.drawImage(Recursos.habilidades.get(personaje.getHabilidadesRaza()[0]), BOTONES[0][0], BOTONES[0][1],
            ANCHO_BOTON, ANCHO_BOTON, null);
        g.drawImage(Recursos.habilidades.get(personaje.getHabilidadesRaza()[1]), BOTONES[1][0], BOTONES[1][1],
            ANCHO_BOTON, ANCHO_BOTON, null);
        g.drawImage(Recursos.habilidades.get(personaje.getHabilidadesCasta()[0]), BOTONES[2][0], BOTONES[2][1],
            ANCHO_BOTON, ANCHO_BOTON, null);
        g.drawImage(Recursos.habilidades.get(personaje.getHabilidadesCasta()[1]), BOTONES[3][0], BOTONES[3][1],
            ANCHO_BOTON, ANCHO_BOTON, null);
        g.drawImage(Recursos.habilidades.get(personaje.getHabilidadesCasta()[2]), BOTONES[4][0], BOTONES[4][1],
            ANCHO_BOTON, ANCHO_BOTON, null);
        g.drawImage(Recursos.habilidades.get("Ser Energizado"), BOTONES[5][0], BOTONES[5][1], ANCHO_BOTON, ANCHO_BOTON,
            null);

        // Dibujo las leyendas
        g.setFont(new Font("Book Antiqua", 1, 14));
        g.drawString(personaje.getHabilidadesRaza()[0], X + 95, Y + 94);
        g.drawString(personaje.getHabilidadesRaza()[1], X + 95, Y + 168);
        g.drawString(personaje.getHabilidadesCasta()[0], X + 268, Y + 94);
        g.drawString(personaje.getHabilidadesCasta()[1], X + 268, Y + 168);
        g.drawString(personaje.getHabilidadesCasta()[2], X + 442, Y + 94);
        g.drawString("Ser energizado", X + 442, Y + 168);

        // Dibujo el turno de quien es
        g.setColor(Color.WHITE);
        if (habilitado) {
            Pantalla.centerString(g, new Rectangle(X, Y + 5, Recursos.menuBatalla.getWidth(), 20), "Mi Turno");
        } else {
            Pantalla.centerString(g, new Rectangle(X, Y + 5, Recursos.menuBatalla.getWidth(), 20), "Turno Rival");
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
        if (mouseX >= X && mouseX <= X + Recursos.menuBatalla.getWidth() && mouseY >= Y && mouseY <= Y
            + Recursos.menuBatalla.getHeight()) {
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
    public void setHabilitado(boolean b) {
        habilitado = b;
    }
}
