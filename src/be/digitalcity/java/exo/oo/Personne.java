package be.digitalcity.java.exo.oo;

import java.time.LocalDate;

public class Personne {
    private String nom;
    private String prenom;
    private LocalDate dateNaissance;

    public Personne(String nom, String prenom, LocalDate dateNaissance) {
        this.nom = nom;
        this.prenom = prenom;
        this.dateNaissance = dateNaissance;
    }

    public void saluer(Personne personneASaluer){
        System.out.println("Bonjour " + personneASaluer.prenom + " " + personneASaluer.nom + ", je me nomme "+ this.prenom + " " + this.nom+".");

//        System.out.printf("Bonjour %s %s , je m'appelle %s %s", personneASaluer.prenom, personneASaluer.nom, this.nom, this.prenom);
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public LocalDate getDateNaissance() {
        return dateNaissance;
    }

}
