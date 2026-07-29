package ex1;

/**
 * Demonstrates try-with-resources with an exception.
 */
public class Demo {

  /**
   * Runs the gamma experiment.
   *
   * @param args command-line arguments
   */
  public static void main(String[] args) {
    try (HulkOutbreak c = new HulkOutbreak()) {
      c.work();
    }
  }
}