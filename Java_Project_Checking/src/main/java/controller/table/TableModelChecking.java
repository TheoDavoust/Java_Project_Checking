package controller.table;

import java.util.List;

import javax.swing.table.AbstractTableModel;

import model.Checking;


/**
 * Contr�le l'onglet "Historique des Pointages"
 * 
 * @author Th�o et Amaury
 * @version 12/06/2022
 */
public class TableModelChecking extends AbstractTableModel{

	private List<Checking> checkings;
	private final Object[] columns = {"Nom", "Heure approximative", "Date"};
	
	/**
	 * Construit un TableModelChecking � partir d'une List de Checking donn�e
	 * 
	 * @param checkings une List de Checking donn�e
	 */
	public TableModelChecking(List<Checking> checkings) {
		super();
	    
		this.checkings = checkings;
		fireTableRowsInserted(getRowCount(), getColumnCount());
	}
	
	/**
	 * Retourne le nom de la colonne � l'index columnindex dans le TableModelChecking
	 * 
	 * @return Le nom de la colonne
	 */
	@Override
	public String getColumnName(int columnIndex) {
		return (String) columns[columnIndex];
	}
	
	/**
	 * Retourne la taille de la List de Checking checkings
	 * 
	 * @return La taille du param�tre checkings de TableModelChecking
	 */
	@Override
	public int getRowCount() {
		return checkings.size();
	}

	/**
	 * Retourne la taille du tableau d'Object columns de TableModelChecking
	 * 
	 * @return La taille du tableau d'Object
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
