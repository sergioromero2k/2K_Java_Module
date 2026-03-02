package exercise;

/**
 * Validator for oxygen sensor readings in the base station.
 * Filters corrupts data and monitors safety thresholds.
 *
 */
public class FtOxygenValidator {

  /**
   * Checks the oxygen level from a strign input and prints the status.
   *
   * @param input The raw string telemetry data from the sensor.
   */
  public static void checkOxygenLevel(String input) {
    try {
      double number = Double.parseDouble(input);
      if (number >= 18 && number <= 25) {
        System.out.println(
            "Input '" + number + "': [OK] Level at " + number + "% - Optimal conditions.");
      } else if (number < 18) {
        System.out.println(
            "Input '" + number + "': [ALERT] " + number
                + "% is below critical threshold (Min 18%)");
      } else {
        System.out.println(
            "Input '" + number + "': [ALERT] " + number
                + "% is oxygen toxicity risk! (Max 25%)");
      }
    } catch (NumberFormatException e) {
      System.out.println(
          "Input '" + input + "': [ERROR] Sensor corrupt: '" + input
              + "' is not a valid numeric reading.");
    }
  }

  /**
   * Runs telemetry test with various sensor input cases.
   *
   * @param args Non-command line.
   */
  public static void main(String[] args) {
    System.out.println("=== Oxygen Sensor Telemetry ===");
    String[] testCases = {
        "21.5",
        "15.0",
        "99.9",
        "abc"
    };
    for (String test : testCases) {
      checkOxygenLevel(test);
    }
  }
}
