package ex1;

import ex0.AsgardianRelic;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;

/**
 * Reader class used to deserialize and retrieve an Asgardian relic from a file.
 */
public class VaultReader {

  /**
   * Main method to execute the deserialization process.
   *
   * @param args command line arguments
   */
  public static void main(String[] args) {
    try (FileInputStream fileIn = new FileInputStream("relic.ser");
         ObjectInputStream objIn = new ObjectInputStream(fileIn)) {
      AsgardianRelic relic = (AsgardianRelic) objIn.readObject();
      System.out.println("Relic recovered: " + relic.getName()
          + ", power level: " + relic.getPowerLevel());
    } catch (IOException | ClassNotFoundException e) {
      System.out.println("Error: " + e.getMessage());
    }
  }
}