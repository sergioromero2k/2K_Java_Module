package ex3;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

/**
 * Manages the serialization and deserialization of Asgardian relics.
 */
public class TreasuryVault {

  /**
   * Main method.
   *
   * @param args command-line arguments
   */
  public static void main(String[] args) {

    ArrayList<AsgardianRelic> relics = new ArrayList<>();

    relics.add(new AsgardianRelic("Mjolnir"));
    relics.add(new AsgardianRelic("Gungnir"));
    relics.add(new AsgardianRelic("Tesseract"));

    // Guardar la lista
    try (
        FileOutputStream fos = new FileOutputStream("treasury.ser");
        ObjectOutputStream oos = new ObjectOutputStream(fos)
    ) {

      oos.writeObject(relics);
      System.out.println("Treasury sealed with " + relics.size() + " relics.");

    } catch (Exception e) {
      e.printStackTrace();
    }

    // Recuperar la lista
    try (
        FileInputStream fis = new FileInputStream("treasury.ser");
        ObjectInputStream ois = new ObjectInputStream(fis)
    ) {

      @SuppressWarnings("unchecked")
      ArrayList<AsgardianRelic> recovered =
          (ArrayList<AsgardianRelic>) ois.readObject();

      System.out.println("Treasury recovered: " + recovered);

    } catch (Exception e) {
      e.printStackTrace();
    }
  }
}