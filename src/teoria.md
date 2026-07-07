### ex0
* **Path** representa la ubicación de un archivo o carpeta en tu sistema.
* Path.of(...) es el método moderno (Java 11+) para crear un Path.
* **Files** es una clase con métodos estáticos (no necesitas crear un objeto, los llamas directo desde la clase) para hacer operaciones sobre archivos: leerlos, escribirlos, comprobar si existen, etc.
* **Files.lines(Path)** método lee un archivo línea por línea y te devuelve un Stream<String> — cada elemento del stream es una línea del archivo.
* Un **Stream** es diferente: no guarda datos, es una especie de "tubería" por la que los datos pasan, uno por uno, para que les apliques operaciones.
* **IOException** leer archivos es una operación que puede fallar (el archivo no existe, no tienes permisos, está corrupto, etc.). Por eso, Files.lines() puede lanzar una IOException.

```java
import java.nio.file.Path;

Path ruta = Path.of("datos.txt"); // busca "datos.txt" en la carpeta del proyecto
List<String> nombres = List.of("Ana", "Luis", "Marta");

// Rutas absolutas
Path ruta = Path.of("C:\\Users\\Sergio\\Documents\\mision.txt");
// Rutas relativas
Path ruta = Path.of("ex0", "mision.txt"); // busca en la carpeta ex0/mision.txt

boolean existe = Files.exists(ruta); // true/false, ¿existe ese archivo?
// La operación más simple sobre un Stream: .forEach()
lineas.forEach(linea -> System.out.println(linea)); // linea -> System.out.println(linea) es una lambda — una función anónima

Stream<String> stream = nombres.stream();
stream.forEach(nombre -> System.out.println(nombre));
// Ana
// Luis
// Marta
```

```java
// Opción A: try-catch
try {
    Stream<String> lineas = Files.lines(ruta);
    lineas.forEach(linea -> System.out.println(linea));
} catch (IOException e) {
    System.out.println("Error leyendo el archivo: " + e.getMessage());
}
// Opción B: declarar que tu método puede lanzar la excepción (más simple para un ejercicio pequeño)
public static void main(String[] args) throws IOException {
  // aquí puedes usar Files.lines() sin try-catch
}
```
### Detalle importante: cerrar el Stream (try-with-resources)
Un Stream<String> que viene de Files.lines() está conectado a un recurso externo (el archivo abierto en el sistema operativo). Es una buena práctica cerrarlo después de usarlo, para liberar ese recurso.
La forma recomendada es usar try-with-resources, que cierra automáticamente el stream al terminar, incluso si hay un error:
```java
try (Stream<String> lineas = Files.lines(ruta)) {
    lineas.forEach(linea -> System.out.println(linea));
} catch (IOException e) {
    System.out.println("Error: " + e.getMessage());
}
```