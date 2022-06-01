
package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.Set;

import javax.swing.JTextField;

import model.IdTimeChecking;
import view.FeedBackLabel;

public class EmulatorButtonChecking implements ActionListener{

	private FeedBackLabel feedback_output;
	private JTextField field;
	private Set<IdTimeChecking> stack;
	
	public EmulatorButtonChecking(
			FeedBackLabel error_output,
			JTextField field,
			Set<IdTimeChecking> stack) {
		super();
		this.feedback_output = error_output;
		this.field = field;
		this.stack = stack;
	}
	
	public void displayError(String str) {
		feedback_output.error(str);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		String text = field.getText();
		try {
			if(text.isBlank())
				throw new IOException("Le champ de texte est vide.");
			
			if(!stack.add(new IdTimeChecking(Integer.parseInt(text))))
				throw new IOException("Vous avez déjà pointé pour cette heure.");
			
			//TODO Appel de la routine d'envoie
			
			//Message de feedback
			feedback_output.success("Vous avez pointé.");
			
		}catch(Exception exc){
			displayError(exc.getMessage());
			exc.printStackTrace();
		}
	}
}