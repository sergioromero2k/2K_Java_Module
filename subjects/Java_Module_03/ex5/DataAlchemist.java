package ex5;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

/**
 * Manages a database of adventurers.
 */
public class DataAlchemist {

  /**
   * Program entry point.
   *
   * @param args command-line arguments
   */
  public static void main(String[] args) {

    HashMap<Integer, Adventurer> database = new HashMap<>();

    database.put(101, new Adventurer("Artorias", 85, "Knight"));
    database.put(102, new Adventurer("Sylvanas", 45, "Archer"));
    database.put(103, new Adventurer("Legolas", 30, "Archer"));
    database.put(104, new Adventurer("Cloud", 31, "Mercenary"));
    database.put(105, new Adventurer("Gandalf", 99, "Wizard"));

    HashSet<Adventurer> elite = new HashSet<>();

    System.out.println("=== DATA ALCHEMIST LAB ===");
    System.out.println("[System] Database populated with "
        + database.size() + " adventurers.");

    System.out.println("\n--- Elite Heroes (Level > 50) ---");

    for (Map.Entry<Integer, Adventurer> entry : database.entrySet()) {

      Adventurer a = entry.getValue();

      if (a.level() > 50) {
        elite.add(a);

        System.out.println("* ID " + entry.getKey()
            + ": " + a.name()
            + " (Level " + a.level() + ")");
      }
    }

    System.out.println("\nTotal Elite: " + elite.size() + " heroes.");
    System.out.println("Transmutation complete. System: STABLE.");
  }
}