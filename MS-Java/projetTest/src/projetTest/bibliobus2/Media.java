package projetTest.bibliobus2;

public class Media {
	protected int id;
	protected String titre;
	protected String auteur;
	protected Genre2 genre;
	protected int exemplaires = 1;
	
	public static Genre2[] genres = {
		Genre2.Litterature,
		Genre2.Litterature_jeunesse,
		Genre2.Policier,
	    Genre2.Bande_dessinee,
	    Genre2.Documentaire,
	    Genre2.Classique,
	    Genre2.Musique_du_monde,
	    Genre2.Rock,
	    Genre2.Pop,
	    Genre2.Chanson_française,
	    Genre2.Non_specifie
	};
	
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
	
	public int getId() {
		return id;
	}

	public String getTitre() {
		return titre;
	}

	public String getAuteur() {
		return auteur;
	}

	public void setGenre(Genre2 genre) {
		this.genre = genre;
	}
	
	public Genre2 getGenre() {
		return genre;
	}

	public int getExemplaires() {
		return exemplaires;
	}

	public void setExemplaires(int exemplaires) {
		this.exemplaires = exemplaires;
	}	

}
