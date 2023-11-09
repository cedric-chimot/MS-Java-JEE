package dynamicProject;

import java.sql.*;

public class Connexion {
	Connection cn = null;
	Statement st = null;
	PreparedStatement ps = null;
	ResultSet rs = null;
	String sql = "";
	String insertCompte = "";
	String insertUser = "";

	public Connection myCnx() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			cn = DriverManager.getConnection("jdbc:mysql://localhost/prjcommerce","root","");
			cn.setAutoCommit(false);
			st = cn.createStatement();
			System.out.println("Connection réussie !");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return cn;
	}
	
	public void fermerCnx() {
        try {
            if (rs != null) rs.close();
            if (st != null) st.close();
            if (cn != null) cn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
	
	public String verifCoordonnees(String login) {
	    String mdp = null;
	    myCnx();
	    sql = "SELECT pwd FROM compte WHERE login LIKE ?";
	    try {
	        PreparedStatement ps = cn.prepareStatement(sql);
	        ps.setString(1, login);

	        rs = ps.executeQuery();

	        if (rs.next()) {
	            mdp = rs.getString("pwd");
	        }

	        rs.close();
	        ps.close();
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }
	    return mdp;
	}

	
	public int recupIdUser() {
		int idUser = 0;
		sql = "SELECT MAX(idUsers) FROM users";
		try {
			rs = st.executeQuery(sql);
			if(rs.next()) {
				idUser = rs.getInt(1);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return idUser;
	}
	
	public void insertCompte(String login, String pwd, String type, String fname, String lname, String adresse, String tel, int age, String sexe) {
	    try {
	        // Ouvrir la connexion
	        myCnx();
	        System.out.println("Connexion ouverte");

	        // Utiliser une requête préparée pour l'insertion de l'utilisateur
	        insertUser = "INSERT INTO `users`(fname,lname,adresse,tel,age,sexe) VALUES(?,?,?,?,?,?);";
	        ps = cn.prepareStatement(insertUser);
	        ps.setString(1, fname);
	        ps.setString(2, lname);
	        ps.setString(3, adresse);
	        ps.setString(4, tel);
	        ps.setInt(5, age);
	        ps.setString(6, sexe);
	        ps.execute();
	        System.out.println("Utilisateur inséré");

	        // Récupérer l'idUsers
	        int idUser = recupIdUser();
	        System.out.println("IdUsers récupéré : " + idUser);

	        // Utiliser une requête préparée pour l'insertion du compte
	        insertCompte = "INSERT INTO `compte`(login, pwd, type, idUser) VALUES (?, ?, 's', ?);";
	        ps = cn.prepareStatement(insertCompte);
	        ps.setString(1, login);
	        ps.setString(2, pwd);
	        ps.setInt(3, idUser);
	        System.out.println("Requête préparée");

	        // Exécuter la requête
	        ps.execute();
	        System.out.println("Requête exécutée");
	        
	        // Commit de la transaction
	        cn.commit();
	    } catch (SQLException e) {
	        e.printStackTrace();
	        // Rollback en cas d'erreur
	        try {
	            if (cn != null) {
	                cn.rollback();
	            }
	        } catch (SQLException ex) {
	            ex.printStackTrace();
	        }
	    } finally {
	        // Fermer la connexion
	        fermerCnx();
	        System.out.println("Connexion fermée");
	    }
	}

	public String recupType(String login) {
		myCnx();
	    String typeUser = null;
	    String sql = "SELECT type FROM compte WHERE login = ?";
	    try {
	        PreparedStatement ps = cn.prepareStatement(sql);
	        ps.setString(1, login);

	        ResultSet rs = ps.executeQuery();

	        if (rs.next()) {
	            typeUser = rs.getString("type");
	        }

	        rs.close();
	        ps.close();
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }
	    return typeUser;
	}

	//public String ajoutProd()
	
	/*public static void main(String[] args) throws SQLException {
		// Récupérer l'objet Connection
		Connexion db = new Connexion();
		Connection cnx = null;
		cnx = db.myCnx();
		
		//db.fermerCnx();
	}*/
}
