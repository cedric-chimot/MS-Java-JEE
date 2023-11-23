/**
 * Gestion d'ajout de plusieurs images
 */

// Variable pour suivre le nombre d'images ajoutées
var indexImg = 1;
var maxImg = 3;

// Fonction pour ajouter dynamiquement un champ d'image
function ajoutImg() {
	// Limiter l'ajout à 3 images
	if(indexImg <= 3) {
		// Créer un nouveau groupe d'éléments div pour l'image
	    var newImgGroup = document.createElement('div');
	    newImgGroup.className = 'form-group mt-2';
	    newImgGroup.id = 'imgGroup' + indexImg;
	
	    // Créer une balise label pour l'élément input
	    var label = document.createElement('label');
	    label.className = 'form-label';
	    label.innerText = 'Image :';
	
	    // Créer un nouvel élément input de type file
		var input = document.createElement('input');
		input.type = 'file';
		input.id = 'img' + indexImg;
		input.name = 'img' + indexImg;
		input.className = 'form-control';
		input.size = '255';
		input.multiple = true;
	
	    // Ajouter le label et l'input au groupe d'images
	    newImgGroup.appendChild(label);
	    newImgGroup.appendChild(input);
	
	    // Récupérer le bouton "Ajouter une image"
	    var addImgButton = document.getElementById('ajouterImg');
	
	    // Insérer le nouveau groupe d'images juste avant le bouton "Ajouter une image"
	    addImgButton.parentNode.insertBefore(newImgGroup, addImgButton);
	
	    // Incrémenter l'index pour le prochain champ d'image
	    indexImg++;
	    
	    // Désactivation du bouton quand le nombre max est atteint
	    if(indexImg > maxImg) {
			addImgButton.disabled = true;
		}
	}	
};
 