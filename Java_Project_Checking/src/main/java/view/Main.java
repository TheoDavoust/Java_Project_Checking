package view;

import java.awt.BorderLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Main {
	public static void main(String[] args) {

		JFrame f = new JFrame();
		JPanel pText = new JPanel();
		BorderLayout bl = new BorderLayout();
		f.setSize(500, 250);
		f.setTitle("Time Tracker emulator");
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.add(pText);
		pText.setLayout(bl);
		//JLabel l = new JLabel("ID");
		//l.setBounds(20,170, 70, 30);
		//panel.add(l);
		
		JTextField t = new JTextField();
		//t.setBounds(20, 170, 250, 30);
		//TextPrompt tp = new TextPrompt("User ID",t);
		pText.add(t, BorderLayout.SOUTH);
		
		JButton b = new JButton("Cheking in/out");
		b.setBounds(310, 170,140, 30);
		pText.add(b);
		
		pText.add(t);
		

		f.setVisible(true);
		
		/*JPanel pHour = new JPanel("7:36");
		
		pHour.setBounds(245, 120, 10, 10);*/
		
	}
	
	public static void createAndShowGUI() {
		JFrame frame = new JFrame("Test");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.pack();
		frame.setVisible(true);
	}
	
	public void createJPanel(){
		
	}
	/*public Clock(){
		EventQueue.invokeLater(new Runnable() {
			@Override
			public void run() {
				
					
				}
		}
	}*/
}