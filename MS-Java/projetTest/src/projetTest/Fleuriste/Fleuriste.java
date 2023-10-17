package projetTest.Fleuriste;

import java.util.ArrayList;
import java.util.List;

public class Fleuriste implements InterfaceFleuriste {
	private List<Fleur> stock;
	private Bouquet bouquetEnCours;
	
	public Fleuriste(List<Fleur> stock) {
		this.stock = stock;
		this.bouquetEnCours = null;
	}
	
	public void creationBouquet(String nom, String prenom) {
		bouquetEnCours = new Bouquet(nom, prenom);
	}

	public int quantiteEnStock(String nomFleur) {
		for(Fleur fleur : stock) {
			if(fleur.getNomFleur().equals(nomFleur)) {
				return fleur.getQuantite();
			}
		}
		return 0;
	}

	public float prixDUneFleur(String nomFleur) {
		for(Fleur fleur : stock) {
			if(fleur.getNomFleur().equals(nomFleur)) {
				return fleur.getPrixUnit();
			}
		}
		return 0;
	}

	// Ajout de fleur à un bouquet
	public void ajoutFleur(String nomFleur, int qte) {
		// Vérification à la création d'un bouquet
		if(bouquetEnCours != null) {
			// On parcourt le stock de fleur
			for(Fleur fleur : stock) {
				// Vérification de la fleur par rapport à son nom
				if(fleur.getNomFleur().equals(nomFleur)) {
					// On vérifie si le stock est suffisant
					if(quantiteEnStock(nomFleur) < qte) {
						// Si non on affiche une erreur
						System.out.println("Stock insuffisant pour cette fleur !");
					} else {
						// Si oui on ajoute la fleur au bouquet et on réduit le stock e la fleur en question
						bouquetEnCours.ajouterFleur(fleur, qte);
						reduireStock(nomFleur, qte);
					}
				}
			}
		}
	}
	
	// Modification du stock suite à l'ajout de fleur dans un bouquet
	public void reduireStock(String nomFleur, int qte) {
		// On parcourt le stock d'une fleur
		for(Fleur fleur : stock) {
			if(fleur.getNomFleur().equals(nomFleur)) {
				// On décrémente le stock selon le nom de la fleur et par rapport à la quantité
				fleur.setQuantite(quantiteEnStock(nomFleur) - qte);
				break;
			}
		}
	}

	public void facturation() {
	    if (bouquetEnCours != null) {
	        Bouquet bouquet = bouquetEnCours;
	        System.out.println("Facture du bouquet pour le client : " + bouquet.getNomClient() +
	                            " " + bouquet.getPrenomClient());
	        System.out.println("-----------------------------------------------------------------");

	        float prixTotalBouquet = 0;
	        List<String> fleursFacturees = new ArrayList<>();

	        // On parcourt chaque fleur du bouquet en cours
	        for (Fleur fleur : bouquet.getFleurs()) {
	            String nomFleur = fleur.getNomFleur();
	            
	            // On vérifie si la fleur a déjà été comptabilisée (éviter la répétition)
	            if (!fleursFacturees.contains(nomFleur)) {
	                int quantite = 0;
	                // On compte la quantité de cette fleur dans le bouquet
	                for (Fleur fleurDuBouquet : bouquet.getFleurs()) {
	                    if (fleurDuBouquet.getNomFleur().equals(nomFleur)) {
	                        quantite++;
	                    }
	                }

	                // On obtient le prix unitaire de la fleur
	                float prixUnit = prixDUneFleur(nomFleur);
	                // Calcul du prix total de la fleur dans le bouquet
	                float prixTotalFleur = prixUnit * quantite;

	                System.out.println(nomFleur + " - Quantité : " + quantite + " - Prix Total : " + prixTotalFleur + "€");
	                // Ajout du nom de la fleur à la liste des fleurs facturées
	                fleursFacturees.add(nomFleur);

	                // On met à jour le total du bouquet
	                prixTotalBouquet += prixTotalFleur;
	            }
	        }

	        System.out.println("-----------------------------------------------------------------");
	        System.out.println("Prix total du bouquet : " + prixTotalBouquet + "€");
	    } else {
	        System.out.println("Aucun bouquet en cours");
	    }
	}


}
