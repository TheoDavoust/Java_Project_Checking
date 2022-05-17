package model;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;
import java.util.Map;

public class Database implements Serializable{
	private Map<LocalDate, Map<Worker, List<RoundedTime>>> storage;
	private Map<Worker, RoundedTime> sumOvertime;
}
