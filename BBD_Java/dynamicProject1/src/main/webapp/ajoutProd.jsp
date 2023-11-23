<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import = "dynamicProject.*" %>
<%@ page import = "java.util.*" %>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="ISO-8859-1">
		<link rel="stylesheet" href="css/bootstrap.min(3).css">
		<title>Ajout produit</title>
	</head>
	<body>
		
		<%@ include file="navbarAdmin.jsp" %>
	
		<form action="MyServlet?flag=produit" method="POST">
			<fieldset>
				<legend class="text-center">Ajouter un produit</legend>
				<hr>
				<div class="container text-center">
					<div class="form-group mt-2">
					    <label class="form-label">Désignation :</label>
					    <input type="text" id="designation" name="designation" class="form-control" size="20">
					    <span style="color: red; font-size: 0.8rem;">
					        <% 
					            // Vérifie si la session a été modifiée avant d'afficher le message
					            if (session != null && session.getAttribute("desiErreur") != null) {
					            	// Affiche le message stocké dans la session
					                out.print(session.getAttribute("desiErreur"));
					             	// Réinitialise le message après l'affichage pour éviter sa répétition
					                session.setAttribute("desiErreur", null);
					            }
					        %>
					    </span>
					</div>
					<div class="form-group mt-2">
					    <label class="form-label">Prix unitaire :</label>
					    <input type="text" id="pu" name="pu" class="form-control" size="20">
					    <span style="color: red; font-size: 0.8rem;">
					        <% 
					            // Vérifie si la session a été modifiée avant d'afficher le message
					            if (session != null && session.getAttribute("puErreur") != null) {
					            	// Affiche le message stocké dans la session
					                out.print(session.getAttribute("puErreur"));
					             	// Réinitialise le message après l'affichage pour éviter sa répétition
					                session.setAttribute("puErreur", null);
					            }
					        %>
					    </span>
					</div>
					<div class="form-group mt-2">
						<label class="form-label">Quantité :</label>
						<input type="text" id="qty" name="qty" class="form-control" size="20">
						<span style="color: red; font-size: 0.8rem;">
					        <% 
					            // Vérifie si la session a été modifiée avant d'afficher le message
					            if (session != null && session.getAttribute("qtyErreur") != null) {
					            	// Affiche le message stocké dans la session
					                out.print(session.getAttribute("qtyErreur"));
					             	// Réinitialise le message après l'affichage pour éviter sa répétition
					                session.setAttribute("qtyErreur", null);
					            }
					        %>
					    </span>
					</div>
					<div class="form-group mt-2">
						<label class="form-label">Catégorie :</label>
						<% 
							Connexion c = new Connexion();
							List<String> l = new ArrayList<String>();
							l = c.listCat();
							String item;
						%>
						<select class="form-select" id="selectCat" name="selectCat">
							<option></option>
							<% 
								for(int i = 0 ; i < l.size() ; i++) {
									item = l.get(i);
							%>
								<option value=<%= item %>><%= item %></option>
							<%
								}
							%>
						</select>
						<span style="color: red; font-size: 0.8rem;">
					        <% 
					            // Vérifie si la session a été modifiée avant d'afficher le message
					            if (session != null && session.getAttribute("catErreur") != null) {
					            	// Affiche le message stocké dans la session
					                out.print(session.getAttribute("catErreur"));
					             	// Réinitialise le message après l'affichage pour éviter sa répétition
					                session.setAttribute("catErreur", null);
					            }
					        %>
					    </span>
					</div>
					<!-- Bouton d'ajout d'images -->
					<button type="button" class="btn btn-success btn-lg mt-2" id="ajouterImg"
						onclick="ajoutImg()">Ajouter une image
					</button>
					<div class="d-grid gap-1 p-2 mt-4">
						<button type='submit' class="btn btn-primary btn-lg">Ajouter</button>
						<button type='reset' class="btn btn-warning btn-lg">Annuler</button>
					</div>
					<span style="color: red; font-size: 0.8rem;">
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
			</fieldset>
		</form>
	
		<script src="js/ajoutProd.js"></script>
	
		<script src="js/bootstrap.bundle.min.js"></script>
		<!--  <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.bundle.min.js"
			integrity="sha384-C6RzsynM9kWDrMNeT87bh95OGNyZPhcTNXj1NW7RuBCsyN/o0jlpcV8Qyq46cDfL"
			crossorigin="anonymous"></script> 
		-->
		
	</body>
</html>