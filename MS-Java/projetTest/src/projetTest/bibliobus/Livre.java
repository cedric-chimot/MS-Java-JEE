package projetTest.bibliobus;

public class Livre {
	// attributs des livres
	private int id;
	private String titre;
	private String auteur;
	private String editeur;
	private int exemplaires = 1;
	// Genre récupéré dans l'enum "Genre"
	private Genre genre;
	
	// auteur,titre et éditeur sont non modifiables
	// si le genre est précisé on l'affiche
	public Livre(int id, String tit, String aut, String edit, int exemp, Genre genre) {
		this.id = id;
		titre = tit.toUpperCase();
		auteur = aut.toUpperCase();
		editeur = edit;
		exemplaires = exemp;
		this.genre = genre;
	}
	
	// dans le cas ou le genre n'est pas précisé
	public Livre(int id, String tit, String aut, String edit, int exemp) {
		this.id = id;
		titre = tit.toUpperCase();
		auteur = aut.toUpperCase();
		editeur = edit;
		exemplaires = exemp;
		genre = Genre.Non_specifie;
	}

    // Créer une nouvelle instance de Livre avec les mêmes attributs que le livre actuel,
	public Livre nouvelEditeur(String unEditeur) {
	    // à l'exception de l'éditeur qui est remplacé par la nouvelle valeur.
	    Livre newEdit = new Livre(this.id, this.titre, this.auteur, unEditeur, this.exemplaires, this.genre);
	    
	    return newEdit;
	}

	public int getId() {
		return id;
	}
	
	public String getTitre() {
		return titre;
	}

	public String getAuteur() {
		return auteur;
	}

	public String getEditeur() {
		return editeur;
	}

	public Genre getGenre() {
		return genre;
	}

	public void setGenre(Genre genre) {
		this.genre = genre;
	}
	
	public int getExemplaires() {
		return exemplaires;
	}
	
	public void setExemplaires(int exemplaires) {
		this.exemplaires = exemplaires;
	}
	
	// vérifie si le livre n'existe pas dans la bibliothèque
	// sinon exemplaire = 1
	public void nouvelExemplaire() {
		if(exemplaires > 0) {
			nouvelExemplaire(1);
		} else {
			exemplaires = 1;
		}
	}
	
	// si au moins un exemplaire est présent
	public void nouvelExemplaire(int nb) {
		this.exemplaires = exemplaires + nb;
	}
	
	// vérifier le nombre d'exemplaire répertorié
	// s'il n'y en a pas le nb d'exmplaire est de 0 par défaut
	public void perteExemplaire(int nb) {
		if(exemplaires > 0) {
			this.exemplaires = exemplaires - nb;
		}
	}
	
	// chaine de caractères pour afficher les caractéristiques d'un livre
	public String toString() {
		return "ID : " + id + "\nTitre : " + titre + "\nAuteur : " + auteur + "\nEditeur : " + editeur
				+ "\nExemplaires : " + exemplaires + "\nGenre : " + genre + "\n";
	}
	
	// un exemplaire du livre est dans la bibliothèque
	public boolean estPresent() {
		if (exemplaires > 0) {
			return true;
		}
		return false;
	}
	
	public boolean equals(Livre l) {
		if (this.titre == l.titre && this.auteur == l.auteur && this.editeur == l.editeur) {
			return true;
		}
		return false;
	}

}
