package exercise;

import java.util.Scanner;

/**
 * Provides functionality to manage and display nursery information.
 */
public class FtNurserySummary {

  /**
   * Prompts the user for nursery details and prints a formatted summary.
   */
  public static void ftNurserySummary() {
    Scanner scanner = new Scanner(System.in);

    System.out.print("Enter nursery name: ");
    String name = scanner.nextLine();
    System.out.print("Enter main species: ");
    String species = scanner.nextLine();

    System.out.print("Nursery: " + name + " | Species: " + species + " | Status: Active");

    scanner.close();
  }

  /**
   * Main entry point of the program.
   *
   * @param args command-line arguments (not used).
   */

  public static void main(String[] args) {
    ftNurserySummary();
  }
}
