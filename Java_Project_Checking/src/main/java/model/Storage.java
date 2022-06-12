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

/**
 * Stocke la liste des Worker, des Checking et des TimeTable
 * 
 * @author Th�o et Amaury
 * @version 12/06/2022
 */
public class Storage {
	private Vector<Checking> checkings;
	private Vector<Worker> workers;
	private Vector<TimeTable> time_table;

	private static final String filename = "." + File.separator + "src" + File.separator + "main" + File.separator
			+ "resources" + File.separator + "storage.dat";

	/**
	 * Construit un Storage
	 */
	public Storage() {
		super();
		checkings = new Vector<Checking>();
		workers = new Vector<Worker>();
		time_table = new Vector<TimeTable>();
	}

	/**
	 * Retourne la liste de Checking du Storage
	 * 
	 * @return Le param�tre checkings du Storage
	 */
	public Vector<Checking> getCheckings() {
		return checkings;
	}

	/**
	 * Remplace la liste de Checking du Storage par une nouvelle liste de Checking donn�e
	 * 
	 * @param checkings une liste de Checking donn�e
	 */
	public void setCheckings(Vector<Checking> checkings) {
		this.checkings = checkings;
	}

	/**
	 * Retourne la liste de Worker du Storage
	 * 
	 * @return Le param�tre workers du Storage
	 */
	public Vector<Worker> getWorkers() {
		return workers;
	}

	/**
	 * Remplace la liste de Worker du Storage par une nouvelle liste de Worker donn�e
	 * 
	 * @param workers une liste de Worker donn�e
	 */
	public void setWorkers(Vector<Worker> workers) {
		this.workers = workers;
	}

	/**
	 * Retourne la liste de TimeTable du Storage
	 * 
	 * @return Le param�tre time_table du Storage
	 */
	public Vector<TimeTable> getTime_table() {
		return time_table;
	}

	/**
	 * Remplace la liste de TimeTable du Storage par une nouvelle liste de TimeTable donn�e
	 * 
	 * @param time_table une liste de TimeTable donn�e
	 */
	public void setTime_table(Vector<TimeTable> time_table) {
		this.time_table = time_table;
	}

	/**
	 * 
	 */
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

	/**
	 * @throws Exception Classe n'existe pas ou connection introuvable
	 */
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

	/**
	 * Retourne un String poss�dant les composantes de Storage
	 * 
	 * @return un String
	 */
	@Override
	public String toString() {
		return String.format("Storage :\n|%s\n|%s", checkings, workers);
	}
}
