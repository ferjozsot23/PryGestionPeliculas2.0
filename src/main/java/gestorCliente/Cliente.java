package gestorCliente;

import java.util.ArrayList;

public class Cliente {
    private String identificacion;
    private String nombre;
    private String apellido;
    private String direccion;
    private String telefono;



    public Cliente(ArrayList <String> datosCliente) {
        this.identificacion = datosCliente.get(0);
        this.nombre = datosCliente.get(1);
        this.apellido =datosCliente.get(2);
        this.direccion = datosCliente.get(3);
        this.telefono = datosCliente.get(4);

    }

    public Cliente() {
    }

    public Cliente( String identificacion, String nombre, String apellido,String direccion, String telefono) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.telefono = telefono;
        this.direccion = direccion;
        this.identificacion = identificacion;
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

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getIdentificacion() {
        return identificacion;
    }

    public void setIdentificacion(String identificacion) {
        this.identificacion = identificacion;
    }
    
    public ArrayList<String> getInformacion() {
        ArrayList<String> informacion = new ArrayList<>();
        informacion.add(this.identificacion);
        informacion.add(this.nombre);
        informacion.add(this.apellido);
        informacion.add(this.direccion);
        informacion.add(this.telefono);
        return informacion;
        }
    public void setInformacion(String identificacion, String nombre, String apellido, String direccion, String telefono ) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.telefono = telefono;
        this.direccion = direccion;
        this.identificacion = identificacion;
    }

    @Override
    public String toString() {
        return "Nombre: " + nombre+
                "\nApellido='" + apellido+
                "\nTelefono='" + telefono+
                "\nDireccion='" + direccion +
                "\nIdentificacion='" + identificacion+"\n";
    }
    
}
