package projetTest.Impots;

public class Habitation extends Commune {

	// Définition des variables
	protected String proprietaire;
	protected String adresse;
	protected double surface;
	
	// Constructeur de la classe
	public Habitation(String p, String a, double s) {
		this.proprietaire = p;
		this.adresse = a;
		this.surface = s;
	}

	// Calcul du montant de l'impôt
	public double impot() {
		return surface * 2;
	}
	
	// Affichage des attributs
	public void affiche() {
		System.out.println("Propriétaire : " + proprietaire + "\nAdresse : " + adresse+
				"\nSurface : " + surface + "m²");
	}
	
	
}
