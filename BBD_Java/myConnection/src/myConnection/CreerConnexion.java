package myConnection;

import java.sql.*;

public class CreerConnexion {

	public Connection myCnx() {
		Connection cn = null;
		// Création de la chaine de connection
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			cn = DriverManager.getConnection("jdbc:mysql://localhost/films","root","");
			System.out.println("Connection réussie !");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return cn;
	}
	
	public static void main(String[] args) throws SQLException {
		// Récupérer l'objet Connection
		CreerConnexion db = new CreerConnexion();
		Connection cnx = null;
		cnx = db.myCnx();
		// Lancer requêtes
		
		// "PreparedStatement" sans retour de résultats
		
		// Déclaration : 
		String str = "";
		//PreparedStatement ps;
		Statement st; // pour les requêtes d'interrogation
		ResultSet rs; // jeu de résultat
		
		/*str = "insert into film(titre,annee,nbSpectateurs,idRealisateur,idGenre) values('Star Wars 2', '1977', 1500000, 22, 5)";
		ps = cnx.prepareStatement(str);
		ps.execute();*/
		
		// "Statement" avec retour de résultats : Le résultat est TOUJOURS un tableau
		
		// Requêtes d'interrogation
		
		str = "select * from film";
		st = cnx.createStatement();
		rs = st.executeQuery(str);
		
		// Parcourir le résultat stocké dans "rs"
		
		while (rs.next()) {
			System.out.println("Numéro : " + rs.getInt("id") + ", Le titre : " + rs.getString("titre"));
		}
				
	}

}
