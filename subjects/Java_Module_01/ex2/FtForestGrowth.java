package exercise;

/**
 * Main class to simulate and display forest growth.
 */
public class FtForestGrowth {
  /**
   * Entry point of the simulation.
   *
   * @param args No command-line used.
   */
  public static void main(String[] args) {
    // Display that initial forest status.
    Tree pine = new Tree("Pine", 50, 100);
    int n = 7;
    int initialHeight = pine.height;
    for (int i = 1; i <= n; i++) {
      if (i == 1 || i == n) {
        System.out.println("=== Day " + i + " ===");
        System.out.println(pine);
      }
      if (i < n) {
        pine.age();
        pine.grow();
      }
    }
    // Calculate and display weekly growth total.
    int growth = pine.height - initialHeight;
    System.out.println("Growth this week: +" + growth + "cm");
  }
}

