package exC;

/**
 * Exception thrown when a mercenary cannot be found.
 */
public class MercenaryNotFoundException extends RuntimeException {

  /**
   * Creates a new mercenary not found exception.
   *
   * @param message exception message
   */
  public MercenaryNotFoundException(String message) {
    super(message);
  }
}