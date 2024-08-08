package be.digitalcity.java.exo.oo.banque;

import be.digitalcity.java.exo.oo.Personne;

public class Courant extends Compte{

    private double ligneDeCredit;


    public Courant(String numero, Personne titulaire) {
        this(numero, 0, titulaire);
    }

    public Courant(String numero, double ligneDeCredit, Personne titulaire) {
        super(numero, titulaire);
        setLigneDeCredit(ligneDeCredit);
    }


    public double getLigneDeCredit() {
        return ligneDeCredit;
    }

    public void setLigneDeCredit(double ligneDeCredit) {
        if(ligneDeCredit < 0){
            throw new IllegalArgumentException("Ligne de crédit négatif");
        }
        this.ligneDeCredit = ligneDeCredit;
    }

    @Override
    public void retrait(double montant) {
        if((super.getSolde() - montant) < (0-this.ligneDeCredit)){
            //Exception
            throw new SoldeInsuffisantException();
        }
        if(super.getSolde() < 0){
            notifyPassageEnNegatif();
        }
        super.retrait(montant);
    }

    @Override
    protected double calculInteret() {
        if(this.getSolde() > 0){
            return (this.getSolde()*3)/100;
        }
        return (this.getSolde()*9.75)/100;
    }

}
