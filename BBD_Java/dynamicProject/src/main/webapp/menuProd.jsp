<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import = "dynamicProject.*" %>
<%@ page import = "java.util.*" %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="ISO-8859-1">
		<link rel="stylesheet" href="css/bootstrap.min(1).css">		
		<title>Gestion produits</title>
	</head>
	<body>
		
		<%@ include file="navbarAdmin.jsp" %>
	
		<div class="container text-center">
		    <h3 class="text-center text-light mt-4">Gestion des produits</h3>
		    <hr>
		    
		    <form id="searchForm" action="menuProd.jsp" method="get" class="mb-3">
			    <label for="categorySelect" class="form-label">Choisir une cat�gorie :</label>
			    <select name="categorySearch" id="categorySelect" class="form-select mt-2">
			        <option value="">Toutes les cat�gories</option>
			        <% 
			            Connexion co = new Connexion();
			        
			     		// R�cup�ration de la liste des cat�gories � partir de la base de donn�es
			            List<String> categories = co.listCat(); 
			     		
			         	// Boucle pour g�n�rer dynamiquement les options de la liste d�roulante
			            for(String category : categories) {
			        %>
			        <!-- Option pour chaque cat�gorie -->
			        <option value="<%= category %>" <%=(category.equals(request.getParameter("categorySearch")) ? "selected" : "")%>>
			        	<%= category %>
			        </option>
			        <% } %>
			    </select>
			</form>
		    
		    <table class="table">
		    	<thead>
		    		<tr>
		    			<th class="text-white bg-secondary">Image</th>
		    			<th class="text-white bg-secondary">D�signation</th>
		    			<th class="text-white bg-secondary">Prix unitaire</th>
		    			<th class="text-white bg-secondary">Quantit�</th>
		    			<th class="text-white bg-secondary">Cat�gorie</th>
		    			<th class="text-white bg-secondary">Action</th>
		    		</tr>
		    	</thead>
		    	<tbody>
		    		<% 
		    			// R�cup�ration de la liste des articles en fonction de la cat�gorie s�lectionn�e
		    			List<Articles> articles; 
		    			
		    			// R�cup�ration du param�tre de recherche par cat�gorie depuis la requ�te
		    			String categorySearch = request.getParameter("categorySearch");
		    			
		    			// V�rification si une cat�gorie de recherche est sp�cifi�e
		    			if(categorySearch != null && !categorySearch.isEmpty()) {
		    				// Si une cat�gorie est sp�cifi�e, r�cup�ration des articles filtr�s par cat�gorie
		    				articles = co.articles(categorySearch);
		    			} else {
		    				// Si aucune cat�gorie sp�cifi�e, r�cup�ration de tous les articles
		    				articles = co.articles();
		    			}
		    		
		    			// Boucle pour g�n�rer dynamiquement les lignes du tableau
		    			for(Articles article : articles) {
		    		%>	 
		    		<tr>
		    			<!-- Cellule pour l'image avec un �l�ment img -->
		    			<td class="text-white bg-secondary text-center">
		    				<img src="images/<%= article.getImg() %>" alt="imgProd" width="30" height="30">
		    			</td>
		    			<td class="text-white bg-secondary text-center"><%= article.getDesignation() %></td>
		    			<td class="text-white bg-secondary text-center"><%= article.getPu() %></td>
		    			<td class="text-white bg-secondary text-center"><%= article.getQty() %></td>
		    			<td class="text-white bg-secondary text-center"><%= article.getCategorie() %></td>
		    			<td class="text-white bg-secondary text-center">
							<a href="modifProd.jsp?idArticle=<%= article.getIdArticle() %>" class="p-2" style="text-decoration: none;">
								<img src="https://icons.iconarchive.com/icons/hopstarter/soft-scraps/128/Text-Edit-icon.png"
									width="20" height="20">
							</a>
							<a href="menuProd.jsp" class="p-2" style="text-decoration: none;">	
								<img src="https://icons.iconarchive.com/icons/hopstarter/sleek-xp-software/16/Windows-Close-Program-icon.png"
									width="20" height="20">
							</a>
		    			</td>
		    		</tr>
		    		<% } %>
		    	</tbody>		    	
		    </table>
			<div>
				<a href="ajoutProd.jsp" class="d-grid gap-1 p-2" style="text-decoration: none;">
					<button type='submit' class="btn btn-primary btn-lg">Ajouter</button>
				</a>
				<a href="menuAdmin.jsp" class="d-grid gap-1 p-2" style="text-decoration: none;">
					<button type='submit' class="btn btn-warning btn-lg">Retour</button>
				</a>
			</div>
		    <div class="d-grid gap-1 p-2">
			    <span style="color: green; font-size: 0.8rem;">
			        <% 
			            // V�rifie si la session a �t� modifi�e avant d'afficher le message
			            if (session != null && session.getAttribute("message") != null) {
			            	// Affiche le message stock� dans la session
			                out.print(session.getAttribute("message"));
			             	// R�initialise le message apr�s l'affichage pour �viter sa r�p�tition
			                session.setAttribute("message", null);
			            }
			        %>
			    </span>
			</div>
		</div>
		
		<script src="js/produit.js"></script>
	
		<script src="js/bootstrap.bundle.min.js"></script>
		<!--  <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.bundle.min.js"
			integrity="sha384-C6RzsynM9kWDrMNeT87bh95OGNyZPhcTNXj1NW7RuBCsyN/o0jlpcV8Qyq46cDfL"
			crossorigin="anonymous"></script> 
		-->
		
	</body>
</html>