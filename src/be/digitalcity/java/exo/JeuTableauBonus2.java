package be.digitalcity.java.exo;
import java.util.Random;
import java.util.Scanner;

public class JeuTableauBonus2 {

    public static void main(String[] args) {
        Random random = new Random();
        Scanner sc = new Scanner(System.in);

        //Constantes
        final int NOMBRE_PIECES = 5;
        final int TAILLE_TABLEAU = 10;

        //Variables
        char[][] plateau = new char[TAILLE_TABLEAU][TAILLE_TABLEAU];
        boolean gameWin = false;
        int lignePion = random.nextInt(0, 10);
        int colonnePion = random.nextInt(0, 10);
        int nbrPiecesPlacees = 0;
        int compteurPieces=0;


        //Remplissage du tableau
        for(int i = 0; i < TAILLE_TABLEAU; i++){
            for(int j = 0 ; j < TAILLE_TABLEAU ; j++){
                plateau[i][j] = '_';
            }
        }

        //Placement du pion sur le plateau
        plateau[lignePion][colonnePion] = '*';


        //Placement des pieces
        while (nbrPiecesPlacees < NOMBRE_PIECES){
            int xPiece = random.nextInt(0,10);
            int yPiece = random.nextInt(0,10);

            if(plateau[xPiece][yPiece]=='_'){
                plateau[xPiece][yPiece] = '$';
                nbrPiecesPlacees++;
            }
        }






        while(!gameWin){
            System.out.println("Choisissez une direction pour déplacer le pion (g, d, h, b).");

            //Affichage du plateau de jeu
            String plateauToString = "";
            for(int i = 0; i < TAILLE_TABLEAU; i++){
                for (int j = 0; j < TAILLE_TABLEAU; j++) {
                    plateauToString += plateau[i][j]+" ";
                }
                plateauToString+="\n";
            }
            System.out.println(plateauToString);

            //Affichage du nombre de pieces
            System.out.println("Pieces rammassées : "+ compteurPieces);


            //Demande le choix du joueur
            char choixJoueur = sc.next().charAt(0);

            //Action selon le choix du joueur
            switch(choixJoueur) {
                case 'd' -> {
                    //Si le joueur veut aller a droit alors qu'il ne peut plus, le pion retourne au début du plateau
                    if(colonnePion == TAILLE_TABLEAU-1){
                        if(plateau[lignePion][0] == '$'){
                            compteurPieces++;
                        }
                        plateau[lignePion][0] = '*';
                        plateau[lignePion][colonnePion] = '_';
                        colonnePion = 0;
                    }
                    //Le pion se deplace vers la droite
                    else {
                        //Si il y a une piece sur la case, on la rammasse
                        if(plateau[lignePion][colonnePion+1] == '$'){
                            compteurPieces++;
                        }
                        plateau[lignePion][colonnePion+1] = '*';
                        plateau[lignePion][colonnePion] = '_';
                        colonnePion++;
                    }
                }

                case 'g' -> {
                    //Si le joueur veut aller a gauche alors qu'il ne peut plus, le pion va a la fin du plateau
                    if(colonnePion == 0){
                        if(plateau[lignePion][TAILLE_TABLEAU-1] == '$'){
                            compteurPieces++;
                        }
                        plateau[lignePion][TAILLE_TABLEAU-1] = '*';
                        plateau[lignePion][colonnePion] = '_';
                        colonnePion = TAILLE_TABLEAU-1;
                    }
                    //le pion se deplace vert la gauche
                    else {
                        if(plateau[lignePion][colonnePion-1] == '$'){
                            compteurPieces++;
                        }
                        plateau[lignePion][colonnePion-1] = '*';
                        plateau[lignePion][colonnePion] = '_';
                        colonnePion--;
                    }
                }

                case 'h' -> {
                    //Si le joueur veut aller en haut alors qu'il ne peut plus, le pion va a en bas du plateau
                    if(lignePion == 0){
                        if(plateau[TAILLE_TABLEAU-1][colonnePion] == '$'){
                            compteurPieces++;
                        }
                        plateau[TAILLE_TABLEAU-1][colonnePion] = '*';
                        plateau[lignePion][colonnePion] = '_';
                        lignePion = TAILLE_TABLEAU-1;
                    }
                    //le pion se deplace vert le haut
                    else {
                        if(plateau[lignePion-1][colonnePion] == '$'){
                            compteurPieces++;
                        }
                        plateau[lignePion-1][colonnePion] = '*';
                        plateau[lignePion][colonnePion] = '_';
                        lignePion--;
                    }
                }

                case 'b' -> {
                    //Si le joueur veut aller en bas alors qu'il ne peut plus, le pion va a en haut du plateau
                    if(lignePion == TAILLE_TABLEAU-1){
                        if(plateau[0][colonnePion] == '$'){
                            compteurPieces++;
                        }
                        plateau[0][colonnePion] = '*';
                        plateau[lignePion][colonnePion] = '_';
                        lignePion = 0;
                    }
                    //le pion se deplace vert le bas
                    else {
                        if(plateau[lignePion+1][colonnePion] == '$'){
                            compteurPieces++;
                        }
                        plateau[lignePion+1][colonnePion] = '*';
                        plateau[lignePion][colonnePion] = '_';
                        lignePion++;
                    }
                }

                //Si le choix n'existe pas
                default -> {
                    System.out.println("Cette direction n'existe pas, choississez une direction (g ou d) o pour arreter");
                }
            }

            //Si le joueur a rammassé toutes les pieces, la partie est terminé
            if(compteurPieces==NOMBRE_PIECES){
                gameWin=true;
            }

        }

        //Affichage du nombre de pieces
        System.out.println("Pieces rammassées : "+ compteurPieces);
        System.out.println("Partie Gagné !!!");

    }

}
