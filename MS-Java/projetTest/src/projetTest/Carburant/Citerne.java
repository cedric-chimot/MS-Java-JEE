package projetTest.Carburant;

public class Citerne extends Vehicule {

	public Citerne(String immat, int charge) {
		super(immat, 3, 10, charge);
	}

	@Override
	public int calculVitMax() {
		if(charge == 0) {
			return 130;
		} else if(charge <= 1) {
			return 110;
		} else if(charge > 1 && charge <= 4) {
			return 90;
		} else {
			return 80;
		}
	}

}
