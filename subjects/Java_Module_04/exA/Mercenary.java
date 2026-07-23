package exA;

/**
 * Represents a mercenary with a name and faction.
 *
 * @param name the mercenary name
 * @param faction the mercenary faction
 */
public record Mercenary(
    String name,
    String faction
) {
}