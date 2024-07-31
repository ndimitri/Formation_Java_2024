package be.digitalcity.java.exo.oo.banque;

import be.digitalcity.java.exo.oo.Personne;

public class Compte {
    private final String numero;
    private double solde;
    private Personne titulaire;

    public Compte(String numero, Personne titulaire) {
        this.numero = numero;
        this.solde = 0;
        this.titulaire = titulaire;

    }

    public String getNumero() {
        return numero;
    }

    public double getSolde() {
        return solde;
    }

    private void setSolde(double solde) {
        this.solde = solde;
    }

    public Personne getTitulaire() {
        return titulaire;
    }

    public void setTitulaire(Personne titulaire) {
        this.titulaire = titulaire;
    }

    public void retrait(double montant){
        if(montant > 0){
            this.solde = this.solde - montant;
        }
    }

    public void depot(double montant){
        if(montant > 0){
            this.solde += montant;
        }

    }

    @Override
    public String toString() {
        return this.getTitulaire().getNom() +" "+ this.getTitulaire().getPrenom() +" "+ this.getNumero() +"(" + this.getClass().getSimpleName() + ") :  " + this.getSolde() + " euros";

    }


}
