package be.digitalcity.java.exo.oo.rpg.handler.commands;

import be.digitalcity.java.exo.oo.rpg.EventsPlayer;
import be.digitalcity.java.exo.oo.rpg.models.map.Map;
import be.digitalcity.java.exo.oo.rpg.models.personnages.heros.Heros;

import java.util.concurrent.TimeUnit;

public class Action {

    private EventsPlayer eventsPlayer =  new EventsPlayer();

    public void moveUp(Heros heros, Map map) {
        int newX = heros.getPosition().x;
        int newY = heros.getPosition().y - 1;

        if (newX >= 0 && newX < map.GRID_SIZE && newY >= 0 && newY < map.GRID_SIZE) {
            heros.setPosition(newX, newY);
            try {
                eventsPlayer.choicOfTheUniverse(heros);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }

        } else {
            System.out.println("Déplacement hors limite.");
        }
    }

    public void moveDown(Heros heros, Map map){
        int newX = heros.getPosition().x;
        int newY = heros.getPosition().y + 1;

        if (newX >= 0 && newX < map.GRID_SIZE && newY >= 0 && newY < map.GRID_SIZE) {
            heros.setPosition(newX, newY);
            try {
                eventsPlayer.choicOfTheUniverse(heros);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        } else {
            System.out.println("Déplacement hors limite.");
        }
    }

    public void moveRight(Heros heros, Map map){
        int newX = heros.getPosition().x + 1;
        int newY = heros.getPosition().y;

        if (newX >= 0 && newX < map.GRID_SIZE && newY >= 0 && newY < map.GRID_SIZE) {
            heros.setPosition(newX, newY);
            try {
                eventsPlayer.choicOfTheUniverse(heros);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        } else {
            System.out.println("Déplacement hors limite.");
        }
    }

    public void moveLeft(Heros heros, Map map){
        int newX = heros.getPosition().x - 1;
        int newY = heros.getPosition().y;

        if (newX >= 0 && newX < map.GRID_SIZE && newY >= 0 && newY < map.GRID_SIZE) {
            heros.setPosition(newX, newY);
            try {
                eventsPlayer.choicOfTheUniverse(heros);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        } else {
            System.out.println("Déplacement hors limite.");
        }
    }

}
