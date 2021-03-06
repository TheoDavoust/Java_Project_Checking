package view.server;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JTabbedPane;
import javax.swing.Timer;

import controller.server.ServerConnectionMenu;
import controller.server.ServerThreadChecking;
import controller.server.ServerThreadUpdate;
import model.Storage;
import view.util.FeedBackLabel;

/**
 * Représente la fenêtre principale du server
 * 
 * @author Théo, Amaury et Louis
 * @version 12/06/2022
 */
public class MainWindow extends JFrame{
	
	private FeedBackLabel feedback;
	private JTabbedPane onglet;
	
	private Storage storage;
	private JMenuBar menu_bar;
	private JMenu menu_options;
	
	private ServerThreadChecking thread_checking;
	private ServerThreadUpdate thread_update;
	
	/**
	 * Construit une MainWindow par défaut puis l'initialise
	 */
	public MainWindow() {
		super();
		
		this.storage = new Storage();
		
		this.feedback = new FeedBackLabel();
		this.onglet = new JTabbedPane();
		
		/* Creating the menu bar */
		this.menu_bar = new JMenuBar();
		this.menu_options = new JMenu("Options");
		
		/* Setting storage file */
		try {			
			this.storage.load();
		}catch(Exception e) {
			feedback.error(e.getMessage());
		}
	
		/* Creating Socket Threads */
		this.thread_checking = new ServerThreadChecking(feedback, storage, 8090);
		this.thread_update = new ServerThreadUpdate(feedback, storage, 8081);
		
		init();
	}
	
	/**
	 * Initialise MainWindow sur son titre, sa taille, sa contenance et ses controllers
	 */
	public void init() {
		/* Init Window */
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

		/* Timer Save Storage File */
		new Timer(15000, new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				storage.save();
			}
		}).start();
		
		/* Init Threads */
		thread_checking.start();
		thread_update.start();
		
		/* Init MenuBar */
		menu_options.add(new JMenuItem(new ServerConnectionMenu(thread_checking, thread_update)));
		menu_bar.add(menu_options);
		setJMenuBar(menu_bar);
				
		/* Init Onglets */
		onglet.add("Employés", new TabWorker(storage));
		onglet.add("Planning", new TabTimeTable(storage, feedback));
		onglet.add("Historique des pointages", new TabCheckingHistory(storage));

		getContentPane().add(feedback, BorderLayout.NORTH);
		getContentPane().add(onglet, BorderLayout.CENTER);
	}
}
