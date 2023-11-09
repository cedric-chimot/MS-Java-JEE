import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

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
		} else {
			this.doGet(request, response);
		}
	}

	private void doConnexion(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String login = request.getParameter("pseudo");
		String pwd = request.getParameter("mdp");
		String pwdBDD = co.verifCoordonnees(login);
		if(pwdBDD == null) {
			request.getRequestDispatcher("/connexionKO.jsp").forward(request, response);
		} else {
			if(pwd.equalsIgnoreCase(pwdBDD)) {
				request.getRequestDispatcher("/connexionOK.jsp").forward(request, response);
			} else {
				request.getRequestDispatcher("/connexionKO.jsp").forward(request, response);
			}
		}
	}
	
	private void doInscription(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String fname = request.getParameter("nom");
		String lname = request.getParameter("prenom");
		String adresse = request.getParameter("adresse");
		String tel = request.getParameter("tel");
		String ageStr = request.getParameter("age");
		String sexe = request.getParameter("sexe");
		String login = request.getParameter("pseudo");
		String pwd = request.getParameter("mdp");
		
		HttpSession session = request.getSession();
		
		boolean erreur = false;
		String fnameRegex = "^[A-Za-z0-9.-/]+$";
		String lnameRegex = "^[A-Za-z0-9.-/]+$";
		String adresseRegex = "^[A-Za-z0-9.-/]+$";
		String telRegex = "^[A-Za-z0-9.-/]+$";
		String ageStrRegex = "^(1[5-9]|[2-9][0-9])$";
		String sexeRegex = "^[MF]$";
		String loginRegex = "^[A-Za-z0-9.-/]+$";
		String pwdRegex = "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[@#$%^&+=!])(?=\\S+$).{8,}$";


		if (fname.isEmpty() && !fname.matches(fnameRegex)) {
		    erreur = true;
		    session.setAttribute("nomErreur", "Le nom ne peut être vide !");
		} else {
			session.setAttribute("nomErreur", null);
		}
		
		if (lname.isEmpty() && !lname.matches(lnameRegex)) {
		    erreur = true;
		    session.setAttribute("prenomErreur", "Le prénom ne peut être vide !");
		} else {
			session.setAttribute("prenomErreur", null);
		}
		
		if (adresse.isEmpty() && !adresse.matches(adresseRegex)) {
		    erreur = true;
		    session.setAttribute("adresseErreur", "L'adresse ne peut être vide !");
		} else {
			session.setAttribute("adresseErreur", null);
		}
		
		if (tel.isEmpty() && !tel.matches(telRegex)) {
		    erreur = true;
		    session.setAttribute("telErreur", "Le téléphone ne peut être vide !");
		} else {
			session.setAttribute("telErreur", null);
		}

		if (ageStr.isEmpty() && !ageStr.matches(ageStrRegex)) {
		    erreur = true;
		    session.setAttribute("ageErreur", "L'âge ne peut être vide !");
		} else {
			session.setAttribute("ageErreur", null);
		}
		
		if (sexe.isEmpty() && !sexe.matches(sexeRegex)) {
		    erreur = true;
		    session.setAttribute("sexeErreur", "Le sexe ne peut être vide !");
		} else {
			session.setAttribute("sexeErreur", null);
		}
		
		if (login.isEmpty() && !login.matches(loginRegex)) {
		    erreur = true;
		    session.setAttribute("pseudoErreur", "Le pseudo ne peut être vide !");
		} else {
			session.setAttribute("pseudoErreur", null);
		}
		
		if (pwd.isEmpty() && !pwd.matches(pwdRegex)) {
		    erreur = true;
		    session.setAttribute("pwdErreur", "Le mot de passe doit comporter une majuscule, une minuscule, un caractère spécial et au minimum 8 caractères !");
		} else {
			session.setAttribute("pwdErreur", null);
		}
		
		if(!erreur) {
		    int age = Integer.parseInt(ageStr);
		    co.insertCompte(login, pwd, "s");
		    co.insertUsers(fname, lname, adresse, tel, age, sexe);
		    request.getRequestDispatcher("/connect.jsp").forward(request, response);
		    return;
		} else {
			request.setAttribute("erreur", erreur);
			request.getRequestDispatcher("/inscrit.jsp").forward(request, response);
		}
		
	}

}
