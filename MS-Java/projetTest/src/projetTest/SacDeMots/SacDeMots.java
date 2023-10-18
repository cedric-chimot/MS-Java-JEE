package projetTest.SacDeMots;

import java.util.*;

public class SacDeMots {
	// On stocke le mot et ses occurences
	private Map<String, Integer> occurenceMot;

	public SacDeMots() {
		// Initialisation de la map
		occurenceMot = new HashMap<>();
	}
	
	public void ajouteUnMot(String mot) {
		// On vérifie si le mot existe dans la map
		if(occurenceMot.containsKey(mot)) {
			// S'il existe on incrément le nombre d'occurences
			int occurences = occurenceMot.get(mot);
			occurenceMot.put(mot, occurences + 1);
		} else {
			// S'il n'existe pas on l'ajoute avec une occurence de 1
			occurenceMot.put(mot, 1);
		}
	}
	
	public void supprimeUnMot() {
		
	}
	
	public void nbOccurences() {
		
	}
	
	public void plusFrequent() {
		
	}
	
	public void nbMotsDifferents() {
		
	}
}
