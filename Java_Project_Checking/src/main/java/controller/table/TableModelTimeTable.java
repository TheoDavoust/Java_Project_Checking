package controller.table;

import javax.swing.JComboBox;
import javax.swing.table.AbstractTableModel;

import model.Storage;
import model.Worker;

/**
 * Contr�le l'onglet "Planning"
 * 
 * @author Th�o et Amaury
 * @version 12/06/2022
 */
public class TableModelTimeTable extends AbstractTableModel{

	private static final String[] columns = {"", "Lundi", "Mardi", "Mercredi", "Jeudi", "Vendredi"};
	private Storage storage;
	
	private JComboBox<Worker> workers;
	
	/**
	 * Construit TableModelTimeTable � partir d'un Storage et d'une JComboBox de Worker donn�s
	 * 
	 * @param storage un Storage donn�
	 * @param workers une JComboBox de Worker donn�e
	 */
	public TableModelTimeTable(Storage storage, JComboBox<Worker> workers) {
		this.storage = storage;
		this.workers = workers;
	}
	
	/**
	 *Retourne le nom de la colonne � l'index index
	 *
	 *@return le nom de la colonne
	 */
	@Override 
	public String getColumnName(int index){
		return columns[index];
	}
	
	/**
	 * 
	 */
	@Override
	public int getRowCount() {
		return (24 * 4) - 1;
	}

	/**
	 * Retourne la taille de columns
	 * 
	 * @return La taille de columns
	 */
	@Override
	public int getColumnCount() {
		return columns.length;
	}

	/**
	 * Retourne l'Object se trouvant � la ligne rowIndex et la colonne columnIndex
	 * 
	 * @return un Object
	 */
	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		if(columnIndex == 0) {
			return String.format("%d:%d", rowIndex, (rowIndex * 15) % 60);
		}
		return "";
	}
}
