package projetTest.bibliobus;

public class Livre {
	// attributs des livres
	private String titre;
	private String auteur;
	private String editeur;
	private int exemplaires;
	// Genre récupéré dans l'enum "Genre"
	Genre genre;
	
	// auteur,titre et éditeur sont non modifiables
	public Livre(String tit, String aut, String edit, Genre genre) {
		titre = tit;
		auteur = aut;
		editeur = edit;
		if(genre == null) {
			this.genre = Genre.Non_spécifié;
		}else {
			this.genre = genre;
		}
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

	// vérifier si le genre est spécifié
	//si non "Non spécifié" par défaut
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
	
	// si le livre n'existe pas dans la bibliothèque
	public void nouvelExemplaire() {
		this.exemplaires = 1;
	}
	
	// si au moins un exemplaire est présent
	public void nouvelExemplaire(int nb) {
		this.exemplaires = exemplaires + nb;
	}
	
	// vérifier le nombre d'exemplaire répertorié
	// s'il n'y en a pas le nb d'exmplaire est de 0 par défaut
	public void perteExemplaire() {
		if(exemplaires > 0) {
			this.exemplaires = exemplaires - 1;
		}
	}
	
	// chaine de caractères pour afficher les caractéristiques d'un livre
	public String toString() {
		return "Titre : " + titre + " Auteur : " + auteur + " Editeur : " + editeur
				+ " Exemplaires : " + " Genre : " + genre;		
	}
	
	// un exemplaire du livre est dans la bibliothèque
	public boolean estPresent() {
		return true;
	}
}
