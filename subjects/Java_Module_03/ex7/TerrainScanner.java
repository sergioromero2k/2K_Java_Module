package ex7;

import java.util.Arrays;

/**
 * Terrain scanner program.
 */
public class TerrainScanner {

  /**
   * Main method.
   *
   * @param args command-line arguments
   */
  public static void main(String[] args) {

    int[] rawData = new int[10];
    rawData[0] = 0;
    rawData[1] = 5;
    rawData[2] = 2;
    rawData[3] = 8;
    rawData[4] = 10;
    rawData[5] = 1;
    rawData[6] = 0;
    rawData[7] = 4;
    rawData[8] = 3;
    rawData[9] = 2;

    System.out.println("=== TERRAIN SCANNER ===");
    System.out.println("Raw Data: " + Arrays.toString(rawData));
    System.out.println();

    int high = rawData[0];
    int low = rawData[0];
    int sum = 0;

    for (int n : rawData) {
      if (high < n) {
        high = n;
      }

      if (n < low) {
        low = n;
      }

      sum += n;
    }

    double average = (double) sum / rawData.length;

    System.out.println("Analysis:");
    System.out.println("Highest Peak: " + high);
    System.out.println("Lowest Valley: " + low);
    System.out.println("Average Altitude: " + average);
    System.out.println();

    System.out.println("[System] Reversing terrain data for landing...");

    for (int i = 0; i < rawData.length / 2; i++) {
      int temp = rawData[i];
      rawData[i] = rawData[rawData.length - 1 - i];
      rawData[rawData.length - 1 - i] = temp;
    }

    System.out.println("New Scan: " + Arrays.toString(rawData));
  }
}