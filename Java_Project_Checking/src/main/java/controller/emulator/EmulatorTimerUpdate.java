package controller.emulator;

import java.awt.event.ActionEvent;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JComboBox;

import model.SocketClient;
import model.TimerSocket;
import model.Worker;
import view.util.FeedBackLabel;

public class EmulatorTimerUpdate extends TimerSocket {

	private JComboBox<Worker> dropdown;
	private List<Worker> workers;

	public EmulatorTimerUpdate(JComboBox<Worker> dropdown, FeedBackLabel feedback) {
		super("127.0.0.1", 8081, feedback);

		this.dropdown = dropdown;
		this.workers = new ArrayList<>();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		try {
			socket = new SocketClient(addr, port);
			Integer hashcode = (Integer) socket.readObject();
			if (hashcode.equals(workers.hashCode())) {
				socket.sendObject(true);
			} else {
				socket.sendObject(false);
				workers = (List<Worker>) socket.readObject();

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
