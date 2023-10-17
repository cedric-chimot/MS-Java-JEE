package projetTest.Fleuriste;

public class Fleur {
	private String nomFleur;
	private float prixUnit;
	private int quantite;
	
	public Fleur(String nomFleur, float prixUnit, int quantite) {
		this.nomFleur = nomFleur;
		this.prixUnit = prixUnit;
		this.quantite = quantite;
	}
	
	public Fleur(String nomFleur, int quantite) {
		this.nomFleur = nomFleur;
		this.quantite = quantite;
	}

	public String getNomFleur() {
		return nomFleur;
	}

	public float getPrixUnit() {
		return prixUnit;
	}

	public int getQuantite() {
		return quantite;
	}
	
	public void setQuantite(int quantite) {
		this.quantite = quantite;
	}
	
}
