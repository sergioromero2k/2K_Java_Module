### El problema de la múltiple identidad
* Si una clase necesita cumplir varios roles simultáneamente, utilizaría interfaces en lugar de intentar resolverlo mediante herencia de clases.
* Por ejemplo, imaginemos un personaje que debe ser un Avenger, un Pilot y un TeamLeader. Estos conceptos representan capacidades o roles que el objeto puede desempeñar, por lo que tiene sentido modelarlos mediante interface.

### El dilema de la implementación compartida
* Elegiría una clase abstracta cuando las clases que voy a crear no solamente comparten un contrato, sino también una implementación, un estado y una relación conceptual fuerte.

### La evolución de Java (Métodos Default)
* La incorporación de los métodos ``default`` en Java 8 hizo que las interfaces fueran mucho más potentes, pero volvió obsoletas a las clases abstractas.
* Antes de Java 8, una interfaz representaba fundamentalmente un contrato: las clases que la implementaban tenían que proporcionar la implementación de sus métodos.
* Desde Java 8 es posible proporcionar una implementación por defecto.

