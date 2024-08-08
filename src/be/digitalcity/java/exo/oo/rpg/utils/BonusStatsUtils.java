package be.digitalcity.java.exo.oo.rpg.utils;

import java.util.Random;

public abstract class BonusStatsUtils {
    private static Random random = new Random();

    public static int bonusEnduranceHeros(){
        return random.nextInt(20,50);
    }

    public static int bonusForceHeros(){
        return random.nextInt(20,50);
    }

    public static int bonusEnduranceMonstres(){
        return random.nextInt(10,30);
    }

    public static int bonusForceMonstres(){
        return random.nextInt(10,20);
    }

}
