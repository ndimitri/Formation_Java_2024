package be.digitalcity.java.exo.oo;

import java.time.LocalDate;

public class Livre {
//    LocalDate date = LocalDate.of(2024, 4, 17);

    String titre, auteur;
    LocalDate date;

    public Livre(String titre, String auteur, LocalDate date) {
        this.titre = titre;
        this.auteur = auteur;
        this.date = date;
    }

}
