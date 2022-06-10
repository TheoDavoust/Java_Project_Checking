package controller;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JComboBox;

import model.SocketClient;
import model.Worker;
import view.FeedBackLabel;

public class EmulatorTimerUpdate implements ActionListener{

	private SocketClient socket;
	private FeedBackLabel feedback;
	private JComboBox<Worker> dropdown;
	private List<Worker> workers;
	
	public EmulatorTimerUpdate(JComboBox<Worker> dropdown, FeedBackLabel feedback) {
		this.dropdown = dropdown;
		this.feedback = feedback;
		this.workers = new ArrayList<>();
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		try {
			socket = new SocketClient("127.0.0.1", 8081);
			Integer hashcode = (Integer)socket.readObject();
			if(hashcode.equals(workers.hashCode())) {
				socket.sendObject(true);
			}
			else {
				socket.sendObject(false);
				workers = (List<Worker>)socket.readObject();
				
				dropdown.removeAllItems();
				for(Worker w : workers)
					dropdown.addItem(w);					
			}
			
			socket.close();
		} catch (Exception e1) {
			e1.printStackTrace();
			feedback.error(e1.getMessage());
		}	
	}
}
