package dynamicProject;

import java.util.List;

public class Commande {
    private int idCommande;
    private String dateCommande;
    private int idUsers;
    private List<LigneCommande> lignesCommande;

    public Commande(int idCommande, String dateCommande, int idUsers, List<LigneCommande> lignesCommande) {
        this.idCommande = idCommande;
        this.dateCommande = dateCommande;
        this.idUsers = idUsers;
        this.lignesCommande = lignesCommande;
    }

    public int getIdCommande() {
        return idCommande;
    }

    public String getDateCommande() {
        return dateCommande;
    }

    public int getIdUsers() {
        return idUsers;
    }

    public List<LigneCommande> getLignesCommande() {
        return lignesCommande;
    }
}
