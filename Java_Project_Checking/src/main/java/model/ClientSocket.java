package model;

import java.io.IOException;
import java.net.Socket;

public class ClientSocket {
	private Socket socket;
	
	public ClientSocket() {
		this("127.0.0.1", 8090);
	}
	
	public ClientSocket(String addr, int port) {
		 
	}
	
	public void setConnection() throws IOException{
		this.socket = new Socket();
	}
}
