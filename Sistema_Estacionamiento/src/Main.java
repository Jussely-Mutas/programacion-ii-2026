import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

public class Main {
    private static List<Vehiculo> listaVehiculos = new ArrayList<>();
    private static Set<String> conjuntoPlacas = new HashSet<>();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int opcion = 0;
        do {
            try {
                System.out.println("\n--- MENÚ ESTACIONAMIENTO ---");
                System.out.println("1. Registrar vehículo.");
                System.out.println("2. Mostrar todos los vehículos registrados.");
                System.out.println("3. Buscar un vehículo por placa.");
                System.out.println("4. Mostrar el vehículo que generó el mayor costo.");
                System.out.println("5. Mostrar el total general recaudado.");
                System.out.println("6. Mostrar el total recaudado por tipo de vehículo.");
                System.out.println("7. Salir.");
                System.out.print("Seleccione una opción: ");

                opcion = Integer.parseInt(scanner.nextLine());

                switch (opcion) {
                    case 1 -> registrarVehiculo();
                    case 2 -> mostrarTodos();
                    case 3 -> buscarPorPlaca();
                    case 4 -> mostrarMayorCosto();
                    case 5 -> mostrarTotalGeneral();
                    case 6 -> mostrarTotalPorTipo();
                    case 7 -> System.out.println("Saliendo del programa...");
                    default -> System.out.println("Error: Opción inválida. Ingrese un número entre 1 y 7.");
                }
            } catch (NumberFormatException e) {
                System.out.println("Error: Debe ingresar un valor numérico entero.");
            } finally {
                System.out.println("Operación de menú procesada.");
            }
        } while (opcion != 7);
    }

    private static void registrarVehiculo() {
        try {
            System.out.print("Ingrese la placa: ");
            String placa = scanner.nextLine().trim();
            if (placa.isEmpty()) {
                System.out.println("Error: La placa no puede estar vacía.");
                return;
            }
            if (conjuntoPlacas.contains(placa)) {
                System.out.println("Error: Ya existe un vehículo registrado con esta placa.");
                return;
            }

            System.out.print("Ingrese el nombre del propietario: ");
            String propietario = scanner.nextLine().trim();
            if (propietario.isEmpty()) {
                System.out.println("Error: El propietario no puede estar vacío.");
                return;
            }

            System.out.print("Ingrese la hora de ingreso (ej. 08:30): ");
            String horaIngreso = scanner.nextLine().trim();

            System.out.print("Ingrese las horas utilizadas: ");
            double horas = Double.parseDouble(scanner.nextLine());
            if (horas <= 0) {
                System.out.println("Error: Las horas utilizadas deben ser mayores que cero.");
                return;
            }

            System.out.print("Tipo de vehículo (1. Automóvil / 2. Motocicleta): ");
            int tipo = Integer.parseInt(scanner.nextLine());

            Vehiculo v = null;
            if (tipo == 1) {
                v = new Automovil(placa, propietario, horaIngreso, horas);
            } else if (tipo == 2) {
                v = new Motocicleta(placa, propietario, horaIngreso, horas);
            } else {
                System.out.println("Error: Tipo de vehículo inválido.");
                return;
            }

            listaVehiculos.add(v);
            conjuntoPlacas.add(placa);
            System.out.println("Vehículo registrado exitosamente.");

        } catch (NumberFormatException e) {
            System.out.println("Error: Entrada inválida. Ingrese un número adecuado para las horas o tipo.");
        }
    }

    private static void mostrarTodos() {
        if (listaVehiculos.isEmpty()) {
            System.out.println("No hay vehículos registrados.");
            return;
        }
        for (Vehiculo v : listaVehiculos) {
            String tipo = (v instanceof Automovil) ? "Automóvil" : "Motocicleta";
            System.out.println("Placa: " + v.getPlaca() +
                    " | Propietario: " + v.getPropietario() +
                    " | Tipo: " + tipo +
                    " | Horas: " + v.getHorasUtilizadas() +
                    " | Costo: Q" + String.format("%.2f", v.calcularCosto()));
        }
    }

    private static void buscarPorPlaca() {
        System.out.print("Ingrese la placa a buscar: ");
        String placa = scanner.nextLine().trim();
        for (Vehiculo v : listaVehiculos) {
            if (v.getPlaca().equalsIgnoreCase(placa)) {
                v.mostrarInformacion();
                return;
            }
        }
        System.out.println("No se encontró ningún vehículo con esa placa.");
    }

    private static void mostrarMayorCosto() {
        if (listaVehiculos.isEmpty()) {
            System.out.println("No hay vehículos registrados.");
            return;
        }
        Vehiculo mayor = listaVehiculos.get(0);
        for (Vehiculo v : listaVehiculos) {
            if (v.calcularCosto() > mayor.calcularCosto()) {
                mayor = v;
            }
        }
        System.out.println("Vehículo con mayor costo:");
        mayor.mostrarInformacion();
    }

    private static void mostrarTotalGeneral() {
        double total = 0;
        for (Vehiculo v : listaVehiculos) {
            total += v.calcularCosto();
        }
        System.out.println("Total general recaudado: Q" + String.format("%.2f", total));
    }

    private static void mostrarTotalPorTipo() {
        Map<String, Double> totales = new HashMap<>();
        totales.put("Automóvil", 0.0);
        totales.put("Motocicleta", 0.0);

        for (Vehiculo v : listaVehiculos) {
            if (v instanceof Automovil) {
                totales.put("Automóvil", totales.get("Automóvil") + v.calcularCosto());
            } else if (v instanceof Motocicleta) {
                totales.put("Motocicleta", totales.get("Motocicleta") + v.calcularCosto());
            }
        }

        System.out.println("Total recaudado por tipo de vehículo:");
        for (Map.Entry<String, Double> entry : totales.entrySet()) {
            System.out.println(entry.getKey() + ": Q" + String.format("%.2f", entry.getValue()));
        }
    }
}