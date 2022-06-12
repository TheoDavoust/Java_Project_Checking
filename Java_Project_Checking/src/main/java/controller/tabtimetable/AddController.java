package controller.tabtimetable;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.time.DayOfWeek;
import java.time.LocalTime;

import javax.swing.AbstractAction;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import model.RoundedTime;
import model.Storage;
import model.TimeTable;
import model.Worker;

/**
 * Contrôle les buttons de la page planning
 * 
 * @author Théo, Amaury et Louis
 * @version 12/06/2022
 */
public class AddController extends AbstractAction{

	private JComboBox<Worker> workers;
	private DayOfWeek day;
	private Storage storage;
	
	/**
	 * Constructeur
	 * 
	 * @param workers
	 * @param day
	 * @param storage
	 */
	public AddController(JComboBox<Worker> workers, DayOfWeek day, Storage storage) {
		super("Modifier");
		this.workers = workers;
		this.day = day;
		this.storage = storage;
	}
	
	/**
	 * Ajoute ou modifie une horaire dans l'emploi du temps
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		if(workers.getSelectedIndex() == -1)
			return;
		
		/* Find existing TimeTable */
		TimeTable time_table = null;
		for(TimeTable t : storage.getTime_table()) {
			if(t.getWorker() == (Worker)workers.getSelectedItem()) {
				time_table = t;
			}
		}
		
		/* Create view */
		JPanel panel = new JPanel();
		JTextField begin_hours = new JTextField();
		JTextField begin_minutes = new JTextField();
		JTextField end_hours = new JTextField();
		JTextField end_minutes = new JTextField();

		JLabel begin_hours_label = new JLabel("Heure de début");
		JLabel begin_minutes_label = new JLabel("Quart d'heure de début");
		JLabel end_hours_label = new JLabel("Heure de départ");
		JLabel end_minutes_label = new JLabel("Quart d'heure de départ");
		
		panel.setLayout(new GridLayout(4, 2));
		panel.add(begin_hours_label);
		panel.add(begin_hours);
		panel.add(begin_minutes_label);
		panel.add(begin_minutes);
		panel.add(end_hours_label);
		panel.add(end_hours);
		panel.add(end_minutes_label);
		panel.add(end_minutes);
		
		
		if(time_table != null) {
			RoundedTime[] times = time_table.getSchedule().get(day);
			if(times[0] != null) {
				begin_hours.setText(String.format("%d", times[0].getHour()));
				begin_minutes.setText(String.format("%d", times[0].getMinute()));				
			}
			if(times[1] != null) {
				end_hours.setText(String.format("%d", times[1].getHour()));
				end_minutes.setText(String.format("%d", times[1].getMinute()));				
			}
		}
		
		int result = JOptionPane.showConfirmDialog(null, panel, "Modification d'horaires",
				JOptionPane.OK_CANCEL_OPTION);

		if (result == JOptionPane.OK_OPTION) {
			RoundedTime begin_time = new RoundedTime(
				LocalTime.of(Integer.parseInt(begin_hours.getText()), 
						Integer.parseInt(begin_minutes.getText()))
			);
			
			RoundedTime end_time = new RoundedTime(
				LocalTime.of(Integer.parseInt(end_hours.getText()),
					Integer.parseInt(end_minutes.getText()))
			);
			
			if(time_table == null) {
				time_table = new TimeTable((Worker)workers.getSelectedItem());
				storage.getTime_table().add(time_table);
			}
			
			RoundedTime[] time = time_table.getSchedule().get(day);
			time[0] = begin_time;
			time[1] = end_time;
			
			/* Mise à jour de l'affichage */
			workers.getActionListeners()[0].actionPerformed(null);
		}
	}
}
