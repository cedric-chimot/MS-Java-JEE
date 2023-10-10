package projetTest.bibliobus;

public class DemoBibliobus {

	public static void main(String[] args) {
		Bibliobus bb1 = new Bibliobus("BB1", 200);
		Bibliobus bb2 = new Bibliobus("BB2", 200);
		//Bibliobus bb3 = new Bibliobus("BB3", 100);
		System.out.println(bb1.toString());
		System.out.println(bb2.toString());
		bb1.ajoutLivre("Les blagues de Toto vol. 1", "Toto", "Editions Toto", 3,Genre.Litterature_jeunesse);
		bb1.ajoutLivre("Les blagues de Toto vol. 2", "Toto", "Editions Toto", 1, Genre.Litterature_jeunesse);
		bb1.ajoutLivre("Les blagues de Toto vol. 3", "Tata", "Editions Toto", 2, Genre.Bande_dessinee);
		bb2.ajoutLivre("Martine en vacances", "Titi", "Editions Toto", 4, Genre.Bande_dessinee);
		bb2.ajoutLivre("Martine à la ferme", "Toto", "Editions Toto", 2, Genre.Documentaire);
		bb1.ajoutLivre("Les blagues de Toto vol. 1", "Toto", "Editions Toto", 2,Genre.Litterature_jeunesse);
		bb1.afficheCatalogue();
		bb2.afficheCatalogue();
		System.out.println(bb1.toString());
		System.out.println(bb2.toString());
		bb1.afficheLivre(1);
		bb1.nbExempAuteur("toto");
		bb2.nbExempGenre(Genre.Bande_dessinee);
		bb1.indiceAutGr("toto", null);
		bb1.appartientBus(bb1.getListeLivres().get(0));
		bb2.appartientBus(bb1.getListeLivres().get(0));
		//bb1.ajoutLivre("Les blagues de Toto vol. 1", "Toto", "Editions Toto", 2,Genre.Litterature_jeunesse);
		//bb1.afficheCatalogue();
		/*bb1.retirerLivre(2);
		bb1.afficheCatalogue();
		System.out.println(bb1.toString());*/
	}

}
