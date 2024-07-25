package be.digitalcity.java.exo;

import java.util.Scanner;

public class NombrePremiers {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

     //Variables

     int nbrDeNombrePremiers=0;
     int compteurNombrePremier = 0;
     int nombreAVerifier = 2;
     int[] tabNbrPremiers;

     System.out.println("Introduire le nombre de nombre premiers a afficher :");
     nbrDeNombrePremiers = sc.nextInt();
     tabNbrPremiers = new int[nbrDeNombrePremiers];
     String printNombrePremiers = "Voici les " + nbrDeNombrePremiers+ " premiers nombres premiers : \n";


     while (compteurNombrePremier < nbrDeNombrePremiers) {
         //On part du principe que le nombre est premier

             boolean estPremier = true;

             //region NBR PREMIER FOR
             //On verifie sur le nombre est premier AVEC UN FOR
//             for( int i = 2; i <= Math.sqrt(indexNombreAVerifier) ; i++) {
//                 if(indexNombreAVerifier % i == 0){
//                    estPremier = false;
//                 }
//             }
//
         //endregion

            //region On verifie sur le nombre est premier AVEC UN WHILE
            int indexTabNbrPremier = 0;
            int diviseur = tabNbrPremiers[indexTabNbrPremier];

            //Si le nombre est premier, que l'index ne va pas plus loin que le compteur de nbr premier et que le nombre premier est <= à la racine du nbr a verifier
             while(estPremier && indexTabNbrPremier < compteurNombrePremier && diviseur<= Math.sqrt(nombreAVerifier)){

                 if(nombreAVerifier % diviseur == 0){
                     estPremier = false;
                 }
                 indexTabNbrPremier++;

             }
             //endregion

             //Si le nombre est premier, on incrémente @compteurNombrePremier
             if(estPremier){
                 tabNbrPremiers[compteurNombrePremier++] = nombreAVerifier;

                 //Verifie si c'est le dernier nombre premier a print
                 if(compteurNombrePremier == nbrDeNombrePremiers){
                     printNombrePremiers += nombreAVerifier;
                 }
                 else  {
                     printNombrePremiers += nombreAVerifier+", ";
                 }

             }

         nombreAVerifier++;

     }

        //Print les nombres premiers
        System.out.println(printNombrePremiers);








    }
}
