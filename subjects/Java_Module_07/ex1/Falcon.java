package ex1;

import ex0.Avenger;

/**
 * Represents Falcon, an Avenger with a specific battle cry.
 */
public class Falcon implements Avenger {

  @Override
  public String battleCry() {
    return "On your left!";
  }
}