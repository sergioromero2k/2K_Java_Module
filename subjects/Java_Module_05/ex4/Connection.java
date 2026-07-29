package ex4;

/**
 * Represents a manual connection to Banner's laboratory.
 */
public class Connection {

  /**
   * Opens the connection.
   */
  public void connect() {
    System.out.println("Connecting to Banner's lab...");
  }

  /**
   * Simulates an unstable connection.
   */
  public void operate() {
    throw new RuntimeException("Connection unstable!");
  }

  /**
   * Closes the connection manually.
   */
  public void close() {
    System.out.println("[finally] Closing connection manually.");
  }
}