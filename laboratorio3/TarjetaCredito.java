package dominio;

public class TarjetaCredito {
    private String banco;
    private String numerotarjeta;
    private double saldoDisponible;
    private Titular titular;

    public TarjetaCredito(String banco, String numeroTarjeta, double saldoDisponible, Titular titular){
        this.banco = banco;
        this.numerotarjeta = numeroTarjeta;
        this.saldoDisponible = saldoDisponible;
        this.titular = titular;
    }

    public boolean tieneSaldo(double monto){
        return saldoDisponible >= monto;
    }

    public void descontarSaldo(double monto){
        saldoDisponible -= monto;
    }

    public Titular getTitular(){
        return titular;
    }
}

    //Metodos

    /*public boolean tieneSaldo(double) {}
    public void descontar(double) {}
    public string nombreTitular () {}
    public string toString () {}

    
    protected String nombreBanco;
    protected String numeroTarjeta;
    protected double saldo;
    private String nombreCompleto;



    public TarjetaDeCredito(String nombreBanco, String numeroTarjeta, double saldo, String nombreCompleto) {
        this.nombreBanco = nombreBanco;
        this.numeroTarjeta = numeroTarjeta;
        this.saldo = saldo;
        this.nombreCompleto = nombreCompleto;
    }


    public String getNombreCompleto() {
        return nombreCompleto;
    }

    public void setNombreCompleto(String nombreCompleto) {
        this.nombreCompleto = nombreCompleto;
    }

    public TarjetaDeCredito(String nombreCompleto) {
        this.nombreCompleto = nombreCompleto;
    }

    public String getNombreBanco() {
        return nombreBanco;
    }

    public void setNombreBanco(String nombreBanco) {
        this.nombreBanco = nombreBanco;
    }

    public String getNumeroTarjeta() {
        return numeroTarjeta;
    }

    public void setNumeroTarjeta(String numeroTarjeta) {
        this.numeroTarjeta = numeroTarjeta;
    }

    public double getSaldo() {
        return saldo;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }

    
}
*/