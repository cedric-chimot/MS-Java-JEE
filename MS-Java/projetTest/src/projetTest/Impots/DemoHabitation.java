package projetTest.Impots;

public class DemoHabitation {

	public static void main(String[] args) {
		Commune maCommune = new Commune();
		HabIndividuelle maison1 = new HabIndividuelle("Cédric", "rue de Java", 200, 9, true);
		HabProfessionnelle societe1 = new HabProfessionnelle("Cédric", "rue de Java", 550, 14);
		maCommune.ajoutHabitation(maison1);
		maCommune.ajoutHabitation(societe1);
		System.out.println("Maison : \n");
		maison1.affiche();
		System.out.println("Montant de l'impôt : " + maison1.impot() + " euros\n");
		System.out.println("Société : \n");
		societe1.affiche();
		System.out.println("Montant de l'impôt : " + societe1.impot() + " euros\n");
		maCommune.impotCommune();
	}

}
