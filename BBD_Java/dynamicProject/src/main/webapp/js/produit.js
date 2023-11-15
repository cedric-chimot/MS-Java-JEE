/**
 * Ecouteur pour afficher une liste déroulante de catégories
 * Paramétrée pour afficher suivant la sélection de la liste
 */

// "EventListener" sur le changement de sélection dans la liste déroulante
document.getElementById('categorySelect').addEventListener('change', function() {
    // Soumettre automatiquement le formulaire lorsque la sélection change
    document.getElementById('searchForm').submit();
});