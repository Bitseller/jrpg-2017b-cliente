package properties;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;
/** 
 * Clase que nos permite acceder a las propiedades de comunicacion.
 * Se aplica el patron singleton por las siguientes motivos.
 * 	.Prentendemos encapsular el acceso al archivos de propiedaes cada vez que queremos  conocer algun valor de alguna propiedad por ejemplo el puerto
 * 	.Por otro lado consideramos que no se debe estar accediendo constantemente al archivo en disco, accedemos una vez y conservamos sus valores en memoria, y al controlar la creacion de instancias aseguramos tener una sola copia de ellos.
 * 	.Tambien con singleton nos evitamos ensuciar el codigo que necesita acceder a las propiedades instanciando esta clase.
 * */
public class PropiedadesComunicacion {
	private final String RUTA_PROPIEDADES = "properties/comunicacion.properties";
	
	private final String KEY_PORT = "Servidor.PORT";
	private final String KEY_IP = "Servidor.IP";
	
	private static PropiedadesComunicacion propiedades = null;

	private int puerto;
	private String ip;
	
	public static String getIpServidor() throws Exception {
		getInstancia();
		return propiedades.ip;
	}

	public static int getPuertoServidor() throws Exception {
		getInstancia();
		return propiedades.puerto;
	}
	
	private static void getInstancia() throws Exception {
		if(propiedades == null)
			propiedades = new PropiedadesComunicacion();
	}
	
    private PropiedadesComunicacion() throws Exception{
        try{
	        
        	Properties propiedades = new Properties();
        	InputStream stream = ClassLoader.getSystemResourceAsStream(RUTA_PROPIEDADES);
	        propiedades.load(stream);
	        
	        puerto=Integer.parseInt(propiedades.getProperty(KEY_PORT));
	        ip= propiedades.getProperty(KEY_IP);
	        
	        stream.close();
	        if(!validarIP(ip))
	        	throw new Exception("Error de direccion ip del servidor");
	        if(!validarPuerto(puerto))
	        	throw new Exception("Error de direccion ip del servidor");
        }catch(Exception ex){            
            throw ex;
        }
    }
    
    
    public static boolean validarIP(final String ip) {
	    String PATTERN = "^((0|1\\d?\\d?|2[0-4]?\\d?|25[0-5]?|[3-9]\\d?)\\.){3}(0|1\\d?\\d?|2[0-4]?\\d?|25[0-5]?|[3-9]\\d?)$";
	    return ip.matches(PATTERN)||ip.equals("localhost");
	}
	
	public static boolean validarPuerto(final int puerto) {
		try{
			if(puerto> 0 && puerto< 65535 )
				return true;
			
		}
		catch(Exception ex){
			return false;
		}
		return false;
	}
    
    
}
