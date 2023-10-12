package projetTest.AgenceVoyage;

public class Billets extends Voyage {
	protected String depart;
	protected String destination;
	protected int distance;
	protected int nbPlaces;
	protected float reduction;
	private int taxe;
	private double prixTrain;
	private double prixAvion;

	public Billets(String nom, String prenom, String depart, String arrivee, int dist, int places, float reduc) {
		super(nom, prenom);
		this.depart = depart;
		this.destination = arrivee;
		this.distance = dist;
		this.nbPlaces = places;
		this.reduction = reduc;
	}
	
	public Billets(String nom, String prenom, String depart, String arrivee, int dist, int places, float reduc, int taxe) {
		super(nom, prenom);
		this.depart = depart;
		this.destination = arrivee;
		this.distance = dist;
		this.nbPlaces = places;
		this.reduction = reduc;
		this.taxe = 20;
	}
	
	public void prixTrain() {
		prixTrain = (getDistance() * 0.10) * (1 - getReduction() * getNbPlaces());
	}

	public void prixAvion() {
		prixAvion = (getDistance() * 0.20 + taxe) * (1 - getReduction() * getNbPlaces());
	}
	
	public void totalFacture(double facture) {
		facture = prixTrain + prixAvion;
	}
	
	public String getDepart() {
		return depart;
	}

	public String getDestination() {
		return destination;
	}

	public int getDistance() {
		return distance;
	}

	public int getNbPlaces() {
		return nbPlaces;
	}

	public float getReduction() {
		return reduction;
	}

	public int getTaxe() {
		return taxe;
	}

	public double getPrixTrain() {
		return prixTrain;
	}

	public double getPrixAvion() {
		return prixAvion;
	}

}
