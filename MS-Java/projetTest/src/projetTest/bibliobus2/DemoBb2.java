package projetTest.bibliobus2;

import java.util.ArrayList;
import java.util.List;

public class DemoBb2 {

	public static void main(String[] args) {
		Bibliobus2 bb1 = new Bibliobus2("BB1", 200);
		Bibliobus2 bb2 = new Bibliobus2("BB2", 200);
		System.out.println(bb1.toString());
		System.out.println(bb2.toString());
		bb1.ajoutLivre("Toto en vacances", "Toto", "Editions Toto", 2, Genre2.Bande_dessinee);
		bb1.ajoutLivre("Les blagues de Toto vol. 1", "Toto", "Editions Toto", 3,Genre2.Litterature_jeunesse);
		bb1.ajoutLivre("Les blagues de Toto vol. 2", "Toto", "Editions Toto", 1, Genre2.Litterature_jeunesse);
		bb1.ajoutLivre("Les blagues de Toto vol. 3", "Tata", "Editions Toto", 2, Genre2.Bande_dessinee);
		bb2.ajoutLivre("Martine en vacances", "Titi", "Editions Toto", 4, Genre2.Bande_dessinee);
		bb2.ajoutLivre("Martine à la ferme", "Toto", "Editions Toto", 2, Genre2.Documentaire);
		bb1.ajoutLivre("Les blagues de Toto vol. 1", "Toto", "Editions Toto", 2,Genre2.Litterature_jeunesse);
		List<Integer> pistesDisque1 = new ArrayList<>();
		pistesDisque1.add(10);
		bb1.ajoutDisque("Toto fait du rock", "Toto", 1, Genre2.Rock, pistesDisque1);
		List<Integer> pistesDisque2 = new ArrayList<>();
		pistesDisque2.add(12);
		bb2.ajoutDisque("Toto fait du rock (la suite)", "Toto", 1, Genre2.Rock, pistesDisque2);
		bb1.afficheCatalogue();
		bb2.afficheCatalogue();
		System.out.println(bb1.toString());
		System.out.println(bb2.toString());
	}

}
