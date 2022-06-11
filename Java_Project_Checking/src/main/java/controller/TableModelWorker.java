package controller;

import java.awt.event.ActionEvent;
import java.util.List;

import javax.swing.AbstractAction;
import javax.swing.JDialog;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.AbstractTableModel;

import model.Worker;

public class TableModelWorker extends AbstractTableModel{

	private List<Worker> workers;
	private final Object[] columns = {"Nom", "UUID"};
	private JTable table;
	
	public TableModelWorker(List<Worker> workers, JTable table) {
		super();
	    
		this.workers = workers;
		this.table = table;
		fireTableRowsInserted(getRowCount(), getColumnCount());
	}
	
	@Override
	public String getColumnName(int columnIndex) {
		return (String) columns[columnIndex];
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
	
	public class deleteAction extends AbstractAction{
		public deleteAction() {
			super("Supprimer");
		}
		
		@Override
		public void actionPerformed(ActionEvent e) {
			int[] selected = table.getSelectedRows();
			for(int i = selected.length - 1; i >= 0; i--)
			{
				workers.remove(selected[i]);
				fireTableRowsDeleted(selected[i], selected[i]);
			}
		}
	}
	
	public class addAction extends AbstractAction{
		public addAction(){
			super("Ajouter");
		}
		
		@Override
		public void actionPerformed(ActionEvent e) {
			String name = (String)JOptionPane.showInputDialog(
				"Nom de l'employé à ajouter : "
			);
			
			if(!name.isBlank()){
				workers.add(new Worker(name));
				fireTableRowsInserted(getRowCount(), getColumnCount());
			}
		}
	}
	
	public class modifierAction extends AbstractAction{
		public modifierAction() {
			super("Modifier");
		}
		
		@Override
		public void actionPerformed(ActionEvent e) {
			int row = table.getSelectedRow();
			if(row == -1)
				return;
			
			Worker worker = workers.get(row);
			String new_name = JOptionPane.showInputDialog(
				String.format("Veuillez saisir le nouveau nom pour %s", worker.getName()),
				worker.getName()
			);
			
			if(!new_name.isBlank()) {
				worker.setName(new_name);
				fireTableRowsUpdated(row, row);
			}
		}
	}
}
