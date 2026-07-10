package ex0;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.stream.Stream;

/**
 * Reads the mission file and prints its contents to the console.
 */
public class MissionScript {

  /**
   * Entry point of the program.
   *
   * @param args command-line arguments
   */
  public static void main(String[] args) {
    String currentDir = System.getProperty("user.dir");
    System.out.println("Directorio Actual:  " + currentDir + "\n");

    Path path = Path.of(currentDir, "mision.txt");

    try (Stream<String> lineas = Files.lines(path)) {
      lineas.forEach(linea -> System.out.println(linea));
    } catch (IOException e) {
      System.out.println("Error: " + e.getMessage());
    }
  }
}