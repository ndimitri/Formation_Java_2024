package be.digitalcity.java.exo.oo.rpg.models.map;

import be.digitalcity.java.exo.oo.rpg.models.personnages.heros.Heros;

import java.util.Random;

public class Map {
    public final int GRID_SIZE = 5;
    private Heros heros;
    private char[][] grid;
    private Random random = new Random();

    public Map() {
        this.grid = new char[GRID_SIZE][GRID_SIZE];
        this.heros.setPosition(GRID_SIZE/2, GRID_SIZE/2);
    }

    public void displayGrid() {
        for (int i = 0; i < GRID_SIZE; i++) {
            for (int j = 0; j < GRID_SIZE; j++) {
                System.out.print(grid[i][j] + " ");
            }
            System.out.println();
        }
    }

    public void updateGrid() {
        for (int i = 0; i < GRID_SIZE; i++) {
            for (int j = 0; j < GRID_SIZE; j++) {
                grid[i][j] = Cell.EMPTY_CELL.getSpriteCell();
            }
        }
        grid[heros.getPosition().y][heros.getPosition().x] = Cell.HERO_CELL.getSpriteCell();
    }



}
