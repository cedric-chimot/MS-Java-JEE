<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import = "dynamicProject.*" %>
<%@ page import = "java.util.*" %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="ISO-8859-1">
		<link rel="stylesheet" href="css/bootstrap.min(1).css">
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
					    <input type="text" id="nom" name="nom" class="form-control" size="20">
					</div>
					<div class="form-group mt-2">
					    <label class="form-label">Prix unitaire :</label>
					    <input type="text" id="prenom" name="prenom" class="form-control" size="20">
					</div>
					<div class="form-group mt-2">
						<label class="form-label">Quantité :</label>
						<input type="text" id="adresse" name="adresse" class="form-control" size="20">
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
					</div>
					<div class="form-group mt-2">
						<label class="form-label">Image :</label>
						<input type="file" id="tel" name="tel" class="form-control" size="20">
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