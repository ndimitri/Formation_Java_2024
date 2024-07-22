package be.digitalcity.java.demo.conditionnel;

import java.util.Scanner;

public class DemoCondition {
    public static void main(String[] args) {

        int temp = 18;

        if(temp >= 5 && temp <= 15){
            System.out.println("J'allume la chaudiere");
        }
        else if(temp < 5){
            System.out.println("J'allume un feu de bois");
        }
        else {
            System.out.println("J'eteinds la chaudiere");
        }


        int age = 58 ;
//
//        if(age >= 18 && age <= 67){
//            System.out.println("Adulte");
//        }
//        else if (age >= 12 && age < 17) {
//            System.out.println("Ado");
//        }
//        else if (age >=0 && age <12) {
//            System.out.println("Enfant");
//        }
//        else if(age >= 67){
//            System.out.println("Retraité");
//        }
//        else{
//            System.out.println("Age Invalide");
//        }
//
//
        age = 57;
        //Fais la meme chose mais avec une structure plus lisible
        if(age < 0) {
            System.out.println("Age invalide");
        }
        else if(age < 12){
            System.out.println("Enfant");
        }
        else if(age < 18) {
            System.out.println("Ado");
        }
        else if(age < 67) {
            System.out.println("Adulte");
        }
        else{
            System.out.println("Retraité");
        }


        age = 18;
        //Se base sur une valeur avec une égalité exacte
        switch(age){
            case 0:
                System.out.println("Vous etes né");
                break;
            case 13:
                System.out.println();
            case 12:
                System.out.println("Début de l'adolescence");
                break;
            case 18:
                System.out.println("Vous devenez adulte");
                break;
            case 67:
                System.out.println("C'est la retraite");
                break;
            default:
                System.out.println("Rien de particulier");
        }


        //Depuis Java 13
        int jourChiffre = 5;
        String jour = switch(jourChiffre){
            case 1: yield "lundi";
            case 2: yield "mardi";
            case 3: yield "mercredi";
            case 4: yield "jeudi";
            case 5: yield "vendredi";
            case 6: yield "samedi";
            case 7: yield "dimanche";
            default: yield "pas un jour";
        };

        //Depuis Java 12
        jour = switch (jourChiffre){
            case 1 ->"lundi";
            case 2 -> "mardi";
            case 3, 57 -> {
                System.out.println("mercredi");
                yield "mercredi";
            }
            case 4 -> "jeudi";
            case 5 -> "vendredi";
            case 6 -> "samedi";
            case 7 -> "dimanche";
            default -> "pas un jour";
        };

        //Depuis Java 17
        //Pattern Matching

        Object valeur = 5;

        switch(valeur) {
            //Verifie si c'est un entier
            case Integer i-> System.out.println("entier");
            //Verifie si c'est une string
            case String s -> System.out.println("string");
            //Verifie si c'est un scanner
            case Scanner sc -> System.out.println("scanner");
            default -> System.out.println("aucun de ces types");
        }


    }
}
