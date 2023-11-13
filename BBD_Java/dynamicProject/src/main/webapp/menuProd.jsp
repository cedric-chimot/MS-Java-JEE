<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import = "dynamicProject.*" %>
<%@ page import = "java.util.*" %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="ISO-8859-1">
		<link rel="stylesheet" href="css/bootstrap.min(1).css">		
		<title>Gestion produits</title>
	</head>
	<body>
		
		<%@ include file="navbarAdmin.jsp" %>
	
		<div class="container text-center">
		    <h3 class="text-center text-light mt-4">Gestion des produits</h3>
		    <table class="table">
		    	<thead>
		    		<tr>
		    			<th class="text-white bg-secondary">Désignation</th>
		    			<th class="text-white bg-secondary">Prix unitaire</th>
		    			<th class="text-white bg-secondary">Quantité</th>
		    			<th class="text-white bg-secondary">Catégorie</th>
		    			<th class="text-white bg-secondary">Image</th>
		    			<th class="text-white bg-secondary">Action</th>
		    		</tr>
		    	</thead>
		    	<tbody>
		    		<% 
		    			Connexion co = new Connexion();
		    			List<Articles> articles = co.articles(); 
		    		
		    			for(Articles article : articles) {
		    		%>	
		    		<tr>
		    			<td class="text-white bg-secondary text-center"><%= article.getDesignation() %></td>
		    			<td class="text-white bg-secondary text-center"><%= article.getPu() %></td>
		    			<td class="text-white bg-secondary text-center"><%= article.getQty() %></td>
		    			<td class="text-white bg-secondary text-center"><%= article.getCategorie() %></td>
		    			<td class="text-white bg-secondary text-center">
		    				<img src="images/<%= article.getImg() %>" alt="imgProd" width="30" height="30">
		    			</td>
		    			<td class="text-white bg-secondary text-center">
							<a href="modifProd.jsp" class="p-2" style="text-decoration: none;">
								<img src="https://icons.iconarchive.com/icons/hopstarter/soft-scraps/128/Text-Edit-icon.png"
									width="20" height="20">
							</a>
							<a href="menuProd.jsp" class="p-2" style="text-decoration: none;">	
								<img src="https://icons.iconarchive.com/icons/hopstarter/sleek-xp-software/16/Windows-Close-Program-icon.png"
									width="20" height="20">
							</a>
		    			</td>
		    		</tr>
		    		<% } %>
		    	</tbody>		    	
		    </table>
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
		</div>
	
		<script src="js/bootstrap.bundle.min.js"></script>
		<!--  <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.bundle.min.js"
			integrity="sha384-C6RzsynM9kWDrMNeT87bh95OGNyZPhcTNXj1NW7RuBCsyN/o0jlpcV8Qyq46cDfL"
			crossorigin="anonymous"></script> 
		-->
		
	</body>
</html>