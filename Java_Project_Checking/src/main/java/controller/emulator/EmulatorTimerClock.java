package controller.emulator;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

import javax.swing.JLabel;

/**
 * @author Théo et Amaury
 * @version 12/06/2022
 */
public class EmulatorTimerClock implements ActionListener{

	private JLabel label;
	private final DateTimeFormatter format;
	
	/**
	 * Construit un EmulatorTimerClock à partir d'un JLabel
	 * @param label un JLabel donné
	 */
	public EmulatorTimerClock(JLabel label) {
		this.format = DateTimeFormatter.ofPattern("HH:mm:ss");
		this.label = label;
	}
	
	/**
	 * Fait apparaitre l'heure réel
	 */
	@Override
	public void actionPerformed(ActionEvent e){
		this.label.setText(LocalTime.now().format(format));
	}
}