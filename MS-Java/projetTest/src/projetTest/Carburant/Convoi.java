package projetTest.Carburant;

public class Convoi {
	private Vehicule[] vehicules;
	
	public Convoi(Vehicule[] vehicules) {
		this.vehicules = vehicules;
	}
	
	// Affichage des données d'un convoi
	public String toString() {
		String description = "Convoi de véhicules :\n";
		// On parcourt les véhicules
		for(Vehicule vehicule : vehicules) {
			// On ajoute la description de chaque véhicule du convoi
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
	
	// Calcul de la consommation totale par rapport à la vitesse maximale
	public float calculConsoTotale() {
		// Vitesse max obtenue en appelant la méthode "calculVitMax"
		int vitesseMax = calculVitMax();
		// Initialise la consommation à 0
		float consoTotale = 0;
		
		// On parcourt les véhicule du convoi
		for(Vehicule vehicule : vehicules) {
			// On appelle la méthode "calculConso" dans la classe véhicule pour obtenir la consommation à la vitesse max du convoi
			// On l'ajoute ensuite à la consommation totale
			consoTotale += vehicule.calculConso(vitesseMax);
		}
		// On retourne la consommation totale
		return consoTotale;
	}

}
