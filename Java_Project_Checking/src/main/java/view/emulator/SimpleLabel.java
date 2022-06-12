package view.emulator;

import java.awt.Font;

import javax.swing.JLabel;

/**
 * Un type de label
 * 
 * @author Théo et Amaury
 * @version 12/06/2022
 */
public class SimpleLabel extends JLabel{
	/**
	 * Construit par défault un SimpleLabel
	 */
	public SimpleLabel() {
		this.setHorizontalAlignment(JLabel.CENTER);
		this.setFont(new Font("Arial", Font.PLAIN, 72));
	}
	
	/**
	 * Construit un SimpleLabel par défault puis change son texte avec un String donné
	 * 
	 * @param s un String donné
	 */
	public SimpleLabel(String s) {
		this();
		setText(s);
	}
}
