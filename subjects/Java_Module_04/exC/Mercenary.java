package exC;

import java.util.List;

/**
 * Represents a mercenary with a list of weapons.
 *
 * @param name mercenary name
 * @param weapons available weapons
 */
public record Mercenary(
    String name,
    List<String> weapons
) {
}