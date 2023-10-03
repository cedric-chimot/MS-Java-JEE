package projetTest.tp1.Vélo;

/** cette classe modélise l'état du vélo d'un cycliste qui roule*/

public class Velo {
	/** la vitesse actuelle du vélo*/
	private int vitesse = 0;
	
	public int getVitesse() {
		return vitesse;
	}
	
	
	/** le cycliste accélère
	 @param incrément indique de combien la vitesse du vélo augmente
	 */
	public void accelerer(int increment) {
		vitesse = vitesse + increment;
	}

	/** le cycliste freine
	 @param décrément indique de combien la vitesse du vélo diminue
	 */
	public void freiner(int decrement) {
	/**	calcul décrément avec condition
		if(this.vitesse > decrement) {
			this.vitesse -= decrement;
		} else{
			this.vitesse = 0;
		}
	*/
		vitesse = vitesse - decrement;
	
	}
	
	/** affiche l'état du vélo i.e. sa vitesse */
	public void imprimeEtat() {
		System.out.println("Vitesse : " + vitesse);
	}

}
