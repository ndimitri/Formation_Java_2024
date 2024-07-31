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
        if(ligneDeCredit >= 0){
            this.ligneDeCredit = ligneDeCredit;
        }
    }

    @Override
    public void retrait(double montant) {
        if((super.getSolde() - montant) >= (0-this.ligneDeCredit)){
            super.retrait(montant);
        }
    }

}
