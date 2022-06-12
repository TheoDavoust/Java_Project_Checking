package controller.emulator;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Queue;

import model.Checking;
import model.SocketClient;
import model.TimerSocket;
import model.Worker;
import view.util.FeedBackLabel;

/**
 * Routine d'execution permettant d'envoyer les pointages au serveur
 * 
 * @author Théo, Amaury et Louis
 * @version 12/06/2022
 */
public class EmulatorTimerChecking extends TimerSocket {

	private Queue<Checking> queue;

	/**
	 * Constructeur
	 * 
	 * @param queue La queque contenant la list des poontages
	 * @param feedback Pour l'affichage des erreurs sur l'appli
	 */
	public EmulatorTimerChecking(Queue<Checking> queue, FeedBackLabel feedback) {
		super("127.0.0.1", 8090, feedback);
		this.queue = queue;
	}

	/**
	 * Envoie tous les pointages de la queue au serveur
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		try {
			if (!queue.isEmpty()) {
				socket = new SocketClient(addr, port);
				while (!queue.isEmpty()) {
					socket.sendObject(queue.peek());

					Worker w = (Worker) socket.readObject();
					if (w != null) {
						feedback.success(String.format("Bonjour %s.", w.getName()));
						if (!(Boolean) socket.readObject())
							feedback.error("Vous avez déjà pointé.");
					} else
						feedback.error("Cet identifiant n'existe pas.");

					queue.remove();
				}
				socket.close();
			}
		} catch (Exception e1) {
			feedback.error(e1.getMessage());
		}
	}
}
