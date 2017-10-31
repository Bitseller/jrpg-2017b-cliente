package recursos;

import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JOptionPane;

/**
 * The Class CargadorImagen.
 */
public class CargadorImagen {

    /**
     * Instantiates a new cargador imagen.
     */
    private CargadorImagen() {

    }

    /**
     * Carga una imagen.
     *
     * @param path
     *            ruta de la imagen
     * @return the buffered image
     */
    public static BufferedImage cargarImagen(final String path) {
        try {
            return ImageIO.read(CargadorImagen.class.getResource(path));
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, "Error al cargar el archivo " + path);
        }

        return null;
    }
}
