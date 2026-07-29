/*
 * =====================================================================
 * INFORME DE CONTENCIÓN: Comparativa de Gestión de Recursos
 * Laboratorio de Bruce Banner
 * =====================================================================
 *
 * 1. ENFOQUE TRADICIONAL (try-finally):
 * - Requería un cierre manual y explícito en el bloque finally.
 * - Propenso a errores humanos (olvidos de cierre, fugas de memoria).
 * - Sufre de enmascaramiento de excepciones (el error del finally
 *   puede ocultar la excepción original del bloque try).
 *
 * 2. ENFOQUE MODERNO (try-with-resources / AutoCloseable):
 * - Automatiza el cierre de los recursos al salir del bloque try.
 * - Mantiene el código limpio, legible y libre de código repetitivo.
 * - Protege la depuración preservando la excepción original e
 *   integrando las excepciones secundarias mediante supresión.
 *
 * Conclusión: El paso a try-with-resources supuso un avance crítico
 * en la robustez y seguridad de las aplicaciones Java corporativas.
 * =====================================================================
 */