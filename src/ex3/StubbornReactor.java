package ex3;

/**
 * Represents a reactor that may fail while closing.
 */
public class StubbornReactor implements AutoCloseable {

  private final int energyLevel;

  /**
   * Creates a reactor with the specified energy level.
   *
   * @param energyLevel reactor energy level
   */
  public StubbornReactor(int energyLevel) {
    this.energyLevel = energyLevel;
  }

  /**
   * Attempts to seal the reactor.
   *
   * @throws ReactorMalfunctionException if the reactor cannot be sealed
   */
  @Override
  public void close() throws ReactorMalfunctionException {
    System.out.println("Attempting to seal reactor...");

    if (energyLevel > 100) {
      throw new ReactorMalfunctionException(
          "Reactor refused to close! Energy level: " + energyLevel);
    }

    System.out.println("Reactor sealed successfully.");
  }
}