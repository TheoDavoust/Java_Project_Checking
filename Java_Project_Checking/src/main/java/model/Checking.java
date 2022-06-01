package model;

import java.io.Serializable;
import java.time.LocalDate;

public class Checking implements Serializable{
	private Worker worker;
	private RoundedTime time;
	private LocalDate date;
	
	// Seul constructeur necessaire pour la creation d'un checking qui va etre traite plus tard par l'appli
	public Checking(Worker worker) {
		time = new RoundedTime();
		this.worker = worker;
		this.date = LocalDate.now();
	}

	public Worker getWorker() {
		return worker;
	}

	public void setWorker(Worker worker) {
		this.worker = worker;
	}

	public RoundedTime getTime() {
		return time;
	}

	public void setTime(RoundedTime time) {
		this.time = time;
	}

	public LocalDate getDate() {
		return date;
	}

	public void setDate(LocalDate date) {
		this.date = date;
	}
}
