package projetTest.AgenceVoyage;

import java.util.*;

public class Voyage {
	protected String nomPersonne;
	protected String prenomPersonne;
	protected List<Billets> reservations = new ArrayList<Billets>();
	
	
	public Voyage(String nom, String prenom) {
		this.nomPersonne = nom;
		this.prenomPersonne = prenom;
		//this.typeBillet = billet;
		this.reservations = new ArrayList<>();
	}

	// Vérification du nombre de réservation
	public void ajoutResa(Billets reservation) {
		// On regarde le total de réservation pour une personne
		if(reservations.size() < 10) {
			int totalResa = 0;
			// Calcul du total de réservation
			for(Billets billet : reservations) {
				totalResa += billet.getNbPlaces();
			}
			// SI le total est inférieur ou égal à 10 on ajoute la réservation
			if (totalResa + reservation.getNbPlaces() <= 10) {
				reservations.add(reservation);
			} else {
				// Sinon on affiche une erreur
				System.out.println("Limite de réservation atteinte !");
			}
		} else {
			System.out.println("Limite de réservation atteinte !");
		}
	}
	
	public String toString() {
        String res = "Voyage de " + nomPersonne + " " + prenomPersonne + "\n";
		
		for(Billets billet : reservations) {
			res += "\nRéservation de " + billet.getTypeBillet() + "\n";
			res += "Départ : " + billet.getDepart() + " - Arrivée : " + billet.getDestination() + " - Distance : " + billet.getDistance();
			res += "\nNb de places : " + billet.getNbPlaces() + " - Réduction : " + billet.getReduction() + " ";
			if (billet.typeBillet.equals("train")) {
				res += "\nPrix : " + billet.prixTrain() + " €\n";
			} else {
				res += "\nPrix : " + billet.prixAvion() + " €\n";
			}
		}
        return res;
    }

	// Total de la facture pour les billets de train et d'avion
	public double totalFacture() {
		double totalFacture = 0.0;

		System.out.println("Total de la facture : ");
		for(Billets billet : reservations) {
			totalFacture = billet.prixTrain() + billet.prixAvion();
		}
		return totalFacture;
	}
	
	public String getNomPersonne() {
		return nomPersonne;
	}

	public String getPrenomPersonne() {
		return prenomPersonne;
	}

	public List<Billets> getReservation() {
		return reservations;
	}

}
