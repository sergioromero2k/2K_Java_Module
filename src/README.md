# Module 06
---

## ex0
* La serialización es el proceso de convertir el estado de un objeto en una secuencia de bytes. Una vez que el objeto se convierte en bytes, puedes: **Guardarlo en un archivo(``.ser``, ``.txt``)**, enviarlo a través de una red a otra máquina.
* La deserialización es el proceso inverso(convertir esos bytes de vuelta en un objeto funcional en la memoria).
* ``.writeObject(...)``: Es el método encargado de tomar cualquier objeto de Java, pasarlo por su proceso interno de conversión y transformarlo en una secuencia de bytes.

Para lograr serializar un objeto en Java, se necesita utilizar 3 elementos principales:
### A. La interfaz ``Serializable(java.io.Serializable)``
* Es una interfaz marcadora(no tiene métodos obligatorios que debes implementar).
* Funciona como un permiso o contrato. Le dice a la máquina virtual de Java (JVM), Esta clase está diseñada para que sus objetos puedan ser convertidos a bytes de forma segura.

### B. FileOutStream (``java.io.FileOutputStream``)
* Un flujo (stream) orientado a bytes enfocado en escribir datos en un archivo en el disco duro.
* Abre un canal de comunicación directo con un archivo específico en tu sistema de ficheros (por ejemplo, ``relic.ser``) para que los datos puedan fluir hacia él.

### C. ObjectOutputStream (``java.io.ObjectOutputStream``)
* Un flujo de alto nivel que envuelve a otro flujo de salida (como ``FileOutputStream``).
* Es el encargado de tomar un objeto de Java, traducirlo a bytes (gracias a que implementa ``Serializable``) y pasárselo al ``FileOutputStream`` para que este último lo escriba físicamente en el archivo.

#### Example:
* ``Tu Objeto (AsgardianRelic):`` Es la reliquia que quieres guardar.
* ``ObjectOutputStream (El empaquetador):`` Es la persona experta que desarma la reliquia, la mete en una caja especial y la prepara en formato de **"paquete de envío" (bytes)**.
* ``FileOutputStream (El camión de transporte):`` Es el vehículo físico que toma ese paquete ya preparado y lo transporta directamente hasta su destino final (el archivo ``relic.ser`` en tu disco).

```
relic
  │
  ▼
oos.writeObject(relic)
  │
  ▼
ObjectOutputStream serializa
  │
  ▼
FileOutputStream.write(byte[])
  │
  ▼
Archivo relic.ser
```

## ex1
* La deserialización es exactamente lo contrario: tomar esa secuencia de bytes guardada en un archivo (``relic.ser``) y reconstruirla en la memoria RAM para que vuelva a ser un objeto de Java totalmente funcional, conservando sus atributos originales.

### Las Piezas Clave del Rompecabezas
* ``FileInputStream`` un flujo orientado a bytes enfocado en leer datos desde un archivo en el disco duro, abre el archivo existente, para que sus bytes puedan ser leídos por tu programa.
* ``ObjectInputStream`` un flujo de alto nivel que envuelve al `FileInputStream` lee los bytes del archivo y los reconstruye en la memoria transformándolos de nuevo en un objeto de Java.

## ex2
* Cada clase serializable tiene un identificador de versión (``serialVersionUID``). Si no lo declaras, Java lo calcula automáticamente en base a la estructura de la clase(campos, métodos, etc.).
* **El problema** si cambias la clase (añades un campos, por ejemplo) y el UID calculado cambia, al intentar deserializar un objeto antiguo obtienes ``InvalidClassException``, porque Java detecta que la versión guardada no coincide con la versión actual de la clase.
```java
class Config implements Serializable {
  private static final long serialVersionUID = 1L; // fijo, no cambia aunque edites la clase
  int value;
} 
```

## ex3
* **Serializable** no significa que el objeto se guarde automáticamente. Solo significa que Java sabe cómo convertir ese objeto en una secuencia de bytes.
* ``ArrayList`` es serializable si los objetos que contiene también implementan ``Serializable``, toda la lista puede serializarse.
* ``printStackTrace()`` sirve para imprimir toda la información de una excepción, incluyendo dónde ocurrió.
```java
ArrayList<String> names = new ArrayList<>();

names.add("Odin");
names.add("Thor");
names.add("Loki");

oos.writeObject(names);

// Deserializar la lista
ArrayList<String> names =
    (ArrayList<String>) ois.readObject();

for (String name : names) {
    System.out.println(name);
}
```

```
Objeto
   │
   ▼
ObjectOutputStream
   │
   ▼
¿Dónde los escribo?
```
El destino puede ser:
* Un archivo (FileOutputStream) ← el caso de vuestro ejercicio.
* La red (un Socket).
* Memoria (ByteArrayOutputStream).
* Cualquier otro OutputStream.

## ex4