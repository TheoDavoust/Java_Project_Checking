package model;

import java.io.Serializable;

public class Checking implements Serializable{
	private Worker worker;
	private RoundedTime time;
	
	// Seul constructeur necessaire pour la creation d'un checking qui va etre traite plus tard par l'appli
	public Checking(Worker worker) {
		time = new RoundedTime();
		this.worker = worker;
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
}
