package be.digitalcity.java.exo.oo.banque;

import be.digitalcity.java.exo.oo.Personne;

public class Courant {
    private final String numero;

    private double solde;
    private double ligneDeCredit;
    private Personne titulaire;

    public Courant(String numero, Personne titulaire) {
        this(numero,0.0,titulaire);
    }

    public Courant(String numero, double ligneDeCredit, Personne titulaire) {
        this.numero = numero;
        setLigneDeCredit(ligneDeCredit);
        this.titulaire = titulaire;
        this.solde = 0;
    }

    public String getNumero() {
        return numero;
    }

//    public void setNumero(String numero) {
//        this.numero = numero;
//    }

    public Personne getTitulaire() {
        return titulaire;
    }

    public void setTitulaire(Personne titulaire) {
        this.titulaire = titulaire;
    }

    public double getLigneDeCredit() {
        return ligneDeCredit;
    }

    public void setLigneDeCredit(double ligneDeCredit) {
        if(ligneDeCredit >= 0){
            this.ligneDeCredit = ligneDeCredit;
        }
    }

    public double getSolde() {
        return solde;
    }

    public void retrait(double montant){
        if(montant > 0){
            if((this.solde - montant) >= (0-this.ligneDeCredit)){ // montant <= solde + ligneDeCredit
                this.solde = this.solde - montant;
            }
        }
    }

    public void depot(double montant){
        if(montant > 0){
            this.solde += montant;
        }

    }

    @Override
    public String toString() {
        return this.getTitulaire().getNom() +" "+ this.getTitulaire().getPrenom() +" "+ this.getNumero() + " :  " + this.getSolde() + " euros";

    }
}
