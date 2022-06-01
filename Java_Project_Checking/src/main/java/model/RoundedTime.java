package model;

import java.io.Serializable;
import java.time.LocalTime;
import java.time.temporal.ChronoUnit;

public class RoundedTime implements Serializable, Comparable<RoundedTime>{
	private int hours;
	private int minutes;
	
	public RoundedTime() {
		LocalTime time = LocalTime.now();
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

	@Override
	public int compareTo(RoundedTime o) {
		RoundedTime arg = (RoundedTime)o;
		Integer tTime = hours * 100 + minutes;
		Integer oTime = arg.hours * 100 + arg.minutes;
		return tTime.compareTo(oTime);
	}
	
	@Override
	public boolean equals(Object o) {
		RoundedTime arg = (RoundedTime)o;
		if(hours == arg.hours && minutes == arg.minutes)
			return true;
		return false;
	}
}
