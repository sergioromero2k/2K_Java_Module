package exercise;

/**
 * Represents a FruitTree, a specialized Tree that contains fruit-related attributes.
 */
public class FruitTree extends Tree {
  private final String typeFruit;
  private final String harvestStatus;
  private final String description;

  /**
   * Constructs a FruitTree object.
   *
   * @param name Tree name.
   * @param height Tree height in centimeters.
   * @param age Tree age in days.
   * @param typeFruit Type of fruit.
   * @param harvestStatus Harvest status.
   * @param description Tree description.
   */
  public FruitTree(
      String name, int height,
      int age, String typeFruit,
      String harvestStatus, String description) {
    super(name, height, age);
    this.typeFruit = typeFruit;
    this.harvestStatus = harvestStatus;
    this.description = description;
  }

  /**
   * Get fruitTree typeFruit.
   *
   * @return typeFruit.
   */
  public String getTypeFruit() {
    return this.typeFruit;
  }

  /**
   * Get fruitTree harvestStatus.
   *
   * @return HarvestStatus.
   */
  public String getHarvestStatus() {
    return this.harvestStatus;
  }

  /**
   * Get fruitTree description.
   *
   * @return Description.
   */
  public String getDescription() {
    return this.description;
  }

  @Override
  public String toString() {
    return getName() + " (" + getHeight() + "cm, " + getAge() + "days) - "
        + description + ", " + typeFruit + ", " + harvestStatus;
  }
}
