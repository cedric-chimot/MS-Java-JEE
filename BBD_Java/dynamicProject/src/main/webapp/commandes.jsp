<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ page import="java.util.List" %>
<%@ page import="dynamicProject.Articles" %>
<%@ page import="dynamicProject.Commande" %>
<%@ page import="dynamicProject.Users" %>
<%@ page import="dynamicProject.Connexion" %>
<%@ page import="dynamicProject.LigneCommande" %>

<!DOCTYPE html>
<html>
	<head>
	    <meta charset="ISO-8859-1">
	    <link rel="stylesheet" href="css/bootstrap.min(3).css">
	    <title>Gestion commandes</title>
	</head>
	<body>

		<%@ include file="navbarAdmin.jsp" %>
		
		<%
			// R�cup�rer toutes les commandes avec les lignes de commande depuis la base de donn�es
			Connexion co = new Connexion();
			List<Commande> commandesList = co.getAllCommandesWithLignes();
		%>
			
		<div class="container text-center">
		    <h3 class="text-center text-light mt-4">Gestion des commandes</h3>
		    <hr>
		
		    <table class="table">
		        <thead>
		        <tr>
		            <th class="text-white bg-secondary">Date Commande</th>
		            <th class="text-white bg-secondary">Client</th>
		            <th class="text-white bg-secondary">Articles</th>
		            <th class="text-white bg-secondary">Quantit�</th>
		        </tr>
		        </thead>
		        <tbody>
				    <!-- It�rer sur les commandes et afficher les d�tails -->
				    <% for (Commande commande : commandesList) { %>
				        <tr>
				            <td class="text-white bg-dark"><%= commande.getDateCommande() %></td>
				            <td class="text-white bg-dark">
				                <!-- R�cup�rer le nom et pr�nom du client -->
				                <% Users client = co.getUserById(commande.getIdUsers()); %>
				                <%= client.getLname() + " " + client.getFname() %>
				            </td>
				            <!-- Ajoutez d'autres colonnes pour les articles, la quantit�, etc. -->
				            <td class="text-white bg-dark">
				                <!-- It�rer sur les lignes de commande de la commande en cours -->
				                <% for (LigneCommande ligneCommande : commande.getLignesCommande()) { %>
				                    <!-- R�cup�rer l'article correspondant � la ligne de commande -->
				                    <% Articles article = co.getArticleById(ligneCommande.getIdArticle()); %>
				                    <%= article.getDesignation() %><br>
				                <% } %>
				            </td>
				            <td class="text-white bg-dark">
				                <!-- It�rer sur les lignes de commande de la commande en cours -->
				                <% for (LigneCommande ligneCommande : commande.getLignesCommande()) { %>
				                    <%= ligneCommande.getQtyCommandee() %><br>
				                <% } %>
				            </td>
				        </tr>
				    <% } %>
				</tbody>
		    </table>
		    
		    <!-- Bouton pour ouvrir la page d'ajoutCommande.jsp -->
		    <a href="ajoutCommandes.jsp" class="btn btn-primary mt-2">Ajouter une commande</a>
		    
		</div>
		
		<script src="js/bootstrap.bundle.min.js"></script>
		
	</body>
</html>
