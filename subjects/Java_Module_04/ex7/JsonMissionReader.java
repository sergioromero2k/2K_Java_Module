package ex7;

import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.IOException;
import java.nio.file.Path;

/**
 * Reads a mission from a JSON file using Jackson.
 */
public class JsonMissionReader {

  /**
   * Main method that loads and displays mission data.
   *
   * @param args program arguments
   */
  public static void main(String[] args) {
    try {
      ObjectMapper mapper = new ObjectMapper();
      Path ruta = Path.of("src/ex7/mission.json");

      Mission mision = mapper.readValue(ruta.toFile(), Mission.class);

      System.out.println("Mission loaded successfully:\n");
      System.out.println("Name: " + mision.name());
      System.out.println("Mercenary: " + mision.mercenary());
      System.out.println("Difficulty: " + mision.difficulty());
      System.out.println("Reward: " + mision.reward());

    } catch (IOException e) {
      System.out.println("Error reading JSON: " + e.getMessage());
    }
  }
}