package crud;

import gestorPelicula.Pelicula;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Adapter {
    private Crud crud = new Crud();

    public HashMap getPeliculas(){
        ArrayList arrayPeliculas = null;
        try {
            arrayPeliculas = crud.getDatos("http://unisatelite.com/Movies/getPelicula.php");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        Map mapPeliculas = new HashMap();
        for(Object pelicula: arrayPeliculas){
            ArrayList<String> datosPelicula = new ArrayList<>();
            ((HashMap<String,String>)pelicula).forEach((key,value)->{
                datosPelicula.add(value);
            });
            mapPeliculas.put(((HashMap<String,String>)pelicula).get("id_pelicula"),datosPelicula);
        }
        return (HashMap) mapPeliculas;
    }

    public ArrayList getPelicula(String idPelicula){
        HashMap mapPeliculas = getPeliculas();
        return (ArrayList) mapPeliculas.get(idPelicula);
    }

    public void insertPelicula(Pelicula pelicula){
        HashMap<String,String> datosPelicula = new HashMap<>();
        datosPelicula.put("titulo",pelicula.getTitulo());
        datosPelicula.put("director", pelicula.getDirector());
        datosPelicula.put("calificacion",Float.toString(pelicula.getCalificacion()));
        datosPelicula.put("duracion", Integer.toString(pelicula.getDuracion()));
        crud.insertarDatos("http://unisatelite.com/Movies/insertarPelicula.php",datosPelicula);
    }




}
