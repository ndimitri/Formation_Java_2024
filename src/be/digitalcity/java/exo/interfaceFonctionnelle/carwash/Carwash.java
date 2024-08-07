package be.digitalcity.java.exo.interfaceFonctionnelle.carwash;

import java.util.ArrayList;
import java.util.List;

public class Carwash {

    private ActionVoiture preparer = (Voiture voiture) -> System.out.println("Je prépare la voiture : " + voiture.getPlaque());
    private ActionVoiture laver = (Voiture voiture) -> System.out.println("Je lave la voiture : " + voiture.getPlaque());
    private ActionVoiture secher = (Voiture voiture) -> System.out.println("Je sèche la voiture : " + voiture.getPlaque());
    private ActionVoiture finaliser = (Voiture voiture) -> System.out.println("Je finalise la voiture : " + voiture.getPlaque());


    List<ActionVoiture> evenementsVoiture = List.of(preparer, laver, secher, finaliser);


    public void traiter(Voiture voiture){

        List<ActionVoiture> evenementsVoiture2 = List.of(
                (Voiture v) -> System.out.println("Je prépare la voiture "+v.getPlaque()),
                (Voiture v) -> System.out.println("Je lave la voiture "+v.getPlaque()),
                (Voiture v) -> System.out.println("Je sèche la voiture "+v.getPlaque()),
                (Voiture v) -> System.out.println("Je finalise la voiture "+v.getPlaque()));

//        for (ActionVoiture actionVoiture : evenementsVoiture) {
//            actionVoiture.action(voiture);
//        }

        for (ActionVoiture actionVoiture : evenementsVoiture2) {
            actionVoiture.action(voiture);
        }



//      evenementsVoiture.forEach(actionVoiture -> actionVoiture.action(voiture));


    }

}
