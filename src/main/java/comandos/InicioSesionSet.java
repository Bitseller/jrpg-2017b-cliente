package comandos;

import mensajeria.Comando;

/**
 * The Class InicioSesionSet.
 */
public class InicioSesionSet extends ComandosCliente {

    @Override
    public void ejecutar() {
        cliente.getPaqueteUsuario().setComando(Comando.INICIOSESION);
    }
}
