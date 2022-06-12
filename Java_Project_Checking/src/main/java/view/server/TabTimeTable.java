package view.server;

import javax.swing.JButton;
import javax.swing.JPanel;

public class TabTimeTable extends JPanel{
	private JButton button;
	
	public TabTimeTable() {
		super();
		
		this.button = new JButton("button");
	}
	
	public void init() {		
		add(button);
	}
}
