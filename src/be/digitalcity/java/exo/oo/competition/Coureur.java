package be.digitalcity.java.exo.oo.competition;

import java.time.LocalDate;
import java.util.Random;

public class Coureur extends Sportif{
    Random random = new Random();

    private double coefficientCourse;

    public Coureur(String nom, String prenom, LocalDate dateNaissance, double coefficientCourse) {
        super(nom, prenom, dateNaissance);
        this.coefficientCourse = coefficientCourse;
    }

    public double getCoefficientCourse() {
        return coefficientCourse;
    }

    public void setCoefficientCourse(double coefficientCourse) {
        this.coefficientCourse = coefficientCourse;
    }

    @Override
    public double performer(){
        int randomNumber = random.nextInt(2,6);
        return this.coefficientCourse * randomNumber;

    }


}
