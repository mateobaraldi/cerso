public class App {
    public static void main(String[] args) throws Exception {       
        Vehiculo moto = new Moto("Honda", " CVR200 v ", 1000);
        moto.arrancar();
        Vehiculo auto = new Auto("Toyota", " Corolla", 120);
        auto.arrancar();
    }
}
