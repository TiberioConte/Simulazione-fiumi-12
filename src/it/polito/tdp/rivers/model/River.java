package it.polito.tdp.rivers.model;

import java.util.ArrayList;

public class River {
	private int id;
	private String nome;
	private ArrayList<Rilevamento> rilevamenti;
	
	
	
	public River(int id, String nome, ArrayList<Rilevamento> rilevamenti) {
		super();
		this.id = id;
		this.nome = nome;
		this.rilevamenti = rilevamenti;
	}
	public ArrayList<Rilevamento> getRilevamenti() {
		return rilevamenti;
	}
	public void setRilevamenti(ArrayList<Rilevamento> rilevamenti) {
		this.rilevamenti = rilevamenti;
	}

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
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
		River other = (River) obj;
		if (id != other.id)
			return false;
		return true;
	}
	@Override
	public String toString() {
		return nome;
	}
}
	