import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.util.*;

import dynamicProject.Articles;
import dynamicProject.Connexion;


/**
 * Servlet implementation class MyServlet
 */
@WebServlet("/MyServlet")

public class MyServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private Connexion co = new Connexion();
	private static final int maxImg = 3;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MyServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String flag = request.getParameter("flag");

        if (flag.equalsIgnoreCase("deleteProd")) {
            // Si le flag est "deleteProd", appelez la méthode doDeleteProd
            this.doDeleteProd(request, response);
        } else {
            // TODO: Ajoutez le code pour les autres cas si nécessaire
            response.getWriter().append("Served at: ").append(request.getContextPath());
        }
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String flag = request.getParameter("flag");
		if(flag.equalsIgnoreCase("connect")) {
			this.doConnexion(request,response);
		} else if(flag.equalsIgnoreCase("inscrit")) {
			this.doInscription(request, response);
		} else if(flag.equalsIgnoreCase("categorie")) {
			this.doAjoutCat(request, response);
		} else if(flag.equalsIgnoreCase("produit")) {
			this.doAjoutProd(request, response);
		} else if(flag.equalsIgnoreCase("modifProd")) {
			this.doModifProd(request, response);
		} else if(flag.equalsIgnoreCase("ajoutCommande")) {
			this.doAjoutCommande(request, response);
		}  else {
			// Si le paramètre flag n'est ni "connect" ni "inscrit", exécutez la méthode doGet
			this.doGet(request, response);
		}
	}

	private void doConnexion(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Récupération des paramètres de la requête
        String login = request.getParameter("pseudo");
        String pwd = request.getParameter("mdp");
        String typeUser = co.recupType(login);
        String pwdBDD = co.verifCoordonnees(login);

        // Récupération de la session
        HttpSession session = request.getSession();
        // Initialisation de la variable d'erreur
        boolean erreur = false;
        // URL par défaut pour la redirection
        String redirectURL = "/connect.jsp";

        // Vérification des champs vides
        if (login.isEmpty() || pwd.isEmpty()) {
            erreur = true;
            session.setAttribute("mesErreur", "Les champs ne peuvent pas être vides !");
        } else {
            // Vérification du pseudo dans la base de données
            if (pwdBDD == null) {
                erreur = true;
                session.setAttribute("mesErreur", "Pseudo ou mot de passe incorrect !");
            } else {
                // Vérification du mot de passe
                if (pwd.equalsIgnoreCase(pwdBDD)) {
                    session.setAttribute("mesErreur", null); // Réinitialiser le message d'erreur
                    // Redirection en fonction du type d'utilisateur
                    if ("a".equalsIgnoreCase(typeUser)) {
                    	session.setAttribute("bienvenue", login);
                        redirectURL = "/menuAdmin.jsp";
                    } else {
                    	session.setAttribute("bienvenue", login);
                        redirectURL = "/menuSimple.jsp";
                    }
                } else {
                    erreur = true;
                    session.setAttribute("mesErreur", "Pseudo ou mot de passe incorrect !");
                }
            }
        }

        // Rediriger vers l'URL appropriée
        if (erreur) {
            request.setAttribute("erreur", erreur);
        }
        request.getRequestDispatcher(redirectURL).forward(request, response);
    }

	private void doInscription(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	    // Récupération des paramètres de la requête
	    String fname = request.getParameter("nom");
	    String lname = request.getParameter("prenom");
	    String adresse = request.getParameter("adresse");
	    String tel = request.getParameter("tel");
	    String ageStr = request.getParameter("age");
	    String sexe = request.getParameter("sexe");
	    String login = request.getParameter("pseudo");
	    String pwd = request.getParameter("mdp");

	    // Récupération de la session
	    HttpSession session = request.getSession();

	    // Initialisation de la variable d'erreur
	    boolean erreur = false;

	    // Expressions régulières pour la validation des champs
	    String fnameRegex = "^[A-Za-z0-9.-/]+$";
	    String lnameRegex = "^[A-Za-z0-9.-/]+$";
	    String adresseRegex = "^[A-Za-z0-9.-/]+$";
	    String telRegex = "^[A-Za-z0-9.-/]+$";
	    String ageStrRegex = "^(1[5-9]|[2-9][0-9])$";
	    String sexeRegex = "^[MF]$";
	    String loginRegex = "^[A-Za-z0-9.-/]+$";
	    String pwdRegex = "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[@#$%^&+=!])(?=\\S+$).{8,}$";

	    // Validation du champ nom
	    if (fname.isEmpty() && !fname.matches(fnameRegex)) {
	        erreur = true;
	        session.setAttribute("nomErreur", "Le nom ne peut être vide !");
	    } else {
	        session.setAttribute("nomErreur", null); // Réinitialiser le message d'erreur
	    }

	    // Validation du champ prénom
	    if (lname.isEmpty() && !lname.matches(lnameRegex)) {
	        erreur = true;
	        session.setAttribute("prenomErreur", "Le prénom ne peut être vide !");
	    } else {
	        session.setAttribute("prenomErreur", null);
	    }

	    // Validation du champ adresse
	    if (adresse.isEmpty() && !adresse.matches(adresseRegex)) {
	        erreur = true;
	        session.setAttribute("adresseErreur", "L'adresse ne peut être vide !");
	    } else {
	        session.setAttribute("adresseErreur", null);
	    }

	    // Validation du champ téléphone
	    if (tel.isEmpty() && !tel.matches(telRegex)) {
	        erreur = true;
	        session.setAttribute("telErreur", "Le téléphone ne peut être vide !");
	    } else {
	        session.setAttribute("telErreur", null);
	    }

	    // Validation du champ âge
	    if (ageStr.isEmpty() && !ageStr.matches(ageStrRegex)) {
	        erreur = true;
	        session.setAttribute("ageErreur", "L'âge ne peut être vide !");
	    } else {
	        session.setAttribute("ageErreur", null);
	    }

	    // Validation du champ sexe
	    if (sexe.isEmpty() && !sexe.matches(sexeRegex)) {
	        erreur = true;
	        session.setAttribute("sexeErreur", "Le sexe ne peut être vide !");
	    } else {
	        session.setAttribute("sexeErreur", null);
	    }

	    // Validation du champ pseudo
	    if (login.isEmpty() && !login.matches(loginRegex)) {
	        erreur = true;
	        session.setAttribute("pseudoErreur", "Le pseudo ne peut être vide !");
	    } else {
	        session.setAttribute("pseudoErreur", null);
	    }

	    // Validation du champ mot de passe
	    if (pwd.isEmpty() && !pwd.matches(pwdRegex)) {
	        erreur = true;
	        session.setAttribute("pwdErreur", "Le mot de passe doit comporter une majuscule, une minuscule, un caractère spécial et au minimum 8 caractères !");
	    } else {
	        session.setAttribute("pwdErreur", null);
	    }

	    // Si aucune erreur, insérer le compte et rediriger vers la page de connexion
	    if (!erreur) {
	        int age = Integer.parseInt(ageStr);
	        co.insertCompte(login, pwd, "s", fname, lname, adresse, tel, age, sexe);
	        request.getRequestDispatcher("/connect.jsp").forward(request, response);
	    } else {
	        // En cas d'erreur, rediriger vers la page d'inscription avec l'indication d'erreur
	        request.setAttribute("erreur", erreur);
	        request.getRequestDispatcher("/inscrit.jsp").forward(request, response);
	    }
	}

	private void doAjoutCat(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	    String designation = request.getParameter("designation");
	    HttpSession session = request.getSession(true);

	    if (designation != null && !designation.isEmpty()) {
	        if (!co.categorieExist(designation)) {
	            co.insertDesignation(designation);
	            session.setAttribute("message", "Catégorie ajoutée correctement !");
	            request.getRequestDispatcher("/menuCat.jsp").forward(request, response);
	            return;  // Ajout de return pour éviter l'exécution des lignes suivantes
	        } else {
	            session.setAttribute("message", "La catégorie existe déjà !");
	        }
	    } else {
	        session.setAttribute("message", "Veuillez fournir une désignation de catégorie valide.");
	    }

	    // Redirection vers /ajoutCat.jsp si les conditions ci-dessus ne sont pas remplies
	    request.getRequestDispatcher("/ajoutCat.jsp").forward(request, response);
	}

	private void doAjoutProd(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String designation = request.getParameter("designation");
		String puStr = request.getParameter("pu");
		String qtyStr = request.getParameter("qty");
		String idCategorieStr = request.getParameter("selectCat");
		String name = request.getParameter("designation");
		
		// Modifier la récupération des paramètres pour prendre en compte les noms dynamiques des images
		String[] imgArray = new String[maxImg];  // Création d'un tableau pour stocker les noms de fichiers d'images

		// Utilisation d'une boucle pour récupérer les paramètres d'image dynamiques (img1, img2, etc.)
		for (int i = 1; i <= maxImg; i++) {
		    // Construire le nom du paramètre d'image (img1, img2, etc.) en fonction de l'index de la boucle
		    String paramName = "img" + i;

		    // Récupérer la valeur du paramètre d'image à partir de la requête
		    String imgValue = request.getParameter(paramName);

		    // Stocker la valeur dans le tableau d'images
		    imgArray[i - 1] = imgValue;
		}

		// Convertir le tableau d'images en une liste (utilisation de Collections.emptyList() si le tableau est nul)
		List<String> img = (imgArray != null) ? Arrays.asList(imgArray) : Collections.emptyList();

		// Récupération de la session
	    HttpSession session = request.getSession();

	    // Initialisation de la variable d'erreur
	    boolean erreur = false;
		
		String desiRegex = "^[A-Za-z0-9.-/]+$";
	    String puRegex = "^[0-9]+$";
	    String qtyRegex = "^[0-9]+$";
	    String categorieRegex = "^[A-Za-z0-9.-/]+$";
		
	    // Validation du champ designation
	    if (designation.isEmpty() && !designation.matches(desiRegex)) {
	        erreur = true;
	        session.setAttribute("desiErreur", "Veuillez entrer une désignation correcte !");
	    } else {
	        session.setAttribute("desiErreur", null); // Réinitialiser le message d'erreur
	    }
	    
	    // Validation du champ prix unitaire
	    if (puStr.isEmpty() && !puStr.matches(puRegex)) {
	        erreur = true;
	        session.setAttribute("puErreur", "Veuillez saisir le prix !");
	    } else {
	        session.setAttribute("puErreur", null); // Réinitialiser le message d'erreur
	    }
	    
	    // Validation du champ quantité
	    if (qtyStr.isEmpty() && !qtyStr.matches(qtyRegex)) {
	        erreur = true;
	        session.setAttribute("qtyErreur", "Veuillez saisir la quantité !");
	    } else {
	        session.setAttribute("qtyErreur", null); // Réinitialiser le message d'erreur
	    }
	    
	    // Validation du champ catégorie
	    if (idCategorieStr.isEmpty() && !idCategorieStr.matches(categorieRegex)) {
	        erreur = true;
	        session.setAttribute("catErreur", "Veuillez choisir une catégorie de produit !");
	    } else {
	        session.setAttribute("catErreur", null); // Réinitialiser le message d'erreur
	    }
	    
	    // Si aucune erreur, insérer le produit et rediriger vers la page de connexion
	    if (!erreur) {
	    	int pu = Integer.parseInt(puStr);
	    	int qty = Integer.parseInt(qtyStr);
	        int categorie = co.selectCat(idCategorieStr);
	        if (!co.produitExist(designation)) {
	        	co.ajoutProd(name, img, designation, pu, qty, categorie);
	            session.setAttribute("message", "Produit ajouté correctement !");
	            request.getRequestDispatcher("/menuProd.jsp").forward(request, response);
	            return;  // Ajout de return pour éviter l'exécution des lignes suivantes
	        } else {
	            session.setAttribute("message", "Le produit existe déjà !");
		        request.getRequestDispatcher("/ajoutProd.jsp").forward(request, response);
	        }
	    } else {
	        // En cas d'erreur, rediriger vers le formulaire d'ajout avec l'indication d'erreur
	        request.setAttribute("erreur", erreur);
	        request.getRequestDispatcher("/ajoutProd.jsp").forward(request, response);
	    }
	}
	
	public void doModifProd(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	    String idArticleParam = request.getParameter("idArticle");
	    try {
	        Connexion co = new Connexion();
	        if (idArticleParam != null && !idArticleParam.isEmpty()) {
	            int idArticle = Integer.parseInt(idArticleParam);

	            // Récupération des images actuelles et nouvelles
	            String[] currentImagesArray = request.getParameterValues("currentImages[]");
	            List<String> currentImages = (currentImagesArray != null) ? Arrays.asList(currentImagesArray) : Collections.emptyList();
	            String newImgModify = request.getParameter("newImgModify");
	            String newImgAdd = request.getParameter("newImgAdd");

	            // Ajout de vérifications pour éviter les chaînes nulles ou vides
	            String newPuParam = request.getParameter("newPu");
	            int newPu = (newPuParam != null && !newPuParam.isEmpty()) ? Integer.parseInt(newPuParam) : 0;

	            String newQtyParam = request.getParameter("newQty");
	            int newQty = (newQtyParam != null && !newQtyParam.isEmpty()) ? Integer.parseInt(newQtyParam) : 0;

	            HttpSession session = request.getSession();
	            boolean erreur = false;

	            // Nouveau paramètre pour le bouton radio sélectionné
	            final String SELECTED_IMAGE_PARAM = "selectedImage";
	            String selectedImage = request.getParameter(SELECTED_IMAGE_PARAM);

	            // Mise à jour du produit, que l'image soit sélectionnée ou non
	            co.updateProd(request, idArticle, currentImages, newPu, newQty, newImgModify, newImgAdd, selectedImage);

	            // Récupération des données mises à jour du produit
	            Articles produitModif = co.getArticle(idArticle);

	            if (produitModif != null) {
	                // On appelle les données existantes du produit
	                request.setAttribute("designation", produitModif.getDesignation());
	                request.setAttribute("selectCat", produitModif.getCategorie());
	                produitModif.setImages(currentImages); // Mise à jour des images avec les actuelles
	                produitModif.setPu(newPu);
	                produitModif.setQty(newQty);

	                session.setAttribute("message", "Produit modifié correctement!");

	                // Redirection vers la page JSP de la liste des produits
	                request.getRequestDispatcher("/menuProd.jsp").forward(request, response);
	            } else {
	                // En cas d'erreur, rediriger vers le menu avec l'indication d'erreur
	                request.setAttribute("erreur", erreur);
	                request.getRequestDispatcher("/menuProd.jsp").forward(request, response);
	            }
	        } else {
	            response.sendError(HttpServletResponse.SC_BAD_REQUEST, "L'id du produit est manquant");
	        }
	    } catch (NumberFormatException e) {
	        // Gérer le cas où la conversion échoue
	        System.err.println("Erreur lors de la conversion de l'idArticle en entier : " + idArticleParam);
	        e.printStackTrace(); // Ajoutez cette ligne pour imprimer le message d'erreur complet
	        // Vous pouvez renvoyer un message d'erreur ou rediriger vers une page d'erreur
	        response.sendError(HttpServletResponse.SC_BAD_REQUEST, "L'id du produit est invalide");
	    } catch (Exception e) {
	        // Gérer d'autres exceptions
	        e.printStackTrace();
	        response.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR, "Erreur lors de la modification du produit");
	    }
	}
	
	public void doDeleteProd(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	    // Récupérer l'id de l'article à supprimer
	    String idArticleParam = request.getParameter("idArticle");

	    if (idArticleParam != null && !idArticleParam.isEmpty()) {
	        try {
	            // Convertir l'id en entier
	            int idArticle = Integer.parseInt(idArticleParam);

	            // Appeler la méthode de suppression
	            co.deleteProd(idArticle);
	            
	            // Ajouter le message de confirmation à la session
	            request.getSession().setAttribute("message", "Produit supprimé correctement!");
	            
	            // Redirection vers la page JSP de la liste des produits
                request.getRequestDispatcher("/menuProd.jsp").forward(request, response);
	        } catch (NumberFormatException e) {
	            // Gérer le cas où la conversion échoue
	            System.err.println("Erreur lors de la conversion de l'idArticle en entier : " + idArticleParam);
	            e.printStackTrace(); // Ajouter cette ligne pour imprimer le message d'erreur complet
	            // Renvoyer un message d'erreur ou rediriger vers une page d'erreur
	            response.sendError(HttpServletResponse.SC_BAD_REQUEST, "L'id du produit est invalide");
	        } catch (Exception e) {
	            // Gérer d'autres exceptions
	            e.printStackTrace();
	            response.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR, "Erreur lors de la suppression du produit");
	        }
	    } else {
	        // Gérer le cas où l'ID de l'article n'est pas spécifié
	        response.getWriter().write("{\"error\": \"ID de l'article non spécifié\"}");
	    }
	}
	
	private void doAjoutCommande(HttpServletRequest request, HttpServletResponse response) {
		
	}
	
	// -------------------------- Méthode HIBERNATE --------------------------------
	
	/*private void doAjoutProdHibernate(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String designation = request.getParameter("designation");
		String puStr = request.getParameter("pu");
		String qtyStr = request.getParameter("qty");
		String idCategorieStr = request.getParameter("selectCat");
		String name = request.getParameter("designation");
		
		int pu = Integer.parseInt(puStr);
    	int qty = Integer.parseInt(qtyStr);
    	int idCategorie = Integer.parseInt(idCategorieStr);
		
		Article a = new Article(designation,pu,qty,idCategorie,name);
		co.ajoutProdHibernate(a);
	}*/
	

}
