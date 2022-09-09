package gestorCliente;
import javax.swing.JOptionPane;
import java.util.ArrayList;
import java.util.HashMap;

import crud.AdapterCliente;

public class GestorCliente {
    private Cliente cliente =new Cliente();
    private AdapterCliente adaptadorCliente = new AdapterCliente();
    public GestorCliente() {
    }
    //Traer cliente ya existente de la base de datos;
    public void setCliente(String idCliente){
        this.cliente = new Cliente(adaptadorCliente.getCliente(idCliente));//trae uno solo
    }
    public void eliminarCliente(String identificacion){
        adaptadorCliente.eliminarCliente(identificacion);
    }
    public ArrayList<String> extraerDatosCliente(){
        return this.cliente.getInformacion();
    }

    public void agregarCliente(String identificacion, String nombre, String apellido,String direccion, String telefono){
        this.cliente= new Cliente(identificacion, nombre, apellido, direccion, telefono);
        adaptadorCliente.insertarCliente(this.cliente);
    }

    public void actualizarCliente(String identificacion, String nombre, String apellido,String direccion, String telefono){
        this.cliente.setInformacion(identificacion, nombre, apellido, direccion, telefono);
        adaptadorCliente.actualizarCliente(this.cliente);
    }
    public ArrayList<String> obtenerInformacionCliente(String idCliente){
        return adaptadorCliente.getCliente(idCliente);
    }
    public HashMap<String,ArrayList<String>> getClientes(){
        return adaptadorCliente.getClientes();
    }
}
