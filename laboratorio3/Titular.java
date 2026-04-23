package dominio;

public class Titular {

    protected String dni;
    protected String nombre;
    protected String apellido; 
    protected String telefono; 
    protected String mail; 


    public Titular(String dni,String nombre, String apellido, String telefono, String mail) {

        this.dni = dni; 
        this.nombre = nombre; 
        this.apellido = apellido; 
        this.telefono = telefono;
        this.mail = mail; 

    }

    public String getNombreCompleto(){
        return nombre + "" + apellido;
    }
}

/*
    public String getDni() {
        return dni;
    }


    public void setDni(String dni) {
        this.dni = dni;
    }


    public String getNombre() {
        return nombre;
    }


    public void setNombre(String nombre) {
        this.nombre = nombre;
    }


    public String getApellido() {
        return apellido;
    }


    public void setApellido(String apellido) {
        this.apellido = apellido;
    }


    public String getTelefono() {
        return telefono;
    }


    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }


    public String getMail() {
        return mail;
    }


    public void setMail(String mail) {
        this.mail = mail;
    }

}
*/