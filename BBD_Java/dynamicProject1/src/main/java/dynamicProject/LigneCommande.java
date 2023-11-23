package dynamicProject;

public class LigneCommande {
	private int idLigneCommande;
	private int idCommande;
	private int idArticle;
	private int qtyCommandee;
	
	public LigneCommande(int idLigneCommande, int idCommande, int idArticle, int qtyCommandee) {
		super();
		this.idLigneCommande = idLigneCommande;
		this.idCommande = idCommande;
		this.idArticle = idArticle;
		this.qtyCommandee = qtyCommandee;
	}
	
	public int getIdLigneCommande() {
		return idLigneCommande;
	}
	public int getIdCommande() {
		return idCommande;
	}
	public int getIdArticle() {
		return idArticle;
	}
	public int getQtyCommandee() {
		return qtyCommandee;
	}
	
}
