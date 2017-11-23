package mensajeria;

import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

import javax.swing.JOptionPane;

import dominio.Item;
import estados.Estado;

/**
 * The Class PaquetePersonaje.
 */
public class PaquetePersonaje extends Paquete implements Serializable, Cloneable {

	/**
	 * Codigo de modo dios
	 */
	public static final int CODE_IDDQD = 1; 
	
	/**
	 * Codigo de modo espectro
	 */
	public static final int CODE_NOCLIP = 2; 
	
	/**
	 * Codigo de modo Hulk
	 */
	public static final int CODE_BIGDADDY = 3;
	
	/**
	 * Codigo de modo KickAss
	 */
	public static final int CODE_TINYDADDY = 4;
	/**
	 * Codigo de modo fantasma
	 */
	public static final int CODE_WAWIUTB = 5; 
	
    private int id;
    private String idMapa;
    private int estado;
    private String casta;
    private String nombre;
    private String raza;
    private int saludTope;
    private int energiaTope;
    private int fuerza;
    private int destreza;
    private int inteligencia;
    private int nivel = 1;
    private int experiencia;
    private int puntosSkill;
    private ArrayList<Item> items = new ArrayList<Item>();
    
    //Paquete de cheats dentro del personaje
    private ArrayList<Boolean> estadoCheats;
    private final HashMap<String, Integer> cheatMap;
    private final HashMap<Integer,Runnable> cheatAction;
    
    //Agrego un estado invisible
    private boolean invisible = false;
    
    public void getCheatsPersonaje() {
    	
    }

    public boolean isInvisible() {
		return invisible;
	}

	public void setInvisible(boolean invisible) {
		this.invisible = invisible;
	}

	/**
     * Instantiates a new paquete personaje.
     *
     * @throws IOException
     *             Signals that an I/O exception has occurred.
     */
    public PaquetePersonaje() throws IOException {
        estado = Estado.getEstadoOffline();
        
        //Se instancia vector y Mapa de cheats del personaje.
        cheatMap = new HashMap<String, Integer>();
        estadoCheats = new ArrayList<Boolean>();
        cheatAction = new HashMap<Integer,Runnable>();

        //Cada cheat tiene un valor asignado para saber donde buscar en el array de estado.
        cheatMap.put("/iddqd", CODE_IDDQD);
        cheatMap.put("/noclip", CODE_NOCLIP);
        cheatMap.put("/bigdaddy", CODE_BIGDADDY);
        cheatMap.put("/tinnydaddy", CODE_TINYDADDY);
        cheatMap.put("/war aint what it used to be", CODE_WAWIUTB);

        //Todos los cheats se inicializan en false.
        estadoCheats.add(false);
        estadoCheats.add(false);
        estadoCheats.add(false);
        estadoCheats.add(false);
        estadoCheats.add(false);
        
        //Todos los cheats poseen su metodo.
        //cheatAction.put(CODE_IDDQD, ()-> setIddqd());
        //cheatAction.put(CODE_NOCLIP, ()-> setNoClip());
        //cheatAction.put(CODE_BIGDADDY, ()-> setBigDaddy());
        //cheatAction.put(CODE_TINYDADDY, ()-> setTinyDaddy());
        //cheatAction.put(CODE_WAWIUTB, ()-> setWawiutb());
    }
    
//    /**
//     * Aplica el cheat iddqd
//     */
//	private void setIddqd() {
//    	System.out.println("ACTIVAR CHEAT");
//    }
//    
//	/**
//     * Aplica el cheat noclip
//     */
//    private void setNoClip() {
//    	
//    }
//    
//    /**
//     * Aplica el cheat bigdaddy
//     */
//    private void setBigDaddy() {
//    	
//    }
//    
//    /**
//     * Aplica el cheat tinydaddy
//     */
//    private void setTinyDaddy() {
//    	
//    }
//    
//    /**
//     * Aplica el cheat war aint what it used to be
//     */
//    private void setWawiutb() {
//		
//	}
//    
	/**
     * Get el valor de la key del mapa de cheats.
     * 
     * @return el mapa de cheats
     */
    public HashMap<String, Integer> getCheats(){
    	return this.cheatMap;
    }
    
