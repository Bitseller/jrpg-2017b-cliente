package comandos;

import java.io.IOException;

import javax.swing.JOptionPane;

import frames.MenuComerciar;
import mensajeria.Paquete;
import mensajeria.PaqueteComerciar;

/**
 * The Class Comercio.
 */
public class Comercio extends ComandosEscucha {

    @Override
    public void ejecutar() {
        PaqueteComerciar paqueteComerciar;
        paqueteComerciar = getGson().fromJson(getCadenaLeida(), PaqueteComerciar.class);
        // Cuando recibo el paquete de comercio actualizado intercambio user/ destino
        paqueteComerciar.setIdEnemigo(paqueteComerciar.getId());
        paqueteComerciar.setId(juego.getCliente().getPaquetePersonaje().getId());

        if (paqueteComerciar.isSolicitudDeComercio()) {
            if (juego.getCliente().getM1() != null) {
                paqueteComerciar.setMensaje(Paquete.msjFracaso);
            } else {
                juego.getCliente().setPaqueteComercio(paqueteComerciar);
                juego.getCliente().setM1(new MenuComerciar(juego.getCliente()));
                juego.getCliente().getM1().setVisible(true);
                paqueteComerciar.setMensaje(Paquete.msjExito);
            }
            paqueteComerciar.setSolicitudDeComercio(false);
            try {
                juego.getCliente().getSalida().writeObject(getGson().toJson(paqueteComerciar));
            } catch (IOException e) {
                JOptionPane.showMessageDialog(null, "No se envio la solicitud de comercio");
            }

        } else {
            if (paqueteComerciar.getMensaje().equals(Paquete.msjFracaso)) {
                JOptionPane.showMessageDialog(null, "Ya esta comerciando");
            } else {
                if (juego.getCliente().getM1() == null) {
                    juego.getCliente().setPaqueteComercio(paqueteComerciar);
                    juego.getCliente().setM1(new MenuComerciar(juego.getCliente()));
                    juego.getCliente().getM1().setVisible(true);
                }
            }
        }

    }

}
