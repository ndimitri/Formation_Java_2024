package be.digitalcity.java.exo.oo;

import java.util.ArrayList;
import java.util.List;

public class Bibliotheque {

    String nom;
    List<Livre> livres;

    Bibliotheque(String nom) {
        this.nom = nom;
        livres =   new ArrayList<Livre>();
    }

    void ajouterLivre(Livre livre) {
        livres.add(livre);

    }

    Livre chercherLivre(String nom){
        for (Livre livre : livres ) {
            if(livre.titre.equals(nom)){
                return livre;
            }
        }
        return null;

    }

    Livre supprimerLivre(Livre livre){
        if(livres.remove(livre))
            return livre;
        else
            return null;

    }


    @Override
    public String toString() {
        StringBuilder toString = new StringBuilder();
        toString.append("Bibliothèque : ").append(this.nom);
        for (Livre livre : livres) {
            toString.append("\n- ").append(livre.titre).append(" de ").append(livre.auteur);
        }
        return toString.toString();
    }
}
