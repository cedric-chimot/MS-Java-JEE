package projetTest.tp2.bulles;

public class TriBulles {
	
	public static void main(String[] args) {
		
		int[] tabBulles;
		
		tabBulles = new int[6];
		
		tabBulles[0] = 10;
		tabBulles[1] = 8;
		tabBulles[2] = 50;
		tabBulles[3] = 20;
		tabBulles[4] = 17;
		tabBulles[5] = 45;

		for(int i = 0 ; i < tabBulles.length ; i++) {
			for(int j = 1 ; j < (tabBulles.length-i) ; j++) {
				if(tabBulles[j-1] > tabBulles[j]) {
					int k = tabBulles[j-1];
					tabBulles[j-1] = tabBulles[j];
					tabBulles[j] = k;
				}
				
			}
			System.out.println("Elément "+i+" " + tabBulles[i]);
		}

	}

}
