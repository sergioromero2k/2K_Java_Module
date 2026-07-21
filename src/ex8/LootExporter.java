package ex8;

import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.IOException;
import java.nio.file.Path;
import java.util.List;

/**
 * Exports a list of loot items to a JSON file.
 */
public class LootExporter {

  /**
   * Main method that writes the loot list to a JSON file.
   *
   * @param args program arguments
   */
  public static void main(String[] args) {
    try {
      ObjectMapper mapper = new ObjectMapper();
      Path ruta = Path.of("loot.json");

      List<Item> loot = List.of(
          new Item("Katana", "Legendary", 100),
          new Item("Medkit", "Common", 50),
          new Item("Grenade", "Rare", 300)
      );

      mapper.writerWithDefaultPrettyPrinter()
          .writeValue(ruta.toFile(), loot);

      System.out.println("Loot exported successfully: " + ruta);

    } catch (IOException e) {
      System.out.println("Error: " + e.getMessage());
    }
  }
}