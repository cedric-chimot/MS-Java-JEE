package projetTest.bibliobus2;

public class Media {
	private int id;
	private String titre;
	private String auteur;
	private Genre2 genre;
	private int exemplaires = 1;
	
	public Media(int id, String tit, String aut, int exemp, Genre2 genre) {
		this.id = id;
		titre = tit.toUpperCase();
		auteur = aut.toUpperCase();
		this.genre = genre;
		this.exemplaires = exemp;
	}
	
	public Media(int id, String tit, String aut, int exemp) {
		this.id = id;
		titre = tit.toUpperCase();
		auteur = aut.toUpperCase();
		genre = Genre2.Non_specifie;
		this.exemplaires = exemp;
	}

}
