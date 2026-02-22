package exercise;

/**
 * Represents a tree with mandatory and valid data.
 */
public class Tree {
  // Static counter shared by all instances.
  private static int totalCount = 0;
  String name;
  int height;
  int age;

  /**
   * Constructs a new Tree.
   *
   * @param name The species name.
   * @param height Height in centimeters.
   * @param age Age in days.
   */
  public Tree(String name, int height, int age) {
    // Check if name is null or empty to prevent "empty" objects.
    if (name == null || name.trim().isEmpty()) {
      throw new IllegalArgumentException("Tree name can't be empty.");
    }
    // Validation: Height and Age can't be "empty" (negative value)
    if (age < 0 || height < 0) {
      throw new IllegalArgumentException("Height and age must be positive");
    }
    this.name = name;
    this.height = height;
    this.age = age;

    // Increment global counter every time a tree is born
    totalCount++;

  }

  /**
   * Overloaded constructor for default values.
   *
   * @param name The species name.
   */
  public Tree(String name) {
    this(name, 1, 0);
  }

  public static int getTotalCount() {
    return totalCount;
  }

  @Override
  public String toString() {
    return "Created: " + this.name + " (" + this.height + "cm, " + this.age + " days)";
  }
}
