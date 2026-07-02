package ex1;

import java.util.HashSet;
import java.util.List;
import java.util.TreeSet;

/**
 * Processes a list of loot to show unique and sorted items.
 */
public class LootProcessor {
  /**
   * Entry point of the application.
   *
   * @param args Command line arguments.
   */
  public static void main(final String[] args) {
    List<String> rawLoot = List.of("Sword", "Shield", "Sword", "Potion");

    // Changed HashMap to HashSet
    HashSet<String> uniqueLoot = new HashSet<>(rawLoot);

    TreeSet<String> sortedLoot = new TreeSet<>(rawLoot);

    System.out.println("=== LOOT PROCESSING ===");
    System.out.println("Unique Loot: " + uniqueLoot);
    System.out.println("Sorted Loot: " + sortedLoot);

    System.out.println("\nTotal unique items: " + uniqueLoot.size());
  }
}