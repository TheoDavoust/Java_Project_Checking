package model;

import java.io.Serializable;
import java.time.LocalTime;
import java.time.temporal.ChronoUnit;

/**
 * Repr�sente une heure approxim�e
 * 
 * @author Th�o et Amaury
 * @version 12/06/2022
 */
public class RoundedTime implements Serializable, Comparable<RoundedTime>{
	private int hours;
	private int minutes;
	
	/**
	 * Construit par d�faut une heure approxim�e � partir de l'heure r�elle
	 */
	public RoundedTime() {
		this(LocalTime.now());
	}
	
	public RoundedTime(LocalTime time) {
		LocalTime rounded = time.truncatedTo(ChronoUnit.HOURS).plusMinutes(15 * (int)Math.round(time.getMinute() / 15.0));
		
		hours = rounded.getHour();
		minutes = rounded.getMinute();
	}
	
	/**
	 * Retourne l'heure du RoundedTime
	 * 
	 * @return Le param�tre hours du RoundedTime
	 */
	public int getHour() {
		return hours;
	}
	
	/**
	 * Retourne les minutes du RoundedTime
	 * 
	 * @return Le param�tre minutes du RoundedTime
	 */
	public int getMinute() {
		return minutes;
	}

	/**
	 * Permet de comparer deux RoundedTime
	 */
	@Override
	public int compareTo(RoundedTime o) {
		RoundedTime arg = (RoundedTime)o;
		Integer tTime = hours * 100 + minutes;
		Integer oTime = arg.hours * 100 + arg.minutes;
		return tTime.compareTo(oTime);
	}
	
	/**
	 * Retourne un bool�en vrai si les param�tres de l'Object o sont les m�mes que ce RoundedTime
	 * 
	 * @return Un bool�en
	 */
	@Override
	public boolean equals(Object o) {
		RoundedTime arg = (RoundedTime)o;
		return hours == arg.hours && minutes == arg.minutes;
	}
	
	@Override
	public String toString() {
		return String.format("%02d : %02d", hours, minutes);
	}
}
