package exercise;

/**
 * Entry point for the Forest Management System demo.
 * Demonstrates the creation and management of trees within a forest.
 */
public class ForestAnalytics {
  /**
   * Main method that runs the forest management demonstration.
   *
   * @param args Command-line arguments (not used).
   */
  public static void main(String[] args) {
    System.out.println("=== Forest Management System Demo ===");

    ForestManager manager = new ForestManager();

    Tree pine = new Tree("Pine", 50, 100);
    PrizeAppleTree apple = new PrizeAppleTree(
        "Apple Tree", 180, 200,
        "Apple", "Harvest ready", "Premium fruit tree",
        "A+", "Red", "Ready");

    manager.addTree(pine);
    manager.addTree(apple);
    manager.nurtureForest(2);
    manager.printReport();
  }
}
