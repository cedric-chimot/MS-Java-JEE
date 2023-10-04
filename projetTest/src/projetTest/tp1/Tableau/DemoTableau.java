package projetTest.tp1.Tableau;

public class DemoTableau {

	public static void main(String[] args) {
		// déclaration
		int[] unTableau;
		
		//allocation de mémoire
		unTableau = new int[3];
		
		//initialisation
		unTableau[0] = 100;
		unTableau[1] = 200;
		unTableau[2] = 300;
		
		for (int i = 0 ; i < unTableau.length ; i++) {
			System.out.println("Elément "+i+" " + unTableau[i]);
		}
		
		String [] [] noms = {{ "Mr. ", "Mrs. ", "Ms " }, {"Smith", "Jones"}};
		
		System.out.println(noms[0][0] + noms[1][0]);
		System.out.println(noms[0][2] + noms[1][1]);
		for (int i = 0 ; i < noms.length ; i++) {
			for (int j = 0 ; j < noms.length ; j++) {
				System.out.println("Indices "+i+", "+j+" : "+noms[i][j]);
			}
		}
		
	}

}
