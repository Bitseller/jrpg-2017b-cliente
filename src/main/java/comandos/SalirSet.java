package comandos;

import mensajeria.Comando;

/**
 * The Class SalirSet.
 */
public class SalirSet extends ComandosCliente {

    @Override
    public void ejecutar() {
        cliente.getPaqueteUsuario().setIp(cliente.getMiIp());
        cliente.getPaqueteUsuario().setComando(Comando.SALIR);
    }

}
