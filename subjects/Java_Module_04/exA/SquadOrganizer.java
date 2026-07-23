package exA;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * Organizes mercenaries by faction using Stream collectors.
 */
public class SquadOrganizer {

  /**
   * Main method that groups mercenaries and counts them by faction.
   *
   * @param args program arguments
   */
  public static void main(String[] args) {
    List<Mercenary> mercenarios = List.of(
        new Mercenary("Deadpool", "Mercs for Money"),
        new Mercenary("Cable", "X-Force"),
        new Mercenary("Domino", "X-Force"),
        new Mercenary("Taskmaster", "Freelance"),
        new Mercenary("Weasel", "Mercs for Money")
    );

    Map<String, List<Mercenary>> agrupados = mercenarios.stream()
        .collect(Collectors.groupingBy(Mercenary::faction));

    Map<String, Long> contador = mercenarios.stream()
        .collect(Collectors.groupingBy(
            Mercenary::faction,
            Collectors.counting()
        ));

    agrupados.forEach((faction, members) -> {
      System.out.println(faction + ":");

      members.forEach(mercenary ->
          System.out.println(" - " + mercenary.name()));
    });

    System.out.println("\nMercenary count by faction:");

    contador.forEach((faction, number) ->
        System.out.println(faction + " -> " + number));
  }
}