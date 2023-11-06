package prjJdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Table {

	public static void main(String[] args) throws SQLException {
		Connexion db = new Connexion();
		Connection cnx = null;
		cnx = db.myCnx();
		
		String utilisateur = "CREATE TABLE IF NOT EXISTS `utilisateur`("
				+ "numero INT AUTO_INCREMENT, "
				+ "nom varchar(30), "
				+ "prenom varchar(30), "
				+ "sexe varchar(1), "
				+ "type varchar(1),"
				+ "PRIMARY KEY(numero)) ENGINE=InnoDB;";
		PreparedStatement ps = cnx.prepareStatement(utilisateur);
		ps.execute();
				
	}

}
