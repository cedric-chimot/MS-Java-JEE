package dynamicProject;

import java.sql.*;
import java.util.*;

import org.hibernate.*;
import org.hibernate.cfg.*;

import jakarta.servlet.http.HttpServletRequest;

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
	// Variable pour le nom de l'image
	private static int imgId;
	
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
	
	// ---------- Récupérer la désignation du produit pour le nom d'image ----------
	public String recupDesi() {
		String designation = "";
		int idArticle = recupIdArticle();
		
		sql = "SELECT designation FROM article WHERE idArticle = ?";
		try {
			ps = cn.prepareStatement(sql);
			ps.setInt(1, idArticle);
			rs = ps.executeQuery();
			if(rs.next()) {
				designation = rs.getString(1);
			}
		} catch(SQLException e) {
			e.printStackTrace();
		} finally {
		    // Fermer le PreparedStatement
		    if (ps != null) {
		        try {
		            ps.close();
		        } catch (SQLException e) {
		            e.printStackTrace();
		        }
		    }
		}
		return designation;
	}
	
	// ---------- Ajouter les images avec l'article ----------
	public void ajoutImg(List<String> images) {
		try {
			// Récupérer la designation du dernier article ajouté
			String designation = recupDesi();
			
			// Récupération de l'idArticle
			int idArticle = recupIdArticle();
			
			// Requête pour ajouter une nouvelle image
	        sql = "INSERT INTO image(name,img,idArticle) VALUES(?,?,?)";
	        ps = cn.prepareStatement(sql);
	        
	        // Boucle pour récupérer plusieurs images
	        for(String img : images) {
	        	// Utilisation de la designation pour construire le name
				String uniqueName = designation + "_image_" + imgId;
		        ps.setString(1, uniqueName);
		        ps.setString(2, img);
		        ps.setInt(3, idArticle);
		        
		        System.out.println(uniqueName);
		        System.out.println(img);
		        System.out.println(idArticle);

		        // Exécution de l'insertion
		        ps.executeUpdate();
		        
		        // Incrémentation de imgId
		        imgId++;
	        }
		} catch (SQLException e) {
	        e.printStackTrace();
	    } finally {
		    // Fermer le PreparedStatement
		    if (ps != null) {
		        try {
		            ps.close();
		        } catch (SQLException e) {
		            e.printStackTrace();
		        }
		    }
		}
	}
	
	// ---------- Ajouter un nouveau produit ----------
	public void ajoutProd(String name, List<String> img, String designation, int pu, int qty, int idCategorie) {
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
	        
	        // Incrémentation de imgId
	        imgId++;
	        System.out.println(imgId);
	        System.out.println("liste images : " + img);
	        	     	
	     	// Ajout des images associées à l'article
	        ajoutImg(img);
	        
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
		    // Fermer le PreparedStatement
		    if (ps != null) {
		        try {
		            ps.close();
		        } catch (SQLException e) {
		            e.printStackTrace();
		        }
		    }
		    // Fermeture de la connexion
	        fermerCnx();
		}
	}
	
	// ---------- Méthode articles() sans paramètres pour afficher tous les articles ----------
	public List<Articles> articles() {
	    return articles(null);
	}
	
	// ---------- Méthode articles() pour récupérer la liste des articles par catégories ----------
	public List<Articles> articles(String categorySearch) {
	    myCnx();
	    List<Articles> produits = new ArrayList<>();

	    // On utilise une requête différente si une catégorie de recherche est spécifiée
	    String sql = null;
	    if (categorySearch != null && !categorySearch.isEmpty()) {
	        sql = "SELECT DISTINCT a.idArticle, a.designation, a.pu, a.qty, "
	                + "c.designation AS desiCat, i.img AS imgArt "
	                + "FROM article a "
	                + "JOIN categorie c ON a.idcategorie = c.idcategorie "
	                + "LEFT JOIN image i ON a.idarticle = i.idarticle "
	                + "WHERE c.designation = ? ";
	    } else {
	        // Requête pour obtenir tous les articles si aucune catégorie spécifiée
	        sql = "SELECT DISTINCT a.idArticle, a.designation, a.pu, a.qty, "
	                + "c.designation AS desiCat, i.img AS imgArt "
	                + "FROM article a "
	                + "JOIN categorie c ON a.idcategorie = c.idcategorie "
	                + "LEFT JOIN image i ON a.idarticle = i.idarticle ";
	    }

	    try {
	        PreparedStatement ps = cn.prepareStatement(sql);

	        // Si une catégorie est spécifiée, on définit le paramètre dans la requête
	        if (categorySearch != null && !categorySearch.isEmpty()) {
	            ps.setString(1, categorySearch);
	        }

	        ResultSet rs = ps.executeQuery();
	        Map<Integer, Articles> articleMap = new HashMap<>();
	        
	        while (rs.next()) {
	            int idArticle = rs.getInt("idArticle");
	            Articles article = articleMap.get(idArticle);

	            if (article == null) {
	                // Si l'article n'est pas déjà dans la map, on le crée
	                article = new Articles(rs.getInt("idArticle"), rs.getString("designation"),
	                    rs.getInt("pu"), rs.getInt("qty"), rs.getString("desiCat"), new ArrayList<>());
	                articleMap.put(idArticle, article);
	            }

	            // Ajouter l'image à la liste d'images de l'article seulement si elle n'est pas nulle
	            String img = rs.getString("imgArt");
	            if (img != null && !img.isEmpty()) {
	                article.getImages().add(img);
	            }
	        }

        	// Fermer les ressources
	        rs.close();
	        ps.close();
	        
	        // On convertit la map pour le retour
	        return new ArrayList<>(articleMap.values());
	        
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }
	    return produits;
	}
	
	// ---------- Récupérer la liste d'images ----------
	public List<String> recupImages(int idArticle) {
	    myCnx();
	    List<String> currentImages = new ArrayList<>();

	    String listImages = "SELECT img FROM image WHERE idArticle = ?";
	    try {
	        PreparedStatement psImg = cn.prepareStatement(listImages);
	        psImg.setInt(1, idArticle);
	        ResultSet rs = psImg.executeQuery();

	        // Ajoutez une déclaration de journalisation pour suivre le début de la boucle
	        System.out.println("Début de la récupération des images...");

	        while (rs.next()) {
	            currentImages.add(rs.getString("img"));

	            // Ajoutez une déclaration de journalisation pour suivre chaque image récupérée
	            System.out.println("Image récupérée : " + rs.getString("img"));
	        }

	        // Ajoutez une déclaration de journalisation pour suivre la fin de la boucle
	        System.out.println("Fin de la récupération des images.");

	        rs.close();
	        psImg.close();
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }
	    return currentImages;
	}
	
	// ---------- Modifier un article ----------
	public void updateProd(int idArticle, List<String> currentImages, int newPu, int newQty, List<String> newImgs, HttpServletRequest request, boolean isUpdate) {
	    myCnx();
	    try {
	        // Début de la transaction
	        cn.setAutoCommit(false);

	        // Requête pour modifier l'article
	        String updateArt = "UPDATE article SET pu = ?, qty = ? WHERE idArticle = ?";
	        try (PreparedStatement psArt = cn.prepareStatement(updateArt)) {
	            psArt.setInt(1, newPu);
	            psArt.setInt(2, newQty);
	            psArt.setInt(3, idArticle);
	            psArt.executeUpdate();
	        }

	        // Suppression des images qui ne sont plus présentes dans le formulaire
	        for (String currentImage : currentImages) {
	            if (!newImgs.contains(currentImage)) {
	                // Vérifier si l'image actuelle doit être supprimée ou conservée
	                if (shouldDeleteImage(request, currentImage, currentImages)) {
	                    // Supprimer l'image de la base de données
	                    deleteImage(idArticle, currentImage);
	                }
	            }
	        }

	        // Mise à jour des images existantes
	        for (int i = 0; i < currentImages.size() && i < newImgs.size(); i++) {
	            String imgParam = request.getParameter("img" + i);
	            if (imgParam != null && !imgParam.isEmpty()) {
	                // Mettre à jour l'image dans la base de données
	                updateImage(idArticle, currentImages.get(i), imgParam);
	            }
	        }

	        // Ajout des nouvelles images (jusqu'à un maximum de 3)
	        int maxNewImages = 3;
	        for (int i = currentImages.size(); i < maxNewImages && i < newImgs.size(); i++) {
	            String imgParam = request.getParameter("img" + i);
	            if (imgParam != null && !imgParam.isEmpty()) {
	                // Ajouter la nouvelle image dans la base de données
	                addImage(idArticle, imgParam);
	            }
	        }

	        // Validation de la transaction
	        cn.commit();

	    } catch (SQLException e) {
	        // En cas d'erreur, annulation de la transaction
	        try {
	            cn.rollback();
	        } catch (SQLException rollbackException) {
	            rollbackException.printStackTrace();
	        }
	        e.printStackTrace();
	    } finally {
	        try {
	            // Rétablissement du mode auto-commit
	            cn.setAutoCommit(true);
	            // Fermeture de la connexion
	            cn.close();
	        } catch (SQLException closeException) {
	            closeException.printStackTrace();
	        }
	    }
	}

	// ---------- Méthode pour supprimer une image de la base de données ----------
	private void deleteImage(int idArticle, String imageName) throws SQLException {
	    String deleteImg = "DELETE FROM image WHERE idArticle = ? AND img = ?";
	    try (PreparedStatement psDeleteImg = cn.prepareStatement(deleteImg)) {
	        psDeleteImg.setInt(1, idArticle);
	        psDeleteImg.setString(2, imageName);
	        psDeleteImg.executeUpdate();
	    }
	}

	// ---------- Méthode pour mettre à jour le nom d'une image dans la base de données ----------
	private void updateImage(int idArticle, String currentImage, String newImage) throws SQLException {
	    String updateImg = "UPDATE image SET img = ? WHERE idArticle = ? AND img = ?";
	    try (PreparedStatement psUpdateImg = cn.prepareStatement(updateImg)) {
	    	String newImgName = generateImgName();
	        psUpdateImg.setString(1, newImgName);
	        psUpdateImg.setInt(2, idArticle);
	        psUpdateImg.setString(3, currentImage);
	        psUpdateImg.executeUpdate();
	    }
	}

	// ---------- Méthode pour ajouter une nouvelle image dans la base de données ----------
	private void addImage(int idArticle, String imageName) throws SQLException {
	    // Vérifier la limite de 3 images
	    int imageCount = getImageCount(idArticle);
	    if (imageCount < 3) {
	        String insertNewImg = "INSERT INTO image(name, img, idArticle) VALUES (?, ?, ?)";
	        try (PreparedStatement psNewImg = cn.prepareStatement(insertNewImg)) {
	        	String uniqueName = generateImgName();
	            psNewImg.setString(1, uniqueName);
	            psNewImg.setString(2, imageName);
	            psNewImg.setInt(3, idArticle);
	            psNewImg.executeUpdate();
	        }
	    } else {
	        // Gérer la limite d'images ici (par exemple, en renvoyant une erreur)
	        throw new SQLException("Limite maximale d'images atteinte");
	    }
	}
	
	/**
	 * Génère un nom d'image unique en combinant un préfixe fixe avec une partie aléatoire.
	 * Utilise un identifiant universellement unique (UUID) pour garantir l'unicité.
	 * La longueur du nom généré est ajustée en utilisant seulement les premiers caractères de la partie aléatoire.
	 *
	 * @return Le nom d'image unique généré.
	 */
	private String generateImgName() {
	    // Préfixe fixe pour le nom d'image
	    String prefix = "new_image_";

	    // Génération d'une partie aléatoire à partir d'un UUID
	    String uniquePart = UUID.randomUUID().toString().substring(0, 8);

	    // Retourne le nom d'image unique combinant le préfixe et la partie aléatoire
	    return prefix + uniquePart;
	}


	// ---------- Méthode pour récupérer le nombre d'images actuelles pour un article ----------
	private int getImageCount(int idArticle) throws SQLException {
	    String countImages = "SELECT COUNT(*) FROM image WHERE idArticle = ?";
	    try (PreparedStatement psCount = cn.prepareStatement(countImages)) {
	        psCount.setInt(1, idArticle);
	        try (ResultSet rs = psCount.executeQuery()) {
	            if (rs.next()) {
	                return rs.getInt(1);
	            }
	        }
	    }
	    return 0;
	}
	
	// ---------- Méthode pour vérifier si on modifie ou non l'image pendant un update ----------
	private boolean shouldDeleteImage(HttpServletRequest request, String imageName, List<String> currentImages) {
	    // Récupérer l'index de l'image dans la liste actuelle
	    int imageIndex = currentImages.indexOf(imageName);

	    // Vérifier si le champ associé à l'image a été modifié
	    String imgParam = request.getParameter("img" + imageIndex);
	    return (imgParam != null && !imgParam.isEmpty());
	}
	
	// ---------- Récupérer les données d'un article en particulier ----------
	public Articles getArticle(int idArticle) {
	    myCnx();
	    Articles produit = null;

	    String sql = "SELECT a.*, "
	            + "c.designation AS desiCat, i.img AS imgArt "
	            + "FROM article a "
	            + "JOIN categorie c ON a.idcategorie = c.idcategorie "
	            + "LEFT JOIN image i ON a.idarticle = i.idarticle "
	            + "WHERE a.idArticle = ?";

	    try {
	        PreparedStatement ps = cn.prepareStatement(sql);
	        ps.setInt(1, idArticle);

	        ResultSet rs = ps.executeQuery();
	        if (rs.next()) {
	            String imgArt = rs.getString("imgArt");
	            List<String> images = (imgArt != null) ? Arrays.asList(imgArt.split(",")) : new ArrayList<>();

	            produit = new Articles(rs.getInt("idArticle"), rs.getString("designation"), rs.getInt("pu"),
	                    rs.getInt("qty"), rs.getString("desiCat"), images);
	        }

	        rs.close();
	        ps.close();
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }

	    return produit;
	}
	
	// ---------- Ajouter un nouveau produit Hibernate ----------
	public void ajoutProdHibernate(Article a) {
	    Configuration configuration = new Configuration().configure();
	    SessionFactory sf = configuration.buildSessionFactory();
	    Session session = sf.openSession();
	    Transaction tr = session.beginTransaction();
	    session.persist(a);
	    tr.commit();
	    session.close();
	    sf.close();
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
