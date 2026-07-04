package ex4;

import java.util.Stack;

/**
 * Simulates a spell stack using LIFO behavior.
 */
public class SpellStack {

  /**
   * Program entry point.
   *
   * @param args command-line arguments
   */
  public static void main(String[] args) {

    Stack<String> stack = new Stack<>();

    System.out.println("=== SPELL CASTER LOG ===");

    stack.push("Fireball");
    System.out.println("Casting: Fireball");

    stack.push("Ice Shield");
    System.out.println("Casting: Ice Shield");

    stack.push("Teleport");
    System.out.println("Casting: Teleport");

    System.out.println("\nTop of the stack: " + stack.peek());

    System.out.println("[!] Spell failed! Undoing last action...");
    System.out.println("Popped from stack: " + stack.pop());

    System.out.println("Current active spells: " + stack);
  }
}