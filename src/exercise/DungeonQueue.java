package exercise;

import java.util.ArrayDeque;

/**
 * Simulates a dungeon entrance queue using ArrayDeque.
 */
public class DungeonQueue {
  /**
   * Entry point of the program.
   * Simulates different queue events in a dungeon scenario.
   *
   * @param args Command-line arguments (not used).
   */
  public static void main(String[] args) {

    // Create a double-ended queue to manage characters.
    ArrayDeque<String> q = new ArrayDeque<>();

    // [Queue Mode] - Add elements to the end (FIFO behavior)
    q.addLast("Warrior");
    q.addLast("Mage");
    q.addLast("Rogue");

    System.out.println("=== DUNGEON ENTRANCE ===");
    System.out.println("\n[Queue Mode]");
    System.out.println("Current Queue: " + q);

    // [Deque Event] - Add element to the front (priority insertion)
    System.out.println("\n[Deque Event]");
    System.out.println("[!] ALERT: Boss has appeared and skipped the line!");
    q.addFirst("Boss");
    System.out.println("New Queue: " + q);

    System.out.println("\n[Peek]");
    System.out.println("Next to enter: " + q.peekFirst());

    System.out.println("\n[Wave Start]");
    System.out.println("Entering dungeon: " + q.pollFirst());
    System.out.println("Remaining: " + q);

    System.out.println("\n[Reinforcements Incoming]");
    q.addLast("Healer");
    q.addFirst("Assassin");
    System.out.println("Queue Updated: " + q);

    System.out.println("\n[Wave Continues]");
    while (!q.isEmpty()) {
      System.out.println("Entering dungeon: " + q.pollFirst());
      System.out.println("Remaining: " + q + "\n");
    }

    System.out.println("\n[Empty Test]");
    System.out.println("Trying to enter: " + q.pollFirst());
    if (q.isEmpty()) {
      System.out.println("Queue is empty.");
    }
  }

}
