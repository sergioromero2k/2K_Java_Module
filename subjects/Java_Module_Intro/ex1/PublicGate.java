package exercise;

/**
 * Demonstrating public access.
 */
public class PublicGate {
  /**
   *The message of the gate.
   */
  public String message = "Welcome";

  /**
   * Main method to modify the public variable directly.
   */
  public static void main() {
    PublicGate gate = new PublicGate();
    gate.message = "The gate is open: Welcome!";
    System.out.println(gate.message);
  }
}
