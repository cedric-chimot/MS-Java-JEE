package projetTest.tp1.Rectangle;

public class DemoRectangle {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Point unPoint = new Point(23, 94);
		Rectangle rectangle = new Rectangle(unPoint, 100, 200);
		//System.out.println(rectangle.getOrigine());
		System.out.println("Abscisse : " + rectangle.getAbscisse());
		System.out.println("Ordonnée : " + rectangle.getOrdonnee());
		System.out.println("Largeur du rectangle : " + rectangle.getLargeur());
		System.out.println("Hauteur du rectangle : " + rectangle.getHauteur());
		System.out.println("Périmètre du rectangle : " + rectangle.perimetre());
		System.out.println("Surface du rectangle : " + rectangle.surface());
		unPoint.setX(27);
		unPoint.setY(90);
		System.out.println("Nouvelles coordonnées abscisse : " + unPoint.getX());
		System.out.println("Nouvelles coordonnées ordonnée : " + unPoint.getY());
	}

}
