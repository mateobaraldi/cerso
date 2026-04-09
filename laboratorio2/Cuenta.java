public class Cuenta {

    private String nombre;
    private String numeroCuenta;
    private double interes;
    private double saldo;

    public Cuenta() {
    }

    public Cuenta(String nombre, String numeroCuenta, double interes, double saldo) {
        this.nombre = nombre;
        this.numeroCuenta = numeroCuenta;
        this.interes = interes;
        this.saldo = saldo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getNumeroCuenta() {
        return numeroCuenta;
    }

    public void setNumeroCuenta(String numeroCuenta) {
        this.numeroCuenta = numeroCuenta;
    }

    public double getInteres() {
        return interes;
    }

    public void setInteres(double interes) {
        this.interes = interes;
    }

    public double getSaldo() {
        return saldo;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }

    // Método ingreso
    public boolean ingreso(double cantidad) {
        if (cantidad < 0) {
            return false;
        }
        saldo += cantidad;
        return true;
    }

    // Método extracción
    public boolean extraccion(double cantidad) {
        if (cantidad < 0 || cantidad > saldo) {
            return false;
        }
        saldo -= cantidad;
        return true;
    }

    // Método transferencia
    public boolean transferencia(Cuenta destino, double importe) {
        if (importe < 0 || saldo < importe) {
            return false;
        }

        this.saldo -= importe;
        destino.saldo += importe;
        return true;
    }
}