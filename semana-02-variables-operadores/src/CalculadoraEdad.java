public class CalculadoraEdad {
    public static void main(String[] args) {
        // Datos del estudiante
        String nombreCompleto = "Jussely Sarai Mutas Chitic";
        String carne = "9941-25-28221";
        int anioNacimiento = 2002;
        int anioActual = 2026;

        // Calcular la edad utilizando los años ingresados
        int edadAproximada = anioActual - anioNacimiento;
        int edadEnMeses = edadAproximada * 12;
        boolean esMayorDeEdad = edadAproximada >= 18;

        System.out.println("----- RESULTADO -----");
        System.out.println("Estudiante: " + nombreCompleto);
        System.out.println("Carné: " + carne);
        System.out.println("Edad aproximada: " + edadAproximada + " años");
        System.out.println("Edad aproximada en meses: " + edadEnMeses + " meses");
        System.out.println("¿Es mayor de edad?: " + esMayorDeEdad);
    }
}