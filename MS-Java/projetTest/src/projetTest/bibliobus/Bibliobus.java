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
    public Bibliobus(String nom, int capaciteMax) {
        this.nom = nom;
        this.capaciteMax = 200;
        this.tabLivres = new ArrayList<>();
        this.nbLivres = 0;
    }

    // Constructeur pour un bibliobus existant
    public Bibliobus(String nom, int capaciteMax, int nbLivres) {
        this.nom = nom;
        this.capaciteMax = capaciteMax;
        this.nbLivres = nbLivres;
        this.tabLivres = new ArrayList<>();
    }

    // Getters et setters
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

    // Ajouter un livre en vérifiant s'il existe déjà un livre équivalent
    public boolean ajoutLivre(int id, String titre, String auteur, String editeur, int exemplaires, Genre genre) {
        for (Livre livreExist : tabLivres) {
            if (livreExist.getTitre().equalsIgnoreCase(titre)
            		&& livreExist.getAuteur().equalsIgnoreCase(auteur)
            		&& livreExist.getEditeur().equalsIgnoreCase(editeur)) {
            	livreExist.nouvelExemplaire(exemplaires); // Incrémente le nombre d'exemplaires du livre existant
            	nbLivres += exemplaires;
            	capaciteMax -= exemplaires;
            	return true; // Livre ajouté avec succès
            }
        }

        // Aucun livre équivalent trouvé, vérifier s'il y a assez de place
        if (exemplaires <= capaciteMax) {
            // Créer un nouveau livre
            Livre livre = new Livre(id, titre, auteur, editeur, exemplaires, genre);
            // Ajouter le livre à la liste
            tabLivres.add(livre);
            // Incrémenter le nombre de livres par rapport aux exemplaires
            nbLivres += exemplaires;
            // Décrémenter la capacité max suivant le nombre d'exemplaires
            capaciteMax -= exemplaires;
            return true;
        } else {
            System.out.println("Capacité maximale atteinte, impossible d'ajouter un livre !\n");
            return false;
        }
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
    	// on compare l'indice et on vérifie sa présence dans le tableau
    	if(identifiant < tabLivres.size()) {
    		// s'il existe on affiche ses caractéristiques
    		Livre livre = tabLivres.get(identifiant);
            System.out.println("Caractéristiques du livre (Identifiant " + identifiant + "):");
            System.out.println(livre.toString());
    	} else {
    		System.out.println("L'identifiant est incorrect ou le livre n'existe pas !\n");
    	}
    }

    // Afficher les livres par auteur
    public void nbExempAuteur(String auteur) {
    	// total d'exemplaires de base à 0
    	int totalExemp = 0;
    	// boucle "for" pour parcourir le tableau de livres
    	for(Livre livre : tabLivres) {
    		// "ignore case" : pour ignorer la casse au moment de la saise du nom de l'auteur
    		// on va chercher le nom de l'auteur correspondant
    		if(livre.getAuteur().equalsIgnoreCase(auteur)) {
    			totalExemp += livre.getExemplaires();
    		}
    	}
    	System.out.println("Nombre de livres de l'auteur " + auteur + " dans le bus "
    			+ nom + " : " + totalExemp + " livres.\n");
    }
    
    // Afficher les livres par genre
    public void nbExempGenre(Genre genre) {
    	int totalExemp = 0;
    	for(Livre livre : tabLivres) {
    		// on va chercher le genre correspondant
    		if(livre.getGenre() == genre) {
    			totalExemp += livre.getExemplaires();
    		}
    	}
    	System.out.println("Nombre de livres du genre " + genre + " dans le bus "
    			+ nom + " : " + totalExemp + " livres.\n");
    }
    
}
