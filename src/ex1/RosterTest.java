package ex1;

import ex0.Avenger;
import ex0.CaptainAmerica;
import java.util.ArrayList;
import java.util.List;

/**
 * Tests the Avengers roster.
 */
public class RosterTest {

  /**
   * Runs the roster test.
   *
   * @param args command-line arguments
   */
  public static void main(String[] args) {
    List<Avenger> avenger = new ArrayList<>();
    avenger.add(new CaptainAmerica());
    avenger.add(new Falcon());

    for (Avenger a : avenger) {
      System.out.println(a.battleCry());
    }
  }
}
