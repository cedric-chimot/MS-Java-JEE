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
		double impotSupp = 0.0;
		// Calcul de la part supplémentaire par rapport aux employés
		if(nbEmployes >= 10) {
			int nb = nbEmployes / 10;
			impotSupp = nb * 1000 + super.impot();
		} else {
			impotSupp = super.impot();
		}
		return impotSupp;
	}
	
	public void affiche() {
		// Import de l'affichage de la classe mère
		super.affiche();
		System.out.println("Nombre d'emmployés : " + nbEmployes);
	}
	
}
