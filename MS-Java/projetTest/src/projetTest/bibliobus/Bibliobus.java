package projetTest.bibliobus;

import java.util.ArrayList;
import java.util.List;

public class Bibliobus {
    // Nom du bibliobus
    private String nom;
    // Liste des livres
    private List<Livre> tabLivres = new ArrayList<Livre>();
    // Capacité maximale de livres dans le bus (constante)
    private int capaciteMax; 
    // Nombre de livres dans le bibliobus
    private int nbLivres;

    // Constructeur pour un nouveau bibliobus
    public Bibliobus(String nom) {
        this.nom = nom;
        this.capaciteMax = 100;
        this.tabLivres = new ArrayList<>();
        this.nbLivres = 0;
    }

    // Constructeur pour un bibliobus existant
    public Bibliobus(String nom,int capaciteMax, int nbLivres) {
        this.nom = nom;
        this.capaciteMax = capaciteMax;
        this.nbLivres = nbLivres;
        this.tabLivres = new ArrayList<>();
    }

    public String getNom() {
        return nom;
    }

    public List<Livre> getListeLivres() {
        return tabLivres;
    }

    public int getCapaciteMax() {
        return capaciteMax;
    }

    public int getNbLivres() {
        return nbLivres;
    }

    // toString pour le bibliobus
    public String toString() {
        return "Nom du bibliobus : " + getNom() + "\nCapacité : " + capaciteMax
            + "\nNombre de livres : " + getNbLivres() + "\n";
    }

    // Ajouter un livre en vérifiant qu'il y a suffisamment de place
    public boolean ajoutLivre(int id, String titre, String auteur, String editeur, int exemplaires, Genre genre) {
        // Vérifier s'il y a assez de place avant d'ajouter
        if (exemplaires <= capaciteMax) {
            // Créer un nouveau livre
            Livre livre = new Livre(id, titre, auteur, editeur, exemplaires, genre);
            // Ajouter le livre à la liste
            tabLivres.add(livre);
            // Incrémenter le nombre de livres par rapport aux exemplaires
            nbLivres+=exemplaires;
            // Décrémenter la capacité max suivant le nombre d'exemplaires
            capaciteMax-=exemplaires;
            return true;
        }
        return false;
    }

    // Afficher le catalogue du bibliobus
    public void afficheCatalogue() {
        System.out.println("Catalogue du bibliobus " + nom + " :\n");
        // boucle "for" pour afficher toutes les lignes du tableau
        for (int i = 0; i < tabLivres.size(); i++) {
            System.out.println(tabLivres.get(i).toString());
        }
    }

    // Getters pour afficher les caractéristiques d'un livre par l'ID
    public String getTitre(int identifiant) {
		return tabLivres.get(identifiant).getTitre();
    }
    
    public String getAuteur(int identifiant) {
		return tabLivres.get(identifiant).getAuteur();
    }
    
    public String getEditeur(int identifiant) {
		return tabLivres.get(identifiant).getEditeur();
    }
    
    public Genre getGenre(int identifiant) {
		return tabLivres.get(identifiant).getGenre();
    }
    
    public int getNbExemplaires(int identifiant) {
		return tabLivres.get(identifiant).getExemplaires();
    }
    
    public void afficheLivre(int identifiant) {
    	if(identifiant < tabLivres.size()) {
    		Livre livre = tabLivres.get(identifiant);
            System.out.println("Caractéristiques du livre (Identifiant " + identifiant + "):");
            System.out.println(livre.toString());
    	} else {
    		System.out.println("L'identifiant est incorrect ou le livre n'existe pas !");
    	}
        
    }

    
}
