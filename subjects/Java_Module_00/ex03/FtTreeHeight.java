package exercise;

import java.util.Scanner;

/**
 * Reads a tree height and prints if it is ready for transplanting.
 */

public class FtTreeHeight {
  /**
   * Reads the tree height in centimeters and prints the transplanting status.
   * If height is greater than 100 cm, the tree is ready.
   */
  public static void ftTreeHeight() {
    Scanner scanner = new Scanner(System.in);

    // Use print() to keep input on the same line.
    System.out.print("Enter tree height (cm): ");
    int height = scanner.nextInt();
    if (height > 100) {
      System.out.print("Ready for transplanting!");
    } else {
      System.out.print("Not ready for transplanting!");
    }
    scanner.close();
  }

  /**
   * Program entry point.
   */
  static void main() {
    ftTreeHeight();
  }
}
