package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

import javax.swing.JLabel;

public class EmulatorTimerClock implements ActionListener{

	private JLabel label;
	private final DateTimeFormatter format;
	
	public EmulatorTimerClock(JLabel label) {
		this.format = DateTimeFormatter.ofPattern("HH:mm:ss");
		this.label = label;
	}
	
	@Override
	public void actionPerformed(ActionEvent e){
		this.label.setText(LocalTime.now().format(format));
	}
}