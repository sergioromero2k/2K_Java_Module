package exercise;

import java.util.ArrayList;

/**
 * Manages the registration and display of expedition members.
 */
public class HeroRegistry {
  /**
   * Main entry point for the registry application.
   *
   * @param args Command line arguments (not used).
   */
  public static void main(String[] args) {
    ArrayList<Adventurer> adventurers = new ArrayList<>();

    // Adding records using the canonical constructor.
    adventurers.add(new Adventurer("Artorias", 50, "Knight"));
    adventurers.add(new Adventurer("Sylvanas", 45, "Archer"));

    System.out.println("=== ADVENTURER REGISTRY ===");
    for (Adventurer a : adventurers) {
      System.out.println("- " + a.name() + " (Level " + a.level() + ") [" + a.role() + "] ");
    }
    System.out.println("\nTotal: " + adventurers.size() + " heroes in the party. ");

  }
}
