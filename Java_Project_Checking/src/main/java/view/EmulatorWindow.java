package view;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.Insets;
import java.util.Set;
import java.util.TreeSet;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.Timer;
import javax.swing.border.Border;

import controller.EmulatorTimerChekcing;
import controller.EmulatorTimerClock;
import model.IdTimeChecking;

public class EmulatorWindow extends JFrame{
	private JPanel border_container;
	private JPanel input_container;
	
	private TextInput text_input;
	private ButtonInput button_input;
	private SimpleLabel current_time;
	private FeedBackLabel error_output;
	
	private Timer timer;
	
	private Set<IdTimeChecking> stack;
	
	public EmulatorWindow() {
		super();
		
		this.stack = new TreeSet<>();

		this.border_container = new JPanel();
		this.input_container = new JPanel();
		
		this.text_input = new TextInput();
		this.current_time = new SimpleLabel();
		this.error_output = new FeedBackLabel();
		this.button_input = new ButtonInput(error_output, text_input, stack);
		
		this.timer = new Timer(1000, null);
		timer.start();
		
		init();
	}
	
	public void init() {
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setMinimumSize(new Dimension(480, 480));
		
		border_container.setLayout(new BorderLayout(10, 10));
		input_container.setLayout(new GridLayout());
		
		border_container.add(input_container, BorderLayout.SOUTH);
		border_container.add(current_time, BorderLayout.CENTER);
		border_container.add(error_output, BorderLayout.NORTH);
		
		input_container.add(text_input);
		input_container.add(button_input);
		
		input_container.setPreferredSize(new Dimension(getPreferredSize().width, 50));
		border_container.setPreferredSize(getPreferredSize());
		
		this.add(border_container);
		
		/** Add timer methods **/
		timer.addActionListener(new EmulatorTimerClock(current_time));
		timer.getActionListeners()[0].actionPerformed(null);
		timer.addActionListener(new EmulatorTimerChekcing(text_input, error_output));
		
		timer.restart();
	}
}
