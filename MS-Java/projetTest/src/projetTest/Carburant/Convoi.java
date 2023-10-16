package projetTest.Carburant;

public class Convoi {
	private Vehicule[] vehicules;
	
	public Convoi(Vehicule[] vehicules) {
		this.vehicules = vehicules;
	}
	
	public String toString() {
		String description = "Convoi de véhicules :\n";
		for(Vehicule vehicule : vehicules) {
			description += vehicule.toString();
		}
		return description;
	}
	
	public int calculVitMax() {
		// "Integer.MAX_VALUE" : initialise la vitesse max avec la plus grande valeur possible d'un entier
		int vitesseMax = Integer.MAX_VALUE;
		// On parcourt les véhicules du convoi
		for(Vehicule vehicule : vehicules) {
			// Méthode pour calculer la vitesse max du véhicule
			int vitesse = vehicule.calculVitMax();
			// Vérifie si la vitesse du véhicule est inférieure à la vitesse max du convoi
			if(vitesse < vitesseMax) {
				// Si oui on met à jour la vitesse max du convoi
				vitesseMax = vitesse;
			}
		}
		// On retourne la vitesse max du convoi
		return vitesseMax;
	}

}
