package ex0;

import java.io.Serializable;

/**
 * Represents an Asgardian relic that can be serialized.
 */
public class AsgardianRelic implements Serializable {

  private String name;
  private int powerLevel;

  /**
   * Instantiates a new Asgardian relic.
   *
   * @param name       the name of the relic
   * @param powerLevel the power level of the relic
   */
  public AsgardianRelic(String name, int powerLevel) {
    this.name = name;
    this.powerLevel = powerLevel;
  }

  /**
   * Gets the name of the relic.
   *
   * @return the name
   */
  public String getName() {
    return name;
  }

  /**
   * Gets the power level of the relic.
   *
   * @return the power level
   */
  public int getPowerLevel() {
    return powerLevel;
  }

  /**
   * Sets the name of the relic.
   *
   * @param name the new name
   */
  public void setName(String name) {
    this.name = name;
  }

  /**
   * Sets the power level of the relic.
   *
   * @param powerLevel the new power level
   */
  public void setPowerLevel(int powerLevel) {
    this.powerLevel = powerLevel;
  }
}