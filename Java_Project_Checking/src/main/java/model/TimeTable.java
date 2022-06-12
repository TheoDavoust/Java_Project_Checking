package model;

import java.io.Serializable;
import java.time.DayOfWeek;
import java.util.HashMap;
import java.util.Map;

public class TimeTable implements Serializable{
	private Worker worker;
	private Map<DayOfWeek, RoundedTime[]> schedule;
	
	public TimeTable(Worker worker) {
		super();
		this.schedule = new HashMap<DayOfWeek, RoundedTime[]>();
		this.worker = worker;
		for(int i = 1; i < 6; i++) {
			this.schedule.put(DayOfWeek.of(i), new RoundedTime[2]);
		}
	}

	public Map<DayOfWeek, RoundedTime[]> getSchedule() {
		return schedule;
	}

	public void setSchedule(Map<DayOfWeek, RoundedTime[]> schedule) {
		this.schedule = schedule;
	}

	public Worker getWorker() {
		return worker;
	}

	public void setWorker(Worker worker) {
		this.worker = worker;
	}
}