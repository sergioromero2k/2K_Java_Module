package ex6;

import java.util.ArrayList;
import java.util.List;

/**
 * Processes a mission command system from raw comma-separated input strings.
 * Supports urgent insertion and abort clearing logic.
 */
public class CommandMission {

  /**
   * Entry point of the application.
   *
   * @param args command-line arguments (not used)
   */
  public static void main(String[] args) {

    List<String> missionQueue = new ArrayList<>();

    String texto = "move, urgent:save_villager, loot, urgent:shield";
    final String texto2 = "explore, abort, rest";

    System.out.println("=== COMMAND MISSION PROCESSOR ===");

    processCommands(texto, missionQueue);

    System.out.println("--- New Entry ---");

    processCommands(texto2, missionQueue);
  }

  /**
   * Processes a comma-separated command string and updates the mission queue.
   *
   * <p>Rules:
   * <ul>
   *   <li>Trim whitespace from each command</li>
   *   <li>"urgent:" commands are inserted at the front</li>
   *   <li>"abort" clears the entire mission queue</li>
   * </ul>
   *
   * @param input raw command string
   * @param missionQueue list storing active missions
   */
  public static void processCommands(String input, List<String> missionQueue) {

    String[] comandos = input.split(",");

    System.out.println("Enter raw commands: " + input);
    System.out.println("[System] Processing...");

    for (String cmd : comandos) {
      String limpio = cmd.trim();

      if (limpio.equals("abort")) {
        System.out.println("[System] Abort command detected. Clearing list...");
        missionQueue.clear();
        continue;
      }

      if (limpio.startsWith("urgent:")) {
        missionQueue.add(0, limpio.substring(7));
      } else {
        missionQueue.add(limpio);
      }
    }

    System.out.println("Current Mission Queue: " + missionQueue);
    System.out.println();
  }
}