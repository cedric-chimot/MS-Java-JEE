package dynamicProject;

public class Articles {
	private int idArticle;
	private String designation;
	private int pu;
	private int qty;
	private String categorie;
	private String img;

	public Articles( int idArticle, String designation, int pu, int qty, String categorie, String img) {
		super();
		this.idArticle = idArticle;
		this.designation = designation;
		this.pu = pu;
		this.qty = qty;
		this.categorie = categorie;
		this.img = img;
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

	public String getImg() {
		return img;
	}
	
	public void setImg(String img) {
		this.img = img;
	}

}
