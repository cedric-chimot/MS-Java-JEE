package dynamicProject;

import java.sql.*;
import java.util.*;

import jakarta.servlet.http.HttpServletRequest;


//import org.hibernate.*;
//import org.hibernate.cfg.*;


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
	
	private void fermerCnx(Connection cn) {
	    try {
	        if (cn != null && !cn.isClosed()) {
	            // Ne définissez pas le mode auto-commit ici
	            cn.close();
	            System.out.println("Connexion fermée !");
	        }
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }
	}
	
	// ---------- Vérification du mot de passe ----------
	public String verifCoordonnees(String login) {
	    String mdp = null;
	    Connection cn = myCnx();
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
	    	Connection cn = myCnx();
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
	        fermerCnx(cn);
	        System.out.println("Connexion fermée");
	    }
	}

	// ---------- Récupération du type d'utilisateur ----------
	public String recupType(String login) {
		Connection cn = myCnx();
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
				fermerCnx(cn);
				return true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		fermerCnx(cn);
		return false;
	}
	
	// ---------- Selectionner la catégorie au moment de l'ajout produit ----------
	public int selectCat(String designation) {
		Connection cn = myCnx();
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
	        fermerCnx(cn);
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
	            fermerCnx(cn);
	        }
	    }
	}
	
	// ---------- Tableau pour récupérer la liste des catégories ----------
	public List<String> listCat() {
		Connection cn = myCnx();
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
				fermerCnx(cn);
				return true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		fermerCnx(cn);
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
	        // Récupération de l'idArticle
	        int idArticle = recupIdArticle();
	        
	        // Vérifier le nombre actuel d'images
	        int currentImageCount = getImageCount(cn, idArticle);
	        int remainingImageSlots = 3 - currentImageCount; // 3 est la limite souhaitée

	        if (remainingImageSlots > 0) {
	            // Requête pour ajouter une nouvelle image
	            sql = "INSERT INTO image(name,img,idArticle) VALUES(?,?,?)";
	            ps = cn.prepareStatement(sql);

	            // Boucle pour récupérer plusieurs images (au maximum, la limite restante)
	            for (int i = 0; i < Math.min(remainingImageSlots, images.size()); i++) {
	                // Utilisation de la designation pour construire le name
	                String uniqueName = generateImgName();
	                ps.setString(1, uniqueName);
	                ps.setString(2, images.get(i));
	                ps.setInt(3, idArticle);

	                System.out.println(uniqueName);
	                System.out.println(images.get(i));
	                System.out.println(idArticle);

	                // Exécution de l'insertion
	                ps.executeUpdate();
	                
	                // Incrémentation de imgId
	                imgId++;
	            }
	        } else {
	            System.out.println("Limite maximale d'images atteinte. Aucune nouvelle image ajoutée.");
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
	    	Connection cn = myCnx();

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
	        fermerCnx(cn);
		}
	}
	
	// ---------- Méthode articles() sans paramètres pour afficher tous les articles ----------
	public List<Articles> articles() {
	    return articles(null);
	}
	
	// ---------- Méthode articles() pour récupérer la liste des articles par catégories ----------
	public List<Articles> articles(String categorySearch) {
		Connection cn = myCnx();
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
	    Connection cn = myCnx();
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
	
	// ---------- Nouvelle méthode pour obtenir une connexion à la base de données ----------
    private Connection getDatabaseConnection() throws SQLException {
        Connection cn = myCnx();
        cn.setAutoCommit(false);
        return cn;
    }
	
    // ---------- Modifier un article ----------
    public void updateProd(HttpServletRequest request, int idArticle, List<String> currentImages, int newPu, int newQty, String newImgModify, String newImgAdd, String selectedImage) {
        Connection cn = null;
        try {
            // Établir une connexion à la base de données
            cn = getDatabaseConnection();
            
            // Début de la transaction
            cn.setAutoCommit(false);

            // Requête pour modifier l'article
            // Modifie les paramètres même si l'image n'est pas modifiée
            String updateArt = "UPDATE article SET pu = ?, qty = ? WHERE idArticle = ?";
            try (PreparedStatement psArt = cn.prepareStatement(updateArt)) {
                // Paramètres de la requête SQL
                psArt.setInt(1, newPu);
                psArt.setInt(2, newQty);
                psArt.setInt(3, idArticle);
                
                // Exécution de la mise à jour de l'article
                int rowsUpdated = psArt.executeUpdate();
                System.out.println(rowsUpdated + " lignes mises à jour dans la table article.");
            }

            // Mise à jour de l'image sélectionnée
            if (selectedImage != null && !selectedImage.isEmpty() && newImgModify != null && !newImgModify.isEmpty()) {
                int imageId = getImageId(cn, idArticle, selectedImage);

                if (imageId != -1) {
                    updateImage(cn, imageId, newImgModify);
                    System.out.println("Image mise à jour : " + selectedImage + " vers " + newImgModify);
                } else {
                    System.out.println("Impossible de trouver l'ID de l'image : " + selectedImage);
                }
            }

            // Obtenir tous les noms des nouvelles images pour la modification
            String[] newImageNames = request.getParameterValues("newImgModify");
            System.out.println("Noms des nouvelles images à modifier : " + Arrays.toString(newImageNames));

            // Mise à jour des autres images une par une
            System.out.println("Images actuelles avant la boucle : " + currentImages);
            List<String> updatedImages = new ArrayList<>(currentImages);

            // Vérifier s'il y a de nouvelles images à modifier et si la liste des images actuelles n'est pas vide
            if (newImageNames != null && newImageNames.length > 0 && !currentImages.isEmpty()) {
                // Parcourir les images actuelles et les nouveaux noms d'images (jusqu'au minimum des deux tailles)
                for (int i = 0; i < Math.min(currentImages.size(), newImageNames.length); i++) {
                    // Obtenir le nom de l'image actuelle
                    String currentImage = currentImages.get(i);
                    // Obtenir le nouveau nom d'image correspondant
                    String newImageName = newImageNames[i];

                    // Obtenir l'ID de l'image actuelle dans la base de données
                    int imageId = getImageId(cn, idArticle, currentImage);

                    // Vérifier si l'ID de l'image a été trouvé
                    if (imageId != -1) {
                        // Mise à jour de l'image dans la base de données
                        updateImage(cn, imageId, newImageName);
                        System.out.println("Image mise à jour : " + currentImage + " vers " + newImageName);

                        // Mise à jour de la liste des images après chaque modification
                        updatedImages = recupImages(idArticle);
                    } else {
                        // Afficher un message d'erreur si l'ID de l'image n'a pas été trouvé
                        System.out.println("Impossible de trouver l'ID de l'image : " + currentImage);
                    }
                }
            }

            // À ce stade, updatedImages contient la liste des images mise à jour
            System.out.println("Images actuelles après la boucle : " + updatedImages);

            // Validation de la transaction
            cn.commit();

        } catch (Exception e) {
            // En cas d'erreur, annulation de la transaction
            try {
                if (cn != null) {
                    cn.rollback();
                    System.out.println("Rollback effectué en raison de l'erreur : " + e.getMessage());
                }
            } catch (SQLException rollbackException) {
                rollbackException.printStackTrace();
            }
            e.printStackTrace();
        } finally {
            try {
                // Rétablissement du mode auto-commit
                if (cn != null) {
                    cn.setAutoCommit(true);
                    // Fermeture de la connexion
                    cn.close();
                }
            } catch (SQLException closeException) {
                closeException.printStackTrace();
            }
        }
    }

    // ---------- Récupération de l'id d'une image ----------
    /**
     * Récupère l'identifiant d'une image spécifique associée à un article.
     *
     * @param cn          La connexion à la base de données.
     * @param idArticle   L'identifiant de l'article.
     * @param imageName   Le nom de l'image dont on souhaite obtenir l'identifiant.
     * @return L'identifiant de l'image s'il est trouvé, sinon -1.
     */
    private int getImageId(Connection cn, int idArticle, String imageName) {
        // Requête SQL pour récupérer l'identifiant de l'image
        String getImageId = "SELECT id FROM image WHERE idArticle = ? AND img = ?";
        
        try (PreparedStatement ps = cn.prepareStatement(getImageId)) {
            // Paramètres de la requête
            ps.setInt(1, idArticle);
            ps.setString(2, imageName);
            
            // Exécution de la requête et récupération du résultat
            ResultSet rs = ps.executeQuery();
            
            if (rs.next()) {
                // Si une ligne est trouvée, retourne l'identifiant de l'image
                return rs.getInt("id");
            } else {
                // Si aucune ligne n'est trouvée, affiche un message d'erreur
                System.out.println("Impossible de trouver l'ID de l'image : " + imageName);
            }
        } catch (SQLException e) {
            // Gestion des exceptions SQL, affiche la trace de la pile
            e.printStackTrace();
        }
        
        // Si une erreur survient, retourne -1
        return -1;
    }
    
	// ---------- Méthode pour mettre à jour une image dans la base de données ----------
    
	// Cette méthode met à jour le nom d'une image dans la base de données en fonction de son identifiant.
	// Elle prend en paramètre une connexion à la base de données (cn), l'identifiant de l'image (imageId),
	// et le nouveau nom de l'image (newImageName) que l'on souhaite enregistrer.
	private void updateImage(Connection cn, int imageId, String newImageName) throws SQLException {
		// Requête SQL pour mettre à jour le nom de l'image dans la table 'image'
		String updateImage = "UPDATE image SET img = ? WHERE id = ?";
		try (PreparedStatement psImage = cn.prepareStatement(updateImage)) {
		// Définition des valeurs dans la requête préparée
		psImage.setString(1, newImageName);
		psImage.setInt(2, imageId);
			
		// Exécution de la requête de mise à jour
		int rowsUpdated = psImage.executeUpdate();
		System.out.println(rowsUpdated + " lignes mises à jour dans la table image.");
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
	
	// Cette méthode récupère le nombre d'images associées à un article spécifique dans la base de données.
	// Elle prend en paramètre une connexion à la base de données (cn) et l'identifiant de l'article (idArticle).
	// La requête SQL compte le nombre d'images enregistrées pour cet article.
	// La méthode renvoie le nombre d'images trouvé ou 0 si aucune image n'est associée à l'article.
	private int getImageCount(Connection cn, int idArticle) throws SQLException {
	    // Requête SQL pour compter le nombre d'images associées à l'article
	    String countImages = "SELECT COUNT(*) FROM image WHERE idArticle = ?";
	    try (PreparedStatement psCount = cn.prepareStatement(countImages)) {
	        psCount.setInt(1, idArticle);
	        try (ResultSet rs = psCount.executeQuery()) {
	            // S'il y a des résultats, retourne le nombre d'images associées à l'article
	            if (rs.next()) {
	                return rs.getInt(1);
	            }
	        }
	    }
	    // Retourne 0 si aucune image n'est associée à l'article
	    return 0;
	}

	// ---------- Récupérer les données d'un article en particulier ----------
	
	// Cette méthode récupère les données d'un article spécifique en fonction de son identifiant.
	// Elle prend en paramètre l'identifiant de l'article (idArticle).
	// La requête SQL joint la table 'article' avec 'categorie' et 'image' pour récupérer toutes les informations nécessaires.
	// Les données récupérées sont utilisées pour créer et renvoyer un objet Articles.
	public Articles getArticle(int idArticle) {
	    Connection cn = null;
	    Articles produit = null;

	    // Requête SQL pour récupérer les données de l'article, y compris la désignation de la catégorie et les noms d'images.
	    String sql = "SELECT a.*, "
	            + "c.designation AS desiCat, i.img AS imgArt "
	            + "FROM article a "
	            + "JOIN categorie c ON a.idcategorie = c.idcategorie "
	            + "LEFT JOIN image i ON a.idarticle = i.idarticle "
	            + "WHERE a.idArticle = ?";

	    try {
	        // Établissement d'une connexion à la base de données
	        cn = getDatabaseConnection();
	        PreparedStatement ps = cn.prepareStatement(sql);
	        ps.setInt(1, idArticle);

	        ResultSet rs = ps.executeQuery();
	        if (rs.next()) {
	            // Récupération des données de l'article et des images associées
	            String imgArt = rs.getString("imgArt");
	            List<String> images = (imgArt != null) ? Arrays.asList(imgArt.split(",")) : new ArrayList<>();

	            // Création d'un objet Articles avec les données récupérées
	            produit = new Articles(rs.getInt("idArticle"), rs.getString("designation"), rs.getInt("pu"),
	                    rs.getInt("qty"), rs.getString("desiCat"), images);
	        }

	        rs.close();
	        ps.close();
	    } catch (SQLException e) {
	        e.printStackTrace();
	    } finally {
	        // Fermeture de la connexion dans le bloc finally
	        if (cn != null) {
	            try {
	                cn.close();
	                System.out.println("Connexion fermée !");
	            } catch (SQLException e) {
	                e.printStackTrace();
	            }
	        }
	     }

	    // Renvoie l'objet Articles ou null si une exception s'est produite
	    return produit;
	}
	
	// ---------- Ajouter un nouveau produit Hibernate ----------
	/*public void ajoutProdHibernate(Article a) {
	    Configuration configuration = new Configuration().configure();
	    SessionFactory sf = configuration.buildSessionFactory();
	    Session session = sf.openSession();
	    Transaction tr = session.beginTransaction();
	    session.persist(a);
	    tr.commit();
	    session.close();
	    sf.close();
	}*/
		
	/*public static void main(String[] args) throws SQLException {
		// Récupérer l'objet Connection
		Connexion db = new Connexion();
		Connection cnx = null;
		cnx = db.myCnx();
		
		db.insertDesignation("Jeux video");
		
		//db.fermerCnx();
	}*/
}
