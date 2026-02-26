package exercise;

/**
 * Fruit tree specialization.
 */
public class FruitTree extends Tree {
  private final String fruitType;

  /**
   * Constructor for FruitTree.
   *
   * @param name FruitTree name.
   * @param height FruitTree height.
   * @param age FruitTree age.
   * @param fruitType FruitTree fruitType.
   */
  public FruitTree(String name, int height, int age, String fruitType) {
    super(name, height, age);
    this.fruitType = fruitType;
  }

  /**
   * Simulate harvesting behavior.
   */
  public void harvest() {
    System.out.println("Harvesting " + fruitType + "... Nutritional value: High");
  }

  /**
   * Custom string representation.
   *
   * @return String info.
   */
  @Override
  public String toString() {
    return getName() + "Tree (FruitTree): "
        + getHeight() + "cm, "
        + getAge() + " days, Fruit: " + fruitType;
  }
}
