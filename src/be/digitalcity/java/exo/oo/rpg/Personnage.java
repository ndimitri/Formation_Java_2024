package be.digitalcity.java.exo.oo.rpg;

import java.util.concurrent.TimeUnit;

public abstract class Personnage {
  private int endurance;
  private int force;
  private int pv;

  public Personnage(int bonusEndurance, int bonusForce) {
    this.endurance = calculerCaracteristique() + bonusEndurance;
    this.force = calculerCaracteristique() + bonusForce;
    this.pv = this.endurance + calculerModificateur(this.endurance);
  }

  private int calculerCaracteristique() {
    De de = new De(1, 6);
    int[] des = new int[4];
    for (int i = 0; i < 4; i++) {
      des[i] = de.lancer();
    }
    java.util.Arrays.sort(des);
    return des[1] + des[2] + des[3];
  }

  protected int calculerModificateur(int valeur) {
    if (valeur < 5) {
      return -1;
    } else if (valeur < 10) {
      return 0;
    } else if (valeur < 15) {
      return 1;
    } else {
      return 2;
    }
  }

  public void frapper(Personnage cible) {
    De de = new De(1, this.force/3);
    int degats = de.lancer() + calculerModificateur(this.force);
    cible.recevoirDegats(degats);

    if(this instanceof Heros){
      System.out.println("Vous infligez " + degats + " dégats");
    }
    else if(this instanceof Monstre){
      System.out.println(this.getClass().getSimpleName() + " inflige " + degats + " dégats");
    }
    try {
      TimeUnit.SECONDS.sleep(2);
    } catch (InterruptedException e) {
      throw new RuntimeException(e);
    }
  }

  public void recevoirDegats(int degats) {
    this.pv -= degats;
    if (this.pv < 0) {
      this.pv = 0;
    }
  }

  public boolean estVivant() {
    return this.pv > 0;
  }

  public int getEndurance() {
    return endurance;
  }

  public int getForce() {
    return force;
  }

  public int getPV() {
    return pv;
  }

  public void ajouterEndurance(int valeur){
    ajouterForce(valeur/2);
    regeneration(valeur/2);
  }

  public int regeneration() {
    int pvAdded = new De(3, 9).lancer();
    this.pv += pvAdded;
    return pvAdded;
  }

  public int regeneration(int pvToAdd){
    this.pv += pvToAdd;
    return pvToAdd;
  }

  public void ajouterForce(int valeur){
    this.force += valeur;
  }
}