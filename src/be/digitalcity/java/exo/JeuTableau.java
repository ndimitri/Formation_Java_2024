package be.digitalcity.java.exo;

import java.util.Scanner;

public class JeuTableau {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        //Variables
        char[] plateau = new char[5];
        boolean continuer = true;
        int indexPion = 0;


        //Remplissage du tableau
        for(int i = 0; i < plateau.length; i++){
            plateau[i] = '_';
        }

        //Placement du pion sur le plateau
        plateau[indexPion] = '*';

        while(continuer){

            System.out.println("Choisissez une direction pour déplacer le pion (g ou d). q pour arreter ");

            //Affichage du plateau de jeu
            String plateauToString = "[";
            for(int i = 0; i < plateau.length; i++){
                plateauToString += plateau[i]+" ";
            }
            plateauToString += "]";
            System.out.println(plateauToString);


            //Demande le choix du joueur
            char choixJoueur = sc.next().charAt(0);


            //Action selon le choix du joueur
            switch(choixJoueur) {
                case 'd' -> {
                    //Si le joueur veut aller a droit alors qu'il ne peut plus, le pion retourne au début du plateau
                    if(indexPion == plateau.length-1){
                        plateau[0] = '*';
                        plateau[indexPion] = '_';
                        indexPion = 0;
                    }
                    //Le pion se deplace vers la droite
                    else {
                        plateau[indexPion + 1] = '*';
                        plateau[indexPion] = '_';
                        indexPion++;
                    }
                }

                case 'g' -> {
                    //Si le joueur veut aller a gauche alors qu'il ne peut plus, le pion va a la fin du plateau
                    if(indexPion == 0){
                        plateau[plateau.length-1] = '*';
                        plateau[indexPion] = '_';
                        indexPion = plateau.length-1;
                    }
                    //le pion se deplace vert la gauche
                    else {
                        plateau[indexPion-1] = '*';
                        plateau[indexPion] = '_';
                        indexPion--;

                    }
                }
                //Si le joueur veut arreter le jeu
                case 'q' -> {
                    continuer = false;
                    System.out.println("Merci d'avoir jouer au jeu !!!");
                }
                //Si le choix n'existe pas
                default -> {
                    System.out.println("Cette direction n'existe pas, choississez une direction (g ou d) q pour arreter");
                }
            }

        }


    }


}
