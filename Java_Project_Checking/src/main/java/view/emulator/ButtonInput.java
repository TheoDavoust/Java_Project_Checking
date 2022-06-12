package view.emulator;

import java.awt.Font;
import java.util.Collection;

import javax.swing.JButton;
import javax.swing.JComboBox;

import controller.emulator.EmulatorButtonChecking;
import model.Checking;
import model.Worker;
import view.util.FeedBackLabel;

/**
 * Un type de bouton
 * 
 * @author Théo, Amaury et Louis
 * @version 12/06/2022
 */
public class ButtonInput extends JButton{
	private FeedBackLabel error_label;
	private JComboBox<Worker> dropdown;
	private Collection<Checking> queue;
	
	/**
	 * Construit un ButtonInput à partir d'un FeedBackLabel, d'une JComboBox de Worker et d'une Collection de Checking donn�s puis l'initialise
	 * 
	 * @param error_label un FeedBackLabel donné
	 * @param text_field une JComboBox de Worker donnée
	 * @param queue une Collection de Checking donnée
	 */
	public ButtonInput(FeedBackLabel error_label, JComboBox<Worker> text_field, Collection<Checking> queue) {
		super();
		this.error_label = error_label;
		this.dropdown = text_field;
		this.queue = queue;
		
		init();
	}
	
	/**
	 * Initialise ButtonInput sur da police, son texte et son controller
	 */
	public void init() {
		this.setFont(new Font("Arial", Font.PLAIN, 32));
		this.setText("Valider");
		this.addActionListener(new EmulatorButtonChecking(error_label, dropdown, queue));
	}
}
