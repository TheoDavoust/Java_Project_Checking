package model;

import java.io.Serializable;

public class Worker implements Serializable{
	private int id;
	private String name;
	
	public Worker(int id, String name) {
		this.id = id;
		this.name = name;
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
}
