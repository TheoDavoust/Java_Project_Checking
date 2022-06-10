package view;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.util.UUID;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;

import model.Storage;
import model.Worker;

public class MainWindow extends JFrame{
	private JPanel border_container;
	private TabWorker tab_worker;
	
	private FeedBackLabel feedback;
	private JTabbedPane onglet;
	
	private Storage storage;
	
	public MainWindow() {
		super();
		
		this.storage = new Storage();
		
		this.border_container = new JPanel();
		this.feedback = new FeedBackLabel();
		this.onglet = new JTabbedPane();
		
		this.storage.getWorkers().add(new Worker(UUID.randomUUID(), "Jean Bon"));
		this.storage.getWorkers().add(new Worker(UUID.randomUUID(), "Alex Ception"));
		this.storage.getWorkers().add(new Worker(UUID.randomUUID(), "Théodore An"));
		
		init();
	}
	
	public void init() {
		setTitle("Fénêtre principale");
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setMinimumSize(new Dimension(480, 480));
		
		border_container.setLayout(new BorderLayout(50, 50));
		border_container.add(feedback, BorderLayout.NORTH);
		border_container.add(onglet, BorderLayout.CENTER);
		
		onglet.add("Employés", new TabWorker(storage));
		onglet.add("Planning", new TabTimeTable());
		onglet.add("Historique des checks", new TabCheckingHistory(storage));
		
		add(border_container);
	}
}
