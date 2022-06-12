package model;

import java.awt.event.ActionListener;

import view.util.FeedBackLabel;

/**
 * @author Théo et Amaury
 * @version 12/06/2022
 */
public abstract class TimerSocket implements ActionListener{
	protected SocketClient socket;
	protected FeedBackLabel feedback;
	protected String addr;
	protected int port;
	
	/**
	 * Construit un TimerSocket à partir d'une adresse IP addr, d'un port et d'un FeedBackLabel
	 * 
	 * @param addr une adresse IP donnée
	 * @param port un port donné
	 * @param feedback un FeedBackLabel donné
	 */
	public TimerSocket(String addr, int port, FeedBackLabel feedback) {
		this.addr = addr;
		this.port = port;
		this.feedback = feedback;
	}
	
	/**
	 * Retourne l'adresse IP du TimerSocket
	 * 
	 * @return Le paramètre addr du TimerSocket
	 */
	public String getAddr() {
		return addr;
	}

	/**
	 * Remplace l'adresse IP du TimerSocket par une nouvelle adresse IP donnée
	 * 
	 * @param addr une adresse IP donnée
	 */
	public void setAddr(String addr) {
		this.addr = addr;
	}

	/**
	 * Retourne le port du TimerSocket
	 * 
	 * @return Le paramètre port du TimerSocket
	 */
	public int getPort() {
		return port;
	}

	/**
	 * Remplace le port du TimerSocket par un nouveau port donné
	 * 
	 * @param port un port donné
	 */
	public void setPort(int port) {
		this.port = port;
	}
}
