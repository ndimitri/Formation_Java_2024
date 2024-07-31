package be.digitalcity.java.exo.oo;

import java.time.LocalDate;

public class MainPersonne {
    public static void main(String[] args) {

        Personne personne1 = new Personne("Delarue", "Marie", LocalDate.of(2000, 5,16));
        Personne personne2 = new Personne("Colarus", "Luc", LocalDate.of(2001, 7,23));

        //region RecordDemo
        record PersonneRecord(String prenom, String nom){

            public void saluer(PersonneRecord personneASaluer){
                System.out.println("Bonjour " + personneASaluer.prenom + " " + personneASaluer.nom + ", je me nomme "+ prenom + " " + nom+".");
            }
        }
        PersonneRecord personneRecord = new PersonneRecord("Luc", "Ilaoui");
        PersonneRecord personneRecord2 = new PersonneRecord("Marie", "Delacroix");
        personneRecord.saluer(personneRecord2);
        //endregion


//        personne1.nom = "Delarue";
//        personne1.prenom = "Gérard";
//
//        personne2.nom = "Doe";
//        personne2.prenom = "John";

        personne1.saluer(personne2);
        personne2.saluer(personne1);


    }
}
