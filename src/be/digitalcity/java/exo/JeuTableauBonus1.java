package be.digitalcity.java.exo;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class JeuTableauBonus1 {

    public static void main(String[] args) {
        //Outils
        Random random = new Random();
        Scanner sc = new Scanner(System.in);

        //Constantes
        final int NOMBRE_PIECES = 3;

        //Variables
        char[] plateau = new char[10];
        boolean gameWin = false;
        int indexPion = random.nextInt(0, 10);
        int nbrPiecesPlacees = 0;
        int compteurPieces=0;

        //Remplissage du tableau
        for(int i = 0; i < plateau.length; i++){
            plateau[i] = '_';
        }
        //Fais exactement la meme chose
//        Arrays.fill(plateau,'_' );

        //Placement du pion sur le plateau
        plateau[indexPion] = '*';

        //Placement des pieces
        while (nbrPiecesPlacees < NOMBRE_PIECES){
            int indexPiece = random.nextInt(0,plateau.length);

            if(plateau[indexPiece]=='_'){
                plateau[indexPiece] = '$';
                nbrPiecesPlacees++;
            }

        }


        while(!gameWin){

            System.out.println("Choisissez une direction pour déplacer le pion (g ou d). o pour arreter ");

            //Affichage du plateau de jeu
            String plateauToString = "[";
            for(int i = 0; i < plateau.length; i++){
                plateauToString += plateau[i]+" ";
            }
            plateauToString += "]";
            System.out.println(plateauToString);

            //Affichage du nombre de pieces
            System.out.println("Pieces rammassées : "+ compteurPieces);


            //Demande le choix du joueur
            char choixJoueur = sc.next().charAt(0);


            //Action selon le choix du joueur
            switch(choixJoueur) {
                case 'd' -> {
                    //Si le joueur veut aller a droit alors qu'il ne peut plus, le pion retourne au début du plateau
                    if(indexPion == plateau.length-1){
                        if(plateau[0] == '$'){
                            compteurPieces++;
                        }
                        plateau[0] = '*';
                        plateau[indexPion] = '_';
                        indexPion = 0;
                    }
                    //Le pion se deplace vers la droite
                    else {
                        //Si il y a une piece sur la case, on la rammasse
                        if(plateau[indexPion+1] == '$'){
                            compteurPieces++;
                        }
                        plateau[indexPion + 1] = '*';
                        plateau[indexPion] = '_';
                        indexPion++;
                    }
                }

                case 'g' -> {
                    //Si le joueur veut aller a gauche alors qu'il ne peut plus, le pion va a la fin du plateau
                    if(indexPion == 0){
                        if(plateau[plateau.length-1] == '$'){
                            compteurPieces++;
                        }
                        plateau[plateau.length-1] = '*';
                        plateau[indexPion] = '_';
                        indexPion = plateau.length-1;
                    }
                    //le pion se deplace vert la gauche
                    else {
                        if(plateau[indexPion-1] == '$'){
                            compteurPieces++;
                        }
                        plateau[indexPion-1] = '*';
                        plateau[indexPion] = '_';
                        indexPion--;

                    }
                }

                //Si le choix n'existe pas
                default -> {
                    System.out.println("Cette direction n'existe pas, choississez une direction (g ou d) o pour arreter");
                }
            }

            //Si le joueur a rammassé toutes les pieces, la partie est terminé
            if(compteurPieces==3){
                gameWin=true;
            }

        }
        //Affichage du nombre de pieces
        System.out.println("Pieces rammassées : "+ compteurPieces);
        System.out.println("Partie Gagné !!!");

    }

}
