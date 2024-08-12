package be.digitalcity.java.exo.animalerie;

import java.lang.reflect.Type;

public class Chat extends Animal{
    private String caractere;
    private boolean griffesCoupees;
    private TypePoil typePoil;


    public Chat(String nom, double poids, double taille, String sexe, int age) {
        super(nom, poids, taille, sexe, age);
    }

    @Override
    public void crier() {
        System.out.println("Miaou");
    }
}
