package controller.tabtimetable;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.DayOfWeek;
import java.util.List;

import javax.swing.JComboBox;
import javax.swing.JLabel;

import model.RoundedTime;
import model.Storage;
import model.TimeTable;
import model.Worker;

/**
 * Contrôle le menu déroulant de l'onglet "planning"
 * 
 * @author Théo, Amaury et Louis
 * @version 12/06/2022
 */
public class WorkerSelector implements ActionListener{

	private List<JLabel> labels;
	private JComboBox<Worker> workers;
	private Storage storage;
	
	/**
	 * Constructeur
	 * 
	 * @param labels
	 * @param workers
	 * @param storage
	 */
	public WorkerSelector(List<JLabel> labels, JComboBox<Worker> workers, Storage storage) {
		this.labels = labels;
		this.workers = workers;
		this.storage = storage;
	}
	
	/**
	 * Actualise l'affichage du planning d'un employé
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		TimeTable time_table = null;
		for(TimeTable t : storage.getTime_table()) {
			if(t.getWorker() == (Worker)workers.getSelectedItem()) {
				time_table = t;
			}
		}
		
		if(time_table == null)
			return;
		
		for(int i = 1; i < labels.size() + 1; i++) {
			RoundedTime[] times = time_table.getSchedule().get(DayOfWeek.of(i));
			labels.get(i - 1).setText(String.format(
				"Début : %s, Fin : %s.",
				times[0] != null ? times[0] : "aucune",
				times[1] != null ? times[1] : "aucune"
			));
		}
	}
	
}
