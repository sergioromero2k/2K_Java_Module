package exB;

import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.function.BinaryOperator;

/**
 * Calculates loot information using Stream reduce operations.
 */
public class LootReducer {

  /**
   * Main method that calculates total loot value and finds the most valuable item.
   *
   * @param args program arguments
   */
  public static void main(String[] args) {
    List<Item> loot = List.of(
        new Item("Katana", 100),
        new Item("Medkit", 50),
        new Item("Grenade", 300),
        new Item("Gold Coin", 500)
    );

    int total = loot.stream()
        .map(Item::value)
        .reduce(0, Integer::sum);

    System.out.println("Total loot value: " + total);

    Optional<Item> masValioso = loot.stream()
        .reduce(BinaryOperator.maxBy(Comparator.comparing(Item::value)));

    masValioso.ifPresent(item ->
        System.out.println(
            "Highest value item: "
                + item.name()
                + " ("
                + item.value()
                + ")"
        ));
  }
}