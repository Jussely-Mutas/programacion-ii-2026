import java.util.Scanner;
public class ControlParqueo {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Nombre: Jussely  Saraí Mutas Chitic");
        System.out.println("Carne: 9941-25-28221");

        System.out.println("=========================================");
        System.out.println("   SISTEMA DE CONTROL DE PARQUEO        ");
        System.out.println("=========================================");

        int cantidadVehiculos = 0;
        do {
            System.out.print("Ingrese la cantidad de vehículos a registrar: ");
            if (scanner.hasNextInt()) {
                cantidadVehiculos = scanner.nextInt();
                if (cantidadVehiculos <= 0) {
                    System.out.println("Error: La cantidad debe ser mayor a cero.");
                }
            } else {
                System.out.println("Error: Por favor ingrese un número entero válido.");
                scanner.next();
            }
        } while (cantidadVehiculos <= 0);

        int cantidadMotos = 0;
        int cantidadAutos = 0;
        int cantidadPickups = 0;
        int cantidadTicketsPerdidos = 0;
        double totalDineroRecaudado = 0;

        double pagoMaximo = -1;
        String placaPagoMaximo = "";
        String tipoPagoMaximo = "";

        for (int i = 1; i <= cantidadVehiculos; i++) {
            System.out.println("\n-----------------------------------------");
            System.out.println("   REGISTRO DEL VEHÍCULO #" + i);
            System.out.println("-----------------------------------------");

            System.out.print("Ingrese la placa del vehículo: ");
            String placa = scanner.next();

            int tipoVehiculo = 0;
            do {
                System.out.print("Seleccione el tipo de vehículo (1: Motocicleta, 2: Automóvil, 3: Pickup/Camioneta): ");
                if (scanner.hasNextInt()) {
                    tipoVehiculo = scanner.nextInt();
                    if (tipoVehiculo < 1 || tipoVehiculo > 3) {
                        System.out.println("Error: Opción no válida. Ingrese 1, 2 o 3.");
                    }
                } else {
                    System.out.println("Error: Ingrese un número válido.");
                    scanner.next();
                }
            } while (tipoVehiculo < 1 || tipoVehiculo > 3);

            int horaEntrada = solicitarEnteroEnRango(scanner, "Hora de entrada (0-23): ", 0, 23);
            int minutoEntrada = solicitarEnteroEnRango(scanner, "Minuto de entrada (0-59): ", 0, 59);
            int horaSalida = solicitarEnteroEnRango(scanner, "Hora de salida (0-23): ", 0, 23);
            int minutoSalida = solicitarEnteroEnRango(scanner, "Minuto de salida (0-59): ", 0, 59);

            int minutosEntradaTotal = horaEntrada * 60 + minutoEntrada;
            int minutosSalidaTotal = horaSalida * 60 + minutoSalida;

            if (minutosSalidaTotal < minutosEntradaTotal) {
                minutosSalidaTotal += 24 * 60;
            }

            int diferenciaMinutosTotal = minutosSalidaTotal - minutosEntradaTotal;
            int horasTranscurridas = diferenciaMinutosTotal / 60;
            int minutosRestantes = diferenciaMinutosTotal % 60;

            int horasCobradas = horasTranscurridas;
            if (minutosRestantes > 0) {
                horasCobradas++;
            }

            char ticketPerdidoChar = ' ';
            do {
                System.out.print("¿Perdió el ticket? (S/N): ");
                String input = scanner.next().toUpperCase();
                if (input.length() == 1 && (input.charAt(0) == 'S' || input.charAt(0) == 'N')) {
                    ticketPerdidoChar = input.charAt(0);
                } else {
                    System.out.println("Error: Respuesta no válida. Ingrese 'S' para sí o 'N' para no.");
                }
            } while (ticketPerdidoChar != 'S' && ticketPerdidoChar != 'N');

            boolean perdióTicket = (ticketPerdidoChar == 'S');

            double tarifa = obtenerTarifa(tipoVehiculo);
            String nombreTipo = obtenerNombreVehiculo(tipoVehiculo);
            double subtotal = horasCobradas * tarifa;
            double descuento = calcularDescuento(subtotal, horasCobradas);
            double recargo = perdióTicket ? 50.00 : 0.00;

            double totalPagar;
            if (perdióTicket) {
                totalPagar = calcularPago(horasCobradas, tarifa, recargo);
            } else {
                totalPagar = calcularPago(horasCobradas, tarifa);
            }

            mostrarComprobante(placa, nombreTipo, horasTranscurridas, minutosRestantes, horasCobradas, tarifa, subtotal, descuento, recargo, totalPagar);

            switch (tipoVehiculo) {
                case 1 -> cantidadMotos++;
                case 2 -> cantidadAutos++;
                case 3 -> cantidadPickups++;
            }

            if (perdióTicket) {
                cantidadTicketsPerdidos++;
            }

            totalDineroRecaudado += totalPagar;

            if (totalPagar > pagoMaximo) {
                pagoMaximo = totalPagar;
                placaPagoMaximo = placa;
                tipoPagoMaximo = nombreTipo;
            }
        }

