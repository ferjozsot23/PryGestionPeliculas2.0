package crud;

import gestorCliente.Cliente;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class AdapterCliente {

    private EnvioRecepcion crud = EnvioRecepcion.obtenerInstancia();
    private HashMap<String,ArrayList<String>> clientes;

    public HashMap getClientes(){
        ArrayList arrayClientes = null;
        try {
            arrayClientes = crud.getDatos("http://unisatelite.com/Movies/leerCliente.php");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        Map mapCliente = new HashMap();
        for(Object cliente: arrayClientes){
            ArrayList<String> datosCliente = new ArrayList<>();
            ((HashMap<String,String>)cliente).forEach((key,value)->{
                datosCliente.add(value);
            });
            mapCliente.put(((HashMap<String,String>)cliente).get("id_cliente"),datosCliente);
        }
        //this.peliculas = (HashMap) mapCliente;
        return (HashMap) mapCliente;
    }

    public ArrayList getCliente(String idCliente){
        //HashMap mapPeliculas = getPeliculas()
        if(this.clientes == null){
            this.clientes = getClientes();
        }
        return (ArrayList) this.clientes.get(idCliente);
    }

   /* public ArrayList<String> getPeliculaPorTitulo(String titulo){
        ArrayList<String> resultadoBusqueda = new ArrayList<>();
        Set keys = this.clientes.keySet();
        //System.out.println(keys.toString());
        for(Object key: keys){
            //System.out.println(key);
            if(this.clientes.get(key).get(6).equals(titulo)) {
                //System.out.println("alo");
                resultadoBusqueda = this.clientes.get(key);
            }
        }
        *//*this.peliculas.forEach((key,value)->{
            if(value.get(1).equals(titulo)) {
                resultadoBusqueda.set(this.peliculas.get(key));
            }
        });*//*
        return resultadoBusqueda;
    }*/

    public void insertarCliente(Cliente cliente){
        HashMap<String,String> datosCliente = new HashMap<>();
        datosCliente.put("id_cliente",cliente.getIdentificacion());
        datosCliente.put("nombre",cliente.getNombre());
        datosCliente.put("apellido", cliente.getApellido());
        datosCliente.put("direccion",cliente.getDireccion());
        datosCliente.put("telefono",cliente.getTelefono());
        crud.insertarDatos("http://unisatelite.com/Movies/insertarCliente.php",datosCliente);
        this.clientes = getClientes();
        //System.out.println(this.clientes.toString());
    }

    public void eliminarCliente(String idCLiente){
        HashMap<String,String> datosCliente = new HashMap<>();
        datosCliente.put("id_cliente",idCLiente);
        crud.insertarDatos("http://unisatelite.com/Movies/borrarCliente.php",datosCliente);
        this.clientes = getClientes();
    }

    public void actualizarCliente(Cliente cliente){
        HashMap<String,String> datosCliente = new HashMap<>();
        datosCliente.put("id_cliente",cliente.getIdentificacion());
        datosCliente.put("nombre",cliente.getNombre());
        datosCliente.put("apellido", cliente.getApellido());
        datosCliente.put("direccion",cliente.getDireccion());
        datosCliente.put("telefono",cliente.getTelefono());
        crud.insertarDatos("http://unisatelite.com/Movies/insertarCliente.php",datosCliente);
        this.clientes = getClientes();
    }
}
