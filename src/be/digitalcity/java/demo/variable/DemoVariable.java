package be.digitalcity.java.demo.variable;

import java.sql.SQLOutput;

public class DemoVariable {

    public static void main(String[] args) {

        //Déclaration et initialisation de variables
        String nom = "Dimitriadis", prenom = "Nico";


        //Types primitifs
        //Nombres entiers

        byte tresPetitEntier = 127;   //1 octet : max 127, min -126
        short petitEntier = 32_767;   // 2 octets : max 32767 , min  -32766
        int entier = 2_000_000_000;   // 4 octets : max 2 milliards , min -2 milliards
        long grandEntier = 5_000_000_000L; //8 octets : max enormement  Le "L" a la fin precise que le nombre est un long et non pas un int

        entier = 0b11111111; // => 255 ecriture en binaire
        entier = 0377; // => 255 ecriture en octale
        entier = 0xFF; // => 255 ecriture en hexadecimale

        //Nombre réels
        float reel = 0.5F; // 4 octets
        double reelPrecis = 0.9; // 8 octets

        //Autres

        boolean bool = false; // ou true // ~1bit
        char character = 'a'; // 2 octets
        character = 97; // un caractere est stocke comme un nombre en mémoire


        // Constantes
        final int TAUX_TVA = 21; //

        // Conversion
        entier = Integer.MAX_VALUE;
        /*
        11111111 11111111 11111111 11111111  => entier en int
                          11111111 11111111 => entier en short
        00000000 00000000 11111111 11111111 => entier en int
         */

        petitEntier = (short) entier; // Type Casting Explicite (nécéssaire car perte de données possible)
        grandEntier = entier; // Type Casting Implicite


        entier = (int) reelPrecis;
        reelPrecis = entier;


        //Pour transformer un short en char, Explicite necessaire
        character = (char) petitEntier;

        String nombre = "15";
        int converti = Integer.parseInt(nombre);
        System.out.println(converti);


        System.out.println("15"+1); //151
        System.out.println(converti+1); //16


        double convertiDouble = Double.parseDouble("15.5"); //Attention de mettre un point et pas une virgule
        System.out.println(convertiDouble);


        boolean convertiBoolean = Boolean.parseBoolean("true");
        System.out.println(convertiBoolean);

     }


}


