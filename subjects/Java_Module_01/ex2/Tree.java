package exercise;

/**
 * Represents a tree with growth behavior.
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
   * Increments tree age by 1 day.
   */
  public void grow() {
    this.height += 1;
  }

  /**
   * Increments tree height by 1 cm.
   */
  public void age() {
    this.age += 1;
  }

  @Override
  public String toString() {
    return this.name + ": " + this.height + "cm, " + this.age + " days old";
  }

}

