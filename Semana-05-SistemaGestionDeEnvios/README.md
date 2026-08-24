* **Nombre:** Jussely Saraí Mutas Chitic
* **Carné:** 9941-25-28221

# Sistema de Gestión de Envíos

## Descripción breve

Programa de consola en Java desarrollado para la administración y cálculo de tarifas de envíos nacionales e internacionales en una empresa de paquetería, garantizando la validación de datos en tiempo de ejecución.

## Objetivo

Aplicar los fundamentos esenciales de la Programación Orientada a Objetos (POO) mediante el desarrollo de un sistema interactivo que procese las reglas de negocio e importes correspondientes a cada modalidad de envío.

## Temas aplicados

* **Encapsulamiento:** Resguardo de los atributos de cada clase utilizando modificadores de acceso privados y métodos getter para la lectura de datos.
* **Herencia:** Derivación de la clase principal Envio hacia las subclases EnvioNacional y EnvioInternacional.
* **Sobrescritura (@Override):** Adaptación del método calcularCostoFinal() para aplicar las fórmulas específicas según el tipo de servicio.
* **Sobrecarga:** Definición de múltiples variantes del método mostrarResumen() para gestionar la presentación simple o detallada de la información.
* **Polimorfismo:** Manipulación de objetos EnvioNacional y EnvioInternacional mediante variables de referencia de la superclase Envio.
* **Validación de entradas:** Implementación de bloques de control de excepciones e instrucciones condicionales para prevenir valores nulos, vacíos o menores/iguales a cero.

## Estructura del proyecto

src/ ├── Envio.java ├── EnvioNacional.java ├── EnvioInternacional.java └── Main.java

## Instrucciones para ejecutar el programa

1. Clonar o descargar este repositorio en su equipo local.
2. Abrir el proyecto en un entorno de desarrollo integrado (IntelliJ IDEA, Eclipse, NetBeans) o desde la consola del sistema.
3. Confirmar que se dispone del Java JDK instalado y configurado correctamente.
4. Navegar hasta el directorio src/ desde la terminal y compilar las clases: javac Main.java Envio.java EnvioNacional.java EnvioInternacional.java
5. Iniciar la ejecución de la clase principal Main: java Main

## Resultado esperado

La aplicación desplegará un menú interactivo en la consola para el registro de envíos nacionales o internacionales. Solicitará la información requerida, bloqueará ingresos de datos no válidos y mostrará un resumen claro con el desglose del costo base, cargos adicionales y total a pagar.