package be.digitalcity.java.exo.oo.rpg;
import java.util.InputMismatchException;
import java.util.Random;
import java.util.Scanner;
import java.awt.Point;
import java.util.concurrent.TimeUnit;

public class Main {
  private static final int GRID_SIZE = 5;
  private static final char EMPTY_CELL = '.';
  private static final char HERO_CELL = 'H';
  private static char[][] grid;
  private static Heros heros;
  private static Point herosPosition;
  private static Random random = new Random();
  private static Scanner scanner = new Scanner(System.in);
  private static Boutique boutique = new Boutique();

  public static void main(String[] args) throws InterruptedException {
    heros = new Humain(); // Ou new Nain();
    herosPosition = new Point(GRID_SIZE / 2, GRID_SIZE / 2);
    grid = new char[GRID_SIZE][GRID_SIZE];
    System.out.println("Humain : \n" + heros.getEndurance() + " STAMINA\n" + heros.getForce() + " FORCE\n" + heros.getPV() + " PV");

    while (true) {
      updateGrid();
      displayGrid();
      System.out.println("Déplacez le héros (z: haut, s: bas, q: gauche, d: droite, i: inventaire, b: boutique, p: heros, r: quitter): ");
      char action;
      try{
        action = scanner.nextLine().charAt(0);
      }catch (StringIndexOutOfBoundsException e){
        System.out.println("Veuillez indiquer une action");
        action ='m';
      }

      if (action == 'r') {
        System.out.println("Merci d'avoir joué!");
        break;
      }

      switch (action) {
        case 'z': moveHero(0, -1); break;
        case 's': moveHero(0, 1); break;
        case 'q': moveHero(-1, 0); break;
        case 'd': moveHero(1, 0); break;
        case 'i' : inventory(); break;
        case 'b' : boutique.entrer(heros); break;
        case 'p' : herosDescription(); break;
        default: System.out.println("Commande invalide.");
      }
    }
  }

  private static void herosDescription(){
    System.out.println("Héros (" + heros.getClass().getSimpleName() + ") : \n" +
        heros.getEndurance() + " STAMINA\n" + heros.getForce() + " FORCE\n" +
        heros.getPV() + " PV\n" + "Niveau: " + heros.getNiveau() + "\n" +
        "Expérience: " + heros.getExperience()+"/"+heros.getExperiencePourNiveauSuivant());
  }

  private static void inventory(){
    System.out.println("Inventaire :");
    System.out.println("Or : " + heros.getOr() + " | Cuir : " + heros.getCuir());
  }

  private static void updateGrid() {
    for (int i = 0; i < GRID_SIZE; i++) {
      for (int j = 0; j < GRID_SIZE; j++) {
        grid[i][j] = EMPTY_CELL;
      }
    }
    grid[herosPosition.y][herosPosition.x] = HERO_CELL;
  }

  private static void displayGrid() {
    for (int i = 0; i < GRID_SIZE; i++) {
      for (int j = 0; j < GRID_SIZE; j++) {
        System.out.print(grid[i][j] + " ");
      }
      System.out.println();
    }
  }

  private static void moveHero(int dx, int dy) throws InterruptedException {
    int newX = herosPosition.x + dx;
    int newY = herosPosition.y + dy;

    if (newX >= 0 && newX < GRID_SIZE && newY >= 0 && newY < GRID_SIZE) {
      herosPosition.setLocation(newX, newY);
      int choiceOfTheUniverse = random.nextInt(5);
      if (choiceOfTheUniverse == 0) {
        encounterMonster();
        System.out.println("Votre héros se repose un peu ...");
        System.out.println("Votre héros a récupéré " + heros.regeneration() + " PV" );

      } else if (choiceOfTheUniverse == 1) {
        discovery();
        TimeUnit.SECONDS.sleep(2);

      }
    } else {
      System.out.println("Déplacement hors limite.");
    }
  }

  private static void choixObjet(int multiplicateurObjet) throws InterruptedException {
    System.out.println("Le héros prend l'objet ...");
    TimeUnit.SECONDS.sleep(2);

    System.out.print("L'objet est de type : ");
    int choixObjet = random.nextInt(1,4);
    int puissanceObjet = random.nextInt(1,5) * multiplicateurObjet;
    switch (choixObjet){
      case 1 -> {
        System.out.println("Force");
        System.out.println("+" + puissanceObjet +" Force");
        heros.ajouterForce(puissanceObjet);
      }
      case 2 -> {
        System.out.println("Endurance");
        System.out.println("+" + puissanceObjet/2 +" PV et +" + puissanceObjet/2 + " Force");
        heros.ajouterEndurance(puissanceObjet);
      }
      case 3 -> {
        System.out.println("PV");
        System.out.println("+" + puissanceObjet +" PV");
        heros.regeneration(puissanceObjet);
      }
      default -> System.out.println("Vous avez raté votre chance !!!");
    }
    System.out.println();
  }

