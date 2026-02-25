package exercise;

/**
 * Secure Tree class represents a tree with protected attributes.
 * Negative values are rejected a maintain data security.
 */
public class SecureTree {
  private final String name;
  private int height;
  private int age;

  /**
   * Creates a SecureTree object with validation.
   *
   * @param name Tree name.
   * @param height Tree height (must be non-negative)
   * @param age Tree age (must be non-negative)
   */
  public SecureTree(String name, int height, int age) {
    this.name = name;
    if (height < 0) {
      System.out.println("Height can't be negative");
    } else {
      this.height = height;
    }

    if (age < 0) {
      System.out.println("Age can't be negative");
    } else {
      this.age = age;
    }
  }

  public String getName() {
    return this.name;
  }

  public int getHeight() {
    return height;
  }

  public int getAge() {
    return this.age;
  }

  /**
   * Update tree height  with validation.
   *
   * @param height New height value (non-negative)
   */
  public void setHeight(int height) {
    if (height < 0) {
      System.out.println("Invalid operation attempted: height " + height + "cm [REJECTED]");
      System.out.println("Security: Negative height rejected");
      return;
    }
    this.height = height;
    System.out.println("Height updated: " + height + "cm [OK]");
  }

  /**
   * Updates tree age with validation.
   *
   * @param age New age value (non-negative).
   */
  public void setAge(int age) {
    if (age < 0) {
      System.out.println("Invalid operation attempted: age " + age + " days [REJECTED]");
      System.out.println("Security: Negative age rejected");
      return;
    }
    this.age = age;
    System.out.println("Age updated: " + age + " days [OK]");
  }

  @Override
  public String toString() {
    return "Tree created: " + this.name;
  }
}