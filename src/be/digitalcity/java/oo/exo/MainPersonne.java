package be.digitalcity.java.oo.exo;

public class MainPersonne {
    public static void main(String[] args) {

        Personne personne1 = new Personne();
        Personne personne2 = new Personne();

        personne1.nom = "Delarue";
        personne1.prenom = "Gérard";

        personne2.nom = "Doe";
        personne2.prenom = "Jhon";

        personne1.saluer(personne2);
        personne2.saluer(personne1);


    }
}
