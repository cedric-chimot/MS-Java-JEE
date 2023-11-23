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
	
		<%@ include file="navbar.jsp" %>
	
		<div class="container bg-dark text-center">
			<h1>Bienvenue <%= session.getAttribute("bienvenue") %> !</h1>
			
			<h3 class="text-center text-light mt-4">Que voulez-vous faire ?</h3>
			
			<div class="d-grid gap-1 p-2">
				<a href="modifProfil.jsp">
					<button type='button' class="btn btn-primary btn-lg">Modifier mon profil</button>
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