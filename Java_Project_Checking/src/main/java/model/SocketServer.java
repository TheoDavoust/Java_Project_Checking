package model;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class SocketServer {
	private Socket socket;
	private ServerSocket serverSocket;
	private int port;
	
	public SocketServer() throws IOException{
		this(8090);
	}
	
	public SocketServer(int port) throws IOException{
		super();
		this.port = port;
		this.serverSocket = new ServerSocket(this.port);
	}
	
	public void setConnection() throws IOException{
		this.socket = this.serverSocket.accept();
	}
	
	public Checking readChecking() throws ClassNotFoundException, IOException{
		ObjectInputStream in = (ObjectInputStream)this.socket.getInputStream();
		Checking checking = (Checking)in.readObject();
		this.socket.getOutputStream().write('\0');
		return checking;
	}
}
