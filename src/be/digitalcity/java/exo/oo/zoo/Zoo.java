package be.digitalcity.java.exo.oo.zoo;

import java.util.HashSet;
import java.util.Set;

public class Zoo {
  String nom;
  Set<Enclos> enclosSet;

  public Zoo(String nom){
    this.nom = nom;
    enclosSet = new HashSet<>();
  }

  public boolean ajouterEnclos(Enclos enclos){
    enclosSet.add(enclos);
    return true;
  }

  public boolean deplacerAnimaux(Enclos enclosDepart, Enclos enclosArrivee){
    if(enclosDepart.type == enclosArrivee.type && enclosDepart.animaux.size()+enclosArrivee.animaux.size() <= enclosArrivee.capacite) {
      enclosArrivee.animaux.addAll(enclosDepart.animaux);
      enclosDepart.animaux.clear();
      return true;
    }
    return false;
  }

}
