package gui;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import waage.Artikel;
import waage.Messung;
import waage.Waage;

public class DatabaseDAO extends Database{
	
	private Connection db;
	Object[] row = new Object[100];
	int rowNumber;
	
	public void createArtikel(Artikel a) {
					
		try {
			
			Statement st = this.getDb().createStatement();
			String query = "insert into artikel (artikelname,stückgewicht,menge) values('"+a.getProduktName()+"','"+a.getStueckGewicht()+"','"+a.getMenge()+"')";
			st.executeUpdate(query);

		} catch (Exception e) {	
			
			e.printStackTrace();
			
		}		

	}
	
	public void createWaage(Waage w) {
		try {
			Statement st = this.getDb().createStatement();
			String query = "insert into waage (waagename,model,ipnummer, portnummer) values('"+w.getName()+"','"+w.getModel()+"','"+w.getIpNummer()+"','"+w.getPortNummer()+"')";
		st.executeUpdate(query);
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
	}
	
	public void createMessung(Messung m) {
		try {
			Statement st = this.getDb().createStatement();
			String query = "insert into messung (stückzahl,gewicht, artikelid, waageid,datum) "
					+ "values('"+m.getStueckZahl()+"','"+m.getGewicht()+"','"+m.getArtikelId().getArtikelId()+"','"+m.getWaageId().getWaageId()+"','"+m.getGewichtDatum()+"')";
		st.executeUpdate(query);
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
	}
	
	// Datensatz artikel ausgeben
	public List<Object[]> ausgeben() throws SQLException {
		List<Object[]> results = new ArrayList<>();
			query = "SELECT * FROM artikel";
		
		try {
			con = DriverManager.getConnection(url, benutzer, password);
			stmt = con.createStatement();
			rs = stmt.executeQuery(query);
			int columns = rs.getMetaData().getColumnCount();
			for (int i = 1; i <= columns; i++) {
				System.out.print(String.format("%-15s", rs.getMetaData().getColumnLabel(i)));
			}
			System.out.println();
			System.out.println("--------------------------------------------------------");
			rowNumber = 1;
			while (rs.next()) {
				for (int i = 1; i <= columns; i++) {					
					System.out.print(String.format("%-15s", rs.getString(i)));	
					  
				}
				System.out.println();						  
				  results.add(new Object [] {rowNumber++,rs.getString("artikelid"),rs.getString("artikelname"),rs.getString("stückgewicht"),rs.getString("menge")});					  
			}
					
			rs.close();
			stmt.close();
			
		} catch (Exception e) {	
			
			e.printStackTrace();
			
		}
		return results;

	}
	
	// Datensatz artikel delete
	public List<Object[]> artikelDelete(int id) throws SQLException {
		List<Object[]> results = new ArrayList<>();
			query = "DELETE FROM artikel WHERE artikelid = 4";
			con = DriverManager.getConnection(url, benutzer, password);
			stmt = con.prepareStatement(query);	
			//new Object[] {("artikelid")}
			stmt.executeUpdate(query);
											
			stmt.close();
			return results;
		} 
	
	// Datensatz der Waage
public List<Object[]> ausgebenWaage() throws SQLException {
	List<Object[]> results = new ArrayList<>();
		query = "SELECT * FROM waage";
		con = DriverManager.getConnection(url, benutzer, password);

  try {
		stmt = con.createStatement();
		rs = stmt.executeQuery(query);
		int columns = rs.getMetaData().getColumnCount();
		for (int i = 1; i <= columns; i++) {
	System.out.print(String.format("%-15s",rs.getMetaData().getColumnLabel(i)));
			}
		
	System.out.println();
	System.out.println("-----------------------------------------------------");
	
			rowNumber = 1;
			while (rs.next()) {
				for (int i = 1; i <= columns; i++) {					
					System.out.print(String.format("%-15s", rs.getString(i)));						  
			}
				
	System.out.println();	
	
		    results.add(new Object [] {rowNumber++,rs.getString("waageid"),
		    		rs.getString("waagename"),rs.getString("model"),
		    		rs.getString("ipnummer"),rs.getString("portnummer")});		    
			}	
			
			rs.close();
			stmt.close();
			
		} catch (Exception e) {			
			e.printStackTrace();			
		}
		return results;
	}
	
	// Datensatz artikel ausgeben
	public List<Object[]> ausgebenMessung() throws SQLException {
		List<Object[]> results = new ArrayList<>();
			query = "SELECT * FROM messung";
			con = DriverManager.getConnection(url, benutzer, password);

		try {
			stmt = con.createStatement();
			rs = stmt.executeQuery(query);
			int columns = rs.getMetaData().getColumnCount();
			for (int i = 1; i <= columns; i++) {
				System.out.print(String.format("%-15s", rs.getMetaData().getColumnLabel(i)));
			}
			System.out.println();
			System.out.println("-------------------------------------------------------------------------------");
			rowNumber = 1;
			while (rs.next()) {
				for (int i = 1; i <= columns; i++) {					
					System.out.print(String.format("%-15s", rs.getString(i)));	
					  
				}
				System.out.println();						  
				  results.add(new Object [] {rowNumber++,rs.getString("messungid"),rs.getString("datum"),rs.getString("stückzahl"),rs.getString("gewicht"), rs.getString("artikelid"), rs.getString("waageid")});					  
			}
					
			rs.close();
			stmt.close();
			
		} catch (Exception e) {	
			
			e.printStackTrace();
			
		}
		return results;

	}
	
public List<Object[]> ausgebenErgebnis(){
	List<Object[]> results = new ArrayList<>();
		query = "SELECT  messung.messungid, messung.datum, messung.stückzahl, "
				+ "messung.gewicht, artikel.artikelname, waage.waagename\r\n"
				+ "				FROM messung\r\n"
				+ "				INNER JOIN artikel\r\n"
				+ "				ON artikel.artikelid = messung.artikelid\r\n"
				+ "				INNER JOIN waage\r\n"
				+ "				ON waage.waageid = messung.waageid;";
try {
	con = DriverManager.getConnection(url, benutzer, password);
	stmt = con.createStatement();
	rs = stmt.executeQuery(query);
	int columns = rs.getMetaData().getColumnCount();
	for (int i = 1; i <= columns; i++) {
	System.out.print(String.format("%-23s",rs.getMetaData().getColumnLabel(i)));
		}
	System.out.println();
	System.out.println("--------------------------------------------------------------------------------------------------------------------------------");
	rowNumber = 1;
	while (rs.next()) {
		for (int i = 1; i <= columns; i++) {					
			System.out.print(String.format("%-23s", rs.getString(i)));		  
			}
			System.out.println();						  
			results.add(new Object [] {rowNumber++,rs.getString("messungid"),
						 rs.getString("datum"), rs.getString("stückzahl"), 
						 rs.getString("gewicht"), rs.getString("artikelname"),
						 rs.getString("waagename")});					  
			}					
			rs.close();
			stmt.close();
	} catch (Exception e) {			
		e.printStackTrace();
	}
	  return results;	
}

	public Connection getDb() {
		
		if(this.db == null) {			
			this.db = this.con;
		}
		
		return db;
				
	}

	public void setDb(Connection db) {
		this.db = db;
	}

}

