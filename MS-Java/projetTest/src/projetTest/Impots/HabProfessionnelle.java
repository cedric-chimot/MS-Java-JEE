package projetTest.Impots;

public class HabProfessionnelle extends Habitation {
	// Variables appartenant aux habitations professionnelles uniquement
		private int nbEmployes;

	public HabProfessionnelle(String proprietaire, String adresse, double surface, int nbEmployes) {
		super (proprietaire, adresse, surface);
		this.nbEmployes = nbEmployes;
	}

	public int getNbEmployes() {
		return nbEmployes;
	}

	public double impot() {
		// Import de la méthode "impot" de la classe mère
		double impotDepart = super.impot();
		// Calcul de la part supplémentaire par rapport aux employés
		double impotSupp = (nbEmployes / 10) * 1000;
		return impotDepart + impotSupp;
	}
	
	public void affiche() {
		// Import de l'affichage de la classe mère
		super.affiche();
		System.out.println("Nombre d'emmployés : " + nbEmployes);
	}
	
}
