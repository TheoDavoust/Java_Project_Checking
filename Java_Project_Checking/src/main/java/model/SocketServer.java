package model;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.rmi.ConnectIOException;

public class SocketServer extends ServerSocket{
	private Socket socket;
	private int port;
	
	public SocketServer() throws IOException{
		this(8090);
	}
	
	public SocketServer(int port) throws IOException{
		super(port);
		this.port = port;
	}
	
	public void setConnection() throws IOException{
		socket = accept();
	}
	
	public Socket getSocket() {
		return socket;
	}

	public void setSocket(Socket socket) {
		this.socket = socket;
	}

	public int getPort() {
		return port;
	}

	public void setPort(int port) {
		this.port = port;
	}

	public Object readObject() throws ClassNotFoundException, IOException{
		if(!socket.isConnected())
			throw new IOException("Socket is not connected");
		
		ObjectInputStream in = new ObjectInputStream(socket.getInputStream());
		return in.readObject();
	}
	
	public void sendObject(Object o) throws IOException{
		if(!socket.isConnected())
			throw new IOException("Socket is not connected");
		
		ObjectOutputStream out = new ObjectOutputStream(socket.getOutputStream());
		out.writeObject(o);
	}
	
	public void closeSocket() throws IOException {
		socket.close();
	}
}
