public class Moto extends Vehiculo {
    private int cilindrada;

    public Moto(String marca, String modelo, int cilindrada) {
        super(marca, modelo);
        this.marca = marca;
        this.modelo = modelo;
        this.cilindrada = cilindrada;
    }
    @Override
    public void arrancar(){ 
        System.out.println(" El vehiculo " + marca + " " + modelo + " arranca con patada ");
       
    }
    
}
