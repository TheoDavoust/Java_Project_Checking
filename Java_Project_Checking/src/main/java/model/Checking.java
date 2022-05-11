package model;

public class Checking {
	private Worker worker;
	private RoundedTime time;
	
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
