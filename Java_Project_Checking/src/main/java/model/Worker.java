package model;

import java.io.Serializable;
import java.util.UUID;

public class Worker implements Serializable{
	private UUID id;
	private String name;
	
	public Worker() {
		this(UUID.randomUUID());
	}
	
	public Worker(UUID id) {
		this(id, null);
	}
	
	public Worker(String name) {
		this(UUID.randomUUID(), name);
	}
	
	public Worker(UUID id, String name) {
		this.id = id;
		this.name = name;
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public UUID getId() {
		return id;
	}
	
	public void setId(UUID id) {
		this.id = id;
	}
	
	@Override
	public int hashCode() {
		return id.hashCode() ^ name.hashCode();
	}
	
	@Override
	public String toString() {
		return name;
	}
	
	@Override
	public boolean equals(Object o) {
		Worker w = (Worker)o;
		if(o == null)
			return false;
		return id == w.id && name == w.name;
	}
}
