public class DetalleOrden {
    private Producto producto;
    private int cantidad;
    private double precioUnitario;

    public DetalleOrden(Producto producto, int cantidad) {
        if (cantidad <= 0) {
            throw new IllegalArgumentException("La cantidad debe ser mayor a 0");
        }
        this.producto = producto;
        this.cantidad = cantidad;
        this.precioUnitario = producto.getPrecio(); // precio al momento de la compra
    }

    public double calcularSubtotal() {
        return cantidad * precioUnitario;
    }

    @Override
    public String toString() {
        return producto.getNombre() +
                " | Cantidad: " + cantidad +
                " | Precio Unitario: " + precioUnitario +
                " | Subtotal: " + calcularSubtotal();
    }
}