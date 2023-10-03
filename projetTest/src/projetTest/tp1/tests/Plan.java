package projetTest.tp1.tests;

class Plan200 {
	int x = 9;
	int y = 7;
	public Plan200(int a, int b) {
		x=a;
		y=b;
	}
	
	public void afficher() {
		System.out.println(x+y);
	}
}

public class Plan {
	
	public static void main(String[] args) {
		Plan200 p = new Plan200(3,4);
		p.afficher();
		Plan200 p1 = new Plan200(24,55);
		p1.afficher();
	}

}
