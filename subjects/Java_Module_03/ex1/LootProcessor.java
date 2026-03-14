package exercise;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.TreeSet;

/**
 * Handles the collection and filtering of loot items found during expeditions.
 * Demonstrates the differences between List, HashSet, and TreeSet.
 */
public class LootProcessor {
  /**
   * Main entry point for processing loot items.
   *
   * @param args Command line arguments (not used).
   */
  public static void main(String[] args) {
    List<String> items = new ArrayList<>();

    items.add("Sword");
    items.add("Shield");
    items.add("Sword");
    items.add("Potion");

    System.out.println("=== LOOT PROCESSING ===");
    System.out.println("Raw Loot: " + items);

    // Remove duplicates using a HashSet
    HashSet<String> hash = new HashSet<>();
    hash.addAll(items);

    System.out.println("Unique Loot: " + hash);

    // Sort items using a TreeSet
    TreeSet<String> tree = new TreeSet<>();
    tree.addAll(items);

    System.out.println("Sorted Loot: " + tree);
    System.out.println("\nTotal unique items: " + hash.size());
  }

}
