package be.digitalcity.java.exo;

import java.util.Scanner;

public class ExoDistributeur {
    public static void main(String[] args) {


        Scanner sc = new Scanner(System.in);

        //Stock de boissons
        int stockEau = 0;
        int stockCafe = 15;
        int stockThe = 8;

        //Constantes
        final int CHOIX_EAU = 1;
        final int CHOIX_CAFE = 2;
        final int CHOIX_THE = 3;

        //Print du distributeur
        System.out.println("____________________");
        System.out.println("|                  |");
        System.out.println("|  Distributeur    |");
        System.out.println("|     de           |");
        System.out.println("|    Boissons      |");
        System.out.println("|                  |");
        System.out.println("| [1] Eau  (" +stockEau + ")     |");
        System.out.println("| [2] Cafe (" +stockCafe + ")    |");
        System.out.println("| [3] Thé  (" +stockThe + ")     |");
        System.out.println("|                  |");
        System.out.println("|__________________|");
        System.out.println("Veuillez le nombre de votre boisson :");

        //Demande au client sa boisson
        int boissonChoisie = sc.nextInt();

        switch (boissonChoisie){
            //Si le client choisi de l'eau
            case CHOIX_EAU -> {
                if(stockEau <= 0){
                    System.out.println("Il n'y a plus de stock d'eau! Revenez plus tard");
                }
                else{
                    stockEau--;
                    System.out.println("Voici votre eau! Merci et au revoir!");

                }

            }
            //Si le client choisi du cafe
            case CHOIX_CAFE -> {
                if(stockCafe <= 0){
                    System.out.println("Il n'y a plus de stock de cafe! Revenez plus tard");
                }
                else{
                    stockCafe--;
                    System.out.println("Voici votre cafe! Merci et au revoir!");

                }

            }
            //Si le client choisi du the
            case CHOIX_THE -> {
                if(stockThe <= 0){
                    System.out.println("Il n'y a plus de stock de the! Revenez plus tard");
                }
                else{
                    stockThe--;
                    System.out.println("Voici votre the! Merci et au revoir!");

                }

            }

            default -> {
                System.out.println("[ERROR] Veuillez entrer un numéro de boisson existant !");
            }
        }
    }
}
