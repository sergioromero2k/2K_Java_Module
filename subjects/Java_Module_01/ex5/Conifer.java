package exercise;

/**
 * Conifer tree specialization.
 */
public class Conifer extends Tree {
  private final String needleType;

  /**
   * Constructor for Conifer.
   *
   * @param name Conifer name.
   * @param height Conifer height.
   * @param age Conifer age.
   * @param needleType Conifer needleType.
   */
  public Conifer(String name, int height, int age, String needleType) {
    super(name, height, age);
    this.needleType = needleType;
  }

  /**
   * Simulate cone dropping behavior.
   */
  public void dropCones() {
    System.out.println(getName() + " is dropping cones on the forest floor.");
  }

  /**
   * Get needle type.
   *
   * @return Conifer needleType.
   */
  public String getNeedleType() {
    return this.needleType;
  }

  /**
   * Custom string representation.
   *
   * @return String info.
   */
  @Override
  public String toString() {
    return (
        getName() + " (Conifer): "
            + getHeight() + "cm, " + getAge() + " days, Needle type: " + needleType);
  }
}
