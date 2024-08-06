package be.digitalcity.java.exo.oo.rpg;

import java.util.Random;

public abstract class Monstre extends Personnage {
  private int or;
  private int cuir;

  protected Monstre(int bonusEndurance, int bonusForce) {
    super(new Random().nextInt(10,30)+bonusEndurance, new Random().nextInt(10,20)+bonusForce);
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

  public int depouillerOr() {
    return this.or;
  }

  public int depouillerCuir() {
    return this.cuir;
  }


}

