package controller.server;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 * @author Théo, Amaury, et Louis
 * @version 12/06/2022
 */
public class ServerConnectionMenu extends AbstractAction {

	private ServerThreadChecking thread_checking;
	private ServerThreadUpdate thread_update;

	/**
	 * Construit un ServerConnectionMenu à partir d'un ServerThreadChecking et d'un ServerThreadUpdate donnés
	 * 
	 * @param thread_checking un ServerThreadChecking donné
	 * @param thread_update un ServerThreadUpdate donné
	 */
	public ServerConnectionMenu(ServerThreadChecking thread_checking, ServerThreadUpdate thread_update) {
		super("Connexion");
		this.thread_checking = thread_checking;
		this.thread_update = thread_update;
	}

	/**
	 * Ouvre une boite de dialogue quand le bouton connexion est appuyé qui permet de changer le port de mise à jour, le port de pointage
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		JPanel panel = new JPanel();
		JTextField update_field = new JTextField(5);
		update_field.setText(String.format("%d", thread_update.getPort()));
		JTextField checking_field = new JTextField(5);
		checking_field.setText(String.format("%d", thread_checking.getPort()));

		panel.setLayout(new GridLayout(2, 2));
		panel.add(new JLabel("Port de mise à jour : "));
		panel.add(update_field);
		panel.add(new JLabel("Port de pointage : "));
		panel.add(checking_field);

		int result = JOptionPane.showConfirmDialog(null, panel, "Paramètres de connexion",
				JOptionPane.OK_CANCEL_OPTION);

		if (result == JOptionPane.OK_OPTION) {
			thread_checking.interrupt();
			thread_update.interrupt();

			try {
				thread_checking.join();
				thread_update.join();
			} catch (Exception e1) {
				e1.printStackTrace();
			}

			thread_checking = new ServerThreadChecking(thread_checking.getFeedback(), thread_checking.getStorage(),
					Integer.parseInt(checking_field.getText()));
			thread_checking.start();

			thread_update = new ServerThreadUpdate(thread_update.getFeedback(), thread_update.getStorage(),
					Integer.parseInt(update_field.getText()));
			thread_update.start();
		}
	}
}
