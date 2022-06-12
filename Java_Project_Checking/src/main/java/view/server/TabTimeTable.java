package view.server;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.time.DayOfWeek;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTable;

import controller.tabtimetable.AddController;
import controller.tabtimetable.WorkerSelector;
import model.Storage;
import model.Worker;
import view.util.FeedBackLabel;

public class TabTimeTable extends JPanel {

	private Storage storage;
	private FeedBackLabel feedback;
	
	private JComboBox<Worker> workers_box;
	private JTable table;
	
	private JPanel center_container;
	private JPanel bottom_container;
	
	private List<JLabel> times;
	private List<JButton> buttons;

	public TabTimeTable(Storage storage, FeedBackLabel feedback) {
		super();
		setLayout(new BorderLayout());

		this.storage = storage;
		this.feedback = feedback;
		
		this.times = new ArrayList<>();
		this.buttons = new ArrayList<>();
		this.workers_box = new JComboBox<Worker>(storage.getWorkers());
		
		this.center_container = new JPanel(new GridLayout(5, 3));
		this.bottom_container = new JPanel();
		
		init();
	}

	public void init() {
		
		
		for(int i = 0; i < 5; i++) {
			center_container.add(new JLabel(DayOfWeek.of(i + 1).name()));
			
			times.add(new JLabel(""));
			center_container.add(times.get(i));
			
			buttons.add(new JButton("Modifier"));
			buttons.get(i).setAction(new AddController(workers_box, DayOfWeek.of(i + 1), storage));
			center_container.add(buttons.get(i));
		}
		
		workers_box.addActionListener(new WorkerSelector(times, workers_box, storage));
		workers_box.getActionListeners()[0].actionPerformed(null);
		
		add(workers_box, BorderLayout.NORTH);
		add(center_container, BorderLayout.CENTER);
	}
}
