package controller;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.Timer;

import model.TimerSocket;

public class ClientConnectionMenu extends AbstractAction{
	private TimerSocket checking_action;
	private TimerSocket update_action;
	private Timer timer;
	
	public ClientConnectionMenu(Timer timer, TimerSocket checking_action, TimerSocket update_action) {
		super("Connexion");
		this.checking_action = checking_action;
		this.update_action = update_action;
		this.timer = timer;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		JPanel panel = new JPanel();
		JTextField update_port_field = new JTextField(5);
		update_port_field.setText(String.format("%d", update_action.getPort()));
		JTextField checking_port_field = new JTextField(5);
		checking_port_field.setText(String.format("%d", checking_action.getPort()));
		JTextField address_field = new JTextField(5);
		address_field.setText(String.format("%s", update_action.getAddr()));
		
		panel.setLayout(new GridLayout(3, 2));
		panel.add(new JLabel("Port de mise à jour : "));
		panel.add(update_port_field);
		panel.add(new JLabel("Port de pointage : "));
		panel.add(checking_port_field);
		panel.add(new JLabel("Adresse du serveur : "));
		panel.add(address_field);

		int result = JOptionPane.showConfirmDialog(null, panel, "Paramètres de connexion",
				JOptionPane.OK_CANCEL_OPTION);
		if(result == JOptionPane.OK_OPTION) {
			timer.stop();
			update_action.setPort(Integer.parseInt(update_port_field.getText()));
			checking_action.setPort(Integer.parseInt(checking_port_field.getText()));
			update_action.setAddr(address_field.getText());
			checking_action.setAddr(address_field.getText());
			timer.start();
		}
	}
}
