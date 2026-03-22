package exercise;

import java.util.Stack;

/**
 * Manages a collection of magical spells using a LIFO(Last-In-First-Out) structure.
 */
public class SpellStack {
  /**
   * Executes the spell casting simulation and demonstrates stack operations.
   */
  public static void main() {
    // Initialize the stack to store spell names.
    Stack<String> spells = new Stack<>();
    spells.push("Fireball");
    spells.push("Ice Shield");
    spells.push("Teleport");

    System.out.println("=== SPELL CASTER LOG ===");
    // Displaying the casting order.
    for (String s : spells) {
      System.out.println("Casting: " + s);
    }

    System.out.println("\nTop of the stack:" + spells.peek());
    System.out.println("[!] Spell failed! Undoing last action... ");
    System.out.println("Popped from stack: " + spells.pop());
    if (!spells.isEmpty()) {
      System.out.println("\nCurrent active spells: " + spells);
    }
  }
}
