package be.digitalcity.java.exo.interfaceFonctionnelle.carwash;

public class Main {
    public static void main(String[] args) {

        Carwash carwash = new Carwash();

        Voiture voiture = new Voiture("113-BGH");

        carwash.traiter(voiture);


    }
}
