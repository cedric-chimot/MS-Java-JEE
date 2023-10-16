package projetTest.Carburant;

public class DemoVehicule {

	public static void main(String[] args) {
		CamionBache camion1 = new CamionBache("XYZ123", 2);
		CamionBache camion2 = new CamionBache("XYZ456", 7);
		// Affichage camion1
		System.out.println("Camion 1 : " + camion1.toString());
		System.out.println("Vitesse maximale du camion1 : " + camion1.calculVitMax() + " km/h"  + "\n");
		// Affichage camion2
		System.out.println("Camion 2 : " + camion2.toString());
		System.out.println("Vitesse maximale du camion2 : " + camion2.calculVitMax() + " km/h" + "\n");
	}

}
