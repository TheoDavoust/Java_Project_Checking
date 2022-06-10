package controller;

import model.Checking;
import model.SocketServer;
import model.Storage;
import model.Worker;
import view.FeedBackLabel;

public class ServerThreadChecking implements Runnable{
	
	private Storage storage;
	private FeedBackLabel feedback;
	private int port;
	
	public ServerThreadChecking(FeedBackLabel feedback, Storage storage) {
		this.storage = storage;
		this.feedback = feedback;
		this.port = 8090;
	}
	
	@Override
	public void run() {
		try (SocketServer server = new SocketServer(port)) {
			while(true) {
				server.setConnection();
				Checking check = (Checking)server.readObject();
				
				Worker ret = null;
				for(Worker w : storage.getWorkers()) {
					if(w.getId().equals(check.getWorker().getId()))
						ret = w;
				}
				server.sendObject(ret);
				if(ret == null)
					break;
				
				Checking c = new Checking(ret, check.getTime());
				c.setDate(check.getDate());
				
				server.sendObject(!storage.getCheckings().add(c));
				server.closeSocket();
			}
		} catch (Exception e){
			feedback.error(e.getMessage());
		}
	}
}
