package mensajeria;

import com.google.gson.Gson;

/**
 * The Class Comando.
 */
public abstract class Comando {
    // Nombre del paquete donde se encuentran las clases con las
    // responsabilidades
    public static final String NOMBREPAQUETE = "comandos";

    public static final String[] CLASSNAMES = {
        "Conexion", "CrearPersonaje", "Desconectar", "InicioSesion",
        "MostrarMapas", "Movimiento", "Registro", "Salir", "Batalla", "Atacar", "FinalizarBatalla",
        "ActualizarPersonaje", "ActualizarPersonajeLvl", "ActualizarInventario", "Comercio", "ActualizarComercio",
        "Trueque", "ActualizarTrueque", "Talk", "MovimientoNPC", "ActualizarNPCs", "IniciarBatallaNPC",
        "FinalizarBatallaNPC" };

    public static final String[] CLASSNAMESBIS = {
        "Conexion", "CrearPersonaje", "Desconectar", "InicioSesionSet",
        "MostrarMapas", "Movimiento", "RegistroSet", "SalirSet", "Batalla", "Atacar", "FinalizarBatalla",
        "ActualizarPersonaje", "ActualizarPersonajeLvl", "ActualizarInventario", "Comercio", "ActualizarComercio",
        "Trueque", "ActualizarTrueque", "Talk", "MovimientoNPC", "ActualizarNPCs", "IniciarBatallaNPC",
        "FinalizarBatallaNPC" };

    public static final int CONEXION = 0;
    public static final int CREACIONPJ = 1;
    public static final int DESCONECTAR = 2;
    public static final int INICIOSESION = 3;
    public static final int MOSTRARMAPAS = 4;
    public static final int MOVIMIENTO = 5;
    public static final int REGISTRO = 6;
    public static final int SALIR = 7;
    public static final int BATALLA = 8;
    public static final int ATACAR = 9;
    public static final int FINALIZARBATALLA = 10;
    public static final int ACTUALIZARPERSONAJE = 11;
    public static final int ACTUALIZARPERSONAJELV = 12;
    public static final int ACTUALIZARINVENTARIO = 13;
    public static final int COMERCIO = 14;
    public static final int ACTUALIZARCOMERCIO = 15;
    public static final int TRUEQUE = 16;
    public static final int ACTUALIZARTRUEQUE = 17;
    public static final int TALK = 18;
    public static final int MOVIMIENTONPCS = 19;
    public static final int ACTUALIZARNPCS = 20;
    public static final int INICIARBATALLANPC = 21;
    public static final int FINALIZARBATALLANPC = 22;

    private final Gson gson = new Gson();
    private String cadenaLeida;

    /**
     * Sets the cadena.
     *
     * @param cadenaRecibida
     *            una cadena
     */
    public void setCadena(final String cadenaRecibida) {
        this.cadenaLeida = cadenaRecibida;
    }

    /**
     * Ejecutar el comando
     */
    public abstract void ejecutar();

    /**
     * @return the cadenaLeida
     */
    public String getCadenaLeida() {
        return cadenaLeida;
    }

    /**
     * @param cadenaLeida the cadenaLeida to set
     */
    public void setCadenaLeida(final String cadenaLeida) {
        this.cadenaLeida = cadenaLeida;
    }

    /**
     * @return the gson
     */
    public Gson getGson() {
        return gson;
    }
}
