<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<link rel="stylesheet" href="css/bootstrap.min(1).css">
		<title>Accueil</title>
	</head>
	<body>
	
		<%@ include file="navbar.jsp" %>
	
		<div class='container bg-dark text-center'>
			<h1 class='text-success'>Hello world !</h1>
			<hr>
			
			<p class='text-warning fs-5'>Ceci est une page d'accueil</p>
			<hr>
			
			<a href="menu.jsp">
				<button type='button' class="btn btn-primary btn-lg">Menu</button>
			</a>
			<hr>
		</div>	
	
	<script src="js/bootstrap.bundle.min.js"></script>
	<!--  <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.bundle.min.js"
		integrity="sha384-C6RzsynM9kWDrMNeT87bh95OGNyZPhcTNXj1NW7RuBCsyN/o0jlpcV8Qyq46cDfL"
		crossorigin="anonymous"></script> 
	-->
	
	</body>
</html>