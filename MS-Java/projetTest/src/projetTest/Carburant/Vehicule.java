package projetTest.Carburant;

public abstract class Vehicule {
	protected String immatriculation;
	protected double poidVide;
	protected double chargeMax;
	protected int charge;
	
	public Vehicule(String immat, double poidVide, double chargeMax, int charge) {
		this.immatriculation = immat;
		this.poidVide = poidVide;
		this.chargeMax = chargeMax;
		this.charge = charge;
	}
	
	public String toString() {
		return "\nImmatriculation : " + immatriculation + "\n" + 
				"Poid à vide : " + poidVide + "t\n" + 
				"Charge maximale : " + chargeMax + "t\n" + 
				"Charge : " + charge + "t\n";
	}
	
	public abstract int calculVitMax();
	
}
