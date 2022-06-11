package model;

import java.io.IOException;

import view.FeedBackLabel;

public abstract class ServerThread extends Thread{
	protected FeedBackLabel feedback;
	protected Storage storage;
	protected int port;
	protected SocketServer server;
	
	public ServerThread(FeedBackLabel feedback, Storage storage, int port) {
		this.feedback = feedback;
		this.storage = storage;
		this.port = port;
	}
	
	public int getPort() {
		return port;
	}

	public void setPort(int port) {
		this.port = port;
	}

	public FeedBackLabel getFeedback() {
		return feedback;
	}

	public void setFeedback(FeedBackLabel feedback) {
		this.feedback = feedback;
	}

	public Storage getStorage() {
		return storage;
	}

	public void setStorage(Storage storage) {
		this.storage = storage;
	}

	@Override
	public void interrupt() {
		try {
			server.close();
			server = null;
		}catch(IOException e) {
			e.printStackTrace();
		}finally {
			super.interrupt();
		}
	}
}
