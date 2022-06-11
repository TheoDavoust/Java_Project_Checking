package view;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JTextArea;
import javax.swing.Timer;

public class FeedBackLabel extends JTextArea{
	private Timer timer;
	
	public FeedBackLabel() {
		super();
		this.setFont(new Font("Arial", Font.BOLD, 32));
		this.setWrapStyleWord(true);
		this.setLineWrap(true);
		this.setOpaque(false);
		this.setEditable(false);
		this.setFocusable(false);
	    
		this.timer = new Timer(5000, new ActionListener() {	
			@Override
			public void actionPerformed(ActionEvent e) {
				setText("");
			}
		});
		timer.setRepeats(false);
	}
	
	public synchronized void success(String str) {
		setForeground(new Color(51, 204, 51));
		setText(str);
		startClearTimer();
	}
	
	public synchronized void error(String str) {
		setForeground(new Color(255, 26, 26));
		setText(str);
		startClearTimer();
	}
	
	public synchronized void info(String str) {
		setForeground(new Color(0, 128, 255));
		setText(str);
		startClearTimer();
	}
	
	public void startClearTimer() {
		timer.restart();
	}
}
