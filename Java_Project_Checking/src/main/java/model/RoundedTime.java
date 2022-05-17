package model;

import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.ObjectStreamException;
import java.io.Serializable;
import java.io.ObjectInputStream.GetField;
import java.time.LocalTime;
import java.time.temporal.ChronoUnit;

public class RoundedTime implements Serializable{
	private int hours;
	private int minutes;
	
	public RoundedTime() {
		LocalTime time = LocalTime.now();
		LocalTime rounded = time.truncatedTo(ChronoUnit.HOURS).plusMinutes(15 * (time.getMinute() / 15));
		
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
