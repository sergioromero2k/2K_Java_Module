package exercise;

/**
 * Technical Controller for the ship's thermal shield system.
 * This class ensures that safety protocols are executed even.
 */
public class FtShieldSystem {
  /**
   * Main entry point for the shield deployment sequence.
   *
   * @param args args Command line arguments (not used).
   */
  public static void main(String[] args) {
    System.out.println("=== Shield Deployment Sequence === \n");
    try {
      System.out.print("Attempting to calibrate thermal shields... ");
      throw new Exception("Calibration failed due to sensor interference. ");
    } catch (Exception e) {
      System.out.println("\n[!] ERROR: " + e.getMessage());
    } finally {
      // Mandatory safety block: executed regardless of success or failure
      System.out.println("[MANDATORY] Closing thermal shields for crew safety...");
      System.out.print("Sequence finished.");
    }
  }
}
