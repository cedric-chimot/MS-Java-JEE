package dynamicProject;

public class Articles {
	private String designation;
	private int pu;
	private int qty;
	private String categorie;
	private String img;

	public Articles(String designation, int pu, int qty, String categorie, String img) {
		super();
		this.designation = designation;
		this.pu = pu;
		this.qty = qty;
		this.categorie = categorie;
		this.img = img;
	}

	public String getDesignation() {
		return designation;
	}

	public int getPu() {
		return pu;
	}

	public int getQty() {
		return qty;
	}

	public String getCategorie() {
		return categorie;
	}

	public String getImg() {
		return img;
	}
}
