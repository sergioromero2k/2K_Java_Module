package ex2;

/**
 * Defines the contract for an Avenger.
 */
public interface Avenger {

  /**
   * Returns the Avenger's battle cry.
   *
   * @return the battle cry
   */
  public String battleCry();

  /**
   * Introduces the Avenger.
   */
  default void introduce() {
    System.out.println("I am an Avenger.");
  }
}

