package model;

import java.io.Serializable;
import java.time.LocalDate;

/**
 * Représente un pointage d'un Worker
 * 
 * @author Théo et Amaury
 * @version 12/06/2022
 */
public class Checking implements Serializable, Comparable<Checking>{
	private Worker worker;
	private RoundedTime time;
	private LocalDate date;
	
	/**
	 * Construit un Checking à partir d'un worker et de l'heure réel approximé
	 * 
	 * @param worker un Worker donné
	 */
	public Checking(Worker worker) {
		this(worker, new RoundedTime());
	}
	
	/**
	 * Construit un Checking à partir d'un worker et d'une heure donnée
	 * 
	 * @param worker un Worker donné
	 * @param time un RoundedTime donné
	 */
	public Checking(Worker worker, RoundedTime time) {
		this.worker = worker;
		this.time = time;
		this.date = LocalDate.now();
	}

	/**
	 * Retourne le worker à qui appartient ce Checking
	 * 
	 * @return Le paramètre worker du Checking
	 */
	public Worker getWorker() {
		return worker;
	}

	/**
	 * Remplace le paramètre worker du Checking par un nouveau Worker
	 * 
	 * @param worker un Worker donné
	 */
	public void setWorker(Worker worker) {
		this.worker = worker;
	}

	/**
	 * Retourne l'heure à laquelle ce Checking a été créé
	 * 
	 * @return Le paramètre time du Checking
	 */
	public RoundedTime getTime() {
		return time;
	}

	/**
	 * Remplace le paramètre time du Checking par un nouveau RoundedTime
	 * 
	 * @param time une heure approximée donnée
	 */
	public void setTime(RoundedTime time) {
		this.time = time;
	}

	/**
	 * Retourne la date à laquelle ce Checking a été créé
	 * 
	 * @return Le paramètre date du Checking
	 */
	public LocalDate getDate() {
		return date;
	}

	/**
	 * Remplace le paramètre date du Checking par un nouveau LocalDate
	 * 
	 * @param date une date donnée
	 */
	public void setDate(LocalDate date) {
		this.date = date;
	}
	
	/**
	 * Retourne un booléen vrai si les paramètres de l'Object o sont les mêmes que ce Checking
	 * 
	 * @return Un booléen
	 */
	@Override
	public boolean equals(Object o) {
		Checking c = (Checking)o;
		return date.equals(c.date) && time.equals(c.time) && worker.equals(c.worker);
	}

	/**
	 * Permet de comparer deux Checking
	 */
	@Override
	public int compareTo(Checking o) {
		Checking c = (Checking)o;
		return (date.compareTo(o.date) * 100) +
				(time.compareTo(o.time) * 10) + 
				worker.getId().compareTo(o.worker.getId());
	}
}
