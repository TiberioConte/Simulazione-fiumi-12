package it.polito.tdp.rivers.model;

import java.time.LocalDate;

public class Rilevamento {
private int id;
private LocalDate date;
private double flow;
public Rilevamento(int id, LocalDate date, double flow) {
	super();
	this.id = id;
	this.date = date;
	this.flow = flow;
}
public int getId() {
	return id;
}
public void setId(int id) {
	this.id = id;
}
public LocalDate getDate() {
	return date;
}
public void setDate(LocalDate date) {
	this.date = date;
}
public double getFlow() {
	return flow;
}
public void setFlow(double flow) {
	this.flow = flow;
}
@Override
public int hashCode() {
	final int prime = 31;
	int result = 1;
	result = prime * result + id;
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
	Rilevamento other = (Rilevamento) obj;
	if (id != other.id)
		return false;
	return true;
}



}
