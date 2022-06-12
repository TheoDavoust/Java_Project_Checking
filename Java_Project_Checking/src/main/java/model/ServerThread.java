package model;

import java.io.IOException;

import view.util.FeedBackLabel;

/**
 * @author Théo et Amaury
 * @version 12/06/2022
 */
public abstract class ServerThread extends Thread{
	protected FeedBackLabel feedback;
	protected Storage storage;
	protected int port;
	protected SocketServer server;
	
	/**
	 * Construit un ServerThread à partir d'un FeedBackLabel, d'un Storage et d'un port
	 * 
	 * @param feedback  un FeedBackLabel donné
	 * @param storage un Storage donné
	 * @param port un port donné
	 */
	public ServerThread(FeedBackLabel feedback, Storage storage, int port) {
		this.feedback = feedback;
		this.storage = storage;
		this.port = port;
	}
	
	/**
	 * Retourne le port du ServerThread
	 * 
	 * @return Le paramètre port du ServerThread
	 */
	public int getPort() {
		return port;
	}

	/**
	 * Remplace le port du ServerThread par un nouveau port donné
	 * 
	 * @param port un port donné
	 */
	public void setPort(int port) {
		this.port = port;
	}

	/**
	 * Retourne le FeedBackLabel du ServerThread
	 * 
	 * @return Le paramètre feedback du ServerThread
	 */
	public FeedBackLabel getFeedback() {
		return feedback;
	}

	/**
	 * Remplace le FeedBackLabel du ServerThread par un nouveau FeedBackLabel
	 * 
	 * @param feedback un FeedBackLabel donné
	 */
	public void setFeedback(FeedBackLabel feedback) {
		this.feedback = feedback;
	}

	/**
	 * Retourne le Storage du ServerThread
	 * 
	 * @return Le paramètre storage du ServerThread
	 */
	public Storage getStorage() {
		return storage;
	}

	/**
	 * Remplace le Storage du ServerThread par un nouveau Storage
	 * 
	 * @param storage un Storage donné
	 */
	public void setStorage(Storage storage) {
		this.storage = storage;
	}

	/**
	 *
	 */
	@Override
	public void interrupt() {
		try {
			server.close();
			server = null;
		}catch(IOException e) {
			e.printStackTrace();
		}finally {
			super.interrupt();
		}
	}
}
