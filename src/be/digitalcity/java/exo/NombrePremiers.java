package be.digitalcity.java.exo;

import java.util.Scanner;

public class NombrePremiers {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

     //Variables
     int nbrDeNombrePremiers;
     int compteurNombrePremier = 0;

     int indexNombreAVerifier = 2;

     System.out.println("Introduire le nombre de nombre premiers a afficher :");
     nbrDeNombrePremiers = sc.nextInt();

     String printNombrePremiers = "Voici les " + nbrDeNombrePremiers+ " premiers nombres premiers : \n";


     while (compteurNombrePremier < nbrDeNombrePremiers) {
         //On part du principe que le nombre est premier

             boolean estPremier = true;

             //On verifie sur le nombre est premier AVEC UN FOR
//             for( int i = 2; i <= Math.sqrt(indexNombreAVerifier) ; i++) {
//                 if(indexNombreAVerifier % i == 0){
//                    estPremier = false;
//                 }
//             }
//
            //On verifie sur le nombre est premier AVEC UN WHILE
            int i = 2;
             while(estPremier && i<= Math.sqrt(indexNombreAVerifier)){
                 if(indexNombreAVerifier % i == 0){
                     estPremier = false;
                 }
                 i++;

             }

             //Si le nombre est premier, on incrémente @compteurNombrePremier
             if(estPremier){
                 compteurNombrePremier++;

                 //Verifie si c'est le dernier nombre premier a print
                 if(compteurNombrePremier == nbrDeNombrePremiers){
                     printNombrePremiers += indexNombreAVerifier;
                 }
                 else  {
                     printNombrePremiers += indexNombreAVerifier+", ";
                 }

             }

         indexNombreAVerifier++;

     }

        //Print les nombres premiers
        System.out.println(printNombrePremiers);








    }
}
