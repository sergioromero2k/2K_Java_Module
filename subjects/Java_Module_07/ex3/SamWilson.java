package ex3;

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

  /**
   * Runs the Sam Wilson example.
   *
   * @param args command-line arguments
   */
  public static void main(String[] args) {
    SamWilson sam = new SamWilson();
    sam.raiseShield();
    System.out.println("Sam Wilson's motto: " + sam.motto());
  }
}
