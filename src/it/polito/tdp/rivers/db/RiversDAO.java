package it.polito.tdp.rivers.db;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import it.polito.tdp.rivers.model.InfoFiume;
import it.polito.tdp.rivers.model.Rilevamento;
import it.polito.tdp.rivers.model.River;
import jdk.nashorn.internal.runtime.regexp.joni.exception.InternalException;

public class RiversDAO {

	public ArrayList<River> getFiumi() {
    ArrayList<River> result = new ArrayList<River>();
		
		Connection conn = DBConnect.getConnection();
		String sql = "select id,name from river ;";

		try {
			PreparedStatement st = conn.prepareStatement(sql);
			ResultSet rs = st.executeQuery();
			
			while (rs.next()) {
			River river = new River(rs.getInt("id"), rs.getString("name"),null);
			result.add(river);
			}
			
			st.close();
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException("Error in database query", e);
		}

		return result;
	}

	public InfoFiume getInfoDiUnRiver(River fiume) {
		InfoFiume info=null;
		
		Connection conn = DBConnect.getConnection();
		String sql = "select AVG(flow) as MediaFlusso,min(day) as primaRilevazione,max(day) as ultimaRilevazione,count(day) as numeroRilevazioni "+
					"from flow "+
					"where river=? ;";

		try {
			PreparedStatement st = conn.prepareStatement(sql);
			st.setInt(1, fiume.getId());
			ResultSet rs = st.executeQuery();
			
			
			if (rs.next()) {
			 info = new InfoFiume( rs.getDate("primaRilevazione").toLocalDate(),rs.getDate("ultimaRilevazione").toLocalDate(),rs.getInt("numeroRilevazioni"),rs.getDouble("MediaFlusso"));
			}
			
			st.close();
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException("Error in database query", e);
		}
		if(info!=null){
		return info;
		}else{
			throw new InternalException("Id non presente nel db");
		}
	}

	public ArrayList<Rilevamento> getRilevamenti(River river) {
		ArrayList<Rilevamento> result = new ArrayList<Rilevamento>();
		
		Connection conn = DBConnect.getConnection();
		String sql = "select id,day,flow from flow where river=?;";

		try {
			PreparedStatement st = conn.prepareStatement(sql);
			st.setInt(1, river.getId());
			ResultSet rs = st.executeQuery();
			
			while (rs.next()) {
			Rilevamento rilevamento = new Rilevamento(rs.getInt("id"), rs.getDate("day").toLocalDate(),rs.getDouble("flow"));
			result.add(rilevamento);
			}
			
			st.close();
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException("Error in database query", e);
		}

		return result;
	}
	
}
