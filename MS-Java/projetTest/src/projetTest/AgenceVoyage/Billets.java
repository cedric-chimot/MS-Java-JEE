package projetTest.AgenceVoyage;

public class Billets extends Voyage {
	protected String typeBillet;
	protected String depart;
	protected String destination;
	protected int distance;
	protected int nbPlaces;
	protected double reduction;
	private int taxe;

	public Billets(String nom, String prenom, String billet, String depart, String arrivee, int dist, int places, double reduc) {
		super(nom, prenom);
		this.typeBillet = billet;
		this.depart = depart;
		this.destination = arrivee;
		this.distance = dist;
		this.nbPlaces = places;
		this.reduction = reduc;
	}
	
	public Billets(String nom, String prenom, String billet,  String depart, String arrivee, int dist, int places, double reduc, int taxe) {
		super(nom, prenom);
		this.typeBillet = billet;
		this.depart = depart;
		this.destination = arrivee;
		this.distance = dist;
		this.nbPlaces = places;
		this.reduction = reduc;
		this.taxe = 20;
	}
	
	// Calcul du prix des billets de train
	public double prixTrain() {
		return (this.distance * 0.10) * this.nbPlaces * (1 - this.reduction);
	}

	// Calcul du prix des billets d'avion
	public double prixAvion() {
		return (this.distance * 0.20) * this.nbPlaces * (1 - this.reduction) + this.taxe;
	}
	
	// Vérification du type de billet
	public String getTypeBillet(boolean estAvion) {
		if(estAvion) {
			return "avion";
		} else {
			return "train";
		}
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

	public double getReduction() {
		return reduction;
	}

	public int getTaxe() {
		return taxe;
	}

	public String getTypeBillet() {
		return typeBillet;
	}
}
