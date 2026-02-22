package exercise;

/**
 * Main factory class to instantiate and manage Tree objects.
 */
public class FtTreeFactory {
  /**
   * Application entry point.
   *
   * @param args Command line arguments.
   */
  public static void main(String[] args) {
    // Initialize an array of Tree instances.
    Tree[] forest = {
        new Tree("Pine", 50, 100),
        new Tree("Oak", 200, 365),
        new Tree("Cedar", 150, 500),
        new Tree("Fir", 30, 45),
        new Tree("Willow", 120, 200)
    };
    int i = 0;
    System.out.println("=== Tree Factory Output ===");
    for (Tree t : forest) {
      System.out.println(t);
      i++;
    }
    // Accessing the count directly from the class.
    System.out.println("Total trees created: " + Tree.getTotalCount());
  }
}
