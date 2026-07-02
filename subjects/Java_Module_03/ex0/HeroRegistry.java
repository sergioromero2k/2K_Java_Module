package ex0;

import java.util.ArrayList;

/**
 * Registry system for managing a party of adventurers.
 */
public class HeroRegistry {

  /**
   * Entry point of the application.
   *
   * @param args Command line arguments.
   */
  public static void main(final String[] args) {
    ArrayList<Adventurer> party = new ArrayList<>();
    party.add(new Adventurer("Artorias", 50, "Knight"));
    party.add(new Adventurer("Sylvanas", 45, "Archer"));

    System.out.println("=== ADVENTURER REGISTRY === ");
    for (Adventurer a : party) {
      System.out.println("- " + a.name() + " (Level " + a.level() + ") [" + a.role() + "]");
    }
    System.out.println("\nTotal: " + party.size() + " heroes in the party.");
  }
}