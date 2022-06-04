package model;

import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInput;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.rmi.ConnectIOException;

public class SocketClient extends Socket{
	private String addr;
	
	public SocketClient() throws IOException{
		super("127.0.0.1", 8090);
	}
	
	public SocketClient(String addr, int port) throws IOException {
		super(addr, port);
		this.addr = addr;
	}
	
	public void sendObject(Object o) throws IOException {
		if(!isConnected())
			throw new ConnectIOException(addr);
		
		ObjectOutputStream out =  new ObjectOutputStream(getOutputStream());
		out.writeObject(o);
	}
	
	public Object receiveObject() throws IOException, ClassNotFoundException{
		if(!isConnected())
			throw new ConnectIOException(addr);
		
		ObjectInputStream in = new ObjectInputStream(getInputStream());
		return in.readObject();
	}
}
