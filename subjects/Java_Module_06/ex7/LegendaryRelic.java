package ex7;

import java.io.Serializable;

/**
 * Represents a legendary relic that can be serialized.
 */
public class LegendaryRelic extends AsgardianRelic implements Serializable {

  private static final long serialVersionUID = 1L;
  private String name;

  /**
   * Creates a legendary relic.
   *
   * @param name the relic name
   */
  public LegendaryRelic(String name) {
    super();
    this.name = name;
  }

  /**
   * Returns the relic name.
   *
   * @return the relic name
   */
  public String getName() {
    return name;
  }
}