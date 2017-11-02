package inventario;

import java.awt.Dimension;
import java.awt.Image;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import dominio.Item;
import mensajeria.PaquetePersonaje;
import recursos.Recursos;

/**
 * The Class Celda.
 */
public class Celda extends JPanel {

    private static final int CELDA_TAM = 60;
    private static final int ICON_SIZE = 49;
    private BufferedImage item;
    private PaquetePersonaje paquetePersonaje;
    private JLabel label;
    private Item it;

    /**
     * Instantiates a new celda.
     *
     * @param item
     *            the item
     * @param paquetePersonaje
     *            the paquete personaje
     * @throws IOException
     *             Signals that an I/O exception has occurred.
     */
    public Celda(final Item item, final PaquetePersonaje paquetePersonaje) throws IOException {
        this.item = item.getFoto();
        it = item;
        this.paquetePersonaje = paquetePersonaje;
        label = new JLabel(new ImageIcon(this.item.getScaledInstance(ICON_SIZE, ICON_SIZE, Image.SCALE_DEFAULT)));
        actionListenersYLabel(item);
    }

    /**
     * Instantiates a new celda.
     */
    public Celda() {
        label = new JLabel(new ImageIcon(Recursos.getNoItem().getScaledInstance(ICON_SIZE, ICON_SIZE, Image.SCALE_DEFAULT)));
        add(label);
    }

    /**
     * Action listeners Y label.
     *
     * @param obj
     *            the item
     */
    private void actionListenersYLabel(final Item obj) {
        StringBuilder s = new StringBuilder();

        s.append("<html>" + obj.getNombre() + "<br>");

        if (obj.getBonusSalud() != 0) {
            s.append("+" + obj.getBonusSalud() + " Salud " + "<br>");
        }
        if (obj.getBonusEnergia() != 0) {
            s.append("+" + obj.getBonusEnergia() + " Energia " + "<br>");
        }
        if (obj.getBonusFuerza() != 0) {
            s.append("+" + obj.getBonusFuerza() + " Fuerza " + "<br>");
        }
        if (obj.getBonusDestreza() != 0) {
            s.append("+" + obj.getBonusDestreza() + " Destreza " + "<br>");
        }
        if (obj.getBonusInteligencia() != 0) {
            s.append("+" + obj.getBonusInteligencia() + " Inteligencia");
        }
        s.append("</html>");
        label.setToolTipText(s.toString());

        label.addMouseListener(mouseListener);

        addMouseListener(mouseListener);

        add(label);
        this.validate();
        this.repaint();

    }

    /**
     * Reset label.
     */
    protected void resetLabel() {
        label.setIcon(new ImageIcon(Recursos.getNoItem().getScaledInstance(ICON_SIZE, ICON_SIZE, Image.SCALE_DEFAULT)));
        label.setToolTipText(null);
        paquetePersonaje.removerItem(it);
        label.removeMouseListener(mouseListener);
        removeMouseListener(mouseListener);
    }

    @Override
    public Dimension getPreferredSize() {
        return new Dimension(CELDA_TAM, CELDA_TAM);
    }

    /**
     * Gets the label.
     *
     * @return the label
     */
    public JLabel getLabel() {
        return label;
    }

    private MouseListener mouseListener = new MouseAdapter() {
        @Override
        public void mouseClicked(final MouseEvent e) {
            Object[] options = {
                "Tirar", "Cancelar" };
            if (e.getClickCount() == 2) {
                int answer = JOptionPane.showOptionDialog(getParent(), "¿Qué desea hacer?", "Item: " + it.getNombre(),
                    JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE, null, options, options[1]);
                //Tirar
                if (answer == 0) {
                    paquetePersonaje.sacarBonus(it.getBonusSalud(), it.getBonusEnergia(), it.getBonusFuerza(),
                        it.getBonusDestreza(), it.getBonusInteligencia());
                    resetLabel();
                }
            }
        }
    };
}
