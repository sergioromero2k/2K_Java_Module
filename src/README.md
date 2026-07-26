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
try (
    Recurso r1 = ...;
    Recurso r2 = ...
) {

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