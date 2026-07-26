package ex0;

/**
 * Demonstrates the use of a containment chamber.
 */
public class Demo {

  /**
   * Runs the containment chamber example.
   *
   * @param args command-line arguments
   */
  public static void main(String[] args) {
    try (ContainmentChamber c = new ContainmentChamber()) {
      System.out.println("Running gamma experiment...");
    }
  }
}