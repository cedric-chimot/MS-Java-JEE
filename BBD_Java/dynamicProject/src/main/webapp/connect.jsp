<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="ISO-8859-1">
		<link rel="stylesheet" href="css/bootstrap.min.css">
		<title>Connection</title>
	</head>
	<body>
	
		<%
			String login = request.getParameter("pseudo");
			String pwd = request.getParameter("mdp");
			if(login == null){login = "";}
			if(pwd == null){pwd = "";}
			
			if(request.getMethod().equals("POST") &&
					login.equals("admin") &&
					pwd.equals("admin")) {
		%>
		
		<h2>Bienvenue <%= login %></h2>
		
		<%
			} else {
		%>
	
			<form action="" method="POST">
				<fieldset>
					<legend class="text-center">Connection</legend>
					<hr>
					<div class="container text-center">
						<div class="form-group mt-2">
							<label class="form-label">Nom d'utilisateur</label>
							<input type="text" id="pseudo" name="pseudo" class="form-control">
						</div>
						<div class="form-group mt-2">
							<label class="form-label">Mot de passe</label>
							<input type="password" id="mdp" name="mdp" class="form-control">
						</div>
						<div class="d-grid gap-1 mt-2">
							<button type='submit' class="btn btn-success btn-lg">Valider</button>
							<button type='reset' class="btn btn-danger btn-lg">Annuler</button>
						</div>
					</div>
				</fieldset>
			</form>
		
		<%
			} 
		%>
		
	</body>
</html>