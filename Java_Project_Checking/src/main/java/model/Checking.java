package model;

import java.io.Serializable;
import java.time.LocalDate;

/**
 * Repr�sente un pointage d'un Worker
 * 
 * @author Th�o et Amaury
 * @version 12/06/2022
 */
public class Checking implements Serializable, Comparable<Checking>{
	private Worker worker;
	private RoundedTime time;
	private LocalDate date;
	
	/**
	 * Construit un Checking � partir d'un worker et de l'heure r�el approxim�
	 * 
	 * @param worker un Worker donn�
	 */
	public Checking(Worker worker) {
		this(worker, new RoundedTime());
	}
	
	/**
	 * Construit un Checking � partir d'un worker et d'une heure donn�e
	 * 
	 * @param worker un Worker donn�
	 * @param time un RoundedTime donn�
	 */
	public Checking(Worker worker, RoundedTime time) {
		this.worker = worker;
		this.time = time;
		this.date = LocalDate.now();
	}

	/**
	 * Retourne le worker � qui appartient ce Checking
	 * 
	 * @return Le param�tre worker du Checking
	 */
	public Worker getWorker() {
		return worker;
	}

	/**
	 * Remplace le param�tre worker du Checking par un nouveau Worker
	 * 
	 * @param worker un Worker donn�
	 */
	public void setWorker(Worker worker) {
		this.worker = worker;
	}

	/**
	 * Retourne l'heure � laquelle ce Checking a �t� cr��
	 * 
	 * @return Le param�tre time du Checking
	 */
	public RoundedTime getTime() {
		return time;
	}

	/**
	 * Remplace le param�tre time du Checking par un nouveau RoundedTime
	 * 
	 * @param time une heure approxim�e donn�e
	 */
	public void setTime(RoundedTime time) {
		this.time = time;
	}

	/**
	 * Retourne la date � laquelle ce Checking a �t� cr��
	 * 
	 * @return Le param�tre date du Checking
	 */
	public LocalDate getDate() {
		return date;
	}

	/**
	 * Remplace le param�tre date du Checking par un nouveau LocalDate
	 * 
	 * @param date une date donn�e
	 */
	public void setDate(LocalDate date) {
		this.date = date;
	}
	
	/**
	 * Retourne un bool�en vrai si les param�tres de l'Object o sont les m�mes que ce Checking
	 * 
	 * @return Un bool�en
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
