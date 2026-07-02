# Jerarquía completa + implementación + instanciación
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