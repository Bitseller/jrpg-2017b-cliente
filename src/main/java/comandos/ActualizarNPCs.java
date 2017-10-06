package comandos;

import mensajeria.PaqueteDeNPC;
import mensajeria.PaqueteDeNPCs;
import mensajeria.PaquetePersonaje;

public class ActualizarNPCs extends ComandosEscucha{
	@Override
	public void ejecutar() {
		PaqueteDeNPCs paqueteDeNPCs = (PaqueteDeNPCs) gson.fromJson(cadenaLeida, PaqueteDeNPCs.class);

		//juego.getPersonajesConectados().remove(paqueteDeNPC.getId());
		juego.setNPCs( paqueteDeNPCs.getNPCs() );
		
		/*
		if (juego.getPersonaje().getId() == paquetePersonaje.getId()) {
			juego.actualizarPersonaje();
			juego.getEstadoJuego().actualizarPersonaje();
			juego.getCliente().actualizarItems(paquetePersonaje);
			juego.getCliente().actualizarPersonaje(juego.getPersonajesConectados().get(paquetePersonaje.getId()));

		} */

	}
}