    /**
     * Get el estado de los cheats.
     * 
     * @return el array de estado de los cheats
     */
    public Boolean getEstadoCheats(int index){
    	return this.estadoCheats.get(index-1);
    }
    
    /**
     * Set el estado de los cheats.
     * 
     * @param index
     * @param valor
     */
    public void setEstadoCheats(int index, boolean valor){
    	this.estadoCheats.remove(index-1);
    	this.estadoCheats.add(index-1, valor);
    }
    
    public HashMap<Integer, Runnable> getCheatAction() {
    	return this.cheatAction;
    }
    /**
     * Gets the estado.
     *
     * @return the estado
     */
    public int getEstado() {
        return estado;
    }

    /**
     * Sets the estado.
     *
     * @param estado
     *            the new estado
     */
    public void setEstado(final int estado) {
        this.estado = estado;
    }

    /**
     * Gets the mapa.
     *
     * @return the mapa
     */
    public String getMapa() {
        return idMapa;
    }

    /**
     * Sets the mapa.
     *
     * @param mapa
     *            the new mapa
     */
    public void setMapa(final String mapa) {
        idMapa = mapa;
    }

    /**
     * Gets the nivel.
     *
     * @return the nivel
     */
    public int getNivel() {
        return nivel;
    }

    /**
     * Sets the nivel.
     *
     * @param nivel
     *            the new nivel
     */
    public void setNivel(final int nivel) {
        this.nivel = nivel;
    }

    /**
     * Gets the experiencia.
     *
     * @return the experiencia
     */
    public int getExperiencia() {
        return experiencia;
    }

    /**
     * Sets the experiencia.
     *
     * @param experiencia
     *            the new experiencia
     */
    public void setExperiencia(final int experiencia) {
        this.experiencia = experiencia;
    }

    /**
     * Gets the id.
     *
     * @return the id
     */
    public int getId() {
        return id;
    }

    /**
     * Sets the id.
     *
     * @param id
     *            the new id
     */
    public void setId(final int id) {
        this.id = id;
    }

    /**
     * Gets the casta.
     *
     * @return the casta
     */
    public String getCasta() {
        return casta;
    }

    /**
     * Sets the casta.
     *
     * @param casta
     *            the new casta
     */
    public void setCasta(final String casta) {
        this.casta = casta;
    }

    /**
     * Gets the nombre.
     *
     * @return the nombre
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * Sets the nombre.
     *
     * @param nombre
     *            the new nombre
     */
    public void setNombre(final String nombre) {
        this.nombre = nombre;
    }

    /**
     * Gets the raza.
     *
     * @return the raza
     */
    public String getRaza() {
        return raza;
    }

    /**
     * Sets the raza.
     *
     * @param raza
     *            the new raza
     */
    public void setRaza(final String raza) {
        this.raza = raza;
    }

    /**
     * Gets the salud tope.
     *
     * @return the salud tope
     */
    public int getSaludTope() {
        return saludTope;
    }

    /**
     * Sets the salud tope.
     *
     * @param saludTope
     *            the new salud tope
     */
    public void setSaludTope(final int saludTope) {
        this.saludTope = saludTope;
    }

    /**
     * Gets the energia tope.
     *
     * @return the energia tope
     */
    public int getEnergiaTope() {
        return energiaTope;
    }

    /**
     * Sets the energia tope.
     *
     * @param energiaTope
     *            the new energia tope
     */
    public void setEnergiaTope(final int energiaTope) {
        this.energiaTope = energiaTope;
    }

    /**
     * Gets the fuerza.
     *
     * @return the fuerza
     */
    public int getFuerza() {
        return fuerza;
    }

    /**
     * Sets the fuerza.
     *
     * @param fuerza
     *            the new fuerza
     */
    public void setFuerza(final int fuerza) {
        this.fuerza = fuerza;
    }

    /**
     * Gets the destreza.
     *
     * @return the destreza
     */
    public int getDestreza() {
        return destreza;
    }

    /**
     * Sets the destreza.
     *
     * @param destreza
     *            the new destreza
     */
    public void setDestreza(final int destreza) {
        this.destreza = destreza;
    }

