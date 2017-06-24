package it.polito.tdp.rivers.model;

import java.util.ArrayList;

import it.polito.tdp.rivers.db.RiversDAO;

public class Model {
	private ArrayList<River> fiumi;
	private RiversDAO dao;
	
	public Model() {
		dao=new RiversDAO();
	}

	public ArrayList<River> getFiumi() {
		if(fiumi==null){
			fiumi=dao.getFiumi();
		}
		return fiumi;
	}
	
	public InfoFiume getInfoDiUnRiver(River fiume){
		return dao.getInfoDiUnRiver(fiume);
	}

	public RisultatiSimulazione Simula(River river, double k) {
		Simulatore simulatore =new Simulatore(dao.getInfoDiUnRiver(river),k,this);
		//inizializzo la coda degli eventi
		//gli eventi sono creati a secondo delle rilevaioni delle fiume che per ogni fiume sono caricate in modo pigro.
		if(river.getRilevamenti()==null){
			river.setRilevamenti(dao.getRilevamenti(river));
		}
		simulatore.caricaEventi(river.getRilevamenti());
		//effettuo la simulazione
		simulatore.run();
		//restitusico il risultato
		return simulatore.Results();
	}
	
	

}
