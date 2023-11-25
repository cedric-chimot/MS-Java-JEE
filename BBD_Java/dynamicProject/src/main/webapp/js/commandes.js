// Fonction JavaScript pour filtrer le tableau en temps réel
function filterTable() {
    // Récupérer l'élément d'entrée de recherche
    var input, filter, table, tr, td, i, txtValue;
    input = document.getElementById("search");

    // Convertir le texte de l'entrée en majuscules pour une recherche insensible à la casse
    filter = input.value.toUpperCase();

    // Récupérer le tableau et toutes ses lignes
    table = document.getElementById("tableauArticles");
    tr = table.getElementsByTagName("tr");
    
    // Parcourir toutes les lignes du tableau et masquer celles qui ne correspondent pas à la recherche
    for (i = 0; i < tr.length; i++) {
        // Récupérer le premier <td> de chaque ligne, qui contient la désignation
        td = tr[i].getElementsByTagName("td")[0];

        if (td) {
            // Récupérer le texte à l'intérieur du <td>
            txtValue = td.textContent || td.innerText;

            // Vérifier si le texte de la désignation contient le texte de recherche
            if (txtValue.toUpperCase().indexOf(filter) > -1) {
                // Afficher la ligne si elle correspond à la recherche
                tr[i].style.display = "";
            } else {
                // Masquer la ligne si elle ne correspond pas à la recherche
                tr[i].style.display = "none";
            }
        }
    }
}
