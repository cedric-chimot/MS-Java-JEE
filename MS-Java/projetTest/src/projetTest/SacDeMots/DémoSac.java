package projetTest.SacDeMots;

public class DémoSac {

	public static void main(String[] args) {
		SacDeMots sac = new SacDeMots();

        // Ajoute des mots au sac
        sac.ajouteUnMot("chien");
        sac.ajouteUnMot("chat");
        sac.ajouteUnMot("chien");
        sac.ajouteUnMot("oiseau");
        sac.ajouteUnMot("chien");
        sac.ajouteUnMot("chat");

        // Affiche le nombre d'occurrences de certains mots
        System.out.println("Nombre d'occurrences de 'chien': " + sac.plusFrequents());
        System.out.println("Nombre d'occurrences de 'chat': " + sac.nbOccurences("chat"));
        System.out.println("Nombre d'occurrences de 'oiseau': " + sac.nbOccurences("oiseau"));

        // Affiche les mots les plus fréquents
        System.out.println("Les mots les plus fréquents : " + sac.plusFrequents());

        // Supprime un mot
        sac.supprimeUnMot("chien");

        // Affiche à nouveau le nombre d'occurrences de 'chien' après la suppression
        System.out.println("Nombre d'occurrences de 'chien' après suppression : " + sac.nbOccurences("chien"));

        // Affiche le nombre de mots différents
        System.out.println("Nombre de mots différents : " + sac.nbMotsDifferents());
    }

}
