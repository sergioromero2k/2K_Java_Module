package ex2;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

/**
 * Exercise 2: RuneMismatch.
 */
public class RuneMismatch {

  /**
   * Main method.
   *
   * @param args command-line arguments
   * @throws IOException if an I/O error occurs
   */
  public static void main(String[] args) throws IOException {

    /*
    // 1ª FORMA
    RuneStone relic = new RuneStone(20);

    try (
        FileOutputStream fos = new FileOutputStream("relic.ser");
        ObjectOutputStream oos = new ObjectOutputStream(fos)
    ) {
      oos.writeObject(relic);
    } catch (IOException e) {
      System.out.println("Error: " + e.getMessage());
    }
    */

    /*
    // 2ª FORMA
    try (
        FileInputStream fileIn = new FileInputStream("relic.ser");
        ObjectInputStream objIn = new ObjectInputStream(fileIn)
    ) {
      RuneStone relic = (RuneStone) objIn.readObject();
      System.out.println(relic);
    } catch (IOException e) {
      System.out.println("Error general: " + e);
    } catch (ClassNotFoundException e) {
      throw new RuntimeException(e);
    }
    */

    /*
    // 3ª FORMA - Serialización
    RuneStone relic = new RuneStone(20);

    try (
        FileOutputStream fos = new FileOutputStream("relic.ser");
        ObjectOutputStream oos = new ObjectOutputStream(fos)
    ) {
      oos.writeObject(relic);
    } catch (IOException e) {
      System.out.println("Error: " + e.getMessage());
    }
    */

    // 3ª FORMA - Deserialización
    try (
        FileInputStream fileIn = new FileInputStream("relic.ser");
        ObjectInputStream objIn = new ObjectInputStream(fileIn)
    ) {
      RuneStone relic = (RuneStone) objIn.readObject();
      System.out.println(relic);
    } catch (IOException e) {
      System.out.println("Error general: " + e);
    } catch (ClassNotFoundException e) {
      throw new RuntimeException(e);
    }
  }
}