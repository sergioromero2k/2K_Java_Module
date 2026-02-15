package exercise;

import java.util.Scanner;

/**
 * Reads rainfall and prints a drought alert message.
 */
public class FtDroughtAlert {
  /**
   * Reads rainfall in liters and prints whether irrigation is needed.
   * If rainfall is less than 15 liters, irrigation is needed.
   */
  public static void ftDroughtAlert() {
    Scanner scanner = new Scanner(System.in);
    System.out.print("Rainfall (liters): ");
    int liters = scanner.nextInt();
    // Conditional output based on rainfall level.
    if (liters < 15) {
      System.out.print("Activate irrigation system!");
    } else {
      System.out.print("Moisture levels optimal");
    }
    scanner.close();
  }

  /**
   * Program entry point.
   */
  static void main() {
    ftDroughtAlert();
  }
}
