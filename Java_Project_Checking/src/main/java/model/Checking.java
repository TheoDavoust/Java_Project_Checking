package model;

import java.io.Serializable;
import java.time.LocalDate;

public class Checking implements Serializable, Comparable<Checking>{
	private Worker worker;
	private RoundedTime time;
	private LocalDate date;
	
	public Checking(Worker worker) {
		this(worker, new RoundedTime());
	}
	
	public Checking(Worker worker, RoundedTime time) {
		this.worker = worker;
		this.time = time;
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
	
	@Override
	public boolean equals(Object o) {
		Checking c = (Checking)o;
		return date.equals(c.date) && time.equals(c.time) && worker.equals(c.worker);
	}

	@Override
	public int compareTo(Checking o) {
		Checking c = (Checking)o;
		return (date.compareTo(o.date) * 100) +
				(time.compareTo(o.time) * 10) + 
				worker.getId().compareTo(o.worker.getId());
	}
}
