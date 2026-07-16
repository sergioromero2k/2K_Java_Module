package ex3;

import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Stores Deadpool's valuable loot in a file.
 */
public class DeadpoolVault {

  /**
   * Main method that filters valuable items and saves them.
   *
   * @param args program arguments
   */
  public static void main(String[] args) {
    List<String> loot = List.of(
        "Katana",
        "Piedra",
        "Oro",
        "Chimichanga",
        "Diamante"
    );

    List<String> filtrados = loot.stream()
        .filter(i -> i.equals("Oro") || i.equals("Diamante") || i.equals("Katana"))
        .collect(Collectors.toList());

    try (BufferedWriter writer = Files.newBufferedWriter(Path.of("deadpool_loot.txt"))) {
      for (String item : filtrados) {
        writer.write(item);
        writer.newLine();
      }
    } catch (IOException e) {
      System.out.println("Error: " + e.getMessage());
    }
  }
}