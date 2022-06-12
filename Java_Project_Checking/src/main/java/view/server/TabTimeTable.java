package view.server;

import java.awt.BorderLayout;

import javax.swing.JPanel;

import model.Storage;

public class TabTimeTable extends JPanel{
	
	private Storage storage;

	public TabTimeTable() {
		super();
		setLayout(new BorderLayout());
			
		init();
	}
	
	public void init() {		
		//add(new TableModelTimeTable(, null))
	}
}
