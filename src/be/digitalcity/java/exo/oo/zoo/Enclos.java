package be.digitalcity.java.exo.oo.zoo;

import java.util.HashSet;
import java.util.Set;

public class Enclos {

  static final int CAPACITE_DEFAULT = 10;

  final String nom;
  final Environnement type;
  final int capacite;
  Set<Animal> animaux;

  public Enclos(String nom, Environnement type, int capacite){
    this.nom = nom;
    this.type = type;
    this.capacite = capacite;
    animaux = new HashSet<Animal>();
  }

  public Enclos(String nom, Environnement type){
    this(nom, type, CAPACITE_DEFAULT);
  }

  public boolean ajouterAnimal(Animal animal){
    if(animaux.size() < this.capacite && animal.type == this.type){
        animaux.add(animal);
        return true;
    }
    return false;
  }

  public boolean deplacerAnimal(Animal animal, Enclos nouvelEnclos){
    if(nouvelEnclos.ajouterAnimal(animal)){
      this.animaux.remove(animal);
      return true;
    }
    return false;

  }


}
