package projetTest.Carburant;

public class DemoConvoi {

	public static void main(String[] args) {
		// Création des véhicules
		Vehicule camion1 = new CamionBache("XYZ123", 4);
		Vehicule camion2 = new Bus("XYZ456");
		Vehicule camion3 = new Citerne("ABC123", 2);
		CamionBache camion4 = new CamionBache("ABC456", 7);
		// Création du convoi
		Vehicule[] convoi1 = {camion1, camion2};
		Convoi convoiA = new Convoi(convoi1);
		// Appel du calcul de la consomation de carburant
		float consommationConvoiA = convoiA.calculConsoTotale();
		Vehicule[] convoi2 = {camion3, camion4};
		Convoi convoiB = new Convoi(convoi2);
		float consommationConvoiB = convoiB.calculConsoTotale();
		// Affichage des informations des convois
		System.out.println(convoiA);
		System.out.println("Vitesse maximale du convoiA : " + convoiA.calculVitMax() + "km/h" + "\n");
		// Afficher la consommation totale de carburant
		System.out.println("Consommation totale du convoi A : " + consommationConvoiA + " littres pour 100km\n");
		System.out.println(convoiB);
		System.out.println("Vitesse maximale du convoiB : " + convoiB.calculVitMax() + "km/h" + "\n");
		System.out.println("Consommation totale du convoi B : " + consommationConvoiB + " littres pour 100km\n");
	}

}
