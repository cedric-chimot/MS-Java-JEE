<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ page import="java.util.List" %>
<%@ page import="dynamicProject.Articles" %>
<%@ page import="dynamicProject.Users" %>
<%@ page import="dynamicProject.Connexion" %>

<!DOCTYPE html>
<html>
	<head>
	    <meta charset="ISO-8859-1">
	    <link rel="stylesheet" href="css/bootstrap.min(3).css">
	    <title>Ajout Commande</title>
	</head>
	<body>
	
		<%@ include file="navbarAdmin.jsp" %>
		
		<div class="container text-center">
		    <h3 class="text-center text-light mt-4">Ajout de Commande</h3>
		    <hr>
		
		    <form action="MyServlet?flag=ajoutCommandeEtLignes" method="post">
		        <label for="dateCommande" class="form-label">Date de la commande :</label>
				<input type="text" name="dateCommande" id="dateCommande" class="form-control mb-2" required>
				
				<label for="client" class="form-label">Client :</label>
				<select name="client" id="client" class="form-select mb-2" required>
		            <option value=""></option>
				    <% 
				    	Connexion co = new Connexion();
				        List<Users> usersList = co.recupAllUsers();
				        for (Users user : usersList) {
				    %>
				    <option value="<%= user.getIdUsers() %>"><%= user.getFname() + " " + user.getLname() %></option>
				    <%
				        } 
				    %>
				</select>
				
				<!-- Ajouter une barre de recherche -->
				<label for="search" class="form-label">Rechercher un article :</label>
				<input type="text" id="search" class="form-control mb-2"
					onkeyup="filterTable()" placeholder="Entrez la désignation">
								
		        <!-- Tableau pour afficher les articles avec cases à cocher -->
		        <label for="client" class="form-label mb-2">Articles :</label>
		        <table class="table" id="tableauArticles">
		            <thead>
		                <tr>
		                    <th class="text-white mt-2">Articles</th>
		                    <th class="text-white mt-2">Ajouter</th>
		                    <th class="text-white mt-2">Quantité</th>
		                </tr>
		            </thead>
		            <tbody id="tbodyArticles" class="tbodyArticles">
		                <!-- Les lignes du tableau seront ajoutées dynamiquement ici -->
		                <% 
		                    List<Articles> articlesList = co.getAllArticles();
		                    for (Articles article : articlesList) {
		                %>
		                <tr>
		                    <td class="text-white"><%= article.getDesignation() %></td>
		                    <td><input type="checkbox" name="articles[]" value="<%= article.getIdArticle() %>"></td>
		                    <td><input type="number" name="quantite<%= article.getIdArticle() %>" class="form-control"></td>
		                </tr>
		                <%
		                    }
		                %>
		            </tbody>
		        </table>
		
		        <button type="submit" class="btn btn-primary mt-3">Ajouter la commande</button>
		    </form>
		    
		    <script src="js/commandes.js"></script>
		
		    <script src="js/bootstrap.bundle.min.js"></script>
		
		</div>
	
	</body>
</html>
