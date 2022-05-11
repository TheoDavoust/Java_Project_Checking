package model;

import javax.swing.*;

public class Main {

	public static void main(String[] args) {
		JFrame f = new JFrame();
		
		JButton b = new JButton("Test");
		b.setBounds(130, 100, 100, 40);
		
		f.add(b);
		
		f.setSize(400, 500);
		f.setLayout(null);
		f.setVisible(true);
		
		RoundedTime time = new RoundedTime();
		System.out.println(String.format("%02d:%02d", time.getHour(), time.getMinute()));
	}
}
