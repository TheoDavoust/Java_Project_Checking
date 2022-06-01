package model;

public class IdTimeChecking implements Comparable<IdTimeChecking>{
	private Integer id;
	private RoundedTime time;
	
	public IdTimeChecking(int id) {
		this.id = id;
		this.time = new RoundedTime();
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public RoundedTime getTime() {
		return time;
	}

	public void setTime(RoundedTime time) {
		this.time = time;
	}
	
	@Override
	public boolean equals(Object o) {
		IdTimeChecking arg = (IdTimeChecking)o;
		return (arg.time.equals(arg.time) && id.equals(arg.id));
	}

	@Override
	public int compareTo(IdTimeChecking o) {
		return this.time.compareTo(o.time);
	}
}
