import dominio.Posnet;
import dominio.TarjetaCredito;
import dominio.Ticket;
import dominio.Titular;

public class App {
    public static void main(String[] args) throws Exception {

        Titular titular = new Titular("12345", "vicente", "cerso", "55555", "vicentecerso@gmail.com");

        TarjetaCredito tarjeta = new TarjetaCredito("galicia", "12345", 15000, titular);
        
        Posnet posnet = new Posnet();

        Ticket ticket = posnet.efectuarPago(tarjeta, 10000, 5);

        System.out.println("Cliente: " + ticket.getNombreCompleto() + "\nTotal: $" + ticket.getMontoTotal() + "\nCuota: " +ticket.getMontoCuota());
    }
}
