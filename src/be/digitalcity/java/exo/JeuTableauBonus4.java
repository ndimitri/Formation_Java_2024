package be.digitalcity.java.exo;
import java.util.Random;
import java.util.Scanner;

public class JeuTableauBonus4 {
    // Met à jour la visibilité autour du pion
    public static void updateVisibility(boolean[][] visible, int x, int y, int taillePlateau) {
        visible[x][y] = true;
        if(x > 0) visible[x-1][y] = true;
        if(x < taillePlateau - 1) visible[x+1][y] = true;
        if(y > 0) visible[x][y-1] = true;
        if(y < taillePlateau - 1) visible[x][y+1] = true;
    }

    public static void main(String[] args) {
        //Outils
        Random random = new Random();
        Scanner sc = new Scanner(System.in);

        //Constantes
        final int NOMBRE_PIECES = 5;
        final int TAILLE_PLATEAU = 10;
        final int NOMBRE_MURS = 5;

        //Variables
        char[][] plateau = new char[TAILLE_PLATEAU][TAILLE_PLATEAU];
        boolean[][] visible = new boolean[TAILLE_PLATEAU][TAILLE_PLATEAU];
        boolean gameWin = false;
        int xPion = random.nextInt(TAILLE_PLATEAU);
        int yPion = random.nextInt(TAILLE_PLATEAU);
        int nbrPiecesPlacees = 0;
        int compteurPieces = 0;
        int nbrMursPlaces = 0;

        //Remplissage du tableau
        for(int i = 0; i < TAILLE_PLATEAU; i++){
            for(int j = 0; j < TAILLE_PLATEAU; j++){
                plateau[i][j] = '_';
                visible[i][j] = false;
            }
        }

        //Placement du pion sur le plateau
        plateau[xPion][yPion] = '*';
        visible[xPion][yPion] = true;

        //Placement des pièces
        while (nbrPiecesPlacees < NOMBRE_PIECES){
            int xPiece = random.nextInt(TAILLE_PLATEAU);
            int yPiece = random.nextInt(TAILLE_PLATEAU);

            if(plateau[xPiece][yPiece] == '_'){
                plateau[xPiece][yPiece] = '$';
                nbrPiecesPlacees++;
            }
        }

        //Placement des murs
        while (nbrMursPlaces < NOMBRE_MURS){
            int xMur = random.nextInt(TAILLE_PLATEAU);
            int yMur = random.nextInt(TAILLE_PLATEAU);

            if(plateau[xMur][yMur] == '_'){
                plateau[xMur][yMur] = '#';
                nbrMursPlaces++;
            }
        }

        while(!gameWin){

            System.out.println("Choisissez une direction pour déplacer le pion (g, d, h, b). o pour arreter ");

            //Affichage du plateau de jeu
            for(int i = 0; i < TAILLE_PLATEAU; i++){
                for(int j = 0; j < TAILLE_PLATEAU; j++){
                    if(visible[i][j]){
                        System.out.print(plateau[i][j] + " ");
                    } else {
                        System.out.print("?"+" ");
                    }
                }
                System.out.println();
            }

            //Affichage du nombre de pièces
            System.out.println("Pièces ramassées : " + compteurPieces);

            //Demande le choix du joueur
            char choixJoueur = sc.next().charAt(0);

            //Action selon le choix du joueur
            switch(choixJoueur) {
                case 'd' -> {
                    int newY = (yPion + 1) % TAILLE_PLATEAU;
                    if(plateau[xPion][newY] == '#') {
                        System.out.println("Mouvement impossible, il y a un mur.");
                    } else {
                        if(plateau[xPion][newY] == '$'){
                            compteurPieces++;
                        }
                        plateau[xPion][yPion] = '_';
                        yPion = newY;
                        plateau[xPion][yPion] = '*';
                        updateVisibility(visible, xPion, yPion, TAILLE_PLATEAU);
                    }
                }

                case 'g' -> {
                    int newY = (yPion - 1 + TAILLE_PLATEAU) % TAILLE_PLATEAU;
                    if(plateau[xPion][newY] == '#') {
                        System.out.println("Mouvement impossible, il y a un mur.");
                    } else {
                        if(plateau[xPion][newY] == '$'){
                            compteurPieces++;
                        }
                        plateau[xPion][yPion] = '_';
                        yPion = newY;
                        plateau[xPion][yPion] = '*';
                        updateVisibility(visible, xPion, yPion, TAILLE_PLATEAU);
                    }
                }

                case 'h' -> {
                    int newX = (xPion - 1 + TAILLE_PLATEAU) % TAILLE_PLATEAU;
                    if(plateau[newX][yPion] == '#') {
                        System.out.println("Mouvement impossible, il y a un mur.");
                    } else {
                        if(plateau[newX][yPion] == '$'){
                            compteurPieces++;
                        }
                        plateau[xPion][yPion] = '_';
                        xPion = newX;
                        plateau[xPion][yPion] = '*';
                        updateVisibility(visible, xPion, yPion, TAILLE_PLATEAU);
                    }
                }

                case 'b' -> {
                    int newX = (xPion + 1) % TAILLE_PLATEAU;
                    if(plateau[newX][yPion] == '#') {
                        System.out.println("Mouvement impossible, il y a un mur.");
                    } else {
                        if(plateau[newX][yPion] == '$'){
                            compteurPieces++;
                        }
                        plateau[xPion][yPion] = '_';
                        xPion = newX;
                        plateau[xPion][yPion] = '*';
                        updateVisibility(visible, xPion, yPion, TAILLE_PLATEAU);
                    }
                }

                //Si le choix n'existe pas
                default -> {
                    System.out.println("Cette direction n'existe pas, choisissez une direction (g, d, h, b) ou o pour arrêter");
                }
            }

            //Si le joueur a ramassé toutes les pièces, la partie est terminée
            if(compteurPieces == NOMBRE_PIECES){
                gameWin = true;
            }
        }

        //Affichage du nombre de pièces
        System.out.println("Pièces ramassées : " + compteurPieces);
        System.out.println("Partie Gagnée !!!");
    }


}
