package main;

import view.emulator.EmulatorWindow;

/**
 * Fonction main de l'application "Ressources Humaines"
 * 
 * @author Th�o et Amaury
 * @version 12/06/2022
 */
public class EmulatorMain {

	/**
	 * @param args le tableau des arguments communiqu�s
	 */
	public static void main(String[] args) {
		EmulatorWindow window = new EmulatorWindow();
		window.setVisible(true);
	}
}
