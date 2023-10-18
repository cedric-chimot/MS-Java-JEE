package projetTest.Fleuriste;

import java.util.ArrayList;
import java.util.List;

public class DémoFleuriste {

	public static void main(String[] args) {
		// Création du stock de fleur
		List<Fleur> stockFleur = new ArrayList<Fleur>();
		
		Fleur rose = new Fleur("Rose", 5, 20);
		Fleur violette = new Fleur("Violette", 3, 10);
		Fleur orchidee = new Fleur("Orchidée", 7, 15);
		Fleur coquelicot = new Fleur("Coquelicot", 2, 10);
		Fleur cactus = new Fleur("Cactus", 9, 17);
		
		// Ajout des fleurs au stock
		stockFleur.add(rose);
		stockFleur.add(violette);
		stockFleur.add(orchidee);
		stockFleur.add(coquelicot);
		stockFleur.add(cactus);
		
		// Initialisation du fleuriste
		Fleuriste fleuriste1 = new Fleuriste(stockFleur);
		
		// Création du bouquet
		fleuriste1.creationBouquet("Chimot", "Cédric");
		
		// Ajouter des fleurs au bouquet
		fleuriste1.ajoutFleur("Rose", 4);
		fleuriste1.ajoutFleur("Violette", 3);
		fleuriste1.ajoutFleur("Orchidée", 1);
		
		// Générer la facture d'achat du bouquet
		fleuriste1.facturation();
		
		// Création du bouquet
		fleuriste1.creationBouquet("Chimot", "Cédric");
				
		// Ajouter des fleurs au bouquet
		fleuriste1.ajoutFleur("Rose", 3);
		fleuriste1.ajoutFleur("Violette", 1);
		fleuriste1.ajoutFleur("Coquelicot", 4);
		fleuriste1.ajoutFleur("Cactus", 2);
				
		// Générer la facture d'achat du bouquet
		fleuriste1.facturation();
		
	}

}
