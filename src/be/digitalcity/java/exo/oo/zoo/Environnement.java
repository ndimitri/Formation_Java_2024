package be.digitalcity.java.exo.oo.zoo;

public enum Environnement {
  SAVANE("Savane"),
  AQUARIUM("Aquarium"),
  DESERT("Désert"),
  FORET("Forêt"),
  JUNGLE("Jungle"),
  MONTAGNE("Montagne");

  private final String valeur;

  Environnement(String valeur){
    this.valeur=valeur;
  }

  public String getValeur(){
    return this.valeur;
  }



}
