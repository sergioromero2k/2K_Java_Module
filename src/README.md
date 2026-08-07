# Module 07
---

## ex0
* **Interface** es un contrato que dice quien "implemente esto, promete tener estos métodos", pero no dice cómo deben comportarse, es decir no representa un objeto sino una lista de obligaciones que cualquier clase debe cumplir.
* Esto es 100% abstracción(en su forma clásica, antes de Java8).
* Con ``implements``. La clase se compromete a escribir el cuerpo de todos los métodos de la interfaz.
* Le dice al compilador que debe coincidir exactamente con un método de la interfaz/padre.
* Cuando implementas los métodos de una interfaz debes mantener el modificador en public.

### Tener en cuenta
* El método de la interfaz no puede tener cuerpo(nada de {} con código, ni default).
* La clase que implementa debe dar el cuerpo, o si no, ella misma tendría que ser abstract.

```java
// Contrato: cualquier Vehiculo debe poder acelerar
public interface Vehiculo {
  String acelerar(); // sin cuerpo, termina en ; y ya
}

public class Coche implements Vehiculo {
  @Override
  public String acelerar() {
    return "Vrooom!";
  }
}
```

## ex1
* Si 2 clases distintas implementan la misma interfaz, puedes tratarlas de forma idéntica a través de una variable del tipo de la interfaz, aunque por dentro hagan cosas distintas.
* **Polimorfismo** significa muchas formas, no se usa `instanceof` porque rompe con el polimorfismo.
```java
public interface Instrumento {
  String tocar();
}

public class Guitarra implements Instrumento {
  @Override
  public String tocar() { return "Rasgueo de cuerdas"; }
}

public class Bateria implements Instrumento {
  @Override
  public String tocar() { return "Redoble de tambor"; }
}
```
* **dynamic dispatch o enlace dinámico** la variable i es de tipo ``Instrumento``, pero Java mira el objeto real (`Guitarra` o `Bateria`) para decidir qué código ejecutar, por eso no necesitas `instanceof`: confías en que, sea quien sea, sabe responder a `tocar()`.
* Está prohibido `instanceof` porque rompe la filosofía del polimorfismo, estarías tratando cada tipo de forma especial en vez de confiar en el contrato común.

## ex2
* Antes de Java 8, las interfaces solo podían tener: **métodos sin cuerpo**, pero desde Java 8 pueden contener métodos implementados para ello se usa ``default``.
* ¿Hay que sobrescribirlo?, no puedes usarlo directamente, solo lo sobrescribes si deseas un comportamiento diferente.
```java
public interface Instrumento {
  String tocar(); // sigue siendo abstracto, cada clase lo define

  default void afinar() { // ¡tiene cuerpo!
    System.out.println("Afinando instrumento genérico...");
  }
}

public class Guitarra implements Instrumento {
  @Override
  public String tocar() { return "Rasgueo"; }
  // NO escribo afinar() aquí -> usa el default de la interfaz
}
```
## ex3
* Una clase abstracta es una plantilla a medio de construir: mezcla métodos ya terminados (concretos) con métodos que deja pendientes(abstractos) para que los hijos lo complementen.
* No se puede instanciar directamente con ``new``.
```java
public abstract class Animal {
  // Método CONCRETO: código real, compartido por todos los hijos tal cual
  public void respirar() {
    System.out.println("Inhala... exhala...");
  }

  // Método ABSTRACTO: sin cuerpo, cada hijo decide su propia versión
  public abstract String sonido();
}

// La subclase concreta
public class Perro extends Animal {
  @Override
  public String sonido() {
    return "Guau!";
  }
}

Perro p = new Perro();     // válido
Animal a = new Perro();    // también válido (Perro ES-UN Animal)
// Animal x = new Animal(); // ERROR: no puedes instanciar una clase abstracta
```
* ``extends`` (no `implements`) porque es una clase, no con un contrato puro.
* ``Perro`` hereda `respirar()` tal cual(no puede ni necesita reescribirlo).
* ``Perro`` está obligada a escribir `sonido()`, igual que con una interfaz.

## ex4
* `Interfaces` Se usan cuando varias clases deben compartir un comportamiento común, aunque no tengan relación entre sí.
* `Clase abstracta` se usa cuando todas las clases son variantes de la misma idea.

| Interface                          | Clase abstracta       |
| ---------------------------------- | --------------------- |
| Contrato                           | Base común            |
| Puede implementarse varias veces   | Solo una herencia     |
| No tiene estado (salvo constantes) | Puede tener atributos |
| No tiene constructor               | Sí tiene constructor  |
| Usa `implements`                   | Usa `extends`         |

* **Herencia simple vs múltiple** en Java, ``extends`` solo permite un padre(single inheritance). En cambio, `implements` permite firmar varias interfaces a la vez.
* Una interfaz tradicionalmente no guarda estado propio de instancia (no tiene atributos con valores que cambien por defecto de la forma en lo que hace una clase).
* Una clase abstracta sí puede tener atributos, constructores, y lógica que dependa de ese estado interno.

## ex5
#### Implementar varias interfaces a la vez
* La ventaja frente a ``extends``
* Esto sería imposible con las clases normales (``class Pato extends Ave, Pez``) no compila: solo se permite un padre).
* Las interfaces rompen esa limitación porque no aportan estado ni implementación obligatoria conflictiva, solo contratos.

```java
public interface Volador {
    void volar();
}

public interface Nadador {
    void nadar();
}

// Una clase puede firmar VARIOS contratos, separados por coma:
public class Pato implements Volador, Nadador {
    @Override
    public void volar() {
        System.out.println("El pato vuela bajito.");
    }

    @Override
    public void nadar() {
        System.out.println("El pato nada en el estanque.");
    }
}
```

## ex6
#### Combinar clase abstracta + list polimórfica
* Este ejercicio junta el Ejercicio 3 (clase abstracta) con el Ejercicio 1 (lista + bucle sin ``instanceof``), pero ahora con herencia de clases en vez de interfaces.
```java
public abstract class Animal {
  public void respirar() {
    System.out.println("Inhala... exhala...");
  }
  public abstract String sonido();
}

public class Perro extends Animal {
  @Override
  public String sonido() { return "Guau!"; }
}

public class Gato extends Animal {
  @Override
  public String sonido() { return "Miau!"; }
}

List<Animal> zoo = new ArrayList<>();
zoo.add(new Perro());
    zoo.add(new Gato());

    for (Animal a : zoo) {
    a.respirar();          // idéntico para todos (heredado)
    System.out.println(a.sonido()); // distinto según el objeto real
    }
```

