public class Producto {
    private static int contadorProductos = 0;

    private int idProducto;
    private String nombre;
    private double precio;

    public Producto(String nombre, double precio) {
        this.idProducto = ++contadorProductos;
        this.nombre = nombre;
        setPrecio(precio);
    }

    public int getIdProducto() {
        return idProducto;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        if (precio <= 0) {
            throw new IllegalArgumentException("El precio debe ser mayor a 0");
        }
        this.precio = precio;
    }

    @Override
    public String toString() {
        return "Producto{" +
                "id=" + idProducto +
                ", nombre='" + nombre + '\'' +
                ", precio=" + precio +
                '}';
    }
}