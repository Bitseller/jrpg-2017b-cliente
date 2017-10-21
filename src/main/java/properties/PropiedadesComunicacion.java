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
	private final static String RUTA_PROPIEDADES = "properties/config.properties";
	
	private final static String KEY_PORT = "Servidor.PORT";
	private final static String KEY_IP = "Servidor.IP";
	
	private static PropiedadesComunicacion propiedades = null;

	private int puerto;
	private String ip;
	
	public static String getIpServidor() throws IOException {
		if(propiedades == null)
			propiedades = new PropiedadesComunicacion();
		return propiedades.ip;
	}

	public static int getPuertoServidor() throws IOException {
		if(propiedades == null)
			propiedades = new PropiedadesComunicacion();
		return propiedades.puerto;
	}
	
    private PropiedadesComunicacion() throws IOException{
        try{
	        
        	Properties propiedades = new Properties();
        	InputStream stream = ClassLoader.getSystemResourceAsStream(RUTA_PROPIEDADES);
	        propiedades.load(stream);
	        
	        puerto=Integer.parseInt(propiedades.getProperty(KEY_PORT));
	        ip= propiedades.getProperty(KEY_IP);
	        
	        stream.close();
        }catch(IOException ex){            
            throw ex;
        }
    }
    
    public static void restaurarArchivoDeConfiguracion() {
        	Properties propiedades = new Properties();
        	
        	 try{
     	        
             	InputStream stream = ClassLoader.getSystemResourceAsStream(RUTA_PROPIEDADES);
     	        propiedades.load(stream);
     	        propiedades.setProperty(KEY_PORT, "550501");
     	        propiedades.setProperty(KEY_IP, "localHost");
     	        
     	        stream.close();
             }catch(IOException ex){         
 				ex.printStackTrace();
             }
        	
    }
    
}
