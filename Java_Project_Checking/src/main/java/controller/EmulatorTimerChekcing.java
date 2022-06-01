package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.JLabel;
import javax.swing.JTextField;

public class EmulatorTimerChekcing implements ActionListener{

	private JTextField field;
	private JLabel error_text;
	
	public EmulatorTimerChekcing(JTextField field, JLabel error_text){
		super();
		this.field = field;
		this.error_text = error_text;
	}
	
	public void error(String str) throws IOException{
		error_text.setText(str);
		throw new IOException(str);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		
	}
}
