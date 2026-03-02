package exercise;

/**
 * Represents a visibility map for managing tree species and capacity limits.
 * This class demonstrates the use of constants, private fields, and accessors.
 */
public class SyntaxMap {
  public static int MAX_TREES = 100;
  private final String speciesName = "Oak";

  public String getSpeciesInfo() {
    return "Maximum trees allowed: " + MAX_TREES + "\n"
        + "Current species: " + this.speciesName;
  }
  /**
   * Retrieves a formatted string containing the maximum tree capacity
   * and the name of the current species.
   * * @return A string summary of the map's status.
   */

  public static void main() {
    SyntaxMap map = new SyntaxMap();
    System.out.println(map.getSpeciesInfo());
  }
}
