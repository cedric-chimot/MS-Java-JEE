package projetTest.tp2.bulles;

public class TriBulles {
	
	public static void main(String[] args) {
		
		int[] tabBulles;
		
		tabBulles = new int[5];
		
		tabBulles[0] = 10;
		tabBulles[1] = 8;
		tabBulles[2] = 50;
		tabBulles[3] = 20;
		tabBulles[4] = 45;
		
		for(int i = 0 ; i < tabBulles.length ; i++) {
			while(tabBulles[i]>tabBulles[i+1]) {
				int j = tabBulles[i];
				tabBulles[i] = tabBulles[i+1];
				tabBulles[i+1] = j;
			}
			System.out.println("Elément "+i+" " + tabBulles[i]);
		}

	}

}
