package mensajeria;

import java.io.Serializable;
import java.util.Map;

public class PaqueteDeNPCs extends Paquete implements Serializable, Cloneable {


	private Map<Integer, PaqueteDeNPC> NPCs;

	public PaqueteDeNPCs(){

	}

	public PaqueteDeNPCs(Map<Integer, PaqueteDeNPC> NPCs){
		this.NPCs = NPCs;
	}

	public Map<Integer, PaqueteDeNPC> getNPCs(){
		return NPCs;
	}

	@Override
	public Object clone() {
		Object obj = null;
		obj = super.clone();
		return obj;
	}
}
