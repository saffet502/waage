package gui;

import java.sql.SQLException;

public class GUIMain {
	
	public static void main(String[] args) throws SQLException, ClassNotFoundException {
		
        new Hauptmenü_Waage();
        new Database().kontaktieren();
	
	}

}
