package be.digitalcity.java.exo;

import java.util.Scanner;

public class Calculatrice {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        //Constantes
        final int ADDITION = 1;
        final int SOUSTRACTION = 2;
        final int MULTIPLICATION = 3;
        final int DIVISION = 4;
        final int MODULO = 5;

        final int ARRETER = 0;

        //Variables
        int nombre1;
        int nombre2;
        int choixOperation;
        int choixContinuer;

        boolean continuer;


        System.out.println("-------------Bienvenue sur la Calculatrice Java-------------");

        do {
            //Demande le premier nombre
            System.out.println("Entrez le nombre 1: ");
            nombre1 = sc.nextInt();

            //Demande le deuxieme nombre
            System.out.println("Entrez le nombre 2: ");
            nombre2 = sc.nextInt();

            //Demande l'operation a faire
            System.out.println("Choississez l'operation a effectuer :" +
                    "\n1 -> +" +
                    "\n2 -> -" +
                    "\n3 -> *" +
                    "\n4 -> /" +
                    "\n5 -> %");
            choixOperation = sc.nextInt();

            switch (choixOperation){
                //Si l'operation est une addition
                case ADDITION -> {
                    System.out.println(nombre1+"+"+nombre2+"="+(nombre1+nombre2));
                }

                //Si l'operation est une soustraction
                case SOUSTRACTION -> {
                    System.out.println(nombre1+"-"+nombre2+"="+(nombre1-nombre2));
                }

                //Si l'operation est une multiplication
                case MULTIPLICATION -> {
                    System.out.println(nombre1+"*"+nombre2+"="+(nombre1*nombre2));
                }

                //Si l'operation est une division
                case DIVISION -> {
                    //Si l'utilisateur veux diviser un nombre par 0
                    if(nombre2 == 0){
                        System.out.println("Division par 0 impossible !!!");
                    //Sinon print la division
                    }
                    else{
                        System.out.println(nombre1+"/"+nombre2+"="+(nombre1/nombre2));
                    }
                }

                //Si l'operation est un modulo
                case MODULO -> {
                    //Si l'utilsateur veux diviser un nombre par 0
                    if(nombre2 == 0){
                        System.out.println("Modulo par 0 impossible !!!");
                    }
                    //Sinon print le modulo
                    else {
                        System.out.println(nombre1+"%"+nombre2+"="+(nombre1%nombre2));
                    }

                }
                default -> System.out.println("Erreur ! Operation non valide");
            }

            System.out.println("Voulez vous refaire un calcul ? (0 -> Non , 1 -> Oui)");
            choixContinuer = sc.nextInt();

            if(choixContinuer == ARRETER){
                continuer = false;
            }
            else{
                continuer = true;
            }

        }while (continuer);
        System.out.println("Merci et a bientot !!!");



    }
}
