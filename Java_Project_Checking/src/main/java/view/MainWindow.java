package view;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JFrame;
import javax.swing.JTabbedPane;
import javax.swing.Timer;

import controller.ServerThreadChecking;
import controller.ServerThreadUpdate;
import model.Storage;

public class MainWindow extends JFrame{
	
	private FeedBackLabel feedback;
	private JTabbedPane onglet;
	
	private Storage storage;
	
	public MainWindow() {
		super();
		
		this.storage = new Storage();
		
		this.feedback = new FeedBackLabel();
		this.onglet = new JTabbedPane();
		
		/* Setting storage file */
		try {			
			this.storage.load();
		}catch(Exception e) {
			feedback.error(e.getMessage());
		}
		
		new Timer(15000, new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				storage.save();
			}
		}).start();
		
		/* Starting Socket Threads */
		new Thread(new ServerThreadUpdate(feedback, storage)).start();
		new Thread(new ServerThreadChecking(feedback, storage)).start();
		
		init();
	}
	
	public void init() {
		setTitle("Fénêtre principale");
		setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				storage.save();
				setDefaultCloseOperation(EXIT_ON_CLOSE);
			}
		});
		setMinimumSize(new Dimension(480, 480));
		
		getContentPane().add(feedback, BorderLayout.NORTH);
		getContentPane().add(onglet, BorderLayout.CENTER);
		
		onglet.add("Employés", new TabWorker(storage));
		onglet.add("Planning", new TabTimeTable());
	}
}
