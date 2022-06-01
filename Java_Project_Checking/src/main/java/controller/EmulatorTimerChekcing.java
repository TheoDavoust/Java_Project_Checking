package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JTextField;

import view.FeedBackLabel;

public class EmulatorTimerChekcing implements ActionListener{

	private JTextField field;
	private FeedBackLabel error_text;
	
	public EmulatorTimerChekcing(JTextField field, FeedBackLabel error_text){
		super();
		this.field = field;
		this.error_text = error_text;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		
	}
}
