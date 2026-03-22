package exercise;

/**
 * Analysis terrain data from a array of 10 altitude readings.
 */
public class TerrainScanner {
  /**
   * Entry point of the application.
   *
   * @param args Command line arguments (not used).
   */
  public static void main(String[] args) {
    int[] readings = {0, 5, 2, 8, 10, 1, 0, 4, 3, 2};

    System.out.println("=== TERRAIN SCANNER ===");
    showArray(readings, "Raw Data: ");

    int maxNum = readings[0];
    int minNum = readings[0];
    double sum = 0;
    for (int i = 0; i < readings.length; i++) {
      // Check for the highest point
      if (maxNum < readings[i]) {
        maxNum = readings[i];
      }
      // Check for the lowest point
      if (minNum > readings[i]) {
        minNum = readings[i];
      }
      sum += readings[i];
    }
    System.out.println("\nAnalysis:");
    System.out.println("- Highest Peak: " + maxNum);
    System.out.println("- Lowest Valley: " + minNum);
    System.out.println("- Average Altitude: " + (sum / readings.length));

    System.out.println("\n[System] Reversing terrain data for landing...");

    int temp;
    int i = 0;
    while (i < readings.length / 2) {
      temp = readings[i];
      readings[i] = readings[readings.length - i - 1];
      readings[readings.length - i - 1] = temp;
      i++;
    }
    showArray(readings, "New Scan: ");
  }

  /**
   * Helper method to print the array in a formatted way.
   *
   * @param arr The terrain array to display.
   * @param text The prefix message.
   */
  public static void showArray(int[] arr, String text) {
    System.out.print(text + "[");
    for (int i = 0; i < arr.length; i++) {
      System.out.print(arr[i]);
      if (i < arr.length - 1) {
        System.out.print(", ");
      }
    }
    System.out.println("]");
  }
}
