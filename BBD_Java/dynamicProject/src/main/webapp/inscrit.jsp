<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="ISO-8859-1">
		<link rel="stylesheet" href="css/bootstrap.min.css">
		<title>Inscription</title>
	</head>
	<body>
	
		<%@ include file="navbar.jsp" %>
				
		<form action="MyServlet?flag=inscrit" method="POST">
			<fieldset>
				<legend class="text-center">Inscription</legend>
				<hr>
				<div class="container text-center">
					<div class="form-group mt-2">
					    <label class="form-label">Nom :</label>
					    <input type="text" id="nom" name="nom" class="form-control" size="20">
					    <% if (request.getAttribute("erreur") != null &&
					        (boolean) request.getAttribute("erreur")) { %>
					        <span style="color: red;font-size: 0.8rem;">
					            <%= session.getAttribute("nomErreur") %>
					        </span>
					    <% } %>
					</div>
					<div class="form-group mt-2">
					    <label class="form-label">Prénom :</label>
					    <input type="text" id="prenom" name="prenom" class="form-control" size="20">
					    <% if (request.getAttribute("erreur") != null &&
					        (boolean) request.getAttribute("erreur")) { %>
					        <span style="color: red;font-size: 0.8rem;">
					            <%= session.getAttribute("prenomErreur") %>
					        </span>
					    <% } %>
					</div>
					<div class="form-group mt-2">
						<label class="form-label">adresse :</label>
						<input type="text" id="adresse" name="adresse" class="form-control" size="20">
						<% if (request.getAttribute("erreur") != null &&
							(boolean) request.getAttribute("erreur")) { %>
						    <span style="color: red;font-size: 0.8rem;">
						        <%= session.getAttribute("adresseErreur") %>
						    </span>
						<% } %>
					</div>
					<div class="form-group mt-2">
						<label class="form-label">Téléphone :</label>
						<input type="text" id="tel" name="tel" class="form-control" size="20">
						<% if (request.getAttribute("erreur") != null &&
							(boolean) request.getAttribute("erreur")) { %>
						    <span style="color: red;font-size: 0.8rem;">
						        <%= session.getAttribute("telErreur") %>
						    </span>
						<% } %>
					</div>
					<div class="form-group mt-2">
						<label class="form-label">Age :</label>
						<input type="text" id="age" name="age" class="form-control" size="2">
						<% if (request.getAttribute("erreur") != null &&
							(boolean) request.getAttribute("erreur")) { %>
						    <span style="color: red;font-size: 0.8rem;">
						        <%= session.getAttribute("ageErreur") %>
						    </span>
						<% } %>
					</div>
					<div class="form-group mt-2">
						<label class="form-label">Sexe :</label>
						<input type="text" id="sexe" name="sexe" class="form-control" size="10">
						<% if (request.getAttribute("erreur") != null &&
							(boolean) request.getAttribute("erreur")) { %>
						    <span style="color: red;font-size: 0.8rem;">
						        <%= session.getAttribute("sexeErreur") %>
						    </span>
						<% } %>
					</div>
					<div class="form-group mt-2">
					    <label class="form-label">Pseudo :</label>
					    <input type="text" id="pseudo" name="pseudo" class="form-control" size="20">
					    <% if (request.getAttribute("erreur") != null &&
					        (boolean) request.getAttribute("erreur")) { %>
					        <span style="color: red;font-size: 0.8rem;">
					            <%= session.getAttribute("pseudoErreur") %>
					        </span>
					    <% } %>
					</div>
					<div class="form-group mt-2">
						<label class="form-label">Mot de passe :</label>
						<input type="text" id="mdp" name="mdp" class="form-control" size="20">
						<% if (request.getAttribute("erreur") != null &&
							(boolean) request.getAttribute("erreur")) { %>
						    <span style="color: red;font-size: 0.8rem;">
						        <%= session.getAttribute("pwdErreur") %>
						    </span>
						<% } %>
					</div>
					<div class="d-grid gap-1 mt-2">
						<button type='submit' class="btn btn-primary btn-lg">Inscription</button>
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