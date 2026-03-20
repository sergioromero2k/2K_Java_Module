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
│     └── Vector (implementa List)
│            → List<String> l = new Vector<>();
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
├── PriorityQueue (implementa Queue)
│      → Queue<String> q = new PriorityQueue<>();
│
└── ArrayDeque (implementa Queue)
→ Queue<String> q = new ArrayDeque<>();


Map (interfaz)  ❗ NO pertenece a Collection
├── HashMap (implementa Map)
│      → Map<String, Integer> m = new HashMap<>();
│
├── LinkedHashMap (implementa Map)
│      → Map<String, Integer> m = new LinkedHashMap<>();
│
└── TreeMap (implementa Map)
→ Map<String, Integer> m = new TreeMap<>();
```