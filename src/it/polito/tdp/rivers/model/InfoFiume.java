package it.polito.tdp.rivers.model;

import java.time.LocalDate;

public class InfoFiume {
	private LocalDate DataPrimaMisurazione;
	private LocalDate DataUtimaMisurazione;
	private int NumeroTotaleRilevazioni;
	private double flussoMedio;
	public InfoFiume(LocalDate dataPrimaMisurazione, LocalDate dataUtimaMisurazione, int numeroTotaleRilevazioni,
			double flussoMedio) {
		super();
		DataPrimaMisurazione = dataPrimaMisurazione;
		DataUtimaMisurazione = dataUtimaMisurazione;
		NumeroTotaleRilevazioni = numeroTotaleRilevazioni;
		this.flussoMedio = flussoMedio;
	}
	public LocalDate getDataPrimaMisurazione() {
		return DataPrimaMisurazione;
	}
	public void setDataPrimaMisurazione(LocalDate dataPrimaMisurazione) {
		DataPrimaMisurazione = dataPrimaMisurazione;
	}
	public LocalDate getDataUtimaMisurazione() {
		return DataUtimaMisurazione;
	}
	public void setDataUtimaMisurazione(LocalDate dataUtimaMisurazione) {
		DataUtimaMisurazione = dataUtimaMisurazione;
	}
	public int getNumeroTotaleRilevazioni() {
		return NumeroTotaleRilevazioni;
	}
	public void setNumeroTotaleRilevazioni(int numeroTotaleRilevazioni) {
		NumeroTotaleRilevazioni = numeroTotaleRilevazioni;
	}
	public double getFlussoMedio() {
		return flussoMedio;
	}
	public void setFlussoMedio(double flussoMedio) {
		this.flussoMedio = flussoMedio;
	}
	@Override
	public String toString() {
		return "DataPrimaMisurazione=" + DataPrimaMisurazione + ", DataUtimaMisurazione="
				+ DataUtimaMisurazione + ", NumeroTotaleRilevazioni=" + NumeroTotaleRilevazioni + ", flussoMedio="
				+ flussoMedio;
	}
	
}
