<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="ISO-8859-1">
		<link rel="stylesheet" href="css/bootstrap.min(3).css">
		<title>Accueil admin</title>
	</head>
	<body>
	
		<%@ include file="navbarAdmin.jsp" %>
	
		<div class="container bg-dark text-center">
		    <h1>Bienvenue <%= session.getAttribute("bienvenue") %> !</h1>
		    <h3 class="text-center text-light mt-4">Que voulez-vous faire ?</h3>
		    <div class="d-grid gap-1 p-2">
		        <a href="menuProd.jsp">
		            <button type='button' class="btn btn-primary btn-lg"
		            	style="text-decoration: none;">
		            	Page Produits
		            </button>
		        </a>
		    </div>
		    <div class="d-grid gap-1 p-2">
		        <a href="menuCat.jsp">
		            <button type='button' class="btn btn-warning btn-lg mb-2"
		            	style="text-decoration: none;">
		            	Page Catégories
		            </button>
		        </a>
		    </div>
		</div>
		
		<script src="js/bootstrap.bundle.min.js"></script>
		<!--  <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.bundle.min.js"
			integrity="sha384-C6RzsynM9kWDrMNeT87bh95OGNyZPhcTNXj1NW7RuBCsyN/o0jlpcV8Qyq46cDfL"
			crossorigin="anonymous"></script> 
		-->
	
	</body>
</html>