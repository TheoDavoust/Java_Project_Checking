package view;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ScrollPaneLayout;
import javax.swing.border.Border;
import javax.swing.table.AbstractTableModel;

import controller.TableModelWorker;
import model.Storage;

public class TabWorker extends JPanel{
	private Storage storage;
	
	private JButton button_delete;
	private JButton button_add;
	private JTable table;
	
	private JPanel bottom_container;
	private JPanel center_container;
	
	public TabWorker(Storage storage) {
		this.storage = storage;
		setLayout(new BorderLayout(50, 50));
		
		this.button_add = new JButton("Ajouter");
		this.button_delete = new JButton("Supprimer");
		
		this.table = new JTable(new TableModelWorker(storage.getWorkers()));
		
		this.bottom_container = new JPanel();
		this.center_container = new JPanel();
		
		init();
	}
	
	public void init() {
		bottom_container.setLayout(new GridLayout());
		bottom_container.add(button_add);
		bottom_container.add(button_delete);
		
		center_container.setLayout(new GridLayout());
		JScrollPane scroll = new JScrollPane(table);
		scroll.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		center_container.add(scroll);
		
		add(center_container, BorderLayout.CENTER);
		add(bottom_container, BorderLayout.SOUTH);
	}
}
