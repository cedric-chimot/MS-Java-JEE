package dynamicProject;

import java.util.List;

public class Articles {
	private int idArticle;
	private String designation;
	private int pu;
	private int qty;
	private String categorie;
	private List<String> images;

	public Articles( int idArticle, String designation, int pu, int qty, String categorie, List<String> images) {
		super();
		this.idArticle = idArticle;
		this.designation = designation;
		this.pu = pu;
		this.qty = qty;
		this.categorie = categorie;
		this.images = images;
	}
	
	public Articles(int idArticle, String designation, int qty) {
		super();
		this.idArticle = idArticle;
		this.designation = designation;
		this.qty = qty;
	}

	public List<String> getImages() {
		return images;
	}
	
	public void setImages(List<String> images) {
		this.images = images;
	}
	
	public int getIdArticle() {
		return idArticle;
	}

	public String getDesignation() {
		return designation;
	}

	public int getPu() {
		return pu;
	}
	
	public void setPu(int pu) {
		this.pu = pu;
	}

	public int getQty() {
		return qty;
	}
	
	public void setQty(int qty) {
		this.qty = qty;
	}

	public String getCategorie() {
		return categorie;
	}

}
