package ex6;

import java.util.Optional;

/**
 * Validates mercenary identities using Optional filtering.
 */
public class IdentityGuard {

  /**
   * Main method that checks if aliases are valid.
   *
   * @param args program arguments
   */
  public static void main(String[] args) {
    Optional<String> resultado = Optional.of("ShadowHunter")
        .filter(a -> a.length() > 5);

    Optional<String> resultado2 = Optional.of("Rex")
        .filter(a -> a.length() > 5);

    if (resultado.isPresent()) {
      System.out.println("Identity accepted: " + resultado.get());
    } else {
      System.out.println("Identity rejected: alias too short");
    }

    if (resultado2.isPresent()) {
      System.out.println("Identity accepted: " + resultado2.get());
    } else {
      System.out.println("Identity rejected: alias too short");
    }
  }
}