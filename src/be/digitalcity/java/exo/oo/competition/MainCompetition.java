package be.digitalcity.java.exo.oo.competition;

import java.time.LocalDate;

public class MainCompetition {
    public static void main(String[] args) {

        Competition<Nageur> comp1 = new Competition(2, 4);
        Competition<Coureur> comp2 = new Competition(4);

        Coureur c1 = new Coureur("Lucirki", "Marie", LocalDate.EPOCH, 3.2);
        Coureur c2 = new Coureur("Lulubulu", "Jean", LocalDate.EPOCH, 5);
        Coureur c3 = new Coureur("Soyaka", "Min", LocalDate.EPOCH, 1.3);

        Nageur n1= new Nageur("Greco","Nico", LocalDate.of(2000, 2, 9), 5.9);
        Nageur n2= new Nageur("Lima","Lucie", LocalDate.of(1998, 3, 20), 2.7);
        Nageur n3= new Nageur("Fardesh","Pierre", LocalDate.of(1999, 8, 10), 6);


//        Personne pers1 = new Personne("Nico", "Greco");
//        Personne pers2 = new Personne("Lucie", "Lima");
//        Personne pers3 = new Personne("Gregory", "Vadet");
//        Personne pers4 = new Personne("Nathan", "Kolyoki");
//        Personne pers5 = new Personne("Pierre", "Fardesh");


        //region Exo Competition basique

//        comp1.ajouterParticipant(pers1);
//        System.out.println(comp1.lancer());//False
//
//        comp1.ajouterParticipant(pers2);
//        System.out.println(comp1.lancer());//True
//
//        //On veux ajouter un participant alors que la competition est deja lancée
//        System.out.println(comp1.ajouterParticipant(pers3)); // False
//
//
//        comp2.ajouterParticipant(pers1);
//        comp2.ajouterParticipant(pers2);
//        comp2.ajouterParticipant(pers3);
//        comp2.ajouterParticipant(pers4);
//        //On veux rajouter un participant alors qu'il n'y a plus de place dans la competition
//        System.out.println(comp2.ajouterParticipant(pers5)); // False
//
//        comp2.lancer();
        //endregion


        //region test Polymorphisme

        comp1.inscrireParticipant(n1);
        System.out.println(comp1.lancer());
        comp1.inscrireParticipant(n2);
        System.out.println(comp1);


        comp2.inscrireParticipant(c1);
        comp2.inscrireParticipant(c2);
        comp2.inscrireParticipant(c3);
        comp2.lancer();
        System.out.println(comp2);

        c1.getCoefficientCourse();

        //endregion




    }
}
