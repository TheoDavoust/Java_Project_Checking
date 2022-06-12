package controller.table;

import javax.swing.JComboBox;
import javax.swing.table.AbstractTableModel;

import model.Storage;
import model.Worker;

/**
 * Contrôle la table de l'onglet "Planning"
 * 
 * @author Théo, Amaury et Louis
 * @version 12/06/2022
 */
public class TableModelTimeTable extends AbstractTableModel{

	private static final String[] columns = {"", "Lundi", "Mardi", "Mercredi", "Jeudi", "Vendredi"};
	private Storage storage;
	
	private JComboBox<Worker> workers;
	
	/**
	 * Construit TableModelTimeTable à partir d'un Storage et d'une JComboBox de Worker donnés
	 * 
	 * @param storage un Storage donné
	 * @param workers une JComboBox de Worker donnée
	 */
	public TableModelTimeTable(Storage storage, JComboBox<Worker> workers) {
		this.storage = storage;
		this.workers = workers;
	}
	
	/**
	 *Retourne le nom de la colonne à l'index index
	 *
	 *@return le nom de la colonne
	 */
	@Override 
	public String getColumnName(int index){
		return columns[index];
	}
	
	/**
	 * Retourne le nombre de lignes
	 * 
	 * @return le nombre de lignes
	 */
	@Override
	public int getRowCount() {
		return (24 * 4) - 1;
	}

	/**
	 * Retourne le nombre de colonnes
	 * 
	 * @return Le nombre de colonnes
	 */
	@Override
	public int getColumnCount() {
		return columns.length;
	}

	/**
	 * Retourne l'Object se trouvant à la ligne rowIndex et la colonne columnIndex
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
