package ex4;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

/**
 * Demonstrates the serialization and deserialization of a SecretRelic object.
 */
public class MainTest {

  /**
   * Runs the serialization and deserialization example.
   *
   * @param args command-line arguments (not used)
   */
  public static void main(String[] args) {
    String filePath = "file.ser";

    SecretRelic secret = new SecretRelic("THOR-7749 ");
    System.out.println("--- BEFORE SERIALIZATION ---");
    System.out.println("Activation Code: " + secret.getActivationCode());

    try (ObjectOutputStream oos =
             new ObjectOutputStream(new FileOutputStream(filePath))) {
      oos.writeObject(secret);
      System.out.println("[Object serialized successfully...]");
    } catch (IOException e) {
      e.printStackTrace();
    }

    try (ObjectInputStream ois =
             new ObjectInputStream(new FileInputStream(filePath))) {
      SecretRelic restoredSecret = (SecretRelic) ois.readObject();

      System.out.println("--- AFTER DESERIALIZATION ---");
      System.out.println("Activation Code: "
          + restoredSecret.getActivationCode());
    } catch (IOException | ClassNotFoundException e) {
      e.printStackTrace();
    }
  }
}