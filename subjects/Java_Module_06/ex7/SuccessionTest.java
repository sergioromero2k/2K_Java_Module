package ex7;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

/**
 * Demonstrates serialization and deserialization of a LegendaryRelic.
 */
public class SuccessionTest {

  /**
   * Serializes and deserializes a LegendaryRelic instance.
   *
   * @param args command-line arguments (not used)
   */
  public static void main(String[] args) {
    LegendaryRelic relic = new LegendaryRelic("Gungnir");

    // Serialize
    try (
        FileOutputStream fos = new FileOutputStream("relic.ser");
        ObjectOutputStream oss = new ObjectOutputStream(fos)) {
      oss.writeObject(relic);
      System.out.println("Relic sealed.");
    } catch (IOException e) {
      System.out.println("Error: " + e);
    }

    // Deserialize
    try (
        FileInputStream fileIn = new FileInputStream("relic.ser");
        ObjectInputStream objIn = new ObjectInputStream(fileIn)) {

      LegendaryRelic restored = (LegendaryRelic) objIn.readObject();

      // AsgardianRelic does not implement Serializable.
      // During deserialization its no-argument constructor is invoked,
      // which is why "Relic forged." is printed again.
      System.out.println("Relic recovered: " + restored.getName());

    } catch (IOException | ClassNotFoundException e) {
      System.out.println("Error: " + e.getMessage());
    }
  }
}