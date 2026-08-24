public class Envio {
    private String codigo;
    private String destinatario;
    private double pesoKg;

    // Constructor
    public Envio(String codigo, String destinatario, double pesoKg) {
        this.codigo = codigo;
        this.destinatario = destinatario;
        this.pesoKg = pesoKg;
    }
    public String getCodigo() {
        return codigo;
    }

    public String getDestinatario() {
        return destinatario;
    }

    public double getPesoKg() {
        return pesoKg;
    }

    public double calcularCostoBase() {
        return pesoKg * 10.0;
    }


    public double calcularCostoFinal() {
        return calcularCostoBase();
    }

    public void mostrarResumen() {
        System.out.println("\n=== RESUMEN DE ENVÍO ===");
        System.out.println("Código: " + codigo);
        System.out.println("Destinatario: " + destinatario);
        System.out.printf("Costo Final: Q%.2f%n", calcularCostoFinal());
    }

    public void mostrarResumen(boolean conDesglose) {
        if (!conDesglose) {
            mostrarResumen();
            return;
        }
        System.out.println("\n=== RESUMEN DETALLADO DE ENVÍO ===");
        System.out.println("Código: " + codigo);
        System.out.println("Destinatario: " + destinatario);
        System.out.printf("Peso del paquete: %.2f kg%n", pesoKg);
        System.out.printf("Costo base: Q%.2f%n", calcularCostoBase());
        System.out.printf("Costo final: Q%.2f%n", calcularCostoFinal());
    }
}
