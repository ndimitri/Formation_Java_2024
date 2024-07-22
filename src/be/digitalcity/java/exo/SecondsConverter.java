package be.digitalcity.java.exo;

import java.util.Scanner;

public class SecondsConverter {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Bienvenue sur le converteur de secondes! \nVeuillez entrez le nombre de secondes a convertir :");
        int secondsToConvert = sc.nextInt();


//        int days = secondsToConvert / 86400;
//
//        int hours =  (secondsToConvert % 86400 ) / 3600;
//
//        int minutes =((secondsToConvert % 86400) % 3600 / 60) ;
//
//        int seconds = ((secondsToConvert % 86400) % 3600 % 60);


        //Correction
        int minutes = secondsToConvert / 60;

        int seconds = secondsToConvert % 60;

        int hours = minutes / 60;

        minutes %= 60;

        int days = hours / 24;

        hours %= 24;


        System.out.println(secondsToConvert+" secondes"+" se converti en :" +"\n" +days+" jours "+hours+" heures "+minutes+" minutes "+seconds+" secondes");



    }
}
