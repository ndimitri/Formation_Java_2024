package be.digitalcity.java.exo.oo.rpg;

import java.util.Random;

public class De {
  private final int min;
  private final int max;
  private final Random random;

  public De(int min, int max) {
    this.min = min;
    this.max = max;
    this.random = new Random();
  }

  public int lancer() {
    return random.nextInt(max - min + 1) + min;
  }
}
