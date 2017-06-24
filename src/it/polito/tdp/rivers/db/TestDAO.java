package it.polito.tdp.rivers.db;

import it.polito.tdp.rivers.model.River;

public class TestDAO {

	public static void main(String[] args) {
		RiversDAO dao=new RiversDAO();
		//System.out.println(dao.getFiumi());
		River river=new River(1,null,null);
		System.out.println(dao.getRilevamenti(river));

	}

}
