package exercise;

/**
 * Main class for running the Forest Security System simulation.
 */
public class FtForestSecurity {
  /**
   * Entry point of the program. Test SecureTree security validations.
   *
   * @param args command line arguments.
   */
  public static void main(String[] args) {
    System.out.println("=== Forest Security System ===");
    SecureTree secure = new SecureTree("Pine", 50, 100);
    System.out.println(secure);
    secure.setHeight(55);
    secure.setAge(101);
    secure.setHeight(-10);
    System.out.println(
        "Current tree: " + secure + " (" + secure.getHeight() + "cm, " + secure.getAge() + "days)");
  }
}
