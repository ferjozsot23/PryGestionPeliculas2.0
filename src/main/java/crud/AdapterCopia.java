package crud;

import gestorPelicula.Copia;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class AdapterCopia {
    private EnvioRecepcion crud = EnvioRecepcion.obtenerInstancia();
    private HashMap<String, ArrayList<String>> copias;

    public HashMap getCopias(){
        ArrayList arrayCopias = null;
        try {
            arrayCopias = crud.getDatos("http://unisatelite.com/Movies/leerCopia.php");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        Map mapCopias = new HashMap();
        for(Object copia: arrayCopias){
            ArrayList<String> datosCopia = new ArrayList<>();
            ((HashMap<String,String>)copia).forEach((key,value)->{
                datosCopia.add(value);
            });
            mapCopias.put(((HashMap<String,String>)copia).get("id_copia"),datosCopia);
        }
        //this.peliculas = (HashMap) mapCopias;
        return (HashMap) mapCopias;
    }

    public ArrayList getCopia(String idCopia){
        //HashMap mapPeliculas = getPeliculas()
        if(this.copias == null){
            this.copias = getCopias();
        }
        return (ArrayList) this.copias.get(idCopia);
    }

    public void insertCopia(Copia copia){
        HashMap<String,String> datosCopia = new HashMap<>();
        datosCopia.put("disponible", Boolean.toString(copia.isDisponible()));
        crud.insertarDatos("http://unisatelite.com/Movies/insertarCopia.php", datosCopia);
        this.copias = getCopias();
        System.out.println(this.copias.toString());
    }

    public void eliminarCopia(String idCopia){
        HashMap<String,String> datosCopia = new HashMap<>();
        datosCopia.put("id_copia",idCopia);
        crud.insertarDatos("http://unisatelite.com/Movies/borrarCopia.php",datosCopia);
        this.copias = getCopias();
    }

    public void actualizarCopia(Copia copia){
        HashMap<String,String> datosCopia = new HashMap<>();
        datosCopia.put("id_copia",copia.getIdCopia());
        datosCopia.put("disponible",Boolean.toString(copia.isDisponible()));
        crud.insertarDatos("http://unisatelite.com/Movies/actualizarCopia.php",datosCopia);
        this.copias = getCopias();
    }

    public void insertarCopias(int numeroCopias, String idPelicula){
        for(int i=0; i<numeroCopias; i++ ){
            HashMap<String,String> datosCopia = new HashMap<>();
            datosCopia.put("disponible","true");
            datosCopia.put("id_pelicula",idPelicula);
            crud.insertarDatos("http://unisatelite.com/Movies/insertarCopia.php",datosCopia);
        }
        this.copias = getCopias();
    }
}
