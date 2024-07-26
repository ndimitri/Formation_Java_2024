package be.digitalcity.java.exo.oo;

public class Personne {
    String nom;
    String prenom;

    public void saluer(Personne personneASaluer){
        System.out.println("Bonjour " + personneASaluer.prenom + " " + personneASaluer.nom + ", je me nomme "+ this.prenom + " " + this.nom+".");

//        System.out.printf("Bonjour %s %s , je m'appelle %s %s", personneASaluer.prenom, personneASaluer.nom, this.nom, this.prenom);
    }


}
