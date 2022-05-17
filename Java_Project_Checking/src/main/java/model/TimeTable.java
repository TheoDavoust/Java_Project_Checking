package model;

import java.io.Serializable;
import java.time.DayOfWeek;
import java.util.Map;

public class TimeTable implements Serializable{
	private Worker worker;
	private Map<DayOfWeek, RoundedTime[]> schedule;
	
	public TimeTable() {
		super();
		this.schedule = schedule;
	}

	public Map<DayOfWeek, RoundedTime[]> getSchedule() {
		return schedule;
	}

	public void setSchedule(Map<DayOfWeek, RoundedTime[]> schedule) {
		this.schedule = schedule;
	}
}