package projetTest.Impots;

import java.util.ArrayList;

public class Commune {
	//protected String nomCommune;
	private ArrayList<Habitation> habitations = new ArrayList<>();

	public Commune() {
		//this.nomCommune = nomCommune;
		this.habitations = new ArrayList<>();
	}
	
	// Ajout des habitations dans la commune
	public void ajoutHabitation(Habitation habitation) {
		habitations.add(habitation);
	}

	// Calcul des impôts pour une commune
	public void impotCommune() {
		// Définir le total de impôts
		double totalImpots = 0;
		// Boucle "for" pour parcourir les habitations de la commune et calculer les impôts
		for(Habitation habitation : habitations) {
			totalImpots += habitation.impot();
		}
		System.out.println("Total des impôts de la commune " + " : " + totalImpots + " €\n");
	}
}
