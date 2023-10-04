package projetTest.tp1.Rectangle;

public class Rectangle {
	
	private Point origine;
	private int largeur = 0;
	private int hauteur = 0;
	
	public Rectangle(Point p, int l, int h) {
		origine = p;
		largeur = l;
		hauteur = h;
	}
	
	public int perimetre() { 
		return ((largeur+hauteur)*2);
	}

	public int surface() {
		return (largeur*hauteur);
	}
	
	public int getAbscisse() {
		return origine.getX();
	}
	
	public int getOrdonnee() {
		return origine.getY();
	}
	
	public int getLargeur() {
		return largeur;
	}

	public int getHauteur() {
		return hauteur;
	}
	
}
