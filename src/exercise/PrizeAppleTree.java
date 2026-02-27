package exercise;

/**
 * Represents a Prize Apple Tree, a specialized type of FruitTree.
 * This class adds quality, color, and state attributes.
 */
public class PrizeAppleTree extends FruitTree {
  private final String quality;
  private final String color;
  private final String state;

  /**
   * Constructs a PrizeAppleTree object.
   *
   * @param name Tree name.
   * @param height Tree height in centimeters.
   * @param age Tree age in days.
   * @param typeFruit typeFruit Type of fruit.
   * @param harvestStatus Harvest status.
   * @param description Harvest description.
   * @param quality Apple quality.
   * @param color Apple color.
   * @param state Apple state.
   */
  public PrizeAppleTree(String name, int height, int age,
                        String typeFruit, String harvestStatus, String description,
                        String quality, String color, String state
  ) {
    super(name, height, age, typeFruit, harvestStatus, description);
    this.quality = quality;
    this.color = color;
    this.state = state;
  }

  public String getQuality() {
    return this.quality;
  }

  public String getColor() {
    return this.color;
  }

  public String getState() {
    return this.state;
  }

  @Override
  public String toString() {
    return super.toString() + " ("
        + quality + ", " + color + ", " + state + ")";
  }
}
