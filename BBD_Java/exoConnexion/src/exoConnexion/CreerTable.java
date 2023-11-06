package exoConnexion;

import java.sql.*;

public class CreerTable {
	
	public static void main(String[] args) throws SQLException {
		Connexion db = new Connexion();
		Connection cnx = null;
		cnx = db.myCnx();
		
		String agence = "CREATE TABLE IF NOT EXISTS `agence`(" +
			    "`numAgence` INT NOT NULL AUTO_INCREMENT, " +
			    "`nomAgence` VARCHAR(50), " +
			    "PRIMARY KEY (`numAgence`)) ENGINE=InnoDB;";
		PreparedStatement ps = cnx.prepareStatement(agence);
		ps.execute();
					
		String client = "CREATE TABLE IF NOT EXISTS `client`(" +
			    "`coCli` INT NOT NULL AUTO_INCREMENT, " +
			    "`nomCli` VARCHAR(50), " +
			    "`rueCli` VARCHAR(50), " +
			    "`villeCli` VARCHAR(50), " +
			    "`numAgence` INT, " +
			    "PRIMARY KEY (`coCli`), " +
			    "FOREIGN KEY (`numAgence`) REFERENCES `agence`(`numAgence`)) ENGINE=InnoDB;";
		PreparedStatement ps1 = cnx.prepareStatement(client);
		ps1.execute();	
					
		String facture = "CREATE TABLE IF NOT EXISTS `facture`(" +
			    "`numFact` INT NOT NULL AUTO_INCREMENT," +
			    "`dateFact` DATE," +
			    "PRIMARY KEY (`numFact`)) ENGINE=InnoDB;";
		PreparedStatement ps2 = cnx.prepareStatement(facture);
		ps2.execute();
					
		String tva = "CREATE TABLE IF NOT EXISTS `tva`(" +
			    "`codeTVA` INT NOT NULL AUTO_INCREMENT," +
			    "`taux` INT," +
			    "PRIMARY KEY (`codeTVA`)) ENGINE=InnoDB;";
		PreparedStatement ps3 = cnx.prepareStatement(tva);
		ps3.execute();
					
		String commande = "CREATE TABLE IF NOT EXISTS `commande`(" +
			    "`numCommande` INT NOT NULL AUTO_INCREMENT, " +
			    "`dateCommande` DATE, " +
			    "`coCli` INT, " +
			    "`numF` INT, " +
			    "PRIMARY KEY (`numCommande`), " +
			    "FOREIGN KEY (`coCli`) REFERENCES `client`(`coCli`))"+
			    "FOREIGN KEY (`numF`) REFERENCES `fournisseur`(`numF`)) ENGINE=InnoDB;";
		PreparedStatement ps4 = cnx.prepareStatement(commande);
		ps4.execute();
					
		String livraison = "CREATE TABLE IF NOT EXISTS `livraison`(" +
			    "`numBL` INT NOT NULL AUTO_INCREMENT, " +
			    "`dateBL` DATE, " +
			    "`numCommande` INT, " +
			    "`numFact` INT, " +
			    "`numFour` INT, " +
			    "PRIMARY KEY (`numBL`), " +
			    "FOREIGN KEY (`numCommande`) REFERENCES `commande`(`numCommande`)," +
			    "FOREIGN KEY (`numFact`) REFERENCES `facture`(`numFact`)) ENGINE=InnoDB;";
		PreparedStatement ps5 = cnx.prepareStatement(livraison);
		ps5.execute();
					
		String produit = "CREATE TABLE IF NOT EXISTS `produit`(" +
			    "`refProd` INT NOT NULL AUTO_INCREMENT, " +
			    "`designation` varchar(50), " +
			    "`codeTVA` INT, " +
			    "PRIMARY KEY (`refProd`), " +
			    "FOREIGN KEY (`codeTVA`) REFERENCES `tva`(`codeTVA`)) ENGINE=InnoDB;";
		PreparedStatement ps6 = cnx.prepareStatement(produit);
		ps6.execute();
					
		String composer = "CREATE TABLE IF NOT EXISTS `composer`(" +
			    "`numBL` INT, " +
			    "`refProd` INT, " +
			    "`qteLivree` INT, " +
			    "PRIMARY KEY (`numBL`, `refProd`), " +
			    "FOREIGN KEY (`numBL`) REFERENCES `livraison`(`numBL`)," +
			    "FOREIGN KEY (`refProd`) REFERENCES `produit`(`refProd`)) ENGINE=InnoDB;";
		PreparedStatement ps7 = cnx.prepareStatement(composer);
		ps7.execute();
					
		String concerner = "CREATE TABLE IF NOT EXISTS `concerner`(" +
			    "`numCommande` INT, " +
			    "`refProd` INT, " +
			    "`qteCommandee` INT, " +
			    "`prixUnit` INT, " +
			    "PRIMARY KEY (`numCommande`, `refProd`), " +
			    "FOREIGN KEY (`numCommande`) REFERENCES `commande`(`numCommande`)," +
			    "FOREIGN KEY (`refProd`) REFERENCES `produit`(`refProd`)) ENGINE=InnoDB;";
		PreparedStatement ps8 = cnx.prepareStatement(concerner);
		ps8.execute();
		
		String fournisseur = "CREATE TABLE IF NOT EXISTS `fournisseur`(" +
			    "`numF` INT NOT NULL AUTO_INCREMENT, " +
			    "`nomF` varchar(50), " +
			    "PRIMARY KEY (`numF`) ENGINE=InnoDB;";
		PreparedStatement ps9 = cnx.prepareStatement(fournisseur);
		ps9.execute();
	}

}
