package be.digitalcity.java.exo.oo.banque;

import be.digitalcity.java.exo.oo.Personne;

public interface Banker extends Customer{

    void appliquerInteret();

    Personne getTitulaire();

    String getNumero();


}
