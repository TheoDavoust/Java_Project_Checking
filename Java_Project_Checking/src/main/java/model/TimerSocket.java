package model;

import java.awt.event.ActionListener;

import view.FeedBackLabel;

public abstract class TimerSocket implements ActionListener{
	protected SocketClient socket;
	protected FeedBackLabel feedback;
	protected String addr;
	protected int port;
	
	public TimerSocket(String addr, int port, FeedBackLabel feedback) {
		this.addr = addr;
		this.port = port;
		this.feedback = feedback;
	}
	
	public String getAddr() {
		return addr;
	}

	public void setAddr(String addr) {
		this.addr = addr;
	}

	public int getPort() {
		return port;
	}

	public void setPort(int port) {
		this.port = port;
	}
}
