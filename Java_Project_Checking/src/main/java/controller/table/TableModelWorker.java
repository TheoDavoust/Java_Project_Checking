package controller.table;

import java.awt.event.ActionEvent;
import java.util.Vector;

import javax.swing.AbstractAction;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.AbstractTableModel;

import model.Worker;

/**
 * Contr�le l'onglet "Employ�s"
 * 
 * @author Th�o et Amaury
 * @version 12/06/2022
 */
public class TableModelWorker extends AbstractTableModel{

	private Vector<Worker> workers;
	private final Object[] columns = {"Nom", "UUID"};
	private JTable table;
	
	/**
	 * Construit un TableModelWorker � partir d'une List de Worker et d'une JTable donn�es
	 * 
	 * @param workers une List de Worker donn�e
	 * @param table une JTable donn�e
	 */
	public TableModelWorker(Vector<Worker> workers, JTable table) {
		super();
	    
		this.workers = workers;
		this.table = table;
		fireTableRowsInserted(getRowCount(), getColumnCount());
	}
	
	/**
	 * Retourne le nom de la colonne � l'index columnIndex
	 * 
	 * @return Le nom de la colonne
	 */
	@Override
	public String getColumnName(int columnIndex) {
		return (String) columns[columnIndex];
	}
	
	/**
	 * Retourne la taille de la List de Worker workers
	 *
	 * @return La taille du param�tre workers de TableModelWorker
	 */
	@Override
	public int getRowCount() {
		return workers.size();
	}

	/**
	 * Retourne la taille du tableau d'Object columns
	 * 
	 * @return La taille du param�tre columns de TableModelWorker
	 */
	@Override
	public int getColumnCount() {
		return columns.length;
	}

	/**
	 * Retourne un Object se trouvant � la ligne rowIndex et la colonne columnIndex
	 * 
	 * @return un Object
	 */
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
	
	/**
	 * @author Th�o et Amaury
	 * @version 12/06/2022
	 */
	public class deleteAction extends AbstractAction{
		/**
		 * Construit deleteAction avec un String
		 */
		public deleteAction() {
			super("Supprimer");
		}
		
		/**
		 * Supprime une ligne de TableModelWorker, supprimant le worker de la workers, et le notifie
		 */
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
	
	/**
	 * @author Th�o et Amaury
	 * @version 12/06/2022
	 */
	public class addAction extends AbstractAction{
		/**
		 * Construit addAction avec un String
		 */
		public addAction(){
			super("Ajouter");
		}
		
		/**
		 * Ouvre une boite de dialogue permettant d'ajouter un Worker, puis l'ajoute dans la List de Worker workers, et le notifie
		 */
		@Override
		public void actionPerformed(ActionEvent e) {
			String name = (String)JOptionPane.showInputDialog(
				"Nom de l'employé à ajouter : "
			);
			
			if(name != null && !name.isBlank()){
				workers.add(new Worker(name));
				fireTableRowsInserted(getRowCount() - 1, getRowCount() - 1);
			}
		}
	}
	
	/**
	 * @author Th�o et Amaury
	 * @version 12/06/2022
	 */
	public class modifierAction extends AbstractAction{
		/**
		 * Construit modifierAction avec un String
		 */
		public modifierAction() {
			super("Modifier");
		}
		
		/**
		 * Ouvre une boite de dialogue permettant de modifier un Worker, puis le modifie dans la List de Worker workers, et le notifie
		 */
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
			
			if(new_name != null && !new_name.isBlank()) {
				worker.setName(new_name);
				fireTableRowsUpdated(row, row);
			}
		}
	}
}
