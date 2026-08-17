# Control de Parqueo - Tarea Semana 04

* **Nombre completo:** Jussely Saraí Mutas Chitic
* **Número de carné:** 9941-25-28221

---

## Descripción de la solución
Esta aplicación de consola desarrollada en Java administra el cobro de vehículos en un parqueo público. Registra dinámicamente varios vehículos validando los datos de entrada, calcula las tarifas exactas según el tiempo estacionado (incluyendo el cobro de fracciones como horas completas) y aplica descuentos o recargos según corresponda. Al finalizar, genera un informe detallado con métricas clave de la jornada.

---

## Métodos creados y su función
* `public static double obtenerTarifa(int tipoVehiculo)`: Retorna la tarifa por hora asociada al tipo de vehículo seleccionada (Q5.00 para Motocicleta, Q8.00 para Automóvil, Q12.00 para Pickup/Camioneta).
* `public static String obtenerNombreVehiculo(int tipoVehiculo)`: Devuelve la etiqueta descriptiva del tipo de vehículo según su código de opción.
* `public static double calcularDescuento(double subtotal, int horas)`: Aplica un 15% de descuento al subtotal si el tiempo superó las 8 horas.
* `public static void mostrarComprobante(...)`: Despliega en pantalla el ticket o comprobante de pago individual con el desglose detallado de cobro.
* `public static double calcularPago(int horas, double tarifa)`: Método sobrecargado para calcular el costo total estándar sin recargos.
* `public static double calcularPago(int horas, double tarifa, double recargo)`: Método sobrecargado para calcular el total incorporando el recargo fijo por pérdida de ticket.

---

## Explicación de la sobrecarga
La sobrecarga del método `calcularPago` permite gestionar de manera modular dos escenarios de cobro distintos bajo el mismo nombre de función:
1. `calcularPago(int horas, double tarifa)`: Se invoca cuando el cliente presenta su ticket original (`S/N` = `N`), ejecutando el cálculo tradicional del subtotal restando el descuento aplicable.
2. `calcularPago(int horas, double tarifa, double recargo)`: Se ejecuta cuando el cliente pierde el comprobante de entrada (`S/N` = `S`), agregando el monto del recargo administrativo (Q50.00) tras deducir el descuento.

---

## Casos de prueba utilizados
1. **Ejecución normal sin ticket perdido:** Entrada 10:00, Salida 15:00 (5 horas). Tipo: Automóvil. Subtotal Q40.00, Descuento Q0.00, Total Q40.00.
2. **Ejecución con descuento y ticket perdido:** Entrada 08:00, Salida 19:00 (11 horas). Tipo: Pickup. Subtotal Q132.00, Descuento Q19.80, Recargo Q50.00, Total Q162.20.
3. **Validación de errores:** Intento de ingreso de tipo de vehículo fuera del rango 1-3, horas superiores a 23, o respuestas en texto no válidas en campos de confirmación.
4. **Cruce de medianoche (Reto Opcional):** Entrada 22:30, Salida 02:10 del día siguiente (3 horas y 40 minutos -> 4 horas cobradas).

---

## Reto Opcional (+2 puntos)
* **¿Se realizó el reto opcional?** **SÍ**
* **Detalles de implementación:**
    * Se solicitaron las horas y minutos de entrada y salida de forma independiente con sus validaciones correspondientes (horas de 0 a 23, minutos de 0 a 59).
    * Se implementó lógica para manejar eventos donde el tiempo de salida cruza la medianoche (agregando un ciclo de 24 horas al cálculo de minutos).
    * Se redondeó cualquier fracción excedente de minutos hacia la hora cobrable superior inmediata.