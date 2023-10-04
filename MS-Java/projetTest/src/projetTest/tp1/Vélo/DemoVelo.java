package projetTest.tp1.Vélo;

/** Classe de test pour la classe @class velo*/
public class DemoVelo {

	public static void main(String[] args) {
		// Génère deux objets différents du type Velo
		Velo velo1 = new Velo();
		Velo velo2 = new Velo();
		
		// Invoque les méthodes
		velo1.accelerer(10);
		velo1.imprimeEtat();
		while(velo1.getVitesse()<40)
		{
			velo1.accelerer(3);
			velo1.imprimeEtat();
		}
		System.out.println("Vitesse de velo1 : " + velo1.getVitesse());
		while(velo1.getVitesse()>0) {
			velo1.freiner(5);
			velo1.imprimeEtat();
		}
		System.out.println("Vitesse de velo1 : " + velo1.getVitesse());
		velo2.accelerer(20);
		velo2.imprimeEtat();
	}

}
