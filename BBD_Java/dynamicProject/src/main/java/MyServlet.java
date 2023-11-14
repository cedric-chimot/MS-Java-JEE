import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

import dynamicProject.Articles;
import dynamicProject.Connexion;

/**
 * Servlet implementation class MyServlet
 */
@WebServlet("/MyServlet")

public class MyServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private Connexion co = new Connexion();
       
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
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
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
		} else {
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
		String img = request.getParameter("img");
		
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
	    // Récupération de l'id du produit à modifier
	    int idArticle = Integer.parseInt(request.getParameter("idArticle"));

	    // Appel de la méthode pour récupérer les données du produit à modifier
	    Articles produitModif = co.getArticle(idArticle);

	    // Récupération des autres paramètres
	    String newImg = request.getParameter("newImg");
	    int newPu = Integer.parseInt(request.getParameter("newPu"));
	    int newQty = Integer.parseInt(request.getParameter("newQty"));

	    HttpSession session = request.getSession();
	    boolean erreur = false;

	    if (produitModif != null) {
	        // On appelle les données existantes du produit
	        request.setAttribute("designation", produitModif.getDesignation());
	        request.setAttribute("selectCat", produitModif.getCategorie());
	        produitModif.setImg(newImg);
	        produitModif.setPu(newPu);
	        produitModif.setQty(newQty);

	        // Appel de la méthode updateProd
	        co.updateProd(idArticle, newImg, newPu, newQty);
	        session.setAttribute("message", "Produit modifié correctement!");

	        // Redirection vers la page JSP de la liste des produits
	        request.getRequestDispatcher("/menuProd.jsp").forward(request, response);
	    } else {
	        // En cas d'erreur, rediriger vers le menu avec l'indication d'erreur
	        request.setAttribute("erreur", erreur);
	        request.getRequestDispatcher("/menuProd.jsp").forward(request, response);
	    }
	}

}
