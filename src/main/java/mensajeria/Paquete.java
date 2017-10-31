package mensajeria;

import java.io.Serializable;

import javax.swing.JOptionPane;

/**
 * The Class Paquete.
 */
public class Paquete implements Serializable, Cloneable {

    private static String msjExito = "1";
    private static String msjFracaso = "0";

    private String mensaje;
    private String ip;
    private int comando;

    /**
     * Instantiates a new paquete.
     */
    public Paquete() {

    }

    /**
     * Instantiates a new paquete.
     *
     * @param mensaje
     *            el mensaje
     * @param nick
     *            el nick
     * @param ip
     *            la ip
     * @param comando
     *            el comando
     */
    public Paquete(final String mensaje, final String nick, final String ip, final int comando) {
        this.mensaje = mensaje;
        this.ip = ip;
        this.comando = comando;
    }

    /**
     * Instantiates a new paquete.
     *
     * @param mensaje
     *            el mensaje
     * @param comando
     *            el comando
     */
    public Paquete(final String mensaje, final int comando) {
        this.mensaje = mensaje;
        this.comando = comando;
    }

    /**
     * Instantiates a new paquete.
     *
     * @param comando
     *            the comando
     */
    public Paquete(final int comando) {
        this.comando = comando;
    }

    /**
     * Sets the mensaje.
     *
     * @param mensaje
     *            the new mensaje
     */
    public void setMensaje(final String mensaje) {
        this.mensaje = mensaje;
    }

    /**
     * Sets the ip.
     *
     * @param ip
     *            the new ip
     */
    public void setIp(final String ip) {
        this.ip = ip;
    }

    /**
     * Sets the comando.
     *
     * @param comando
     *            the new comando
     */
    public void setComando(final int comando) {
        this.comando = comando;
    }

    /**
     * Gets the mensaje.
     *
     * @return the mensaje
     */
    public String getMensaje() {
        return mensaje;
    }

    /**
     * Gets the ip.
     *
     * @return the ip
     */
    public String getIp() {
        return ip;
    }

    /**
     * Gets the comando.
     *
     * @return the comando
     */
    public int getComando() {
        return comando;
    }

    @Override
    public Object clone() {
        Object obj = null;
        try {
            obj = super.clone();
        } catch (CloneNotSupportedException ex) {
            JOptionPane.showMessageDialog(null, "Error al clonar");

        }
        return obj;
    }

    /**
     * Gets the objeto.
     *
     * @param nombrePaquete
     *            the nombre paquete
     * @return the objeto
     */
    public Comando getObjeto(final String nombrePaquete) {
        Comando c = null;
        try {
            c = (Comando) Class.forName(nombrePaquete + "." + Comando.CLASSNAMES[comando]).newInstance();
            return c;
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException e) {
            JOptionPane.showMessageDialog(null, "Error al seleccionar orden");
            //Si no encuentra la ordne apropiada, enseño mensaje de error y retorno el Comando inicializado en null;

        }

        return c;

    }

    /**
     * Gets the objeto set.
     *
     * @param nombrePaquete
     *            el paquete
     * @param accion
     *            la accion
     * @return el comnado del paquete
     */
    public static Comando getObjetoSet(final String nombrePaquete, final int accion) {
        Comando c = null;
        try {
            c = (Comando) Class.forName(nombrePaquete + "." + Comando.CLASSNAMESBIS[accion]).newInstance();
            return c;
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException e) {
            JOptionPane.showMessageDialog(null, "Error al seleccionar orden");
            //Si no encuentra la ordne apropiada, enseño mensaje de error y retorno el Comando inicializado en null;
        }
        return c;
    }

	/**
	 * @return the msjExito
	 */
	public static String getMsjExito() {
		return msjExito;
	}

	/**
	 * @param msjExito the msjExito to set
	 */
	public static void setMsjExito(String msjExito) {
		Paquete.msjExito = msjExito;
	}

	/**
	 * @return the msjFracaso
	 */
	public static String getMsjFracaso() {
		return msjFracaso;
	}

	/**
	 * @param msjFracaso the msjFracaso to set
	 */
	public static void setMsjFracaso(String msjFracaso) {
		Paquete.msjFracaso = msjFracaso;
	}

}
