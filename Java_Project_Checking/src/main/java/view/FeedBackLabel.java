package view;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JLabel;
import javax.swing.Timer;

public class FeedBackLabel extends JLabel{
	private Timer timer;
	
	public FeedBackLabel() {
		super();
		this.setFont(new Font("Arial", Font.BOLD, 32));
		this.setForeground(new Color(255, 0, 0));
		this.setHorizontalAlignment(JLabel.CENTER);
		
		this.timer = new Timer(3000, new ActionListener() {	
			@Override
			public void actionPerformed(ActionEvent e) {
				setText("");
			}
		});
		timer.setRepeats(false);
	}
	
	public void success(String str) {
		setForeground(new Color(0, 255, 0));
		setText(str);
		startClearTimer();
	}
	
	public void error(String str) {
		setForeground(new Color(255, 0, 0));
		setText(str);
		startClearTimer();
	}
	
	public void startClearTimer() {
		timer.restart();
	}
}
