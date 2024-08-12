package be.digitalcity.java.exo.oo.rpg.utils;

public enum BonusEnum {
    HERO(BonusStatsUtils.bonusForceHeros(), BonusStatsUtils.bonusEnduranceHeros()),
    MONSTRE(BonusStatsUtils.bonusForceMonstres(), BonusStatsUtils.bonusEnduranceMonstres());


    private int bonusForce;
    private int bonusEndurance;

    BonusEnum(int bonusForce, int bonusEndurance){
        this.bonusForce = bonusForce;
        this.bonusEndurance = bonusEndurance;
    }

    public int getBonusForce() {
        return bonusForce;
    }

    public int getBonusEndurance() {
        return bonusEndurance;
    }
}
