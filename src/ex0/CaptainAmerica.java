package ex0;

/**
 * Represents Captain America as an Avenger.
 */
public class CaptainAmerica implements Avenger {

  /**
   * Returns Captain America's battle cry.
   *
   * @return the battle cry
   */
  @Override
  public String battleCry() {
    return "Avengers, assemble!";
  }

  /**
   * Runs the Captain America example.
   *
   * @param args command-line arguments
   */
  public static void main(String[] args) {
    CaptainAmerica capitan = new CaptainAmerica();
    System.out.println("Captain America says: " + capitan.battleCry());
  }
}