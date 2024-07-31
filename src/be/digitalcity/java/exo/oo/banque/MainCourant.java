package be.digitalcity.java.exo.oo.banque;

import be.digitalcity.java.exo.oo.Personne;

import java.time.LocalDate;

public class MainCourant {
    public static void main(String[] args) {
        Personne pers1 = new Personne("Monier", "Luc", LocalDate.of(2000, 5,8));
        Personne pers2 = new Personne("Pelistre", "Marie", LocalDate.of(1987, 2,16));

        Courant compteCourant = new Courant("IBAN123456789", pers1);
        Courant compteCourant2 =  new Courant("IBAN123456789", -20, pers2 );

        System.out.println(compteCourant2.getLigneDeCredit()); //0

        System.out.println(compteCourant); //0

        compteCourant.depot(100);
        System.out.println(compteCourant); //100

        compteCourant.setLigneDeCredit(100); // Solde peut aller jusqu'a -100eu

        compteCourant.retrait(200);
        System.out.println(compteCourant);// -100

        compteCourant.depot(50);
        System.out.println(compteCourant);// -50

        compteCourant.setTitulaire(pers2); // On change de titulaire
        System.out.println(compteCourant);


    }
    }

