package controller.emulator;

import java.awt.event.ActionEvent;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

import javax.swing.JComboBox;

import model.SocketClient;
import model.TimerSocket;
import model.Worker;
import view.util.FeedBackLabel;

/**
 * @author Théo et Amaury
 * @version 12/06/2022
 */
public class EmulatorTimerUpdate extends TimerSocket {

	private JComboBox<Worker> dropdown;
	private Vector<Worker> workers;

	/**
	 * Constuit un EmulatorTimerUpdat à partir d''une JComboBox de Worker et d'un FeedBackLabel
	 * 
	 * @param dropdown une JComboBox de Worker donnée
	 * @param feedback un FeedBackLabel donné
	 */
	public EmulatorTimerUpdate(JComboBox<Worker> dropdown, FeedBackLabel feedback) {
		super("127.0.0.1", 8081, feedback);

		this.dropdown = dropdown;
		this.workers = new Vector<>();
	}

	/**
	 * Permet de mettre à jour les employés de la pointeuse
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		try {
			socket = new SocketClient(addr, port);
			Integer hashcode = (Integer) socket.readObject();
			if (hashcode.equals(workers.hashCode())) {
				socket.sendObject(true);
			} else {
				socket.sendObject(false);
				workers = (Vector<Worker>) socket.readObject();

				dropdown.removeAllItems();
				for (Worker w : workers)
					dropdown.addItem(w);
			}

			socket.close();
		} catch (Exception e1) {
			feedback.error(e1.getMessage());
		}
	}
}
