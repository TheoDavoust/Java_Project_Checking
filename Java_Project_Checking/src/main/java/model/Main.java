package model;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import javax.swing.JButton;
import javax.swing.JFrame;

public class Main {

	public static void main(String[] args) {
		JFrame f = new JFrame();
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JButton b = new JButton("Test");
		b.setBounds(130, 100, 100, 40);
		
		f.add(b);
		
		f.setSize(400, 500);
		f.setLayout(null);
		f.setVisible(true);
		
		RoundedTime time = new RoundedTime();
		System.out.println(String.format("%02d:%02d", time.getHour(), time.getMinute()));

		try {
			FileOutputStream fout = new FileOutputStream("./src/test/resources/test.txt");
			ObjectOutputStream oos = new ObjectOutputStream(fout);
			oos.writeObject(time);
		}catch(IOException e) {
			e.printStackTrace();
		}
		
		try {
			FileInputStream fin = new FileInputStream("./src/test/resources/test.txt");
			ObjectInputStream ois = new ObjectInputStream(fin);
			time = (RoundedTime)ois.readObject();
			System.out.println(String.format("%02d:%02d", time.getHour(), time.getMinute()));
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
}
