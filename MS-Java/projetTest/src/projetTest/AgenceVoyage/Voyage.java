package projetTest.AgenceVoyage;

import java.util.*;

public class Voyage {
	protected String nomPersonne;
	protected String prenomPersonne;
	protected ArrayList<Voyage> reservations = new ArrayList<Voyage>();
	
	
	public Voyage(String nom, String prenom) {
		this.nomPersonne = nom;
		this.prenomPersonne = prenom;
		this.reservations = new ArrayList<>();
	}

	public void ajoutResa(Billets reservation) {
		if(reservations.size() < 10) {
			reservations.add(reservation);
		} else {
			System.out.println("Limite de réservation atteinte !");
		}
	}

	public String getNomPersonne() {
		return nomPersonne;
	}

	public String getPrenomPersonne() {
		return prenomPersonne;
	}

	public ArrayList<Voyage> getReservation() {
		return reservations;
	}

}
