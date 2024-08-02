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
        Compte compteEpargne2 = new Epargne("IBAN789123456", pers2);

        //region Test Exo Heritage
//        System.out.println(compteCourant1);
//        System.out.println(compteEpargne1);
//
//        System.out.println(compteCourant2);
//        System.out.println(compteEpargne2);
//
//        //Depot 50eu sur compteEpargne1
//        compteEpargne1.depot(50);
//        System.out.println(compteEpargne1.getDateDernierRetrait());
//
//        System.out.println(compteEpargne1);
//
//        compteEpargne1.retrait(20);
//        System.out.println(compteEpargne1);
//        System.out.println(compteEpargne1.getDateDernierRetrait());
//
//
//        System.out.println(-compteCourant1.getLigneDeCredit() + " euros");
//endregion

        //region test Exo classe abstraite

//        compteCourant1.depot(50);
//        compteCourant1.appliquerInteret();
//        System.out.println(compteCourant1);
//        compteCourant1.retrait(100);
//        System.out.println(compteCourant1);
//        compteCourant1.appliquerInteret();
//        System.out.println(compteCourant1);
//
//        compteEpargne1.depot(50);
//        compteEpargne1.appliquerInteret();
//        System.out.println(compteEpargne1);


        //endregion


        //region Exo Interface
        Customer customerCourant = new Courant("IBAN159753456", pers1);

        Banker bankerCourant = new Courant("IBAN1654798623", pers1);

        customerCourant.depot(50);
        System.out.println(customerCourant);

        bankerCourant.appliquerInteret();


        //endregion

    }
    }

