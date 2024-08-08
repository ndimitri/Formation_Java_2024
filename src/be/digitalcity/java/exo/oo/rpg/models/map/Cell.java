package be.digitalcity.java.exo.oo.rpg.models.map;

public enum Cell {
    HERO_CELL('H'),
    EMPTY_CELL('.');

    private char spriteCell;

    Cell(char spriteCell){
        this.spriteCell = spriteCell;
    }

    public char getSpriteCell(){
        return spriteCell;
    }
}
