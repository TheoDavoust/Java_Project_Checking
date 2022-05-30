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
		
		Worker worker = new Worker(0, "work_guy");
		Storage storage = new Storage();
		
		storage.getCheckings().add(new Checking(worker));
		storage.getWorkers().add(worker);
		
		System.out.println(storage);
		storage.save();
		
		Storage other = new Storage();
		System.out.println(other);
		other.load();
		System.out.println(other);
	}
}
