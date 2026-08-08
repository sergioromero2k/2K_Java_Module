package ex5;

import ex0.Avenger;

/**
 * Represents Sam Wilson, a pilot and Avenger.
 */
public class SamWilson implements Pilot, Avenger {

  @Override
  public String battleCry() {
    return "On your left!";
  }

  @Override
  public void fly() {
    System.out.println("Sam Wilson is flying with the Falcon wings.");
  }

  /**
   * Runs the Sam Wilson example.
   *
   * @param args command-line arguments
   */
  public static void main(String[] args) {
    SamWilson sam = new SamWilson();
    System.out.println("Sam Wilson says: " + sam.battleCry());
    sam.fly();
  }
}
