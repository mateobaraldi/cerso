package dominio;

public class Ticket {

    
    protected String nombreCompleto;
    protected double montoTotal;
    protected double montoCuota;

    public Ticket(String nombreCompleto, double montoTotal, double montoCuota) {
        this.nombreCompleto = nombreCompleto;
        this.montoTotal = montoTotal;
        this.montoCuota = montoCuota;
    }
 
    public String getNombreCompleto() {
        return nombreCompleto;
    }

    public void setNombreCompleto(String nombreCompleto) {
        this.nombreCompleto = nombreCompleto;
    }

    public double getMontoTotal() {
        return montoTotal;
    }

    public void setMontoTotal(double montoTotal) {
        this.montoTotal = montoTotal;
    }

    public double getMontoCuota() {
        return montoCuota;
    }

    public void setMontoCuota(double montoCuota) {
        this.montoCuota = montoCuota;
    }

}
