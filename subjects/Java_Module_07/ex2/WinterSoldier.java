package ex2;

/**
 * Represents the Winter Soldier as an Avenger.
 */
public class WinterSoldier implements Avenger {

  /**
   * Returns the Winter Soldier's battle cry.
   *
   * @return the battle cry
   */
  @Override
  public String battleCry() {
    return "Ready to comply... no, wait. Ready to fight.";
  }

  /**
   * Runs the Winter Soldier example.
   *
   * @param args command-line arguments
   */
  public static void main(String[] args) {
    WinterSoldier winter = new WinterSoldier();
    winter.introduce();
    System.out.println("Winter Soldier says: " + winter.battleCry());
  }
}