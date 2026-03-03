package exercise;

/**
 * Diagnostic tool for Space Station error handling.
 */
public class FtSpaceStationErrors {
  /**
   * Runs diagnostic tests for common Java exceptions.
   *
   * @param args Command Line arguments.
   */
  public static void main(String[] args) {
    System.out.println("=== Station Diagnostic Run ===");
    try {
      System.out.println("1. Testing Telemetry...");
      String text = "Hola";
      int num = Integer.parseInt(text);
    } catch (NumberFormatException e) {
      System.out.println("   Caught: NumberFormatException - Data packet corrupted.");
    }
    try {
      System.out.println("2. Testing Navigation...");
      int result = 10 / 0;
    } catch (ArithmeticException e) {
      System.out.println("   Caught: ArithmeticException - Trajectory division by zero.");
    }
    try {
      System.out.println("3. Testing Module Access...");
      int[] array = {1, 2, 3};
      System.out.println(array[99]);
    } catch (ArrayIndexOutOfBoundsException e) {
      System.out.println("   Caught: ArrayIndexOutOfBoundsException - Module does not exist.");
    }
    System.out.println("\nDiagnostic complete. System Status: STABLE (Errors handled).");
  }
}
