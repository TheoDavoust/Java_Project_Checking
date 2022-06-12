package controller.server;

import model.ServerThread;
import model.SocketServer;
import model.Storage;
import view.util.FeedBackLabel;

/**
 * @author Théo, Amaury et Louis
 * @version 12/06/2022
 */
public class ServerThreadUpdate extends ServerThread{

	/**
	 * Construit un ServerThreadUpdate à partir d'un FeddBackLabel, d'un Storage et d'un port donnés
	 * 
	 * @param feedback un FeedBackLabel donné
	 * @param storage un Storage donné
	 * @param port un port donné
	 */
	public ServerThreadUpdate(FeedBackLabel feedback, Storage storage, int port) {
		super(feedback, storage, port);
	}

	/**
	 * Permet d'envoyer la liste des workers à la pointeuse si changement il y a eu
	 */
	@Override
	public void run() {
		try{
			server = new SocketServer(port);
			while(!Thread.currentThread().isInterrupted()){
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
