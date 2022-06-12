package model;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

/**
 * @author Théo et Amaury
 * @version 12/06/2022
 */
public class SocketClient extends Socket{
	private String addr;
	
	/**
	 * Construit un SocketClient à l'aide du constructeur de Socket 
	 * 
	 * @throws IOException Connection introuvable
	 */
	public SocketClient() throws IOException{
		super("127.0.0.1", 8090);
	}
	
	/**
	 * Construit un SocketClient à l'aide du constructeur de Socket, à partir d'une adresse IP donnée et d'un port donné
	 * 
	 * @param addr une adresse IP donnée
	 * @param port un port donné
	 * @throws IOException Connection introuvable
	 */
	public SocketClient(String addr, int port) throws IOException {
		super(addr, port);
	}
	
	/**
	 * Cette méthode permet d'envoyer un objet o à un Socket
	 * @param o l'objet qui doit être envoyé
	 * @throws IOException Connection introuvable
	 */
	public void sendObject(Object o) throws IOException {
		if(!isConnected())
			throw new IOException();
		
		ObjectOutputStream out =  new ObjectOutputStream(getOutputStream());
		out.writeObject(o);
	}
	
	/**
	 * Cette méthode permet de lire un objet reçu provenant d'un Socket et le retourne
	 * 
	 * @return L'objet in reçu
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
