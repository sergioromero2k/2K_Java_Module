package ex3;

/**
 * Represents an abstract shield bearer.
 */
public abstract class ShieldBearer {

  /**
   * Raises the shield.
   */
  public void raiseShield() {
    System.out.println("Shield raised.");
  }

  /**
   * Returns the shield bearer's motto.
   *
   * @return the motto
   */
  public abstract String motto();
}

