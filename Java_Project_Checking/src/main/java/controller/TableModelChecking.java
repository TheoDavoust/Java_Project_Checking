package controller;

import java.util.List;

import javax.swing.table.AbstractTableModel;

import model.Checking;


public class TableModelChecking extends AbstractTableModel{

	private List<Checking> checkings;
	private final Object[] columns = {"Nom", "Heure approximative","Date"};
	
	public TableModelChecking(List<Checking> checkings) {
		super();
	    
		this.checkings = checkings;
		fireTableRowsInserted(getRowCount(), getColumnCount());
	}
	
	@Override
	public String getColumnName(int columnIndex) {
		return (String) columns[columnIndex];
	}
	
	@Override
	public int getRowCount() {
		return checkings.size();
	}

	@Override
	public int getColumnCount() {
		return columns.length;
	}

	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		Checking c = checkings.get(rowIndex);
		switch(columnIndex) {
			case 0:
				return c.getWorker();
			case 1:
				return c.getTime();
			case 2:
				return c.getDate();
			default:
				return null;
		}
	}
}
