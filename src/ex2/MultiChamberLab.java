package ex2;

/**
 * Demonstrates the closing order of multiple AutoCloseable resources.
 */
public class MultiChamberLab {

  /**
   * Runs the multiple containment chamber experiment.
   *
   * @param args command-line arguments
   */
  public static void main(String[] args) {

    try (
        ContainmentChamber a = new ContainmentChamber("A");
        ContainmentChamber b = new ContainmentChamber("B")
    ) {
    }
  }
}