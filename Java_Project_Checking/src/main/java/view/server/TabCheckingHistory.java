package view.server;

import java.awt.BorderLayout;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import controller.tabcheckings.ActionRefreshButton;
import controller.table.TableModelChecking;
import model.Storage;

/**
 * Représente l'onglet "Historique des pointages"
 * 
 * @author Théo, Amaury et Louis
 * @version 12/06/2022
 */
public class TabCheckingHistory extends JPanel{
	private Storage storage;

	private JPanel center_container;
	private JPanel bottom_container;
	private JScrollPane scroll;

	private JButton button_today;
	private JButton button_alltime;
	private JButton button_refresh;
	
	private JTable table;
	
	/**
	 * Construit un TabCheckingHistory à partir d'un Storage, puis l'initialise
	 * 
	 * @param storage un Storage donné
	 */
	public TabCheckingHistory(Storage storage) {
		this.storage = storage;
		setLayout(new BorderLayout(50, 50));
		
		this.table = new JTable();
		table.setModel(new TableModelChecking(storage.getCheckings()));
		table.setAutoCreateRowSorter(true);

		this.button_today = new JButton("Aujourd'hui");
		this.button_alltime = new JButton("Tous");
		this.button_refresh = new JButton("Refresh");
		this.button_refresh.setAction(new ActionRefreshButton((TableModelChecking)table.getModel(), storage));
		
		scroll = new JScrollPane(table);
		
		this.bottom_container = new JPanel();
		this.center_container = new JPanel();
		
		init();
	}
	
	/**
	 * Initialise TabCheckingHistory sur sa contenance
	 */
	public void init() {
		bottom_container.setLayout(new GridLayout());
		bottom_container.add(button_today);
		bottom_container.add(button_refresh);
		bottom_container.add(button_alltime);
		
		center_container.setLayout(new GridLayout());
		scroll.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		center_container.add(scroll);
		
		add(center_container, BorderLayout.CENTER);
		add(bottom_container, BorderLayout.SOUTH);
	}
}
