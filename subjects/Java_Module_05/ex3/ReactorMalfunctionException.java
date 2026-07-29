package ex3;

/**
 * Exception thrown when the reactor cannot be sealed safely.
 */
public class ReactorMalfunctionException extends Exception {

  /**
   * Creates a new reactor malfunction exception.
   *
   * @param message exception message
   */
  public ReactorMalfunctionException(String message) {
    super(message);
  }
}