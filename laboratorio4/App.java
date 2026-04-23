public class App {
    public static void main(String[] args) {

        // Crear productos
        Producto p1 = new Producto("Manzanas", 5000);
        Producto p2 = new Producto("Bananas", 12000);
        Producto p3 = new Producto("Telefonos", 25000);

        // Crear orden
        Orden orden1 = new Orden();

        // Agregar productos
        orden1.agregarProducto(p1, 2);
        orden1.agregarProducto(p2, 3);
        orden1.agregarProducto(p3, 1);

        // Mostrar orden
        orden1.mostrarOrden();
    }
}