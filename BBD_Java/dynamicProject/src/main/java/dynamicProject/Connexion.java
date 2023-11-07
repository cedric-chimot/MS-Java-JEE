package dynamicProject;

import java.sql.*;

public class Connexion {
	Connection cn = null;
	Statement st = null;
	PreparedStatement ps = null;
	ResultSet rs = null;
	String sql = "";

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
	
	/*public static void main(String[] args) throws SQLException {
		// Récupérer l'objet Connection
		Connexion db = new Connexion();
		Connection cnx = null;
		cnx = db.myCnx();
		
		//db.fermerCnx();
	}*/
}
