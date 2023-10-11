package projetTest.Impots;

public class HabIndividuelle extends Habitation {
	// Variables appartenant aux habitations individuelles uniquement
	private int nbPieces;
	private boolean piscine;

	public HabIndividuelle(String proprietaire, String adresse, double surface, int nbPieces, boolean piscine) {
		super (proprietaire, adresse, surface);
		this.nbPieces = nbPieces;
		this.piscine = piscine;
	}

	public int getNbPieces() {
		return nbPieces;
	}

	public boolean isPiscine() {
		return piscine;
	}
	
	public double impot() {
		// Import de la méthode "impot" de la classe mère
		double impotDepart = super.impot();
		// Calcul de la part supplémentaire par rapport aux pièces
		double impotSupp = nbPieces * 100;
		// Ajout du supplément si piscine
		if(piscine) {
			impotSupp += 500;
		}
		return impotDepart + impotSupp;
	}

	public void affiche() {
		// Import de l'affichage de la classe mère
		super.affiche();
		// "(piscine ? "Oui" : "Non")" : condition qui affiche oui ou non s'il y a ou pas une piscine
		System.out.println("Nombre de pièces : " + nbPieces + "\nPiscine : " + (piscine ? "Oui" : "Non"));
	}
	
}
