package model;

import java.io.IOException;
import java.net.Socket;
import java.rmi.ConnectIOException;

public class SocketClient {
	private Socket socket;
	private String addr;
	private int port;
	
	public SocketClient() throws IOException{
		this("127.0.0.1", 8090);
	}
	
	public SocketClient(String addr, int port) throws IOException {
		this.socket = new Socket(addr, port);
	}
	
	public void sendChecking(int id) throws ConnectIOException {
		if(!this.socket.isConnected()) {
			throw new ConnectIOException(addr);
		}
	}
}
