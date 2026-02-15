package exercise;

import java.util.Scanner;

/**
 * Logs plant growth day by day until the target is reached.
 */
public class FtGrowthLog {
  /**
   * Iteratively Logs growth for a given number of days.
   */
  public static void ftGrowthLogIterative() {
    Scanner scanner = new Scanner(System.in);
    System.out.print("Target day: ");
    int days = scanner.nextInt();
    for (int i = 1; i <= 3; i++) {
      System.out.println("Day " + i + ": Growing...");
    }
    System.out.println("Target reached!");
    scanner.close();
  }

  /**
   * Recursively logs growth for n days.
   *
   * @param n number of days.
   */
  public static void ftGrowthLogRecursive(int n) {
    ftGrowthLogRecursiveHelper(n, 1);
  }

  /**
   * Helper method for recursion with day counter.
   *
   * @param n remaining days.
   * @param day current day number.
   */
  private static void ftGrowthLogRecursiveHelper(int n, int day) {
    if (n > 0) {
      System.out.println("Day " + day + ": Growing...");
      ftGrowthLogRecursiveHelper(n - 1, day + 1);
    } else {
      System.out.println("Target reached!");
    }
  }

  /**
   * Program entry point.
   */
  static void main() {
    // ftGrowthLogIterative();
    ftGrowthLogRecursive(3);
  }
}
