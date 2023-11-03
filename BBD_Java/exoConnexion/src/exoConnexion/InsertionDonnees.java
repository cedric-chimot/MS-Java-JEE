package exoConnexion;

import java.sql.*;

public class InsertionDonnees {

	public static void main(String[] args) throws SQLException {
		Connexion db = new Connexion();
		Connection cnx = null;
		cnx = db.myCnx();
		
		String agence = "INSERT INTO `agence`(nomAgence)" +
					"VALUES('Agence D'), ('Agence E'), ('Agence F')";
		PreparedStatement ps = cnx.prepareStatement(agence);
		ps.execute();
		
		String client ="INSERT INTO `client`(nomCli,rueCli,villeCli,numAgence)" +
				"VALUES('Toto', 'rue Toto', 'Toto City', 4),"
				+ " ('Toto', 'rue Toto', 'Toto City', 5),"
				+ " ('Toto', 'rue Toto', 'Toto City', 6)";
		PreparedStatement ps1 = cnx.prepareStatement(client);
		ps1.execute();
		
		String commande = "INSERT INTO `commande`(dateCommande,coCli)" +
				"VALUES('2023-11-02', 1),"
				+ " ('2023-11-02', 2),"
				+ " ('2023-11-02', 3)";
		PreparedStatement ps2 = cnx.prepareStatement(commande);
		ps2.execute();
		
		String facture = "INSERT INTO `facture`(dateFact)" +
				"VALUES('2023-11-02'),"
				+ " ('2023-11-02'),"
				+ " ('2023-11-02')";
		PreparedStatement ps3 = cnx.prepareStatement(facture);
		ps3.execute();
		
		String livraison = "INSERT INTO `livraison`(dateBL,numCommande,numFact)" +
				"VALUES('2023-11-04', 1, 1),"
				+ " ('2023-11-04', 2, 2),"
				+ " ('2023-11-04', 3, 3)";
		PreparedStatement ps4 = cnx.prepareStatement(livraison);
		ps4.execute();
		
		String tva = "INSERT INTO `tva`(taux)" +
				"VALUES(5),"
				+ " (10),"
				+ " (20)";
		PreparedStatement ps5 = cnx.prepareStatement(tva);
		ps5.execute();
		
		String produit = "INSERT INTO `produit`(designation,codeTVA)" +
				"VALUES('Pomme', 1),"
				+ " ('Poire', 2),"
				+ " ('Scoubidou', 3)";
		PreparedStatement ps6 = cnx.prepareStatement(produit);
		ps6.execute();
		
		String composer = "INSERT INTO `composer`(numBl,refProd,qteLivree)" +
				"VALUES(7,7, 10),"
				+ " (8, 8, 10),"
				+ " (9, 9, 12)";
		PreparedStatement ps7 = cnx.prepareStatement(composer);
		ps7.execute();
		
		String concerner = "INSERT INTO `concerner`(numCommande,refProd,qteCommandee,prixUnit)" +
				"VALUES(7, 7, 10, 3),"
				+ " (8, 8, 10, 2),"
				+ " (9, 9, 12, 4)";
		PreparedStatement ps8 = cnx.prepareStatement(concerner);
		ps8.execute();
		System.out.println("Insertion réussie !");
	}

}
