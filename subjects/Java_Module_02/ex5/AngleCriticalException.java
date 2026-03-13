package exercise;

/**
 * Custom exception thrown when a spacecraft's reentry angle falls outside
 * safe thermal limits.
 */
public class AngleCriticalException extends Exception {
  /**
   * Constructs a new exception with the specified detail message.
   *
   * @param message The formatted error string containing the critical angle.
   */
  public AngleCriticalException(String message) {
    super(message);
  }
}
