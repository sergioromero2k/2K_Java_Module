package ex3;

import java.io.Serializable;

/**
 * Represents an Asgardian relic.
 */
public class AsgardianRelic implements Serializable {

  private static final long serialVersionUID = 1L;

  private String name;

  /**
   * Creates an Asgardian relic.
   *
   * @param name relic name
   */
  public AsgardianRelic(String name) {
    this.name = name;
  }

  @Override
  public String toString() {
    return name;
  }
}