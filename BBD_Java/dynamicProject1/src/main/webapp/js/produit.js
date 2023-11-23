/**
 * Ecouteur pour afficher une liste déroulante de catégories
 * Paramétrée pour afficher suivant la sélection de la liste
 */

// "EventListener" sur le changement de sélection dans la liste déroulante
document.getElementById('categorySelect').addEventListener('change', function() {
    // Soumettre automatiquement le formulaire lorsque la sélection change
    document.getElementById('searchForm').submit();
});

document.addEventListener('DOMContentLoaded', function () {
    var deleteLinks = document.querySelectorAll('.delete-article-link');
    var deleteFlagInput = document.getElementById('deleteFlag');

    deleteLinks.forEach(function (link) {
        link.addEventListener('click', function (event) {
            event.preventDefault();
            var articleId = link.getAttribute('data-article-id');
            var deleteArticleLink = document.getElementById('deleteArticleLink');
            deleteArticleLink.setAttribute('href', 'servletName?idArticle=' + articleId);
            // Mettre à jour la valeur du champ caché
            deleteFlagInput.value = 'deleteArticle';
        });
    });
});