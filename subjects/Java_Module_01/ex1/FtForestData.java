package exercise;

/**
 * Main application to register and display tree data.
 */
public class FtForestData {
  /**
   * Main entry point for the registry simulation.
   *
   * @param args Command-line arguments (not used in this exercise).
   */
  public static void main(String[] args) {
    Tree pine = new Tree("Pine", 50, 100);
    Tree oak = new Tree("Oak", 200, 365);
    Tree cedar = new Tree("Cedar", 150, 500);

    System.out.println("=== Forest Tree Registry ===");
    System.out.println(pine);
    System.out.println(oak);
    System.out.println(cedar);
  }
}
