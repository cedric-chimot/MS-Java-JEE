package projetTest.Fleuriste;

import java.util.ArrayList;
import java.util.List;

public class Bouquet {
	private List<Fleur> fleurs = new ArrayList<Fleur>();
	private float prixTotal;
	private String nomClient;
	private String prenomClient;
	
	public Bouquet(String nomClient, String prenomClient) {
		this.nomClient = nomClient;
		this.prenomClient = prenomClient;
		this.prixTotal = 0;
	}

	public List<Fleur> getFleurs() {
		return fleurs;
	}

	public float getPrixTotal() {
		return prixTotal;
	}

	public String getNomClient() {
		return nomClient;
	}

	public String getPrenomClient() {
		return prenomClient;
	}
	
	public void ajouterFleur(Fleur fleur, int quantite) {
		for(int i = 0 ; i < quantite ; i++) {
			fleurs.add(fleur);
		}
	}
	
	public int qteFleur(Fleur fleur) {
		int qte = 0;
		for(Fleur fleurBouquet : fleurs) {
			if(fleurBouquet.equals(fleur)) {
				qte++;
			}
		}
		return qte;
	}
}
