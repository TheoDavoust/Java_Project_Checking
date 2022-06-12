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
 * @author Th�o et Amaury
 * @version 12/06/2022
 */
public class EmulatorTimerChekcing extends TimerSocket {

	private Queue<Checking> queue;

	/**
	 * Construit un EmulatorTimerChecking � partir d'une Queue de Checking et d'un FeedBackLabel
	 * 
	 * @param queue une Queue de Checking donn�e
	 * @param feedback un FeedBackLabel donn�
	 */
	public EmulatorTimerChekcing(Queue<Checking> queue, FeedBackLabel feedback) {
		super("127.0.0.1", 8090, feedback);
		this.queue = queue;
	}

	/**
	 * Envoie un pointage dans une queue, v�rifie que l'employ� existe et si le Checking n'existe pas d�j�
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
