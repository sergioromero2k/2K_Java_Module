package exercise;

import java.util.ArrayList;
import java.util.List;

public class ForestManager {

  private final List<Tree> trees;
  private static int totalForests = 0;

  public ForestManager() {
    trees = new ArrayList<>();
    totalForests++;
  }

  public void addTree(Tree tree) {
    if (tree != null) {
      trees.add(tree);
      System.out.println("Added " + tree.getName() + " to Northern Forest");
    }
  }

  public void nurtureForest(int cm) {
    System.out.println("Northern Forest is nurturing all trees...");;
    int totalGrowth = 0;

    for (Tree tree: trees) {
      tree.grow(cm);;
      totalGrowth += cm;
      System.out.println(tree.getName() + " grew " + cm + "cm");
    }

    System.out.println("Total growth: " + totalGrowth + "cm");


  }
}
