# Module 05
---

## ex0
Un **recurso** es cualquier objeto que necesita ser abierto y posteriormente cerrado o liberado. 
La idea es que un recurso ocupa memoria o recursos del sistema operativo y, cuando termina de usarse, debe cerrarse correctamente.

Ejemplos comunes:
* Un archivo.
* Una conexión a una base de datos.
* Un socket de red.
* Un escáner (``Scanner``).
* Una cámara de contención.

``AutoCloseable`` es una interfaz de Java (desde Java 7) con un único método abstracto: `void close() throws Exception`. Cualquier clase que la implemente puede usarse dentro de un `try (...)` el llamado `try-with-resources`.
Al salir del bloque ``try`` (de forma normal o por excepción), Java llama automáticamente a `close()` sin que tú lo invoques.
Java introdujo esta interfaz para indicar que un objeto se ``puede cerrarse automáticamente``..

* Una interfaz es un contrato, si quieres implementarla, debes proporcionar determinados métodos.
* Una **Excepción** es un error que ocurre durante la ejecución del programa.

El orden es:
* Se ejecuta el ``try``.
* Luego, antes de cualquier ``catch/finally``.
* Luego java invoca ``close()``.

```java
class FileHandle implements AutoCloseable {
  public FileHandle() {
    System.out.println("Archivo abierto.");
  }

  @Override
  public void close() {
    System.out.println("Archivo cerrado.");
  }
}

public class Demo {
  public static void main(String[] args) {
    try (FileHandle f = new FileHandle()) {
      System.out.println("Usando el archivo...");
    } // <- aquí Java llama a close() automáticamente
  } 
}
```

## ex1
* Este ejercicio no introduce conceptos nuevos de ``AutoCloseable``, sino que quiere que entiendas cómo interactúan las excepciones con `try-with-resources`
* ``throw`` sirve para lanzar una excepción, no captura errores, los provoca.

## ex2
Este ejercicio introduce el concepto de trabajar con varios recursos a la vez y entender en qué orden los cierra Java.
```java
// Declaración múltiple en la cabecera
try (Recurso a = new Recurso("A"); Recurso b = new Recurso("B")) {
    System.out.println("Trabajando...");
}

// Bloques try anidados
try (Recurso a = new Recurso("A")) {
  try (Recurso b = new Recurso("B")) {
        System.out.println("Trabajando...");
    }
}

// Variables efectivas finales (desde Java 9)
Recurso a = new Recurso("A");
Recurso b = new Recurso("B");
try (a; b) {
  System.out.println("Trabajando...");
}
```
Muchos programas necesitan más de un recurso al mismo tiempo.
Ejem:
* Dos archivos.
* Una conexión a una base de datos y un archivo.
* Dos sockets de red.
* Dos cámaras de contención (como en el ejercicio).

**¿En qué orden se abren?** -> Los recursos se crean de izquierda a derecha. (Arriba-abajo).
**¿En qué orden se cierran?** -> Los recursos se cierran en el orden inverso al que fueron creados. (Abajo-Arriba).
```json
Abrir A
↓
Abrir B
↓
Cerrar B
↓
Cerrar A
```
## ex3
### Excepciones personalizadas lanzadas desde ``close()``
* ``close()`` puede declarar `thorws AlgunaExcepcion`.
* Si es una excepción de checked (comprobada), quien use el recurso en un ``try-with-resources`` debe capturarla o propagarla.
* Para crear una excepción personalizada, se extiende normalmente de ``Excepcion`` (checked) o `RuntimeException` (unchecked).

```java
class MiExcepcion extends Exception {
    public MiExcepcion(String mensaje) {
        super(mensaje);
    }
}
```
* Si ``close()`` lanza una excepción, y el bloque try también había lanzado otra excepción antes, Java no pierde ninguna: la excepción del try es la "principal" y la de close() queda registrada como excepción suprimida (suppressed exception), accesible con getSuppressed(). Pero si el try no lanza nada y solo falla close(), esa excepción de close() se propaga normalmente.

