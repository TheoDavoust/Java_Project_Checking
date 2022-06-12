package model;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @author Th�o et Amaury
 * @version 12/06/2022
 */
public class SocketServer extends ServerSocket{
	private Socket socket;
	private int port;
	
	/**
	 * Construit un SocketServer par d�faut en lui donnant un port fix�
	 * @throws IOException Connection introuvable
	 */
	public SocketServer() throws IOException{
		this(8090);
	}
	
	/**
	 * Construit un SocketServer � partir d'un port donn�
	 * 
	 * @param port un port donn�
	 * @throws IOException Connection introuvable
	 */
	public SocketServer(int port) throws IOException{
		super(port);
		this.port = port;
	}
	
	/**
	 * Cette m�thode accepte une connection et cr�er un socket temporaire
	 * 
	 * @throws IOException Connection introuvable
	 */
	public void setConnection() throws IOException{
		socket = accept();
	}
	
	/**
	 * Retourne le Socket du SocketServer
	 * 
	 * @return le param�tre socket du SocketServer
	 */
	public Socket getSocket() {
		return socket;
	}

	/**
	 * Remplace le Socket du SocketServer par un nouveau Socket donn�
	 * 
	 * @param socket un Socket donn�
	 */
	public void setSocket(Socket socket) {
		this.socket = socket;
	}

	/**
	 * Retourne le port du SocketServer
	 * 
	 * @return Le param�tre port du SockerServer
	 */
	public int getPort() {
		return port;
	}

	/**
	 * Remplace le port du SocketServer par un nouveau port donn�
	 * 
	 * @param port un port donn�
	 */
	public void setPort(int port) {
		this.port = port;
	}

	/**
	 * Cette m�thode permet de lire un objet re�u provenant d'un Socket et le retourne
	 * 
	 * @return L'objet in re�u 
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
	 * Cette m�thode permet d'envoyer un objet o � un Socket
	 * 
	 * @param o l'objet qui doit �tre envoy�
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
	 * @throws IOException Probl�me d'I/O
	 */
	public void closeSocket() throws IOException {
		socket.close();
	}
}