    /**
     * Gets the inteligencia.
     *
     * @return the inteligencia
     */
    public int getInteligencia() {
        return inteligencia;
    }

    /**
     * Sets the inteligencia.
     *
     * @param inteligencia
     *            the new inteligencia
     */
    public void setInteligencia(final int inteligencia) {
        this.inteligencia = inteligencia;
    }

    /**
     * Gets the puntos skill.
     *
     * @return the puntos skill
     */
    public int getPuntosSkill() {
        return puntosSkill;
    }

    /**
     * Sets the puntos skill.
     *
     * @param puntosSkill
     *            the new puntos skill
     */
    public void setPuntosSkill(final int puntosSkill) {
        this.puntosSkill = puntosSkill;
    }

    @Override
    public Object clone() {
        Object obj = null;
        obj = super.clone();
        return obj;
    }

    /**
     * Anadir item.
     *
     * @param i
     *            the i
     */
    public final void anadirItem(final Item i) {
        items.add(i);
    }

    /**
     * Remover item.
     *
     * @param i
     *            the i
     */
    public final void removerItem(final Item i) {
        items.remove(i);
    }

    /**
     * Gets the items.
     *
     * @return the items
     */
    public ArrayList<Item> getItems() {
        return new ArrayList<Item>(items);
    }

    /**
     * Sets the items.
     *
     * @param items
     *            the new items
     */
    public final void setItems(final ArrayList<Item> items) {
        this.items = items;
    }

    /**
     * Gets the item ID.
     *
     * @param index
     *            the index
     * @return the item ID
     */
    public final int getItemID(final int index) {
        return items.get(index).getIdItem();
    }

