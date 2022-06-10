package controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JComboBox;

import model.SocketServer;
import model.Worker;
import view.FeedBackLabel;

public class EmulatorThreadSocket implements Runnable{
	private SocketServer socket;
	private JComboBox<Worker> dropdown;
	private FeedBackLabel feedback;
	private List<Worker> workers;
	
	public EmulatorThreadSocket(JComboBox<Worker> dropdown, FeedBackLabel feedback){
		this.dropdown = dropdown;
		this.feedback = feedback;
		this.workers = new ArrayList<>();
		
		try {
			socket = new SocketServer(8081);
		} catch (IOException e) {
			feedback.error("Creation socket échouée.");
		}
	}
	
	@Override
	public void run() {
		while(true) {
			try {
				socket.setConnection();
				Integer hashcode = (Integer)socket.readObject();
				System.out.println(hashcode);
				System.out.println(workers.hashCode());
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
				
				socket.closeSocket();
			} catch (Exception e1) {
				feedback.error(e1.getMessage());
			}			
		}
	}
}
