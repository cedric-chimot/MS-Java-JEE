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
		sql = "SELECT pwd FROM compte WHERE login LIKE '" + login + "'";
		try {
			rs = st.executeQuery(sql);
			if(rs.next()) {
				mdp = rs.getString(1);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return mdp;
	}
	
	public void insertCompte(String login, String pwd, String type) {
		try {
			myCnx();
			insertCompte = "INSERT INTO `compte`(login,pwd,type) values(?,?,'s');";
			ps = cn.prepareStatement(insertCompte);
			ps.setString(1, login);
			ps.setString(2, pwd);
			ps.execute();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public int recupIdCompte() {
		int idCompte = 0;
		sql = "SELECT MAX(idCompte) FROM compte";
		try {
			rs = st.executeQuery(sql);
			if(rs.next()) {
				idCompte = rs.getInt(1);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return idCompte;
	}
	
	public void insertUsers(String fname, String lname, String adresse, String tel, int age, String sexe) {
		int idCompte = recupIdCompte();
		try {
			insertUser = "INSERT INTO `users`(fname,lname,adresse,tel,age,sexe,idCompte) VALUES(?,?,?,?,?,?,?);";
			ps = cn.prepareStatement(insertUser);
			ps.setString(1, fname);
			ps.setString(2, lname);
			ps.setString(3, adresse);
			ps.setString(4, tel);
			ps.setInt(5, age);
			ps.setString(6, sexe);
			ps.setInt(7, idCompte);
			ps.execute();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	/*public static void main(String[] args) throws SQLException {
		// Récupérer l'objet Connection
		Connexion db = new Connexion();
		Connection cnx = null;
		cnx = db.myCnx();
		
		//db.fermerCnx();
	}*/
}
