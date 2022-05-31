package view;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SpringLayout;

public class EmulatorWindow extends JFrame{
	private JPanel border_container;
	private JPanel input_container;
	
	private TextInput text_input;
	private ButtonInput button_input;
	
	public EmulatorWindow() {
		super();
		this.border_container = new JPanel();
		this.input_container = new JPanel();
		
		this.text_input = new TextInput();
		this.button_input = new ButtonInput();
		
		init();
	}
	
	public void init() {
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setMinimumSize(new Dimension(480, 480));
		
		border_container.setLayout(new BorderLayout());
		input_container.setLayout(new GridLayout());
		
		border_container.add(input_container, BorderLayout.SOUTH);
		input_container.add(this.text_input);
		input_container.add(this.button_input);
		
		input_container.setPreferredSize(new Dimension(getPreferredSize().width, 50));
		border_container.setPreferredSize(getPreferredSize());
		
		this.add(border_container);
	}
}
