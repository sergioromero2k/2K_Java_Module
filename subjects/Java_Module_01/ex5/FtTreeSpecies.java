package exercise;

/**
 * Main demonstrates inheritance.
 */
public class FtTreeSpecies {
  /**
   * Program entry point.
   *
   * @param args Non-Command line used.
   */
  public static void main(String[] args) {
    System.out.println("=== Forest Tree Types ===");
    Conifer conifer = new Conifer("Pine", 50, 100, "Long");
    System.out.println(conifer);
    conifer.dropCones();

    System.out.println();

    FruitTree fruitTree = new FruitTree("Apple", 180, 400, "Red Apple");
    System.out.println(fruitTree);
    // Testing parsing : ( (FruitTree) fruitTree).harvest();
    fruitTree.harvest();
  }
}

