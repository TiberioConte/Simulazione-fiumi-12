package it.polito.tdp.rivers.model;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

import it.polito.tdp.rivers.model.Event.EventType;
public class Simulatore {
	

	//solo ti serva il model durante la simulazione
	Model model;
	
	
	// Parametri di simulazione(parametri che puoi cambiare 
	//prima di avviare la simulazione ma una volta avviata
	//restano costanti)
	private double QcapienzaDelBacino;
	private double flussoMedio;
	
	// Stato del modello(variabili che durante la simulazione 
	//variano il loro valore)
	private double CacquaNelBacino;
	
	
	// Variabili di interesse(che sono il risultato della simulazione)
	private RisultatiSimulazione rs;
	
	// Lista degli eventi
	PriorityQueue<Event> queue;
	
	public Simulatore(InfoFiume infoFiume, double k, Model model) {
		QcapienzaDelBacino=k*30*infoFiume.getFlussoMedio()*60*60*24;
		flussoMedio=infoFiume.getFlussoMedio()*60*60*24;
		CacquaNelBacino=QcapienzaDelBacino/2;
		queue=new PriorityQueue<Event>();
		rs=new RisultatiSimulazione();
		this.model=model;
	}
	
	public void caricaEventi(ArrayList<Rilevamento> rilevamenti) {
		for(Rilevamento r:rilevamenti)	{
			if(Math.random()<0.05){
				queue.add(new Event (EventType.RICHESTA_ELEVATA,r.getDate(),r.getFlow()*60*60*24));
			}else{
				queue.add(new Event (EventType.RICHESTA_MINIMA,r.getDate(),r.getFlow()*60*60*24));
			}
		}
			
	}
	public void run() {
		while (!queue.isEmpty()) {
			Event e = queue.poll();
			switch (e.getType()) {
			case RICHESTA_ELEVATA:
				processRICHESTA_ELEVATAEvent(e);
				break;
			case RICHESTA_MINIMA:
				processRICHESTA_MINIMAEvent(e);
				break;
			}
		}
	}

	private void processRICHESTA_MINIMAEvent(Event e) {
		double flussoInUscita=0.8*flussoMedio;
		double deltaFlussoGiornaliero=e.getFlussoInEntrata()-flussoInUscita;
		if(deltaFlussoGiornaliero>0){
			if((CacquaNelBacino+deltaFlussoGiornaliero)<QcapienzaDelBacino){
				CacquaNelBacino=CacquaNelBacino+deltaFlussoGiornaliero;
				//System.out.println("giorno di riempimento");
				rs.AggiornaCumulataOccupazioneGiornaliera(CacquaNelBacino);
			}else{
				CacquaNelBacino=QcapienzaDelBacino;
				//System.out.println("tracimazione");
				rs.AggiornaCumulataOccupazioneGiornaliera(CacquaNelBacino);
			}
		}else{
			if((CacquaNelBacino+deltaFlussoGiornaliero)>0){
				CacquaNelBacino=CacquaNelBacino+deltaFlussoGiornaliero;
				//System.out.println("giorno di svuotamento");
				rs.AggiornaCumulataOccupazioneGiornaliera(CacquaNelBacino);
			}else{
				CacquaNelBacino=0;
				//System.out.println("non si è fornito il servizio");
				rs.IncrementaNumeroGiorniSenzaErogazioneMinima();
				rs.AggiornaCumulataOccupazioneGiornaliera(CacquaNelBacino);
			}
			
		}
		
		
	}

	private void processRICHESTA_ELEVATAEvent(Event e) {
		double flussoInUscita=8*flussoMedio;
		double deltaFlussoGiornaliero=e.getFlussoInEntrata()-flussoInUscita;
		if(deltaFlussoGiornaliero>0){
			if((CacquaNelBacino+deltaFlussoGiornaliero)<QcapienzaDelBacino){
				CacquaNelBacino=CacquaNelBacino+deltaFlussoGiornaliero;
				//System.out.println("giorno di riempimento");
				rs.AggiornaCumulataOccupazioneGiornaliera(CacquaNelBacino);
			}else{
				CacquaNelBacino=QcapienzaDelBacino;
				//System.out.println("tracimazione");
				rs.AggiornaCumulataOccupazioneGiornaliera(CacquaNelBacino);
			}
		}else{
			if((CacquaNelBacino+deltaFlussoGiornaliero)>0){
				CacquaNelBacino=CacquaNelBacino+deltaFlussoGiornaliero;
				//System.out.println("giorno di svuotamento");
				rs.AggiornaCumulataOccupazioneGiornaliera(CacquaNelBacino);
			}else{
				CacquaNelBacino=0;
				//System.out.println("non si è fornito il servizio");
				rs.IncrementaNumeroGiorniSenzaErogazioneMinima();
				rs.AggiornaCumulataOccupazioneGiornaliera(CacquaNelBacino);
			}
			
		}
		
		
	}

	public RisultatiSimulazione Results() {
		return rs;
	}
}
