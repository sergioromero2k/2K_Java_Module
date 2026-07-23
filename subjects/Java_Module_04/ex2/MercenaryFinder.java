package ex2;

import java.util.List;

/**
 * Finds mercenaries in a list of names.
 */
public class MercenaryFinder {

  /**
   * Searches for a mercenary by name.
   *
   * @param mercenarios list of mercenary names
   * @param nombre name to search for
   * @return the mercenary name or a default message if not found
   */
  String buscarMercenario(List<String> mercenarios, String nombre) {
    return mercenarios.stream()
        .filter(n -> n.equals(nombre))
        .findFirst()
        .orElse("Mercenario no encontrado...");
  }

  /**
   * Main method to test the mercenary finder.
   *
   * @param args program arguments
   */
  public static void main(String[] args) {
    List<String> mercenarios = List.of(
        "Geralt",
        "Letho",
        "Eskel",
        "Lambert",
        "Coën"
    );

    MercenaryFinder finder = new MercenaryFinder();

    System.out.println(finder.buscarMercenario(mercenarios, "Letho"));
    System.out.println(finder.buscarMercenario(mercenarios, "Ciri"));
  }
}