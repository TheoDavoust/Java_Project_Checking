package main;

import view.server.MainWindow;

/**
 * Fonction main de l'application "Emulateur"
 * 
 * @author Théo, Amaury et Louis
 * @version 12/06/2022
 */
public class ServerMain {
	/**
	 * @param args le tableau des arguments communiqués
	 */
	public static void main(String[] args) {
		MainWindow window = new MainWindow();
		window.setVisible(true);
	}
}
