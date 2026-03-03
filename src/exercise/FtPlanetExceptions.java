package exercise;

/**
 * Base Exception.
 */
class StationException extends Exception {
  public StationException(String message) {
    super(message);
  }
}

/**
 * Specific Exception 2.
 */
class SolarStormException extends StationException {
  public SolarStormException(String message) {
    super(message);
  }
}

/**
 * Specific Exception 2.
 */
class OxygenLeakException extends StationException {
  public OxygenLeakException(String message) {
    super(message);
  }
}

public class FtPlanetExceptions {

}
