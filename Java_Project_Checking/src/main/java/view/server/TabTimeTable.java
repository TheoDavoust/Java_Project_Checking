package view.server;

import java.awt.BorderLayout;

import javax.swing.JComboBox;
import javax.swing.JPanel;
import javax.swing.JTable;

import controller.table.TableModelTimeTable;
import model.Storage;
import model.Worker;

public class TabTimeTable extends JPanel {

	private Storage storage;
	private JComboBox<Worker> workers_box;
	private JTable table;
	private TableModelTimeTable table_model;

	public TabTimeTable(Storage storage) {
		super();
		setLayout(new BorderLayout());

		this.storage = storage;
		this.workers_box = new JComboBox<Worker>(storage.getWorkers());
		this.table_model = new TableModelTimeTable(storage, workers_box);
		this.table = new JTable(this.table_model);
		
		init();
	}

	public void init() {
		// add(new TableModelTimeTable(, null))
	}
}
