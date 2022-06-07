package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.Queue;

import javax.swing.JTextField;

import model.Checking;
import model.SocketClient;
import model.Worker;
import view.FeedBackLabel;

public class EmulatorTimerChekcing implements ActionListener{
	
	private Queue<Checking> queue;
	private JTextField field;
	private FeedBackLabel feedback_text;
	private SocketClient socket;
	
	public EmulatorTimerChekcing(JTextField field, FeedBackLabel feedback_text, Queue<Checking> queue){
		super();
		this.field = field;
		this.feedback_text = feedback_text;
		this.queue = queue;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		try {
			if(!queue.isEmpty()) {
				socket = new SocketClient();
				while(!queue.isEmpty())
				{
					socket.sendObject(queue.peek());
					
					Worker w = (Worker)socket.receiveObject();
					if(w != null) {
						feedback_text.success(String.format("Bonjour %s.", w.getName()));
						if((Boolean)socket.receiveObject())
							feedback_text.error("Vous avez déjà pointé.");						
					}
					else
						feedback_text.error("Cet identifiant n'existe pas.");
					
					queue.remove();
				}
				socket.close();				
			}
		} catch (Exception e1){
			feedback_text.error(e1.getMessage());
			e1.printStackTrace();
		}
	}
}
