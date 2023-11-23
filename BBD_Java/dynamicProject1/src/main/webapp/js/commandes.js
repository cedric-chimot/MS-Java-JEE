var indexLigneArticle = 1;

    function ajoutNouvelleLigneArticle() {
        var container = document.getElementById("dynamicInputContainer");

        // Créer un div pour contenir les champs d'entrée
        var div = document.createElement("div");
        div.className = "mb-3";

        // Créer le champ d'entrée pour l'article
        var articleSelect = document.createElement("select");
        articleSelect.name = "article" + indexLigneArticle;
        articleSelect.className = "form-select";

        // Exemple de liste statique d'utilisateurs (remplacez cela par la liste réelle des utilisateurs)
        var usersList = [
            { id: 1, fname: "John", lname: "Doe" },
            { id: 2, fname: "Jane", lname: "Doe" },
            // Ajoutez d'autres utilisateurs au besoin
        ];

        // Remplacez cette partie avec la logique pour charger dynamiquement la liste des utilisateurs depuis la base de données
        for (var i = 0; i < usersList.length; i++) {
            var option = document.createElement("option");
            option.value = usersList[i].id;
            option.text = usersList[i].fname + " " + usersList[i].lname;
            articleSelect.appendChild(option);
        }

        // Créer le champ d'entrée pour la quantité
        var quantiteInput = document.createElement("input");
        quantiteInput.type = "number";
        quantiteInput.name = "quantite" + indexLigneArticle;
        quantiteInput.className = "form-control";

        // Ajouter les champs d'entrée au div
        div.appendChild(articleSelect);
        div.appendChild(quantiteInput);

        // Ajouter le div au conteneur
        container.appendChild(div);

        indexLigneArticle++;
    }