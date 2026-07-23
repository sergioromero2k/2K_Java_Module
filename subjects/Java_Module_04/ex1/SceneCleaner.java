package ex1;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.stream.Stream;

/**
 * Cleans the crime scene report by removing unwanted lines
 * and printing the remaining ones in uppercase.
 */
public class SceneCleaner {

  /**
   * Entry point of the program.
   *
   * @param args command-line arguments
   */
  public static void main(String[] args) {
    Path path = Path.of("escena.txt");

    try (Stream<String> lines = Files.lines(path)) {
      lines
          .filter(line -> !line.contains("NOISE")
              && !line.contains("CIVILIAN"))
          .map(l -> l.toUpperCase())
          .forEach(System.out::println);
    } catch (IOException e) {
      System.out.println("Error: " + e.getMessage());
    }
  }
}