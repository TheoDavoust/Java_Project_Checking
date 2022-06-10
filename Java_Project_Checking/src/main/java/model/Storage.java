package model;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;

public class Storage {
	private List<Checking> checkings;
	private List<Worker> workers;
	private List<TimeTable> time_table;
	
	private static final String filename = "./src/main/resources/storage.dat";
	
	public Storage() {
		super();
		checkings = new ArrayList<Checking>();
		workers = new ArrayList<Worker>();
		time_table = new ArrayList<TimeTable>();
	}
	
	public List<Checking> getCheckings() {
		return checkings;
	}

	public void setCheckings(List<Checking> checkings) {
		this.checkings = checkings;
	}

	public List<Worker> getWorkers() {
		return workers;
	}

	public void setWorkers(List<Worker> workers) {
		this.workers = workers;
	}

	public List<TimeTable> getTime_table() {
		return time_table;
	}

	public void setTime_table(List<TimeTable> time_table) {
		this.time_table = time_table;
	}

	public void save() {
		try(FileOutputStream file = new FileOutputStream(filename);
				ObjectOutputStream outs = new ObjectOutputStream(file)){
			outs.writeObject(checkings);
			outs.writeObject(workers);
		}catch(IOException e) {
			e.printStackTrace();
		}
	}
	
	public void load() throws Exception {
		try(FileInputStream file = new FileInputStream(filename);
				ObjectInputStream ins = new ObjectInputStream(file)){
			checkings = (List<Checking>)ins.readObject();
			workers = (List<Worker>)ins.readObject();
			
		}catch(IOException | ClassNotFoundException e) {
			throw e;
		}
	}
	
	@Override
	public String toString() {
		return String.format("Storage :\n|%s\n|%s", checkings, workers);
	}
}
