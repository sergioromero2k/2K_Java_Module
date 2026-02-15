package exercise;

import java.util.Scanner;

/**
 * Reads the number of sprouts from two plots and returns the total.
 * Typical exercise constraints:
 * - Scanner for reading
 * - System.out.print/println for displaying
 */

public class FtSproutCount {
  /**
   * Reads 2 plot values and returns the total sprouts.
   *
   * @return total sprouts from the two plots.
   */
  public static int ftSproutCount() {
    Scanner scanner = new Scanner(System.in);
    int sum;

    sum = 0;
    for (int i = 1; i <= 3; i++) {
      System.out.print("Plot " + i + " sprouts: ");
      // Reads one integer per plot.
      sum += scanner.nextInt();
    }
    return sum;
  }

  /**
   * Program entry point.
   *
   * @param args command-line arguments (not used).
   */
  public static void main(String[] args) {
    // Fix: store and print the returned result.
    int total = ftSproutCount();
    System.out.println("Total sprouts: " + total);
  }
}

