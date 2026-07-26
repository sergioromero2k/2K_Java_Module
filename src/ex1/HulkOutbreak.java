package ex1;

/**
 * Simulates a gamma containment chamber that fails during an experiment.
 */
public class HulkOutbreak implements AutoCloseable {

  /**
   * Opens the containment chamber.
   */
  public HulkOutbreak() {
    System.out.println("Opening containment chamber...");
  }

  /**
   * Simulates a gamma overload.
   */
  public void work() {
    System.out.println("ERROR: Gamma overload detected!");
    throw new RuntimeException("Gamma overload detected!");
  }

  /**
   * Seals the containment chamber.
   */
  @Override
  public void close() {
    System.out.println("Chamber sealed. Gamma levels stable.");
  }
}