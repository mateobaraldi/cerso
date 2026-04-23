public class Orden {
    private static int contadorOrdenes = 0;
    private static final int MAX_PRODUCTOS = 10;

    private int idOrden;
    private DetalleOrden[] detalles;
    private int contadorDetalles;

    public Orden() {
        this.idOrden = ++contadorOrdenes;
        this.detalles = new DetalleOrden[MAX_PRODUCTOS];
        this.contadorDetalles = 0;
    }

    public void agregarProducto(Producto producto, int cantidad) {
        if (contadorDetalles >= MAX_PRODUCTOS) {
            throw new RuntimeException("No se pueden agregar más productos a la orden");
        }

        detalles[contadorDetalles++] = new DetalleOrden(producto, cantidad);
    }

    public double calcularTotal() {
        double total = 0;

        for (int i = 0; i < contadorDetalles; i++) {
            total += detalles[i].calcularSubtotal();
        }

        return total;
    }

    public void mostrarOrden() {
        System.out.println("Orden #" + idOrden);
        System.out.println("Productos:");

        for (int i = 0; i < contadorDetalles; i++) {
            System.out.println(detalles[i]);
        }

        System.out.println("TOTAL: $" + calcularTotal());
    }
}