package view;

import java.awt.Font;
import java.util.Collection;

import javax.swing.JButton;
import javax.swing.JTextField;

import controller.EmulatorButtonChecking;
import model.Checking;

public class ButtonInput extends JButton{
	private FeedBackLabel error_label;
	private JTextField text_field;
	private Collection<Checking> queue;
	
	public ButtonInput(FeedBackLabel error_label, JTextField text_field, Collection<Checking> queue) {
		super();
		this.error_label = error_label;
		this.text_field = text_field;
		this.queue = queue;
		
		init();
	}
	
	public void init() {
		this.setFont(new Font("Arial", Font.PLAIN, 32));
		this.setText("Valider");
		this.addActionListener(new EmulatorButtonChecking(error_label, text_field, queue));
	}
}
