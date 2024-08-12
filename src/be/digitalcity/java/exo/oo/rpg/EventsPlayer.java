package be.digitalcity.java.exo.oo.rpg;

import be.digitalcity.java.exo.oo.rpg.models.personnages.heros.Heros;
import be.digitalcity.java.exo.oo.rpg.models.personnages.monstres.Dragonnet;
import be.digitalcity.java.exo.oo.rpg.models.personnages.monstres.Loup;
import be.digitalcity.java.exo.oo.rpg.models.personnages.monstres.Monstre;
import be.digitalcity.java.exo.oo.rpg.models.personnages.monstres.Orque;

import java.util.InputMismatchException;
import java.util.Random;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

public class EventsPlayer {

    private Random random = new Random();
    private Scanner scanner = new Scanner(System.in);


    public void choicOfTheUniverse(Heros heros) throws InterruptedException {
        int choiceOfTheUniverse = random.nextInt(5);
            if (choiceOfTheUniverse == 0) {
                encounterMonster(heros);
                System.out.println("Votre héros se repose un peu ...");
                System.out.println("Votre héros a récupéré " + heros.regeneration() + " PV" );

            } else if (choiceOfTheUniverse == 1) {
                discovery(heros);
                TimeUnit.SECONDS.sleep(2);

            }
    }

    private void choixObjet(int multiplicateurObjet, Heros heros) throws InterruptedException {
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
                heros.ajouterPV(puissanceObjet);
            }
            default -> System.out.println("Vous avez raté votre chance !!!");
        }
        System.out.println();
    }

    private void discovery(Heros heros) throws InterruptedException {
        int indiceDeRarete = random.nextInt(0,1000);
        if(indiceDeRarete >=0 && indiceDeRarete < 600){
            //Commun
            System.out.println("Vous avez trouvé un objet (commun)");
            choixObjet(1, heros);
        }
        else if (indiceDeRarete >= 600 && indiceDeRarete < 800) {
            //Rare
            System.out.println("Vous avez trouvé un objet (rare)");
            choixObjet(2, heros);
        }
        else if (indiceDeRarete >= 800 && indiceDeRarete < 950) {
            //Mythique
            System.out.println("Vous avez trouvé un objet (Mythique) !!!");
            choixObjet(4, heros);
        }
        else if (indiceDeRarete >= 950 && indiceDeRarete <= 1000){
            //Legendaire
            System.out.println("Vous avez trouvé un objet (Légendaire)");
            choixObjet(10, heros);
        }
    }

    private void encounterMonster(Heros heros) throws InterruptedException {
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
                heros.ajouterOr(monstre.getOr());
                if (monstre instanceof Loup || monstre instanceof Dragonnet) {
                    heros.ajouterCuir(monstre.getCuir());
                }
                System.out.println("Vous avez récupéré " + monstre.getOr() + " or et " +
                        (monstre instanceof Loup || monstre instanceof Dragonnet ? monstre.getCuir()
                                + " cuir" : "aucun cuir") + ".");
            }
        } else if (!heros.estVivant()) {
            System.out.println("Vous êtes mort. Fin de la partie.");
            System.exit(0);
        }
    }
}
