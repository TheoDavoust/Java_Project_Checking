package model;

import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.ObjectStreamException;
import java.io.Serializable;
import java.io.ObjectInputStream.GetField;

public class Checking implements Serializable{
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
