package gui;

import java.sql.SQLException;

public class GUIMain {
	
	public static void main(String[] args) throws SQLException, ClassNotFoundException {
		
        new Hauptmen�_Waage();
        new Database().kontaktieren();
	
	}

}
