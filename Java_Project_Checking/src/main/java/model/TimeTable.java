package model;

import java.io.Serializable;
import java.time.DayOfWeek;
import java.util.HashMap;
import java.util.Map;

/**
 * Représente un emploi du temps d'un Worker
 * 
 * @author Théo et Amaury
 * @version 12/06/2022
 */
public class TimeTable implements Serializable{
	private Worker worker;
	private Map<DayOfWeek, RoundedTime[]> schedule;
	
	/**
	 * Construit l'emploi du temps d'un worker à partir d'un DayOfWeek et d'un RoundedTime
	 * 
	 * @param worker un Worker donné
	 */
	public TimeTable(Worker worker) {
		super();
		schedule = new HashMap<DayOfWeek, RoundedTime[]>();
		this.worker = worker;
	}

	/**
	 * Retourne l'emploi du temps du TimeTable
	 * 
	 * @return Le paramètre schedule du TimeTable
	 */
	public Map<DayOfWeek, RoundedTime[]> getSchedule() {
		return schedule;
	}

	/**
	 * Remplace l'emploi du temps du TimeTable par un nouvel emploi du temps
	 * @param schedule un emploi du temps donné
	 */
	public void setSchedule(Map<DayOfWeek, RoundedTime[]> schedule) {
		this.schedule = schedule;
	}

	/**
	 * Retourne le Worker à qui appartient ce TimeTable
	 * 
	 * @return le paramètre worker du TimeTable
	 */
	public Worker getWorker() {
		return worker;
	}

	/**
	 * Remplace le Worker du TimeTable par un nouveau worker
	 * 
	 * @param worker un Worker donné
	 */
	public void setWorker(Worker worker) {
		this.worker = worker;
	}
}