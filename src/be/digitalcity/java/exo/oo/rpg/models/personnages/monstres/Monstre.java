package be.digitalcity.java.exo.oo.rpg.models.personnages.monstres;

import be.digitalcity.java.exo.oo.rpg.utils.De;
import be.digitalcity.java.exo.oo.rpg.models.personnages.Personnage;
import be.digitalcity.java.exo.oo.rpg.utils.BonusStatsUtils;

public abstract class Monstre extends Personnage {
  private int or;
  private int cuir;

  public Monstre(int bonusEndurance, int bonusForce) {
    super(BonusStatsUtils.bonusEnduranceMonstres() + bonusEndurance, BonusStatsUtils.bonusForceMonstres() + bonusForce);
    creerRessources();
  }

  private void creerRessources(){
    if(this.getPV() + this.getForce() <= 30 ){
      this.or = new De(1, 6).lancer();
      this.cuir = new De(1, 4).lancer();
    }
    else if (this.getPV() + this.getForce() <= 50) {
      this.or = new De(1, 6).lancer() * 4;
      this.cuir = new De(1, 4).lancer() * 4;
    }
    else if (this.getPV() + this.getForce() <= 70) {
      this.or = new De(1, 6).lancer() * 8;
      this.cuir = new De(1, 4).lancer() * 8;
    }
    else {
      this.or = new De(1, 6).lancer() * 10;
      this.cuir = new De(1, 4).lancer() * 10;
    }

  }

  public int getOr() {
    return this.or;
  }

  public int getCuir() {
    return this.cuir;
  }


}

