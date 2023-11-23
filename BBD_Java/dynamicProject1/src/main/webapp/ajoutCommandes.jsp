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
        <label for="dateCommande" class="form-label">Date de la commande:</label>
		<input type="text" name="dateCommande" id="dateCommande" class="form-control" required>
		
		<label for="client" class="form-label">Client:</label>
		<select name="client" id="client" class="form-select" required>
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

        <!-- Les menus déroulants pour l'article et la quantité -->
        <label for="article1" class="form-label">Article:</label>
        <select name="article1" id="article1" class="form-select mt-2 mb-2">
            <option value=""></option>
            <% 
                List<Articles> articlesList = co.getAllArticles();
                for (Articles article : articlesList) {
            %>
            <option value="<%= article.getIdArticle() %>"><%= article.getDesignation() %></option>
            <%
                }
            %>
        </select>

        <label for="quantite1" class="form-label">Quantité:</label>
        <input type="number" name="quantite1" id="quantite1" class="form-control mb-2">

        <!-- Tableau pour afficher les articles ajoutés -->
        <table class="table" id="tableauArticles">
            <thead>
                <tr>
                    <th class="text-white mt-2">Articles</th>
                    <th class="text-white mt-2">Quantité</th>
                </tr>
            </thead>
            <tbody id="tbodyArticles" class="tbodyArticles">
                <!-- Les lignes du tableau seront ajoutées dynamiquement ici -->
            </tbody>
        </table>

        <button type="button" class="btn btn-success mt-3" onclick="ajoutNouvelleLigneArticle()">Ajouter un article</button>

        <button type="submit" class="btn btn-primary mt-3">Ajouter la commande</button>
    </form>

    <script src="js/bootstrap.bundle.min.js"></script>

    <script>
        var indexLigneArticle = 1;
        var articlesList = [
            <%
                for (Articles article : articlesList) {
            %>
            {
                id: <%= article.getIdArticle() %>,
                designation: '<%= article.getDesignation() %>',
                qty: <%= article.getQty() %>
            },
            <%
                }
            %>
        ];

        function ajoutNouvelleLigneArticle() {
            var selectedArticle = document.getElementById('article1');
            var quantiteInput = document.getElementById('quantite1');

            var articleId = selectedArticle.options[selectedArticle.selectedIndex].value;
            var quantiteValue = quantiteInput.value;

            if (articleId !== "" && quantiteValue !== "") {
                var tbodyArticles = document.getElementById('tbodyArticles');
                var nouvelleLigneTableau = tbodyArticles.insertRow();

                var colonneArticle = nouvelleLigneTableau.insertCell(0);
                colonneArticle.textContent = selectedArticle.options[selectedArticle.selectedIndex].text;
                colonneArticle.classList.add('text-light');

                var colonneQuantite = nouvelleLigneTableau.insertCell(1);
                colonneQuantite.textContent = quantiteValue;
                colonneQuantite.classList.add('text-light');

                selectedArticle.value = "";
                quantiteInput.value = "";
            } else {
                alert("Veuillez sélectionner un article et saisir une quantité.");
            }
        }
    </script>

</div>

</body>
</html>
