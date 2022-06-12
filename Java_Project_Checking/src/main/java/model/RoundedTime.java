package model;

import java.io.Serializable;
import java.time.LocalTime;
import java.time.temporal.ChronoUnit;

/**
 * Représente une heure approximée
 * 
 * @author Theo, Amaury et Louis
 * @version 12/06/2022
 */
public class RoundedTime implements Serializable, Comparable<RoundedTime>{
	private int hours;
	private int minutes;
	
	/**
	 * Construit par défaut une heure approximée à partir de l'heure réelle
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
	 * @return Le paramétre hours du RoundedTime
	 */
	public int getHour() {
		return hours;
	}
	
	/**
	 * Retourne les minutes du RoundedTime
	 * 
	 * @return Le paramètre minutes du RoundedTime
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
	 * Retourne un booléen vrai si les paramètres de l'Object o sont les mêmes que ce RoundedTime
	 * 
	 * @return Un booléen
	 */
	@Override
	public boolean equals(Object o) {
		RoundedTime arg = (RoundedTime)o;
		return hours == arg.hours && minutes == arg.minutes;
	}
	
	/**
	 * Retourne l'objet sous forme de chaine de charactère
	 */
	@Override
	public String toString() {
		return String.format("%02d : %02d", hours, minutes);
	}
}
