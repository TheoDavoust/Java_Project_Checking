package model;

import java.io.Serializable;
import java.util.UUID;

/**
 * Repr�sente un employ� d'une entreprise
 * 
 * @author Th�o et Amaury
 * @version 12/06/2022
 */
public class Worker implements Serializable{
	private UUID id;
	private String name;
	
	/**
	 * Construit un worker en appelant un autre constructeur avec comme param�tre un UUID al�atoire
	 */
	public Worker() {
		this(UUID.randomUUID());
	}
	
	/**
	 * Construit un worker � partir d'un UUID donn�
	 * 
	 * @param id un UUID donn�
	 */
	public Worker(UUID id) {
		this(id, null);
	}
	
	/**
	 * Construit un worker en appelant un autre constructeur avec comme param�tre un UUID al�atoire et un nom donn�
	 * 
	 * @param name un nom donn�
	 */
	public Worker(String name) {
		this(UUID.randomUUID(), name);
	}
	
	/**
	 * Construit un worker � partir d'un UUID et d'un nom donn�
	 * 
	 * @param id un UUID donn�
	 * @param name un nom donn�
	 */
	public Worker(UUID id, String name) {
		this.id = id;
		this.name = name;
	}
	
	/**
	 * Retourne le nom de ce Worker
	 * 
	 * @return Le param�tre name du Worker
	 */
	public String getName() {
		return name;
	}

	/**
	 * Remplace le param�tre name du Worker par un nouveau nom
	 * 
	 * @param name un nom donn�
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * Retourne le UUID de ce Worker
	 * 
	 * @return Le param�tre id du Worker
	 */
	public UUID getId() {
		return id;
	}
	
	/**
	 * Remplace le param�tre id du Worker par un nouveau UUID
	 * 
	 * @param id un UUID donn�
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
	 * @return Le param�tre name de Worker
	 */
	@Override
	public String toString() {
		return name;
	}
	
	/**
	 * Retourne un bool�en vrai si les param�tres de l'Object o sont les m�mes que ce Checking
	 * 
	 * @return Un bool�en
	 */
	@Override
	public boolean equals(Object o) {
		Worker w = (Worker)o;
		if(o == null)
			return false;
		return id == w.id && name == w.name;
	}
}
