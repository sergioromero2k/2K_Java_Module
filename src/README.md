# Teoria - Module 04
---

## ex0 - El guion de la misión
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

## ex01 - Limpiando la Escena del Crimen

### ```Stream.filter()``` - quedarte solo con lo que cumple la condición.
**filter()** recibe una condición(una lambda que devuelve true/false) y descarta todos los elementos que no la cumplan.
Solo dejan pasar los que devuelven ```true```.
```java
List<String> palabras = List.of("Gato","Perro","Gallina","Pez");

palabras.stream()
    .filter(palabra -> palabra.length() > 4) // solo palabras con más de 4 letras
    .forEach(System.out::println);
```

### ```Stream.map()``` - transformar cada elemento en otra cosa.
**map()** recibe una función que transforma cada elemento en otro valor (puede ser del mismo tipo o de un tipo distinto), y lo reemplaza en el stream.

```java
List<String> nombres = List.of("ana", "luis", "marta");

nombres.stream()
    .map(nombre -> nombre.toUpperCase()) // transforma cada String a mayúsculas
    .forEach(System.out::println);

// ANA
// LUIS
// MARTA
```

## ex02 - El buscador de Mercenarios
* Un **stream** en Java es una forma de recorrer y procesar colecciones de datos(listas, conjuntos, etc.) de manera más declarativa, sin escribir bucle `for` manualmente.
* Piensa en un stream como una cadena de operaciones por la que pasan los elementos de una colección.

```java
List<String> nombres = List.of("Ana", "Luis", "Pedro", "María");
String resultado = nombres.stream()
    .filter(nombre -> nombre.startsWith("P"))
    .findFirst()
    .orElse("No encontrado");
```
A partir de ahí puedes hacer operaciones como:
* ``filter()`` → quedarse solo con algunos elementos.
* ``map()`` → transformar los elementos.
* ``sorted()`` → ordenarlos.
* ``findFirst()`` → obtener el primero.
* ``count()`` → contar cuántos hay.

```java
import java.util.List;

public class Main {
    public static void main(String[] args) {

        List<String> mercenarios = List.of(
                "Geralt - Nivel 50",
                "Letho - Nivel 45",
                "Eskel - Nivel 38",
                "Lambert - Nivel 40"
        );

        String resultado = mercenarios.stream()
                .filter(m -> m.contains("Letho"))
                .findFirst()
                .orElse("Mercenario no encontrado");

        System.out.println(resultado);
    }
}
```
## ex03 - El Almacén de Deadpool (I/O — escribir archivos)
* ```Files.write()``` - escribir contenido en un archivo.
* Es el hermano opuesto de ``Files.lines()``: en vez de leer, escribe una lista de líneas en un archivo.

```java
List<String> lineas = List.of("Espada +5", "Escudo mágico", "Poción");
Files.write(Path.of("salida.txt"), lineas);
```
Esto crea(o sobreescribe) ``salida.txt`` con cada elemento de la lista como una línea separada.

### ```try-with-resources``` para escritura
* Aunque Files.write() en su forma simple no necesita try-with-resources explícito (se abre/cierra internamente).
* El problema es que si ocurre un error antes no logra cerrar, es decir write.close()

El enunciado lo exige como práctica — probablemente usando un BufferedWriter o similar:
```java
try (BufferedWriter writer = Files.newBufferedWriter(Path.of("salida.txt"))) {
    writer.write("contenido");
} catch (IOException e) {
    System.out.println("Error: " + e.getMessage());
}
```

### ``Collectors.toList()`` — convertir un Stream de vuelta a una List
```java
List<String> filtrados = items.stream()
    .filter(item -> /* condición de "valor" */)
    .collect(Collectors.toList());
```

## ex04 - Filtrado de Hechizos(Streams avanzados)
* ```Stream.distinct()``` - eliminar duplicados dentro de un Stream.
* ```Stream.sorted()``` - ordenar los elementos del Stream.
* ```Comparator``` - ordenar con reglas personalizadas.

```java
// ordena por longitud del texto
hechizos.stream()
    .sorted(Comparator.comparing(String::length)) // ordena por longitud del texto
    .forEach(System.out::println);

// Para orden alfabético descendente (Z→A):
hechizos.stream()
    .sorted(Comparator.reverseOrder())
    .forEach(System.out::println);
```

## ex05 - Conversión de Datos(Map + Method References)
* ```map``` transforma tipos.

### Method References (::) — una forma más corta de escribir lambdas
```java
// Lambda normal
textos.stream().map(texto -> Integer.parseInt(texto));

// Method reference equivalente (misma cosa, más corto)
textos.stream().map(Integer::parseInt);
```
### Tipos de Method References que existen (para que reconozcas la sintaxis)
| Tipo | Ejemplo equivalente en lambda |
|------|-------------------------------|
| Método estático | `Integer::parseInt` → `x -> Integer.parseInt(x)` |
| Método de instancia sobre el parámetro | `String::toUpperCase` → `x -> x.toUpperCase()` |
| Constructor | `Adventurer::new` → `x -> new Adventurer(x)` |

## ex06 - Validación de Identidad (Optional.filter())
* ``Optional.filter()`` - aplicar una condición dentro del Optional.
* ``Optional.isPresent()`` - comprobar si sigue teniendo valor.

```java
Optional<String> alias2 = Optional.of("Rex");

Optional<String> resultado2 = alias2.filter(a -> a.length() > 5);
// resultado2 está VACÍO ahora, aunque "Rex" existía, porque NO cumplió la condición

if (resultado.isPresent()) {
    System.out.println("Alias válido");
}
```
## ex07 - El informe del Sindicato (Leer JSON con Jackson)
* JSON - un formato de texto para representar datos estructurados, muy usados para intercambiar información entre sistemas (APIs, archivos de configuración, etc).
* Se parece a un Map (claves con valores), pero es texto plano — cualquier lenguaje de programación puede leerlo.

```json
{
  "title": "Rescatar al rehén",
  "difficulty": 8,
  "location": "Bosque Norte"
}
```
### Jackson y ``ObjectMapper`` - convertir JSON a objetos automáticamente
* Jackson es una librería externa que Java usa muchisimo (Spring Boot la usa por debajo, de hecho para convertir tus `record` a JSON en las respuestas web que ya viste). 
* De Jackson su clase principal es ``ObjectMapper``.
* Un ``record`` es una forma compacta de crear una clase que solo guarda datos, sin necesitar escribir constructor, getters, equals, toString(), etc a mano.
* Técnicamente también funcionaría con una class tradicional con getters/setters. Pero record es la opción moderna y preferida porque es menos código.
* Con ``record`` estamos definiendo el molde("la plantilla") de qué forma va a tener un objeto Mission. Es solo definición de la estructura.
* 
```java
// Ejemplo de record
public record Mission(String title, int difficulty, String location ) {}

// La conexión con JSON: los 2 tienen la misma forma
/*
{
    "title": "Rescatar al rehén",
    "difficulty": 8,
    "location": "Bosque Norte"gi
    }
*/

import com.fasterxml.jackson.databind.ObjectMapper;

ObjectMapper mapper = new ObjectMapper();
Mission mision = mapper.readValue(new File("mission.json"), Mission.class);
```