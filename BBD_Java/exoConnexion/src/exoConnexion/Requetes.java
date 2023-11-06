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
		
		// Produit avec ID inférieur à 6 et fournisseur supérieur ou égal à 3 :
		String produit3 = "SELECT p.* FROM produit AS p "
		        + "JOIN composer AS c ON p.refProd = c.refProd "
		        + "JOIN livraison AS l ON c.numBL = l.numBL "
		        + "JOIN commande AS com ON l.numCommande = com.numCommande "
		        + "JOIN fournisseur AS f ON com.numF = f.numF "
		        + "WHERE p.refProd <= 6 AND com.numF >= 3";
		Statement st2 = cnx.createStatement();
		ResultSet rs2 = st2.executeQuery(produit3);
		
		System.out.println("\nProduits avec référence inférieure à 6  et id fournisseur supérieur à 3: \n");
		while (rs2.next()) {
			System.out.println("Référence produit : " + rs2.getInt("refProd") +
					" " + "Designation : " + rs2.getString("designation"));
		}
		System.out.println("----------------------------------------------");
		
	//----------------------------------------------------------------------------------------------------------
		
		// Produit avec ID inférieur à 5 , compris entre 7 et 9, fournisseur supérieur ou égal à 4 :
		String produit4 = "SELECT p.* FROM produit AS p "
				+ "JOIN composer AS c ON p.refProd = c.refProd "
		        + "JOIN livraison AS l ON c.numBL = l.numBL "
		        + "JOIN commande AS com ON l.numCommande = com.numCommande "
		        + "JOIN fournisseur AS f ON com.numF = f.numF "
		        + "WHERE (p.refProd <= 5 OR (p.refProd >=6 AND p.refProd < 8)) AND f.numF >= 4";
		Statement st3 = cnx.createStatement();
		ResultSet rs3 = st3.executeQuery(produit4);
		
		System.out.println("\nProduits avec ID inférieur à 5 ou compris entre 6 et 8, fournisseur supérieur ou égal à 5 : \n");
		while (rs3.next()) {
			System.out.println("Référence produit : " + rs3.getInt("refProd") +
					" " + "Designation : " + rs3.getString("designation"));
		}
		System.out.println("----------------------------------------------");
		

	//----------------------------------------------------------------------------------------------------------
			
		// Produits avec ID inférieur à 5 ou compris entre 6 et 8 ou supérieur ou égal à 9
		String produit8 = "SELECT * "
				+ "FROM produit "
				+ "WHERE refProd < 5 OR (refProd >= 6 AND refProd < 8) OR refProd >= 9;";
		Statement st8 = cnx.createStatement();
		ResultSet rs8= st8.executeQuery(produit8);
		
		System.out.println("\nProduits avec ID inférieur à 5 ou compris entre 6 et 8 ou supérieur ou égal à 9 : \n");
		while (rs8.next()) {
			System.out.println("Référence produit : " + rs8.getInt("refProd") +
					" " + "Designation : " + rs8.getString("designation"));
		}
		System.out.println("----------------------------------------------");
		
	//----------------------------------------------------------------------------------------------------------
		
		// Produits commençant par 'E'
		String produit5 = "SELECT * FROM produit WHERE designation LIKE 'E%'";
		Statement st4 = cnx.createStatement();
		ResultSet rs4 = st4.executeQuery(produit5);
		
		System.out.println("\nProduits commençant par 'E' : \n");
		while (rs4.next()) {
			System.out.println("Référence produit : " + rs4.getInt("refProd") +
					" " + "Designation : " + rs4.getString("designation"));
		}
		System.out.println("----------------------------------------------");
		
	//----------------------------------------------------------------------------------------------------------
	
		// Produits commençant par 'E'
		String produit6 = "SELECT * FROM produit WHERE designation LIKE '%e'";
		Statement st5 = cnx.createStatement();
		ResultSet rs5 = st5.executeQuery(produit6);
		
		System.out.println("\nProduits se terminant par 'E' : \n");
		while (rs5.next()) {
			System.out.println("Référence produit : " + rs5.getInt("refProd") +
					" " + "Designation : " + rs5.getString("designation"));
		}
		System.out.println("----------------------------------------------");
	
	//----------------------------------------------------------------------------------------------------------
		
		// Produits contenant un 'E'
		String produit7 = "SELECT * FROM produit "
				+ "WHERE MID(designation, 2, 1) = 'E'";
		Statement st6 = cnx.createStatement();
		ResultSet rs6 = st6.executeQuery(produit7);
		
		System.out.println("\nProduits avec un 'E' en deuxième lettre : \n");
		while (rs6.next()) {
			System.out.println("Référence produit : " + rs6.getInt("refProd") +
					" " + "Designation : " + rs6.getString("designation"));
		}
		System.out.println("----------------------------------------------");
		
	//----------------------------------------------------------------------------------------------------------
		
		// Client avec nom d'agence commençant par 'A' mais sans 'N' en deuxième lettre
		String client = "SELECT * FROM client c "
				+ "INNER JOIN agence a ON c.numAgence = a.numAgence "
				+ "WHERE nomAgence LIKE 'A%' AND nomAgence NOT LIKE '_n%';";
		Statement st7 = cnx.createStatement();
		ResultSet rs7 = st7.executeQuery(client);
		
		System.out.println("\nClient avec nom d'agence commençant par 'A' mais sans 'N' en deuxième lettre : \n");
		while (rs7.next()) {
			System.out.println("Nom client : " + rs7.getString("nomCli") +
					" " + "Agence : " + rs7.getString("nomAgence"));
		}
		System.out.println("----------------------------------------------");
			
	}

}
