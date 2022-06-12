package controller.table;

import javax.swing.JComboBox;
import javax.swing.table.AbstractTableModel;

import model.Storage;
import model.Worker;

public class TableModelTimeTable extends AbstractTableModel{

	private static final String[] columns = {"", "Lundi", "Mardi", "Mercredi", "Jeudi", "Vendredi"};
	private Storage storage;
	
	private JComboBox<Worker> workers;
	
	public TableModelTimeTable(Storage storage, JComboBox<Worker> workers) {
		this.storage = storage;
		this.workers = workers;
	}
	
	@Override 
	public String getColumnName(int index){
		return columns[index];
	}
	
	@Override
	public int getRowCount() {
		return (24 * 4) - 1;
	}

	@Override
	public int getColumnCount() {
		return columns.length;
	}

	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		if(columnIndex == 0) {
			return String.format("%d:%d", rowIndex, (rowIndex * 15) % 60);
		}
		return "";
	}
}
