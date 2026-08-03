package ex6;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

/**
 * Compares the file sizes of a serialized file and a JSON file.
 */
public class FormatComparator {

  /**
   * Reads and displays the sizes of the serialized and JSON files.
   *
   * @param args command-line arguments (not used)
   */
  public static void main(String[] args) {
    Path serPath = Path.of("treasury.ser");
    Path jsonPath = Path.of("treasury.json");

    try {
      long serSize = Files.size(serPath);
      long jsonSize = Files.size(jsonPath);

      System.out.println(
          "treasury.ser -> " + serSize
              + " bytes (binary, unreadable outside Java)");
      System.out.println(
          "treasury.json -> " + jsonSize
              + " bytes (plain text, readable anywhere)");
    } catch (IOException e) {
      e.printStackTrace();
    }
  }
}

