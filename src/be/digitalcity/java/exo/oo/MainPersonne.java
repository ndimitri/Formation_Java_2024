package be.digitalcity.java.exo.oo;

public class MainPersonne {
    public static void main(String[] args) {

        Personne personne1 = new Personne();
        Personne personne2 = new Personne();

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


        personne1.nom = "Delarue";
        personne1.prenom = "Gérard";

        personne2.nom = "Doe";
        personne2.prenom = "Jhon";

        personne1.saluer(personne2);
        personne2.saluer(personne1);


    }
}
