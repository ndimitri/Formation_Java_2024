package be.digitalcity.java.exo.oo.zoo;

import java.util.Scanner;

public class GestionZoo {
  private Zoo zoo;
  private Scanner scanner;

  public GestionZoo() {
    zoo = new Zoo("Mon Zoo");
    scanner = new Scanner(System.in);
  }

  public static void main(String[] args) {
    GestionZoo gestionZoo = new GestionZoo();
    gestionZoo.run();
  }

  private void run() {
    while (true) {
      afficherMenu();
      int choix = Integer.parseInt(scanner.nextLine());

      switch (choix) {
        case 1:
          ajouterEnclos();
          break;
        case 2:
          ajouterAnimal();
          break;
        case 3:
          deplacerAnimal();
          break;
        case 4:
          deplacerAnimaux();
          break;
        case 5:
          afficherEtatZoo();
          break;
        case 6:
          System.out.println("Au revoir!");
          return;
        default:
          System.out.println("Choix invalide, veuillez réessayer.");
      }
    }
  }

  private void afficherMenu() {
    System.out.println("\n╔═══════════════════════════════════╗");
    System.out.println("║      --- Menu Gestion Zoo ---     ║");
    System.out.println("╠═══════════════════════════════════╣");
    System.out.println("║ 1. Ajouter un enclos              ║");
    System.out.println("║ 2. Ajouter un animal              ║");
    System.out.println("║ 3. Déplacer un animal             ║");
    System.out.println("║ 4. Déplacer les animaux d'un enclos║");
    System.out.println("║ 5. Afficher l'état du zoo         ║");
    System.out.println("║ 6. Quitter                        ║");
    System.out.println("╚═══════════════════════════════════╝");
    System.out.print("Choisissez une option: ");
  }

  private void ajouterEnclos() {
    System.out.println("\n╔═══════════════════════════════════╗");
    System.out.println("║         --- Ajouter Enclos ---         ║");
    System.out.println("╚═══════════════════════════════════╝");

    System.out.print("Nom de l'enclos: ");
    String nom = scanner.nextLine();

    System.out.println("Type d'environnement de l'enclos:");
    for (Environnement env : Environnement.values()) {
      System.out.println(env.ordinal() + 1 + ". " + env.getValeur());
    }
    int typeIndex = Integer.parseInt(scanner.nextLine()) - 1;
    Environnement type = Environnement.values()[typeIndex];

    System.out.print("Capacité de l'enclos (laisser vide pour la capacité par défaut): ");
    String capaciteInput = scanner.nextLine();
    int capacite = capaciteInput.isEmpty() ? Enclos.CAPACITE_DEFAULT : Integer.parseInt(capaciteInput);

    Enclos enclos = capaciteInput.isEmpty() ? new Enclos(nom, type) : new Enclos(nom, type, capacite);
    zoo.ajouterEnclos(enclos);
    System.out.println("Enclos ajouté avec succès.");
  }

  private void ajouterAnimal() {
    System.out.println("\n╔═══════════════════════════════════╗");
    System.out.println("║         --- Ajouter Animal ---         ║");
    System.out.println("╚═══════════════════════════════════╝");

    System.out.print("Nom de l'animal: ");
    String nom = scanner.nextLine();

    System.out.print("Espèce de l'animal: ");
    String espece = scanner.nextLine();

    System.out.println("Type de l'animal:");
    for (Environnement env : Environnement.values()) {
      System.out.println(env.ordinal() + 1 + ". " + env.getValeur());
    }
    int typeIndex = Integer.parseInt(scanner.nextLine()) - 1;
    Environnement type = Environnement.values()[typeIndex];

    Animal animal = new Animal(nom, espece, type);

    System.out.print("Nom de l'enclos: ");
    String nomEnclos = scanner.nextLine();

    for (Enclos enclos : zoo.enclosSet) {
      if (enclos.nom.equals(nomEnclos)) {
        if (enclos.ajouterAnimal(animal)) {
          System.out.println(animal.nom+ " ajouté à l'enclos "+ enclos.nom + " avec succès.");
        } else {
          System.out.println("Impossible d'ajouter "+ animal.nom+" ("+ animal.type+")"+" à l'enclos"+ enclos.nom +" ("+ enclos.type+")"+".");
        }
        return;
      }
    }
    System.out.println("Enclos non trouvé.");
  }

