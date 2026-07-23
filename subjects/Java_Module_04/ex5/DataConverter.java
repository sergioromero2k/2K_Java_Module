package ex5;

import java.util.List;

/**
 * Converts a list of String numbers into a list of Integer values.
 */
public class DataConverter {

  /**
   * Main method that converts service years from String to Integer.
   *
   * @param args program arguments
   */
  public static void main(String[] args) {
    List<String> nums = List.of("5", "12", "3", "20", "8");

    List<Integer> newList = nums.stream()
        .map(Integer::parseInt)
        .toList();

    System.out.println("Converted service years:\n" + newList);
  }
}