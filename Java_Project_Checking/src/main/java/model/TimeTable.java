package model;

import java.io.Serializable;
import java.time.DayOfWeek;
import java.util.HashMap;
import java.util.Map;

/**
 * Repr�sente un emploi du temps d'un Worker
 * 
 * @author Th�o et Amaury
 * @version 12/06/2022
 */
public class TimeTable implements Serializable{
	private Worker worker;
	private Map<DayOfWeek, RoundedTime[]> schedule;
	
	/**
	 * Construit l'emploi du temps d'un worker � partir d'un DayOfWeek et d'un RoundedTime
	 * 
	 * @param worker un Worker donn�
	 */
	public TimeTable(Worker worker) {
		super();
		this.schedule = new HashMap<DayOfWeek, RoundedTime[]>();
		this.worker = worker;
		for(int i = 1; i < 6; i++) {
			this.schedule.put(DayOfWeek.of(i), new RoundedTime[2]);
		}
	}

	/**
	 * Retourne l'emploi du temps du TimeTable
	 * 
	 * @return Le param�tre schedule du TimeTable
	 */
	public Map<DayOfWeek, RoundedTime[]> getSchedule() {
		return schedule;
	}

	/**
	 * Remplace l'emploi du temps du TimeTable par un nouvel emploi du temps
	 * @param schedule un emploi du temps donn�
	 */
	public void setSchedule(Map<DayOfWeek, RoundedTime[]> schedule) {
		this.schedule = schedule;
	}

	/**
	 * Retourne le Worker � qui appartient ce TimeTable
	 * 
	 * @return le param�tre worker du TimeTable
	 */
	public Worker getWorker() {
		return worker;
	}

	/**
	 * Remplace le Worker du TimeTable par un nouveau worker
	 * 
	 * @param worker un Worker donn�
	 */
	public void setWorker(Worker worker) {
		this.worker = worker;
	}
}