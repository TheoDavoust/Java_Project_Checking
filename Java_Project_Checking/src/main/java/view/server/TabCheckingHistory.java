package view.server;

import java.awt.BorderLayout;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import controller.table.TableModelChecking;
import model.Storage;

public class TabCheckingHistory extends JPanel{
	private JButton button;
	private JPanel center_container;
	private JPanel bottom_container;
	private JScrollPane scroll;
	private Storage storage;
	private JButton button_today;
	private JButton button_alltime;
	
	private JTable table;
	
	public TabCheckingHistory(Storage storage) {
		this.storage = storage;
		setLayout(new BorderLayout(50, 50));
		
		this.button_today = new JButton("Aujourd'hui");
		this.button_alltime = new JButton("Tous");
		
		this.table = new JTable();
		table.setModel(new TableModelChecking(storage.getCheckings()));
		table.setAutoCreateRowSorter(true);
		
		scroll = new JScrollPane(table);
		
		this.bottom_container = new JPanel();
		this.center_container = new JPanel();
		
		init();
	}
	
	public void init() {		
		bottom_container.setLayout(new GridLayout());
		bottom_container.add(button_today);
		bottom_container.add(button_alltime);
		
		center_container.setLayout(new GridLayout());
		scroll.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		center_container.add(scroll);
		
		add(center_container, BorderLayout.CENTER);
		add(bottom_container, BorderLayout.SOUTH);
		
	}
}
