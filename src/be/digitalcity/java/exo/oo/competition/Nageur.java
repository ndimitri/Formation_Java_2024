package be.digitalcity.java.exo.oo.competition;

import java.time.LocalDate;
import java.util.Random;

public class Nageur extends Sportif{
    Random random = new Random();

    private double coefficientNage;

    public Nageur(String nom, String prenom, LocalDate dateNaissance, double coefficientNage) {
        super(nom, prenom, dateNaissance);
        this.coefficientNage = coefficientNage;
    }

    public double getCoefficientNage() {
        return coefficientNage;
    }

    public void setCoefficientNage(double coefficientNage) {
        this.coefficientNage = coefficientNage;
    }

    @Override
    public double performer(){
        int randomNumber = random.nextInt(1,4);
        return this.coefficientNage * randomNumber;
    }
}
