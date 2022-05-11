package model;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.temporal.ChronoUnit;

public class RoundedTime {
	private int hours;
	private int minutes;
	private LocalDate date;
	
	public RoundedTime() {
		LocalTime time = LocalTime.now();
		LocalTime rounded = time.truncatedTo(ChronoUnit.HOURS).plusMinutes(15 * (time.getMinute() / 15));
		
		date = LocalDate.now();
		hours = rounded.getHour();
		minutes = rounded.getMinute();
	}
	
	public int getHour() {
		return hours;
	}
	
	public int getMinute() {
		return minutes;
	}

	public LocalDate getDate() {
		return date;
	}
	
}
