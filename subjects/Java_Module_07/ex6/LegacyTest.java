package ex6;

import ex3.ShieldBearer;
import java.util.ArrayList;
import java.util.List;

/**
 * Tests polymorphism using different shield bearers.
 */
public class LegacyTest {

  /**
   * Runs the polymorphism test.
   *
   * @param args command-line arguments
   */
  public static void main(String[] args) {
    List<ShieldBearer> bearers = new ArrayList<>();

    bearers.add(new SteveRogers());
    bearers.add(new SamWilson());

    for (ShieldBearer s : bearers) {
      s.raiseShield();
      System.out.println(s.motto());
    }
  }
}
