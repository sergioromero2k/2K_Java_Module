package ex0;

/**
 * Represents an adventurer in the party.
 *
 * @param name  the name of the adventurer
 * @param level the current level of the adventurer
 * @param role  the character class or role
 */
public record Adventurer(String name, int level, String role) {
}