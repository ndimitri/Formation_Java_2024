package be.digitalcity.java.exo.oo.rpg;

import be.digitalcity.java.exo.oo.rpg.models.personnages.heros.Heros;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Boutique {
  private Scanner scanner = new Scanner(System.in);

  public void entrer(Heros heros) {
    while (true) {
      System.out.println("\nBienvenue à la boutique !");
      System.out.println("Votre or : " + heros.getOr() + ", votre cuir : " + heros.getCuir());
      System.out.println("1. Acheter Pilule Force (5 or pour +1 force)");
      System.out.println("2. Acheter Gordon Explosion !!!(50 or pour +10 force)");
      System.out.println("3. Vendre du cuir (2 or par cuir)");
      System.out.println("4. Vendre tout le cuir (2 or par cuir)");
      System.out.println("5. Acheter une Potion Simple (10 or pour +7PV)");
      System.out.println("6. Acheter une Potion Maxi (50 or pour +40PV)");
      System.out.println("7. Quitter la boutique");
      int choix;
      try{
        choix = scanner.nextInt();
      }catch(InputMismatchException e){
        choix = 0;
      }
      scanner.nextLine(); // Consume newline left-over

      switch (choix) {
        case 1:
          acheterForce(heros);
          break;
        case 2:
          acheterMaxiForce(heros);
          break;

        case 3:
          vendreCuir(heros);
          break;
        case 4:
          vendreCuir(heros,heros.getCuir());
          break;
        case 5:
          acheterPotion(heros);
          break;
        case 6:
          acheterMaxiPotion(heros);
          break;
        case 7:
          System.out.println("Merci de votre visite !");
          return;
        default:
          System.out.println("Choix invalide.");
      }
    }
  }

  private void vendreCuir(Heros heros, int nbrCuir) {
    if (heros.getCuir() > 0) {
      heros.ajouterOr(2*nbrCuir);
      heros.retirerCuir(nbrCuir);
      System.out.println("Vous avez vendu "+ nbrCuir +" cuir pour "+2*nbrCuir +" or.");
    } else {
      System.out.println("Vous n'avez pas de cuir à vendre.");
    }
  }

  private void acheterPotion(Heros heros){
    if(heros.getOr() >= 10){
      heros.retirerOr(10);
      heros.ajouterPV(7);
      System.out.println("Vous avez acheté une Potion Simple +7PV.");
    }else {
      System.out.println("Vous n'avez pas assez d'or.");
    }
  }

  private void acheterMaxiPotion(Heros heros){
    if(heros.getOr() >= 50){
      heros.retirerOr(50);
      heros.ajouterPV(40);
      System.out.println("Vous avez acheté une Potion Maxi +40PV.");
    }else {
      System.out.println("Vous n'avez pas assez d'or.");
    }
  }

  private void acheterMaxiForce(Heros heros) {
    if (heros.getOr() >= 50) {
      heros.retirerOr(50);
      heros.ajouterForce(10);
      System.out.println("Vous avez acheté +10 force.");
    } else {
      System.out.println("Vous n'avez pas assez d'or.");
    }
  }

  private void acheterForce(Heros heros) {
    if (heros.getOr() >= 5) {
      heros.retirerOr(5);
      heros.ajouterForce(1);
      System.out.println("Vous avez acheté +1 force.");
    } else {
      System.out.println("Vous n'avez pas assez d'or.");
    }
  }

  private void vendreCuir(Heros heros) {
    if (heros.getCuir() > 0) {
      heros.ajouterOr(2);
      heros.retirerCuir(1);
      System.out.println("Vous avez vendu 1 cuir pour 2 or.");
    } else {
      System.out.println("Vous n'avez pas de cuir à vendre.");
    }
  }
}

