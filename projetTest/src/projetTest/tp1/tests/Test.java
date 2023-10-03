package projetTest.tp1.tests;

public class Test {

	public static void main(String[] args) {
		//Crée un objet de type Premiere
		Premiere prem = new Premiere();
		prem.affiche();
		prem.setMessage("bonjour le monde !");
		prem.affiche();
		prem.setMessage("Re coucou !");
		prem.affiche();
	}

}
