public class Auto extends Vehiculo{
    private int carroceria;

    public Auto(String marca, String modelo, int carroceria) {
        super(marca, modelo);
        this.marca = marca;
        this.modelo = modelo;
        this.carroceria = carroceria;
    }
    @Override
    public void arrancar(){ 
        System.out.println(" El vehiculo " + marca + " " + modelo + " arranca con pedal ");
       
    }

}
