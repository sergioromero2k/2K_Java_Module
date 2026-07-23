package ex8;

/**
 * Represents a loot item that can be exported to JSON.
 *
 * @param name the item name
 * @param rarity the item rarity
 * @param value the item value
 */
public record Item(
    String name,
    String rarity,
    int value
) {
}