package main;

import view.server.MainWindow;

/**
 * Fonction main de l'application "Emulateur"
 * 
 * @author Th�o et Amaury
 * @version 12/06/2022
 */
public class ServerMain {
	/**
	 * @param args le tableau des arguments communiqu�s
	 */
	public static void main(String[] args) {
		MainWindow window = new MainWindow();
		window.setVisible(true);
	}
}
