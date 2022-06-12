package model;

import java.awt.event.ActionListener;

import view.util.FeedBackLabel;

/**
 * @author Th�o et Amaury
 * @version 12/06/2022
 */
public abstract class TimerSocket implements ActionListener{
	protected SocketClient socket;
	protected FeedBackLabel feedback;
	protected String addr;
	protected int port;
	
	/**
	 * Construit un TimerSocket � partir d'une adresse IP addr, d'un port et d'un FeedBackLabel
	 * 
	 * @param addr une adresse IP donn�e
	 * @param port un port donn�
	 * @param feedback un FeedBackLabel donn�
	 */
	public TimerSocket(String addr, int port, FeedBackLabel feedback) {
		this.addr = addr;
		this.port = port;
		this.feedback = feedback;
	}
	
	/**
	 * Retourne l'adresse IP du TimerSocket
	 * 
	 * @return Le param�tre addr du TimerSocket
	 */
	public String getAddr() {
		return addr;
	}

	/**
	 * Remplace l'adresse IP du TimerSocket par une nouvelle adresse IP donn�e
	 * 
	 * @param addr une adresse IP donn�e
	 */
	public void setAddr(String addr) {
		this.addr = addr;
	}

	/**
	 * Retourne le port du TimerSocket
	 * 
	 * @return Le param�tre port du TimerSocket
	 */
	public int getPort() {
		return port;
	}

	/**
	 * Remplace le port du TimerSocket par un nouveau port donn�
	 * 
	 * @param port un port donn�
	 */
	public void setPort(int port) {
		this.port = port;
	}
}
