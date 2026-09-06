import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static boolean existeCodigo(List<Mascota> lista, String codigo) {
        for (Mascota m : lista) {
            if (m.getCodigoPaciente().equalsIgnoreCase(codigo)) {
                return true;
            }
        }
        return false;
    }

    public static Mascota buscarPorCodigo(List<Mascota> lista, String codigo) {
        for (Mascota m : lista) {
            if (m.getCodigoPaciente().equalsIgnoreCase(codigo)) {
                return m;
            }
        }
        return null;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Mascota> pacientes = new ArrayList<>();

        System.out.println("=== SISTEMA VETERINARIO VETCARE ===");
        System.out.println("--- CASO A: REGISTRO CON ARRAYLIST ---");

        System.out.print("Ingrese un número para iniciar el proceso (ej. 1): ");
        String entrada = scanner.nextLine();

        try {
            int opcion = Integer.parseInt(entrada);
            System.out.println("Opción válida (" + opcion + "). Iniciando registro...\n");
        } catch (NumberFormatException e) {
            System.out.println("Debe ingresar una opción numérica. El programa continúa.\n");
        }

        Mascota[] mascotasAInsertar = {
                new Perro("VET-001", "Luna", 14, 24.5, "Mestiza"),
                new Gato("VET-002", "Milo", 24, 4.8, true),
                new Ave("VET-003", "Piolín", 10, 0.4, "Exótica"),
                new Perro("VET-001", "Rocco", 8, 12.0, "Poodle")
        };

        for (Mascota m : mascotasAInsertar) {
            if (existeCodigo(pacientes, m.getCodigoPaciente())) {
                System.out.println("[DUPLICADO DETECTADO] No se puede agregar a " + m.getNombre() +
                        " porque el código '" + m.getCodigoPaciente() + "' ya existe.");
            } else {
                pacientes.add(m);
                System.out.println("-> Registrado con éxito: " + m.getNombre() + " (" + m.getCodigoPaciente() + ")");
            }
        }

        System.out.println("\nCantidad actual de pacientes: " + pacientes.size());
        System.out.println("\n--- LISTA DE PACIENTES REGISTRADOS ---");
        for (Mascota paciente : pacientes) {
            System.out.println(paciente.mostrarInformacion());
            paciente.emitirSonido();
            System.out.println("Costo consulta: Q" + paciente.calcularCostoConsulta());
            System.out.println("------------------------------------");
        }

        System.out.println("\n--- BÚSQUEDA DE PACIENTE ---");
        String codigoBuscado = "VET-002";
        Mascota encontrada = buscarPorCodigo(pacientes, codigoBuscado);
        if (encontrada != null) {
            System.out.println("Paciente encontrado: " + encontrada.mostrarInformacion());
        } else {
            System.out.println("No se encontró ningún paciente con el código: " + codigoBuscado);
        }

        System.out.println("\n--- ELIMINACIÓN DE PACIENTE ---");
        if (!pacientes.isEmpty()) {
            Mascota eliminada = pacientes.remove(0);
            System.out.println("Se ha eliminado de la lista a: " + eliminada.getNombre());
        }

        System.out.println("\n--- LISTA ACTUALIZADA (" + pacientes.size() + " PACIENTES) ---");
        for (Mascota paciente : pacientes) {
            System.out.println(paciente.mostrarInformacion());
        }

        scanner.close();
    }
}