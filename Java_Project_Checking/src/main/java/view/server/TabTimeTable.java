package view.server;

import java.awt.BorderLayout;

import javax.swing.JPanel;

import model.Storage;

/**
 * R�pr�sente l'onglet "Planning"
 * 
 * @author Th�o et Amaury
 * @version 12/06/2022
 */
public class TabTimeTable extends JPanel{
	
	private Storage storage;

	/**
	 * 
	 */
	public TabTimeTable() {
		super();
		setLayout(new BorderLayout());
			
		init();
	}
	
	/**
	 * 
	 */
	public void init() {		
		//add(new TableModelTimeTable(, null))
	}
}
