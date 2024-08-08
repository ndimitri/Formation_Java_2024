package be.digitalcity.java.exo.oo.rpg.handler.commands;

import be.digitalcity.java.exo.oo.rpg.models.map.Map;
import be.digitalcity.java.exo.oo.rpg.models.personnages.heros.Heros;

import java.util.concurrent.TimeUnit;

public class Action {


    public void moveUp(Heros heros, Map map){
        int newX = heros.getPosition().x;
        int newY = heros.getPosition().y - 1;

        if (newX >= 0 && newX < map.GRID_SIZE && newY >= 0 && newY < map.GRID_SIZE) {
            heros.setPosition(newX, newY);

//            int choiceOfTheUniverse = random.nextInt(5);
//            if (choiceOfTheUniverse == 0) {
//                encounterMonster();
//                System.out.println("Votre héros se repose un peu ...");
//                System.out.println("Votre héros a récupéré " + heros.regeneration() + " PV" );
//
//            } else if (choiceOfTheUniverse == 1) {
//                discovery();
//                TimeUnit.SECONDS.sleep(2);
//
//            }
        } else {
            System.out.println("Déplacement hors limite.");
        }
    }

}
