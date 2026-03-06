package exercise;

/**
 * Base exception representing a generic space station emergency.
 */
class StationException extends Exception {
  /**
   * Construct a new StationException with a specified message.
   *
   * @param message detailed description of the station error.
   */
  public StationException(String message) {
    super(message);
  }
}

/**
 * Exception representing a solar storm event that threatens the station.
 */
class SolarStormException extends StationException {
  /**
   * Constructs a SolarStormException with a specific warning message.
   *
   * @param message description of the solar storm alert.
   */
  public SolarStormException(String message) {
    super(message);
  }
}

/**
 * Exception representing a critical oxygen leak inside the station.
 */
class OxygenLeakException extends StationException {
  /**
   * Constructs an OxygenLeakException with a specific error message.
   *
   * @param message description of the oxygen leak alert.
   */
  public OxygenLeakException(String message) {
    super(message);
  }
}

/**
 * Demonstrates how custom exceptions can be thrown and captured in a
 * simulated mission control alert system.
 */
public class FtPlanetExceptionsThrows {
  /**
   * Entry point of the program.
   *
   * @param args command-line arguments (not used).
   */
  public static void main(String[] args) {

    System.out.println("=== Mission Control Alert System === ");
    try {
      System.out.println(
          "Triggering: " + OxygenLeakException.class.getSimpleName());
      triggerAlarm("Oxygen", "[CRITICAL] Pressure drop in Sector 7G! ");
    } catch (StationException e) {
      System.out.println("Report: " + e.getMessage());
      System.out.println(
          "Captured as " + OxygenLeakException.class.getSimpleName() + ": " + e.getMessage());
    }
    System.out.println();
    try {
      System.out.println(
          "Triggering: " + SolarStormException.class.getSimpleName());
      triggerAlarm("Solar", "[WARNING] High radiation detected. Deploying shields");
    } catch (StationException e) {
      System.out.println("Report: " + e.getMessage());
      System.out.println(
          "Captured as " + SolarStormException.class.getSimpleName() + ": " + e.getMessage());
    }

  }

  /**
   * Triggers a specific alarm depending on the provided event type.
   *
   * @param type the type of emergency detected.
   * @param message the alert message describing the problem.
   * @throws StationException if a station emergency occurs.
   */
  public static void triggerAlarm(
      String type, String message) throws StationException {
    if (type.equals("Oxygen")) {
      throw new OxygenLeakException(message);
    } else if (type.equals(("Solar"))) {
      throw new SolarStormException(message);
    }
  }
}
