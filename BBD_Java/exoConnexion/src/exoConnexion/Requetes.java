package exoConnexion;

import java.sql.*;

public class Requetes {

	public static void main(String[] args) throws SQLException  {
		Connexion db = new Connexion();
		Connection cnx = null;
		cnx = db.myCnx();
		
		// Produits par ordre alphabétique :
		String produit1 = "SELECT * FROM `produit` ORDER BY `designation` ASC";
		Statement st = cnx.createStatement();
		ResultSet rs = st.executeQuery(produit1);
		
		System.out.println("Produits par ordre alphabétiques : \n");
		while (rs.next()) {
			System.out.println("Designation : " + rs.getString("designation"));
		}
		System.out.println("----------------------------------------------");
		
	//----------------------------------------------------------------------------------------------------------
		
		// Produit avec ID inférieur à 6 :
		String produit2 = "SELECT * FROM `produit` WHERE `refProd` < 6";
		Statement st1 = cnx.createStatement();
		ResultSet rs1 = st1.executeQuery(produit2);
		
		System.out.println("\nProduits avec référence inférieure à 6 : \n");
		while (rs1.next()) {
			System.out.println("Référence produit : " + rs1.getInt("refProd") +
					" " + "Designation : " + rs1.getString("designation"));
		}
		System.out.println("----------------------------------------------");
		
	//----------------------------------------------------------------------------------------------------------
		
		// Produit avec ID inférieur à 6 et Bl supérieur ou égal à 5 :
		String produit3 = "SELECT p.* FROM produit AS p "
		        + "JOIN composer AS c ON p.refProd = c.refProd "
		        + "JOIN livraison AS l ON c.numBL = l.numBL "
		        + "WHERE p.refProd <= 6 AND l.numBL >= 5";
		Statement st2 = cnx.createStatement();
		ResultSet rs2 = st2.executeQuery(produit3);
		
		System.out.println("\nProduits avec référence inférieure à 6  et id fournisseur supérieur à 5: \n");
		while (rs2.next()) {
			System.out.println("Référence produit : " + rs2.getInt("refProd") +
					" " + "Designation : " + rs2.getString("designation"));
		}
		System.out.println("----------------------------------------------");
		
	//----------------------------------------------------------------------------------------------------------
		
		// Produit avec ID inférieur à 5 , compris entre 6 et 8, Bl supérieur ou égal à 5 :
		String produit4 = "SELECT p.* FROM produit AS p "
		        + "JOIN composer AS c ON p.refProd = c.refProd "
		        + "JOIN livraison AS l ON c.numBL = l.numBL "
		        + "WHERE (p.refProd <= 6 OR (p.refProd >=6 AND p.refProd < 8)) AND l.numBL >= 5";
		Statement st3 = cnx.createStatement();
		ResultSet rs3 = st3.executeQuery(produit4);
		
		System.out.println("\nProduit avec ID inférieur à 5 ou compris entre 6 et 8, Bl supérieur ou égal à 5 : \n");
		while (rs3.next()) {
			System.out.println("Référence produit : " + rs3.getInt("refProd") +
					" " + "Designation : " + rs3.getString("designation"));
		}
		System.out.println("----------------------------------------------");
		
	//----------------------------------------------------------------------------------------------------------
		
		
	}

}
