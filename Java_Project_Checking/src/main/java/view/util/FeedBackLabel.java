package view.util;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JTextArea;
import javax.swing.Timer;

/**
 * @author Théo, Amaury et Louis
 * @version 12/06/2022
 */
public class FeedBackLabel extends JTextArea{
	private Timer timer;
	
	/**
	 * Construit un FeedBackLabel par défaut et initialise sa police ainsi que timer et son controller
	 */
	public FeedBackLabel() {
		super();
		this.setFont(new Font("Arial", Font.BOLD, 32));
		this.setWrapStyleWord(true);
		this.setLineWrap(true);
		this.setOpaque(false);
		this.setEditable(false);
		this.setFocusable(false);
	    
		this.timer = new Timer(5000, new ActionListener() {	
			@Override
			public void actionPerformed(ActionEvent e) {
				setText("");
			}
		});
		timer.setRepeats(false);
	}
	
	/**
	 * Change le texte de FeedBackLabel par un String donné si il y a un succés 
	 * 
	 * @param str un String donné
	 */
	public synchronized void success(String str) {
		setForeground(new Color(51, 204, 51));
		setText(str);
		startClearTimer();
	}
	
	/**
	 Change le texte de FeedBackLabel par un String donné si il y a une erreur 
	 * 
	 * @param str un String donné
	 */
	public synchronized void error(String str) {
		setForeground(new Color(255, 26, 26));
		setText(str);
		startClearTimer();
	}
	
	/**
	 Change le texte de FeedBackLabel par un String donné pour afficher une information 
	 * 
	 * @param str un String donné
	 */
	public synchronized void info(String str) {
		setForeground(new Color(0, 128, 255));
		setText(str);
		startClearTimer();
	}
	
	/**
	 * Remet à 0 timer
	 */
	public void startClearTimer() {
		timer.restart();
	}
}
