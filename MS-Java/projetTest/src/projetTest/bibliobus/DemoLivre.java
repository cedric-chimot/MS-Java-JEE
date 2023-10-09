package projetTest.bibliobus;

public class DemoLivre {

	public static void main(String[] args) {
		Livre livre1 = new Livre(1, "Toto à la plage", "Toto", "Editions Toto", 1, Genre.Litterature_jeunesse);
		livre1.nouvelExemplaire(3);
		livre1.perteExemplaire(1);
		Livre livre2 = new Livre(2, "Martine à la plage", "Toto", "Editions Toto", 1, null);
		livre2.setGenre(Genre.Litterature_jeunesse);
		//livre1.setGenre(Genre.fantastique);
		System.out.println(livre1.toString());
		System.out.println(livre2.toString());
		//System.out.println(livre1.estPresent());
		//System.out.println(livre1.equals(livre2));
		Livre newEdit = livre1.nouvelEditeur("Editions Tata");
		System.out.println(newEdit.toString());
	}
}
