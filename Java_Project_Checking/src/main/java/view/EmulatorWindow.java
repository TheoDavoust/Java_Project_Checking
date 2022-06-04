package view;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.util.LinkedList;
import java.util.Queue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.Timer;

import controller.EmulatorTimerChekcing;
import controller.EmulatorTimerClock;
import model.Checking;

public class EmulatorWindow extends JFrame{
	private JPanel border_container;
	private JPanel input_container;
	
	private TextInput text_input;
	private ButtonInput button_input;
	private SimpleLabel current_time;
	private FeedBackLabel feedback_output;
	
	private Timer timer;
	
	private Queue<Checking> queue;
	
	public EmulatorWindow() {
		super();
		
		this.queue = new LinkedList<>();

		this.border_container = new JPanel();
		this.input_container = new JPanel();
		
		this.text_input = new TextInput();
		this.current_time = new SimpleLabel();
		this.feedback_output = new FeedBackLabel();
		this.button_input = new ButtonInput(feedback_output, text_input, queue);
		
		this.timer = new Timer(1000, null);
		timer.start();
		
		init();
	}
	
	public void init() {
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setMinimumSize(new Dimension(480, 480));
		
		border_container.setLayout(new BorderLayout(50, 50));
		input_container.setLayout(new GridLayout());
		
		border_container.add(input_container, BorderLayout.SOUTH);
		border_container.add(current_time, BorderLayout.CENTER);
		border_container.add(feedback_output, BorderLayout.NORTH);
		
		input_container.add(text_input);
		input_container.add(button_input);
		
		input_container.setPreferredSize(new Dimension(getPreferredSize().width, 50));
		border_container.setPreferredSize(getPreferredSize());
		
		this.add(border_container);
		
		/** Add timer methods **/
		timer.addActionListener(new EmulatorTimerClock(current_time));
		timer.getActionListeners()[0].actionPerformed(null);
		timer.addActionListener(new EmulatorTimerChekcing(text_input, feedback_output, queue));
		
		timer.restart();
	}
}
