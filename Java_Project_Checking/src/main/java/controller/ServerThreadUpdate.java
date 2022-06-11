package controller;

import model.ServerThread;
import model.SocketServer;
import model.Storage;
import view.FeedBackLabel;

public class ServerThreadUpdate extends ServerThread{

	public ServerThreadUpdate(FeedBackLabel feedback, Storage storage, int port) {
		super(feedback, storage, port);
	}

	@Override
	public void run() {
		try{
			System.out.println("Running");
			while(!Thread.currentThread().isInterrupted()){
				server = new SocketServer(port);
				server.setConnection();
				server.sendObject(storage.getWorkers().hashCode());
				if(!(Boolean)server.readObject()) {
					server.sendObject(storage.getWorkers());
				}
				server.closeSocket();
			}
		}catch(Exception e) {
			e.printStackTrace();
			feedback.error(e.getMessage());
		}
	}
}
