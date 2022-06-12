package model;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

/**
 * @author Th�o et Amaury
 * @version 12/06/2022
 */
public class SocketClient extends Socket{
	private String addr;
	
	/**
	 * Construit un SocketClient � l'aide du constructeur de Socket 
	 * 
	 * @throws IOException Connection introuvable
	 */
	public SocketClient() throws IOException{
		super("127.0.0.1", 8090);
	}
	
	/**
	 * Construit un SocketClient � l'aide du constructeur de Socket, � partir d'une adresse IP donn�e et d'un port donn�
	 * 
	 * @param addr une adresse IP donn�e
	 * @param port un port donn�
	 * @throws IOException Connection introuvable
	 */
	public SocketClient(String addr, int port) throws IOException {
		super(addr, port);
	}
	
	/**
	 * Cette m�thode permet d'envoyer un objet o � un Socket
	 * @param o l'objet qui doit �tre envoy�
	 * @throws IOException Connection introuvable
	 */
	public void sendObject(Object o) throws IOException {
		if(!isConnected())
			throw new IOException();
		
		ObjectOutputStream out =  new ObjectOutputStream(getOutputStream());
		out.writeObject(o);
	}
	
	/**
	 * Cette m�thode permet de lire un objet re�u provenant d'un Socket et le retourne
	 * 
	 * @return L'objet in re�u
	 * @throws IOException Connection introuvable
	 * @throws ClassNotFoundException Classe n'existe pas
	 */
	public Object readObject() throws IOException, ClassNotFoundException{
		if(!isConnected())
			throw new IOException();
		
		ObjectInputStream in = new ObjectInputStream(getInputStream());
		return in.readObject();
	}
}
