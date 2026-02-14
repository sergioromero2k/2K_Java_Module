package exercise;

import java.util.Scanner;

/**
 * Calculates the planting area from user input.
 */
public class FtPlantingArea {
  /**
   * Reads length and width from standard input and prints the total planting area.
   */
  public static void ftPlantingArea() {
    Scanner sc;
    sc = new Scanner(System.in);

    // Ask for the selection length (meters).
    System.out.print("Enter length: ");
    int length = Integer.parseInt(sc.nextLine());

    // Ask for the section width (meters).
    System.out.print("Enter width: ");
    int width = Integer.parseInt(sc.nextLine());

    // Compute and print the area.
    System.out.print("Total planting area: ");
    System.out.println(width * length);

    sc.close();
  }

  /**
   * Program entry point.
   *
   * @param args command-line arguments (not used).
   */
  public static void main(String[] args) {
    ftPlantingArea();
  }
}

