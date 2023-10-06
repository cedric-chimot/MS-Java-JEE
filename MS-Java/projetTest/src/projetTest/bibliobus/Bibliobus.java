package projetTest.bibliobus;

public class Bibliobus {
	// nom du bibliobus
	private String nom;
	// tableau des livres
	private Livre[] tabLivre;
	// nombre max de livres dans le bus
	private int capaciteMax = 100;
	// nombre de livres dans le bibliobus
	private int nbLivres;
	
	// constructeur pour un nouveau bibliobus
	public Bibliobus(String nom, int capaciteMax) {
		this.nom = nom;
		this.capaciteMax = capaciteMax;
	}
	
	// constructeur pour un bibliobus existant
	public Bibliobus(String nom, int capaciteMax, int nbLivres) {
		this.nom = nom;
		this.capaciteMax = capaciteMax;
		this.nbLivres = nbLivres;
		// créer un tableau pour stocker des objets "livre"
		// la taille est définie par la variable "capaciteMax"
		tabLivre = new Livre[capaciteMax];
	}
	
	public String getNom() {
		return nom;
	}

	public Livre[] getTabLivre() {
		return tabLivre;
	}

	public int getCapaciteMax() {
		return capaciteMax;
	}

	public int getNbLivres() {
		return nbLivres;
	}
	
	// toString nouveau bibliobus
	public String toString() {
		return "Nom du bibliobus : " + getNom() + "\nCapacité : " + getCapaciteMax();
		
	}
	
	// ajouter un livre ne vérifiant qu'il y a suffisamment de place
	public boolean ajoutLivre(Livre livre) {
		if(nbLivres < capaciteMax) {
			tabLivre[nbLivres] = livre;
			nbLivres++;
			return true;
		}
		return false;
	}
	
	// afficher le catalogue d'un bibliobus
	public void afficheCatalogue() {
		
	}
		
}
