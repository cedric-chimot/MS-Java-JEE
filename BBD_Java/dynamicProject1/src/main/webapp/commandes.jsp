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
	    <title>Gestion commandes</title>
	</head>
	<body>

		<%@ include file="navbarAdmin.jsp" %>
		
		<div class="container text-center">
		    <h3 class="text-center text-light mt-4">Gestion des commandes</h3>
		    <hr>
		
		    <table class="table">
		        <thead>
		        <tr>
		            <th class="text-white bg-secondary">Date Commande</th>
		            <th class="text-white bg-secondary">Client</th>
		            <th class="text-white bg-secondary">Articles</th>
		            <th class="text-white bg-secondary">Quantité</th>
		        </tr>
		        </thead>
		        <tbody>
		        <!-- Les données des commandes seront affichées ici -->
		        </tbody>
		    </table>
		    
		    <!-- Bouton pour ouvrir la page d'ajoutCommande.jsp -->
		    <a href="ajoutCommandes.jsp" class="btn btn-primary mt-2">Ajouter une commande</a>
		    
		</div>
		
		<script src="js/bootstrap.bundle.min.js"></script>
		
	</body>
</html>
