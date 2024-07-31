package be.digitalcity.java.exo.oo.banque;


import be.digitalcity.java.exo.oo.Personne;

import java.time.LocalDateTime;

public class Epargne extends Compte{
    private LocalDateTime dateDernierRetrait;

    public Epargne(String numero, Personne titulaire){
        super(numero, titulaire);
        this.dateDernierRetrait = LocalDateTime.now();
    }

    public LocalDateTime getDateDernierRetrait() {
        return dateDernierRetrait;
    }

    @Override
    public void retrait(double montant) {
        if(this.getSolde() - montant>=0){
            super.retrait(montant);
            this.dateDernierRetrait = LocalDateTime.now();
        }
    }


}
