package projetTest.Fleuriste;

/**
 * Définir les actions du fleuriste
 */
public interface InterfaceFleuriste {
	
	public void creationBouquet(String nom, String prenom);
	
	public int quantiteEnStock(String nomFleur) ;
	
	public float prixDUneFleur(String nomFleur) ;
	
	public void ajoutFleur(String nomFleur, int qte) ;
	
	public void facturation();
	
}
