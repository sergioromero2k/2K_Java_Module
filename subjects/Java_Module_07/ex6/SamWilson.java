package ex6;

import ex3.ShieldBearer;

/**
 * Represents Sam Wilson as a shield bearer.
 */
public class SamWilson extends ShieldBearer {

  /**
   * Returns Sam Wilson's motto.
   *
   * @return Sam Wilson's motto
   */
  @Override
  public String motto() {
    return "The shield doesn't belong to a man. It belongs to an idea.";
  }
}