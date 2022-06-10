package controller;

import java.util.List;

import javax.swing.table.AbstractTableModel;

import model.Worker;

public class TableModelWorker extends AbstractTableModel{

	private final String[] columns = {"Nom", "UUID"};
	private List<Worker> workers;
	
	public TableModelWorker(List<Worker> workers) {
		super();
		this.workers = workers;
		fireTableRowsInserted(getRowCount(), getColumnCount());
	}
	
	@Override
	public String getColumnName(int columnIndex) {
		return columns[columnIndex];
	}
	
	@Override
	public int getRowCount() {
		return workers.size();
	}

	@Override
	public int getColumnCount() {
		return columns.length;
	}

	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		Worker w = workers.get(rowIndex);
		switch(columnIndex) {
			case 0:
				return w.getName();
			case 1:
				return w.getId();
			default:
				return null;
		}
	}
}