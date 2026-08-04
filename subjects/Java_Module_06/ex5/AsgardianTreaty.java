package ex5;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import java.io.File;
import java.io.IOException;
import java.util.List;

/**
 * Generates a JSON file containing a list of Asgardian relics.
 */
public class AsgardianTreaty {

  /**
   * Creates a list of items and writes it to a formatted JSON file.
   *
   * @param args command-line arguments (not used)
   */
  public static void main(String[] args) {
    List<Item> asgardianRelics = List.of(
        new Item("Mjolnir", 9000),
        new Item("Gungnir", 8500)
    );

    ObjectMapper objectMapper = new ObjectMapper();

    // Enable pretty-print formatting.
    objectMapper.enable(SerializationFeature.INDENT_OUTPUT);

    File file = new File("treasury.json");

    try {
      objectMapper.writeValue(file, asgardianRelics);
      System.out.println("JSON file generated successfully with pretty print.");
    } catch (IOException e) {
      e.printStackTrace();
    }
  }
}
