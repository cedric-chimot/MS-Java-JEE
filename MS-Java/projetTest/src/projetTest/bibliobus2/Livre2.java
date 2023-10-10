package projetTest.bibliobus2;

public class Livre2 extends Media {
	// attributs des livres
	private int id;
	private String titre;
	private String auteur;
	private String editeur;
	private int exemplaires = 1;
	// Genre récupéré dans l'enum "Genre"
	private Genre2 genre;
	private String nomBus;
	
	// auteur,titre et éditeur sont non modifiables
	// si le genre est précisé on l'affiche
	public Livre2(int id, String tit, String aut, String edit, int exemp, Genre2 genre) {
		super(id, tit, aut, exemp, genre);
		editeur = edit;
	}
	
	// dans le cas ou le genre n'est pas précisé
	public Livre2(int id, String tit, String aut, String edit, int exemp) {
		this(id, tit, aut, edit, exemp, Genre2.Non_specifie);
	}

    // Créer une nouvelle instance de Livre avec les mêmes attributs que le livre actuel,
	public Livre2 nouvelEditeur(String unEditeur) {
	    // à l'exception de l'éditeur qui est remplacé par la nouvelle valeur.
	    Livre2 newEdit = new Livre2(this.id, this.titre, this.auteur, unEditeur, this.exemplaires, this.genre);
	    
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

	public Genre2 getGenre() {
		return genre;
	}

	public void setGenre(Genre2 genre) {
		this.genre = genre;
	}
	
	public int getExemplaires() {
		return exemplaires;
	}
	
	public void setExemplaires(int exemplaires) {
		this.exemplaires = exemplaires;
	}

	public String getNomBus() {
		return nomBus;
	}
	
	public void setNomBus(String nomBus) {
		this.nomBus = nomBus;
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
	
	/*public boolean equals(Livre l) {
		if (this.titre == l.titre && this.auteur == l.auteur && this.editeur == l.editeur) {
			return true;
		}
		return false;
	}*/

}
