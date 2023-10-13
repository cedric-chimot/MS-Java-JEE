package projetTest.AgenceVoyage;

public class DemoAgence {

	public static void main(String[] args) {
		Voyage voyage = new Voyage("Chimot", "Cédric");
		Billets billetTrain = new Billets("Chimot", "Cédric", "train", "Saint Michel", "Lille", 130, 4, 0.25);
		Billets billetAvion = new Billets("Chimot", "Cédric", "avion", "Saint Michel", "Lille", 130, 4, 0.25);
		voyage.ajoutResa(billetTrain);
		voyage.ajoutResa(billetAvion);
		System.out.println(voyage);
		System.out.println(voyage.totalFacture());
	}

}
