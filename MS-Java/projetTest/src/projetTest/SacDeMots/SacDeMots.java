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
	
	public void supprimeUnMot(String mot) {
		// On vérifie si le mot existe
		if(occurenceMot.containsKey(mot)) {
			int occurences = occurenceMot.get(mot);
			if(occurences == 1) {
				// S'il n'y a qu'une seule occurence on le retire de la map
				occurenceMot.remove(mot);
			} else {
				// Sinon on décrémente le nombre d'occurences
				occurenceMot.put(mot, occurences - 1);
			}
		}
	}
	
	public int nbOccurences(String mot) {
		// On vérifie si le mot existe
		if(occurenceMot.containsKey(mot)) {
			// Si c'est le cas on retourne le nombre d'occurences
			return occurenceMot.get(mot);
		}
		// Sinon on retourne 0
		return 0;
	}
	
	public List<String> plusFrequents() {
		// Liste pour stocker les mots les + fréquents
		List<String> motFrequents = new ArrayList<>();
		// Variable des occurences maximum
		int freqOccurences = 0;
		
		// On parcourt la map des mots et de leurs occurences
		for(Map.Entry<String, Integer> entry : occurenceMot.entrySet()) {
			int occurences = entry.getValue();
			
			//Si le nombre d'occurences du mot est supérieur au maximum trouvé précédemment
			if(occurences > freqOccurences) {
				// On efface la précédente liste de mots les plus fréquents
				motFrequents.clear();
				// On ajoute le mot comme le seul plus fréquent
				motFrequents.add(entry.getKey());
				// On met à jour le nombre d'occurences maximum
				freqOccurences = occurences;
			} else if(occurences == freqOccurences) {
				// Si le nb d'occurences est égal au max, on ajoute ce mot à la liste des mots les + fréquents
				motFrequents.add(entry.getKey());
			}
		}
		// Retourne les mots les plus fréquents
		return motFrequents;
	}
	
	public int nbMotsDifferents() {
		// Retourne le nombre de mots différents
		return occurenceMot.size();
	}
}
