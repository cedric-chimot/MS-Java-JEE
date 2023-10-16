package projetTest.Carburant;

public abstract class Vehicule {
	// Variables communes à chaque classes
	protected String immatriculation;
	protected double poidVide;
	protected double chargeMax;
	protected int charge;
	
	public Vehicule(String immat, double poidVide, double chargeMax, int charge) {
		this.immatriculation = immat;
		this.poidVide = poidVide;
		this.chargeMax = chargeMax;
		this.charge = charge;
	}
	
	public String toString() {
		return "\nImmatriculation : " + immatriculation + "\n" + 
				"Poid à vide : " + poidVide + "t\n" + 
				"Charge maximale : " + chargeMax + "t\n" + 
				"Charge : " + charge + "t\n";
	}
	
	// Méthode abstraite qui sera utilisée avec des méthodes de calcul différentes dans les classes secondaires
	public abstract int calculVitMax();
	
	// Calcul de la consommation totale par rapport à la vitesse et au poids du véhicule
	public float calculConso(int vitesse) {
		int poidTotal = (int) (poidVide + charge);
		return Utilitaire.consommation(vitesse, poidTotal);
	}
	
}
