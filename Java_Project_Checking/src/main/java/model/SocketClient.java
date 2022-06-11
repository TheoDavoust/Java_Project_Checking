package model;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

public class SocketClient extends Socket{
	private String addr;
	
	public SocketClient() throws IOException{
		super("127.0.0.1", 8090);
	}
	
	public SocketClient(String addr, int port) throws IOException {
		super(addr, port);
	}
	
	public void sendObject(Object o) throws IOException {
		if(!isConnected())
			throw new IOException();
		
		ObjectOutputStream out =  new ObjectOutputStream(getOutputStream());
		out.writeObject(o);
	}
	
	public Object readObject() throws IOException, ClassNotFoundException{
		if(!isConnected())
			throw new IOException();
		
		ObjectInputStream in = new ObjectInputStream(getInputStream());
		return in.readObject();
	}
}
