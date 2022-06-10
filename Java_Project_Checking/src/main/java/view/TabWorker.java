package view;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import controller.TableModelWorker;
import model.Storage;

public class TabWorker extends JPanel{
	private Storage storage;
	
	private JButton button_delete;
	private JButton button_add;
	private JButton button_modifier;
	private JTable table;
	
	private JPanel bottom_container;
	private JPanel center_container;
	
	public TabWorker(Storage storage) {
		this.storage = storage;
		setLayout(new BorderLayout(50, 50));
		
		
		this.table = new JTable();
		TableModelWorker table_model = new TableModelWorker(storage.getWorkers(), table);
		this.table.setModel(table_model);
		
		this.button_add = new JButton(table_model.new addAction());
		this.button_modifier = new JButton(table_model.new modifierAction());
		this.button_delete = new JButton(table_model.new deleteAction());
		
		this.bottom_container = new JPanel();
		this.center_container = new JPanel();
		
		init();
	}
	
	public void init() {
		bottom_container.setLayout(new GridLayout());
		bottom_container.add(button_add);
		bottom_container.add(button_modifier);
		bottom_container.add(button_delete);
		bottom_container.setPreferredSize(new Dimension(getPreferredSize().width, 60));
		
		center_container.setLayout(new GridLayout());
		JScrollPane scroll = new JScrollPane(table);
		scroll.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		center_container.add(scroll);
		
		add(center_container, BorderLayout.CENTER);
		add(bottom_container, BorderLayout.SOUTH);
	}
}
