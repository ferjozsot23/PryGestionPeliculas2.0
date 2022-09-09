package crud;

import gestorPelicula.Pelicula;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class AdapterRenta {
    private EnvioRecepcion crud = EnvioRecepcion.obtenerInstancia();

    private HashMap<String, ArrayList<String>> rentas;

    public HashMap getRentas(){
        ArrayList arrayRentas = null;
        try {
            arrayRentas = crud.getDatos("http://unisatelite.com/Movies/leerRenta.php");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        Map mapRentas = new HashMap();
        for(Object renta: arrayRentas){
            ArrayList<String> datosRentas = new ArrayList<>();
            ((HashMap<String,String>)renta).forEach((key,value)->{
                datosRentas.add(value);
            });
            mapRentas.put(((HashMap<String,String>)renta).get("id_renta"),datosRentas);
        }
        //this.peliculas = (HashMap) mapPeliculas;
        return (HashMap) mapRentas;
    }

    public ArrayList getRenta(String idRenta){
        //HashMap mapPeliculas = getPeliculas()
        if(this.rentas == null){
            this.rentas = getRentas();
        }
        return (ArrayList) this.rentas.get(idRenta);
    }

    public void insertarRenta(Renta renta){
        HashMap<String,String> datosRenta = new HashMap<>();
        datosRenta.put("fecha_inicio",renta.getTitulo());
        datosRenta.put("fecha_entrega", renta.getDirector());
        datosRenta.put("dias_extendidos",Float.toString(renta.getCalificacion()));
        datosRenta.put("id_recibo", Integer.toString(renta.getDuracion()));
        datosRenta.put("id_cliente",renta.getGenero());
        datosRenta.put("id_copia", renta.getElenco());
        crud.insertarDatos("http://unisatelite.com/Movies/insertarRenta.php",datosRenta);
        this.rentas = getRentas();
        System.out.println(this.rentas.toString());
    }

    public void eliminarRenta(String idRenta){
        HashMap<String,String> datosRenta = new HashMap<>();
        datosRenta.put("id_renta",);
        crud.insertarDatos("http://unisatelite.com/Movies/borrarRenta.php",datosRenta);
        this.rentas = getRentas();
    }

    public void actualizarRenta(Renta renta){
        HashMap<String,String> datosRenta = new HashMap<>();
        datosRenta.put("id_renta",renta.getIdPelicula());
        datosRenta.put("fecha_inicio",renta.getTitulo());
        datosRenta.put("fecha_entrega", renta.getDirector());
        datosRenta.put("dias_extendidos",Float.toString(renta.getCalificacion()));
        datosRenta.put("id_recibo", Integer.toString(renta.getDuracion()));
        datosRenta.put("id_cliente",renta.getGenero());
        datosRenta.put("id_copia", renta.getElenco());
        crud.insertarDatos("http://unisatelite.com/Movies/actualizarRenta.php",datosRenta);
        this.rentas = getRentas();
    }
}
