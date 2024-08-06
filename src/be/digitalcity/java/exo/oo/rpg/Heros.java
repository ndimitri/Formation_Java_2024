package be.digitalcity.java.exo.oo.rpg;

import java.util.Random;
import java.util.concurrent.TimeUnit;

public abstract class Heros extends Personnage {
  private int or;
  private int cuir;
  private int niveau;
  private int experience;
  private int experiencePourNiveauSuivant;
  private int cooldownSpecial;

  public Heros(int bonusEndurance, int bonusForce) {
    super(new Random().nextInt(20,50)+bonusEndurance, new Random().nextInt(20,50)+bonusForce);
    this.or = 0;
    this.cuir = 0;
    this.niveau = 1;
    this.experience = 0;
    this.experiencePourNiveauSuivant = 100;
    this.cooldownSpecial = 0;
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
    this.regeneration(2);
    System.out.println("Niveau augmenté ! Vous êtes maintenant niveau " + this.niveau + ".");
    System.out.println("Tous vos attributs ont été augmenté de 2");
  }

  public void utiliserSpecial(Monstre monstre) {
    if (peutUtiliserSpecial()) {
      Random random = new Random();
      // Exemple d'attaque spéciale, peut être personnalisée
      int degats = random.nextInt(10, 20);// + this.getModificateurForce();
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

  public void decrementerCooldown() {
    if (cooldownSpecial > 0) {
      cooldownSpecial--;
    }
  }

  public boolean peutUtiliserSpecial() {
    return cooldownSpecial == 0;
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

  public int getOr() {
    return or;
  }

  public int getCuir() {
    return cuir;
  }


}

