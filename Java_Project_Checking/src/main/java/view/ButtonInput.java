package view;

import java.util.Set;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextField;

import controller.EmulatorButtonChecking;
import model.IdTimeChecking;

public class ButtonInput extends JButton{
	private FeedBackLabel error_label;
	private JTextField text_field;
	private Set<IdTimeChecking> stack;
	
	public ButtonInput(FeedBackLabel error_label, JTextField text_field, Set<IdTimeChecking> stack) {
		super();
		this.error_label = error_label;
		this.text_field = text_field;
		this.stack = stack;
		
		init();
	}
	
	public void init() {		
		this.setText("Submit");
		this.addActionListener(new EmulatorButtonChecking(error_label, text_field, stack));
	}
}
