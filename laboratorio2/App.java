public class App {
    public static void main(String[] args) {

        Cuenta cuentaOrigen = new Cuenta("Juan", "12345", 1.5, 1000);
        Cuenta cuentaDestino = new Cuenta("Ana", "67890", 1.2, 500);

        // Ingreso
        cuentaOrigen.ingreso(200);

        // Extracción
        cuentaOrigen.extraccion(150);

        // Transferencia
        cuentaOrigen.transferencia(cuentaDestino, 300);

        // Mostrar resultados
        System.out.println("Saldo cuenta1: " + cuentaOrigen.getSaldo());
        System.out.println("Saldo cuenta2: " + cuentaDestino.getSaldo());
    }
}