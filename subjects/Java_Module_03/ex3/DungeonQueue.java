package ex3;

import java.util.ArrayDeque;

/**
 * Simulates the entrance queue of a dungeon using ArrayDeque.
 */
public class DungeonQueue {

  /**
   * Program entry point.
   *
   * @param args command-line arguments
   */
  public static void main(String[] args) {

    ArrayDeque<String> deque = new ArrayDeque<>();

    deque.addLast("Warrior");
    deque.addLast("Mage");
    deque.addLast("Rogue");

    System.out.println("=== DUNGEON ENTRANCE ===\n");

    System.out.println("[Queue Mode]");
    System.out.println("Current Queue: " + deque);

    System.out.println("\n[Deque Event]");
    System.out.println("[!] ALERT: Boss has appeared and skipped the line!");
    deque.addFirst("Boss");
    System.out.println("New Queue: " + deque);

    System.out.println("\n[Peek]");
    System.out.println("Next to enter: " + deque.peekFirst());

    System.out.println("\n[Wave Start]");
    System.out.println("Entering dungeon: " + deque.pollFirst());
    System.out.println("Remaining: " + deque);

    System.out.println("\n[Reinforcements Incoming]");
    deque.addFirst("Assassin");
    deque.addLast("Healer");
    System.out.println("Queue Updated: " + deque);

    System.out.println("\n[Wave Continues]");
    while (!deque.isEmpty()) {
      System.out.println("Entering dungeon: " + deque.pollFirst());
      System.out.println("Remaining: " + deque + "\n");
    }

    System.out.println("[Empty Test]");
    System.out.println("Trying to enter: " + deque.pollFirst());
    System.out.println("Queue is empty.");
  }
}