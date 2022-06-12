package view.emulator;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.util.LinkedList;
import java.util.Queue;

import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.Timer;

import controller.emulator.ClientConnectionMenu;
import controller.emulator.EmulatorTimerChecking;
import controller.emulator.EmulatorTimerClock;
import controller.emulator.EmulatorTimerUpdate;
import model.Checking;
import model.TimerSocket;
import model.Worker;
import view.util.FeedBackLabel;

/**
 * Un type de fenêtre
 * 
 * @author Théo, Amaury et Louis
 * @version 12/06/2022
 */
public class EmulatorWindow extends JFrame{
	
	private JPanel border_container;
	private JPanel input_container;
	
	private JMenuBar menu_bar;
	private JMenu menu_option;
	
	private JComboBox<Worker> dropdown;
	private ButtonInput button_input;
	private SimpleLabel current_time;
	private FeedBackLabel feedback_output;
	
	private Timer timer;
	
	private Queue<Checking> queue;
	
	/**
	 * Construit par défaut un EmulatorWindow puis l'initialise
	 */
	public EmulatorWindow() {
		super();
		
		this.queue = new LinkedList<>();

		this.border_container = new JPanel();
		this.input_container = new JPanel();
		
		this.menu_bar = new JMenuBar();
		this.menu_option = new JMenu("Options");
		
		this.dropdown = new JComboBox<Worker>();
		this.current_time = new SimpleLabel();
		this.feedback_output = new FeedBackLabel();
		this.button_input = new ButtonInput(feedback_output, dropdown, queue);
		
		this.timer = new Timer(1000, null);
		timer.start();
		
		init();
	}
	
	/**
	 * Initialise EmulatorWindow sur son titre, sa taille, sa contenance et ses controllers
	 */
	public void init() {
		setTitle("Emulateur de pointeuse");
		setDefaultCloseOperation(EXIT_ON_CLOSE); 
		setMinimumSize(new Dimension(480, 480));
		
		
		border_container.setLayout(new BorderLayout(50, 50));
		input_container.setLayout(new GridLayout());
		
		border_container.add(input_container, BorderLayout.SOUTH);
		border_container.add(current_time, BorderLayout.CENTER);
		border_container.add(feedback_output, BorderLayout.NORTH);
		
		input_container.add(dropdown);
		input_container.add(button_input);
		
		input_container.setPreferredSize(new Dimension(getPreferredSize().width, 50));
		border_container.setPreferredSize(getPreferredSize());
		
		this.add(border_container);
		
		/** Add timer methods **/
		timer.addActionListener(new EmulatorTimerClock(current_time));
		timer.getActionListeners()[0].actionPerformed(null);
		timer.addActionListener(new EmulatorTimerChecking(queue, feedback_output));
		timer.addActionListener(new EmulatorTimerUpdate(dropdown, feedback_output));
		timer.restart();
		
		menu_option.add(new JMenuItem(new ClientConnectionMenu(
			timer,
			(TimerSocket)timer.getActionListeners()[1],
			(TimerSocket)timer.getActionListeners()[0]
		)));
		menu_bar.add(menu_option);
		setJMenuBar(menu_bar);
	}
}
