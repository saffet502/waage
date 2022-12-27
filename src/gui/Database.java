package gui;

	import java.sql.Connection;
	import java.sql.DriverManager;
	import java.sql.PreparedStatement;
	import java.sql.ResultSet;
	import java.sql.SQLException;
	import java.sql.Statement;

	public class Database {

		Connection con;
		Statement stmt;
		PreparedStatement ps;
		String query;
		ResultSet rs;
		String url = "jdbc:postgresql://localhost:5432/IndustrieWaage";
		String benutzer = "postgres";
		String password = "admin";
		
		
		// die Verbindung mit Datenbank 
		public void  kontaktieren() throws ClassNotFoundException {
			Class.forName("org.postgresql.Driver");
			try {
			   con = DriverManager.getConnection(url, benutzer, password);
			   System.out.println("Verbunden");
			   System.out.println();
			} catch (SQLException e) {
			   System.out.println("Konnte keine Verbindung hergestellt werden");
			}

		}
				
	}
	
	
	


