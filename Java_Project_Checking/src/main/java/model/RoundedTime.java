package model;

import java.io.Serializable;
import java.sql.Time;
import java.time.LocalTime;
import java.time.temporal.ChronoUnit;

public class RoundedTime implements Serializable{
	private int hours;
	private int minutes;
	
	public RoundedTime() {
		LocalTime time = LocalTime.now();
		// Permet d'arrondir l'heure au quart d'heure le plus proche
		LocalTime rounded = time.truncatedTo(ChronoUnit.HOURS).plusMinutes(15 * (int)Math.ceil(time.getMinute() / 15.0));
		
		hours = rounded.getHour();
		minutes = rounded.getMinute();
	}
	
	public int getHour() {
		return hours;
	}
	
	public int getMinute() {
		return minutes;
	}
}
