package projetTest.bibliobus2;

import java.util.ArrayList;
import java.util.List;

import projetTest.bibliobus.Genre;
import projetTest.bibliobus.Livre;

public class Bibliobus2 {
	// Nom du bibliobus
    private String nom;
    // Liste des livres
    private List<Livre> tabLivres = new ArrayList<Livre>();
    // Capacité maximale de livres dans le bus (constante)
    private int capaciteMax; 
    // Nombre de livres dans le bibliobus
    private int nbLivres;

    // Constructeur pour un nouveau bibliobus
    public Bibliobus2(String nom, int capaciteMax) {
        this.nom = nom;
        this.capaciteMax = 200;
        this.tabLivres = new ArrayList<>();
        this.nbLivres = 0;
    }

    // Constructeur pour un bibliobus existant
    public Bibliobus2(String nom, int capaciteMax, int nbLivres) {
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
    public boolean ajoutLivre(String titre, String auteur, String editeur, int exemplaires, Genre genre) {
    	// boucle "for" pour parcourir le tableau et voir si un livre existe
        for (Livre livreExist : tabLivres) {
        	// vérifie si le livre existe par rapport à l'auteur, au titre et à l'éditeur
            if (livreExist.getTitre().equalsIgnoreCase(titre)
            		&& livreExist.getAuteur().equalsIgnoreCase(auteur)
            		&& livreExist.getEditeur().equalsIgnoreCase(editeur)) {
            	// S'il existe, on incrémente le nombre d'exemplaires du livre existant et on diminue la capacité max
            	livreExist.nouvelExemplaire(exemplaires);
            	nbLivres += exemplaires;
            	capaciteMax -= exemplaires;
            	return true; // Livre ajouté avec succès
            }
        }

        // Aucun livre équivalent trouvé, vérifier s'il y a assez de place
        if (exemplaires <= capaciteMax) {
            // Créer un nouveau livre
        	int newId = tabLivres.size();
            Livre livre = new Livre(newId, titre, auteur, editeur, exemplaires, genre);
            // Donne le nom du bus pour un livre
            livre.setNomBus(this.nom);
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
    
    // Méthode pour retirer un livre du catalogue par son ID
    public boolean retirerLivre(int id) {
        // Vérifier si l'indice est valide
        if (id >= 0 && id < tabLivres.size()) {
            Livre supprLivre = tabLivres.get(id);
            nbLivres -= supprLivre.getExemplaires(); // Mettre à jour le nombre total de livres
            capaciteMax += supprLivre.getExemplaires(); // Mettre à jour la capacité max
            tabLivres.remove(id); // Supprimer le livre de la liste en utilisant l'indice
            return true; // Livre retiré avec succès
        } else {
            System.out.println("Indice inconnu ou le livre n'existe pas !\n");
            return false; // Indice invalide, le livre n'a pas été retiré
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
    
    // Indice des livres par auteur
    public ArrayList<Integer> indiceAutGr(String auteur, Genre genre) {
    	// Créer une liste pour stocker les indices des livres correspondants
    	ArrayList<Integer> tabIndices = new ArrayList<Integer>();
    	
    	// Parcourir la liste des livres
    	for(int i = 0; i < tabLivres.size(); i++) {
    		// Créer une variable "livre" et lui attribuer la valeur de la position "i"
    		Livre livre = tabLivres.get(i);
    		// Vérifier si le livre a l'auteur OU le genre correspondant
    		if(livre.getAuteur().equalsIgnoreCase(auteur) || livre.getGenre().equals(genre)) {
    			// Si oui, ajoutez l'indice de ce livre à la liste des indices
    			tabIndices.add(i);
    		}
        }
    	    	
    	// Affichage des indices des livres correspondants
    	System.out.println("Indices des livres correspondants à l'auteur " + auteur
    			+ " ou au genre " + genre + " : ");
    	for(int indice : tabIndices) {
    		System.out.println(indice);
    	}
    	
		return tabIndices;
    }
    
    // Livre appartenant à quel bus
    public boolean appartientBus(Livre livre) {
    	if(this.nom.equals(livre.getNomBus())) {
    		System.out.println("\nLe livre " + livre.getTitre() + " appartient au bus " + livre.getNomBus() + ".");
    		return true;
    	}
    	System.out.println("\nLe livre " + livre.getTitre() + " n'appartient pas au bus " + this.nom + ".");
    	return false;
    }
}
