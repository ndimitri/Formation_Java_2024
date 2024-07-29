package be.digitalcity.java.exo.oo;

import java.time.LocalDate;

public class MainBibliotheque {
    public static void main(String[] args) {

        Bibliotheque maBibliotheque = new Bibliotheque("Les livres du bonheur");

        Livre livre1 = new Livre("La petit chat gris qui miaulait", "J.Decasse", LocalDate.of(2019, 2, 8));
        Livre livre2 = new Livre("La terre est belle", "A.Jardin", LocalDate.of(2018, 6, 24));
        Livre livre3 = new Livre("Ceci n'est pas un livre", "G.Fuchaut", LocalDate.of(2022, 1, 15));

        //Ajout des livres dans la bibliothèque
        maBibliotheque.ajouterLivre(livre1);
        System.out.println("Ajout du livre 1");

        maBibliotheque.ajouterLivre(livre2);
        System.out.println("Ajout du livre 2");

        maBibliotheque.ajouterLivre(livre3);
        System.out.println("Ajout du livre 3");

        System.out.println();
        System.out.println(maBibliotheque);
        System.out.println();


        //Recherche d'un livre avec un titre
        Livre livreTrouve = maBibliotheque.chercherLivre("La terre est belle");
        System.out.println("Livre trouvé : " + livreTrouve.titre + " ("+livreTrouve.date+ ") écrit par " + livreTrouve.auteur);

        //Supprimer un livre de la bibliothèque
        maBibliotheque.supprimerLivre(livre3);
        System.out.println("Supprimer le livre '"  +livre3.titre + "' (" + livre3.auteur + ")");
        System.out.println();
        System.out.println(maBibliotheque);
        System.out.println();

    }
}
