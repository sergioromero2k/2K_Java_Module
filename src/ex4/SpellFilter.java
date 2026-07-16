package ex4;

import java.util.Comparator;
import java.util.List;

/**
 * Filters, removes duplicates, and sorts a list of spells.
 */
public class SpellFilter {

  /**
   * Main method that processes the spell list.
   *
   * @param args program arguments
   */
  public static void main(String[] args) {
    List<String> hechizos = List.of(
        "Fireball",
        "Teleport",
        "Ice Blast",
        "Fireball",
        "Shield",
        "Teleport",
        "Lightning"
    );

    System.out.println("Unique and sorted spells:\n");

    hechizos.stream()
        .distinct()
        .sorted(Comparator.naturalOrder())
        .forEach(System.out::println);
  }
}