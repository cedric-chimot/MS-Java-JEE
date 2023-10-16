package projetTest.Carburant;

public class Bus extends Vehicule {

	public Bus(String immat) {
		super(immat, 4, 0, 0);
	}

	@Override
	public int calculVitMax() {
		return 150;
	}

}
