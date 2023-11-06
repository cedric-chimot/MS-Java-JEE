package prjJdbc;

import java.sql.*;

public class Connexion {

	public Connection myCnx() {
		Connection cn = null;
		// Création de la chaine de connection
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			cn = DriverManager.getConnection("jdbc:mysql://localhost/jdbc","root","");
			//System.out.println("Connection réussie !");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return cn;
	}

}
