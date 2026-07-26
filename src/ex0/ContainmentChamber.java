package ex0;

/**
 * Represents a gamma containment chamber.
 */
public class ContainmentChamber implements AutoCloseable {

  /**
   * Opens the containment chamber.
   */
  public ContainmentChamber() {
    System.out.println("Opening containment chamber...");
  }

  /**
   * Seals the containment chamber.
   */
  @Override
  public void close() {
    System.out.println("Chamber sealed. Gamma levels stable.");
  }
}