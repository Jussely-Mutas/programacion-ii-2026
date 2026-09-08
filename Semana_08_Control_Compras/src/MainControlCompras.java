import java.util.ArrayList;
import java.util.HashSet;
import java.util.HashMap;
import java.util.Scanner;

public class MainControlCompras {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<Producto> listaProductos = new ArrayList<>();
        HashSet<String> categoriasUnicas = new HashSet<>();
        HashMap<String, Double> totalPorCategoria = new HashMap<>();

        System.out.println("=============================================");
        System.out.println("   SISTEMA DE CONTROL DE COMPRAS DEL HOGAR   ");
        System.out.println("=============================================");
        System.out.println("Debe registrar como mínimo 5 productos válidos.\n");

        while (listaProductos.size() < 5) {
            System.out.println("--- Ingreso Producto #" + (listaProductos.size() + 1) + " ---");

            System.out.print("Nombre del producto: ");
            String nombre = scanner.nextLine().trim();
            System.out.print("Categoría: ");
            String categoria = scanner.nextLine().trim();

            System.out.print("Precio unitario: ");
            double precioUnitario = scanner.nextDouble();

            System.out.print("Cantidad: ");
            int cantidad = scanner.nextInt();
            scanner.nextLine();

            if (nombre.isEmpty()) {
                System.out.println("Producto no registrado: el nombre no puede estar vacío.\n");
                continue;
            }
            if (categoria.isEmpty()) {
                System.out.println("Producto no registrado: la categoría no puede estar vacía.\n");
                continue;
            }
            if (precioUnitario <= 0) {
                System.out.println("Producto no registrado: el precio debe ser mayor que cero.\n");
                continue;
            }
            if (cantidad <= 0) {
                System.out.println("Producto no registrado: la cantidad debe ser mayor que cero.\n");
                continue;
            }

            Producto productoNuevo = new Producto(nombre, categoria, precioUnitario, cantidad);

            listaProductos.add(productoNuevo);

            categoriasUnicas.add(categoria);

            double subtotalActual = productoNuevo.calcularSubtotal();
            double totalAcumuladoCategoria = totalPorCategoria.getOrDefault(categoria, 0.0);
            totalPorCategoria.put(categoria, totalAcumuladoCategoria + subtotalActual);

            System.out.println("-> Producto registrado con éxito.\n");
        }

        System.out.println("\n===== RESUMEN DE COMPRAS =====");

        double totalGeneral = 0;
        Producto productoMayorGasto = listaProductos.get(0);
        Producto productoMenorGasto = listaProductos.get(0);

        for (Producto producto : listaProductos) {
            double subtotal = producto.calcularSubtotal();
            totalGeneral += subtotal;

            System.out.printf("%s | %s | Q%.2f x %d | Subtotal: Q%.2f\n",
                    producto.getNombre(),
                    producto.getCategoria(),
                    producto.getPrecioUnitario(),
                    producto.getCantidad(),
                    subtotal);

            if (subtotal > productoMayorGasto.calcularSubtotal()) {
                productoMayorGasto = producto;
            }
            if (subtotal < productoMenorGasto.calcularSubtotal()) {
                productoMenorGasto = producto;
            }
        }

        System.out.println("\nCategorías registradas:");
        System.out.println(categoriasUnicas);

        System.out.println("\nTotal por categoría:");
        String categoriaMayorGasto = "";
        double montoMayorGasto = -1.0;

        for (String categoria : totalPorCategoria.keySet()) {
            double gastoCategoria = totalPorCategoria.get(categoria);
            System.out.printf("%s: Q%.2f\n", categoria, gastoCategoria);

            if (gastoCategoria > montoMayorGasto) {
                montoMayorGasto = gastoCategoria;
                categoriaMayorGasto = categoria;
            }
        }

        System.out.println("\nProductos registrados: " + listaProductos.size());
        System.out.printf("Total general: Q%.2f\n", totalGeneral);

        System.out.printf("\nProducto con mayor gasto:\n%s - Q%.2f\n",
                productoMayorGasto.getNombre(), productoMayorGasto.calcularSubtotal());

        System.out.printf("\nProducto con menor gasto:\n%s - Q%.2f\n",
                productoMenorGasto.getNombre(), productoMenorGasto.calcularSubtotal());

        System.out.printf("\nCategoría con mayor gasto:\n%s - Q%.2f\n",
                categoriaMayorGasto, montoMayorGasto);

        System.out.println("\n=============================================");
        System.out.print("Ingrese una categoría para consultar: ");
        String categoriaConsultada = scanner.nextLine().trim();

        if (totalPorCategoria.containsKey(categoriaConsultada)) {
            System.out.printf("Total gastado en %s: Q%.2f\n",
                    categoriaConsultada, totalPorCategoria.get(categoriaConsultada));
        } else {
            System.out.println("La categoría ingresada no se encuentra registrada.");
        }

        scanner.close();
    }
}
