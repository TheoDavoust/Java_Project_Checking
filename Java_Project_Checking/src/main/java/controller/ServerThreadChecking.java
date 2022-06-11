package controller;

import model.Checking;
import model.ServerThread;
import model.SocketServer;
import model.Storage;
import model.Worker;
import view.FeedBackLabel;

public class ServerThreadChecking extends ServerThread{
	
	public ServerThreadChecking(FeedBackLabel feedback, Storage storage, int port) {
		super(feedback, storage, port);
	}

	@Override
	public void run() {
		try {
			while(!isInterrupted()) {
				server = new SocketServer(port);
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
			e.printStackTrace();
			feedback.error(e.getMessage());
		}
	}
}
