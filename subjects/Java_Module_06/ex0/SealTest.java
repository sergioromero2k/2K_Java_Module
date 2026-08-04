package ex0;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

/**
 * Test class used to serialize an Asgardian relic into a file.
 */
public class SealTest {

  /**
   * Main method to execute the serialization process.
   *
   * @param args command line arguments
   */
  public static void main(String[] args) {
    AsgardianRelic relic = new AsgardianRelic("Reloj", 100);

    try (FileOutputStream fos = new FileOutputStream("relic.ser");
         ObjectOutputStream oos = new ObjectOutputStream(fos)) {

      oos.writeObject(relic);
      System.out.println("The relic's seal has been successfully applied!");
      System.out.println("Relic sealed into relic.ser");

    } catch (IOException e) {
      System.out.println("Error sealing the relic: " + e.getMessage());
    }
  }
}