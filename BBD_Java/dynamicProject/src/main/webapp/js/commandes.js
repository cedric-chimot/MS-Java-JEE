// Déclaration d'une variable pour suivre l'index des lignes d'article
var indexLigneArticle = 1;

// Fonction appelée lors de l'ajout d'une nouvelle ligne d'article
function ajoutNouvelleLigneArticle() {
    // Récupérer les éléments HTML des menus déroulants d'article et de quantité
    var selectedArticle = document.getElementById('article1');
    var quantiteInput = document.getElementById('quantite1');

    // Récupérer les valeurs sélectionnées dans les menus déroulants
    var articleId = selectedArticle.options[selectedArticle.selectedIndex].value;
    var quantiteValue = quantiteInput.value;

    // Vérifier si une option d'article est sélectionnée et si la quantité est saisie
    if (articleId !== "" && quantiteValue !== "") {
        // Créer une nouvelle ligne pour le tableau
        var nouvelleLigneTableau = document.createElement('tr');

        // Créer une cellule pour la colonne "Articles"
        var colonneArticle = document.createElement('td');
        // Définir le texte de la cellule avec le nom de l'article sélectionné
        colonneArticle.textContent = selectedArticle.options[selectedArticle.selectedIndex].text;
        // Ajouter une classe pour le style Bootstrap (texte blanc)
        colonneArticle.classList.add('text-light');

        // Créer une cellule pour la colonne "Quantité"
        var colonneQuantite = document.createElement('td');
        // Définir le texte de la cellule avec la quantité saisie
        colonneQuantite.textContent = quantiteValue;
        // Ajouter une classe pour le style Bootstrap (texte blanc)
        colonneQuantite.classList.add('text-light');

        // Ajouter les cellules à la ligne du tableau
        nouvelleLigneTableau.appendChild(colonneArticle);
        nouvelleLigneTableau.appendChild(colonneQuantite);

        // Ajouter la nouvelle ligne au tableau existant dans le HTML
        var tbodyArticles = document.getElementById('tbodyArticles');
        tbodyArticles.appendChild(nouvelleLigneTableau);

        // Réinitialiser les valeurs des menus déroulants et du champ de quantité
        selectedArticle.value = "";
        quantiteInput.value = "";
    } else {
        // Afficher une alerte si une option d'article n'est pas sélectionnée ou si la quantité n'est pas saisie
        alert("Veuillez sélectionner un article et saisir une quantité.");
    }
}
