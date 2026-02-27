package exercise;

/**
 * Base class representing a Tree.
 * Contains common attributes and validation logic.
 */
public class Tree {
  private final String name;
  private int height;
  private int age;

  /**
   * Constructor initializes tree attributes.
   *
   * @param name Tree name.
   * @param height Tree height in cm.
   * @param age Tree age in days.
   */
  public Tree(String name, int height, int age) {
    this.name = name;
    if (height < 0) {
      System.out.println("Security: Negative height rejected.");
    } else {
      this.height = height;
    }
    if (age < 0) {
      System.out.println("Security: Negative age rejected.");
    } else {
      this.age = age;
    }
  }

  /**
   * Get tree same.
   *
   * @return Name.
   */
  public String getName() {
    return this.name;
  }

  /**
   * Get tree height.
   *
   * @return Height.
   */
  public int getHeight() {
    return this.height;
  }

  /**
   * Get tree age.
   *
   * @return Age.
   */
  public int getAge() {
    return this.age;
  }

  /**
   * Update tree height with validation.
   *
   * @param height New height value.
   */
  public void setHeight(int height) {
    if (height < 0) {
      System.out.println("Invalid operation attempted: " + height + "cm [REJECTED]");
      System.out.println("Security: Negative height rejected");
    } else {
      this.height = height;
    }
  }

  /**
   * Update tree age with validation.
   *
   * @param age New age value.
   */
  public void setAge(int age) {
    if (age < 0) {
      System.out.println("Invalid operation attempted: " + age + "days [REJECTED]");
      System.out.println("Security: Negative age rejected");
    } else {
      this.age = age;
    }
  }

  /**
   * String representation of Tree.
   *
   * @return String.
   */
  @Override
  public String toString() {
    return name + " (" + height + "cm, " + age + "days)";
  }

  public void grow(int cm) {
    if (cm > 0) {
      this.height += cm;
    } else {
      System.out.println("Invalid growth value: " + cm);
    }
  }
}

