package model;

import java.io.Serializable;
import java.util.UUID;

/**
 * Représente un employé d'une entreprise
 * 
 * @author Théo et Amaury
 * @version 12/06/2022
 */
public class Worker implements Serializable{
	private UUID id;
	private String name;
	
	/**
	 * Construit un worker en appelant un autre constructeur avec comme paramètre un UUID aléatoire
	 */
	public Worker() {
		this(UUID.randomUUID());
	}
	
	/**
	 * Construit un worker à partir d'un UUID donné
	 * 
	 * @param id un UUID donné
	 */
	public Worker(UUID id) {
		this(id, null);
	}
	
	/**
	 * Construit un worker en appelant un autre constructeur avec comme paramètre un UUID aléatoire et un nom donné
	 * 
	 * @param name un nom donné
	 */
	public Worker(String name) {
		this(UUID.randomUUID(), name);
	}
	
	/**
	 * Construit un worker à partir d'un UUID et d'un nom donné
	 * 
	 * @param id un UUID donné
	 * @param name un nom donné
	 */
	public Worker(UUID id, String name) {
		this.id = id;
		this.name = name;
	}
	
	/**
	 * Retourne le nom de ce Worker
	 * 
	 * @return Le paramètre name du Worker
	 */
	public String getName() {
		return name;
	}

	/**
	 * Remplace le paramètre name du Worker par un nouveau nom
	 * 
	 * @param name un nom donné
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * Retourne le UUID de ce Worker
	 * 
	 * @return Le paramètre id du Worker
	 */
	public UUID getId() {
		return id;
	}
	
	/**
	 * Remplace le paramètre id du Worker par un nouveau UUID
	 * 
	 * @param id un UUID donné
	 */
	public void setId(UUID id) {
		this.id = id;
	}
	
	/**
	 * Retourne le hashCode du Worker
	 * 
	 * @return Le hashCode du Worker
	 */
	@Override
	public int hashCode() {
		return id.hashCode() ^ name.hashCode();
	}
	
	/**
	 * Retourne le nom du Worker
	 * 
	 * @return Le paramètre name de Worker
	 */
	@Override
	public String toString() {
		return name;
	}
	
	/**
	 * Retourne un booléen vrai si les paramètres de l'Object o sont les mêmes que ce Checking
	 * 
	 * @return Un booléen
	 */
	@Override
	public boolean equals(Object o) {
		Worker w = (Worker)o;
		if(o == null)
			return false;
		return id == w.id && name == w.name;
	}
}
