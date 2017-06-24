package it.polito.tdp.rivers.model;

public class RisultatiSimulazione {
	private int NumeroGiorniSenzaErogazioneMinima;
	private int giorniDiSimulazione;
	private double CumulataOccupazioneGiornaliera;
	public RisultatiSimulazione() {
		NumeroGiorniSenzaErogazioneMinima = 0;
		giorniDiSimulazione = 0;
		CumulataOccupazioneGiornaliera = 0;
	}
	public void IncrementaNumeroGiorniSenzaErogazioneMinima(){
		NumeroGiorniSenzaErogazioneMinima++;
	}
	public void AggiornaCumulataOccupazioneGiornaliera(double Occupazione){
		CumulataOccupazioneGiornaliera=CumulataOccupazioneGiornaliera+Occupazione;
		giorniDiSimulazione++;
	}
	public int getNumeroGiorniSenzaErogazioneMinima() {
		return NumeroGiorniSenzaErogazioneMinima;
	}
	public double getOccupazioneMediaDelBacino() {
		return CumulataOccupazioneGiornaliera/giorniDiSimulazione;
	}
	
	
	

}
