package ex3;

/**
 * Demonstrates a reactor that may fail while closing.
 */
public class Demo {

  /**
   * Runs the reactor example.
   *
   * @param args command-line arguments
   */
  public static void main(String[] args) {
    try (StubbornReactor reactor = new StubbornReactor(150)) {
      System.out.println("Running gamma experiment...");
    } catch (ReactorMalfunctionException e) {
      System.out.println(e.getMessage());
    }
  }
}