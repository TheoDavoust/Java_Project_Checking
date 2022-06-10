package controller;

import model.SocketServer;
import model.Storage;
import view.FeedBackLabel;

public class ServerThreadUpdate implements Runnable{
	private FeedBackLabel feedback;
	private Storage storage;
	private int port;
	
	public ServerThreadUpdate(FeedBackLabel feedback, Storage storage) {
		this.feedback = feedback;
		this.storage = storage;
		this.port = 8081;
	}

	@Override
	public void run() {
		try (SocketServer serv = new SocketServer(port)) {
			while(true){
				serv.setConnection();
				serv.sendObject(storage.getWorkers().hashCode());
				if(!(Boolean)serv.readObject()) {
					serv.sendObject(storage.getWorkers());
				}
			}
		}catch(Exception e) {
			feedback.error(e.getMessage());
		}
	}
}
