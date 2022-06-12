
package controller.emulator;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.Collection;

import javax.swing.JComboBox;

import model.Checking;
import model.Worker;
import view.util.FeedBackLabel;

/**
 * @author Th�o et Amaury
 * @version 12/06/2022
 */
public class EmulatorButtonChecking implements ActionListener{

	private FeedBackLabel feedback_output;
	private JComboBox<Worker> field;
	private Collection<Checking> queue;
	
	/**
	 * Construit un EmulatorButtonChecking � partir d'un FeedBackLabel, d'une JComboBox de Worker et d'une Collection de Checking
	 * 
	 * @param error_output un FeedBackLabel donn�
	 * @param field une JComboBox de Worker donn�e
	 * @param queue une Collection de Checking donn�e
	 */
	public EmulatorButtonChecking(
			FeedBackLabel error_output,
			JComboBox<Worker> field,
			Collection<Checking> queue) {
		super();
		this.feedback_output = error_output;
		this.field = field;
		this.queue = queue;
	}
	
	/**
	 * Permet d'entrer un nouveau pointage
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		try {
			if(field.getSelectedIndex() == -1)
				throw new IOException("Aucun utilisateur selectionné.");
			
			Checking check = new Checking(field.getItemAt(field.getSelectedIndex()));
			if(queue.contains(check))
				throw new IOException("Vous avez déjà pointé pour cette heure.");
			
			queue.add(check);
			
			//Message de feedback
			feedback_output.info("Pointage pris en compte.");
			
		}catch(Exception exc){
			feedback_output.error(exc.getMessage());
		}
	}
}