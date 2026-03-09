package exercise;

public class FtReentryProtocol {

  public static void main(String[] args){
    int angle1 = 25;
    int angle2 = 60;
    try {
      System.out.println("=== Deep Space Navigation === ");
      calculateHeatShield(angle1);
      calculateHeatShield(angle2);
    } catch (AngleCriticalException e) {
      System.out.println(e.getMessage());
    } finally {
      System.out.println("[SYSTEM] Aborting reentry. Recalculating orbit... ");
    }
  }
  public static void calculateHeatShield(int angle) throws AngleCriticalException{
    if (angle < 10 || angle > 45) {
      System.out.println("Testing Reentry Angle: " + angle  + "...  ");
      throw new AngleCriticalException("[EMERGENCY] AngleCriticalException: " + angle + "° exceeds safety limits! ");
    } else {
      System.out.println("Testing Reentry Angle: " + angle + "... [SUCCESS] Ship is on track. ");
    }
  }
}
