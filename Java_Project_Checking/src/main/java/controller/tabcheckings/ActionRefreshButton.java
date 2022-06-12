package controller.tabcheckings;

import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;
import javax.swing.JTable;

import controller.table.TableModelChecking;
import model.Storage;

public class ActionRefreshButton extends AbstractAction {
	
	private TableModelChecking table;
	private Storage storage;
	
	public ActionRefreshButton(TableModelChecking table, Storage storage) {
		super("Refresh");
		 this.table = table;
		 this.storage = storage;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		table.fireTableDataChanged();
	}
}
