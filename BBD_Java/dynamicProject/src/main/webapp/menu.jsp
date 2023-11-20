<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="ISO-8859-1">
		<link rel="stylesheet" href="css/bootstrap.min(3).css">
		<title>Menu</title>
	</head>
	<body>
	
		<%@ include file="navbar.jsp" %>
		
		<div class='container bg-light text-center gap-2'>
			<a href="connect.jsp">
				<button type='button' class="btn btn-success btn-lg mt-2">Connection</button>
			</a>
			<hr>
			<a href="inscrit.jsp">
				<button type='button' class="btn btn-warning btn-lg">Inscription</button>
			</a>
			<hr>
			<a href="accueil.jsp">
				<button type='button' class="btn btn-primary btn-lg">Accueil</button>
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