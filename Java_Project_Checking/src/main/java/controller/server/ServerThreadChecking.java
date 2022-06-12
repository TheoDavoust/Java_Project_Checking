package controller.server;

import model.Checking;
import model.ServerThread;
import model.SocketServer;
import model.Storage;
import model.Worker;
import view.util.FeedBackLabel;

/**
 * @author Théo, Amaury et Louis
 * @version 12/06/2022
 */
public class ServerThreadChecking extends ServerThread{
	
	/**
	 * Construit un ServerThreadChecking à partir d'un FeedBackLabel, d'un Storage et d'un port donnés
	 * 
	 * @param feedback un FeedBackLabel donné
	 * @param storage un Storage donné
	 * @param port un port donné
	 */
	public ServerThreadChecking(FeedBackLabel feedback, Storage storage, int port) {
		super(feedback, storage, port);
	}

	/**
	 * Permet de recevoir un Checking à tout instant quand l'application est lancée, de vérifier l'intégrité du Checking
	 * puis le stock si tout est bon
	 */
	@Override
	public void run() {
		try {
			server = new SocketServer(port);
			while(!isInterrupted()) {
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
				
				boolean isIn = storage.getCheckings().contains(c);
				server.sendObject(!isIn);
				if(!isIn)
					storage.getCheckings().add(c);
				
				server.closeSocket();
			}
		} catch (Exception e){
			e.printStackTrace();
			feedback.error(e.getMessage());
		}
	}
}
