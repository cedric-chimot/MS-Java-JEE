package projetTest.bibliobus2;

import java.util.ArrayList;
import java.util.List;

public class Disque extends Media {
	// Liste des pistes des disques
    private List<Integer> piste = new ArrayList<>();
	private String nomBus;

	public Disque(int id, String tit, String aut, int exemp, Genre2 genre, List<Integer> piste) {
		super(id, tit, aut, exemp, genre);
		this.piste = new ArrayList<>(piste);
	}
		
	public Disque(int id, String tit, String aut, int exemp, List<Integer> piste) {
		this(id, tit, aut, exemp, Genre2.Non_specifie, piste);
		this.piste = new ArrayList<>(piste);
	}

	public List<Integer> getPiste() {
		return piste;
	}

	public void setPiste(List<Integer> piste) {
		this.piste = piste;
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
	
	// chaine de caractères pour afficher les caractéristiques d'un disque
	public String toString() {
		return "ID : " + id + "\nTitre : " + titre + "\nAuteur : " + auteur + "\nExemplaires : "  
				+ exemplaires + "\nGenre : " + genre + "\nPistes : " + piste +  "\n";
	}
	
	// un exemplaire du livre est dans la bibliothèque
	public boolean estPresent() {
		if (exemplaires > 0) {
			return true;
		}
		return false;
	}
	
	public boolean equals(Disque d) {
		if (this.titre == d.titre && this.auteur == d.auteur) {
			return true;
		}
		return false;
	}
	
	// Vérification de la présence du genre dans le tableau de genre de la classe "Média"
	public boolean genreCorrect(Genre2 genre) {
		for(Genre2 g : genres) {
			if(g == genre) {
				return true;
			}
		}
		return false;
	}
}
