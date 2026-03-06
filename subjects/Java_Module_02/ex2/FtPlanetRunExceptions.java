package exercise;

/**
 * Base exception representing a generic space station emergency.
 * This exception extends RuntimeException so it does not need to be
 * explicitly declared or caught.
 */
class StationException extends RuntimeException {

  /**
   * Creates a new StationException with a descriptive message.
   *
   * @param message detailed description of the station error
   */
  public StationException(String message) {
    super(message);
  }
}

/**
 * Exception representing a solar storm threat to the station.
 */
class SolarStormException extends StationException {

  /**
   * Creates a SolarStormException with a specific alert message.
   *
   * @param message description of the solar storm warning
   */
  public SolarStormException(String message) {
    super(message);
  }
}

/**
 * Exception representing a critical oxygen leak detected
 * in the space station.
 */
class OxygenLeakException extends StationException {

  /**
   * Creates an OxygenLeakException with a specific alert message.
   *
   * @param message description of the oxygen leak problem
   */
  public OxygenLeakException(String message) {
    super(message);
  }
}

/**
 * Demonstrates the use of custom runtime exceptions in a simulated
 * mission control monitoring system.
 */
public class FtPlanetRunExceptions {

  /**
   * Program entry point. Simulates alerts being triggered by
   * different system codes.
   *
   * @param main command-line arguments (not used)
   */
  public static void main(String[] main) {

    // Display system header
    System.out.println("=== Mission Control: Runtime System ===");

    // Simulate different emergency codes
    triggersAlert("02");
    triggersAlert("SOLAR");
  }

  /**
   * Triggers an alert based on the provided emergency code.
   * Different runtime exceptions are thrown depending on the
   * type of detected problem.
   *
   * @param code system alert code identifying the emergency type
   */
  public static void triggersAlert(String code) {

    try {

      // If the system code corresponds to an oxygen leak
      if (code.equals("02")) {

        System.out.println(
            "Triggering: " + OxygenLeakException.class.getSimpleName());

        // Throw a runtime exception for the oxygen leak
        throw new OxygenLeakException(
            "[CRITICAL] Pressure drop in Sector 7G!");

      } else {

        System.out.println(
            "Triggering: " + SolarStormException.class.getSimpleName());

        // Throw a runtime exception for a solar storm warning
        throw new SolarStormException(
            "[WARNING] High radiation detected.");
      }

    } catch (StationException e) {

      // Handle any station-related runtime exception
      System.out.println("Caught as: " + e.getClass().getSimpleName());
      System.out.println("Report: " + e.getMessage());
      System.out.println("-----------------------------------");
    }
  }
}