  private void deplacerAnimal() {
    System.out.println("\n╔═══════════════════════════════════╗");
    System.out.println("║         --- Déplacer Animal ---         ║");
    System.out.println("╚═══════════════════════════════════╝");

    System.out.print("Nom de l'animal a déplacer: ");
    String nomAnimal = scanner.nextLine();

    System.out.print("Nom de l'enclos de départ: ");
    String nomEnclosDepart = scanner.nextLine();

    System.out.print("Nom de l'enclos d'arrivée: ");
    String nomEnclosArrivee = scanner.nextLine();

    Enclos enclosDepart = null;
    Enclos enclosArrivee = null;

    for (Enclos enclos : zoo.enclosSet) {
      if (enclos.nom.equals(nomEnclosDepart)) {
        enclosDepart = enclos;
      }
      if (enclos.nom.equals(nomEnclosArrivee)) {
        enclosArrivee = enclos;
      }
    }

    if (enclosDepart == null || enclosArrivee == null) {
      System.out.println("Un ou plusieurs enclos non trouvés.");
      return;
    }

    for (Animal animal : enclosDepart.animaux) {
      if (animal.nom.equals(nomAnimal)) {
        if (enclosDepart.deplacerAnimal(animal, enclosArrivee)) {
          System.out.println(animal.nom+" déplacé avec succès vers " + enclosArrivee.nom + ".");
        } else {
          System.out.println("Impossible de déplacer "+animal.nom+".");
        }
        return;
      }
    }
    System.out.println("Animal non trouvé dans l'enclos de départ.");
  }

  private void deplacerAnimaux() {
    System.out.println("\n╔═══════════════════════════════════╗");
    System.out.println("║         --- Déplacer Animaux ---       ║");
    System.out.println("╚═══════════════════════════════════╝");

    System.out.print("Nom de l'enclos des animaux de départs: ");
    String nomEnclosDepart = scanner.nextLine();

    System.out.print("Nom de l'enclos des animaux d'arrivées: ");
    String nomEnclosArrivee = scanner.nextLine();

    Enclos enclosDepart = null;
    Enclos enclosArrivee = null;

    for (Enclos enclos : zoo.enclosSet) {
      if (enclos.nom.equals(nomEnclosDepart)) {
        enclosDepart = enclos;
      }
      if (enclos.nom.equals(nomEnclosArrivee)) {
        enclosArrivee = enclos;
      }
    }
    if (enclosDepart == null || enclosArrivee == null) {
      System.out.println("Un ou plusieurs enclos non trouvés.");
      return;
    }
    if(zoo.deplacerAnimaux(enclosDepart, enclosArrivee)){
      System.out.println("Déplacement des animaux de l'enclos "+ enclosDepart.nom+" ---> l'enclos " + enclosArrivee.nom+" réussie !" );
      return;
    }
    else {
      System.out.println("Déplacement des animaux de l'enclos"+ enclosDepart.nom+ " ---> l'enclos " + enclosArrivee.nom+" impossible !");
    }

  }

//  private void afficherEtatZoo() {
//    System.out.println("\n--- État du Zoo ---");
//    System.out.println("Zoo: " + zoo.nom);
//    for (Enclos enclos : zoo.enclosSet) {
//      System.out.println("Enclos: " + enclos.nom + " (" + enclos.type.getValeur() + ")");
//      System.out.println("Capacité: " + enclos.capacite);
//      System.out.println("Animaux:");
//      for (Animal animal : enclos.animaux) {
//        System.out.println("  - " + animal.nom + " (" + animal.espece + ")");
//      }
//      System.out.println();
//    }
//  }

  private void afficherEtatZoo() {
    System.out.println("\n╔═══════════════════════════════════╗");
    System.out.println("║        --- État du Zoo ---              ║");
    System.out.println("╚═══════════════════════════════════╝");

    System.out.println("Zoo: " + zoo.nom);
    for (Enclos enclos : zoo.enclosSet) {
      System.out.println("╔═══════════════════════════════════╗");
      System.out.println("║ Enclos: " + enclos.nom + " (" + enclos.type.getValeur() + ")");
      System.out.println("║ Capacité: " + enclos.capacite);
      System.out.println("║ Animaux:");
      for (Animal animal : enclos.animaux) {
        System.out.println("║   - " + animal.nom + " (" + animal.espece + ")");
      }
      System.out.println("╚═══════════════════════════════════╝\n");
    }
  }
}
