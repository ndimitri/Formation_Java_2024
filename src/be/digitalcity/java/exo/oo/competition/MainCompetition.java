package be.digitalcity.java.exo.oo.competition;

public class MainCompetition {
    public static void main(String[] args) {

        Competition comp1 = new Competition(2, 4);
        Competition comp2 = new Competition(4);
        Competition comp3 = new Competition();

        Personne pers1 = new Personne("Nico", "Greco");
        Personne pers2 = new Personne("Lucie", "Lima");
        Personne pers3 = new Personne("Gregory", "Vadet");
        Personne pers4 = new Personne("Nathan", "Kolyoki");
        Personne pers5 = new Personne("Pierre", "Fardesh");

        comp1.ajouterParticipant(pers1);
        System.out.println(comp1.lancer());//False

        comp1.ajouterParticipant(pers2);
        System.out.println(comp1.lancer());//True

        //On veux ajouter un participant alors que la competition est deja lancée
        System.out.println(comp1.ajouterParticipant(pers3)); // False


        comp2.ajouterParticipant(pers1);
        comp2.ajouterParticipant(pers2);
        comp2.ajouterParticipant(pers3);
        comp2.ajouterParticipant(pers4);
        //On veux rajouter un participant alors qu'il n'y a plus de place dans la competition
        System.out.println(comp2.ajouterParticipant(pers5)); // False

        comp2.lancer();



    }
}
