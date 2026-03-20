package exercise;

import java.util.HashMap;

/**
 * CityMap class manages locations in Pixel City using a HashMap.
 * Goal: Assign coordinates to locations and perform fast lookups.
 */
public class CityMap {
  /**
   * Entry point of the application.
   *
   * @param args Command line arguments (not used).
   */
  public static void main(String[] args) {
    HashMap<String, String> m = new HashMap<>();

    System.out.println("=== PIXEL CITY GPS ===");
    System.out.println("Registering locations...");
    m.put("Inn", "Located at the North Plaza.");
    m.put("Guild", "Located at the Town Center.");
    m.put("Blacksmith", "Located near the East Gate.");
    m.put("Market", "Located in the South District.");
    searchLocation(m, "Inn");
    searchLocation(m, "Graveyard");

    System.out.println("\nTotal locations in map: " + m.size());
  }

  /**
   * Performs a direct lookup in the map.
   *
   * @param map The HashMap containing city data.
   * @param place The name of the location to find.
   */
  public static void searchLocation(HashMap<String, String> map, String place) {
    System.out.print("Search: '" + place + "' -> ");
    if (map.containsKey(place)) {
      System.out.println("Found: " + map.get(place));
    } else {
      System.out.println("Error: This location is not discovered yet.");
    }
  }
}
