package exercise;

/**
 * Custom exception class.
 */
public class RadiationLeakingException extends Exception {
  /**
   * Constructs a new RadiationLeakingException with the specified message.
   *
   * @param message the detail message.
   */
  public RadiationLeakingException(String message) {
    super(message);
  }
}