  private static void discovery() throws InterruptedException {
    int indiceDeRarete = random.nextInt(0,1000);
    if(indiceDeRarete >=0 && indiceDeRarete < 600){
      //Commun
      System.out.println("Vous avez trouvé un objet (commun)");
      choixObjet(1);
    }
    else if (indiceDeRarete >= 600 && indiceDeRarete < 800) {
      //Rare
      System.out.println("Vous avez trouvé un objet (rare)");
      choixObjet(2);
    }
    else if (indiceDeRarete >= 800 && indiceDeRarete < 950) {
      //Mythique
      System.out.println("Vous avez trouvé un objet (Mythique) !!!");
      choixObjet(4);
    }
    else if (indiceDeRarete >= 950 && indiceDeRarete <= 1000){
      //Legendaire
      System.out.println("Vous avez trouvé un objet (Légendaire)");
      choixObjet(10);
    }
  }

  private static void encounterMonster() throws InterruptedException {
    Monstre monstre;
    int monsterType = random.nextInt(3);
    monstre = switch (monsterType) {
          case 0 -> new Loup();
          case 1 -> new Orque();
          default -> new Dragonnet();
      };

    if(monstre.getForce() >= 40 && monstre.getPV() >= 40){
      System.out.println("Attention ! Le Boss n'est pas loin ...");
      TimeUnit.SECONDS.sleep(2);
      System.out.println("Le voila !!!" + "Un " + monstre.getClass().getSimpleName() + " (Boss) apparaît !");
    }
    else {
      if (monstre.getForce() >= 40) {
        System.out.println("Attention ! Un monstre plutôt fort est dans les environs ...");
        TimeUnit.SECONDS.sleep(2);
        System.out.println("Là !!!" + "Un " + monstre.getClass().getSimpleName() + " (Berserk) apparaît !");
      }
      else if (monstre.getPV() >= 40) {
        System.out.println("Attention ! Un monstre plutôt robuste nous observe ...");
        TimeUnit.SECONDS.sleep(2);
        System.out.println("Ici !!!" + "Un " + monstre.getClass().getSimpleName() + " (Tank) apparaît !");
      }
      else{
        System.out.println("Un " + monstre.getClass().getSimpleName() + " apparaît !");
      }
    }

    boolean combatTermine = false;
    while (heros.estVivant() && monstre.estVivant() && !combatTermine) {
      System.out.println("Héros: PV = " + heros.getPV() + " | FOR = " + heros.getForce());
      System.out.println(monstre.getClass().getSimpleName() + ": PV = " + monstre.getPV()+ " | FOR = " + monstre.getForce());
      System.out.println("Que voulez-vous faire ? (1: Attaquer, 2: Fuir, 3: Compétence spéciale)");
      int choix;
      try{
        choix = scanner.nextInt();
      }catch(InputMismatchException e){
        choix = 4;
      }

      scanner.nextLine(); // Consume newline left-over

      switch (choix) {
        case 1:
          heros.frapper(monstre);
          if (monstre.estVivant()) {
            monstre.frapper(heros);
          }
          break;
        case 2:
          if (random.nextInt(2) == 0) { // 50% chance to escape
            System.out.println("Vous avez réussi à fuir !");
            combatTermine = true;
          } else {
            System.out.println("Vous n'avez pas réussi à fuir !");
            monstre.frapper(heros);
          }
          break;
        case 3:
          heros.utiliserSpecial(monstre);
          if (monstre.estVivant()) {
            monstre.frapper(heros);
          }
          break;
        default:
          System.out.println("Choix invalide.");
      }

      heros.decrementerCooldown();
    }

    if (heros.estVivant() && !monstre.estVivant()) {
      System.out.println("Vous avez vaincu le " + monstre.getClass().getSimpleName() + " !");
      heros.gagnerExperience(50); // Gagne de l'XP pour avoir vaincu le monstre
      System.out.println("Voulez-vous dépouiller la victime ? (1: Oui, 2: Non)");
      int choix = scanner.nextInt();
      scanner.nextLine(); // Consume newline left-over

      if (choix == 1) {
        heros.ajouterOr(monstre.depouillerOr());
        if (monstre instanceof Loup || monstre instanceof Dragonnet) {
          heros.ajouterCuir(monstre.depouillerCuir());
        }
        System.out.println("Vous avez récupéré " + monstre.depouillerOr() + " or et " +
            (monstre instanceof Loup || monstre instanceof Dragonnet ? monstre.depouillerCuir()
                + " cuir" : "aucun cuir") + ".");
      }
    } else if (!heros.estVivant()) {
      System.out.println("Vous êtes mort. Fin de la partie.");
      System.exit(0);
    }
  }
}
