package ex2;

import java.io.Serializable;

/**
 * Represents a serializable rune stone.
 */
public class RuneStone implements Serializable {

  private static final long serialVersionUID = 1L;

  private int value;
  private String name;

  /**
   * Creates a rune stone.
   *
   * @param value rune value
   * @param name rune name
   */
  public RuneStone(int value, String name) {
    this.value = value;
    this.name = name;
  }

  /**
   * Returns the rune value.
   *
   * @return value
   */
  public int getValue() {
    return value;
  }

  /**
   * Returns the rune name.
   *
   * @return name
   */
  public String getName() {
    return name;
  }

  @Override
  public String toString() {
    return "RuneStone{"
        + "value=" + value
        + ", name='" + name + '\''
        + '}';
  }
}