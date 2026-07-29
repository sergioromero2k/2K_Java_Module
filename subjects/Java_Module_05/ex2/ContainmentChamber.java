package ex2;

/**
 * Represents a containment chamber resource.
 */
public class ContainmentChamber implements AutoCloseable {

  private String name;

  /**
   * Creates a containment chamber with the given name.
   *
   * @param name chamber identifier
   */
  public ContainmentChamber(String name) {
    this.name = name;
    System.out.println("Opening Chamber " + name + "...");
  }

  /**
   * Closes the containment chamber.
   */
  @Override
  public void close() {
    System.out.println("Closing Chamber " + name + "...");
  }
}