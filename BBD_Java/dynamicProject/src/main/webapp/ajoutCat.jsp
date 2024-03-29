<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="ISO-8859-1">
		<link rel="stylesheet" href="css/bootstrap.min(3).css">
		<title>Ajout cat�gorie</title>
	</head>
	<body>
		
		<%@ include file="navbarAdmin.jsp" %>
	
		<form action="MyServlet?flag=categorie" method="POST">
		    <fieldset>
		        <legend class="text-center">Ajouter une cat�gorie</legend>
		        <hr>
		        <div class="container text-center">
		            <div class="form-group mt-2">
		                <label class="form-label">D�signation :</label>
		                <input type="text" id="designation" name="designation" class="form-control" size="20">
					    <span style="color: red; font-size: 0.8rem;">
					        <% 
					            // V�rifie si la session a �t� modifi�e avant d'afficher le message
					            if (session != null && session.getAttribute("message") != null) {
					            	// Affiche le message stock� dans la session
					                out.print(session.getAttribute("message"));
					             	// R�initialise le message apr�s l'affichage pour �viter sa r�p�tition
					                session.setAttribute("message", null);
					            }
					        %>
					    </span>
		            </div>
		            <div class="d-grid gap-1 p-2">
		                <button type='submit' class="btn btn-primary btn-lg">Ajouter</button>
		                <button type='reset' class="btn btn-warning btn-lg">Annuler</button>
		            </div>
		        </div>
		    </fieldset>
		</form>
	
	
		<script src="js/bootstrap.bundle.min.js"></script>
		<!--  <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.bundle.min.js"
			integrity="sha384-C6RzsynM9kWDrMNeT87bh95OGNyZPhcTNXj1NW7RuBCsyN/o0jlpcV8Qyq46cDfL"
			crossorigin="anonymous"></script> 
		-->
		
	</body>
</html>