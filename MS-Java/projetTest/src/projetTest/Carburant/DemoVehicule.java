package projetTest.Carburant;

public class DemoVehicule {

	public static void main(String[] args) {
		CamionBache camion1 = new CamionBache("XYZ123", 2);
		CamionBache camion2 = new CamionBache("XYZ456", 7);
		CamionBache camion3 = new CamionBache("ABC123", 0);
		CamionBache camion4 = new CamionBache("ABC456", 3);
		Vehicule[] convoi1 = {camion1, camion2};
		Convoi convoiA = new Convoi(convoi1);
		Vehicule[] convoi2 = {camion3, camion4};
		Convoi convoiB = new Convoi(convoi2);
		System.out.println(convoiA);
		System.out.println("Vitesse maximale du convoiA : " + convoiA.calculVitMax() + "km/h" + "\n");
		System.out.println(convoiB);
		System.out.println("Vitesse maximale du convoiB : " + convoiB.calculVitMax() + "km/h" + "\n");
		/*// Affichage camion1
		System.out.println("Camion 1 : " + camion1.toString());
		System.out.println("Vitesse maximale du camion1 : " + camion1.calculVitMax() + " km/h"  + "\n");
		// Affichage camion2
		System.out.println("Camion 2 : " + camion2.toString());
		System.out.println("Vitesse maximale du camion2 : " + camion2.calculVitMax() + " km/h" + "\n");*/
	}

}
