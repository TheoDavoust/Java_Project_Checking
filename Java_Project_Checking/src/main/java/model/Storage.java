package model;

import java.util.ArrayList;
import java.util.List;

public class Storage {
	private List<Checking> checkings;
	private List<Worker> workers;
	
	public Storage() {
		checkings = new ArrayList<Checking>();
		workers = new ArrayList<Worker>();
	}
}
