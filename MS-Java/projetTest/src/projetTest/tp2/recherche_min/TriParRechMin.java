package projetTest.tp2.recherche_min;

public class TriParRechMin {

	public static void main(String[] args) {
		int[] tab;
		int min;
		int indiceMin;
		
		tab = new int[5];
		
		tab[0] = 10;
		tab[1] = 8;
		tab[2] = 50;
		tab[3] = 20;
		tab[4] = 17;
		
		for(int i = 0 ; i < (tab.length-1) ; i++) {
			min = tab[i];
			indiceMin = i;
			for(int j = i ; j < tab.length ; j++) {
				if(tab[j] < min) {
					indiceMin = j;
					min = tab[j];
				}
			}
			int k = tab[indiceMin];
			tab[indiceMin] = tab[i];
			tab[i] = k;
			System.out.println("Elément "+i+" " + tab[i]);
		}
	}

}
