package exercise;

/**
 * Represents an immutable adventurer.
 *
 * @param name The character's name.
 * @param level The current experience level.
 * @param role The class/job of the adventurer.
 */
public record Adventurer(String name, int level, String role) {}
