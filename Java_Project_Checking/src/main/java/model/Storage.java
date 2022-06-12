package model;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

public class Storage {
	private Vector<Checking> checkings;
	private Vector<Worker> workers;
	private Vector<TimeTable> time_table;

	private static final String filename = "." + File.separator + "src" + File.separator + "main" + File.separator
			+ "resources" + File.separator + "storage.dat";

	public Storage() {
		super();
		checkings = new Vector<Checking>();
		workers = new Vector<Worker>();
		time_table = new Vector<TimeTable>();
	}

	public List<Checking> getCheckings() {
		return checkings;
	}

	public void setCheckings(Vector<Checking> checkings) {
		this.checkings = checkings;
	}

	public Vector<Worker> getWorkers() {
		return workers;
	}

	public void setWorkers(Vector<Worker> workers) {
		this.workers = workers;
	}

	public Vector<TimeTable> getTime_table() {
		return time_table;
	}

	public void setTime_table(Vector<TimeTable> time_table) {
		this.time_table = time_table;
	}

	public void save() {
		try (FileOutputStream file = new FileOutputStream(filename);
				ObjectOutputStream outs = new ObjectOutputStream(file)) {
			outs.writeObject(checkings);
			outs.writeObject(workers);
			outs.writeObject(time_table);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void load() throws Exception {
		try (FileInputStream file = new FileInputStream(filename);
				ObjectInputStream ins = new ObjectInputStream(file)) {
			checkings = (Vector<Checking>) ins.readObject();
			workers = (Vector<Worker>) ins.readObject();
			time_table = (Vector<TimeTable>) ins.readObject();
		} catch (IOException | ClassNotFoundException e) {
			throw e;
		}
	}

	@Override
	public String toString() {
		return String.format("Storage :\n|%s\n|%s", checkings, workers);
	}
}
