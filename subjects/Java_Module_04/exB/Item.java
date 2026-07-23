package exB;

/**
 * Represents a loot item with a name and value.
 *
 * @param name the item name
 * @param value the item value
 */
public record Item(
    String name,
    int value
) {
}