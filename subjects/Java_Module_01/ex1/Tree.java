package exercise;

/**
 * Represents a tree in the forest management system.
 */
public class Tree {
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
    this.name = name;
    this.height = height;
    this.age = age;
  }

  /**
   * This answers the "Extra Requirement" about what happens when printing an object.
   *
   * @return Returns a string representation of the tree
   */
  @Override
  public String toString() {
    return this.name + ": " + this.height + "cm, " + this.age + " days old";
  }
}
