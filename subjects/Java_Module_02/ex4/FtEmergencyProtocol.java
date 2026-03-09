package exercise;

/**
 * Monitoring system designed to halt execution upon detecting sabotage.
 */
public class FtEmergencyProtocol {
  /**
   * By adding 'throws' here, we allow the exception to crash the program,
   * which is the required behavior for this protocol.
   *
   * @param args Command-Line arguments (not used).
   * @throws RadiationLeakingException Re-thrown to ensure the program stops.
   */
  public static void main(String[] args) throws RadiationLeakingException {
    int temp1 = 800;
    int temp2 = 1200;
    try {
      System.out.println("=== Reactor Core Monitor === \n");
      radiation(temp1);
      radiation(temp2);
    } catch (RadiationLeakingException e) {
      throw e;
    }
  }

  /**
   * Checks temperature and throws exception if above 1000.
   *
   * @param temp the current core temperature in Celsius.
   * @throws RadiationLeakingException if temp > 1000.
   */
  public static void radiation(int temp) throws RadiationLeakingException {
    if (temp > 1000) {
      System.out.println("Current Temp: " + temp + "°C");
      throw new RadiationLeakingException("\nCritical Overheat! Core at " + temp + "°C.");
    } else {
      System.out.println("Current Temp: " + temp + "°C - Stable.");
    }
  }
}
