package properties;

import java.io.InputStream;
import java.util.Properties;

/**
 * Clase que nos permite acceder a las propiedades de comunicacion. Se aplica el
 * patron singleton por las siguientes motivos. .Prentendemos encapsular el
 * acceso al archivos de propiedaes cada vez que queremos conocer algun valor de
 * alguna propiedad por ejemplo el puerto .Por otro lado consideramos que no se
 * debe estar accediendo constantemente al archivo en disco, accedemos una vez y
 * conservamos sus valores en memoria, y al controlar la creacion de instancias
 * aseguramos tener una sola copia de ellos. .Tambien con singleton nos evitamos
 * ensuciar el codigo que necesita acceder a las propiedades instanciando esta
 * clase.
 */
public final class PropiedadesComunicacion {
    private static final int MAX_PORT = 65535;

    private final String rutaPropiedades = "properties/comunicacion.properties";

    private final String keyPort = "Servidor.PORT";
    private final String keyIp = "Servidor.IP";

    private static PropiedadesComunicacion propiedades = null;

    private int puerto;
    private String ip;

    /**
     * Gets the ip servidor.
     *
     * @return the ip servidor
     * @throws Exception
     *             the exception
     */
    public static String getIpServidor() throws Exception {
        getInstancia();
        return propiedades.ip;
    }

    /**
     * Gets the puerto servidor.
     *
     * @return the puerto servidor
     * @throws Exception
     *             the exception
     */
    public static int getPuertoServidor() throws Exception {
        getInstancia();
        return propiedades.puerto;
    }

    /**
     * Gets the instancia.
     *
     * @throws Exception
     *             the exception
     */
    private static void getInstancia() throws Exception {
        if (propiedades == null) {
            propiedades = new PropiedadesComunicacion();
        }
    }

    /**
     * Instantiates a new propiedades comunicacion.
     *
     * @throws Exception
     *             the exception
     */
    private PropiedadesComunicacion() throws Exception {
        try {

            Properties propiedades = new Properties();
            InputStream stream = ClassLoader.getSystemResourceAsStream(rutaPropiedades);
            propiedades.load(stream);

            puerto = Integer.parseInt(propiedades.getProperty(keyPort));
            ip = propiedades.getProperty(keyIp);

            stream.close();
            if (!validarIP(ip)) {
                throw new Exception("Error de direccion ip del servidor");
            }
            if (!validarPuerto(puerto)) {
                throw new Exception("Error de direccion ip del servidor");
            }
        } catch (Exception ex) {
            throw ex;
        }
    }

    /**
     * Validar la IP.
     *
     * @param ip
     *            the ip
     * @return true, if successful
     */
    public static boolean validarIP(final String ip) {
        String pattern
         = "^((0|1\\d?\\d?|2[0-4]?\\d?|25[0-5]?|[3-9]\\d?)\\.){3}(0|1\\d?\\d?|2[0-4]?\\d?|25[0-5]?|[3-9]\\d?)$";
        return ip.matches(pattern) || ip.equals("localhost");
    }

    /**
     * Validar el puerto.
     *
     * @param puerto
     *            the puerto
     * @return true, if successful
     */
    public static boolean validarPuerto(final int puerto) {
        try {
            if (puerto > 0 && puerto < MAX_PORT) {
                return true;
            }
        } catch (Exception ex) {
            return false;
        }
        return false;
    }
}
