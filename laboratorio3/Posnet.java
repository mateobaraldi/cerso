package dominio;

public class Posnet {

  /*   public final double RECARGO_CUOTA = 0.03;
    public final int MIN_CUOTA = 1;
    public final int MAX_CUOTA = 6;

  //  Ticket ticket = null;
*/
    public Ticket efectuarPago(TarjetaCredito tarjeta, double monto, int cuotas){
        double montoFinal = calcularMontoFinal(monto, cuotas);

        if (tarjeta.tieneSaldo(montoFinal)) {
            
            tarjeta.descontarSaldo(montoFinal);

            double montoCuota = montoFinal / cuotas;

            return new Ticket(tarjeta.getTitular().getNombreCompleto(), montoFinal, montoCuota);

        }
        return null;
    }
    private double calcularMontoFinal(double monto, int cuotas){
        if (cuotas == 1) {
            return monto;
        }
        double recargo = (cuotas - 1) * 0.03;
        return monto + (monto * recargo);
    }

}

/* 
private boolean datosValidos(TarjetaDeCredito tarjetaDeCredito, double monto, int cuotas){

    boolean tarjetaValida = tarjetaDeCredito != null;
    boolean montoValido = monto > 0; 
    boolean cuotaValida = cuotas >= MIN_CUOTA && cuotas <=MAX_CUOTA;
    return tarjetaValida && montoValido && cuotaValida;

}


private double recargoCuotas(int cuotas) {

    return (cuotas-1) * RECARGO_CUOTA;

}
}

public Ticket efectuarPago(TarjetaDeCredito tarjetaDeCredito, double monto, int cantidadDeCuotas) {

    if(datosValidos(tarjetaDeCredito, monto, cantidadDeCuotas)){
        
        double montoTotal = monto + monto * recargoCuotas(cantidadDeCuotas); 
        
        if(tarjetaDeCredito.getSaldo()>= montoTotal){

            tarjetaDeCredito.setSaldo( tarjetaDeCredito.getSaldo() - montoTotal );
            
            ticket = new Ticket(tarjetaDeCredito.getNombreCompleto(), montoTotal , cantidadDeCuotas);
            

        }
    }
    
    return ticket;

}*/