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
Por defecto, todos los atributos(variables de instancia) no estáticos y no transitorios de un objeto serializable guardan automáticamente durante la serialización. Sin embargo, en aplicaciones reales, hay datos que no deben persistir por motivos de seguridad o lógica.
* Contraseñas (``Password``).
* Código de activación.
* Conexiones abiertas a base de datos (``Connection``).
* Hilos de ejecución (``Thread``).

### transient
* La palabra reservada ```transient``` se utiliza como un modificación en la declaración de un atributo para indicarte al mecanismo de serialización de Java.
* Durante la serialización el valor del atributo ```transient``` se omite y no escribe en el flujo de bytes.
* Durante la deserialización como el atributo no fue guardado, Java le asigna su valor por defecto según su tipo de dato.

```java
import java.io.*;

// 1. La clase debe implementar Serializable
public class BankAccount implements Serializable {
    private static final long serialVersionUID = 1L;

    private String accountNumber;
    
    // 2. Usamos 'transient' para evitar que el PIN se serialice
    private transient String pinCode; 

    public BankAccount(String accountNumber, String pinCode) {
        this.accountNumber = accountNumber;
        this.pinCode = pinCode;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public String getPinCode() {
        return pinCode;
    }

    public void setPinCode(String pinCode) {
        this.pinCode = pinCode;
    }
}
```
## ex5
* JSON es un formato de intercambio de datos ligero, basado en texto y legible por humanos.
* A diferencia de la serialización binaria nativa de Java (``ObjectOutputStream``), que solo puede ser leída por programas desarrollados en Java.
* JSON es universal: cualquier lenguaje de programación moderno puede leerlo y escribirlo fácilmente.

### Jackson 
* Es una de las librerías más populares y potentes de java para procesar JSON.

* Su clase principal es ObjectMapper, la cual se encarga de:
* **Serialización (Object to JSON):** Convertir objetos o colecciones de Java (como listas o mapas) en texto JSON.
* **Deserialización (JSON to Object):** Convertir texto JSON nuevamente en objetos de Java.

### Pretty Print
* Cuando un programa genera JSON, suele hacerlo en una sola línea continua para ahorrar espacio, lo cual dificulta su lectura.
* El **Pretty Print (impresión bonita)** formatea el texto añadiendo saltos de línea e indentación (espacios de tabulación), logrando una estructura jerárquica clara y fácil de leer para cualquier persona.
* ``ObjectMapper``: Es el motor principal que procesa la conversión.
* ``objectMapper.writeValue(file, inventory)``: Reemplaza al tradicional ObjectOutputStream. Toma la lista y la traduce automáticamente a formato JSON dentro del archivo especificado.


### Serialización Binaria en Java
* Convierte el objeto en una secuencia de bytes optimizada para el entorno de ejecución de Java.
* **Metadatos y Cabeceras** guarda información detallada sobre la estructura de la clase(nombres completos de los paquetes, nombres de los atributos, modificadores de acceso, firmas de serialización como el ``serialVersionUID``)`.
* **Estructura de objeto** Java añade bytes de control para saber cómo reconstruir la jerarquía de los objetos en memoria exactamente igual a como estaban.
* Es ilegible para humanos y para otros lenguajes; si intentas abrir el archivo ```.ser``` con un editor de texto, verás símbolos extraños y basura binaria.

### Formato JSON
* Almacena los datos como texto plano estructurado mediante pares clave-valor.
* Solo guarda los datos puros y los nombres de los atributos como texto. No incluye metadatos complejos de la máquina virtual de Java.
* Requiere un proceso de análisis de texto (parsing), lo que se consume un poco más de recursos de CPU al convertirlo de texto a objeto en comparación con la lectura binaria directa.

#### Files.size()
Para cumplir con la restricción de medir datos objetivos, la API moderna de java (``java.nio.file``) proporciona la clase `Files` y `Path`, las cuales permiten interactuar con el sistema de archivos de manera eficiente.
* ``Path.of("file.json")`` obtiene la ruta del archivo.
* ```Files.size(Path)``` Devuelve el tamaño exacto del archivo en bytes consultando directamente al sistema operativo.

## ex7
* Si una superclase no implementa ``Serializable``, el motor de serialización de Java no guardará automáticamente los atributos definidos en esa clase padre.
* Durante el proceso de deserialización, para poder reconstruir la parte de la subclase que sí es serializable.