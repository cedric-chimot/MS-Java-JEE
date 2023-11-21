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
		
		    <!-- Fenêtre modale pour ajouter une commande -->
		    <div class="modal fade" id="ajoutCommandeModal" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">
		        <div class="modal-dialog">
		            <div class="modal-content">
		                <div class="modal-header">
		                    <h5 class="modal-title" id="exampleModalLabel">Ajouter une commande</h5>
		                    <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
		                </div>
		                <div class="modal-body">
		                    <!-- Formulaire pour ajouter une commande -->
		                    <form action="MyServlet?flag=ajoutCommande" method="post">
		                        <label for="dateCommande" class="form-label">Date de la commande:</label>
		                        <input type="text" name="dateCommande" id="dateCommande" class="form-control" required>
		                        <div id="lignesArticlesContainer">
		                            <div id="ligneArticle1">
		                                <!-- Menu déroulant pour sélectionner un article -->
		                                <label for="article1" class="form-label">Article :</label>
		                                <select name="article1" id="article1" class="form-select" required onchange="updateHiddenFields()">
		                                    <option value="" disabled selected>Choisir un article</option>
		                                    <%
		                                        Connexion co = new Connexion();
		                                        List<Articles> articlesList = co.getAllArticles();
		                                        try {
		                                            for (Articles article : articlesList) {
		                                    %>
		                                    <option value="<%= article.getIdArticle() %>"><%= article.getDesignation() %></option>
		                                    <%
		                                            }
		                                        } catch (Exception e) {
		                                            e.printStackTrace();
		                                        }
		                                    %>
		                                </select>
		                                <!-- Champ de saisie directe pour la quantité -->
		                                <label for="quantite1" class="form-label">Quantité :</label>
		                                <input type="number" name="quantite1" id="quantite1" class="form-control" required
		                                       onchange="updateHiddenFields()">
		                            </div>
		                        </div>
		                        <!-- Menu déroulant pour sélectionner le client -->
		                        <label for="client" class="form-label">Client:</label>
		                        <select name="client" id="client" class="form-select" required>
		                            <option value="" disabled selected>Choisir un client</option>
		                            <%
		                                // Récupération de la liste des utilisateurs à partir de la base de donnéesS
		                                List<Users> usersList = co.recupAllUsers();
		                                // Boucle pour générer dynamiquement les options du menu déroulant des clients
		                                for (Users user : usersList) {
		                            %>
		                            <option value="<%= user.getIdUsers() %>"><%= user.getFname() + " " + user.getLname() %></option>
		                            <%
		                                } %>
		                        </select>
		                        <!-- Tableau pour afficher les articles ajoutés -->
		                        <!-- Ajoutez ces champs cachés pour stocker les informations d'article et de quantité -->
		                        <input type="hidden" name="articleId" id="articleId" value="">
		                        <input type="hidden" name="quantite" id="quantite" value="">
		
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
		                        <button type="button" class="btn btn-success mt-3" onclick="ajoutNouvelleLigneArticle()">Ajouter un
		                            article
		                        </button>
		                        <button type="submit" class="btn btn-primary mt-3">Ajouter la commande</button>
		                    </form>
		                </div>
		            </div>
		        </div>
		    </div>
		
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
		        <tr>
		
		        </tr>
		        </tbody>
		    </table>
		    <!-- Bouton ou lien pour ouvrir le modal -->
		    <button type="button" class="btn btn-primary" data-bs-toggle="modal" data-bs-target="#ajoutCommandeModal">
		        Ajouter une commande
		    </button>
		</div>
		
		<script src="js/commandes.js"></script>
		
		<script src="js/bootstrap.bundle.min.js"></script>
		<!--  <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.bundle.min.js"
		    integrity="sha384-C6RzsynM9kWDrMNeT87bh95OGNyZPhcTNXj1NW7RuBCsyN/o0jlpcV8Qyq46cDfL"
		    crossorigin="anonymous"></script>
		-->
		
		<script>
		    function updateHiddenFields() {
		        // Récupérer la valeur sélectionnée dans le menu déroulant d'article
		        var selectedArticle = document.getElementById('article1');
		        var articleId = selectedArticle.options[selectedArticle.selectedIndex].value;
		        // Mettre à jour la valeur du champ caché articleId
		        document.getElementById('articleId').value = articleId;
		
		        // Récupérer la valeur dans le champ de saisie directe de quantité
		        var quantiteValue = document.getElementById('quantite1').value;
		        // Mettre à jour la valeur du champ caché quantite
		        document.getElementById('quantite').value = quantiteValue;
		    }
		</script>
	
	</body>
</html>
