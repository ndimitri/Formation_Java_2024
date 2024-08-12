package be.digitalcity.java.exo.oo.rpg.models.personnages.heros;

import be.digitalcity.java.exo.oo.rpg.models.personnages.monstres.Monstre;
import be.digitalcity.java.exo.oo.rpg.models.personnages.Personnage;
import be.digitalcity.java.exo.oo.rpg.utils.BonusEnum;
import be.digitalcity.java.exo.oo.rpg.utils.BonusStatsUtils;

import java.awt.*;
import java.util.Random;
import java.util.concurrent.TimeUnit;

public abstract class Heros extends Personnage {
  private int or;
  private int cuir;
  private int niveau;
  private int experience;
  private int experiencePourNiveauSuivant;
  private int cooldownSpecial;
  private Point herosPosition;

  public Heros(int bonusEndurance, int bonusForce) {
    super( BonusEnum.HERO.getBonusEndurance() + bonusEndurance, BonusStatsUtils.bonusForceHeros() + bonusForce);
    this.or = 0;
    this.cuir = 0;
    this.niveau = 1;
    this.experience = 0;
    this.experiencePourNiveauSuivant = 100;
    this.cooldownSpecial = 0;
    this.herosPosition = new Point();
  }

  public Point getPosition() {
    return herosPosition;
  }

  public void setPosition(int x, int y) {
    this.herosPosition.setLocation(x,y);
  }

  public int getOr() {
    return or;
  }

  public int getCuir() {
    return cuir;
  }

  public int getNiveau() {
    return niveau;
  }

  public int getExperience() {
    return experience;
  }

  public int getExperiencePourNiveauSuivant() {
    return experiencePourNiveauSuivant;
  }

  public void ajouterOr(int valeur) {
    this.or += valeur;
  }

  public void retirerOr(int valeur){
    this.or -= valeur;
  }

  public void ajouterCuir(int valeur) {
    this.cuir += valeur;
  }

  public void retirerCuir(int valeur){
    this.cuir -= valeur;
  }

  public void gagnerExperience(int xp) {
    this.experience += xp;
    while (this.experience >= this.experiencePourNiveauSuivant) {
      this.experience -= this.experiencePourNiveauSuivant;
      niveauUp();
    }
  }

  private void niveauUp() {
    this.niveau++;
    this.experiencePourNiveauSuivant += 50;
    this.ajouterForce(2);
    this.ajouterEndurance(2);
    this.ajouterPV(2);
    System.out.println("Niveau augmenté ! Vous êtes maintenant niveau " + this.niveau + ".");
    System.out.println("Tous vos attributs ont été augmenté de 2");
  }

  public void utiliserSpecial(Monstre monstre) {
    if (peutUtiliserSpecial()) {
      Random random = new Random();
      // Exemple d'attaque spéciale, peut être personnalisée
      int degats = random.nextInt(this.getForce()/2, (this.getForce() *7)/8);

      monstre.recevoirDegats(degats);
      System.out.println("Vous utilisez votre compétence spéciale et infligez " + degats + " dégâts !");
      try {
        TimeUnit.SECONDS.sleep(2);
      } catch (InterruptedException e) {
        throw new RuntimeException(e);
      }
      this.cooldownSpecial = 3; // Cooldown de 3 tours
    } else {
      System.out.println("Votre compétence spéciale n'est pas encore prête.");
    }
  }

  private boolean peutUtiliserSpecial() {
    return cooldownSpecial == 0;
  }

  public void decrementerCooldown() {
    if (cooldownSpecial > 0) {
      cooldownSpecial--;
    }
  }






}

