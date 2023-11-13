<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="ISO-8859-1">
	<link rel="stylesheet" href="css/bootstrap.min(1).css">
	<title>Gestion catégories</title>
</head>
	<body>
	
		<%@ include file="navbarAdmin.jsp" %>
		
		<div>
			<a href="ajoutProd.jsp" class="d-grid gap-1 p-2" style="text-decoration: none;">
				<button type='submit' class="btn btn-primary btn-lg">Ajouter</button>
			</a>
			<a href="menuAdmin.jsp" class="d-grid gap-1 p-2" style="text-decoration: none;">
				<button type='submit' class="btn btn-warning btn-lg">Retour</button>
			</a>
		</div>
		<div class="d-grid gap-1 p-2">
		    <span style="color: green; font-size: 0.8rem;">
		        <% 
		            // Vérifie si la session a été modifiée avant d'afficher le message
		            if (session != null && session.getAttribute("message") != null) {
		            	// Affiche le message stocké dans la session
		                out.print(session.getAttribute("message"));
		             	// Réinitialise le message après l'affichage pour éviter sa répétition
		                session.setAttribute("message", null);
		            }
		        %>
		    </span>
		</div>
		
		<script src="js/bootstrap.bundle.min.js"></script>
		<!--  <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.bundle.min.js"
			integrity="sha384-C6RzsynM9kWDrMNeT87bh95OGNyZPhcTNXj1NW7RuBCsyN/o0jlpcV8Qyq46cDfL"
			crossorigin="anonymous"></script> 
		-->
				
	</body>
</html>