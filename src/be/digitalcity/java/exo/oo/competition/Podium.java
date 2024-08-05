package be.digitalcity.java.exo.oo.competition;

public class Podium<C extends Competiteur> {

  private C or, argent, bronze;

  public C getOr() {
    return or;
  }

  public void setOr(C or) {
    this.or = or;
  }

  public C getArgent() {
    return argent;
  }

  public void setArgent(C argent) {
    this.argent = argent;
  }

  public C getBronze() {
    return bronze;
  }

  public void setBronze(C bronze) {
    this.bronze = bronze;
  }

  @Override
  public String toString() {
    return "Podium :" +
        "\nOr : " + or +
        "\nArgent : " + argent +
        "\nBronze : " + bronze;
  }
}
