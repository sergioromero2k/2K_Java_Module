# Teoria - Module 03

## Jerarquía completa + implementación + instanciación
```
java.lang.Iterable
└── Collection
    ├── List (interfaz)
    │     ├── ArrayList (implementa List)
    │     │      → List<String> l = new ArrayList<>();
    │     │      → ArrayList<String> l = new ArrayList<>();
    │     │
    │     ├── LinkedList (implementa List)
    │     │      → List<String> l = new LinkedList<>();
    │     │
    │     ├── Vector (implementa List)
    │     │      → List<String> l = new Vector<>();
    │     │
    │     └── Stack (extiende Vector)
    │            → Stack<String> s = new Stack<>();
    │
    ├── Set (interfaz)
    │     ├── HashSet (implementa Set)
    │     │      → Set<String> s = new HashSet<>();
    │     │
    │     ├── LinkedHashSet (implementa Set)
    │     │      → Set<String> s = new LinkedHashSet<>();
    │     │
    │     └── TreeSet (implementa Set)
    │            → Set<String> s = new TreeSet<>();
    │
    └── Queue (interfaz)
          ├── Deque (interfaz)  ← extiende Queue
          │     ├── ArrayDeque (implementa Deque)
          │     │      → Deque<String> d = new ArrayDeque<>();
          │     │      → Queue<String> q = new ArrayDeque<>();
          │     │      → ArrayDeque<String> a = new ArrayDeque<>();
          │     │
          │     └── LinkedList (implementa Deque)
          │            → Deque<String> d = new LinkedList<>();
          │
          └── PriorityQueue (implementa Queue)
                 → Queue<String> q = new PriorityQueue<>();


Map (interfaz)   NO pertenece a Collection
├── HashMap (implementa Map)
│      → Map<String, Integer> m = new HashMap<>();
│
├── LinkedHashMap (implementa Map)
│      → Map<String, Integer> m = new LinkedHashMap<>();
│
└── TreeMap (implementa Map)
       → Map<String, Integer> m = new TreeMap<>();
```

## ex0
* Un record es una forma simplificada de crear clases inmutables (datos puros).
* Se usa cuando solo quieres almacenar datos, no lógica compleja, va en otro archivo.
```java
public record Adventurer(String name, int level, String role) {}
```

## ex1
* HashSet<T> colección que guarda elementos únicos (sin duplicados).
### Características
* No permite duplicados
* No tiene índices
* No garantiza orden

## ex2
* Estructura que guarda pares clave → valor.
### Características
* Busca datos por clave (muy rápido).
* No importa el orden.
* Cada clave es única.

## ex3
* Una **Queue** es una estructura de datos que sigue el principio FIFO (First In, First Out — "el primero que entra es el primero que sale").
* En Java, Queue es una interfaz, define el comportamiento, pero necesitas una clase concreta que la implemente.
* **Deque** significa "Double Ended Queue" (cola de doble extremo). Es una versión más flexible que una cola normal: te permite agregar y quitar elementos por ambos extremos — el inicio (First) y el final (Last)


### ArrayDeque
* **ArrayDeque**  es una implementación de Deque basada en un array redimensionable (a diferencia de LinkedList que también implementa Deque pero usa nodos enlazados).
```java
ArrayDeque<String> dungeonQueue = new ArrayDeque<>();
```
* .addLast(elemento) — agregar al final
* .addFirst(elemento) — agregar al inicio
* .pollFirst() — sacar y devolver el primer elemento
* .peekFirst() — "espiar" el primer elemento sin sacarlo
* .isEmpty() — comprobar si la cola está vacía

### ¿Por qué NO usar ArrayList para esto?
El enunciado te lo prohíbe explícitamente, y hay una razón técnica de fondo: en un ArrayList, los elementos están guardados en posiciones contiguas de memoria (como un array). Si eliminas el primer elemento, Java tiene que recorrer y desplazar todos los demás elementos una posición hacia atrás para llenar el hueco — eso es una operación lenta (O(n)).
En cambio, ArrayDeque está diseñado específicamente para que agregar/quitar en los extremos sea rápido (O(1) amortizado), porque no necesita desplazar nada — solo mueve punteros internos.

## ex4
* Una **Stack** sigue el principio LIFO **(Last In, First Out — "el último que entra es el primero que sale").**
* Piensa en una pila de platos: si apilas platos uno encima del otro, el único que puedes sacar sin problemas es el de arriba, que es justamente el último que pusiste.
* Stack es una clase que Java trae desde sus primeras versiones (es "legacy", antigua), y representa justo esta estructura de pila.

```java
Stack<String> spellStack = new Stack<>();
spellStack.push("Fireball");        // .push(elemento) — apilar (agregar arriba de todo)
String ultimo = spellStack.pop();   // .pop() — desapilar (sacar y devolver el de arriba)
String cima = spellStack.peek();    // .peek() — ver la cima sin sacarla
if (!spellStack.isEmpty()) {        // .isEmpty() — comprobar si la pila está vacía
    spellStack.pop();
}
```

### ¿Por qué no usar ArrayList aunque también podrías simular esto?
* Técnicamente un ArrayList tiene métodos como .add() (al final) y .remove(size()-1) (el último), con los cuales podrías simular una pila.
* Pero el ejercicio te lo prohíbe a propósito por una razón pedagógica: quiere que uses el vocabulario y la semántica específicos de una pila (push/pop/peek), que comunican la intención del código de forma mucho más clara que manipular índices a mano. Es una cuestión de expresividad y buenas prácticas, no solo de que "funcione".

## ex6

* String.split(",") — partir un texto en pedazos
* String.trim() — quitar espacios sobrantes
* .clear() es un método nuevo: vacía completamente la lista, dejándola con tamaño 0.
* .add(0, elemento) — insertar en una posición específica
  .startsWith(texto) — comprobar cómo empieza un String, "urgent:shield".startsWith("urgent:"); // true

| Tipos primitivos | Wrapper equivalente |
|------------------|---------------------|
| int              | Integer             |
| double           | Double              |
| boolean          | Boolean             |
| char             | Character           |
| long             | Long                |
| float            | Float               |
| byte             | Byte                |
| short            | Short               |
