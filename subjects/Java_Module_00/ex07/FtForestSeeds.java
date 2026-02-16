package exercise;

import java.util.Scanner;

/**
 * Manages the inventory of forest seeds with unit validation.
 */

public class FtForestSeeds {

  /**
   * Validates seed units and prints a formatted inventory message.
   *
   * @param type The species of the tree.
   * @param qty The amount of seeds.
   * @param unit The measurement unit (kilograms, seeds, or bags).
   */
  public static void ftForestSeeds(String type, int qty, String unit) {
    // Formatting the type to: First letter Uppercase, rest Lowercase
    String formattedType = type.substring(0, 1).toUpperCase()
        + type.substring(1).toLowerCase();
    Scanner scanner = new Scanner(System.in);
    switch (unit) {
      case "kilograms":
        System.out.println(formattedType + ": " + qty + " kilograms in stock.");
        break;
      case "seeds":
        System.out.println(formattedType + ": " + qty + " seeds ready for planting.");
        break;
      case "bags":
        System.out.println(formattedType + ": " + qty + " bags of seeds available.");
        break;
      default:
        System.out.println("Unknown unit.");
    }
  }

  /**
   * Main method to demonstrate the functionally.
   *
   * @param args Command Line arguments.
   */
  public static void main(String[] args) {
    ftForestSeeds("pine", 50, "kilograms");
    ftForestSeeds("OAK", 200, "seeds");
    ftForestSeeds("fir", 10, "bags");
    ftForestSeeds("cedar", 5, "boxes");
  }
}
