package exercise;

/**
 * Manages the atmospheric reentry protocol for spacecraft.
 * This class validates approach angles to ensure heat shield integrity.
 */
public class FtReentryProtocol {
  /**
   * Main entry point simulating reentry maneuvers.
   *
   * @param args Command line arguments (unused).
   */
  public static void main(String[] args) {
    double angle1 = 25;
    double angle2 = 60;
    try {
      System.out.println("=== Deep Space Navigation === ");
      calculateHeatShield(angle1);
      calculateHeatShield(angle2);
    } catch (AngleCriticalException e) {
      System.out.println(e.getMessage());
    } finally {
      System.out.println("[SYSTEM] Aborting reentry. Recalculating orbit... ");
    }
  }

  /**
   * Validates if the reentry angle is within safety parameters.
   *
   * @param angle The approach angle in degrees.
   * @throws AngleCriticalException If the angle is less than 10 or greater than 45.
   */
  public static void calculateHeatShield(double angle) throws AngleCriticalException {
    // Safety check: Angle must be between [10.0, 45.0]
    if (angle < 10 || angle > 45) {
      System.out.printf(
          java.util.Locale.US, "Testing Reentry Angle: %.1f...%n ", angle);

      // Formatting the error message to include the decimal value.
      String message = String.format(java.util.Locale.US,
          "[EMERGENCY] AngleCriticalException: %.1f° exceeds safety limits!", angle);
      throw new AngleCriticalException(message);
    } else {
      System.out.printf(
          java.util.Locale.US,
          "Testing Reentry Angle: %.1f... [SUCCESS] Ship is on track. %n", angle);
    }
  }
}
