package be.digitalcity.java.exo.oo.banque;

import be.digitalcity.java.exo.oo.Personne;

import java.time.LocalDate;

public class MainCourant {
    public static void main(String[] args) {
        Personne pers1 = new Personne("Monier", "Luc", LocalDate.of(2000, 5,8));
        Personne pers2 = new Personne("Pelistre", "Marie", LocalDate.of(1987, 2,16));

        Courant compteCourant1 = new Courant("IBAN123456789",100, pers1);
        Compte compteCourant2 = new Courant("IBAN456789123", pers2);

        Epargne compteEpargne1 = new Epargne("IBAN987654321", pers1);
        Compte compteEpargne2 = new Compte("IBAN789123456", pers2);


        System.out.println(compteCourant1);
        System.out.println(compteEpargne1);

        System.out.println(compteCourant2);
        System.out.println(compteEpargne2);

        //Depot 50eu sur compteEpargne1
        compteEpargne1.depot(50);
        System.out.println(compteEpargne1.getDateDernierRetrait());

        System.out.println(compteEpargne1);

        compteEpargne1.retrait(20);
        System.out.println(compteEpargne1);
        System.out.println(compteEpargne1.getDateDernierRetrait());


        System.out.println(-compteCourant1.getLigneDeCredit() + " euros");




    }
    }

