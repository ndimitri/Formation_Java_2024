package be.digitalcity.java.exo;

import java.util.Scanner;

public class ExoInOut {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.println("Veuillez entrer votre nom :");
        //Recuperation du nom en String
        String nom = sc.nextLine();

        System.out.println("Veuillez entrer votre age :");
        //Recuperation de l'age en String
        String age = sc.nextLine();

        //Conversion de l'age en int
        int ageInt = Integer.parseInt(age);

//        int age = sc.nextInt();

        System.out.println(
                "#####################################################"+
                        "\nBonjour "+ nom+"!"
                        +"\nVous avez actuellement "+ age + " ans."+
                        "\nDans 20 ans vous aurez " + (ageInt +20) +" ans." +
                        "\n#####################################################");


    }
}
