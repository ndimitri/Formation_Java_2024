package be.digitalcity.java.exo.animalerie;

import java.time.LocalDate;

public abstract class Animal {
    private String nom;
    private double poids;
    private double taille;
    private Sexe sexe;
    private int age;
    private int ageHumain;
    private LocalDate dateArrivee;

    public Animal(String nom, double poids, double taille, String sexe, int age){
        this.nom = nom;
        this.poids = poids;
        this.taille = taille;
        this.sexe = Sexe.valueOf(sexe);
        this.age = age;
        this.ageHumain = age*7;
        this.dateArrivee = LocalDate.now();
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public double getPoids() {
        return poids;
    }

    public void setPoids(double poids) {
        this.poids = poids;
    }

    public double getTaille() {
        return taille;
    }

    public void setTaille(double taille) {
        this.taille = taille;
    }

    public Sexe getSexe() {
        return sexe;
    }


    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
        setAgeHumain(this.age*7);
    }

    public int getAgeHumain() {
        return ageHumain;
    }

    private void setAgeHumain(int ageHumain) {
        this.ageHumain = ageHumain;
    }

    public LocalDate getDateArrivee() {
        return dateArrivee;
    }

    public abstract void crier();
}
