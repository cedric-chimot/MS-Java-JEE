package projetTest.bibliobus;

public class DemoBibliobus {

	public static void main(String[] args) {
		Bibliobus bb1 = new Bibliobus("BB1");
		Bibliobus bb2 = new Bibliobus("BB2");
		//Bibliobus bb3 = new Bibliobus("BB3", 100);
		System.out.println(bb1.toString());
		System.out.println(bb2.toString());
		bb1.ajoutLivre(1, "Les blagues de Toto vol. 1", "Toto", "Editions Toto", 3,Genre.aventure);
		bb1.ajoutLivre(2, "Les blagues de Toto vol. 2", "Toto", "Editions Toto", 1, Genre.aventure);
		bb1.ajoutLivre(3, "Les blagues de Toto vol. 3", "Toto", "Editions Toto", 1, Genre.aventure);
		bb2.ajoutLivre(1, "Martine en vacances", "Toto", "Editions Toto", 4, Genre.amour);
		bb2.ajoutLivre(2, "Martine à la ferme", "Toto", "Editions Toto", 2, Genre.fantastique);
		bb1.afficheCatalogue();
		bb2.afficheCatalogue();
		System.out.println(bb1.toString());
		System.out.println(bb2.toString());
		bb1.afficheLivre(2);
		//System.out.println(bb3.toString());
	}

}
