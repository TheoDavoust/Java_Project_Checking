package main;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;
import java.util.UUID;

import javax.swing.Timer;

import model.Checking;
import model.SocketClient;
import model.SocketServer;
import model.Worker;

public class MainSocketServer {
	public static void main(String[] argv) {
		List<Worker> workers = new ArrayList<>();
		workers.add(new Worker(UUID.randomUUID(), "Jean Bon"));
		workers.add(new Worker(UUID.randomUUID(), "Alex Ception"));
		workers.add(new Worker(UUID.randomUUID(), "Théodore An"));
		
		Set<Checking> checks = new TreeSet<Checking>();
		
		SocketServer server;

		Timer timer = new Timer(5000, new ActionListener() {
			private SocketClient update_socket;
			
			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					update_socket = new SocketClient("127.0.0.1", 8081);
					update_socket.sendObject(workers.hashCode());
					if(!(Boolean)update_socket.readObject()) {
						update_socket.sendObject(workers);
					}
				} catch (Exception e1) {
					e1.printStackTrace();
				}
			}
		});
		timer.start();
		
		try {
			server = new SocketServer(8090);
			while(true) {
				server.setConnection();
				Checking check = (Checking)server.readObject();
				
				Worker ret = null;
				for(Worker w : workers) {
					if(w.getId().equals(check.getWorker().getId()))
						ret = w;
				}
				server.sendObject(ret);
				if(ret == null)
					break;
				
				Checking c = new Checking(ret, check.getTime());
				c.setDate(check.getDate());
				
				server.sendObject(!checks.add(c));
				server.closeSocket();
				
				System.out.println(checks);
			}
		} catch (Exception e){
			e.printStackTrace();
		}
		
	}
}
