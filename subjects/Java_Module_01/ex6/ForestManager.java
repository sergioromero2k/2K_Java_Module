package exercise;

import java.util.ArrayList;
import java.util.List;

/**
 * Manages a collection of Tree objects within a forest.
 * Provides functionality to add trees, nurture them, and generate reports.
 */
public class ForestManager {

  private final List<Tree> trees;
  private static int totalForests = 0;

  /**
   * Constructs a ForestManager instance and initializes the tree collection.
   * Increments the total number of managed forests.
   */
  public ForestManager() {
    trees = new ArrayList<>();
    totalForests++;
  }

  /**
   * Adds a Tree to the forest if it is not null.
   *
   * @param tree The Tree to be added.
   */
  public void addTree(Tree tree) {
    if (tree != null) {
      trees.add(tree);
      System.out.println("Added " + tree.getName() + " to Northern Forest");
    }
  }

  /**
   * Nurtures all trees in the forest by increasing their height.
   *
   * @param cm The number of centimeters each tree should grow.
   */
  public void nurtureForest(int cm) {
    System.out.println("Northern Forest is nurturing all trees...");
    int totalGrowth = 0;

    for (Tree tree : trees) {
      tree.grow(cm);
      totalGrowth += cm;
      System.out.println(tree.getName() + " grew " + cm + "cm");
    }

    System.out.println("Total growth: " + totalGrowth + "cm\n");
  }

  /**
   * Prints a detailed report of the forest and its trees.
   */
  public void printReport() {
    System.out.println("=== Northern Forest Report ===");
    System.out.println("Trees in forest:");

    for (Tree tree : trees) {
      System.out.println("- " + tree.toString());
    }

    System.out.println("Trees added: " + trees.size());
    System.out.println("Total forests managed: " + totalForests);
    System.out.println("Total trees created in system: "
        + Tree.getTotalTrees());
  }

  /**
   * Returns the total number of forests managed.
   *
   * @return Total number of ForestManager instances created.
   */
  public static int getTotalForests() {
    return totalForests;
  }
}

