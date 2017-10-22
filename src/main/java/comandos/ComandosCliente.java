package comandos;

import cliente.Cliente;
import mensajeria.Comando;

public abstract class ComandosCliente extends Comando {
	protected Cliente cliente;
	public void setCliente(final Cliente cliente) {
		this.cliente = cliente;
	}
	

}
