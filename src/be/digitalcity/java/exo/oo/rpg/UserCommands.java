package be.digitalcity.java.exo.oo.rpg;

import be.digitalcity.java.exo.oo.rpg.handler.commands.Action;
import be.digitalcity.java.exo.oo.rpg.models.map.Map;
import be.digitalcity.java.exo.oo.rpg.models.personnages.heros.Heros;
import be.digitalcity.java.exo.oo.rpg.models.personnages.heros.Humain;
import be.digitalcity.java.exo.oo.rpg.models.personnages.heros.Nain;

import java.util.Scanner;

public class UserCommands {
    private Scanner scanner =  new Scanner(System.in);
    private Action action = new Action();
    private Menu menu = new Menu();
    private Boutique boutique = new Boutique();


    public boolean mainMenuCommands(Heros heros, Map map){

        char choix;

            try{
                choix = scanner.nextLine().charAt(0);
            }catch (StringIndexOutOfBoundsException e){
                System.out.println("Veuillez indiquer une action");
                choix ='*';
            }

            if (choix == 'r') {
                System.out.println("Merci d'avoir joué!");
                return false;
            }

            switch (choix) {
                case 'z': action.moveUp(heros, map); break;
                case 's': action.moveDown(heros, map); break;
                case 'q': action.moveLeft(heros, map); break;
                case 'd': action.moveRight(heros, map); break;
                case 'i' : menu.afficherInventaire(heros); break;
                case 'b' : boutique.entrer(heros); break;
                case 'p' : menu.afficherDescriptionHeros(heros); break;
                default: System.out.println("Commande invalide.");
            }
            return true;


    }

    public Heros selectionHeroCommand(){
        Heros heroToReturn = null ;
        int choix;
        do {
            try{
                choix = scanner.nextInt();
            }catch (StringIndexOutOfBoundsException e){
                System.out.println("Veuillez indiquer une action");
                choix =0;
            }

            switch (choix) {
                case 1: heroToReturn = new Humain(); break;
                case 2: heroToReturn = new Nain(); break;
                default: System.out.println("Commande invalide.");
            }
        } while (choix != 1 && choix != 2);
        scanner.nextLine();
        return heroToReturn;

    }
}
