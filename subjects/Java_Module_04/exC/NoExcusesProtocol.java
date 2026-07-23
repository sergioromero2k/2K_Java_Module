package exC;

import java.util.List;

/**
 * Protocol for searching mercenaries and extracting their weapons.
 */
public class NoExcusesProtocol {

  /**
   * Finds a mercenary by name.
   *
   * @param mercenary list of available mercenaries
   * @param name mercenary name to search
   * @throws MercenaryNotFoundException if the mercenary does not exist
   */
  public static void buscar(List<Mercenary> mercenary, String name) {
    Mercenary buscado = mercenary.stream()
        .filter(n -> n.name().equals(name))
        .findFirst()
        .orElseThrow(() ->
            new MercenaryNotFoundException("Exception:\nAlias not found: " + name));

    System.out.println("Mercenary found: " + buscado.name());
  }

  /**
   * Program entry point.
   *
   * @param args command line arguments
   */
  public static void main(String[] args) {
    List<Mercenary> mercenary = List.of(
        new Mercenary("Deadpool", List.of("Katana", "Pistol", "Grenade")),
        new Mercenary("Cable", List.of("Rifle", "Knife")),
        new Mercenary("Domino", List.of("Sniper Rifle", "Pistol")),
        new Mercenary("Taskmaster", List.of("Sword", "Shield"))
    );

    buscar(mercenary, "Deadpool");

    try {
      buscar(mercenary, "Wolverine");
    } catch (MercenaryNotFoundException e) {
      System.out.println(e.getMessage());
    }

    System.out.println();

    List<String> weapons = mercenary.stream()
        .flatMap(m -> m.weapons().stream())
        .distinct()
        .toList();

    System.out.println("Weapons available:");

    for (String weapon : weapons) {
      System.out.println(weapon);
    }
  }
}