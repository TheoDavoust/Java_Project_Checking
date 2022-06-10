package view;

import java.awt.Font;
import java.util.Collection;

import javax.swing.JButton;
import javax.swing.JComboBox;

import controller.EmulatorButtonChecking;
import model.Checking;
import model.Worker;

public class ButtonInput extends JButton{
	private FeedBackLabel error_label;
	private JComboBox<Worker> dropdown;
	private Collection<Checking> queue;
	
	public ButtonInput(FeedBackLabel error_label, JComboBox<Worker> text_field, Collection<Checking> queue) {
		super();
		this.error_label = error_label;
		this.dropdown = text_field;
		this.queue = queue;
		
		init();
	}
	
	public void init() {
		this.setFont(new Font("Arial", Font.PLAIN, 32));
		this.setText("Valider");
		this.addActionListener(new EmulatorButtonChecking(error_label, dropdown, queue));
	}
}
