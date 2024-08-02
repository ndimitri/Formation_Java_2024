package be.digitalcity.java.exo.oo.competition;

import java.time.LocalDate;

public abstract class Sportif extends Personne implements Competiteur{


    Sportif(String nom, String prenom, LocalDate dateNaissance) {
        super(nom, prenom, dateNaissance);
    }

    @Override
    public abstract double performer();

    @Override
    public String toString() {
        return this.nom.charAt(0) + "." + this.prenom + " (" + this.dateNaissance.getYear()+")";
    }
}
