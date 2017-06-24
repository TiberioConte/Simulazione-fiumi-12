package it.polito.tdp.rivers.model;

import java.time.LocalDate;

public class Event implements Comparable<Event>{
	
	public enum EventType{
			RICHESTA_MINIMA,RICHESTA_ELEVATA;
		}
	
	private EventType type;
	private LocalDate ld;
	private double flussoInEntrata;
	
	

	public Event(EventType type, LocalDate ld, double flussoInEntrata) {
		super();
		this.type = type;
		this.ld = ld;
		this.flussoInEntrata = flussoInEntrata;
	}

	public EventType getType() {
		return type;
	}

	public void setType(EventType type) {
		this.type = type;
	}

	public LocalDate getLd() {
		return ld;
	}

	public void setLd(LocalDate ld) {
		this.ld = ld;
	}
	

	public double getFlussoInEntrata() {
		return flussoInEntrata;
	}

	public void setFlussoInEntrata(double flussoInEntrata) {
		this.flussoInEntrata = flussoInEntrata;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((ld == null) ? 0 : ld.hashCode());
		result = prime * result + ((type == null) ? 0 : type.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Event other = (Event) obj;
		if (ld == null) {
			if (other.ld != null)
				return false;
		} else if (!ld.equals(other.ld))
			return false;
		if (type != other.type)
			return false;
		return true;
	}

	@Override
	public int compareTo(Event arg0) {
		return this.getLd().compareTo(arg0.getLd());
	}
	
}
