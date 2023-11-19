<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ page import="dynamicProject.*" %>
<%@ page import="java.util.*" %>
<!DOCTYPE html>
<html>
	<head>
	    <meta charset="ISO-8859-1">
	    <link rel="stylesheet" href="css/bootstrap.min(1).css">
	    <title>Modifier un produit</title>
	</head>
	<body>
	
	<%@ include file="navbarAdmin.jsp" %>
	
	<form action="MyServlet?flag=modifProd" method="POST">
	    <!-- Section pour la modification de l'image existante -->
	    <fieldset>
	        <legend class="text-center">Modifier un produit</legend>
	        <hr>
	        <div class="container text-center">
	            <%
	                Connexion c = new Connexion();
	
	                // Récupération du paramètre "idArticle" de la requête
	                String idArticleParam = request.getParameter("idArticle");
	
	                // Déclaration de produitModif en dehors des balises
	                Articles produitModif = null;
	
	                // Vérification si le paramètre "idArticle" est présent dans la requête
	                if (idArticleParam != null) {
	                    // Conversion du paramètre "idArticle" en entier
	                    int idArticle = Integer.parseInt(idArticleParam);
	
	                    // Appel de la méthode de la classe Connexion pour récupérer les données du produit à modifier
	                    produitModif = c.getArticle(idArticle);
	
	                    // Vérification si les données du produit à modifier ont été récupérées avec succès
	                    if (produitModif != null) {
	                        // On appelle les données existantes du produit
	                        // et on les place dans les attributs de la requête pour les rendre accessibles dans le formulaire
	                        request.setAttribute("designation", produitModif.getDesignation());
	                        request.setAttribute("selectCat", produitModif.getCategorie());
	                    }
	                }
	            %>
	
	            <!-- Input caché pour récupérer l'id du produit -->
	            <input type="hidden" id="idArticle" name="idArticle" value="<%= request.getParameter("idArticle") %>" readonly>
	            <!-- Champ pour modifier une image existante -->
	            <div class="form-group mt-2">
	            	<label class="form-label">Images actuelles :</label>
	                <%
						int idArticleToModify = Integer.parseInt(request.getParameter("idArticle"));
						List<String> currentImages = c.recupImages(idArticleToModify);
						
						for (String imageName : currentImages) {
						%>
					        <img src="images/<%= imageName %>" alt="Image actuelle du produit" width="100">
					        <input class="form-check-input" type="radio" name="selectedImage" value="<%= imageName %>">					    
					<%
						}
					%>
	            </div>
	            <div class="form-group mt-2">
				    <label class="form-label">Modifier une image existante :</label>
				    <input type="file" id="newImgModify" name="newImgModify" class="form-control" size="255">
				</div>
	            <div class="form-group mt-2">
	                <label class="form-label">Désignation :</label>
	                <!-- "disabled" rend le champ visible mais non modifiable -->
	                <input type="text" id="designation" name="designation" class="form-control" size="20" value="<%= request.getAttribute("designation") %>" readonly>
	            </div>
	            <div class="form-group mt-2">
	                <label class="form-label">Prix unitaire :</label>
	                <input type="text" id="newPu" name="newPu" class="form-control" size="20" value="<%= produitModif != null ? produitModif.getPu() : "" %>">
	            </div>
	            <div class="form-group mt-2">
	                <label class="form-label">Quantité :</label>
	                <input type="text" id="newQty" name="newQty" class="form-control" size="20" value="<%= produitModif != null ? produitModif.getQty() : "" %>">
	            </div>
	            <div class="form-group mt-2">
	                <label class="form-label">Catégorie :</label>
	                <input type="text" id="selectCat" name="selectCat" class="form-control" value="<%= request.getAttribute("selectCat") %>" readonly>
	            </div>
	        </div>
	    </fieldset>
	    <div class="container text-center">
	        <div>
	            <a href="menuProd.jsp" class="d-grid gap-1 p-2" style="text-decoration: none;">
	                <button type='submit' class="btn btn-primary btn-lg">Modifier</button>
	            </a>
	            <a href="menuProd.jsp" class="d-grid gap-1 p-2" style="text-decoration: none;">
	                <button type='submit' class="btn btn-warning btn-lg">Retour</button>
	            </a>
	        </div>
	    </div>
	</form>

	<script src="js/bootstrap.bundle.min.js"></script>
	
	</body>
</html>      