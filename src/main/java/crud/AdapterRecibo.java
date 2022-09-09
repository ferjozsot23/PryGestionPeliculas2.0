package crud;

import gestorPago.Recibo;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class AdapterRecibo {
    private EnvioRecepcion crud = EnvioRecepcion.obtenerInstancia();
    private HashMap<String, ArrayList<String>> recibos;

    public HashMap getRecibos(){
        ArrayList arrayRecibos = null;
        try {
            arrayRecibos = crud.getDatos("http://unisatelite.com/Movies/leerRecibo.php");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        Map mapRecibos = new HashMap();
        for(Object recibo: arrayRecibos){
            ArrayList<String> datosRecibo = new ArrayList<>();
            ((HashMap<String,String>)recibo).forEach((key,value)->{
                datosRecibo.add(value);
            });
            mapRecibos.put(((HashMap<String,String>)recibo).get("id_recibo"),datosRecibo);
        }
        //this.peliculas = (HashMap) mapRecibos;
        return (HashMap) mapRecibos;
    }

    public ArrayList getRecibo(String idRecibo){
        //HashMap mapPeliculas = getPeliculas()
        if(this.recibos == null){
            this.recibos = getRecibos();
        }
        return (ArrayList) this.recibos.get(idRecibo);
    }

    public void insertRecibo(Recibo recibo){
        HashMap<String,String> datosRecibo = new HashMap<>();
        datosRecibo.put("fecha", recibo.getFecha());
        datosRecibo.put("monto", Float.toString(recibo.getMonto()));
        datosRecibo.put("detalles", recibo.getDetalles());
        datosRecibo.put("multa", Float.toString(recibo.getMulta()));
        crud.insertarDatos("http://unisatelite.com/Movies/insertarRecibo.php", datosRecibo);
        this.recibos = getRecibos();
        System.out.println(this.recibos.toString());
    }

    public void eliminarRecibo(String idRecibo){
        HashMap<String,String> datosRecibo = new HashMap<>();
        datosRecibo.put("id_recibo",idRecibo);
        crud.insertarDatos("http://unisatelite.com/Movies/borrarRecibo.php",datosRecibo);
        this.recibos = getRecibos();
    }

    public void actualizarRecibo(Recibo recibo){
        HashMap<String,String> datosRecibo = new HashMap<>();
        datosRecibo.put("id_recibo",Integer.toString(recibo.getId_recibo()));
        datosRecibo.put("fecha", recibo.getFecha());
        datosRecibo.put("monto", Float.toString(recibo.getMonto()));
        datosRecibo.put("detalles", recibo.getDetalles());
        datosRecibo.put("multa", Float.toString(recibo.getMulta()));
        crud.insertarDatos("http://unisatelite.com/Movies/actualizarRecibo.php",datosRecibo);
        this.recibos = getRecibos();
    }
}
