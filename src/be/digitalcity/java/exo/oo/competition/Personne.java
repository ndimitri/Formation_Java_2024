package be.digitalcity.java.exo.oo.competition;

import java.time.LocalDate;

public class Personne {
    String nom;
    String prenom;
    LocalDate dateNaissance;


    Personne(String nom , String prenom, LocalDate dateNaissance) {
        this.nom = nom;
        this.prenom = prenom;
        this.dateNaissance = dateNaissance;

    }

}
