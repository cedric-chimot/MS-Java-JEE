package projetTest.tp2.nbComplexes;

public class LibComplexe {

	public static void main(String[] args) {
		Complexe unComplexe = new Complexe(10,2.5);
		Complexe unComplexe2 = new Complexe(14,-6.5);
		Complexe unComplexe3;
		Complexe unComplexe4;
		unComplexe3 = Complexe.somme(unComplexe,unComplexe2);
		unComplexe4 = Complexe.multi(unComplexe,unComplexe2);
		System.out.println("Partie réelle : " + unComplexe.getA());
		System.out.println("Partie imaginaire : " + unComplexe.getB());
		System.out.println("Module nombre complexe : " + unComplexe.module());
		System.out.println("Argument nombre complexe : " + unComplexe.argument());
		System.out.println("Argument nombre complexe : " + unComplexe.argument1());
		System.out.println("Somme nombre complexe : " + unComplexe3);
		System.out.println("Multiplication nombre complexe : " + unComplexe4);
	}

}
