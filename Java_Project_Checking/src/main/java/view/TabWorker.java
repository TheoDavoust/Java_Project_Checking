package view;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ScrollPaneLayout;
import javax.swing.table.AbstractTableModel;

import controller.TableModelWorker;
import model.Storage;

public class TabWorker extends JPanel{
	private Storage storage;
	
	private JButton button_delete;
	private JButton button_add;
	private JTable table;
	
	private JPanel bottom_container;
	private JScrollPane center_container;
	
	public TabWorker(Storage storage) {
		this.storage = storage;
		setLayout(new BorderLayout(50, 50));
		
		this.button_add = new JButton("Ajouter");
		this.button_delete = new JButton("Supprimer");
		
		this.table = new JTable();
		table.setModel(new TableModelWorker(storage.getWorkers()));
		
		this.bottom_container = new JPanel();
		this.center_container = new JScrollPane();
		
		init();
	}
	
	public void init() {
		bottom_container.setLayout(new GridLayout());
		bottom_container.add(button_add);
		bottom_container.add(button_delete);
		
		center_container.setLayout(new ScrollPaneLayout());
		center_container.add(table);
		
		add(center_container, BorderLayout.CENTER);
		add(bottom_container, BorderLayout.SOUTH);
		
		System.out.println(table.getValueAt(0, 0));
	}
}
