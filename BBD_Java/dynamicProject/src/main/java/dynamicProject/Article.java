package dynamicProject;

import javax.persistence.*;

@Entity
public class Article {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private String designation;
	private int pu;
	private int qty;
	private int categorie;
	private String images;

	public Article(String designation, int pu, int qty, int idCategorie, String name) {
		super();
		this.designation = designation;
		this.pu = pu;
		this.qty = qty;
		this.categorie = idCategorie;
		this.images = name;
	}
	
	public String getImages() {
		return images;
	}
	
	public void setImages(String images) {
		this.images = images;
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

	public int getCategorie() {
		return categorie;
	}

}
