package ex4;

/**
 * Demonstrates manual resource management using try-finally.
 */
public class ManualGuardian {

  /**
   * Runs the manual resource management example.
   *
   * @param args command-line arguments
   */
  public static void main(String[] args) {
    Connection resource = null;

    try {
      resource = new Connection();
      resource.connect();
      resource.operate();
    } catch (RuntimeException e) {
      System.out.println("ERROR: " + e.getMessage());
    } finally {
      if (resource != null) {
        resource.close();
      }
    }
  }
}