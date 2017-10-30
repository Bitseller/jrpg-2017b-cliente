package comandos;

import cliente.Cliente;
import mensajeria.Comando;

/**
 * The Class ComandosCliente.
 */
public abstract class ComandosCliente extends Comando {
    protected Cliente cliente;

    /**
     * Sets the cliente.
     *
     * @param cliente
     *            el cliente
     */
    public void setCliente(final Cliente cliente) {
        this.cliente = cliente;
    }

}
