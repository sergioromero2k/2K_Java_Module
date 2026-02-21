package exercise;

import java.util.Scanner;

/**
 * Entry point for the Forests Management System.
 * This class displays initial tree data provided via command-line arguments.
 */
public class FtForestIntro {
  /**
   * Main method that prints tree specifications.
   *
   * @param args Array of string: [0] species. [1] height, [2] age.
   */
  public static void main(String[] args) {
    if (args.length == 3) {
      // Check if the required 3 parameters. (Tree, Height, Age) are provided.
      System.out.println("=== Welcome to the Forest Management System ===");
      System.out.println("Tree: " + args[0]);
      System.out.println("Height: " + args[1] + "cm");
      System.out.println("Age: " + args[2] + " days");
      System.out.println("\n=== End of Program ===");
    } else {
      System.out.println("Usage: java FtForestIntro <Type> <Height> <Age>");
    }
  }
}
