package view.emulator;

import java.awt.Font;

import javax.swing.JLabel;

/**
 * Un type de label
 * 
 * @author Th�o et Amaury
 * @version 12/06/2022
 */
public class SimpleLabel extends JLabel{
	/**
	 * Construit par d�fault un SimpleLabel
	 */
	public SimpleLabel() {
		this.setHorizontalAlignment(JLabel.CENTER);
		this.setFont(new Font("Arial", Font.PLAIN, 72));
	}
	
	/**
	 * Construit un SimpleLabel par d�fault puis change son texte avec un String donn�
	 * 
	 * @param s un String donn�
	 */
	public SimpleLabel(String s) {
		this();
		setText(s);
	}
}
