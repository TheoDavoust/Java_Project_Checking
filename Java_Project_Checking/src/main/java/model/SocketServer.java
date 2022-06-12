package model;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @author Théo, Amaury et Louis
 * @version 12/06/2022
 */
public class SocketServer extends ServerSocket{
	private Socket socket;
	private int port;
	
	/**
	 * Construit un SocketServer par défaut en lui donnant un port fixé
	 * @throws IOException Connection introuvable
	 */
	public SocketServer() throws IOException{
		this(8090);
	}
	
	/**
	 * Construit un SocketServer à partir d'un port donné
	 * 
	 * @param port un port donné
	 * @throws IOException Connection introuvable
	 */
	public SocketServer(int port) throws IOException{
		super(port);
		this.port = port;
	}
	
	/**
	 * Cette méthode accepte une connection et créer un socket temporaire
	 * 
	 * @throws IOException Connection introuvable
	 */
	public void setConnection() throws IOException{
		socket = accept();
	}
	
	/**
	 * Retourne le Socket du SocketServer
	 * 
	 * @return le paramètre socket du SocketServer
	 */
	public Socket getSocket() {
		return socket;
	}

	/**
	 * Remplace le Socket du SocketServer par un nouveau Socket donné
	 * 
	 * @param socket un Socket donné
	 */
	public void setSocket(Socket socket) {
		this.socket = socket;
	}

	/**
	 * Retourne le port du SocketServer
	 * 
	 * @return Le paramètre port du SockerServer
	 */
	public int getPort() {
		return port;
	}

	/**
	 * Remplace le port du SocketServer par un nouveau port donné
	 * 
	 * @param port un port donné
	 */
	public void setPort(int port) {
		this.port = port;
	}

	/**
	 * Cette méthode permet de lire un objet reçu provenant d'un Socket et le retourne
	 * 
	 * @return L'objet in reçu 
	 * @throws ClassNotFoundException Classe n'existe pas
	 * @throws IOException Connection introuvable
	 */
	public Object readObject() throws ClassNotFoundException, IOException{
		if(!socket.isConnected())
			throw new IOException("Socket is not connected");
		
		ObjectInputStream in = new ObjectInputStream(socket.getInputStream());
		return in.readObject();
	}
	
	/**
	 * Cette méthode permet d'envoyer un objet o à un Socket
	 * 
	 * @param o l'objet qui doit être envoyé
	 * @throws IOException Connection introuvable
	 */
	public void sendObject(Object o) throws IOException{
		if(!socket.isConnected())
			throw new IOException("Socket is not connected");
		
		ObjectOutputStream out = new ObjectOutputStream(socket.getOutputStream());
		out.writeObject(o);
	}
	
	/**
	 * Ferme le Socket socket
	 * 
	 * @throws IOException Problème d'I/O
	 */
	public void closeSocket() throws IOException {
		socket.close();
	}
}
