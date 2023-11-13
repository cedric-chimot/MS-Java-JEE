package dynamicProject;

import java.sql.*;
import java.util.*;

public class Connexion {
	// Création des variables
	Connection cn = null;
	Statement st = null;
	PreparedStatement ps = null;
	ResultSet rs = null;
	String sql = "";
	String insertCompte = "";
	String insertUser = "";
	String insertArticle = "";
	String insertImg = "";
	
	// ---------- Paramétrage de la connexion ----------
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
	
	// ---------- Fermeture de la connexion ----------
	public void fermerCnx() {
        try {
            if (rs != null) rs.close();
            if (st != null) st.close();
            if (cn != null) cn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
	
	// ---------- Vérification du mot de passe ----------
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

	// ---------- Récupération de l'utilisateur pour l'ajouter dans la table compte ----------
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
	
	// ---------- Insertion de l'utilisateur en BDD au moment de l'inscription ----------
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

	// ---------- Récupération du type d'utilisateur ----------
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
	
	// ---------- Vérification de l'existence d'une catégorie ----------
	public boolean categorieExist(String designation) {
		myCnx();
		sql = "SELECT idCategorie FROM categorie WHERE designation LIKE '" + designation + "'";
		try {
			rs = st.executeQuery(sql);
			if(rs.next()) {
				fermerCnx();
				return true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		fermerCnx();
		return false;
	}
	
	// ---------- Selectionner la catégorie au moment de l'ajout produit ----------
	public int selectCat(String designation) {
	    myCnx();
	    int idCat = 0;
	    sql = "SELECT idCategorie FROM categorie WHERE designation LIKE ?";
	    try (PreparedStatement ps = cn.prepareStatement(sql)) {
	        ps.setString(1, designation);
	        try (ResultSet rs = ps.executeQuery()) {
	            if (rs.next()) {
	                idCat = rs.getInt(1);
	            }
	        }
	    } catch (SQLException e) {
	        e.printStackTrace();
	    } finally {
	        fermerCnx();
	    }
	    return idCat;
	}
	
	// ---------- Ajouter une nouvelle catégorie ----------
	public void insertDesignation(String cat) {
	    if (!categorieExist(cat)) {
	        sql = "INSERT INTO categorie(designation) VALUES(?)";
	        try {
	            myCnx();

	            // Utiliser une requête préparée pour l'insertion de la catégorie
	            ps = cn.prepareStatement(sql);
	            ps.setString(1, cat);

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
	            fermerCnx();
	        }
	    }
	}
	
	// ---------- Tableau pour récupérer la liste des catégories ----------
	public List<String> listCat() {
		myCnx();
		List<String> categories = new ArrayList<String>();
		String sql = "SELECT * FROM `categorie`";
		try {
	        PreparedStatement ps = cn.prepareStatement(sql);

	        ResultSet rs = ps.executeQuery();
	        while(rs.next()) {
	        	categories.add(rs.getString(2));
	        }

	        rs.close();
	        ps.close();
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }		
		return categories;
	}
	
	// ---------- Vérification de l'existence d'un produit ----------
	public boolean produitExist(String designation) {
		myCnx();
		sql = "SELECT idArticle FROM article WHERE designation LIKE '" + designation + "'";
		try {
			rs = st.executeQuery(sql);
			if(rs.next()) {
				fermerCnx();
				return true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		fermerCnx();
		return false;
	}
	
	// ---------- Récupérer l'id du produit ----------
	public int recupIdArticle() {
		int idArticle = 0;
		sql = "SELECT MAX(idArticle) FROM article";
		try {
			rs = st.executeQuery(sql);
			if(rs.next()) {
				idArticle = rs.getInt(1);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return idArticle;
	}
	
	// ---------- Ajouter un nouveau produit ----------
	public void ajoutProd(String name, String img, String designation, int pu, int qty, int idCategorie) {
	    try {
	        myCnx();

	        // Insertion dans la table article
	        sql = "INSERT INTO article(designation,pu,qty,idCategorie) VALUES(?,?,?,?)";
	        ps = cn.prepareStatement(sql);
	        ps.setString(1, designation);
	        ps.setInt(2, pu);
	        ps.setInt(3, qty);
	        ps.setInt(4, idCategorie);

	        // Exécution de l'insertion
	        ps.executeUpdate();

	        // Récupération de l'idArticle généré
	        int idArticle = recupIdArticle();

	        // Insertion dans la table image
	        sql = "INSERT INTO image(name,img,idArticle) VALUES(?,?,?)";
	        ps = cn.prepareStatement(sql);
	        ps.setString(1, name);
	        ps.setString(2, img);
	        ps.setInt(3, idArticle);

	        // Exécution de l'insertion
	        ps.executeUpdate();

	        // Validation de la transaction
	        cn.commit();

	    } catch (SQLException e) {
	        // Annulation de la transaction en cas d'exception
	        try {
	            if (cn != null) {
	                cn.rollback();
	            }
	        } catch (SQLException ex) {
	            ex.printStackTrace();
	        }
	        e.printStackTrace();
	    } finally {
	        // Fermeture de la connexion
	        fermerCnx();
	    }
	}
	
	// ---------- Tableau pour récupérer la liste des produits ----------
	public List<Articles> articles() {
		myCnx();
		List<Articles> produits = new ArrayList<Articles>();
		String sql = "SELECT a.*, "
				+ "c.designation AS desiCat, i.img AS imgArt "
				+ "FROM article a "
				+ "JOIN categorie c ON a.idcategorie = c.idcategorie "
				+ "LEFT JOIN image i ON a.idarticle = i.idarticle;";
		try {
	        PreparedStatement ps = cn.prepareStatement(sql);

	        ResultSet rs = ps.executeQuery();
	        while(rs.next()) {
	        	produits.add(new Articles(rs.getString("designation"), rs.getInt("pu"), rs.getInt("qty"),
	        			rs.getString("desiCat"), rs.getString("imgArt")));
	        }

	        rs.close();
	        ps.close();
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }		
		return produits;
	}
		
	/*public static void main(String[] args) throws SQLException {
		// Récupérer l'objet Connection
		Connexion db = new Connexion();
		Connection cnx = null;
		cnx = db.myCnx();
		
		db.insertDesignation("Jeux video");
		
		//db.fermerCnx();
	}*/
}
