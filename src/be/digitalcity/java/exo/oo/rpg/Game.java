package be.digitalcity.java.exo.oo.rpg;

import be.digitalcity.java.exo.oo.rpg.handler.commands.Action;
import be.digitalcity.java.exo.oo.rpg.models.map.Map;
import be.digitalcity.java.exo.oo.rpg.models.personnages.heros.Heros;
import be.digitalcity.java.exo.oo.rpg.models.personnages.heros.Humain;

import java.util.Scanner;

public class Game {

    private Heros heros;
    private final Map map;
    private Menu menu;
    private UserCommands userCommands;
    private boolean continuer;


    public Game(){
        map = init();

    }

    private Map init() {
        final Map map;
        menu = new Menu();
        userCommands = new UserCommands();
        menu.selectionnerHeros();
        heros = userCommands.selectionHeroCommand();
        map = new Map(heros);
        continuer = true;
        return map;
    }

    public void start(){
        while(continuer) {
            map.updateGrid();
            map.displayGrid();
            menu.afficherDescriptionHeros(heros);
            menu.afficherMenu();
            continuer = userCommands.mainMenuCommands(heros, map);
        }


    }


}
