package view;

import java.awt.Font;

import javax.swing.JLabel;

public class SimpleLabel extends JLabel{
	public SimpleLabel() {
		this.setHorizontalAlignment(JLabel.CENTER);
		this.setFont(new Font("Arial", Font.PLAIN, 72));
	}
}