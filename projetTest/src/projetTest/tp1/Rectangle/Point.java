package projetTest.tp1.Rectangle;

public class Point {

	/** abscisse du point*/
	private int x = 0;
	
	/** ordonnée du point*/
	private int y = 0;
	
	/**On peut construire u point en donnant se coordonnées
	 * @param x abscisse du point
	 * @param y ordonnée du point
	*/
	public Point(int unX, int unY) {
		x = unX;
		y = unY;
	}
	
	/** Par défaut le point construit est l'origine du repere*/
	public Point() {
		this(0, 0);
	}

	public int getY() {
		return y;
	}

	public int getX() {
		return x;
	}
	
	public void setY(int y) {
		this.y = y;
	}
	
	public void setX(int x) {
		this.x = x;
	}
	
}