### Ejemplo genérico
```java
class MiExcepcion extends Exception {
    public MiExcepcion(String msg) { super(msg); }
}

class Recurso implements AutoCloseable {
    private int nivel;
    public Recurso(int nivel) { this.nivel = nivel; }

    @Override
    public void close() throws MiExcepcion {
        if (nivel > 100) {
            throw new MiExcepcion("Nivel crítico al cerrar!");
        }
        System.out.println("Cerrado sin problemas.");
    }
}

public class Demo {
    public static void main(String[] args) {
        try (Recurso r = new Recurso(150)) {
            System.out.println("Usando recurso...");
        } catch (MiExcepcion e) {
            System.out.println("Excepción controlada: " + e.getMessage());
        }
    }
}
```

* ``AutoCloseable`` permite que `close()` lance excepciones.
La interfaz está definida así:
```java
public interface AutoCloseable {
  void close() throws Exception;
}
// Siempre que MiExcepcion sea compatible con Exception.
```

### Excepción personalizada
* Las **excepciones personalizadas** son simplemente clases.
```java
throw new RuntimeException(...);  // Ahora crearás tu propia excepción...
// Las excepciones personalizadas son simplemente clases.

public class MiExcepcion extends Exception {
}
public class MiExcepcion extends RuntimeException {
}
```

## ex4
* Antes de Java 7 (cuando no existía el try-with-resources), la gestión de recursos que requerían cierre explícito (como conexiones a bases de datos, ficheros o sockets) se realizaba obligatoriamente mediante la estructura try-finally.
* Cuando abres un recurso, este consume memoria o canales del sistema operativo. Si ocurre una excepción durante su uso, el flujo del programa salta inmediatamente al bloque catch o sale del método, saltándose cualquier código posterior.
* Si no cerrabas el recurso en un bloque finally, este quedaba abierto indefinidamente, provocando fugas (leaks) y bloqueando sistemas.

```java
// 1. Declarar la variable fuera del try para que tenga alcance en el finally
MiRecurso recurso = null;

try {
    // 2. Abrir el recurso y realizar operaciones que pueden fallar
    recurso = new MiRecurso();
    recurso.abrir();
    
    // Simulamos un error
    if (true) {
        throw new RuntimeException("¡Fallo inesperado!");
    }
    
    recurso.trabajar();

} finally {
    // 3. Garantizar el cierre manual
    if (recurso != null) {
        recurso.cerrar(); // Se ejecuta sí o sí, haya o no excepción
    }
}
```

## ex05
---
Para resolver este ejercicio(el informe de reflexión), debes contraponer el pasado y el presente de la gestión de recurso en Java basándose en 2 grandes ejes.
**La seguridad**/**Limpieza del código** y **el manejo de excepciones (supresión)**.

### 1. El Enfoque Tradicional (try-finally)
Obliga al desarrollador a declarar la variable fuera del ``try``, abrirla dentro, y llamar manualmente al método de cierre(`close()`) dentro del bloque `finally` validando que no sea `nula`.

#### Problemas principales
* Código repetitivo y propenso a errores(boilerplate).
* El peligro de las excepciones ocultas (**Exception Suppression/Masking**).
* Olvido humano, si el programador olvidaba el bloque ``finally`` o validación del `null`.

### 2. El Enfoque Moderno (try-with-resources y AutoCloseable)
Llegó en Java 7 para automatizar por completo este proceso implementando la interfaz ``AutoCloseable``.

#### Ventajas principales
* Código limpio y seguro, los recursos se declaran en la cabecera del ``try`` y Java se encarga de cerrarlos de forma automática al salir del bloque.
* Gestión inteligente de excepciones (Supresión de excepciones).
* Orden inverso, cierra los recursos automáticamente en orden inverso al de su apertura.