    /**
     * Anadir item.
     *
     * @param idItem
     *            the id item
     * @param nombre
     *            the nombre
     * @param wearLocation
     *            the wear location
     * @param bonusSalud
     *            the bonus salud
     * @param bonusEnergia
     *            the bonus energia
     * @param bonusAtaque
     *            the bonus ataque
     * @param bonusDefensa
     *            the bonus defensa
     * @param bonusMagia
     *            the bonus magia
     * @param foto
     *            the foto
     * @param fotoEquipado
     *            the foto equipado
     */
    public final void anadirItem(final int idItem, final String nombre, final int wearLocation, final int bonusSalud,
        final int bonusEnergia,
        final int bonusAtaque, final int bonusDefensa, final int bonusMagia, final String foto,
        final String fotoEquipado) {
        try {
            items.add(new Item(idItem, nombre, wearLocation, bonusSalud, bonusEnergia, bonusAtaque, bonusDefensa,
                bonusMagia, foto, fotoEquipado));
            useBonus(bonusSalud, bonusEnergia, bonusAtaque, bonusDefensa, bonusMagia);
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, "Falló al añadir item");

        }
    }

    /**
     * Metodo que retorna un entero. Dependiendo del skill se calcula el stat de
     * skill base.
     *
     * @param skill
     *            the skill
     * @return Retorna el skill base dependiendo de los items.
     */

    public final int getStatSkill(final String skill) {
        int skillBase = 0;

        switch (skill) {
            case "Fuerza":
                for (Item item : items) {
                    skillBase += item.getBonusFuerza();
                }
                break;
            case "Destreza":
                for (Item item : items) {
                    skillBase += item.getBonusDestreza();
                }
            default:
                for (Item item : items) {
                    skillBase += item.getBonusInteligencia();

                }
                break;
        }
        return skillBase;
    }

    /**
     * Remover bonus.
     */
    public final void removerBonus() {
        // Intente usar un iterator y por alguna razón no andaba..
        int i = 0;
        while (i < items.size()) {
            sacarBonus(items.get(i).getBonusSalud(), items.get(i).getBonusEnergia(), items.get(i).getBonusFuerza(),
                items.get(i).getBonusDestreza(), items.get(i).getBonusInteligencia());
            i++;
        }
    }

    /**
     * Sacar bonus.
     *
     * @param bonusSalud
     *            the bonus salud
     * @param bonusEnergia
     *            the bonus energia
     * @param bonusAtaque
     *            the bonus ataque
     * @param bonusDefensa
     *            the bonus defensa
     * @param bonusMagia
     *            the bonus magia
     */
    public final void sacarBonus(final int bonusSalud, final int bonusEnergia, final int bonusAtaque,
        final int bonusDefensa, final int bonusMagia) {
        saludTope -= bonusSalud;
        energiaTope -= bonusEnergia;
        fuerza -= bonusAtaque;
        destreza -= bonusDefensa;
        inteligencia -= bonusMagia;
    }

    /**
     * Poner bonus.
     */
    public final void ponerBonus() {
        // Intente usar un iterator y por alguna razón no andaba..
        int i = 0;
        while (i < items.size()) {
            useBonus(items.get(i).getBonusSalud(), items.get(i).getBonusEnergia(), items.get(i).getBonusFuerza(),
                items.get(i).getBonusDestreza(), items.get(i).getBonusInteligencia());
            i++;
        }
    }

    /**
     * Use bonus.
     *
     * @param bonusSalud
     *            the bonus salud
     * @param bonusEnergia
     *            the bonus energia
     * @param bonusAtaque
     *            the bonus ataque
     * @param bonusDefensa
     *            the bonus defensa
     * @param bonusMagia
     *            the bonus magia
     */
    public void useBonus(final int bonusSalud, final int bonusEnergia, final int bonusAtaque, final int bonusDefensa,
        final int bonusMagia) {
        saludTope += bonusSalud;
        energiaTope += bonusEnergia;
        fuerza += bonusAtaque;
        destreza += bonusDefensa;
        inteligencia += bonusMagia;
    }

    /**
     * Gets the cant items.
     *
     * @return the cant items
     */
    public int getCantItems() {
        return items.size();
    }

    /**
     * Anadir item.
     *
     * @param idItem
     *            the id item
     */
    public void anadirItem(final int idItem) {
        try {
            items.add(new Item(idItem, null, 0, 0, 0, 0, 0, 0, null, null));
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, "Falló al añadir item");
        }

    }

    /**
     * Gets the iterator.
     *
     * @return the iterator
     */
    public Iterator<Item> getIterator() {
        // TODO Auto-generated method stub
        return items.iterator();
    }

    /**
     * Remover ultimo item.
     */
    public void removerUltimoItem() {
        items.remove(items.size() - 1);

    }

    /**
     * Nuevo item.
     *
     * @return true, if successful
     */
    public boolean nuevoItem() {
        return items.get(items.size() - 1).getNombre() == null;
    }

    /**
     * Poner bonus.
     *
     * @param cantItems
     *            the cant items
     */
    public void ponerBonus(final int cantItems) {
        int i = 0;
        while (i < cantItems) {
            useBonus(items.get(i).getBonusSalud(), items.get(i).getBonusEnergia(), items.get(i).getBonusFuerza(),
                items.get(i).getBonusDestreza(), items.get(i).getBonusInteligencia());
            i++;
        }
    }

    /**
     * Sacar ultimo item.
     */
    public void sacarUltimoItem() {
        int i = items.size() - 1;
        if (i >= 0) {
            sacarBonus(items.get(i).getBonusSalud(), items.get(i).getBonusEnergia(), items.get(i).getBonusFuerza(),
                items.get(i).getBonusDestreza(), items.get(i).getBonusInteligencia());
        }
    }

    /**
     * Poner ultimo item.
     */
    public void ponerUltimoItem() {
        int i = items.size() - 1;
        if (i >= 0) {
            useBonus(items.get(i).getBonusSalud(), items.get(i).getBonusEnergia(), items.get(i).getBonusFuerza(),
                items.get(i).getBonusDestreza(), items.get(i).getBonusInteligencia());
        }
    }

    /**
     * Eliminar items.
     */
    public void eliminarItems() {
        items.removeAll(items);
    }

    /**
     * Actualizar trueque.
     *
     * @param items
     *            the items
     */
    public void actualizarTrueque(final ArrayList<Item> items) {
        this.items.removeAll(this.items);
        for (Item item : items) {
            this.items.add(item);
        }
    }

}
