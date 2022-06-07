package main;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

import model.Checking;
import model.SocketServer;
import model.Worker;

public class MainSocketServer {
	public static void main(String[] argv) {
		List<Worker> workers = new ArrayList<>();
		workers.add(new Worker(1, "First"));
		workers.add(new Worker(2, "Second"));
		workers.add(new Worker(3, "Third"));
		
		Set<Checking> checks = new TreeSet<Checking>();
		
		SocketServer server;
		
		try {
			server = new SocketServer();
			while(true) {
				server.setConnection();
				Checking check = (Checking)server.readObject();
				
				Worker ret = null;
				for(Worker w : workers) {
					if(w.getId() == check.getWorker().getId())
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
