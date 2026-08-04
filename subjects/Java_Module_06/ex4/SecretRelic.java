package ex4;

import java.io.Serializable;

/**
 * Represents a secret relic with a transient activation code.
 */
public class SecretRelic implements Serializable {

  /** Serial version UID for serialization. */
  private static final long serialVersionUID = 1L;

  /** Activation code that is not serialized. */
  private transient String activationCode;

  /**
   * Creates a new SecretRelic with the specified activation code.
   *
   * @param activationCode the activation code of the relic
   */
  public SecretRelic(String activationCode) {
    this.activationCode = activationCode;
  }

  /**
   * Returns the activation code.
   *
   * @return the activation code
   */
  public String getActivationCode() {
    return activationCode;
  }

  /**
   * Sets the activation code.
   *
   * @param activationCode the new activation code
   */
  public void setActivationCode(String activationCode) {
    this.activationCode = activationCode;
  }
}