        System.out.println("\n=========================================");
        System.out.println("       RESUMEN GENERAL DE LA JORNADA     ");
        System.out.println("=========================================");
        System.out.println("Cantidad de motocicletas: " + cantidadMotos);
        System.out.println("Cantidad de automóviles: " + cantidadAutos);
        System.out.println("Cantidad de pickups/camionetas: " + cantidadPickups);
        System.out.println("Cantidad de tickets perdidos: " + cantidadTicketsPerdidos);
        System.out.printf("Total de dinero recaudado: Q%.2f\n", totalDineroRecaudado);
        if (cantidadVehiculos > 0) {
            System.out.printf("Vehículo con el pago más alto: Placa %s (%s) con un total de Q%.2f\n", placaPagoMaximo, tipoPagoMaximo, pagoMaximo);
        }
        System.out.println("=========================================");

        scanner.close();
    }

    public static double obtenerTarifa(int tipoVehiculo) {
        return switch (tipoVehiculo) {
            case 1 -> 5.00;
            case 2 -> 8.00;
            case 3 -> 12.00;
            default -> 0.00;
        };
    }

    public static String obtenerNombreVehiculo(int tipoVehiculo) {
        return switch (tipoVehiculo) {
            case 1 -> "Motocicleta";
            case 2 -> "Automóvil";
            case 3 -> "Pickup o camioneta";
            default -> "Desconocido";
        };
    }

    public static double calcularDescuento(double subtotal, int horas) {
        if (horas > 8) {
            return subtotal * 0.15;
        }
        return 0.00;
    }

    public static void mostrarComprobante(String placa, String tipo, int horasTiempo, int minutosTiempo, int horasCobradas, double tarifa, double subtotal, double descuento, double recargo, double total) {
        System.out.println("\n========== COMPROBANTE ==========");
        System.out.println("Placa: " + placa);
        System.out.println("Tipo: " + tipo);
        System.out.println("Tiempo estacionado: " + horasTiempo + " horas y " + minutosTiempo + " minutos");
        System.out.println("Horas cobradas: " + horasCobradas);
        System.out.printf("Tarifa por hora: Q%.2f\n", tarifa);
        System.out.printf("Subtotal: Q%.2f\n", subtotal);
        System.out.printf("Descuento: Q%.2f\n", descuento);
        System.out.printf("Recargo por ticket perdido: Q%.2f\n", recargo);
        System.out.printf("TOTAL: Q%.2f\n", total);
        System.out.println("=================================");
    }

    public static double calcularPago(int horas, double tarifa) {
        double subtotal = horas * tarifa;
        double descuento = calcularDescuento(subtotal, horas);
        return subtotal - descuento;
    }

    public static double calcularPago(int horas, double tarifa, double recargo) {
        double subtotal = horas * tarifa;
        double descuento = calcularDescuento(subtotal, horas);
        return (subtotal - descuento) + recargo;
    }


    private static int solicitarEnteroEnRango(Scanner scanner, String mensaje, int min, int max) {
        int valor = -1;
        do {
            System.out.print(mensaje);
            if (scanner.hasNextInt()) {
                valor = scanner.nextInt();
                if (valor < min || valor > max) {
                    System.out.println("Error: El valor debe estar entre " + min + " y " + max + ".");
                }
            } else {
                System.out.println("Error: Ingrese un número válido.");
                scanner.next();
            }
        } while (valor < min || valor > max);
        return valor;
    }
}