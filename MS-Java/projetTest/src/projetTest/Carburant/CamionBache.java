package projetTest.Carburant;

public class CamionBache extends Vehicule {

	public CamionBache(String immat, int charge) {
		super(immat, 4, 20, charge);
	}

	@Override
	public int calculVitMax() {
		if(charge == 0) {
			return 130;
		} else if(charge <= 3) {
			return 110;
		} else if(charge <=7) {
			return 90;
		} else {
			return 0;
		}
	}

}
