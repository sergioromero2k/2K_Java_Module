package exercise;

/**
 * Base Exception for all spaces station related incidents.
 */
class StationException extends Exception {
  public StationException(String message) {
    super(message);
  }
}

/**
 * Occurs when solar radiation levels exceed safety thresholds.
 */
class SolarStormException extends StationException {
  public SolarStormException(String message) {
    super(message);
  }
}

/**
 * Occurs when life support system detect a drop in oxygen pressure.
 */
class OxygenLeakException extends StationException {
  public OxygenLeakException(String message) {
    super(message);
  }
}

/**
 * Simulated mission control system for handling planetary station emergencies.
 */
public class  FtPlanetExceptionsTry {

  /**
   * Main entry point for the Mission Control Alert System.
   *
   * @param args Command-line arguments (not used).
   */
  public static void main(String[] args) {
    System.out.println("=== Mission Control Alert System ===");
    launchAlert("OXIGENO", "[CRITICAL] Pressure drop in Sector 7G!");
    launchAlert("SOLAR", "[WARNING] High radiation detected. Deploying shields");
  }

  /**
   * Triggers and handles station exceptions based on the provided type.
   *
   * @param type    The category of the alert.
   * @param message The specific error message.
   */
  public static void launchAlert(String type, String message) {
    String exceptionName = type.equals("OXIGENO") ? "OxygenLeakException" : "SolarStormException";
    System.out.println("Triggering: " + exceptionName);

    try {
      if (type.equals("OXIGENO")) {
        throw new OxygenLeakException(message);
      } else {
        throw new SolarStormException(message);
      }
    } catch (StationException e) {
      System.out.println("Report: " + e.getMessage());
      System.out.println("Captured as Station: " + e.getMessage());
      System.out.println();
    }
  }
}