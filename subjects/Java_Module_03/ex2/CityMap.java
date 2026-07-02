package ex2;

import java.util.HashMap;

/**
 * Handles the mapping and searching of city locations.
 */
public class CityMap {

  /**
   * Searches for a location in the map and prints the result.
   *
   * @param map   the map of locations
   * @param place the name of the place to search
   */
  public static void searchLocation(HashMap<String, String> map, String place) {
    if (map.containsKey(place)) {
      System.out.println("Search: '" + place + "' -> Found: " + map.get(place));
    } else {
      System.out.println("Search: '" + place + "' -> Error: This location is not discovered yet.");
    }
  }

  /**
   * Entry point of the application.
   *
   * @param args command line arguments
   */
  public static void main(final String[] args) {
    HashMap<String, String> map = new HashMap<>();
    map.put("Inn", "Located at the North Plaza");
    map.put("Guild", "Located at the Town Center");
    map.put("Blacksmith", "Located near the East Gate");
    map.put("Market", "Located in the South District");

    System.out.println("=== PIXEL CITY GPS === ");
    System.out.println("Registering locations...");
    searchLocation(map, "Inn");
    searchLocation(map, "Graveyard");
    System.out.println("\nTotal locations in map: " + map.size());
  }
}