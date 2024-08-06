package be.digitalcity.java.exo.oo.banque;

import be.digitalcity.java.exo.oo.Personne;

public abstract class Compte implements Banker{
    private final String numero;
    private double solde;
    private Personne titulaire;

    public Compte(String numero, Personne titulaire) {
        this.numero = numero;
        this.solde = 0;
        this.titulaire = titulaire;

    }
    //region GET/SET

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

    //endregion

    public void retrait(double montant){
        if(montant <= 0){
            throw new IllegalArgumentException("Montant du retrait négatif ou égale à 0");
        }
        setSolde(this.solde-montant);
    }

    public void depot(double montant){
        if(montant <= 0){
            throw new IllegalArgumentException("Montant du dépot négatif ou égale à 0");
        }
        setSolde(this.solde+montant);
    }

    protected abstract double calculInteret();

    @Override
    public String toString() {
        return this.getTitulaire().getNom() +" "+ this.getTitulaire().getPrenom() +" "+ this.getNumero() +"(" + this.getClass().getSimpleName() + ") :  " + this.getSolde() + " euros";

    }

    public void appliquerInteret(){
        setSolde( this.solde + this.calculInteret());

    }


}